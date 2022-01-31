package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.ETC1Util;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static final float[] EMPTY_POSITIONS;
  public static final float[] EMPTY_POSITIONS_TRIANGLES;
  public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
  public static final float[] IDENTITY_MATRIX;
  public static final int NO_TEXTURE = -1;
  public static final float[] ORIGIN_POSITION_COORDS;
  public static final float[] ORIGIN_TEX_COORDS;
  public static final float[] ORIGIN_TEX_COORDS_REVERSE;
  public static final float[] ORIGIN_TEX_COORDS_TRIANGLES;
  private static final int SIZEOF_FLOAT = 4;
  public static final String TAG;
  public static boolean curBlendModeEnabled;
  
  static
  {
    AppMethodBeat.i(50018);
    TAG = GlUtil.class.getSimpleName();
    EMPTY_POSITIONS = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    EMPTY_POSITIONS_TRIANGLES = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    ORIGIN_POSITION_COORDS = new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F };
    ORIGIN_TEX_COORDS = new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    ORIGIN_TEX_COORDS_REVERSE = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    ORIGIN_TEX_COORDS_TRIANGLES = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    float[] arrayOfFloat = new float[16];
    IDENTITY_MATRIX = arrayOfFloat;
    Matrix.setIdentityM(arrayOfFloat, 0);
    AppMethodBeat.o(50018);
  }
  
  @TargetApi(18)
  public static void checkEglError(String paramString)
  {
    AppMethodBeat.i(50005);
    for (;;)
    {
      int i = EGL14.eglGetError();
      if (i == 12288) {
        break;
      }
      new StringBuilder().append(paramString).append(": eglGetError: 0x").append(Integer.toHexString(i));
    }
    AppMethodBeat.o(50005);
  }
  
  public static void checkGlError(String paramString)
  {
    AppMethodBeat.i(50004);
    int i = GLES20.glGetError();
    if (i != 0) {
      new StringBuilder().append(paramString).append(": glError 0x").append(Integer.toHexString(i));
    }
    AppMethodBeat.o(50004);
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    AppMethodBeat.i(50006);
    if (paramInt < 0)
    {
      paramString = new RuntimeException("Unable to locate '" + paramString + "' in program");
      AppMethodBeat.o(50006);
      throw paramString;
    }
    AppMethodBeat.o(50006);
  }
  
  public static void createEtcTexture(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(50016);
    GLES20.glGenTextures(paramArrayOfInt.length, paramArrayOfInt, 0);
    while (i < paramArrayOfInt.length)
    {
      GLES20.glBindTexture(3553, paramArrayOfInt[i]);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      i += 1;
    }
    AppMethodBeat.o(50016);
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(50008);
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    AppMethodBeat.o(50008);
    return localObject;
  }
  
  public static int createImageTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50007);
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
    AppMethodBeat.o(50007);
    return i;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(50002);
    int k = loadShader(35633, paramString1);
    if (k == 0)
    {
      AppMethodBeat.o(50002);
      return 0;
    }
    int m = loadShader(35632, paramString2);
    if (m == 0)
    {
      AppMethodBeat.o(50002);
      return 0;
    }
    int j = GLES20.glCreateProgram();
    checkGlError("glCreateProgram");
    GLES20.glAttachShader(j, k);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(j, m);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      GLES20.glGetProgramInfoLog(j);
      GLES20.glDeleteProgram(j);
    }
    for (;;)
    {
      AppMethodBeat.o(50002);
      return i;
      i = j;
    }
  }
  
  public static FloatBuffer createSquareVtx()
  {
    AppMethodBeat.i(50001);
    Object localObject = ByteBuffer.allocateDirect(80);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(new float[] { -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F });
    ((FloatBuffer)localObject).position(0);
    AppMethodBeat.o(50001);
    return localObject;
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(50003);
    int j = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=".concat(String.valueOf(paramInt)));
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
      AppMethodBeat.o(50003);
      return paramInt;
    }
  }
  
  public static void loadTexture(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(50011);
    if (BitmapUtils.isLegal(paramBitmap))
    {
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    AppMethodBeat.o(50011);
  }
  
  public static void loadTexture(int paramInt, ETC1Util.ETC1Texture paramETC1Texture)
  {
    AppMethodBeat.i(50010);
    if (paramETC1Texture != null)
    {
      GLES20.glBindTexture(3553, paramInt);
      ETC1Util.loadTexture(3553, 0, 0, 6407, 33635, paramETC1Texture);
    }
    AppMethodBeat.o(50010);
  }
  
  public static void loadTexture(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(50012);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    checkGlError("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt4, paramInt2, paramInt3, 0, paramInt4, 5121, paramByteBuffer);
    checkGlError("loadImageTexture");
    AppMethodBeat.o(50012);
  }
  
  public static void logVersionInfo()
  {
    AppMethodBeat.i(50009);
    new StringBuilder("vendor  : ").append(GLES20.glGetString(7936));
    new StringBuilder("renderer: ").append(GLES20.glGetString(7937));
    new StringBuilder("version : ").append(GLES20.glGetString(7938));
    AppMethodBeat.o(50009);
  }
  
  public static void reBind(h paramh, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50015);
    if (paramh == null)
    {
      AppMethodBeat.o(50015);
      return;
    }
    paramh.width = paramInt2;
    paramh.height = paramInt3;
    GLES20.glBindFramebuffer(36160, paramh.bte[0]);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    AppMethodBeat.o(50015);
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6)
  {
    AppMethodBeat.i(50014);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(50014);
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
    AppMethodBeat.o(50014);
  }
  
  public static void saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    AppMethodBeat.i(50013);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(50013);
      return;
    }
    GLES20.glBindFramebuffer(36160, paramInt4);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    GLES20.glPixelStorei(3333, 1);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, paramArrayOfByte);
    GLES20.glBindFramebuffer(36160, 0);
    checkGlError("glBindFramebuffer");
    AppMethodBeat.o(50013);
  }
  
  public static void setBlendMode(boolean paramBoolean)
  {
    AppMethodBeat.i(50017);
    curBlendModeEnabled = paramBoolean;
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      AppMethodBeat.o(50017);
      return;
    }
    GLES20.glDisable(3042);
    AppMethodBeat.o(50017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.gles.GlUtil
 * JD-Core Version:    0.7.0.1
 */