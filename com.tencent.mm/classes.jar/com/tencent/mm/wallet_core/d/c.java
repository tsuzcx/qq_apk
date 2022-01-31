package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

public abstract class c<T extends d>
  implements f
{
  public int rtType;
  public f wBb;
  T wBc;
  
  public abstract void a(d paramd);
  
  public abstract boolean a(int paramInt1, int paramInt2, T paramT);
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if (((paramm instanceof d)) && (!a(paramInt1, paramInt2, (d)paramm)) && (this.wBb != null) && (this.wBc != null) && ((this.wBc instanceof m))) {
      this.wBb.onSceneEnd(paramInt1, paramInt2, paramString, (m)this.wBc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.c
 * JD-Core Version:    0.7.0.1
 */