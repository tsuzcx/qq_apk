package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<T extends d>
  implements i
{
  public i Rux;
  T Ruy;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    Log.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.aAi();
    g.aAg().hqi.a(this.rtType, this);
    a(paramd);
  }
  
  public final void fib()
  {
    Log.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    g.aAi();
    g.aAg().hqi.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if (((paramq instanceof d)) && (!a(paramInt1, paramInt2, (d)paramq)) && (this.Rux != null) && (this.Ruy != null) && ((this.Ruy instanceof q))) {
      this.Rux.onSceneEnd(paramInt1, paramInt2, paramString, (q)this.Ruy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */