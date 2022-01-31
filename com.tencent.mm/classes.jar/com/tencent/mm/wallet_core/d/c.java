package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c<T extends d>
  implements f
{
  T AXA;
  public f AXz;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    ab.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.RM();
    g.RK().eHt.a(this.rtType, this);
    a(paramd);
  }
  
  public final void bOo()
  {
    ab.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.RM();
    g.RK().eHt.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    ab.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if (((paramm instanceof d)) && (!a(paramInt1, paramInt2, (d)paramm)) && (this.AXz != null) && (this.AXA != null) && ((this.AXA instanceof m))) {
      this.AXz.onSceneEnd(paramInt1, paramInt2, paramString, (m)this.AXA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */