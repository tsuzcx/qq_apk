package com.tencent.mm.plugin.s;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;

final class j$3
  implements ah.a
{
  j$3(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (this.meT.meP == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    case 5: 
    case 6: 
    default: 
      return false;
    case 1: 
      if (!this.meT.meP.prepare()) {
        this.meT.meP = null;
      }
      j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), 0L);
      return false;
    case 2: 
      if (d.tK(this.meT.meP.state))
      {
        this.meT.meK.obtainMessage(9).sendToTarget();
        this.meT.meJ.removeMessages(2);
        return false;
      }
      if (d.tH(this.meT.meP.C(this.meT.auM, this.meT.meL))) {
        this.meT.meK.sendMessageDelayed(this.meT.meK.obtainMessage(2), 10L);
      }
      if (this.meT.state == 3)
      {
        j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), this.meT.mep.mek);
        return false;
      }
      if (this.meT.state == 5)
      {
        j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), 0L);
        return false;
      }
      if (this.meT.state == 1)
      {
        j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), 0L);
        return false;
      }
      if (this.meT.state == 0)
      {
        j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), 0L);
        return false;
      }
      this.meT.meJ.removeMessages(2);
      return false;
    case 3: 
      this.meT.meP.start();
      j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), 0L);
      return false;
    case 4: 
      j.a(this.meT, this.meT.meJ, SystemClock.elapsedRealtime(), 0L);
      this.meT.meP.pause();
      return false;
    }
    this.meT.meP.release();
    this.meT.meO = true;
    this.meT.meK.obtainMessage(0).sendToTarget();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.j.3
 * JD-Core Version:    0.7.0.1
 */