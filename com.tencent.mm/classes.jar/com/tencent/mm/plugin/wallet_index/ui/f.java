package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f
  implements b
{
  private c Axw;
  private d AyF;
  private com.tencent.mm.sdk.b.c AyG;
  private final int Ayb;
  
  public f(c paramc, com.tencent.mm.sdk.b.c paramc1)
  {
    AppMethodBeat.i(71954);
    this.Ayb = (hashCode() & 0xFFFF);
    this.AyF = null;
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.Axw = paramc;
    this.AyG = paramc1;
    a.ESL.c(this.AyG);
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    ad.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.Axw.AxJ), Integer.valueOf(paramMMActivity.getTaskId()) });
    ab.fka();
    this.AyF = paramd;
    if (this.Axw.AxJ) {
      if (this.Axw.Axk != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.Axw.Axk.DFr.app_id;
        paramd.timeStamp = this.Axw.Axk.DFr.Adv;
        paramd.nonceStr = this.Axw.Axk.DFr.nCc;
        paramd.packageExt = this.Axw.Axk.DFr.DUg;
        paramd.signType = this.Axw.Axk.DFr.nCa;
        paramd.dsZ = this.Axw.Axk.DFq;
        paramd.dtb = this.Axw.Axk.dtb;
        paramd.dfg = 33;
        paramd.CoK = "key_from_scene_appbrandgame";
        paramd.dtc = this.Ayb;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.Ayb, null);
      }
    }
    for (;;)
    {
      ad.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.Ayb) });
      int i = this.Ayb;
      AppMethodBeat.o(71955);
      return i;
      ad.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      paramd = new PayInfo();
      paramd.dcE = this.Axw.Axk.DFo;
      paramd.partnerId = this.Axw.Axk.DFp;
      paramd.dCx = this.Axw.Axk.DFq;
      paramd.dtb = 5;
      com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.Ayb);
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.b.cg(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.Axw.oyw, this.Axw.AxB, this.Axw.Axc, this.Axw.Axd));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.Ayb;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ad.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.Ayb) && (this.AyF != null))
      {
        if (paramInt2 != -1) {
          break label195;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label185;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cg(0, "");
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.Axw.oyw, this.Axw.AxB, this.Axw.Axc, this.Axw.Axd);
      this.AyF.a(paramMMActivity, paramIntent);
      this.AyF = null;
      AppMethodBeat.o(71956);
      return true;
      bool = false;
      break;
      label185:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cg(5, "");
      continue;
      label195:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cg(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cg(6, "");
      }
    }
  }
  
  public final void c(MMActivity paramMMActivity, boolean paramBoolean)
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
  
  public final int efA()
  {
    return 2;
  }
  
  public final void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    ad.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    a.ESL.d(this.AyG);
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */