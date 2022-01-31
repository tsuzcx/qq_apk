package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SphereImageView$3
  implements Runnable
{
  SphereImageView$3(SphereImageView paramSphereImageView, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(145407);
    Object localObject = new StringBuilder("updateImage in GLThread, bmp.w=");
    if (this.val$bmp == null)
    {
      i = 0;
      localObject = ((StringBuilder)localObject).append(i).append(", h=");
      if (this.val$bmp != null) {
        break label228;
      }
    }
    label228:
    for (int i = j;; i = this.val$bmp.getHeight())
    {
      ab.i("SphereImageView.SphereView", i);
      localObject = SphereImageView.d(this.rBr);
      Bitmap localBitmap = this.val$bmp;
      try
      {
        long l = System.currentTimeMillis();
        if (((b)localObject).rBE != 0)
        {
          GLES20.glDeleteTextures(1, new int[] { ((b)localObject).rBE }, 0);
          ab.i("SphereImageView.SphereRender", "delete old texture");
        }
        i = c.Y(localBitmap);
        ab.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).rBE + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
        ((b)localObject).rBE = i;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
        }
      }
      this.rBr.rzX.requestRender();
      if (this.rBr.rBq != null) {
        this.rBr.mHandler.post(new SphereImageView.3.1(this));
      }
      AppMethodBeat.o(145407);
      return;
      i = this.val$bmp.getWidth();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.3
 * JD-Core Version:    0.7.0.1
 */