package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class Texture2dProgram
{
  private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
  private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
  public static final int KERNEL_SIZE = 9;
  private static final String TAG = GlUtil.TAG;
  private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
  private float mColorAdjust;
  private float[] mKernel = new float[9];
  private int mProgramHandle;
  private Texture2dProgram.ProgramType mProgramType;
  private float[] mTexOffset;
  private int mTextureTarget;
  private int maPositionLoc;
  private int maTextureCoordLoc;
  private int muColorAdjustLoc;
  private int muKernelLoc;
  private int muMVPMatrixLoc;
  private int muTexMatrixLoc;
  private int muTexOffsetLoc;
  
  public Texture2dProgram(Texture2dProgram.ProgramType paramProgramType)
  {
    this.mProgramType = paramProgramType;
    switch (Texture2dProgram.1.$SwitchMap$com$tencent$ttpic$gles$Texture2dProgram$ProgramType[paramProgramType.ordinal()])
    {
    default: 
      throw new RuntimeException("Unhandled type " + paramProgramType);
    case 1: 
      this.mTextureTarget = 3553;
      this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    }
    while (this.mProgramHandle == 0)
    {
      throw new RuntimeException("Unable to create program");
      this.mTextureTarget = 36197;
      this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
      continue;
      this.mTextureTarget = 36197;
      this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
      continue;
      this.mTextureTarget = 36197;
      this.mProgramHandle = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n");
    }
    new StringBuilder("Created program ").append(this.mProgramHandle).append(" (").append(paramProgramType).append(")");
    this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
    GlUtil.checkLocation(this.maPositionLoc, "aPosition");
    this.maTextureCoordLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
    GlUtil.checkLocation(this.maTextureCoordLoc, "aTextureCoord");
    this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
    GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
    this.muTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
    GlUtil.checkLocation(this.muTexMatrixLoc, "uTexMatrix");
    this.muKernelLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
    if (this.muKernelLoc < 0)
    {
      this.muKernelLoc = -1;
      this.muTexOffsetLoc = -1;
      this.muColorAdjustLoc = -1;
      return;
    }
    this.muTexOffsetLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
    GlUtil.checkLocation(this.muTexOffsetLoc, "uTexOffset");
    this.muColorAdjustLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
    GlUtil.checkLocation(this.muColorAdjustLoc, "uColorAdjust");
    setKernel(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 0.0F);
    setTexSize(256, 256);
  }
  
  public int createTextureObject()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GlUtil.checkGlError("glGenTextures");
    int i = arrayOfInt[0];
    GLES20.glBindTexture(this.mTextureTarget, i);
    GlUtil.checkGlError("glBindTexture " + i);
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    GlUtil.checkGlError("glTexParameter");
    return i;
  }
  
  public void draw(float[] paramArrayOfFloat1, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer2, int paramInt5, int paramInt6)
  {
    GlUtil.checkGlError("draw start");
    GLES20.glUseProgram(this.mProgramHandle);
    GlUtil.checkGlError("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureTarget, paramInt5);
    GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, paramArrayOfFloat1, 0);
    GlUtil.checkGlError("glUniformMatrix4fv");
    GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, paramArrayOfFloat2, 0);
    GlUtil.checkGlError("glUniformMatrix4fv");
    GLES20.glEnableVertexAttribArray(this.maPositionLoc);
    GlUtil.checkGlError("glEnableVertexAttribArray");
    GLES20.glVertexAttribPointer(this.maPositionLoc, paramInt3, 5126, false, paramInt4, paramFloatBuffer1);
    GlUtil.checkGlError("glVertexAttribPointer");
    GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
    GlUtil.checkGlError("glEnableVertexAttribArray");
    GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, paramInt6, paramFloatBuffer2);
    GlUtil.checkGlError("glVertexAttribPointer");
    if (this.muKernelLoc >= 0)
    {
      GLES20.glUniform1fv(this.muKernelLoc, 9, this.mKernel, 0);
      GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
      GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
    }
    GLES20.glDrawArrays(5, paramInt1, paramInt2);
    GlUtil.checkGlError("glDrawArrays");
    GLES20.glDisableVertexAttribArray(this.maPositionLoc);
    GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
    GLES20.glBindTexture(this.mTextureTarget, 0);
    GLES20.glUseProgram(0);
  }
  
  public Texture2dProgram.ProgramType getProgramType()
  {
    return this.mProgramType;
  }
  
  public void release()
  {
    new StringBuilder("deleting program ").append(this.mProgramHandle);
    GLES20.glDeleteProgram(this.mProgramHandle);
    this.mProgramHandle = -1;
  }
  
  public void setKernel(float[] paramArrayOfFloat, float paramFloat)
  {
    if (paramArrayOfFloat.length != 9) {
      throw new IllegalArgumentException("Kernel size is " + paramArrayOfFloat.length + " vs. 9");
    }
    System.arraycopy(paramArrayOfFloat, 0, this.mKernel, 0, 9);
    this.mColorAdjust = paramFloat;
  }
  
  public void setTexSize(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F / paramInt1;
    float f2 = 1.0F / paramInt2;
    this.mTexOffset = new float[] { -f1, -f2, 0.0F, -f2, f1, -f2, -f1, 0.0F, 0.0F, 0.0F, f1, 0.0F, -f1, f2, 0.0F, f2, f1, f2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.gles.Texture2dProgram
 * JD-Core Version:    0.7.0.1
 */