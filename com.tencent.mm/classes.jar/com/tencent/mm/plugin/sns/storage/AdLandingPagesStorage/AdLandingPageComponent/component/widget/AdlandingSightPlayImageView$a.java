package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class AdlandingSightPlayImageView$a
  extends a
{
  private WeakReference<AdlandingSightPlayImageView> ofE;
  
  public AdlandingSightPlayImageView$a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
  {
    super(paramAdlandingSightPlayImageView);
    this.ofE = new WeakReference(paramAdlandingSightPlayImageView);
  }
  
  public final void G(Bitmap paramBitmap)
  {
    AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.ofE.get();
    if (localAdlandingSightPlayImageView == null)
    {
      y.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
      clear();
      return;
    }
    localAdlandingSightPlayImageView.setImageBitmap(paramBitmap);
  }
  
  protected final int bAZ()
  {
    return i.a.sight_loop;
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.ofE.get();
    if (localAdlandingSightPlayImageView == null)
    {
      y.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
      clear();
    }
    while (AdlandingSightPlayImageView.a(localAdlandingSightPlayImageView)) {
      return;
    }
    AdlandingSightPlayImageView.a(localAdlandingSightPlayImageView, paramInt1);
    AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView, paramInt2);
    if (localAdlandingSightPlayImageView.joM != null) {
      localAdlandingSightPlayImageView.joM.cw(paramInt1, paramInt2);
    }
    if (AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView))
    {
      if (AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView) < AdlandingSightPlayImageView.d(localAdlandingSightPlayImageView)) {
        break label247;
      }
      AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 150));
    }
    for (;;)
    {
      if (AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView) > 0)
      {
        ViewGroup.LayoutParams localLayoutParams = localAdlandingSightPlayImageView.getLayoutParams();
        if ((localLayoutParams.width != AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)) || (localLayoutParams.height != AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView) * paramInt2 / paramInt1))
        {
          localLayoutParams.width = AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView);
          localLayoutParams.height = (AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView) * paramInt2 / paramInt1);
          ai.d(new AdlandingSightPlayImageView.a.1(this, localAdlandingSightPlayImageView, localLayoutParams));
          localAdlandingSightPlayImageView.postInvalidate();
        }
        y.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      }
      y.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      label247:
      AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, com.tencent.mm.cb.a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 85));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView.a
 * JD-Core Version:    0.7.0.1
 */