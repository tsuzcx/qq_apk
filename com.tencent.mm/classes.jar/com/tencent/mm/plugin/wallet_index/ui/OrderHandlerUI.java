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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.qg;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.fhv;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements i
{
  private IListener GUP;
  private boolean Iqp;
  private PayReq Pkg;
  private PayResp Pkh;
  private boolean Pki;
  private String Pkj;
  private boolean Pkk;
  private boolean Pkl;
  private boolean Pkm;
  private boolean Pkn;
  private boolean Pko;
  private boolean Pkp;
  private IListener Pkq;
  public String TAG;
  private String fwv;
  private String lYZ;
  private int mScene;
  private PayReq.Options options;
  private long sgN;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.Pki = false;
    this.mScene = 0;
    this.Pkj = "";
    this.Pkk = false;
    this.sgN = 0L;
    this.Pkl = false;
    this.Pkm = false;
    this.Pkn = false;
    this.Pko = false;
    this.Iqp = false;
    this.Pkp = false;
    this.GUP = new IListener() {};
    this.Pkq = new OrderHandlerUI.2(this);
    AppMethodBeat.o(71868);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(71880);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.i.wallet_unknown_err);
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
  
  private void cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.Pkj)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        auQ(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      cc(this, this.Pkj);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.lYZ, this.Pkh, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private void cc(Context paramContext, String paramString)
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private PayReq cxE()
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
  
  private void gMZ()
  {
    AppMethodBeat.i(71878);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_is_paying_tips), "", getString(a.i.button_ok), new DialogInterface.OnClickListener()
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
    if (((Boolean)g.hoh().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_is_paying_tips), "", getString(a.i.button_ok), new DialogInterface.OnClickListener()
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
    qg localqg = new qg();
    localqg.fOU.ret = 1;
    EventCenter.instance.publish(localqg);
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    Log.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.Iqp), Util.getStack().toString() });
    if (this.Iqp)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.Iqp = true;
    super.finish();
    AppMethodBeat.o(71876);
  }
  
  public int getLayoutId()
  {
    return a.g.order_handle_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71874);
    Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.Pkh, Boolean.valueOf(this.Pki) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.Pkh, Boolean.valueOf(this.Pki), Integer.valueOf(paramInt1) });
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
    if ((this.Pkh != null) && (!this.Pki))
    {
      Log.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.Pkh.errCode = -2;
      cX("", false);
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
    this.sgN = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ab.iiV();
    getController().setStatusBarColor(0);
    EventCenter.instance.addListener(this.GUP);
    EventCenter.instance.addListener(this.Pkq);
    b.iie();
    this.Pkl = b.b(b.a.vCG, true);
    this.Pkm = this.Pkl;
    this.Pkn = this.Pkl;
    b.iie();
    this.Pko = b.b(b.a.vCH, false);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.ipc();
    AppMethodBeat.o(71869);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(397, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(2655, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(283, this);
    EventCenter.instance.removeListener(this.GUP);
    EventCenter.instance.removeListener(this.Pkq);
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = cxE();
    Object localObject1;
    String str1;
    label386:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.Pkg == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.Pkg.prepayId))))
    {
      this.Pkg = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      Log.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.lYZ = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.lYZ == null) || (this.lYZ.length() == 0))
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
        this.Pkh = ((PayResp)localObject1);
        this.Pkh.prepayId = localPayReq.prepayId;
        this.Pkh.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label386;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        Log.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.Pkh.errCode = -1;
        this.Pkh.errStr = getString(a.i.pay_callback_errmsg_req_checkargs_fail);
        e.a(this, this.lYZ, this.Pkh, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        Log.e(this.TAG, "onCreate, checkAppResult fail");
        this.Pkh.errCode = -1;
        e.a(this, this.lYZ, this.Pkh, this.options);
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
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.cu(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = cxE();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            if ((this.mScene != 1) || (!this.Pkn)) {
              break;
            }
            gMZ();
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayH5Pay(this, getIntent().getExtras(), str1, str2, (String)localObject2, (String)localObject4);
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
        if ((((String)localObject1).startsWith("sns_")) && (this.Pko)) {}
        for (i = 1; i != 0; i = 1)
        {
          gMZ();
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
          AppMethodBeat.o(71870);
          return;
          if ((((String)localObject1).startsWith("sns_")) || (!this.Pkm)) {
            break label841;
          }
        }
      }
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(397, this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(2655, this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.c.h(localPayReq, str1, str2, localObject3, (String)localObject4);
      localObject1 = localObject5;
      if (!Util.isNullOrNil(localPayReq.prepayId))
      {
        if (!localPayReq.prepayId.startsWith("up_")) {
          break label799;
        }
        localObject1 = new m(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
      AppMethodBeat.o(71870);
      return;
      label799:
      localObject1 = localObject5;
      if (localPayReq.prepayId.startsWith("sns_")) {
        localObject1 = new j(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      localPayInfo.fOY = 36;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(paramq.getType(), this);
      Log.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.h)paramq;
      paramq = (djb)d.c.b(((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.lBS);
      if (paramq != null) {
        break label233;
      }
      paramq = null;
      label154:
      this.Pkj = paramq;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      Log.e(this.TAG, "onSceneEnd, auth access denied");
      this.Pkh.errCode = -1;
      cX(paramString, true);
      paramInt1 = localPayInfo.fOY;
      if (this.Pkg != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.Pkg.prepayId)
    {
      af.B(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.fOY = 2;
      break;
      paramq = paramq.TQD;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.Pkh.errCode = -1;
      cX(paramString, true);
      paramInt1 = localPayInfo.fOY;
      if (this.Pkg == null) {}
      for (paramString = "";; paramString = this.Pkg.prepayId)
      {
        af.B(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramq = (djb)d.c.b(((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.lBS);
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramq == null)
    {
      paramInt1 = -1;
      paramq = (djb)d.c.b(((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.lBS);
      if (paramq != null) {
        break label529;
      }
      paramq = null;
      localObject1 = (djb)d.c.b(((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.lBS);
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (djb)d.c.b(((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.lBS);
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (djb)d.c.b(((com.tencent.mm.plugin.wallet_index.c.h)localObject3).rr.lBS);
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((djb)localObject3).SZc)
    {
      Log.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramq, localObject1, localObject2 });
      if (!Util.isNullOrNil((String)localObject1)) {
        break label569;
      }
      Log.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.Pkh.errCode = -1;
      cX(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramq.vht;
      break;
      paramq = paramq.vhu;
      break label373;
      localObject1 = ((djb)localObject1).SYW;
      break label397;
      localObject2 = ((djb)localObject2).SYX;
      break label421;
    }
    label569:
    af.B(localPayInfo.fOY, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!Util.isNullOrNil(((fhv)localObject3).UHJ)))
    {
      this.Pkp = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((fhv)localObject3).UHJ);
      paramString.putExtra("need_dialog", ((fhv)localObject3).UHL);
      paramString.putExtra("dialog_text", ((fhv)localObject3).UHM);
      paramString.putExtra("max_count", ((fhv)localObject3).UHK.Sdg);
      paramString.putExtra("inteval_time", ((fhv)localObject3).UHK.Sdf);
      paramString.putExtra("default_wording", ((fhv)localObject3).UHK.Sdh);
      com.tencent.mm.by.c.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.fwv = ((String)localObject1);
      this.Pki = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.Pkg.appId;
      localPayInfo.fwv = ((String)localObject1);
      localPayInfo.partnerId = this.Pkg.partnerId;
      localPayInfo.Pjv = ((String)localObject2);
      localPayInfo.Rzh = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramq;
      if (this.sgN > 0L)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(641L, 2L, Util.milliSecondsToNow(this.sgN), true);
        if (localPayInfo.lfu == null) {
          localPayInfo.lfu = new Bundle();
        }
        localPayInfo.lfu.putLong("wallet_pay_key_check_time", this.sgN);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */