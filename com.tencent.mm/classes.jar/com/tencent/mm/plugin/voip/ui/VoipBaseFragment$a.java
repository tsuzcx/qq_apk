package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.ai;

public final class VoipBaseFragment$a
  extends b
{
  public VoipBaseFragment$a(VoipBaseFragment paramVoipBaseFragment) {}
  
  public final String getKey()
  {
    return "VoipBaseFragment_blurbitmap";
  }
  
  public final void run()
  {
    AppMethodBeat.i(115367);
    ad.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
    Bitmap localBitmap2 = c.a(this.zrA.flk, false, -1, null);
    if ((localBitmap2 == null) || (this.zrA.vHU == null))
    {
      AppMethodBeat.o(115367);
      return;
    }
    int i = 0;
    while (((this.zrA.vHU.getHeight() == 0) || (this.zrA.vHU.getWidth() == 0)) && (i < 10)) {
      try
      {
        Thread.sleep(300L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        ad.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
        AppMethodBeat.o(115367);
        return;
      }
    }
    final Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2.getHeight() <= localBitmap2.getWidth())
    {
      localBitmap1 = localBitmap2;
      if (localBitmap2.getHeight() / 5 > 0)
      {
        localBitmap1 = localBitmap2;
        if ((int)(localBitmap2.getHeight() * 0.6D) > 0) {
          localBitmap1 = Bitmap.createBitmap(localBitmap2, localBitmap2.getWidth() / 5, localBitmap2.getHeight() / 5, (int)(localBitmap2.getHeight() * 0.6D), (int)(localBitmap2.getHeight() * 0.6D), null, false);
        }
      }
    }
    float f = ai.cf(aj.getContext()).y / ai.cf(aj.getContext()).x;
    i = (int)(localBitmap1.getHeight() / f);
    localBitmap1 = f.a(localBitmap1, localBitmap1.getHeight(), i, true, false);
    if (localBitmap1 == null)
    {
      ad.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
      AppMethodBeat.o(115367);
      return;
    }
    try
    {
      localBitmap1 = f.l(localBitmap1, 20);
      ad.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
      this.zrA.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115366);
          if (VoipBaseFragment.a.this.zrA.zrs != null)
          {
            VoipBaseFragment.a.this.zrA.zrs.setBackgroundDrawable(new BitmapDrawable(localBitmap1));
            VoipBaseFragment.a.this.zrA.zrs.getBackground().setAlpha(128);
          }
          VoipBaseFragment.a(VoipBaseFragment.a.this.zrA);
          AppMethodBeat.o(115366);
        }
      });
      AppMethodBeat.o(115367);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + localException.getMessage());
      AppMethodBeat.o(115367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.a
 * JD-Core Version:    0.7.0.1
 */