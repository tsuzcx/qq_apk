package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private PayReq DqA;
  private PayResp DqB;
  private boolean DqC;
  private String DqD;
  private boolean DqE;
  private boolean DqF;
  private boolean DqG;
  private boolean DqH;
  private boolean DqI;
  private boolean DqJ;
  private c DqK;
  public String TAG;
  private String dlu;
  private String ilc;
  private int mScene;
  private long nOq;
  private PayReq.Options options;
  private c wNB;
  private boolean ycd;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.DqC = false;
    this.mScene = 0;
    this.DqD = "";
    this.DqE = false;
    this.nOq = 0L;
    this.DqF = false;
    this.DqG = false;
    this.DqH = false;
    this.DqI = false;
    this.ycd = false;
    this.DqJ = false;
    this.wNB = new c() {};
    this.DqK = new c() {};
    AppMethodBeat.o(71868);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(71880);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131765901);
    }
    h.a(this, str, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71867);
        paramAnonymousDialogInterface.dismiss();
        OrderHandlerUI.this.finish();
        AppMethodBeat.o(71867);
      }
    });
    AppMethodBeat.o(71880);
  }
  
  private PayReq bMu()
  {
    AppMethodBeat.i(71871);
    if (y.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(y.bk(getIntent()));
      AppMethodBeat.o(71871);
      return localObject;
    }
  }
  
  private void bv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71879);
    if (paramContext == null)
    {
      ad.e(this.TAG, "startOuterApp context == null");
      AppMethodBeat.o(71879);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ad.e(this.TAG, "startOuterApp callbackUrl is empty");
      AppMethodBeat.o(71879);
      return;
    }
    ad.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    if (bt.aj(paramContext, paramString))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahp(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private void cm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.DqD)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        abY(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      bv(this, this.DqD);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.ilc, this.DqB, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private void eJc()
  {
    AppMethodBeat.i(71878);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71865);
          OrderHandlerUI.this.finish();
          AppMethodBeat.o(71865);
        }
      });
      AppMethodBeat.o(71878);
      return;
    }
    if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.ffE().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71866);
          OrderHandlerUI.this.finish();
          AppMethodBeat.o(71866);
        }
      });
      AppMethodBeat.o(71878);
      return;
    }
    op localop = new op();
    localop.dCy.ret = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localop);
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    ad.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.ycd), bt.flS().toString() });
    if (this.ycd)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.ycd = true;
    super.finish();
    AppMethodBeat.o(71876);
  }
  
  public int getLayoutId()
  {
    return 2131495060;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71874);
    ad.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.DqB, Boolean.valueOf(this.DqC) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        ad.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.DqB, Boolean.valueOf(this.DqC), Integer.valueOf(paramInt1) });
        finish();
        AppMethodBeat.o(71874);
        return;
      }
      if (paramInt1 == 1001)
      {
        AppMethodBeat.o(71874);
        return;
      }
    }
    if ((this.DqB != null) && (!this.DqC))
    {
      ad.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.DqB.errCode = -2;
      cm("", false);
    }
    AppMethodBeat.o(71874);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(71877);
    super.onConfigurationChanged(paramConfiguration);
    ad.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(71877);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71869);
    super.onCreate(paramBundle);
    this.TAG = ("MicroMsg.OrderHandlerUI@" + hashCode());
    this.nOq = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ab.fRA();
    com.tencent.mm.sdk.b.a.IbL.c(this.wNB);
    com.tencent.mm.sdk.b.a.IbL.c(this.DqK);
    com.tencent.mm.wallet_core.b.fQJ();
    this.DqF = com.tencent.mm.wallet_core.b.b(b.a.qwl, true);
    if ((this.DqF) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY")))
    {
      bool1 = true;
      this.DqG = bool1;
      if ((!this.DqF) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY"))) {
        break label212;
      }
    }
    label212:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.DqH = bool1;
      com.tencent.mm.wallet_core.b.fQJ();
      this.DqI = com.tencent.mm.wallet_core.b.b(b.a.qwm, false);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fUT();
      AppMethodBeat.o(71869);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(397, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(2655, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(283, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.wNB);
    com.tencent.mm.sdk.b.a.IbL.d(this.DqK);
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = bMu();
    Object localObject1;
    String str1;
    label384:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.DqA == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.DqA.prepayId))))
    {
      this.DqA = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      ad.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.ilc = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.ilc == null) || (this.ilc.length() == 0))
        {
          ad.e(this.TAG, "callerPkgName is null, dealOrder fail, can not callback");
          finish();
          AppMethodBeat.o(71870);
          return;
        }
      }
      this.options = new PayReq.Options();
      this.options.fromBundle(getIntent().getExtras());
      if (y.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
      for (localObject1 = new WXJointPay.JointPayResp();; localObject1 = new PayResp())
      {
        this.DqB = ((PayResp)localObject1);
        this.DqB.prepayId = localPayReq.prepayId;
        this.DqB.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label384;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        ad.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.DqB.errCode = -1;
        this.DqB.errStr = getString(2131761837);
        e.a(this, this.ilc, this.DqB, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        ad.e(this.TAG, "onCreate, checkAppResult fail");
        this.DqB.errCode = -1;
        e.a(this, this.ilc, this.DqB, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
        if (this.mScene == 1) {
          str1 = "WAP";
        }
      }
      str2 = getIntent().getStringExtra("_mmessage_appPackage");
      localObject5 = "";
      localObject4 = "";
      for (;;)
      {
        try
        {
          getPackageManager().getPackageInfo(str2, 0);
          localObject1 = (String)getPackageManager().getPackageInfo(str2, 0).applicationInfo.loadLabel(getPackageManager());
          Object localObject2;
          ad.printErrStackTrace(this.TAG, localNameNotFoundException1, "", new Object[0]);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          try
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.bN(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = bMu();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            if ((this.mScene != 1) || (!this.DqH)) {
              break;
            }
            eJc();
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayH5Pay(this, getIntent().getExtras(), str1, str2, (String)localObject2, (String)localObject4);
            AppMethodBeat.o(71870);
            return;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            for (;;)
            {
              Object localObject3;
              continue;
              int i = 0;
            }
          }
          localNameNotFoundException1 = localNameNotFoundException1;
          localObject1 = localObject5;
        }
        localObject3 = localObject1;
      }
      if (this.mScene == 0)
      {
        if ((((String)localObject1).startsWith("sns_")) && (this.DqI)) {}
        for (i = 1; i != 0; i = 1)
        {
          eJc();
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
          AppMethodBeat.o(71870);
          return;
          if ((((String)localObject1).startsWith("sns_")) || (!this.DqG)) {
            break label839;
          }
        }
      }
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(397, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(2655, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.c.g(localPayReq, str1, str2, localObject3, (String)localObject4);
      localObject1 = localObject5;
      if (!bt.isNullOrNil(localPayReq.prepayId))
      {
        if (!localPayReq.prepayId.startsWith("up_")) {
          break label797;
        }
        localObject1 = new l(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject1, 0);
      AppMethodBeat.o(71870);
      return;
      label797:
      localObject1 = localObject5;
      if (localPayReq.prepayId.startsWith("sns_")) {
        localObject1 = new i(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71873);
    if ((paramn.getType() != 397) && (paramn.getType() != 2655) && (paramn.getType() != 283))
    {
      AppMethodBeat.o(71873);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    if (this.mScene == 1)
    {
      localPayInfo.dCC = 36;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(paramn.getType(), this);
      ad.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.g)paramn;
      paramn = (cil)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hNL.hNQ;
      if (paramn != null) {
        break label233;
      }
      paramn = null;
      label154:
      this.DqD = paramn;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      ad.e(this.TAG, "onSceneEnd, auth access denied");
      this.DqB.errCode = -1;
      cm(paramString, true);
      paramInt1 = localPayInfo.dCC;
      if (this.DqA != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.DqA.prepayId)
    {
      af.w(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.dCC = 2;
      break;
      paramn = paramn.Hcs;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.DqB.errCode = -1;
      cm(paramString, true);
      paramInt1 = localPayInfo.dCC;
      if (this.DqA == null) {}
      for (paramString = "";; paramString = this.DqA.prepayId)
      {
        af.w(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramn = (cil)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hNL.hNQ;
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramn == null)
    {
      paramInt1 = -1;
      paramn = (cil)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hNL.hNQ;
      if (paramn != null) {
        break label529;
      }
      paramn = null;
      localObject1 = (cil)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hNL.hNQ;
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (cil)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hNL.hNQ;
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (cil)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hNL.hNQ;
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((cil)localObject3).GsX)
    {
      ad.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramn, localObject1, localObject2 });
      if (!bt.isNullOrNil((String)localObject1)) {
        break label569;
      }
      ad.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.DqB.errCode = -1;
      cm(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramn.qel;
      break;
      paramn = paramn.qem;
      break label373;
      localObject1 = ((cil)localObject1).GsR;
      break label397;
      localObject2 = ((cil)localObject2).GsS;
      break label421;
    }
    label569:
    af.w(localPayInfo.dCC, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!bt.isNullOrNil(((ebj)localObject3).HNX)))
    {
      this.DqJ = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((ebj)localObject3).HNX);
      paramString.putExtra("need_dialog", ((ebj)localObject3).HNZ);
      paramString.putExtra("dialog_text", ((ebj)localObject3).HOa);
      paramString.putExtra("max_count", ((ebj)localObject3).HNY.FOR);
      paramString.putExtra("inteval_time", ((ebj)localObject3).HNY.FOQ);
      paramString.putExtra("default_wording", ((ebj)localObject3).HNY.FOS);
      d.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.dlu = ((String)localObject1);
      this.DqC = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.DqA.appId;
      localPayInfo.dlu = ((String)localObject1);
      localPayInfo.partnerId = this.DqA.partnerId;
      localPayInfo.DpS = ((String)localObject2);
      localPayInfo.FlR = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramn;
      if (this.nOq > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(641L, 2L, bt.Df(this.nOq), true);
        if (localPayInfo.htZ == null) {
          localPayInfo.htZ = new Bundle();
        }
        localPayInfo.htZ.putLong("wallet_pay_key_check_time", this.nOq);
      }
      com.tencent.mm.pluginsdk.wallet.f.a(this, localPayInfo, 123);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */