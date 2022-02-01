package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f
  implements b
{
  private c DHQ;
  private d DIZ;
  private final int DIv;
  private com.tencent.mm.sdk.b.c DJa;
  
  public f(c paramc, com.tencent.mm.sdk.b.c paramc1)
  {
    AppMethodBeat.i(71954);
    this.DIv = (hashCode() & 0xFFFF);
    this.DIZ = null;
    ae.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.DHQ = paramc;
    this.DJa = paramc1;
    a.IvT.c(this.DJa);
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    ae.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.DHQ.DId), Integer.valueOf(paramMMActivity.getTaskId()) });
    ab.fVW();
    this.DIZ = paramd;
    if (this.DHQ.DId) {
      if (this.DHQ.DHC != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.DHQ.DHC.HdL.app_id;
        paramd.timeStamp = this.DHQ.DHC.HdL.DnK;
        paramd.nonceStr = this.DHQ.DHC.HdL.oOY;
        paramd.packageExt = this.DHQ.DHC.HdL.Hud;
        paramd.signType = this.DHQ.DHC.HdL.oOW;
        paramd.dDF = this.DHQ.DHC.HdK;
        paramd.dDH = this.DHQ.DHC.dDH;
        paramd.dpc = 33;
        paramd.FEH = "key_from_scene_appbrandgame";
        paramd.dDI = this.DIv;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.DIv, null);
      }
    }
    for (;;)
    {
      ae.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.DIv) });
      int i = this.DIv;
      AppMethodBeat.o(71955);
      return i;
      ae.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      paramd = new PayInfo();
      paramd.dmw = this.DHQ.DHC.HdI;
      paramd.partnerId = this.DHQ.DHC.HdJ;
      paramd.dNM = this.DHQ.DHC.HdK;
      paramd.dDH = 5;
      com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.DIv);
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    ae.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.b.cr(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.DHQ.pMk, this.DHQ.DHV, this.DHQ.DHu, this.DHQ.DHv));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.DIv;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ae.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.DIv) && (this.DIZ != null))
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
      ae.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.DHQ.pMk, this.DHQ.DHV, this.DHQ.DHu, this.DHQ.DHv);
      this.DIZ.a(paramMMActivity, paramIntent);
      this.DIZ = null;
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
    ae.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", 0);
    localIntent.putExtra("key_err_msg", "");
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71958);
  }
  
  public final int eMI()
  {
    return 2;
  }
  
  public final void p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    ae.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    a.IvT.d(this.DJa);
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */