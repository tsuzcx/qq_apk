package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.s;

public final class b
  extends s
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public String jumpUrl;
  public int qro = 0;
  
  public b()
  {
    b.a locala = new b.a();
    bdl localbdl = new bdl();
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.urA, Boolean.valueOf(false));
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localbdl.tyC = i;
        locala.ecH = localbdl;
        locala.ecI = new bdm();
        locala.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        locala.ecG = 1564;
        locala.ecJ = 0;
        locala.ecK = 0;
        this.dmK = locala.Kt();
        return;
      }
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramq = (bdm)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.jxl), paramq.jxm });
      paramString = paramq.jxm;
      paramInt2 = paramq.jxl;
      this.jumpUrl = paramq.kRP;
      this.qro = paramq.tyD;
    }
    for (;;)
    {
      paramq = paramString;
      if (bk.bl(paramString)) {
        paramq = ae.getContext().getString(a.i.wallet_data_err);
      }
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramq, this);
      return;
      y.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
      this.jumpUrl = null;
    }
  }
  
  public final int getType()
  {
    return 1564;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.b
 * JD-Core Version:    0.7.0.1
 */