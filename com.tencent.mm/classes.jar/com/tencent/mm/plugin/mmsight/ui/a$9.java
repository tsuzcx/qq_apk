package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class a$9
  implements c.a
{
  a$9(a parama) {}
  
  public final void hw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
      ai.d(new Runnable()
      {
        public final void run()
        {
          if (a.9.this.mpw.dnV != null) {
            a.9.this.mpw.dnV.dismiss();
          }
          if (a.9.this.mpw.mpn != null) {
            a.9.this.mpw.mpn.onError();
          }
        }
      });
    }
    while (this.mpw.mpd == null) {
      return;
    }
    this.mpw.mpf = this.mpw.mpd.getDurationMs();
    y.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", new Object[] { Integer.valueOf(this.mpw.mpf) });
    try
    {
      if (this.mpw.mlw != null)
      {
        this.mpw.mpg = Math.round(this.mpw.mpf * this.mpw.mpd.bjK());
        this.mpw.mph = Math.round(this.mpw.mpf * this.mpw.mpd.bjL());
        if (this.mpw.mph <= 0) {
          if (this.mpw.mpf > this.mpw.mgW.duration * 1000 + 500) {
            break label286;
          }
        }
      }
      label286:
      for (this.mpw.mph = this.mpw.mpf;; this.mpw.mph = (this.mpw.mgW.duration * 1000))
      {
        y.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", new Object[] { Integer.valueOf(this.mpw.mpg), Integer.valueOf(this.mpw.mph), Integer.valueOf(this.mpw.mpf) });
        a locala = this.mpw;
        locala.mpi = new am(Looper.getMainLooper(), new a.12(locala), true);
        locala.mpi.S(20L, 20L);
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.9
 * JD-Core Version:    0.7.0.1
 */