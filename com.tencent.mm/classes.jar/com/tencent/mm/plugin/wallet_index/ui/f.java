package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f
  implements b
{
  private c PjQ;
  private d PkY;
  private IListener PkZ;
  private final int Pkv;
  
  public f(c paramc, IListener paramIListener)
  {
    AppMethodBeat.i(71954);
    this.Pkv = (hashCode() & 0xFFFF);
    this.PkY = null;
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.PjQ = paramc;
    this.PkZ = paramIListener;
    EventCenter.instance.addListener(this.PkZ);
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    Log.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.PjQ.Pkd), Integer.valueOf(paramMMActivity.getTaskId()) });
    ab.iiV();
    this.PkY = paramd;
    if (this.PjQ.Pkd) {
      if (this.PjQ.Pjz != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.PjQ.Pjz.TsE.app_id;
        paramd.timeStamp = this.PjQ.Pjz.TsE.OPc;
        paramd.nonceStr = this.PjQ.Pjz.TsE.tyJ;
        paramd.packageExt = this.PjQ.Pjz.TsE.TOJ;
        paramd.signType = this.PjQ.Pjz.TsE.tyH;
        paramd.fOW = this.PjQ.Pjz.TsD;
        paramd.fOY = this.PjQ.Pjz.fOY;
        paramd.payChannel = 33;
        paramd.RzA = "key_from_scene_appbrandgame";
        paramd.fOZ = this.Pkv;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.Pkv, null);
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.Pkv) });
      int i = this.Pkv;
      AppMethodBeat.o(71955);
      return i;
      Log.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      boolean bool = ((a)h.ae(a.class)).isSwitch2InWxAppPay(this.PjQ.Pjz.TsB);
      Log.i("MicroMsg.WeiXinWallet", "doEmojiReward, isSwitch2InWxAppPay:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ((a)h.ae(a.class)).startInWxAppPayUseCase(paramMMActivity, this.PjQ.Pjz.TsB, "", "", 5, 0);
      }
      else
      {
        paramd = new PayInfo();
        paramd.fwv = this.PjQ.Pjz.TsB;
        paramd.partnerId = this.PjQ.Pjz.TsC;
        paramd.fJB = this.PjQ.Pjz.TsD;
        paramd.fOY = 5;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.Pkv);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.c.cK(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.PjQ.uFI, this.PjQ.PjV, this.PjQ.Pjo, this.PjQ.Pjp));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.Pkv;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.Pkv) && (this.PkY != null))
      {
        if (paramInt2 != -1) {
          break label200;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label190;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cK(0, "");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.PjQ.uFI, this.PjQ.PjV, this.PjQ.Pjo, this.PjQ.Pjp);
      this.PkY.a(paramMMActivity, paramIntent);
      this.PkY = null;
      AppMethodBeat.o(71956);
      return true;
      bool = false;
      break;
      label190:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cK(5, "");
      continue;
      label200:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cK(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cK(6, "");
      }
    }
  }
  
  public final void c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(71958);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", 0);
    localIntent.putExtra("key_err_msg", "");
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71958);
  }
  
  public final int gMX()
  {
    return 2;
  }
  
  public final void q(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    EventCenter.instance.removeListener(this.PkZ);
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */