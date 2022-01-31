package com.tencent.mm.plugin.n;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;

final class j$2
  implements ak.a
{
  j$2(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(117893);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(117893);
      return false;
      if (this.oFs.oFm.prepare())
      {
        this.oFs.aNP = this.oFs.oFm.aNP;
        j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
      }
      else
      {
        this.oFs.oEO.obtainMessage(5, -1, -1).sendToTarget();
        AppMethodBeat.o(117893);
        return false;
        paramMessage = this.oFs.oEN;
        long l = bo.av(paramMessage.oEH);
        if ((paramMessage.oEH > 0L) && (l >= 30L))
        {
          ab.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramMessage.bau(), Long.valueOf(paramMessage.oEH), Long.valueOf(l) });
          paramMessage.oEI = 0L;
        }
        if (d.zd(this.oFs.oFm.state))
        {
          this.oFs.oFj.obtainMessage(9).sendToTarget();
          this.oFs.oFh.removeMessages(2);
        }
        else
        {
          int j = this.oFs.oFm.O(this.oFs.axe, this.oFs.oFk);
          if (d.yZ(j)) {
            this.oFs.oFj.obtainMessage(2).sendToTarget();
          }
          if (j == 7) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label346;
            }
            this.oFs.oFj.obtainMessage(7).sendToTarget();
            this.oFs.oFh.removeMessages(2);
            break;
          }
          label346:
          if (d.zf(j))
          {
            j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
            this.oFs.oEN.oEH = bo.yB();
          }
          else
          {
            if (this.oFs.state == 3) {
              j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), this.oFs.oEN.oEI);
            }
            for (;;)
            {
              this.oFs.oEN.oEH = bo.yB();
              break;
              if (this.oFs.state == 5) {
                j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
              } else if (this.oFs.state == 1) {
                j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
              } else if (this.oFs.state == 0) {
                j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
              } else if (this.oFs.state == 6) {
                j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
              } else {
                this.oFs.oFh.removeMessages(2);
              }
            }
            this.oFs.zj(3);
            this.oFs.oFm.start();
            j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
            continue;
            this.oFs.zj(4);
            j.a(this.oFs, this.oFs.oFh, SystemClock.elapsedRealtime(), 0L);
            this.oFs.oFm.pause();
            continue;
            this.oFs.oFm.release();
            this.oFs.oFl = true;
            this.oFs.oFj.obtainMessage(0).sendToTarget();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.j.2
 * JD-Core Version:    0.7.0.1
 */