package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.protocal.c.bkm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class i
  extends s
{
  private b dmK;
  private f dmL;
  
  public i(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bkl();
    ((b.a)localObject).ecI = new bkm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
    ((b.a)localObject).ecG = 600;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bkl)this.dmK.ecE.ecN;
    ((bkl)localObject).tEk = paramString1;
    ((bkl)localObject).tEj = bk.getInt(paramString2, 0);
    ((bkl)localObject).sHl = com.tencent.mm.plugin.wallet_core.model.i.bVj();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.i
 * JD-Core Version:    0.7.0.1
 */