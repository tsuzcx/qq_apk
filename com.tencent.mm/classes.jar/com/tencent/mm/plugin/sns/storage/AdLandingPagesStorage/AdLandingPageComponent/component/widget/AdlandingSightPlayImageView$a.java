package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;

final class AdlandingSightPlayImageView$a
  extends b
{
  private WeakReference<AdlandingSightPlayImageView> qTS;
  
  public AdlandingSightPlayImageView$a(AdlandingSightPlayImageView paramAdlandingSightPlayImageView)
  {
    super(paramAdlandingSightPlayImageView);
    AppMethodBeat.i(37436);
    this.qTS = new WeakReference(paramAdlandingSightPlayImageView);
    AppMethodBeat.o(37436);
  }
  
  public final void S(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37438);
    AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.qTS.get();
    if (localAdlandingSightPlayImageView == null)
    {
      ab.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
      clear();
      AppMethodBeat.o(37438);
      return;
    }
    localAdlandingSightPlayImageView.setImageBitmap(paramBitmap);
    AppMethodBeat.o(37438);
  }
  
  protected final int cmz()
  {
    return 2131034258;
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37437);
    AdlandingSightPlayImageView localAdlandingSightPlayImageView = (AdlandingSightPlayImageView)this.qTS.get();
    if (localAdlandingSightPlayImageView == null)
    {
      ab.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
      clear();
      AppMethodBeat.o(37437);
      return;
    }
    if (AdlandingSightPlayImageView.a(localAdlandingSightPlayImageView))
    {
      AppMethodBeat.o(37437);
      return;
    }
    AdlandingSightPlayImageView.a(localAdlandingSightPlayImageView, paramInt1);
    AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView, paramInt2);
    if (localAdlandingSightPlayImageView.lxA != null) {
      localAdlandingSightPlayImageView.lxA.dQ(paramInt1, paramInt2);
    }
    if (AdlandingSightPlayImageView.b(localAdlandingSightPlayImageView))
    {
      if (AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView) < AdlandingSightPlayImageView.d(localAdlandingSightPlayImageView)) {
        break label268;
      }
      AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 150));
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
          al.d(new AdlandingSightPlayImageView.a.1(this, localAdlandingSightPlayImageView, localLayoutParams));
          localAdlandingSightPlayImageView.postInvalidate();
        }
        ab.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      }
      ab.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(AdlandingSightPlayImageView.e(localAdlandingSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(37437);
      return;
      label268:
      AdlandingSightPlayImageView.c(localAdlandingSightPlayImageView, a.fromDPToPix(localAdlandingSightPlayImageView.getContext(), 85));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView.a
 * JD-Core Version:    0.7.0.1
 */