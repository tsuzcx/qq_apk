package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class c<T extends d>
  implements f
{
  public f LVH;
  T LVI;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    ae.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.ajS();
    g.ajQ().gDv.a(this.rtType, this);
    a(paramd);
  }
  
  public final void efC()
  {
    ae.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.ajS();
    g.ajQ().gDv.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ae.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if (((paramn instanceof d)) && (!a(paramInt1, paramInt2, (d)paramn)) && (this.LVH != null) && (this.LVI != null) && ((this.LVI instanceof n))) {
      this.LVH.onSceneEnd(paramInt1, paramInt2, paramString, (n)this.LVI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */