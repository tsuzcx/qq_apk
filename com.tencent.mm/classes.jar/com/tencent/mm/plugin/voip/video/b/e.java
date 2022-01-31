package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
{
  private static volatile int tIJ = 0;
  
  static int Vm()
  {
    AppMethodBeat.i(140237);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    int i = arrayOfInt[0];
    AppMethodBeat.o(140237);
    return i;
  }
  
  static int Vn()
  {
    AppMethodBeat.i(140238);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("MicroMsg.VoipRenderUtils", "gen frame buffer error");
      AppMethodBeat.o(140238);
      return 0;
    }
    int i = arrayOfInt[0];
    AppMethodBeat.o(140238);
    return i;
  }
  
  static int cPY()
  {
    AppMethodBeat.i(140236);
    int[] arrayOfInt = new int[1];
    GLES20.glGetIntegerv(3379, arrayOfInt, 0);
    int j = arrayOfInt[0];
    ab.i("MicroMsg.VoipRenderUtils", "nextTexName, maxTexSize: %d", new Object[] { Integer.valueOf(j) });
    int i = 1;
    while (i < j)
    {
      if (!GLES20.glIsTexture(i))
      {
        ab.i("MicroMsg.VoipRenderUtils", "nextTexName: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(140236);
        return i;
      }
      i += 1;
    }
    ab.e("MicroMsg.VoipRenderUtils", "error!!, all texture is not available!");
    AppMethodBeat.o(140236);
    return -1;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(140234);
    int k = loadShader(35633, paramString1);
    if (k == 0)
    {
      AppMethodBeat.o(140234);
      return 0;
    }
    int m = loadShader(35632, paramString2);
    if (m == 0)
    {
      AppMethodBeat.o(140234);
      return 0;
    }
    int j = GLES20.glCreateProgram();
    if (j == 0) {
      ab.e("MicroMsg.VoipRenderUtils", "Could not create program");
    }
    GLES20.glAttachShader(j, k);
    GLES20.glAttachShader(j, m);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      ab.e("MicroMsg.VoipRenderUtils", "Could not link program: ");
      ab.e("MicroMsg.VoipRenderUtils", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
    }
    for (;;)
    {
      AppMethodBeat.o(140234);
      return i;
      i = j;
    }
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(140235);
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      ab.e("MicroMsg.VoipRenderUtils", "Could not compile shader %s and shader info is %s", new Object[] { Integer.valueOf(paramInt), GLES20.glGetShaderInfoLog(j) });
      GLES20.glDeleteShader(j);
    }
    for (paramInt = i;; paramInt = j)
    {
      AppMethodBeat.o(140235);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.e
 * JD-Core Version:    0.7.0.1
 */