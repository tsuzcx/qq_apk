package com.tencent.tav.decoder.decodecache;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Program;
import com.tencent.tav.decoder.RenderContext;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class CopyFilter
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String TAG = "MultiTextureFilter";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private TextureInfo _textureInfo;
  private int aPositionHandle;
  private int[] defaultViewport;
  private int frameBuffer;
  protected int program;
  private boolean renderForScreen;
  private int rendererHeight;
  private int rendererWidth;
  private final int[] shaderIndexes;
  private int stMatrixHandle;
  private FloatBuffer triangleVertices;
  private int uAlphaHandle;
  private int uMatrixHandle;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  public CopyFilter()
  {
    AppMethodBeat.i(215071);
    this.renderForScreen = false;
    this.shaderIndexes = new int[2];
    this._textureInfo = null;
    this.frameBuffer = -1;
    this.defaultViewport = new int[4];
    AppMethodBeat.o(215071);
  }
  
  private void initFrameBuffer(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215073);
    if (paramTextureInfo.textureType != 3553)
    {
      paramTextureInfo = new RuntimeException("纹理类型不可为OES");
      AppMethodBeat.o(215073);
      throw paramTextureInfo;
    }
    GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
    this._textureInfo = paramTextureInfo;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, i);
    RenderContext.checkEglError("glBindFramebuffer frameBuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
    RenderContext.checkEglError("glCheckFramebufferStatus frameBuffer");
    if (GLES20.glCheckFramebufferStatus(36160) != 36053)
    {
      new RuntimeException("EGL error encountered: FramebufferStatus is not complete.");
      AppMethodBeat.o(215073);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    this.frameBuffer = i;
    paramTextureInfo.setFrameBuffer(i);
    AppMethodBeat.o(215073);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215076);
    paramTextureInfo = applyFilter(paramTextureInfo, null);
    AppMethodBeat.o(215076);
    return paramTextureInfo;
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix)
  {
    AppMethodBeat.i(215077);
    if ((!this.renderForScreen) && (this.frameBuffer == -1)) {
      initFrameBuffer(this._textureInfo);
    }
    if (this.program == 0) {
      initShaderForTextureInfo(paramTextureInfo);
    }
    RenderContext.checkEglError("onDrawFrame start");
    CGRect localCGRect = new CGRect(0.0F, 0.0F, paramTextureInfo.width, paramTextureInfo.height);
    float f2 = localCGRect.origin.x + localCGRect.size.width;
    float f1 = f2;
    if (f2 > paramTextureInfo.width) {
      f1 = paramTextureInfo.width;
    }
    float f3 = localCGRect.origin.y + localCGRect.size.height;
    f2 = f3;
    if (f3 > paramTextureInfo.height) {
      f2 = paramTextureInfo.height;
    }
    f3 = localCGRect.origin.x;
    float f4 = localCGRect.origin.x;
    float f5 = localCGRect.origin.y;
    float f6 = localCGRect.origin.y;
    this.triangleVertices.rewind();
    this.triangleVertices.put(new float[] { f3, f2, f4, f5, f1, f2, f1, f6 });
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    if (this.frameBuffer != -1)
    {
      GLES20.glBindFramebuffer(36160, this.frameBuffer);
      GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
    }
    GLES20.glUseProgram(this.program);
    RenderContext.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(paramMatrix), 0);
    GLES20.glUniform1f(this.uAlphaHandle, 1.0F);
    prepareDraw(paramTextureInfo, DecoderUtils.toOpenGL2DMatrix(null));
    GLES20.glDrawArrays(5, 0, 4);
    RenderContext.checkEglError("glDrawArrays");
    finishDraw(paramTextureInfo);
    if (this.frameBuffer != -1)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
    }
    if (!this.renderForScreen)
    {
      paramTextureInfo = this._textureInfo;
      AppMethodBeat.o(215077);
      return paramTextureInfo;
    }
    AppMethodBeat.o(215077);
    return null;
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    AppMethodBeat.i(215075);
    if (this.frameBuffer != -1)
    {
      GLES20.glBindFramebuffer(36160, this.frameBuffer);
      GLES20.glClearColor(((0xFF0000 & paramInt) >> 16) / 255.0F, ((0xFF00 & paramInt) >> 8) / 255.0F, (paramInt & 0xFF) / 255.0F, 1.0F);
      GLES20.glClear(16384);
    }
    AppMethodBeat.o(215075);
  }
  
  protected void finishDraw(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215080);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, 0);
    AppMethodBeat.o(215080);
  }
  
  public int getRendererHeight()
  {
    return this.rendererHeight;
  }
  
  public int getRendererWidth()
  {
    return this.rendererWidth;
  }
  
  protected void initShaderForTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215078);
    if (paramTextureInfo.textureType == 36197)
    {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
      AppMethodBeat.o(215078);
      return;
    }
    initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
    AppMethodBeat.o(215078);
  }
  
  protected void initShaders(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215072);
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.program = Program.createProgram(paramString1, paramString2, this.shaderIndexes);
    if (this.program == 0)
    {
      new RuntimeException("failed creating program");
      AppMethodBeat.o(215072);
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
    RenderContext.checkEglError("glGetAttribLocation aPosition");
    if (this.aPositionHandle == -1)
    {
      new RuntimeException("Could not get attribute location for aPosition");
      AppMethodBeat.o(215072);
      return;
    }
    this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
    RenderContext.checkEglError("glGetUniformLocation uMatrix");
    if (this.uMatrixHandle == -1)
    {
      new RuntimeException("Could not get uniform location for uMatrix");
      AppMethodBeat.o(215072);
      return;
    }
    this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
    RenderContext.checkEglError("glGetUniformLocation uAlpha");
    if (this.uAlphaHandle == -1)
    {
      new RuntimeException("Could not get uniform location for uAlpha");
      AppMethodBeat.o(215072);
      return;
    }
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    RenderContext.checkEglError("glGetUniformLocation stMatrix");
    if (this.stMatrixHandle == -1)
    {
      new RuntimeException("Could not get uniform location for stMatrix");
      AppMethodBeat.o(215072);
      return;
    }
    this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
    RenderContext.checkEglError("glGetUniformLocation uScreenSize");
    if (this.uScreenSizeHandle == -1)
    {
      new RuntimeException("Could not get uniform location for uScreenSize");
      AppMethodBeat.o(215072);
      return;
    }
    this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
    RenderContext.checkEglError("glGetUniformLocation uTextureSize");
    if (this.uTextureSizeHandle == -1) {
      new RuntimeException("Could not get uniform location for uTextureSize");
    }
    AppMethodBeat.o(215072);
  }
  
  protected void prepareDraw(TextureInfo paramTextureInfo, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(215079);
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
    AppMethodBeat.o(215079);
  }
  
  public void release()
  {
    AppMethodBeat.i(215083);
    releaseTexture();
    releaseProgram();
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
    AppMethodBeat.o(215083);
  }
  
  public void releaseProgram()
  {
    AppMethodBeat.i(215081);
    if (this.program > 0)
    {
      GLES20.glDeleteProgram(this.program);
      this.program = 0;
    }
    AppMethodBeat.o(215081);
  }
  
  public void releaseTexture()
  {
    AppMethodBeat.i(215082);
    if (this.frameBuffer != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.frameBuffer }, 0);
      this.frameBuffer = -1;
    }
    if (this._textureInfo != null)
    {
      GLES20.glDeleteTextures(1, new int[] { this._textureInfo.textureID }, 0);
      this._textureInfo = null;
    }
    AppMethodBeat.o(215082);
  }
  
  public void setDesTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215074);
    if (paramTextureInfo.getFrameBuffer() == -1) {
      initFrameBuffer(paramTextureInfo);
    }
    for (;;)
    {
      this._textureInfo = paramTextureInfo;
      AppMethodBeat.o(215074);
      return;
      this.frameBuffer = paramTextureInfo.getFrameBuffer();
    }
  }
  
  public void setRenderForScreen(boolean paramBoolean)
  {
    this.renderForScreen = paramBoolean;
  }
  
  public void setRendererHeight(int paramInt)
  {
    this.rendererHeight = paramInt;
  }
  
  public void setRendererWidth(int paramInt)
  {
    this.rendererWidth = paramInt;
  }
  
  public TextureInfo textureInfo()
  {
    return this._textureInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CopyFilter
 * JD-Core Version:    0.7.0.1
 */