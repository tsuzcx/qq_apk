package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f
  implements b
{
  private final int DqQ;
  private c Dqk;
  private d Dru;
  private com.tencent.mm.sdk.b.c Drv;
  
  public f(c paramc, com.tencent.mm.sdk.b.c paramc1)
  {
    AppMethodBeat.i(71954);
    this.DqQ = (hashCode() & 0xFFFF);
    this.Dru = null;
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.Dqk = paramc;
    this.Drv = paramc1;
    a.IbL.c(this.Drv);
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    ad.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.Dqk.Dqx), Integer.valueOf(paramMMActivity.getTaskId()) });
    ab.fRA();
    this.Dru = paramd;
    if (this.Dqk.Dqx) {
      if (this.Dqk.DpW != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.Dqk.DpW.GKk.app_id;
        paramd.timeStamp = this.Dqk.DpW.GKk.CWf;
        paramd.nonceStr = this.Dqk.DpW.GKk.oIw;
        paramd.packageExt = this.Dqk.DpW.GKk.HaD;
        paramd.signType = this.Dqk.DpW.GKk.oIu;
        paramd.dCA = this.Dqk.DpW.GKj;
        paramd.dCC = this.Dqk.DpW.dCC;
        paramd.dnX = 33;
        paramd.Fmj = "key_from_scene_appbrandgame";
        paramd.dCD = this.DqQ;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.DqQ, null);
      }
    }
    for (;;)
    {
      ad.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.DqQ) });
      int i = this.DqQ;
      AppMethodBeat.o(71955);
      return i;
      ad.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      paramd = new PayInfo();
      paramd.dlu = this.Dqk.DpW.GKh;
      paramd.partnerId = this.Dqk.DpW.GKi;
      paramd.dMw = this.Dqk.DpW.GKj;
      paramd.dCC = 5;
      com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.DqQ);
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.b.cr(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.Dqk.pFG, this.Dqk.Dqp, this.Dqk.DpO, this.Dqk.DpP));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.DqQ;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ad.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.DqQ) && (this.Dru != null))
      {
        if (paramInt2 != -1) {
          break label195;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label185;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cr(0, "");
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.Dqk.pFG, this.Dqk.Dqp, this.Dqk.DpO, this.Dqk.DpP);
      this.Dru.a(paramMMActivity, paramIntent);
      this.Dru = null;
      AppMethodBeat.o(71956);
      return true;
      bool = false;
      break;
      label185:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cr(5, "");
      continue;
      label195:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cr(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cr(6, "");
      }
    }
  }
  
  public final void d(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(71958);
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", 0);
    localIntent.putExtra("key_err_msg", "");
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71958);
  }
  
  public final int eJa()
  {
    return 2;
  }
  
  public final void p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    a.IbL.d(this.Drv);
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */