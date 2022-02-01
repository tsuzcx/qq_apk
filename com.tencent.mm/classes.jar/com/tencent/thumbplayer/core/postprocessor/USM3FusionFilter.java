package com.tencent.thumbplayer.core.postprocessor;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class USM3FusionFilter
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String TAG = "sifeng: USM3Fusionr";
  private static final float[] positoins = { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static final float[] texcoords = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] weights = { 4.0F, 0.3F, 0.4F, 0.3F, 6.0F, 0.4F, 0.5F, 0.1F, 4.0F, 0.4F, 0.5F, 0.1F };
  private String FRAGMENT_SHADER;
  private String VERTEX_SHADER;
  private int[] mFrameBuffer;
  private int mHeight;
  private float[] mMVPMatrix;
  private FloatBuffer mPositoins;
  private int mProgramHandle;
  private float[] mSTMatrix;
  private FloatBuffer mTexcoords;
  private int[] mTextureid;
  private int mWidth;
  private int mblurredImageTexture1id;
  private int mblurredImageTexture2id;
  private int mblurredImageTexture3id;
  private int minputImageTextureid;
  private int mpositionid;
  private int msharpenraio;
  private int mtexcoordid;
  private int muMVPMatrixHandle;
  private int muSTMatrixHandle;
  private int mweightid;
  
  public USM3FusionFilter(String paramString)
  {
    AppMethodBeat.i(227346);
    this.mMVPMatrix = new float[16];
    this.mSTMatrix = new float[16];
    this.mProgramHandle = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mpositionid = 0;
    this.mtexcoordid = 0;
    this.minputImageTextureid = 0;
    this.mblurredImageTexture1id = 0;
    this.mblurredImageTexture2id = 0;
    this.mblurredImageTexture3id = 0;
    this.mweightid = 0;
    this.msharpenraio = 0;
    this.mFrameBuffer = new int[1];
    this.mFrameBuffer[0] = 0;
    this.mTextureid = new int[1];
    this.mTextureid[0] = 0;
    this.mPositoins = ByteBuffer.allocateDirect(positoins.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mPositoins.put(positoins).position(0);
    this.mTexcoords = ByteBuffer.allocateDirect(texcoords.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTexcoords.put(texcoords).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
    Object localObject = getClass().getClassLoader().getResourceAsStream(paramString + "/vertex_general.glsl");
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i;
    if (localObject != null) {
      for (i = ((InputStream)localObject).read(arrayOfByte); i != -1; i = ((InputStream)localObject).read(arrayOfByte)) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    ((InputStream)localObject).close();
    localByteArrayOutputStream.close();
    this.VERTEX_SHADER = new String(localByteArrayOutputStream.toByteArray());
    paramString = getClass().getClassLoader().getResourceAsStream(paramString + "/fragment_usm3fusion.glsl");
    localObject = new ByteArrayOutputStream();
    if (paramString != null) {
      for (i = paramString.read(arrayOfByte); i != -1; i = paramString.read(arrayOfByte)) {
        ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
      }
    }
    paramString.close();
    ((ByteArrayOutputStream)localObject).close();
    this.FRAGMENT_SHADER = new String(((ByteArrayOutputStream)localObject).toByteArray());
    if ((compileShaders() != true) || (checkGlError("USM3FusionFilter") != 0))
    {
      paramString = new RuntimeException("USM3FusionFilter create failed");
      AppMethodBeat.o(227346);
      throw paramString;
    }
    AppMethodBeat.o(227346);
  }
  
  private int checkGlError(String paramString)
  {
    AppMethodBeat.i(227354);
    int i = GLES20.glGetError();
    if (i != 0)
    {
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(i));
      AppMethodBeat.o(227354);
      return i;
    }
    AppMethodBeat.o(227354);
    return 0;
  }
  
  int compileShader(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(227373);
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      new StringBuilder("Could not compile shader ").append(paramInt).append(":");
      new StringBuilder(" ").append(GLES20.glGetShaderInfoLog(j));
      GLES20.glDeleteShader(j);
    }
    for (paramInt = i;; paramInt = j)
    {
      AppMethodBeat.o(227373);
      return paramInt;
    }
  }
  
  boolean compileShaders()
  {
    AppMethodBeat.i(227384);
    int i = compileShader(this.VERTEX_SHADER, 35633);
    if (i == 0)
    {
      AppMethodBeat.o(227384);
      return false;
    }
    int j = compileShader(this.FRAGMENT_SHADER, 35632);
    if (j == 0)
    {
      AppMethodBeat.o(227384);
      return false;
    }
    this.mProgramHandle = GLES20.glCreateProgram();
    if (checkGlError("glCreateProgram") != 0)
    {
      AppMethodBeat.o(227384);
      return false;
    }
    GLES20.glAttachShader(this.mProgramHandle, i);
    if (checkGlError("glAttachShader") != 0)
    {
      AppMethodBeat.o(227384);
      return false;
    }
    GLES20.glAttachShader(this.mProgramHandle, j);
    if (checkGlError("glAttachShader") != 0)
    {
      AppMethodBeat.o(227384);
      return false;
    }
    GLES20.glLinkProgram(this.mProgramHandle);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(this.mProgramHandle, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      GLES20.glGetProgramInfoLog(this.mProgramHandle);
      GLES20.glDeleteProgram(this.mProgramHandle);
      this.mProgramHandle = 0;
      AppMethodBeat.o(227384);
      return false;
    }
    GLES20.glUseProgram(this.mProgramHandle);
    this.mpositionid = GLES20.glGetAttribLocation(this.mProgramHandle, "position");
    GLES20.glEnableVertexAttribArray(this.mpositionid);
    this.mtexcoordid = GLES20.glGetAttribLocation(this.mProgramHandle, "texCoord");
    GLES20.glEnableVertexAttribArray(this.mtexcoordid);
    this.minputImageTextureid = GLES20.glGetUniformLocation(this.mProgramHandle, "inputImageTexture");
    this.mblurredImageTexture1id = GLES20.glGetUniformLocation(this.mProgramHandle, "blurredImageTexture1");
    this.mblurredImageTexture2id = GLES20.glGetUniformLocation(this.mProgramHandle, "blurredImageTexture2");
    this.mblurredImageTexture3id = GLES20.glGetUniformLocation(this.mProgramHandle, "blurredImageTexture3");
    this.mweightid = GLES20.glGetUniformLocation(this.mProgramHandle, "weight");
    this.msharpenraio = GLES20.glGetUniformLocation(this.mProgramHandle, "ratio");
    this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
    this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uSTMatrix");
    if ((this.mpositionid == -1) || (this.mtexcoordid == -1) || (this.minputImageTextureid == -1) || (this.muMVPMatrixHandle == -1) || (this.muSTMatrixHandle == -1) || (this.mblurredImageTexture1id == -1) || (this.mblurredImageTexture2id == -1) || (this.mblurredImageTexture3id == -1) || (this.mweightid == -1) || (this.msharpenraio == -1))
    {
      AppMethodBeat.o(227384);
      return false;
    }
    AppMethodBeat.o(227384);
    return true;
  }
  
  void destroyBuffers()
  {
    AppMethodBeat.i(227395);
    if (this.mFrameBuffer[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, this.mFrameBuffer, 0);
      this.mFrameBuffer[0] = 0;
    }
    if (this.mTextureid[0] != 0)
    {
      GLES20.glDeleteTextures(1, this.mTextureid, 0);
      this.mTextureid[0] = 0;
    }
    if (this.mProgramHandle != 0)
    {
      GLES20.glDeleteProgram(this.mProgramHandle);
      this.mProgramHandle = 0;
    }
    AppMethodBeat.o(227395);
  }
  
  int process(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    AppMethodBeat.i(227423);
    if ((this.mWidth != paramInt5) || (this.mHeight != paramInt6)) {
      updatebuffer(paramInt5, paramInt6);
    }
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glUseProgram(this.mProgramHandle);
    GLES20.glViewport(0, 0, paramInt5, paramInt6);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glUniform1i(this.minputImageTextureid, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(this.mblurredImageTexture1id, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(this.mblurredImageTexture2id, 2);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, paramInt4);
    GLES20.glUniform1i(this.mblurredImageTexture3id, 3);
    if (paramInt5 * paramInt6 >= 2073600) {
      paramInt1 = 2;
    }
    for (;;)
    {
      GLES20.glUniform1fv(this.mweightid, 4, weights, paramInt1 * 4);
      float f2 = paramInt7;
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
      GLES20.glUniform1f(this.msharpenraio, f1);
      Matrix.setIdentityM(this.mMVPMatrix, 0);
      GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
      GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
      GLES20.glEnableVertexAttribArray(this.mpositionid);
      GLES20.glEnableVertexAttribArray(this.mtexcoordid);
      this.mPositoins.position(0);
      this.mTexcoords.position(0);
      GLES20.glVertexAttribPointer(this.mpositionid, 3, 5126, false, 0, this.mPositoins);
      GLES20.glVertexAttribPointer(this.mtexcoordid, 2, 5126, false, 0, this.mTexcoords);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.mpositionid);
      GLES20.glDisableVertexAttribArray(this.mtexcoordid);
      GLES20.glBindFramebuffer(36160, 0);
      if (checkGlError("USM3FusionFilter") == 0) {
        break;
      }
      RuntimeException localRuntimeException = new RuntimeException("sifeng: USM3FusionFilter process failed");
      AppMethodBeat.o(227423);
      throw localRuntimeException;
      if (paramInt5 * paramInt6 >= 921600) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    paramInt1 = this.mTextureid[0];
    AppMethodBeat.o(227423);
    return paramInt1;
  }
  
  void updatebuffer(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227408);
    if (this.mFrameBuffer[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, this.mFrameBuffer, 0);
      this.mFrameBuffer[0] = 0;
    }
    if (this.mTextureid[0] != 0)
    {
      GLES20.glDeleteTextures(1, this.mTextureid, 0);
      this.mTextureid[0] = 0;
    }
    GLES20.glGenFramebuffers(1, this.mFrameBuffer, 0);
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glGenTextures(1, this.mTextureid, 0);
    GLES20.glBindTexture(3553, this.mTextureid[0]);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTextureid[0], 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    AppMethodBeat.o(227408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.postprocessor.USM3FusionFilter
 * JD-Core Version:    0.7.0.1
 */