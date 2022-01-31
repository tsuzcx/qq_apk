package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ProgramTools
{
  public static final int PER_FLOAT_BYTE = 4;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(50028);
    TAG = ProgramTools.class.getSimpleName();
    AppMethodBeat.o(50028);
  }
  
  public static int createComputeProgram(String paramString)
  {
    AppMethodBeat.i(50023);
    int i = GLES31.glCreateShader(37305);
    GLES20.glShaderSource(i, paramString);
    Object localObject = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      localObject = GLES20.glGetShaderInfoLog(i);
      GLES20.glDeleteShader(i);
      if (GLConfig.DEBUG) {
        if (paramString.length() < 100) {
          break label110;
        }
      }
      label110:
      for (i = paramString.length() - 100;; i = 0)
      {
        LogUtils.e(TAG, "vertex shader compile,failed:" + paramString.substring(i));
        LogUtils.e(TAG, (String)localObject);
        AppMethodBeat.o(50023);
        return 0;
      }
    }
    int j = GLES20.glCreateProgram();
    GLES20.glAttachShader(j, i);
    GLES20.glLinkProgram(j);
    GLES20.glGetProgramiv(j, 35714, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      GLES20.glDeleteProgram(j);
      new StringBuilder("link program,failed:").append(GLES20.glGetProgramInfoLog(j));
      if (GLConfig.DEBUG) {
        LogUtils.e(TAG, "link program,failed:" + GLES20.glGetProgramInfoLog(j));
      }
      AppMethodBeat.o(50023);
      return 0;
    }
    GLES20.glDeleteShader(i);
    AppMethodBeat.o(50023);
    return j;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50022);
    int i = GLES20.glCreateShader(35633);
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glShaderSource(j, paramString2);
    int[] arrayOfInt = new int[1];
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      paramString2 = GLES20.glGetShaderInfoLog(i);
      GLES20.glDeleteShader(i);
      if (GLConfig.DEBUG) {
        if (paramString1.length() < 100) {
          break label124;
        }
      }
      label124:
      for (i = paramString1.length() - 100;; i = 0)
      {
        LogUtils.e(TAG, "vertex shader compile,failed:" + paramString1.substring(i));
        LogUtils.e(TAG, paramString2);
        AppMethodBeat.o(50022);
        return 0;
      }
    }
    GLES20.glCompileShader(j);
    GLES20.glGetShaderiv(j, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      paramString1 = GLES20.glGetShaderInfoLog(j);
      GLES20.glDeleteShader(j);
      if (GLConfig.DEBUG) {
        if (paramString2.length() < 100) {
          break label221;
        }
      }
      label221:
      for (i = paramString2.length() - 100;; i = 0)
      {
        LogUtils.e(TAG, "fragment shader compile,failed:" + paramString2.substring(i));
        LogUtils.e(TAG, paramString1);
        AppMethodBeat.o(50022);
        return 0;
      }
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteProgram(k);
      new StringBuilder("link program,failed:").append(GLES20.glGetProgramInfoLog(k));
      if (GLConfig.DEBUG) {
        LogUtils.e(TAG, "link program,failed:" + GLES20.glGetProgramInfoLog(k));
      }
      AppMethodBeat.o(50022);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(50022);
    return k;
  }
  
  public static void createTexture(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(50024);
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, null);
    AppMethodBeat.o(50024);
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    AppMethodBeat.i(50025);
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    AppMethodBeat.o(50025);
    return paramInt;
  }
  
  public static void mallocTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50026);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
    AppMethodBeat.o(50026);
  }
  
  /* Error */
  private static String readTextFile(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 160
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 166	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_1
    //   10: invokevirtual 172	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore_0
    //   14: new 174	java/io/BufferedReader
    //   17: dup
    //   18: new 176	java/io/InputStreamReader
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 179	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: invokespecial 182	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_2
    //   30: new 78	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +36 -> 82
    //   49: aload_3
    //   50: aload 4
    //   52: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: ldc 188
    //   59: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: goto -25 -> 38
    //   66: astore_3
    //   67: aload_0
    //   68: invokevirtual 193	java/io/InputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 194	java/io/BufferedReader:close	()V
    //   75: ldc 160
    //   77: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_0
    //   83: invokevirtual 193	java/io/InputStream:close	()V
    //   86: aload_2
    //   87: invokevirtual 194	java/io/BufferedReader:close	()V
    //   90: aload_3
    //   91: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_0
    //   95: ldc 160
    //   97: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_3
    //   103: aload_0
    //   104: invokevirtual 193	java/io/InputStream:close	()V
    //   107: aload_2
    //   108: invokevirtual 194	java/io/BufferedReader:close	()V
    //   111: ldc 160
    //   113: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_3
    //   117: athrow
    //   118: astore_0
    //   119: goto -8 -> 111
    //   122: astore_0
    //   123: goto -48 -> 75
    //   126: astore_0
    //   127: goto -37 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramContext	android.content.Context
    //   0	130	1	paramInt	int
    //   29	79	2	localBufferedReader	java.io.BufferedReader
    //   37	20	3	localStringBuilder	StringBuilder
    //   66	25	3	localException	java.lang.Exception
    //   102	15	3	localObject	Object
    //   42	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   38	44	66	java/lang/Exception
    //   49	63	66	java/lang/Exception
    //   38	44	102	finally
    //   49	63	102	finally
    //   103	111	118	java/io/IOException
    //   67	75	122	java/io/IOException
    //   82	90	126	java/io/IOException
  }
  
  @TargetApi(18)
  public static void setupSSBufferObject(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    AppMethodBeat.i(50027);
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramInt3 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    if (paramArrayOfFloat != null) {
      localFloatBuffer.put(paramArrayOfFloat).position(0);
    }
    GLES31.glBindBuffer(37074, paramInt1);
    GLES31.glBufferData(37074, paramInt3 * 4, localFloatBuffer, 35044);
    GLES31.glBindBufferBase(37074, paramInt2, paramInt1);
    AppMethodBeat.o(50027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.gles.ProgramTools
 * JD-Core Version:    0.7.0.1
 */