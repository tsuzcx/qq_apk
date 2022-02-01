package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ad$3$1
  implements Runnable
{
  ad$3$1(ad.3 param3, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(292861);
    ad localad = this.Ofr.KsN;
    Bitmap localBitmap = this.val$bitmap;
    if (localBitmap == null)
    {
      Log.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(292861);
      return;
    }
    if (localad.fDJ == null)
    {
      Log.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      AppMethodBeat.o(292861);
      return;
    }
    if (localBitmap.getWidth() == 0)
    {
      Log.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(292861);
      return;
    }
    localad.fDJ.setImageBitmap(localBitmap);
    localad.progressBar.setVisibility(8);
    AppMethodBeat.o(292861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.3.1
 * JD-Core Version:    0.7.0.1
 */