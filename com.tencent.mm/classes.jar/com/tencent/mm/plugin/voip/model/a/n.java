package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class n<REQ, RESP>
  extends com.tencent.mm.al.n
  implements k
{
  protected l Cbq = m.ewp();
  f callback;
  protected b rr;
  private f tnv;
  
  public int doScene(e parame, f paramf)
  {
    int i = eye();
    if (i != 0) {
      return i;
    }
    this.tnv = paramf;
    this.callback = eyd();
    return dispatch(parame, this.rr, this);
  }
  
  public abstract f eyd();
  
  public int eye()
  {
    return 0;
  }
  
  public final void eyg()
  {
    ad.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    g.aiU().a(this, 0);
  }
  
  public final <RESP> RESP eyh()
  {
    return this.rr.hNL.hNQ;
  }
  
  public final <REQ> REQ eyi()
  {
    return this.rr.hNK.hNQ;
  }
  
  public void it(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    it(paramInt2, paramInt3);
    if (this.tnv != null) {
      this.tnv.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115258);
          if (n.this.callback != null) {
            n.this.callback.onSceneEnd(paramInt2, paramInt3, paramString, n.this);
          }
          AppMethodBeat.o(115258);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */