package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;

public class LookupFilter
  extends MultiTextureFilter
{
  private static final String FRAGMENT_SHADER = "sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\nuniform lowp float uAlpha;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = mix(vec4(0,0,0,1), newColor, uAlpha);\n}";
  private static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D  ";
  private static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
  private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  public float intensity = 1.0F;
  private int intensityHandle;
  public Bitmap lookupBitmap;
  public String lookupBitmapPath;
  private int lookupTextureID = -1;
  private int sLookupTextureHandle;
  
  public LookupFilter(Bitmap paramBitmap)
  {
    this(paramBitmap, 1.0F);
  }
  
  public LookupFilter(Bitmap paramBitmap, float paramFloat)
  {
    this.lookupBitmap = paramBitmap;
    this.intensity = paramFloat;
  }
  
  public MultiTextureFilter clone()
  {
    AppMethodBeat.i(201561);
    LookupFilter localLookupFilter = new LookupFilter(this.lookupBitmap, this.intensity);
    if (this.subFilter != null) {
      localLookupFilter.setSubFilter(this.subFilter.clone());
    }
    AppMethodBeat.o(201561);
    return localLookupFilter;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201562);
    if (paramObject == this)
    {
      AppMethodBeat.o(201562);
      return true;
    }
    if (paramObject.getClass() != getClass())
    {
      AppMethodBeat.o(201562);
      return false;
    }
    if (this.intensity != ((LookupFilter)paramObject).intensity)
    {
      AppMethodBeat.o(201562);
      return false;
    }
    if (this.lookupBitmap != ((LookupFilter)paramObject).lookupBitmap)
    {
      AppMethodBeat.o(201562);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(201562);
    return bool;
  }
  
  protected void finishDraw(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(201559);
    super.finishDraw(paramTextureInfo);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(201559);
  }
  
  protected void initShaderForTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(201557);
    if (paramTextureInfo.textureType == 36197) {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\nuniform lowp float uAlpha;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = mix(vec4(0,0,0,1), newColor, uAlpha);\n}");
    }
    for (;;)
    {
      this.sLookupTextureHandle = GLES20.glGetUniformLocation(this.program, "sLookupTexture");
      RenderContext.checkEglError("glGetUniformLocation sLookupTexture");
      if (this.sLookupTextureHandle != -1) {
        break;
      }
      paramTextureInfo = new RuntimeException("Could not get uniform location for sLookupTexture");
      AppMethodBeat.o(201557);
      throw paramTextureInfo;
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "uniform sampler2D  sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\nuniform lowp float uAlpha;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = mix(vec4(0,0,0,1), newColor, uAlpha);\n}");
    }
    this.intensityHandle = GLES20.glGetUniformLocation(this.program, "intensity");
    RenderContext.checkEglError("glGetUniformLocation intensity");
    if (this.intensityHandle == -1)
    {
      paramTextureInfo = new RuntimeException("Could not get uniform location for intensity");
      AppMethodBeat.o(201557);
      throw paramTextureInfo;
    }
    if (this.lookupTextureID == -1)
    {
      paramTextureInfo = new int[1];
      GLES20.glGenTextures(1, paramTextureInfo, 0);
      int i = paramTextureInfo[0];
      GLES20.glBindTexture(3553, i);
      RenderContext.checkEglError("glBindTexture mTextureID");
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      RenderContext.checkEglError("glTexParameter");
      GLES20.glTexImage2D(3553, 0, 6407, getRendererWidth(), getRendererHeight(), 0, 6407, 5121, null);
      GLUtils.texImage2D(3553, 0, this.lookupBitmap, 0);
      this.lookupTextureID = i;
    }
    AppMethodBeat.o(201557);
  }
  
  protected void prepareDraw(TextureInfo paramTextureInfo, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(201558);
    super.prepareDraw(paramTextureInfo, paramArrayOfFloat);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.lookupTextureID);
    GLES20.glUniform1i(this.sLookupTextureHandle, 1);
    GLES20.glUniform1f(this.intensityHandle, this.intensity);
    AppMethodBeat.o(201558);
  }
  
  public void release()
  {
    AppMethodBeat.i(201560);
    super.release();
    if (this.lookupTextureID != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.lookupTextureID }, 0);
      this.lookupTextureID = -1;
    }
    AppMethodBeat.o(201560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.LookupFilter
 * JD-Core Version:    0.7.0.1
 */