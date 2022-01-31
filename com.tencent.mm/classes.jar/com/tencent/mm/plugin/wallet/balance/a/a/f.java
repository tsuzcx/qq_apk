package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.bhj;
import com.tencent.mm.protocal.c.bhk;

public final class f
  extends a<bhk>
{
  public f(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bhj();
    ((b.a)localObject).ecI = new bhk();
    ((b.a)localObject).ecG = 1283;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localObject = ((b.a)localObject).Kt();
    bhj localbhj = (bhj)((b)localObject).ecE.ecN;
    localbhj.tBQ = paramString1;
    localbhj.nzq = paramString2;
    localbhj.tBh = paramInt1;
    localbhj.sOy = paramInt2;
    this.dmK = ((b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.f
 * JD-Core Version:    0.7.0.1
 */