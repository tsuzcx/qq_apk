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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements i
{
  private IListener BaR;
  private boolean CsL;
  private String IrA;
  private boolean IrB;
  private boolean IrC;
  private boolean IrD;
  private boolean IrE;
  private boolean IrF;
  private boolean IrG;
  private IListener IrH;
  private PayReq Irx;
  private PayResp Iry;
  private boolean Irz;
  public String TAG;
  private String dDL;
  private String jjd;
  private int mScene;
  private PayReq.Options options;
  private long peJ;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.Irz = false;
    this.mScene = 0;
    this.IrA = "";
    this.IrB = false;
    this.peJ = 0L;
    this.IrC = false;
    this.IrD = false;
    this.IrE = false;
    this.IrF = false;
    this.CsL = false;
    this.IrG = false;
    this.BaR = new IListener() {};
    this.IrH = new IListener() {};
    AppMethodBeat.o(71868);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(71880);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131768354);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new DialogInterface.OnClickListener()
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
  
  private void bR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71879);
    if (paramContext == null)
    {
      Log.e(this.TAG, "startOuterApp context == null");
      AppMethodBeat.o(71879);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      Log.e(this.TAG, "startOuterApp callbackUrl is empty");
      AppMethodBeat.o(71879);
      return;
    }
    Log.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    if (Util.isIntentAvailable(paramContext, paramString))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private void cJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.IrA)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        amW(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      bR(this, this.IrA);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.jjd, this.Iry, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private PayReq ckn()
  {
    AppMethodBeat.i(71871);
    if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(IntentUtil.getExtras(getIntent()));
      AppMethodBeat.o(71871);
      return localObject;
    }
  }
  
  private void fUt()
  {
    AppMethodBeat.i(71878);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131767779), "", getString(2131756920), new DialogInterface.OnClickListener()
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
    if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.gsU().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131767779), "", getString(2131756920), new DialogInterface.OnClickListener()
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
    pi localpi = new pi();
    localpi.dVr.ret = 1;
    EventCenter.instance.publish(localpi);
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    Log.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.CsL), Util.getStack().toString() });
    if (this.CsL)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.CsL = true;
    super.finish();
    AppMethodBeat.o(71876);
  }
  
  public int getLayoutId()
  {
    return 2131495894;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71874);
    Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.Iry, Boolean.valueOf(this.Irz) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.Iry, Boolean.valueOf(this.Irz), Integer.valueOf(paramInt1) });
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
    if ((this.Iry != null) && (!this.Irz))
    {
      Log.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.Iry.errCode = -2;
      cJ("", false);
    }
    AppMethodBeat.o(71874);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(71877);
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(71877);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71869);
    super.onCreate(paramBundle);
    this.TAG = ("MicroMsg.OrderHandlerUI@" + hashCode());
    this.peJ = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ab.hht();
    EventCenter.instance.addListener(this.BaR);
    EventCenter.instance.addListener(this.IrH);
    com.tencent.mm.wallet_core.b.hgC();
    this.IrC = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
    this.IrD = this.IrC;
    this.IrE = this.IrC;
    com.tencent.mm.wallet_core.b.hgC();
    this.IrF = com.tencent.mm.wallet_core.b.b(b.a.rWe, false);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.hlD();
    AppMethodBeat.o(71869);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(397, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(2655, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(283, this);
    EventCenter.instance.removeListener(this.BaR);
    EventCenter.instance.removeListener(this.IrH);
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = ckn();
    Object localObject1;
    String str1;
    label385:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.Irx == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.Irx.prepayId))))
    {
      this.Irx = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      Log.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.jjd = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.jjd == null) || (this.jjd.length() == 0))
        {
          Log.e(this.TAG, "callerPkgName is null, dealOrder fail, can not callback");
          finish();
          AppMethodBeat.o(71870);
          return;
        }
      }
      this.options = new PayReq.Options();
      this.options.fromBundle(getIntent().getExtras());
      if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {}
      for (localObject1 = new WXJointPay.JointPayResp();; localObject1 = new PayResp())
      {
        this.Iry = ((PayResp)localObject1);
        this.Iry.prepayId = localPayReq.prepayId;
        this.Iry.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label385;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        Log.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.Iry.errCode = -1;
        this.Iry.errStr = getString(2131763825);
        e.a(this, this.jjd, this.Iry, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        Log.e(this.TAG, "onCreate, checkAppResult fail");
        this.Iry.errCode = -1;
        e.a(this, this.jjd, this.Iry, this.options);
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
          Log.printErrStackTrace(this.TAG, localNameNotFoundException1, "", new Object[0]);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          try
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.ci(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = ckn();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            if ((this.mScene != 1) || (!this.IrE)) {
              break;
            }
            fUt();
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayH5Pay(this, getIntent().getExtras(), str1, str2, (String)localObject2, (String)localObject4);
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
        if ((((String)localObject1).startsWith("sns_")) && (this.IrF)) {}
        for (i = 1; i != 0; i = 1)
        {
          fUt();
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
          AppMethodBeat.o(71870);
          return;
          if ((((String)localObject1).startsWith("sns_")) || (!this.IrD)) {
            break label840;
          }
        }
      }
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(397, this);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(2655, this);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.c.h(localPayReq, str1, str2, localObject3, (String)localObject4);
      localObject1 = localObject5;
      if (!Util.isNullOrNil(localPayReq.prepayId))
      {
        if (!localPayReq.prepayId.startsWith("up_")) {
          break label798;
        }
        localObject1 = new m(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
      AppMethodBeat.o(71870);
      return;
      label798:
      localObject1 = localObject5;
      if (localPayReq.prepayId.startsWith("sns_")) {
        localObject1 = new j(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(71873);
    if ((paramq.getType() != 397) && (paramq.getType() != 2655) && (paramq.getType() != 283))
    {
      AppMethodBeat.o(71873);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    if (this.mScene == 1)
    {
      localPayInfo.dVv = 36;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(paramq.getType(), this);
      Log.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.h)paramq;
      paramq = (czn)((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.iLL.iLR;
      if (paramq != null) {
        break label233;
      }
      paramq = null;
      label154:
      this.IrA = paramq;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      Log.e(this.TAG, "onSceneEnd, auth access denied");
      this.Iry.errCode = -1;
      cJ(paramString, true);
      paramInt1 = localPayInfo.dVv;
      if (this.Irx != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.Irx.prepayId)
    {
      af.z(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.dVv = 2;
      break;
      paramq = paramq.MER;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.Iry.errCode = -1;
      cJ(paramString, true);
      paramInt1 = localPayInfo.dVv;
      if (this.Irx == null) {}
      for (paramString = "";; paramString = this.Irx.prepayId)
      {
        af.z(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramq = (czn)((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.iLL.iLR;
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramq == null)
    {
      paramInt1 = -1;
      paramq = (czn)((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.iLL.iLR;
      if (paramq != null) {
        break label529;
      }
      paramq = null;
      localObject1 = (czn)((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.iLL.iLR;
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (czn)((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.iLL.iLR;
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (czn)((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.iLL.iLR;
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((czn)localObject3).LQB)
    {
      Log.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramq, localObject1, localObject2 });
      if (!Util.isNullOrNil((String)localObject1)) {
        break label569;
      }
      Log.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.Iry.errCode = -1;
      cJ(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramq.rBL;
      break;
      paramq = paramq.rBM;
      break label373;
      localObject1 = ((czn)localObject1).LQv;
      break label397;
      localObject2 = ((czn)localObject2).LQw;
      break label421;
    }
    label569:
    af.z(localPayInfo.dVv, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!Util.isNullOrNil(((exi)localObject3).NuI)))
    {
      this.IrG = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((exi)localObject3).NuI);
      paramString.putExtra("need_dialog", ((exi)localObject3).NuK);
      paramString.putExtra("dialog_text", ((exi)localObject3).NuL);
      paramString.putExtra("max_count", ((exi)localObject3).NuJ.LbT);
      paramString.putExtra("inteval_time", ((exi)localObject3).NuJ.LbS);
      paramString.putExtra("default_wording", ((exi)localObject3).NuJ.LbU);
      c.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.dDL = ((String)localObject1);
      this.Irz = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.Irx.appId;
      localPayInfo.dDL = ((String)localObject1);
      localPayInfo.partnerId = this.Irx.partnerId;
      localPayInfo.IqM = ((String)localObject2);
      localPayInfo.Kxt = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramq;
      if (this.peJ > 0L)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(641L, 2L, Util.milliSecondsToNow(this.peJ), true);
        if (localPayInfo.iqp == null) {
          localPayInfo.iqp = new Bundle();
        }
        localPayInfo.iqp.putLong("wallet_pay_key_check_time", this.peJ);
      }
      f.a(this, localPayInfo, 123);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */