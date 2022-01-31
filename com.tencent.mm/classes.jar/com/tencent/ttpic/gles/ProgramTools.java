package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.tencent.ttpic.VideoModuleConfig;

public class ProgramTools
{
  private static final String TAG = ProgramTools.class.getSimpleName();
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    int m = GLES20.glCreateShader(35633);
    int n = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(m, paramString1);
    GLES20.glShaderSource(n, paramString2);
    int[] arrayOfInt = new int[1];
    GLES20.glCompileShader(m);
    GLES20.glGetShaderiv(m, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteShader(m);
      if (VideoModuleConfig.DEBUG)
      {
        i = j;
        if (paramString1.length() >= 100) {
          i = paramString1.length() - 100;
        }
        throw new RuntimeException("vertex shader compile,failed:" + paramString1.substring(i));
      }
    }
    else
    {
      GLES20.glCompileShader(n);
      GLES20.glGetShaderiv(n, 35713, arrayOfInt, 0);
      if (arrayOfInt[0] == 0)
      {
        GLES20.glDeleteShader(n);
        if (VideoModuleConfig.DEBUG)
        {
          i = k;
          if (paramString2.length() >= 100) {
            i = paramString2.length() - 100;
          }
          throw new RuntimeException("fragment shader compile,failed:" + paramString2.substring(i));
        }
      }
      else
      {
        j = GLES20.glCreateProgram();
        GLES20.glAttachShader(j, m);
        GLES20.glAttachShader(j, n);
        GLES20.glLinkProgram(j);
        GLES20.glGetProgramiv(j, 35714, arrayOfInt, 0);
        if (arrayOfInt[0] == 0)
        {
          GLES20.glDeleteProgram(j);
          new StringBuilder("link program,failed:").append(GLES20.glGetProgramInfoLog(j));
          if (VideoModuleConfig.DEBUG) {
            throw new RuntimeException("link program,failed:" + GLES20.glGetProgramInfoLog(j));
          }
        }
        else
        {
          GLES20.glDeleteShader(m);
          GLES20.glDeleteShader(n);
          i = j;
        }
      }
    }
    return i;
  }
  
  public static void createTexture(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, null);
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    return paramInt;
  }
  
  public static void mallocTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
  }
  
  /* Error */
  private static String readTextFile(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 136	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 142	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore_0
    //   9: new 144	java/io/BufferedReader
    //   12: dup
    //   13: new 146	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 152	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: new 62	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_2
    //   34: invokevirtual 156	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +31 -> 72
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: ldc 158
    //   54: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -25 -> 33
    //   61: astore_3
    //   62: aload_0
    //   63: invokevirtual 163	java/io/InputStream:close	()V
    //   66: aload_2
    //   67: invokevirtual 164	java/io/BufferedReader:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: invokevirtual 163	java/io/InputStream:close	()V
    //   76: aload_2
    //   77: invokevirtual 164	java/io/BufferedReader:close	()V
    //   80: aload_3
    //   81: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: areturn
    //   85: astore_3
    //   86: aload_0
    //   87: invokevirtual 163	java/io/InputStream:close	()V
    //   90: aload_2
    //   91: invokevirtual 164	java/io/BufferedReader:close	()V
    //   94: aload_3
    //   95: athrow
    //   96: astore_0
    //   97: goto -3 -> 94
    //   100: astore_0
    //   101: goto -31 -> 70
    //   104: astore_0
    //   105: goto -25 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramContext	android.content.Context
    //   0	108	1	paramInt	int
    //   24	67	2	localBufferedReader	java.io.BufferedReader
    //   32	20	3	localStringBuilder	StringBuilder
    //   61	20	3	localException	java.lang.Exception
    //   85	10	3	localObject	Object
    //   37	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   33	39	61	java/lang/Exception
    //   44	58	61	java/lang/Exception
    //   33	39	85	finally
    //   44	58	85	finally
    //   86	94	96	java/io/IOException
    //   62	70	100	java/io/IOException
    //   72	80	104	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.gles.ProgramTools
 * JD-Core Version:    0.7.0.1
 */