package com.tencent.mm.plugin.s;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class j$2
  implements ah.a
{
  j$2(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 6: 
    default: 
      return false;
    case 1: 
      if (this.meT.meN.prepare())
      {
        this.meT.aGU = this.meT.meN.aGU;
        j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
        return false;
      }
      this.meT.meq.obtainMessage(5, -1, -1).sendToTarget();
      return false;
    case 2: 
      paramMessage = this.meT.mep;
      long l = bk.cp(paramMessage.mej);
      if ((paramMessage.mej > 0L) && (l >= 30L))
      {
        y.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramMessage.ayN(), Long.valueOf(paramMessage.mej), Long.valueOf(l) });
        paramMessage.mek = 0L;
      }
      if (d.tK(this.meT.meN.state))
      {
        this.meT.meK.obtainMessage(9).sendToTarget();
        this.meT.meI.removeMessages(2);
        return false;
      }
      int j = this.meT.meN.C(this.meT.auM, this.meT.meL);
      if (d.tH(j)) {
        this.meT.meK.obtainMessage(2).sendToTarget();
      }
      if (j == 7) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.meT.meK.obtainMessage(7).sendToTarget();
        this.meT.meI.removeMessages(2);
        return false;
      }
      if (d.tM(j))
      {
        j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
        this.meT.mep.mej = bk.UZ();
        return false;
      }
      if (this.meT.state == 3) {
        j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), this.meT.mep.mek);
      }
      for (;;)
      {
        this.meT.mep.mej = bk.UZ();
        return false;
        if (this.meT.state == 5) {
          j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
        } else if (this.meT.state == 1) {
          j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
        } else if (this.meT.state == 0) {
          j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
        } else if (this.meT.state == 6) {
          j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
        } else {
          this.meT.meI.removeMessages(2);
        }
      }
    case 3: 
      this.meT.tQ(3);
      this.meT.meN.start();
      j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
      return false;
    case 4: 
      this.meT.tQ(4);
      j.a(this.meT, this.meT.meI, SystemClock.elapsedRealtime(), 0L);
      this.meT.meN.pause();
      return false;
    }
    this.meT.meN.release();
    this.meT.meM = true;
    this.meT.meK.obtainMessage(0).sendToTarget();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.s.j.2
 * JD-Core Version:    0.7.0.1
 */