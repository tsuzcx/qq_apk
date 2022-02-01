package com.tencent.mm.wallet_core.d;

import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class c<T extends d>
  implements f
{
  public f LyS;
  T LyT;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    ad.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.ajD();
    g.ajB().gAO.a(this.rtType, this);
    a(paramd);
  }
  
  public final void ebV()
  {
    ad.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.ajD();
    g.ajB().gAO.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    ad.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if (((paramn instanceof d)) && (!a(paramInt1, paramInt2, (d)paramn)) && (this.LyS != null) && (this.LyT != null) && ((this.LyT instanceof n))) {
      this.LyS.onSceneEnd(paramInt1, paramInt2, paramString, (n)this.LyT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */