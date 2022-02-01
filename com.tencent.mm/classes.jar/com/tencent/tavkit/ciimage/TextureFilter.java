package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.Utils;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class TextureFilter
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "#version 300 es\nuniform sampler2D sTexture;\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform float uAlpha;\nuniform int uIsCrop;\nuniform vec4 uCropRect;\nout vec4 outColor;\nvoid main() {\n  vec4 color;\n  if(uIsCrop == 1) {\n    ivec2 size = textureSize(sTexture, 0);\n    float cropWidth = uCropRect.z - uCropRect.x;\n    float cropHeight = uCropRect.w - uCropRect.y;\n    float sizeWidth = float(size.x);\n    float sizeHeight = float(size.y);\n    float pointX = vTextureCoord.x;\n    float pointY = vTextureCoord.y;\n    if(cropWidth <= sizeWidth) {\n        pointX = vTextureCoord.x * cropWidth / sizeWidth + (uCropRect.x / sizeWidth);\n    }\n    if(cropHeight <= sizeHeight) {\n        pointY = vTextureCoord.y * cropHeight / sizeHeight + (uCropRect.y / sizeHeight);\n    }\n    vec2 point = vec2(pointX, pointY);\n    color = texture(sTexture, point);\n  } else {\n    color = texture(sTexture, vTextureCoord);\n  }\n  outColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_2 = "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_END = "precision mediump float;\nin vec2 vTextureCoord;\nuniform float uAlpha;\nuniform int uIsCrop;\nuniform vec4 uCropRect;\nout vec4 outColor;\nvoid main() {\n  vec4 color;\n  if(uIsCrop == 1) {\n    ivec2 size = textureSize(sTexture, 0);\n    float cropWidth = uCropRect.z - uCropRect.x;\n    float cropHeight = uCropRect.w - uCropRect.y;\n    float sizeWidth = float(size.x);\n    float sizeHeight = float(size.y);\n    float pointX = vTextureCoord.x;\n    float pointY = vTextureCoord.y;\n    if(cropWidth <= sizeWidth) {\n        pointX = vTextureCoord.x * cropWidth / sizeWidth + (uCropRect.x / sizeWidth);\n    }\n    if(cropHeight <= sizeHeight) {\n        pointY = vTextureCoord.y * cropHeight / sizeHeight + (uCropRect.y / sizeHeight);\n    }\n    vec2 point = vec2(pointX, pointY);\n    color = texture(sTexture, point);\n  } else {\n    color = texture(sTexture, vTextureCoord);\n  }\n  outColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_END_2 = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_OES = "#version 300 es\n#extension GL_OES_EGL_image_external : require\n#extension GL_OES_EGL_image_external_essl3 : enable\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform float uAlpha;\nuniform int uIsCrop;\nuniform vec4 uCropRect;\nout vec4 outColor;\nvoid main() {\n  vec4 color;\n  if(uIsCrop == 1) {\n    ivec2 size = textureSize(sTexture, 0);\n    float cropWidth = uCropRect.z - uCropRect.x;\n    float cropHeight = uCropRect.w - uCropRect.y;\n    float sizeWidth = float(size.x);\n    float sizeHeight = float(size.y);\n    float pointX = vTextureCoord.x;\n    float pointY = vTextureCoord.y;\n    if(cropWidth <= sizeWidth) {\n        pointX = vTextureCoord.x * cropWidth / sizeWidth + (uCropRect.x / sizeWidth);\n    }\n    if(cropHeight <= sizeHeight) {\n        pointY = vTextureCoord.y * cropHeight / sizeHeight + (uCropRect.y / sizeHeight);\n    }\n    vec2 point = vec2(pointX, pointY);\n    color = texture(sTexture, point);\n  } else {\n    color = texture(sTexture, vTextureCoord);\n  }\n  outColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_OES_2 = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  private static final String VERTEX_SHADER = "#version 300 es\nuniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nin vec2 aPosition;\nout vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private static final String VERTEX_SHADER_2 = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private final String TAG;
  private int aPositionHandle;
  private GLBlendStateCache glBlendStateCache;
  private int outputFrameBufferId;
  private TextureInfo outputTextureInfo;
  protected int program;
  private int rendererHeight;
  private int rendererWidth;
  private final int[] shaderIndexes;
  private int stMatrixHandle;
  private FloatBuffer triangleVertices;
  private int uAlphaHandle;
  private int uCropHandle;
  private int uCropRectHandle;
  private int uMatrixHandle;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  public TextureFilter()
  {
    AppMethodBeat.i(218600);
    this.TAG = ("TextureFilter@" + Integer.toHexString(hashCode()));
    this.uCropHandle = -1;
    this.uCropRectHandle = -1;
    this.shaderIndexes = new int[2];
    this.outputTextureInfo = null;
    this.outputFrameBufferId = -1;
    Logger.d(this.TAG, "TextureFilter() called");
    AppMethodBeat.o(218600);
  }
  
  private void checkAndInitFrameBuffer(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218614);
    int j = paramTextureInfo.getFrameBuffer();
    int i = j;
    if (j == -1)
    {
      GLES20.glBindTexture(3553, paramTextureInfo.textureID);
      GLES20.glTexImage2D(3553, 0, paramTextureInfo.getFormat(), paramTextureInfo.width, paramTextureInfo.height, 0, paramTextureInfo.getFormat(), 5121, null);
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
      GLES20.glBindFramebuffer(36160, i);
      RenderContext.checkEglError("glBindFramebuffer outputFrameBufferId");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
      RenderContext.checkEglError("glCheckFramebufferStatus outputFrameBufferId");
      if (GLES20.glCheckFramebufferStatus(36160) != 36053)
      {
        new RuntimeException("EGL error encountered: FramebufferStatus is not complete.");
        AppMethodBeat.o(218614);
        return;
      }
      GLES20.glBindFramebuffer(36160, 0);
    }
    this.outputFrameBufferId = i;
    paramTextureInfo.setFrameBuffer(i);
    this.outputTextureInfo = paramTextureInfo;
    AppMethodBeat.o(218614);
  }
  
  private void finishDraw(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218643);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, 0);
    AppMethodBeat.o(218643);
  }
  
  private void initShaderForTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218622);
    int i;
    if ((paramTextureInfo.getTextureRect() == null) || (Utils.isOnlySupportLowVersionGl())) {
      i = 1;
    }
    while (paramTextureInfo.textureType == 36197) {
      if (i != 0)
      {
        initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n", true);
        AppMethodBeat.o(218622);
        return;
        i = 0;
      }
      else
      {
        initShaders("#version 300 es\nuniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nin vec2 aPosition;\nout vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#version 300 es\n#extension GL_OES_EGL_image_external : require\n#extension GL_OES_EGL_image_external_essl3 : enable\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform float uAlpha;\nuniform int uIsCrop;\nuniform vec4 uCropRect;\nout vec4 outColor;\nvoid main() {\n  vec4 color;\n  if(uIsCrop == 1) {\n    ivec2 size = textureSize(sTexture, 0);\n    float cropWidth = uCropRect.z - uCropRect.x;\n    float cropHeight = uCropRect.w - uCropRect.y;\n    float sizeWidth = float(size.x);\n    float sizeHeight = float(size.y);\n    float pointX = vTextureCoord.x;\n    float pointY = vTextureCoord.y;\n    if(cropWidth <= sizeWidth) {\n        pointX = vTextureCoord.x * cropWidth / sizeWidth + (uCropRect.x / sizeWidth);\n    }\n    if(cropHeight <= sizeHeight) {\n        pointY = vTextureCoord.y * cropHeight / sizeHeight + (uCropRect.y / sizeHeight);\n    }\n    vec2 point = vec2(pointX, pointY);\n    color = texture(sTexture, point);\n  } else {\n    color = texture(sTexture, vTextureCoord);\n  }\n  outColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n", false);
        AppMethodBeat.o(218622);
        return;
      }
    }
    if (i != 0)
    {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n", true);
      AppMethodBeat.o(218622);
      return;
    }
    initShaders("#version 300 es\nuniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nin vec2 aPosition;\nout vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#version 300 es\nuniform sampler2D sTexture;\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform float uAlpha;\nuniform int uIsCrop;\nuniform vec4 uCropRect;\nout vec4 outColor;\nvoid main() {\n  vec4 color;\n  if(uIsCrop == 1) {\n    ivec2 size = textureSize(sTexture, 0);\n    float cropWidth = uCropRect.z - uCropRect.x;\n    float cropHeight = uCropRect.w - uCropRect.y;\n    float sizeWidth = float(size.x);\n    float sizeHeight = float(size.y);\n    float pointX = vTextureCoord.x;\n    float pointY = vTextureCoord.y;\n    if(cropWidth <= sizeWidth) {\n        pointX = vTextureCoord.x * cropWidth / sizeWidth + (uCropRect.x / sizeWidth);\n    }\n    if(cropHeight <= sizeHeight) {\n        pointY = vTextureCoord.y * cropHeight / sizeHeight + (uCropRect.y / sizeHeight);\n    }\n    vec2 point = vec2(pointX, pointY);\n    color = texture(sTexture, point);\n  } else {\n    color = texture(sTexture, vTextureCoord);\n  }\n  outColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n", false);
    AppMethodBeat.o(218622);
  }
  
  private void initShaders(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(218630);
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.program = Program.createProgram(paramString1, paramString2, this.shaderIndexes);
    if (this.program == 0)
    {
      new RuntimeException("failed creating program");
      AppMethodBeat.o(218630);
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
    RenderContext.checkEglError("glGetAttribLocation aPosition");
    if (this.aPositionHandle == -1)
    {
      new RuntimeException("Could not get attribute location for aPosition");
      AppMethodBeat.o(218630);
      return;
    }
    this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
    RenderContext.checkEglError("glGetUniformLocation uMatrix");
    if (this.uMatrixHandle == -1)
    {
      new RuntimeException("Could not get uniform location for uMatrix");
      AppMethodBeat.o(218630);
      return;
    }
    this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
    RenderContext.checkEglError("glGetUniformLocation uAlpha");
    if (this.uAlphaHandle == -1)
    {
      new RuntimeException("Could not get uniform location for uAlpha");
      AppMethodBeat.o(218630);
      return;
    }
    if (!paramBoolean)
    {
      this.uCropHandle = GLES20.glGetUniformLocation(this.program, "uIsCrop");
      RenderContext.checkEglError("glGetUniformLocation uCropHandle");
      if (this.uCropHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uCropHandle");
        AppMethodBeat.o(218630);
        return;
      }
      this.uCropRectHandle = GLES20.glGetUniformLocation(this.program, "uCropRect");
      RenderContext.checkEglError("glGetUniformLocation uCropRectHandle");
      if (this.uCropRectHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uCropRectHandle");
        AppMethodBeat.o(218630);
        return;
      }
    }
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    RenderContext.checkEglError("glGetUniformLocation stMatrix");
    if (this.stMatrixHandle == -1)
    {
      new RuntimeException("Could not get uniform location for stMatrix");
      AppMethodBeat.o(218630);
      return;
    }
    this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
    RenderContext.checkEglError("glGetUniformLocation uScreenSize");
    if (this.uScreenSizeHandle == -1)
    {
      new RuntimeException("Could not get uniform location for uScreenSize");
      AppMethodBeat.o(218630);
      return;
    }
    this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
    RenderContext.checkEglError("glGetUniformLocation uTextureSize");
    if (this.uTextureSizeHandle == -1) {
      new RuntimeException("Could not get uniform location for uTextureSize");
    }
    AppMethodBeat.o(218630);
  }
  
  private boolean isEqualsCurrentOutputTexture(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218609);
    if (this.outputTextureInfo == null)
    {
      AppMethodBeat.o(218609);
      return false;
    }
    if (this.outputTextureInfo.equals(paramTextureInfo))
    {
      AppMethodBeat.o(218609);
      return true;
    }
    if ((this.outputTextureInfo.textureID == paramTextureInfo.textureID) && (this.outputTextureInfo.width == paramTextureInfo.width) && (this.outputTextureInfo.height == paramTextureInfo.height))
    {
      AppMethodBeat.o(218609);
      return true;
    }
    AppMethodBeat.o(218609);
    return false;
  }
  
  private void prepareDraw(TextureInfo paramTextureInfo, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(218640);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, paramTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    RenderContext.checkEglError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    RenderContext.checkEglError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glUniformMatrix3fv(this.uMatrixHandle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTextureInfo.width, paramTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
    AppMethodBeat.o(218640);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(218658);
    if (paramTextureInfo == null)
    {
      AppMethodBeat.o(218658);
      return null;
    }
    if (this.glBlendStateCache == null) {
      this.glBlendStateCache = new GLBlendStateCache();
    }
    this.glBlendStateCache.cache();
    if (this.program == 0) {
      initShaderForTextureInfo(paramTextureInfo);
    }
    RenderContext.checkEglError("onDrawFrame start");
    if (paramCGRect == null)
    {
      paramCGRect = new CGRect(0.0F, 0.0F, paramTextureInfo.width, paramTextureInfo.height);
      float f2 = paramCGRect.origin.x + paramCGRect.size.width;
      float f1 = f2;
      if (f2 > paramTextureInfo.width)
      {
        f1 = paramTextureInfo.width;
        Logger.e(this.TAG, "applyFilter: crop right pixel exceed texture width");
      }
      float f3 = paramCGRect.origin.y + paramCGRect.size.height;
      f2 = f3;
      if (f3 > paramTextureInfo.height)
      {
        f2 = paramTextureInfo.height;
        Logger.e(this.TAG, "applyFilter: crop bottom pixel exceed texture height");
      }
      f3 = paramCGRect.origin.x;
      float f4 = paramCGRect.origin.x;
      float f5 = paramCGRect.origin.y;
      float f6 = paramCGRect.origin.y;
      this.triangleVertices.rewind();
      this.triangleVertices.put(new float[] { f3, f2, f4, f5, f1, f2, f1, f6 });
      paramCGRect = new int[4];
      GLES20.glGetIntegerv(2978, paramCGRect, 0);
      if (this.outputFrameBufferId != -1)
      {
        GLES20.glBindFramebuffer(36160, this.outputFrameBufferId);
        GLES20.glGetIntegerv(2978, paramCGRect, 0);
        GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
      }
      GLES20.glUseProgram(this.program);
      RenderContext.checkEglError("glUseProgram");
      GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(paramMatrix2), 0);
      GLES20.glUniform1f(this.uAlphaHandle, paramFloat);
      paramMatrix2 = paramTextureInfo.getTextureRect();
      if ((paramMatrix2 != null) && (paramMatrix2.right > paramMatrix2.left) && (paramMatrix2.bottom > paramMatrix2.top))
      {
        GLES20.glUniform1i(this.uCropHandle, 1);
        GLES20.glUniform4f(this.uCropRectHandle, paramMatrix2.left, paramMatrix2.top, paramMatrix2.right, paramMatrix2.bottom);
      }
      GLES20.glEnable(3042);
      if (paramTextureInfo.isMixAlpha()) {
        break label609;
      }
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(1, 771, 1, 771);
    }
    for (;;)
    {
      prepareDraw(paramTextureInfo, DecoderUtils.toOpenGL2DMatrix(paramMatrix1));
      GLES20.glDrawArrays(5, 0, 4);
      RenderContext.checkEglError("glDrawArrays");
      finishDraw(paramTextureInfo);
      if (this.outputFrameBufferId != -1)
      {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(paramCGRect[0], paramCGRect[1], paramCGRect[2], paramCGRect[3]);
      }
      this.glBlendStateCache.restore();
      paramTextureInfo = this.outputTextureInfo;
      AppMethodBeat.o(218658);
      return paramTextureInfo;
      paramCGRect.size.width = Math.min(paramTextureInfo.width, paramCGRect.size.width);
      paramCGRect.size.height = Math.min(paramTextureInfo.height, paramCGRect.size.height);
      break;
      label609:
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(770, 771, 1, 771);
    }
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    AppMethodBeat.i(218668);
    clearBufferBuffer(paramInt, 0.0F);
    AppMethodBeat.o(218668);
  }
  
  public void clearBufferBuffer(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(218675);
    if (this.outputFrameBufferId != -1)
    {
      GLES20.glBindFramebuffer(36160, this.outputFrameBufferId);
      GLES20.glClearColor(((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, (paramInt & 0xFF) / 255.0F, paramFloat);
      GLES20.glClear(16384);
    }
    AppMethodBeat.o(218675);
  }
  
  public void release()
  {
    AppMethodBeat.i(218682);
    Logger.d(this.TAG, "release: start, thread = " + Thread.currentThread().getName() + ", egl = " + EGL14.eglGetCurrentContext());
    if (this.outputTextureInfo != null)
    {
      GLES20.glDeleteTextures(1, new int[] { this.outputTextureInfo.textureID }, 0);
      this.outputTextureInfo = null;
    }
    if (this.outputFrameBufferId != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.outputFrameBufferId }, 0);
      this.outputFrameBufferId = -1;
    }
    if (this.program > 0)
    {
      GLES20.glDeleteProgram(this.program);
      this.program = 0;
    }
    int i = 0;
    while (i < this.shaderIndexes.length)
    {
      if (this.shaderIndexes[i] > 0)
      {
        GLES20.glDeleteShader(this.shaderIndexes[i]);
        this.shaderIndexes[i] = 0;
      }
      i += 1;
    }
    Logger.d(this.TAG, "release: end");
    AppMethodBeat.o(218682);
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218650);
    if (paramTextureInfo == null)
    {
      paramTextureInfo = new RuntimeException("outputTextureInfo 为空");
      AppMethodBeat.o(218650);
      throw paramTextureInfo;
    }
    if (paramTextureInfo.isReleased())
    {
      paramTextureInfo = new RuntimeException("outputTextureInfo 已经被释放了");
      AppMethodBeat.o(218650);
      throw paramTextureInfo;
    }
    if (paramTextureInfo.textureType != 3553)
    {
      paramTextureInfo = new RuntimeException("目标纹理类型需要GLES20.GL_TEXTURE_2D");
      AppMethodBeat.o(218650);
      throw paramTextureInfo;
    }
    this.rendererWidth = paramTextureInfo.width;
    this.rendererHeight = paramTextureInfo.height;
    if (!isEqualsCurrentOutputTexture(paramTextureInfo)) {
      checkAndInitFrameBuffer(paramTextureInfo);
    }
    AppMethodBeat.o(218650);
  }
  
  public String toString()
  {
    AppMethodBeat.i(218691);
    String str = "TextureFilter{program=" + this.program + ", rendererWidth=" + this.rendererWidth + ", rendererHeight=" + this.rendererHeight + ", outputTextureInfo=" + this.outputTextureInfo + ", outputFrameBufferId=" + this.outputFrameBufferId + '}';
    AppMethodBeat.o(218691);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TextureFilter
 * JD-Core Version:    0.7.0.1
 */