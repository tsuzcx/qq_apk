package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.i.b;

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
    Log.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
    Bitmap localBitmap2 = d.a(this.UKr.luk, false, -1, null);
    if ((localBitmap2 == null) || (this.UKr.thl == null))
    {
      AppMethodBeat.o(115367);
      return;
    }
    int i = 0;
    while (((this.UKr.thl.getHeight() == 0) || (this.UKr.thl.getWidth() == 0)) && (i < 10)) {
      try
      {
        Thread.sleep(300L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
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
    float f = aw.bf(MMApplicationContext.getContext()).y / aw.bf(MMApplicationContext.getContext()).x;
    i = (int)(localBitmap1.getHeight() / f);
    localBitmap1 = BitmapUtil.extractThumbNail(localBitmap1, localBitmap1.getHeight(), i, true, false);
    if (localBitmap1 == null)
    {
      Log.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
      AppMethodBeat.o(115367);
      return;
    }
    try
    {
      localBitmap1 = BitmapUtil.fastblur(localBitmap1, 20);
      Log.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
      this.UKr.qse.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115366);
          if (VoipBaseFragment.a.this.UKr.UKb != null)
          {
            VoipBaseFragment.a.this.UKr.UKb.setBackgroundDrawable(new BitmapDrawable(localBitmap1));
            VoipBaseFragment.a.this.UKr.UKb.getBackground().setAlpha(128);
          }
          VoipBaseFragment.a(VoipBaseFragment.a.this.UKr);
          AppMethodBeat.o(115366);
        }
      });
      AppMethodBeat.o(115367);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + localException.getMessage());
      AppMethodBeat.o(115367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.a
 * JD-Core Version:    0.7.0.1
 */