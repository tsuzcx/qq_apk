package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.bfi;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.fu;

public final class d
  extends a<bfj>
{
  public d(int paramInt1, fu paramfu, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bfi();
    ((b.a)localObject).ecI = new bfj();
    ((b.a)localObject).ecG = 1324;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localObject = ((b.a)localObject).Kt();
    bfi localbfi = (bfi)((b)localObject).ecE.ecN;
    localbfi.tzY = paramInt1;
    if (paramfu != null) {
      localbfi.tzZ = 1;
    }
    for (localbfi.tAa = paramfu;; localbfi.tAa = null)
    {
      localbfi.sOy = paramInt2;
      localbfi.tAb = paramInt3;
      this.dmK = ((b)localObject);
      return;
      localbfi.tzZ = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.d
 * JD-Core Version:    0.7.0.1
 */