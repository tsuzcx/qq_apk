package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f
  implements b
{
  private final int IrM;
  private c Irh;
  private d Isp;
  private IListener Isq;
  
  public f(c paramc, IListener paramIListener)
  {
    AppMethodBeat.i(71954);
    this.IrM = (hashCode() & 0xFFFF);
    this.Isp = null;
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.Irh = paramc;
    this.Isq = paramIListener;
    EventCenter.instance.addListener(this.Isq);
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    Log.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.Irh.Iru), Integer.valueOf(paramMMActivity.getTaskId()) });
    ab.hht();
    this.Isp = paramd;
    if (this.Irh.Iru) {
      if (this.Irh.IqQ != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.Irh.IqQ.MiO.app_id;
        paramd.timeStamp = this.Irh.IqQ.MiO.HXc;
        paramd.nonceStr = this.Irh.IqQ.MiO.qcM;
        paramd.packageExt = this.Irh.IqQ.MiO.MDb;
        paramd.signType = this.Irh.IqQ.MiO.qcK;
        paramd.dVt = this.Irh.IqQ.MiN;
        paramd.dVv = this.Irh.IqQ.dVv;
        paramd.payChannel = 33;
        paramd.KxM = "key_from_scene_appbrandgame";
        paramd.dVw = this.IrM;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.IrM, null);
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.IrM) });
      int i = this.IrM;
      AppMethodBeat.o(71955);
      return i;
      Log.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      boolean bool = ((a)g.af(a.class)).isSwitch2InWxAppPay(this.Irh.IqQ.MiL);
      Log.i("MicroMsg.WeiXinWallet", "doEmojiReward, isSwitch2InWxAppPay:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ((a)g.af(a.class)).startInWxAppPayUseCase(paramMMActivity, this.Irh.IqQ.MiL, "", "", 5, 0);
      }
      else
      {
        paramd = new PayInfo();
        paramd.dDL = this.Irh.IqQ.MiL;
        paramd.partnerId = this.Irh.IqQ.MiM;
        paramd.dQk = this.Irh.IqQ.MiN;
        paramd.dVv = 5;
        com.tencent.mm.pluginsdk.wallet.f.a(paramMMActivity, paramd, this.IrM);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.c.cJ(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.Irh.rcD, this.Irh.Irm, this.Irh.IqF, this.Irh.IqG));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.IrM;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.IrM) && (this.Isp != null))
      {
        if (paramInt2 != -1) {
          break label200;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label190;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cJ(0, "");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.Irh.rcD, this.Irh.Irm, this.Irh.IqF, this.Irh.IqG);
      this.Isp.a(paramMMActivity, paramIntent);
      this.Isp = null;
      AppMethodBeat.o(71956);
      return true;
      bool = false;
      break;
      label190:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cJ(5, "");
      continue;
      label200:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cJ(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cJ(6, "");
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
  
  public final int fUr()
  {
    return 2;
  }
  
  public final void p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    EventCenter.instance.removeListener(this.Isq);
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */