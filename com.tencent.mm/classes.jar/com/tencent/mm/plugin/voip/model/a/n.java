package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public abstract class n<REQ, RESP>
  extends com.tencent.mm.ak.n
  implements k
{
  protected l CsR = m.ezW();
  f callback;
  protected b rr;
  private f tyn;
  
  public int doScene(e parame, f paramf)
  {
    int i = eBM();
    if (i != 0) {
      return i;
    }
    this.tyn = paramf;
    this.callback = eBL();
    return dispatch(parame, this.rr, this);
  }
  
  public abstract f eBL();
  
  public int eBM()
  {
    return 0;
  }
  
  public final void eBO()
  {
    ae.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    g.ajj().a(this, 0);
  }
  
  public final <RESP> RESP eBP()
  {
    return this.rr.hQE.hQJ;
  }
  
  public final <REQ> REQ eBQ()
  {
    return this.rr.hQD.hQJ;
  }
  
  public void ix(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ix(paramInt2, paramInt3);
    if (this.tyn != null) {
      this.tyn.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      ar.f(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */