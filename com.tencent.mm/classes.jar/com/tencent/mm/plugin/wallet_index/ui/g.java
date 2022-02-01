package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_index.b.a.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.model.ac;
import java.util.ArrayList;

public final class g
  implements b
{
  private c WaT;
  private final int Wby;
  private d Wcs;
  private IListener Wct;
  
  public g(c paramc, IListener paramIListener)
  {
    AppMethodBeat.i(71954);
    this.Wby = (hashCode() & 0xFFFF);
    this.Wcs = null;
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
    this.WaT = paramc;
    this.Wct = paramIListener;
    this.Wct.alive();
    AppMethodBeat.o(71954);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71955);
    Log.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.WaT.Wbg), Integer.valueOf(paramMMActivity.getTaskId()) });
    ac.jOR();
    this.Wcs = paramd;
    if (this.WaT.Wbg) {
      if (this.WaT.War != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.WaT.War.aaGO.app_id;
        paramd.timeStamp = this.WaT.War.aaGO.VEW;
        paramd.nonceStr = this.WaT.War.aaGO.wDg;
        paramd.packageExt = this.WaT.War.aaGO.abfh;
        paramd.signType = this.WaT.War.aaGO.wDe;
        paramd.hUP = this.WaT.War.aaGN;
        paramd.hUR = this.WaT.War.hUR;
        paramd.payChannel = 33;
        paramd.YvZ = "key_from_scene_appbrandgame";
        paramd.hUS = this.Wby;
        f.a(paramMMActivity, paramd, this.Wby, null);
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.Wby) });
      int i = this.Wby;
      AppMethodBeat.o(71955);
      return i;
      Log.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      boolean bool = ((a)h.ax(a.class)).isSwitch2InWxAppPay(this.WaT.War.aaGL);
      Log.i("MicroMsg.WeiXinWallet", "doEmojiReward, isSwitch2InWxAppPay:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ((a)h.ax(a.class)).startInWxAppPayUseCase(paramMMActivity, this.WaT.War.aaGL, "", "", 5, 0);
      }
      else
      {
        paramd = new PayInfo();
        paramd.hAT = this.WaT.War.aaGL;
        paramd.partnerId = this.WaT.War.aaGM;
        paramd.hPe = this.WaT.War.aaGN;
        paramd.hUR = 5;
        f.a(paramMMActivity, paramd, this.Wby);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71959);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.model.c.dA(0, ""), new e(this.WaT.xOk, this.WaT.WaY, this.WaT.Wag, this.WaT.Wah));
    }
    AppMethodBeat.o(71959);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71956);
    int i = this.Wby;
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramInt1 == this.Wby) && (this.Wcs != null))
      {
        if (paramInt2 != -1) {
          break label196;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label186;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.model.c.dA(0, "");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new e(this.WaT.xOk, this.WaT.WaY, this.WaT.Wag, this.WaT.Wah);
      this.Wcs.a(paramMMActivity, paramIntent);
      this.Wcs = null;
      AppMethodBeat.o(71956);
      return true;
      bool = false;
      break;
      label186:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.model.c.dA(5, "");
      continue;
      label196:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.model.c.dA(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.model.c.dA(6, "");
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
  
  public final int imm()
  {
    return 2;
  }
  
  public final void v(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71957);
    Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
    this.Wct.dead();
    AppMethodBeat.o(71957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.g
 * JD-Core Version:    0.7.0.1
 */