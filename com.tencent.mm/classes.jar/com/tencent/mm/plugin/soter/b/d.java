package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class d
  extends m
  implements k
{
  private h snM;
  
  public abstract void bzB();
  
  public abstract void d(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 1;
    ab.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.snM = new h(new d.a(this, (byte)0));
    this.snM.snP = -3202;
    paramArrayOfByte = this.snM;
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
      if ((paramInt2 == 4) && (paramInt3 == paramArrayOfByte.snP))
      {
        paramInt1 = i;
        if (paramArrayOfByte.snO != null)
        {
          paramArrayOfByte.snO.cxR();
          paramInt1 = i;
        }
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  public abstract void wf(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.d
 * JD-Core Version:    0.7.0.1
 */