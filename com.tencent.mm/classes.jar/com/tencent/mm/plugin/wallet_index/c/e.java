package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class e
  extends s
{
  private b dmK;
  private f dmL;
  public int errCode;
  public aqe qLk;
  public aqf qLl;
  
  public e(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aaz();
    ((b.a)localObject).ecI = new aba();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((b.a)localObject).ecG = 1130;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aaz)this.dmK.ecE.ecN;
    ((aaz)localObject).bOL = paramString1;
    ((aaz)localObject).taw = paramInt1;
    ((aaz)localObject).tay = Integer.parseInt(paramString2);
    ((aaz)localObject).desc = paramString3;
    ((aaz)localObject).count = paramInt2;
    ((aaz)localObject).scene = 13;
    ((aaz)localObject).taz = paramString4;
    ((aaz)localObject).taA = paramString5;
    ((aaz)localObject).sign = paramString6;
    ((aaz)localObject).taB = paramString7;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg:" + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      return;
    }
    paramString = (aba)this.dmK.ecF.ecN;
    y.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.bPH + ",errMsg:" + paramString.bPI);
    paramInt2 = paramString.bPH;
    paramq = paramString.bPI;
    if (paramInt2 == 0)
    {
      this.qLk = paramString.taC;
      this.qLl = paramString.taD;
    }
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramq, this);
  }
  
  public final int getType()
  {
    return 1130;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.e
 * JD-Core Version:    0.7.0.1
 */