package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends e
{
  private boolean qmp = false;
  private boolean qmq;
  
  public b(com.tencent.mm.plugin.wallet_core.model.p paramp, Orders paramOrders)
  {
    super(paramp, paramOrders);
    bTS();
  }
  
  private void bTS()
  {
    this.qmp = false;
    com.tencent.mm.plugin.wallet.a.p.bTK();
    if ((com.tencent.mm.plugin.wallet.a.p.bTL().qzj != null) && (this.qmr.nqa != null))
    {
      String str = this.qmr.mOb;
      com.tencent.mm.plugin.wallet.a.p.bTK();
      if (str.equals(com.tencent.mm.plugin.wallet.a.p.bTL().qzj.field_bankcardType))
      {
        if ((this.qmr.nqa.bUV != 31) && (this.qmr.nqa.bUV != 32) && (this.qmr.nqa.bUV != 33) && (this.qmr.nqa.bUV != 42) && (this.qmr.nqa.bUV != 37)) {
          break label168;
        }
        this.qmp = true;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[] { Boolean.valueOf(this.qmp), Boolean.valueOf(this.qmq) });
      return;
      label168:
      this.qmq = true;
    }
  }
  
  public final int HH()
  {
    bTS();
    if (this.qmp) {
      return 1281;
    }
    if (this.qmq) {
      return 1305;
    }
    return 1601;
  }
  
  protected final void P(Map<String, String> paramMap)
  {
    bTS();
    if ((this.qmp) || (this.qmq)) {
      paramMap.put("busi_scene", this.qmr.mOb);
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    if (this.qmp) {
      h.nFQ.a(663L, 26L, 1L, false);
    }
    for (;;)
    {
      return super.a(parame, paramf);
      if (this.qmq) {
        h.nFQ.a(663L, 22L, 1L, false);
      }
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramString, paramJSONObject);
    if (paramInt != 0)
    {
      if (!this.qmp) {
        break label33;
      }
      h.nFQ.a(663L, 27L, 1L, false);
    }
    label33:
    while (!this.qmq) {
      return;
    }
    h.nFQ.a(663L, 23L, 1L, false);
  }
  
  public final int aEC()
  {
    return 121;
  }
  
  public final String getUri()
  {
    bTS();
    if (this.qmp) {
      return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }
    if (this.qmq) {
      return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
    }
    return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.d.b
 * JD-Core Version:    0.7.0.1
 */