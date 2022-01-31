package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class b
  extends s
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private String qjr;
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      p.bTK();
      p.bTL();
      ag.Qu(this.qjr);
    }
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 621;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.b
 * JD-Core Version:    0.7.0.1
 */