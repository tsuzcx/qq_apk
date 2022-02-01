package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f
  implements b
{
  private c BPS;
  private final int BQx;
  private d BRb;
  private com.tencent.mm.sdk.b.c BRc;
  
  public f(c paramc, com.tencent.mm.sdk.b.c paramc1)
  {
    AppMethodBeat.i(71954);
    this.BQx = (hashCode() & 0xFFFF);
    this.BRb = null;
    ac.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.BPS = paramc;
    this.BRc = paramc1;
    a.GpY.c(this.BRc);
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    ac.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.BPS.BQf), Integer.valueOf(paramMMActivity.getTaskId()) });
    ab.fAq();
    this.BRb = paramd;
    if (this.BPS.BQf) {
      if (this.BPS.BPE != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.BPS.BPE.FaL.app_id;
        paramd.timeStamp = this.BPS.BPE.FaL.BvP;
        paramd.nonceStr = this.BPS.BPE.FaL.ofc;
        paramd.packageExt = this.BPS.BPE.FaL.FqT;
        paramd.signType = this.BPS.BPE.FaL.ofa;
        paramd.dqJ = this.BPS.BPE.FaK;
        paramd.dqL = this.BPS.BPE.dqL;
        paramd.dcB = 33;
        paramd.DHc = "key_from_scene_appbrandgame";
        paramd.dqM = this.BQx;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.BQx, null);
      }
    }
    for (;;)
    {
      ac.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.BQx) });
      int i = this.BQx;
      AppMethodBeat.o(71955);
      return i;
      ac.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      paramd = new PayInfo();
      paramd.dac = this.BPS.BPE.FaI;
      paramd.partnerId = this.BPS.BPE.FaJ;
      paramd.dAj = this.BPS.BPE.FaK;
      paramd.dqL = 5;
      com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.BQx);
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    ac.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.b.cj(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.BPS.pbW, this.BPS.BPX, this.BPS.BPw, this.BPS.BPx));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.BQx;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ac.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.BQx) && (this.BRb != null))
      {
        if (paramInt2 != -1) {
          break label195;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label185;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cj(0, "");
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.BPS.pbW, this.BPS.BPX, this.BPS.BPw, this.BPS.BPx);
      this.BRb.a(paramMMActivity, paramIntent);
      this.BRb = null;
      AppMethodBeat.o(71956);
      return true;
      bool = false;
      break;
      label185:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cj(5, "");
      continue;
      label195:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cj(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cj(6, "");
      }
    }
  }
  
  public final void d(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(71958);
    ac.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", 0);
    localIntent.putExtra("key_err_msg", "");
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71958);
  }
  
  public final int euU()
  {
    return 2;
  }
  
  public final void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    ac.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    a.GpY.d(this.BRc);
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */