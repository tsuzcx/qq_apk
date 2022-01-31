package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;

public final class f
  implements b
{
  private c qLx;
  private final int qMr = hashCode() & 0xFFFF;
  private d qMs = null;
  private com.tencent.mm.sdk.b.c qMt;
  
  public f(c paramc, com.tencent.mm.sdk.b.c paramc1)
  {
    this.qLx = paramc;
    this.qMt = paramc1;
    a.udP.c(this.qMt);
  }
  
  public final void a(MMActivity paramMMActivity, d paramd)
  {
    y.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.qLx.qLK), Integer.valueOf(paramMMActivity.getTaskId()) });
    w.cME();
    this.qMs = paramd;
    if (this.qLx.qLK)
    {
      if (this.qLx.qLl != null)
      {
        paramd = new g();
        paramd.appId = this.qLx.qLl.tml.app_id;
        paramd.timeStamp = this.qLx.qLl.tml.quW;
        paramd.nonceStr = this.qLx.qLl.tml.ivF;
        paramd.packageExt = this.qLx.qLl.tml.tya;
        paramd.signType = this.qLx.qLl.tml.ivD;
        paramd.bUT = this.qLx.qLl.tmk;
        paramd.bUV = this.qLx.qLl.bUV;
        h.a(paramMMActivity, paramd, this.qMr, null);
        return;
      }
      y.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      return;
    }
    paramd = new PayInfo();
    paramd.bMX = this.qLx.qLl.tmi;
    paramd.partnerId = this.qLx.qLl.tmj;
    paramd.ccR = this.qLx.qLl.tmk;
    paramd.bUV = 5;
    h.a(paramMMActivity, paramd, this.qMr);
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.b.aP(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.qLx.iZD, this.qLx.qLC, this.qLx.qLe, this.qLx.qLf));
    }
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramMMActivity = new StringBuilder("onPayEnd payResult : ").append(paramInt2).append(", data is null : ");
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      y.i("MicroMsg.WeiXinWallet", bool);
      if ((paramInt1 == this.qMr) && (this.qMs != null))
      {
        if (paramInt2 != -1) {
          break label171;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label161;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.aP(0, "");
      }
    }
    for (;;)
    {
      y.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.qLx.iZD, this.qLx.qLC, this.qLx.qLe, this.qLx.qLf);
      this.qMs.a(paramMMActivity, paramIntent);
      this.qMs = null;
      return true;
      bool = false;
      break;
      label161:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.aP(5, "");
      continue;
      label171:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.aP(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.aP(6, "");
      }
    }
  }
  
  public final int bXz()
  {
    return 2;
  }
  
  public final void c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", 0);
    localIntent.putExtra("key_err_msg", "");
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
  }
  
  public final void j(MMActivity paramMMActivity)
  {
    a.udP.d(this.qMt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */