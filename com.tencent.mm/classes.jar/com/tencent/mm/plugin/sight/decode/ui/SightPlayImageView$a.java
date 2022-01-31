package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.ai.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class SightPlayImageView$a
  extends b
{
  private WeakReference<SightPlayImageView> ofE;
  
  public SightPlayImageView$a(SightPlayImageView paramSightPlayImageView)
  {
    super(0, paramSightPlayImageView);
    this.ofE = new WeakReference(paramSightPlayImageView);
  }
  
  public final void G(Bitmap paramBitmap)
  {
    SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.ofE.get();
    if (localSightPlayImageView == null)
    {
      y.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
      clear();
      return;
    }
    localSightPlayImageView.setImageBitmap(paramBitmap);
  }
  
  protected final int bAZ()
  {
    return a.a.sight_loop;
  }
  
  public final void cw(int paramInt1, int paramInt2)
  {
    SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.ofE.get();
    if (localSightPlayImageView == null)
    {
      y.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
      clear();
    }
    while (SightPlayImageView.a(localSightPlayImageView)) {
      return;
    }
    SightPlayImageView.a(localSightPlayImageView, paramInt1);
    SightPlayImageView.b(localSightPlayImageView, paramInt2);
    if (localSightPlayImageView.joM != null) {
      localSightPlayImageView.joM.cw(paramInt1, paramInt2);
    }
    if (SightPlayImageView.b(localSightPlayImageView))
    {
      if (SightPlayImageView.c(localSightPlayImageView) < SightPlayImageView.d(localSightPlayImageView)) {
        break label247;
      }
      SightPlayImageView.c(localSightPlayImageView, a.fromDPToPix(localSightPlayImageView.getContext(), 150));
    }
    for (;;)
    {
      if (SightPlayImageView.e(localSightPlayImageView) > 0)
      {
        ViewGroup.LayoutParams localLayoutParams = localSightPlayImageView.getLayoutParams();
        if ((localLayoutParams.width != SightPlayImageView.e(localSightPlayImageView)) || (localLayoutParams.height != SightPlayImageView.e(localSightPlayImageView) * paramInt2 / paramInt1))
        {
          localLayoutParams.width = SightPlayImageView.e(localSightPlayImageView);
          localLayoutParams.height = (SightPlayImageView.e(localSightPlayImageView) * paramInt2 / paramInt1);
          ai.d(new SightPlayImageView.a.1(this, localSightPlayImageView, localLayoutParams));
          localSightPlayImageView.postInvalidate();
        }
        y.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      }
      y.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(SightPlayImageView.e(localSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      label247:
      SightPlayImageView.c(localSightPlayImageView, a.fromDPToPix(localSightPlayImageView.getContext(), 85));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView.a
 * JD-Core Version:    0.7.0.1
 */