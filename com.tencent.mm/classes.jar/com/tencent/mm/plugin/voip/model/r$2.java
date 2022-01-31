package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.m.f;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class r$2
  implements Runnable
{
  r$2(r paramr, int paramInt, long paramLong) {}
  
  public final void run()
  {
    y.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(this.pzR), Long.valueOf(this.pzS) });
    if ((!f.zR()) && (!r.em(ae.getContext()))) {
      y.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
    }
    do
    {
      return;
      if (!this.pTG.pTq.bRp()) {
        break;
      }
      y.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
    } while ((this.pTG.pTq.pNq.pQe.lpD == this.pzR) || (this.pTG.pTq.pNq.pQe.lpE == this.pzS));
    y.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(this.pzR), Long.valueOf(this.pzS), Integer.valueOf(this.pTG.pTq.pNq.pQe.lpD), Long.valueOf(this.pTG.pTq.pNq.pQe.lpE) });
    s locals = this.pTG.pTq;
    s.a(this.pzR, this.pzS, 2, null, null, r.b(this.pTG));
    return;
    new e(this.pzR, this.pzS, "").bRB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r.2
 * JD-Core Version:    0.7.0.1
 */