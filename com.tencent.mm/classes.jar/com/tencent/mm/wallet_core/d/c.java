package com.tencent.mm.wallet_core.d;

import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<T extends d>
  implements i
{
  public i YVV;
  T YVW;
  public int rtType;
  
  protected abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public final void b(d paramd)
  {
    Log.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    h.aHH();
    h.aHF().kcd.a(this.rtType, this);
    a(paramd);
  }
  
  public final void fWn()
  {
    Log.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", new Object[] { Integer.valueOf(this.rtType) });
    h.aHH();
    h.aHF().kcd.b(this.rtType, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Log.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if (((paramq instanceof d)) && (!a(paramInt1, paramInt2, (d)paramq)) && (this.YVV != null) && (this.YVW != null) && ((this.YVW instanceof q))) {
      this.YVV.onSceneEnd(paramInt1, paramInt2, paramString, (q)this.YVW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */