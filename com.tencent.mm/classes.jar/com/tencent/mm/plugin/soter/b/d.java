package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;

public abstract class d
  extends m
  implements k
{
  private h prK;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 1;
    y.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.prK = new h(new d.a(this, (byte)0));
    this.prK.prN = -3202;
    paramArrayOfByte = this.prK;
    if ((paramInt2 == 4) && (paramInt3 == -3200))
    {
      com.tencent.soter.a.a.a(new h.1(paramArrayOfByte), true, new f());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        d(paramInt2, paramInt3, paramString, paramq);
      }
      return;
      if ((paramInt2 == 4) && (paramInt3 == paramArrayOfByte.prN))
      {
        paramInt1 = i;
        if (paramArrayOfByte.prM != null)
        {
          paramArrayOfByte.prM.bKF();
          paramInt1 = i;
        }
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  public abstract void aTg();
  
  public abstract void d(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract void rl(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.d
 * JD-Core Version:    0.7.0.1
 */