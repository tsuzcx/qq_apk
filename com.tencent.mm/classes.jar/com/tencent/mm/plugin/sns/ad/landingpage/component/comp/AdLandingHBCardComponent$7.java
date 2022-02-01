package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class AdLandingHBCardComponent$7
  implements Runnable
{
  AdLandingHBCardComponent$7(AdLandingHBCardComponent paramAdLandingHBCardComponent, String paramString, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(310724);
    final Bitmap localBitmap = AdLandingPagesProxy.getInstance().getAvatarByUserName(this.lzH, false);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310661);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          AdLandingHBCardComponent.7.this.PRl.setImageBitmap(localBitmap);
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(AdLandingHBCardComponent.7.this.PRl, "alpha", new float[] { 0.5F, 1.0F });
          localObjectAnimator.setDuration(200L);
          localObjectAnimator.start();
          Log.i("AdLandingHBCardComponent", "loadAvatarByUserName end, userName=" + AdLandingHBCardComponent.7.this.lzH + ", w=" + localBitmap.getWidth() + ", h=" + localBitmap.getHeight());
        }
        AppMethodBeat.o(310661);
      }
    });
    AppMethodBeat.o(310724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.AdLandingHBCardComponent.7
 * JD-Core Version:    0.7.0.1
 */