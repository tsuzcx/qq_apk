package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.bgm;
import com.tencent.mm.protocal.c.bgn;
import com.tencent.mm.wallet_core.c.g;

public final class e
  extends a<bgn>
  implements g
{
  public e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bgm();
    ((b.a)localObject).ecI = new bgn();
    ((b.a)localObject).ecG = 1276;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localObject = ((b.a)localObject).Kt();
    bgm localbgm = (bgm)((b)localObject).ecE.ecN;
    localbgm.tBg = paramString1;
    localbgm.tBh = paramInt1;
    localbgm.sOy = paramInt2;
    localbgm.tBi = paramString2;
    this.dmK = ((b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.e
 * JD-Core Version:    0.7.0.1
 */