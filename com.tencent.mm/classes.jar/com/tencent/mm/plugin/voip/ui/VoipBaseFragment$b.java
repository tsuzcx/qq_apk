package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;

public final class VoipBaseFragment$b
  extends b
{
  public VoipBaseFragment$b(VoipBaseFragment paramVoipBaseFragment) {}
  
  public final String getKey()
  {
    return "VoipBaseFragment_blurtransparentbitmap";
  }
  
  public final void run()
  {
    AppMethodBeat.i(115369);
    ad.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
    final Bitmap localBitmap = f.Wf(2131234595);
    ad.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
    this.zrA.iDu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115368);
        if (VoipBaseFragment.b.this.zrA.zrt != null)
        {
          VoipBaseFragment.b.this.zrA.zrt.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          VoipBaseFragment.b.this.zrA.zrt.getBackground().setAlpha(230);
          VoipBaseFragment.b.this.zrA.zrt.getBackground().setFilterBitmap(true);
        }
        VoipBaseFragment.b(VoipBaseFragment.b.this.zrA);
        AppMethodBeat.o(115368);
      }
    });
    AppMethodBeat.o(115369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.b
 * JD-Core Version:    0.7.0.1
 */