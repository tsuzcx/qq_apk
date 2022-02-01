package com.tencent.mm.wallet_core.c;

import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<T extends d>
  implements com.tencent.mm.am.h
{
  public com.tencent.mm.am.h agTP;
  T agTQ;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    Log.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.rtType, this);
    a(paramd);
  }
  
  public final void hoB()
  {
    Log.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Log.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if (((paramp instanceof d)) && (!a(paramInt1, paramInt2, (d)paramp)) && (this.agTP != null) && (this.agTQ != null) && ((this.agTQ instanceof p))) {
      this.agTP.onSceneEnd(paramInt1, paramInt2, paramString, (p)this.agTQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */