package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.z;
import java.util.ArrayList;

public final class f
  implements b
{
  private final int uAY;
  private c uAt;
  private com.tencent.mm.sdk.b.c uBA;
  private d uBz;
  
  public f(c paramc, com.tencent.mm.sdk.b.c paramc1)
  {
    AppMethodBeat.i(48313);
    this.uAY = (hashCode() & 0xFFFF);
    this.uBz = null;
    this.uAt = paramc;
    this.uBA = paramc1;
    a.ymk.c(this.uBA);
    AppMethodBeat.o(48313);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(48314);
    ab.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", new Object[] { Boolean.valueOf(this.uAt.uAG), Integer.valueOf(paramMMActivity.getTaskId()) });
    z.dSt();
    this.uBz = paramd;
    if (this.uAt.uAG) {
      if (this.uAt.uAi != null)
      {
        paramd = new WalletJsapiData();
        paramd.appId = this.uAt.uAi.xlE.app_id;
        paramd.timeStamp = this.uAt.uAi.xlE.uho;
        paramd.nonceStr = this.uAt.uAi.xlE.kwJ;
        paramd.packageExt = this.uAt.uAi.xlE.xyA;
        paramd.signType = this.uAt.uAi.xlE.kwH;
        paramd.cCB = this.uAt.uAi.xlD;
        paramd.cCD = this.uAt.uAi.cCD;
        paramd.wgN = "key_from_scene_appbrandgame";
        h.a(paramMMActivity, paramd, this.uAY, null);
      }
    }
    for (;;)
    {
      ab.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", new Object[] { Integer.valueOf(this.uAY) });
      int i = this.uAY;
      AppMethodBeat.o(48314);
      return i;
      ab.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
      continue;
      paramd = new PayInfo();
      paramd.cnI = this.uAt.uAi.xlB;
      paramd.partnerId = this.uAt.uAi.xlC;
      paramd.cLA = this.uAt.uAi.xlD;
      paramd.cCD = 5;
      h.a(paramMMActivity, paramd, this.uAY);
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(48318);
    if (paramd != null) {
      paramd.a(com.tencent.mm.plugin.wallet_index.c.b.bu(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.uAt.liu, this.uAt.uAy, this.uAt.uAa, this.uAt.uAb));
    }
    AppMethodBeat.o(48318);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48315);
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ab.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d, data is null : %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 == this.uAY) && (this.uBz != null))
      {
        if (paramInt2 != -1) {
          break label181;
        }
        if ((paramIntent == null) || (paramIntent.getIntExtra("key_jsapi_pay_err_code", 0) != 0)) {
          break label171;
        }
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.bu(0, "");
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.WeiXinWallet", "wxpay result : %s", new Object[] { paramMMActivity });
      paramIntent = new com.tencent.mm.plugin.wallet_index.b.a.c(this.uAt.liu, this.uAt.uAy, this.uAt.uAa, this.uAt.uAb);
      this.uBz.a(paramMMActivity, paramIntent);
      this.uBz = null;
      AppMethodBeat.o(48315);
      return true;
      bool = false;
      break;
      label171:
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.bu(5, "");
      continue;
      label181:
      if (paramInt2 == 0) {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.bu(1, "");
      } else {
        paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.bu(6, "");
      }
    }
  }
  
  public final void b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(48317);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", 0);
    localIntent.putExtra("key_err_msg", "");
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(48317);
  }
  
  public final int cXf()
  {
    return 2;
  }
  
  public final void l(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(48316);
    a.ymk.d(this.uBA);
    AppMethodBeat.o(48316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.f
 * JD-Core Version:    0.7.0.1
 */