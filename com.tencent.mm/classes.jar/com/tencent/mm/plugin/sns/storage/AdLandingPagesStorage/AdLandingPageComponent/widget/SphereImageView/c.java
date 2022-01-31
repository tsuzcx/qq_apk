package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static int Y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(145431);
    if (paramBitmap == null)
    {
      ab.i("SphereImageView.Utils", "initTexture, bmp==null");
      AppMethodBeat.o(145431);
      return 0;
    }
    ab.i("SphereImageView.Utils", "initTexture, bmp.w=" + paramBitmap.getWidth() + ", bmp.h=" + paramBitmap.getHeight());
    try
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      int i = arrayOfInt[0];
      GLES20.glBindTexture(3553, i);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      AppMethodBeat.o(145431);
      return i;
    }
    catch (Throwable paramBitmap)
    {
      ab.e("SphereImageView.Utils", "initTexture exp:" + paramBitmap.toString());
      AppMethodBeat.o(145431);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.c
 * JD-Core Version:    0.7.0.1
 */