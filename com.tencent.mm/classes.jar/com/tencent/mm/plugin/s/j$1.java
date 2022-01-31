package com.tencent.mm.plugin.s;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.y;

final class j$1
  implements ah.a
{
  j$1(j paramj) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    y.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { this.meT.mep.ayN(), Integer.valueOf(i), Integer.valueOf(this.meT.state), Integer.valueOf(this.meT.meN.state) });
    switch (i)
    {
    }
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return false;
          if (this.meT.state < 2) {}
          for (i = 1; i != 0; i = 0)
          {
            bool2 = d.tH(this.meT.meN.state);
            bool1 = bool2;
            if (this.meT.meP != null) {
              bool1 = bool2 & d.tH(this.meT.meP.state);
            }
            if (!bool1) {
              break;
            }
            this.meT.setState(2);
            this.meT.meq.obtainMessage(1).sendToTarget();
            return false;
          }
          j.a(this.meT);
          return false;
        } while (d.tK(this.meT.state));
        if ((d.tL(this.meT.state)) || (d.tJ(this.meT.state)))
        {
          this.meT.setState(9);
          this.meT.meq.obtainMessage(2).sendToTarget();
          return false;
        }
        boolean bool2 = d.tK(this.meT.meN.state);
        bool1 = bool2;
        if (this.meT.meP != null) {
          bool1 = bool2 & d.tK(this.meT.meP.state);
        }
      } while (!bool1);
      this.meT.setState(9);
      this.meT.meq.obtainMessage(2).sendToTarget();
      return false;
    } while ((!this.meT.meM) || ((!this.meT.dnJ) && (!this.meT.meO)));
    this.meT.meq.obtainMessage(6).sendToTarget();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.j.1
 * JD-Core Version:    0.7.0.1
 */