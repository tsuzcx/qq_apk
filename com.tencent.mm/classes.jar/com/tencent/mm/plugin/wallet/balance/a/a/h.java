package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.wallet_core.c.g;

public final class h
  extends a<bjw>
  implements g
{
  public h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bjv();
    ((b.a)localObject).ecI = new bjw();
    ((b.a)localObject).ecG = 1338;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localObject = ((b.a)localObject).Kt();
    bjv localbjv = (bjv)((b)localObject).ecE.ecN;
    localbjv.tzY = paramInt1;
    localbjv.sOx = paramString1;
    localbjv.tAc = paramString2;
    localbjv.sOy = paramInt2;
    this.dmK = ((b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.h
 * JD-Core Version:    0.7.0.1
 */