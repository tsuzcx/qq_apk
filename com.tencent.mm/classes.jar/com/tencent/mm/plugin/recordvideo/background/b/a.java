package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
{
  protected int HHm;
  
  private static void acg(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
  }
  
  public static int i(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    return j(paramBitmap, paramInt);
  }
  
  public static int j(Bitmap paramBitmap, int paramInt)
  {
    Log.i("MicroMsg.Story.AbsShader", "loadTexture");
    if (paramBitmap != null)
    {
      if (paramInt > 0) {
        acg(paramInt);
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
    Log.i("MicroMsg.Story.AbsShader", "loadTexture bitmap null");
    return paramInt;
  }
  
  protected static int loadShader(int paramInt, String paramString)
  {
    Log.i("MicroMsg.Story.AbsShader", "loadShader");
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
      Log.e("MicroMsg.Story.AbsShader", GLES20.glGetShaderInfoLog(paramInt));
      GLES20.glDeleteShader(paramInt);
      return 0;
    }
    return paramInt;
  }
  
  public final void fvk()
  {
    GLES20.glUseProgram(this.HHm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.a
 * JD-Core Version:    0.7.0.1
 */