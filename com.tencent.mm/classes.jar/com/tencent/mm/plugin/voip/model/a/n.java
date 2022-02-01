package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class n<REQ, RESP>
  extends com.tencent.mm.ak.n
  implements k
{
  protected l ACr = m.eiE();
  com.tencent.mm.ak.g callback;
  protected b rr;
  private com.tencent.mm.ak.g sqT;
  
  public int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    int i = ekt();
    if (i != 0) {
      return i;
    }
    this.sqT = paramg;
    this.callback = eks();
    return dispatch(parame, this.rr, this);
  }
  
  public abstract com.tencent.mm.ak.g eks();
  
  public int ekt()
  {
    return 0;
  }
  
  public final void ekv()
  {
    ac.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    com.tencent.mm.kernel.g.agi().a(this, 0);
  }
  
  public final <RESP> RESP ekw()
  {
    return this.rr.hvs.hvw;
  }
  
  public final <REQ> REQ ekx()
  {
    return this.rr.hvr.hvw;
  }
  
  public void ig(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, final String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ig(paramInt2, paramInt3);
    if (this.sqT != null) {
      this.sqT.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      ap.f(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */