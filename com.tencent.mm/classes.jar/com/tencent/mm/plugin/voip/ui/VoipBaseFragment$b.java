package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
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
    ac.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
    final Bitmap localBitmap = f.Yo(2131234595);
    ac.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
    this.AKl.jdu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115368);
        if (VoipBaseFragment.b.this.AKl.AKe != null)
        {
          VoipBaseFragment.b.this.AKl.AKe.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          VoipBaseFragment.b.this.AKl.AKe.getBackground().setAlpha(230);
          VoipBaseFragment.b.this.AKl.AKe.getBackground().setFilterBitmap(true);
        }
        VoipBaseFragment.b(VoipBaseFragment.b.this.AKl);
        AppMethodBeat.o(115368);
      }
    });
    AppMethodBeat.o(115369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.b
 * JD-Core Version:    0.7.0.1
 */