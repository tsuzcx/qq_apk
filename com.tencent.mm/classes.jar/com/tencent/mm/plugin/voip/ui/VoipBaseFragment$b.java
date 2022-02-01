package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

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
    Log.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
    final Bitmap localBitmap = BitmapUtil.getBitmapNative(b.c.voip_video_called_blur_background);
    Log.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
    this.NVB.ntw.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115368);
        if (VoipBaseFragment.b.this.NVB.NVu != null)
        {
          VoipBaseFragment.b.this.NVB.NVu.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          VoipBaseFragment.b.this.NVB.NVu.getBackground().setAlpha(230);
          VoipBaseFragment.b.this.NVB.NVu.getBackground().setFilterBitmap(true);
        }
        VoipBaseFragment.b(VoipBaseFragment.b.this.NVB);
        AppMethodBeat.o(115368);
      }
    });
    AppMethodBeat.o(115369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.b
 * JD-Core Version:    0.7.0.1
 */