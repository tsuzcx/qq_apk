package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.a;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
{
  private static volatile int AQU = 0;
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(115740);
    int k = loadShader(35633, paramString1);
    if (k == 0)
    {
      AppMethodBeat.o(115740);
      return 0;
    }
    int m = loadShader(35632, paramString2);
    if (m == 0)
    {
      AppMethodBeat.o(115740);
      return 0;
    }
    int j = GLES20.glCreateProgram();
    if (j == 0) {
      ac.e("MicroMsg.VoipRenderUtils", "Could not create program");
    }
    GLES20.glAttachShader(j, k);
    GLES20.glAttachShader(j, m);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      ac.e("MicroMsg.VoipRenderUtils", "Could not link program: ");
      ac.e("MicroMsg.VoipRenderUtils", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
    }
    for (;;)
    {
      AppMethodBeat.o(115740);
      return i;
      i = j;
    }
  }
  
  static d emO()
  {
    AppMethodBeat.i(115742);
    d locald = c.a(true, 14L);
    AppMethodBeat.o(115742);
    return locald;
  }
  
  static a emP()
  {
    AppMethodBeat.i(115743);
    Object localObject = c.gRV;
    localObject = c.pq(14L);
    AppMethodBeat.o(115743);
    return localObject;
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(115741);
    int j = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      ac.e("MicroMsg.VoipRenderUtils", "Could not compile shader %s and shader info is %s", new Object[] { Integer.valueOf(paramInt), GLES20.glGetShaderInfoLog(j) });
      GLES20.glDeleteShader(j);
    }
    for (paramInt = i;; paramInt = j)
    {
      AppMethodBeat.o(115741);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.f
 * JD-Core Version:    0.7.0.1
 */