package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public class Program
{
  private static final String TAG = "Program";
  
  public static void checkEglError(String paramString)
  {
    AppMethodBeat.i(218269);
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(j));
      localStringBuilder.append(paramString + ": EGL error: 0x" + Integer.toHexString(j));
      i = 1;
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + localStringBuilder.toString());
    }
    AppMethodBeat.o(218269);
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(218266);
      int i = createProgram(paramString1, paramString2, null);
      AppMethodBeat.o(218266);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int createProgram(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    int k;
    int m;
    try
    {
      AppMethodBeat.i(218267);
      GLES20.glEnable(3042);
      GLES20.glBlendEquationSeparate(32774, 32774);
      GLES20.glBlendFuncSeparate(770, 771, 1, 771);
      k = loadShader(35633, paramString1);
      if (k == 0) {
        AppMethodBeat.o(218267);
      }
      for (i = j;; i = j)
      {
        return i;
        m = loadShader(35632, paramString2);
        if (m != 0) {
          break;
        }
        AppMethodBeat.o(218267);
      }
      if (paramArrayOfInt == null) {
        break label115;
      }
    }
    finally {}
    if (paramArrayOfInt.length >= 2)
    {
      paramArrayOfInt[0] = k;
      paramArrayOfInt[1] = m;
    }
    label115:
    j = GLES20.glCreateProgram();
    checkEglError("glCreateProgram");
    if (j == 0) {
      Logger.e("Program", "Could not create program");
    }
    GLES20.glAttachShader(j, k);
    checkEglError("glAttachShader");
    GLES20.glAttachShader(j, m);
    checkEglError("glAttachShader");
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Logger.e("Program", "Could not link program: ");
      Logger.e("Program", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
    }
    for (;;)
    {
      AppMethodBeat.o(218267);
      break;
      i = j;
    }
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(218268);
        j = GLES20.glCreateShader(paramInt);
        checkEglError("glCreateShader type=".concat(String.valueOf(paramInt)));
        GLES20.glShaderSource(j, paramString);
        GLES20.glCompileShader(j);
        paramString = new int[1];
        GLES20.glGetShaderiv(j, 35713, paramString, 0);
        if (paramString[0] == 0)
        {
          Logger.e("Program", "Could not compile shader " + paramInt + ":");
          Logger.e("Program", " " + GLES20.glGetShaderInfoLog(j));
          GLES20.glDeleteShader(j);
          paramInt = i;
          AppMethodBeat.o(218268);
          return paramInt;
        }
      }
      finally {}
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.Program
 * JD-Core Version:    0.7.0.1
 */