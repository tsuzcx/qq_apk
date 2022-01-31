package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.TimerTask;

final class f$3
  extends TimerTask
{
  f$3(f paramf) {}
  
  public final void run()
  {
    if ((this.mtZ.bli() >= 45000L) && (this.mtZ.mtG != e.mwa)) {
      ai.d(new f.3.1(this));
    }
    if (this.mtZ.mtG == e.mwa)
    {
      f localf = this.mtZ;
      localf.mtK += 1;
      ai.d(new Runnable()
      {
        public final void run()
        {
          if (f.3.this.mtZ.mtG == e.mwa)
          {
            com.tencent.mm.plugin.voip.b.bPy().yg(f.3.this.mtZ.mtK);
            if (f.3.this.mtZ.mtQ != null) {
              f.3.this.mtZ.mtQ.bbQ();
            }
          }
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.3
 * JD-Core Version:    0.7.0.1
 */