package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
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
  com.tencent.mm.al.g callback;
  private com.tencent.mm.al.g ria;
  protected b rr;
  protected l zjH = m.dTs();
  
  public abstract com.tencent.mm.al.g dVg();
  
  public int dVh()
  {
    return 0;
  }
  
  public final void dVj()
  {
    ad.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    com.tencent.mm.kernel.g.aeS().a(this, 0);
  }
  
  public final <RESP> RESP dVk()
  {
    return this.rr.gUT.gUX;
  }
  
  public final <REQ> REQ dVl()
  {
    return this.rr.gUS.gUX;
  }
  
  public int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    int i = dVh();
    if (i != 0) {
      return i;
    }
    this.ria = paramg;
    this.callback = dVg();
    return dispatch(parame, this.rr, this);
  }
  
  public void hR(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    hR(paramInt2, paramInt3);
    if (this.ria != null) {
      this.ria.onSceneEnd(paramInt2, paramInt3, paramString, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */