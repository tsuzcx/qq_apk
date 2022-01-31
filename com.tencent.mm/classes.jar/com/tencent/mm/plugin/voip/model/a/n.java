package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public abstract class n<REQ, RESP>
  extends m
  implements com.tencent.mm.network.k
{
  protected b dmK;
  f dmL;
  private f kpj;
  protected j pQA = com.tencent.mm.plugin.voip.model.k.bQj();
  
  public final int a(e parame, f paramf)
  {
    int i = bRz();
    if (i != 0) {
      return i;
    }
    this.kpj = paramf;
    this.dmL = bRy();
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    em(paramInt2, paramInt3);
    if (this.kpj != null) {
      this.kpj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.dmL != null) {
      ai.d(new n.1(this, paramInt2, paramInt3, paramString));
    }
  }
  
  public final void bRB()
  {
    y.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    g.Dk().a(this, 0);
  }
  
  public final <RESP> RESP bRC()
  {
    return this.dmK.ecF.ecN;
  }
  
  public final <REQ> REQ bRD()
  {
    return this.dmK.ecE.ecN;
  }
  
  public abstract f bRy();
  
  public int bRz()
  {
    return 0;
  }
  
  public void em(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.n
 * JD-Core Version:    0.7.0.1
 */