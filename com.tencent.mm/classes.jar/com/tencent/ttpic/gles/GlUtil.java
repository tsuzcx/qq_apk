package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.filter.h;
import com.tencent.ttpic.VideoModuleConfig;
import com.tencent.ttpic.cache.PreLoader;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final float[] IDENTITY_MATRIX;
  public static final int NO_TEXTURE = -1;
  private static final int SIZEOF_FLOAT = 4;
  public static final String TAG = GlUtil.class.getSimpleName();
  
  static
  {
    float[] arrayOfFloat = new float[16];
    IDENTITY_MATRIX = arrayOfFloat;
    Matrix.setIdentityM(arrayOfFloat, 0);
  }
  
  @TargetApi(18)
  public static void checkEglError(String paramString)
  {
    for (;;)
    {
      int i = EGL14.eglGetError();
      if (i == 12288) {
        break;
      }
      new StringBuilder().append(paramString).append(": eglGetError: 0x").append(Integer.toHexString(i));
    }
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      new StringBuilder().append(paramString).append(": glError 0x").append(Integer.toHexString(i));
    }
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new RuntimeException("Unable to locate '" + paramString + "' in program");
    }
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int createImageTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    checkGlError("glGenTextures");
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
    return i;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    checkGlError("glCreateProgram");
    GLES20.glAttachShader(k, i);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(k, j);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      GLES20.glGetProgramInfoLog(k);
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static FloatBuffer createSquareVtx()
  {
    Object localObject = ByteBuffer.allocateDirect(80);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(new float[] { -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F });
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static void debugCheckGlError(Object paramObject)
  {
    if (!VideoModuleConfig.GL_DEBUG) {}
    int i;
    do
    {
      return;
      i = GLES20.glGetError();
    } while (i == 0);
    new StringBuilder().append(paramObject.getClass().getSimpleName()).append(": glError 0x").append(Integer.toHexString(i));
    new Throwable();
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      new StringBuilder("Could not compile shader ").append(paramInt).append(":");
      new StringBuilder(" ").append(GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  public static void loadTexture(int paramInt, Bitmap paramBitmap)
  {
    synchronized (PreLoader.LOCK_IMAGE_PRE_LOADER)
    {
      if (VideoBitmapUtil.isLegal(paramBitmap))
      {
        GLES20.glBindTexture(3553, paramInt);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      }
      return;
    }
  }
  
  public static void loadTexture(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt4, paramInt2, paramInt3, 0, paramInt4, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
  }
  
  public static void logVersionInfo()
  {
    new StringBuilder("vendor  : ").append(GLES20.glGetString(7936));
    new StringBuilder("renderer: ").append(GLES20.glGetString(7937));
    new StringBuilder("version : ").append(GLES20.glGetString(7938));
  }
  
  public static void reBind(h paramh, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramh == null) {
      return;
    }
    paramh.width = paramInt2;
    paramh.height = paramInt3;
    GLES20.glBindFramebuffer(36160, paramh.bcC[0]);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt6);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    GLES20.glPixelStorei(3333, 1);
    GLES20.glReadPixels(paramInt2, paramInt3, paramInt4, paramInt5, 6408, 5121, paramArrayOfByte);
    GLES20.glBindFramebuffer(36160, 0);
    checkGlError("glBindFramebuffer");
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt4);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    GLES20.glPixelStorei(3333, 1);
    BenchUtil.benchStart("glReadPixels");
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, paramArrayOfByte);
    BenchUtil.benchEnd("glReadPixels");
    GLES20.glBindFramebuffer(36160, 0);
    checkGlError("glBindFramebuffer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.gles.GlUtil
 * JD-Core Version:    0.7.0.1
 */