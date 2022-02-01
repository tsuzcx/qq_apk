package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class c<T extends d>
  implements com.tencent.mm.ak.g
{
  public com.tencent.mm.ak.g JFO;
  T JFP;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    ac.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.rtType, this);
    a(paramd);
  }
  
  public final void dPE()
  {
    ac.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ac.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if (((paramn instanceof d)) && (!a(paramInt1, paramInt2, (d)paramn)) && (this.JFO != null) && (this.JFP != null) && ((this.JFP instanceof n))) {
      this.JFO.onSceneEnd(paramInt1, paramInt2, paramString, (n)this.JFP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */