package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.protocal.c.qt;

public final class a
  extends com.tencent.mm.ah.a<qt>
{
  public a(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new qs();
    ((b.a)localObject).ecI = new qt();
    ((b.a)localObject).ecG = 1386;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localObject = ((b.a)localObject).Kt();
    qs localqs = (qs)((b)localObject).ecE.ecN;
    localqs.sOx = paramString;
    localqs.sOy = paramInt;
    this.dmK = ((b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.a
 * JD-Core Version:    0.7.0.1
 */