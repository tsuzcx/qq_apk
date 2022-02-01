package com.tencent.mm.plugin.sns.ad.widget.alphavideo;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class e
{
  public static final float[] Qfi = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] Qfj = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] Qfk = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  
  public static String aV(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(310500);
    localBufferedReader = new BufferedReader(new InputStreamReader(paramContext.getResources().openRawResource(paramInt)));
    paramContext = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        paramContext.append(str);
        paramContext.append("\n");
      }
      try
      {
        localBufferedReader.close();
        paramContext = paramContext.toString();
        AppMethodBeat.o(310500);
        return paramContext;
      }
      catch (IOException localIOException)
      {
        break label66;
      }
    }
    catch (Exception localException) {}
  }
  
  public static int lQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310507);
    int i = GLES20.glCreateShader(35633);
    GLES20.glShaderSource(i, paramString1);
    GLES20.glCompileShader(i);
    paramString1 = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString1, 0);
    if (paramString1[0] != 1)
    {
      paramString1 = new IllegalStateException("load vertex shader:" + GLES20.glGetShaderInfoLog(i));
      AppMethodBeat.o(310507);
      throw paramString1;
    }
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(j, paramString2);
    GLES20.glCompileShader(j);
    GLES20.glGetShaderiv(j, 35713, paramString1, 0);
    if (paramString1[0] != 1)
    {
      paramString1 = new IllegalStateException("load fragment shader:" + GLES20.glGetShaderInfoLog(i));
      AppMethodBeat.o(310507);
      throw paramString1;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      paramString1 = new IllegalStateException("link program:" + GLES20.glGetProgramInfoLog(k));
      AppMethodBeat.o(310507);
      throw paramString1;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(310507);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.alphavideo.e
 * JD-Core Version:    0.7.0.1
 */