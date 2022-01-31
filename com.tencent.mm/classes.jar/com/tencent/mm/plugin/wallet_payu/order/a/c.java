package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.c.bef;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class c
  extends s
{
  private b dmK;
  private f dmL;
  public bdv qNE = null;
  
  public c(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bef();
    ((b.a)localObject).ecI = new beg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
    ((b.a)localObject).ecG = 1520;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bef)this.dmK.ecE.ecN;
    if (!bk.bl(paramString)) {
      ((bef)localObject).mPI = paramString;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (beg)((b)paramq).ecF.ecN;
      this.qNE = paramString.tzm;
      if (paramString.tzm != null) {
        y.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + paramString.tzm.mPI);
      }
    }
    else
    {
      return;
    }
    y.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
  }
  
  public final int getType()
  {
    return 1520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.c
 * JD-Core Version:    0.7.0.1
 */