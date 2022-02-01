package com.tencent.mm.plugin.sns.ad.widget.gllib;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class e
{
  public static Bitmap X(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(310130);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(310130);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.eraseColor(paramInt3);
    if (paramInt4 == 0)
    {
      AppMethodBeat.o(310130);
      return localBitmap;
    }
    localBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, paramInt4);
    AppMethodBeat.o(310130);
    return localBitmap;
  }
  
  public static int aI(Bitmap paramBitmap)
  {
    AppMethodBeat.i(310125);
    if (paramBitmap == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("Utils", "initTexture, bmp==null");
      AppMethodBeat.o(310125);
      return 0;
    }
    com.tencent.mm.sdk.platformtools.Log.i("Utils", "initTexture, bmp.w=" + paramBitmap.getWidth() + ", bmp.h=" + paramBitmap.getHeight());
    try
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      int i = arrayOfInt[0];
      if (i == 0)
      {
        AppMethodBeat.o(310125);
        return 0;
      }
      GLES20.glBindTexture(3553, i);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      AppMethodBeat.o(310125);
      return i;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("Utils", "initTexture exp:" + android.util.Log.getStackTraceString(paramBitmap));
      AppMethodBeat.o(310125);
    }
    return 0;
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    AppMethodBeat.i(310119);
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    AppMethodBeat.o(310119);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.gllib.e
 * JD-Core Version:    0.7.0.1
 */