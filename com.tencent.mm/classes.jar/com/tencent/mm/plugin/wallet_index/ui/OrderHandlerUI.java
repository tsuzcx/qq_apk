package com.tencent.mm.plugin.wallet_index.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.rt;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_index.model.j;
import com.tencent.mm.plugin.wallet_index.model.m;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.geh;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.ag;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private IListener MSr;
  private boolean OnI;
  public String TAG;
  private PayReq Wbj;
  private PayResp Wbk;
  private boolean Wbl;
  private String Wbm;
  private boolean Wbn;
  private boolean Wbo;
  private boolean Wbp;
  private boolean Wbq;
  private boolean Wbr;
  private boolean Wbs;
  private IListener Wbt;
  private String hAT;
  private int mScene;
  private String oSi;
  private PayReq.Options options;
  private long vsH;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.Wbl = false;
    this.mScene = 0;
    this.Wbm = "";
    this.Wbn = false;
    this.vsH = 0L;
    this.Wbo = false;
    this.Wbp = false;
    this.Wbq = false;
    this.Wbr = false;
    this.OnI = false;
    this.Wbs = false;
    this.MSr = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Wbt = new OrderHandlerUI.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(71868);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(71880);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    k.a(this, str, null, false, new DialogInterface.OnClickListener()
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
  
  private void cn(Context paramContext, String paramString)
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private void dF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.Wbm)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        aoP(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      cn(this, this.Wbm);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.oSi, this.Wbk, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private PayReq dat()
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
  
  private void imo()
  {
    AppMethodBeat.i(71878);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      k.a(this, getString(a.i.wallet_is_paying_tips), "", getString(a.i.button_ok), new DialogInterface.OnClickListener()
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
    if (((Boolean)g.iOZ().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      k.a(this, getString(a.i.wallet_is_paying_tips), "", getString(a.i.button_ok), new DialogInterface.OnClickListener()
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
    rt localrt = new rt();
    localrt.hUN.ret = 1;
    localrt.publish();
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    Log.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.OnI), Util.getStack().toString() });
    if (this.OnI)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.OnI = true;
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
    Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.Wbk, Boolean.valueOf(this.Wbl) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.Wbk, Boolean.valueOf(this.Wbl), Integer.valueOf(paramInt1) });
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
    if ((this.Wbk != null) && (!this.Wbl))
    {
      Log.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.Wbk.errCode = -2;
      dF("", false);
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
    this.vsH = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ac.jOR();
    getController().setStatusBarColor(0);
    this.MSr.alive();
    this.Wbt.alive();
    b.jNX();
    this.Wbo = b.b(c.a.yRc, true);
    this.Wbp = this.Wbo;
    this.Wbq = this.Wbo;
    b.jNX();
    this.Wbr = b.b(c.a.yRd, false);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.jYq();
    AppMethodBeat.o(71869);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(397, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2655, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(283, this);
    this.MSr.dead();
    this.Wbt.dead();
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = dat();
    Object localObject1;
    String str1;
    label386:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.Wbj == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.Wbj.prepayId))))
    {
      this.Wbj = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      Log.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.oSi = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.oSi == null) || (this.oSi.length() == 0))
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
        this.Wbk = ((PayResp)localObject1);
        this.Wbk.prepayId = localPayReq.prepayId;
        this.Wbk.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label386;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        Log.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.Wbk.errCode = -1;
        this.Wbk.errStr = getString(a.i.pay_callback_errmsg_req_checkargs_fail);
        e.a(this, this.oSi, this.Wbk, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        Log.e(this.TAG, "onCreate, checkAppResult fail");
        this.Wbk.errCode = -1;
        e.a(this, this.oSi, this.Wbk, this.options);
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
            localObject2 = u.cF(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = dat();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            if ((this.mScene != 1) || (!this.Wbq)) {
              break;
            }
            imo();
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayH5Pay(this, getIntent().getExtras(), str1, str2, (String)localObject2, (String)localObject4);
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
        if ((((String)localObject1).startsWith("sns_")) && (this.Wbr)) {}
        for (i = 1; i != 0; i = 1)
        {
          imo();
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
          AppMethodBeat.o(71870);
          return;
          if ((((String)localObject1).startsWith("sns_")) || (!this.Wbp)) {
            break label841;
          }
        }
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(397, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(2655, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.model.h(localPayReq, str1, str2, localObject3, (String)localObject4);
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
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
      AppMethodBeat.o(71870);
      return;
      label799:
      localObject1 = localObject5;
      if (localPayReq.prepayId.startsWith("sns_")) {
        localObject1 = new j(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71873);
    if ((paramp.getType() != 397) && (paramp.getType() != 2655) && (paramp.getType() != 283))
    {
      AppMethodBeat.o(71873);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    if (this.mScene == 1)
    {
      localPayInfo.hUR = 36;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(paramp.getType(), this);
      Log.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.model.h)paramp;
      paramp = (ebl)c.c.b(((com.tencent.mm.plugin.wallet_index.model.h)localObject3).rr.otC);
      if (paramp != null) {
        break label233;
      }
      paramp = null;
      label154:
      this.Wbm = paramp;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      Log.e(this.TAG, "onSceneEnd, auth access denied");
      this.Wbk.errCode = -1;
      dF(paramString, true);
      paramInt1 = localPayInfo.hUR;
      if (this.Wbj != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.Wbj.prepayId)
    {
      ag.G(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.hUR = 2;
      break;
      paramp = paramp.abhc;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.Wbk.errCode = -1;
      dF(paramString, true);
      paramInt1 = localPayInfo.hUR;
      if (this.Wbj == null) {}
      for (paramString = "";; paramString = this.Wbj.prepayId)
      {
        ag.G(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramp = (ebl)c.c.b(((com.tencent.mm.plugin.wallet_index.model.h)localObject3).rr.otC);
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramp == null)
    {
      paramInt1 = -1;
      paramp = (ebl)c.c.b(((com.tencent.mm.plugin.wallet_index.model.h)localObject3).rr.otC);
      if (paramp != null) {
        break label529;
      }
      paramp = null;
      localObject1 = (ebl)c.c.b(((com.tencent.mm.plugin.wallet_index.model.h)localObject3).rr.otC);
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (ebl)c.c.b(((com.tencent.mm.plugin.wallet_index.model.h)localObject3).rr.otC);
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (ebl)c.c.b(((com.tencent.mm.plugin.wallet_index.model.h)localObject3).rr.otC);
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((ebl)localObject3).aalU)
    {
      Log.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramp, localObject1, localObject2 });
      if (!Util.isNullOrNil((String)localObject1)) {
        break label569;
      }
      Log.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.Wbk.errCode = -1;
      dF(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramp.ytv;
      break;
      paramp = paramp.ytw;
      break label373;
      localObject1 = ((ebl)localObject1).aalO;
      break label397;
      localObject2 = ((ebl)localObject2).aalP;
      break label421;
    }
    label569:
    ag.G(localPayInfo.hUR, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!Util.isNullOrNil(((geh)localObject3).acbS)))
    {
      this.Wbs = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((geh)localObject3).acbS);
      paramString.putExtra("need_dialog", ((geh)localObject3).acbU);
      paramString.putExtra("dialog_text", ((geh)localObject3).acbV);
      paramString.putExtra("max_count", ((geh)localObject3).acbT.ZaY);
      paramString.putExtra("inteval_time", ((geh)localObject3).acbT.ZaX);
      paramString.putExtra("default_wording", ((geh)localObject3).acbT.ZaZ);
      com.tencent.mm.br.c.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.hAT = ((String)localObject1);
      this.Wbl = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.Wbj.appId;
      localPayInfo.hAT = ((String)localObject1);
      localPayInfo.partnerId = this.Wbj.partnerId;
      localPayInfo.Wan = ((String)localObject2);
      localPayInfo.YvF = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramp;
      if (this.vsH > 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(641L, 2L, Util.milliSecondsToNow(this.vsH), true);
        if (localPayInfo.nKf == null) {
          localPayInfo.nKf = new Bundle();
        }
        localPayInfo.nKf.putLong("wallet_pay_key_check_time", this.vsH);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */