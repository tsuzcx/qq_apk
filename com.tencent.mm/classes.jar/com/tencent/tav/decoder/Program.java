package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.GLES30;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public class Program
{
  private static final String TAG = "Program";
  
  public static void checkEglError(String paramString)
  {
    AppMethodBeat.i(216383);
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      Logger.e("Program", paramString + ": EGL error: 0x" + Integer.toHexString(j));
      localStringBuilder.append(paramString + ": EGL error: 0x" + Integer.toHexString(j));
      i = 1;
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + localStringBuilder.toString());
    }
    AppMethodBeat.o(216383);
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(216363);
      int i = createProgram(paramString1, paramString2, null);
      AppMethodBeat.o(216363);
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
      AppMethodBeat.i(216372);
      GLES30.glEnable(3042);
      GLES30.glBlendEquationSeparate(32774, 32774);
      GLES30.glBlendFuncSeparate(770, 771, 1, 771);
      k = loadShader(35633, paramString1);
      if (k == 0) {
        AppMethodBeat.o(216372);
      }
      for (i = j;; i = j)
      {
        return i;
        m = loadShader(35632, paramString2);
        if (m != 0) {
          break;
        }
        AppMethodBeat.o(216372);
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
    j = GLES30.glCreateProgram();
    checkEglError("glCreateProgram");
    if (j == 0) {
      Logger.e("Program", "Could not create program");
    }
    GLES30.glAttachShader(j, k);
    checkEglError("glAttachShader");
    GLES30.glAttachShader(j, m);
    checkEglError("glAttachShader");
    GLES30.glLinkProgram(j);
    paramString1 = new int[1];
    GLES30.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Logger.e("Program", "Could not link program: ");
      Logger.e("Program", GLES30.glGetProgramInfoLog(j));
      GLES30.glDeleteProgram(j);
    }
    for (;;)
    {
      AppMethodBeat.o(216372);
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
        AppMethodBeat.i(216379);
        j = GLES30.glCreateShader(paramInt);
        checkEglError("glCreateShader type=".concat(String.valueOf(paramInt)));
        GLES30.glShaderSource(j, paramString);
        GLES30.glCompileShader(j);
        paramString = new int[1];
        GLES30.glGetShaderiv(j, 35713, paramString, 0);
        if (paramString[0] == 0)
        {
          Logger.e("Program", "Could not compile shader " + paramInt + ":");
          Logger.e("Program", " " + GLES30.glGetShaderInfoLog(j));
          GLES30.glDeleteShader(j);
          paramInt = i;
          AppMethodBeat.o(216379);
          return paramInt;
        }
      }
      finally {}
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.Program
 * JD-Core Version:    0.7.0.1
 */