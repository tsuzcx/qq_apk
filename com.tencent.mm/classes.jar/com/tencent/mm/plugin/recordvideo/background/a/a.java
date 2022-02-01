package com.tencent.mm.plugin.recordvideo.background.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class a
{
  protected int vew;
  
  private static void Kf(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
  }
  
  public static int f(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    return g(paramBitmap, paramInt);
  }
  
  public static int g(Bitmap paramBitmap, int paramInt)
  {
    ad.i("MicroMsg.Story.AbsShader", "loadTexture");
    if (paramBitmap != null)
    {
      if (paramInt > 0) {
        Kf(paramInt);
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      paramInt = arrayOfInt[0];
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 10497);
      GLES20.glTexParameteri(3553, 10243, 10497);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      return paramInt;
    }
    ad.i("MicroMsg.Story.AbsShader", "loadTexture bitmap null");
    return paramInt;
  }
  
  protected static int loadShader(int paramInt, String paramString)
  {
    ad.i("MicroMsg.Story.AbsShader", "loadShader");
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0) {
      return 0;
    }
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ad.e("MicroMsg.Story.AbsShader", GLES20.glGetShaderInfoLog(paramInt));
      GLES20.glDeleteShader(paramInt);
      return 0;
    }
    return paramInt;
  }
  
  public final void dgZ()
  {
    GLES20.glUseProgram(this.vew);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(74994);
      vex = new a("Default", 0);
      vey = new a("CenterCrop", 1);
      vez = new a("CenterInside", 2);
      veA = new a[] { vex, vey, vez };
      AppMethodBeat.o(74994);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.a
 * JD-Core Version:    0.7.0.1
 */