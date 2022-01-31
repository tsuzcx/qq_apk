package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public abstract class n<REQ, RESP>
  extends m
  implements com.tencent.mm.network.k
{
  f callback;
  private f mKW;
  protected b rr;
  protected com.tencent.mm.plugin.voip.model.k tvE = l.cMn();
  
  public abstract f cOp();
  
  public int cOq()
  {
    return 0;
  }
  
  public final void cOs()
  {
    ab.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    g.Rc().a(this, 0);
  }
  
  public final <RESP> RESP cOt()
  {
    return this.rr.fsW.fta;
  }
  
  public final <REQ> REQ cOu()
  {
    return this.rr.fsV.fta;
  }
  
  public int doScene(e parame, f paramf)
  {
    int i = cOq();
    if (i != 0) {
      return i;
    }
    this.mKW = paramf;
    this.callback = cOp();
    return dispatch(parame, this.rr, this);
  }
  
  public void gk(int paramInt1, int paramInt2) {}
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    gk(paramInt2, paramInt3);
    if (this.mKW != null) {
      this.mKW.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.callback != null) {
      al.d(new n.1(this, paramInt2, paramInt3, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */