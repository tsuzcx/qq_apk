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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private PayReq DIg;
  private PayResp DIh;
  private boolean DIi;
  private String DIj;
  private boolean DIk;
  private boolean DIl;
  private boolean DIm;
  private boolean DIn;
  private boolean DIo;
  private boolean DIp;
  private c DIq;
  public String TAG;
  private String dmw;
  private String inV;
  private int mScene;
  private long nTW;
  private PayReq.Options options;
  private c xdp;
  private boolean yrU;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.DIi = false;
    this.mScene = 0;
    this.DIj = "";
    this.DIk = false;
    this.nTW = 0L;
    this.DIl = false;
    this.DIm = false;
    this.DIn = false;
    this.DIo = false;
    this.yrU = false;
    this.DIp = false;
    this.xdp = new c() {};
    this.DIq = new c() {};
    AppMethodBeat.o(71868);
  }
  
  private void acP(String paramString)
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
  
  private PayReq bNs()
  {
    AppMethodBeat.i(71871);
    if (z.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(z.bl(getIntent()));
      AppMethodBeat.o(71871);
      return localObject;
    }
  }
  
  private void bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71879);
    if (paramContext == null)
    {
      ae.e(this.TAG, "startOuterApp context == null");
      AppMethodBeat.o(71879);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ae.e(this.TAG, "startOuterApp callbackUrl is empty");
      AppMethodBeat.o(71879);
      return;
    }
    ae.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    if (bu.aj(paramContext, paramString))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.ahE(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private void cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.DIj)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        acP(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      bx(this, this.DIj);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.inV, this.DIh, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private void eMK()
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
    if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.fju().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
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
    oq localoq = new oq();
    localoq.dDD.ret = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localoq);
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    ae.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.yrU), bu.fpN().toString() });
    if (this.yrU)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.yrU = true;
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
    ae.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.DIh, Boolean.valueOf(this.DIi) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        ae.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.DIh, Boolean.valueOf(this.DIi), Integer.valueOf(paramInt1) });
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
    if ((this.DIh != null) && (!this.DIi))
    {
      ae.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.DIh.errCode = -2;
      cq("", false);
    }
    AppMethodBeat.o(71874);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(71877);
    super.onConfigurationChanged(paramConfiguration);
    ae.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(71877);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71869);
    super.onCreate(paramBundle);
    this.TAG = ("MicroMsg.OrderHandlerUI@" + hashCode());
    this.nTW = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ab.fVW();
    com.tencent.mm.sdk.b.a.IvT.c(this.xdp);
    com.tencent.mm.sdk.b.a.IvT.c(this.DIq);
    com.tencent.mm.wallet_core.b.fVf();
    this.DIl = com.tencent.mm.wallet_core.b.b(b.a.qDk, true);
    if ((this.DIl) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY")))
    {
      bool1 = true;
      this.DIm = bool1;
      if ((!this.DIl) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY"))) {
        break label212;
      }
    }
    label212:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.DIn = bool1;
      com.tencent.mm.wallet_core.b.fVf();
      this.DIo = com.tencent.mm.wallet_core.b.b(b.a.qDl, false);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fZs();
      AppMethodBeat.o(71869);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(397, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(2655, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(283, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.xdp);
    com.tencent.mm.sdk.b.a.IvT.d(this.DIq);
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = bNs();
    Object localObject1;
    String str1;
    label384:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.DIg == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.DIg.prepayId))))
    {
      this.DIg = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      ae.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.inV = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.inV == null) || (this.inV.length() == 0))
        {
          ae.e(this.TAG, "callerPkgName is null, dealOrder fail, can not callback");
          finish();
          AppMethodBeat.o(71870);
          return;
        }
      }
      this.options = new PayReq.Options();
      this.options.fromBundle(getIntent().getExtras());
      if (z.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
      for (localObject1 = new WXJointPay.JointPayResp();; localObject1 = new PayResp())
      {
        this.DIh = ((PayResp)localObject1);
        this.DIh.prepayId = localPayReq.prepayId;
        this.DIh.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label384;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        ae.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.DIh.errCode = -1;
        this.DIh.errStr = getString(2131761837);
        e.a(this, this.inV, this.DIh, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        ae.e(this.TAG, "onCreate, checkAppResult fail");
        this.DIh.errCode = -1;
        e.a(this, this.inV, this.DIh, this.options);
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
          ae.printErrStackTrace(this.TAG, localNameNotFoundException1, "", new Object[0]);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          try
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.bO(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = bNs();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            if ((this.mScene != 1) || (!this.DIn)) {
              break;
            }
            eMK();
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
        if ((((String)localObject1).startsWith("sns_")) && (this.DIo)) {}
        for (i = 1; i != 0; i = 1)
        {
          eMK();
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
          AppMethodBeat.o(71870);
          return;
          if ((((String)localObject1).startsWith("sns_")) || (!this.DIm)) {
            break label839;
          }
        }
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(397, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(2655, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.c.g(localPayReq, str1, str2, localObject3, (String)localObject4);
      localObject1 = localObject5;
      if (!bu.isNullOrNil(localPayReq.prepayId))
      {
        if (!localPayReq.prepayId.startsWith("up_")) {
          break label797;
        }
        localObject1 = new l(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject1, 0);
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
      localPayInfo.dDH = 36;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(paramn.getType(), this);
      ae.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.g)paramn;
      paramn = (cjf)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hQE.hQJ;
      if (paramn != null) {
        break label233;
      }
      paramn = null;
      label154:
      this.DIj = paramn;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      ae.e(this.TAG, "onSceneEnd, auth access denied");
      this.DIh.errCode = -1;
      cq(paramString, true);
      paramInt1 = localPayInfo.dDH;
      if (this.DIg != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.DIg.prepayId)
    {
      af.w(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.dDH = 2;
      break;
      paramn = paramn.HvS;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.DIh.errCode = -1;
      cq(paramString, true);
      paramInt1 = localPayInfo.dDH;
      if (this.DIg == null) {}
      for (paramString = "";; paramString = this.DIg.prepayId)
      {
        af.w(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramn = (cjf)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hQE.hQJ;
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramn == null)
    {
      paramInt1 = -1;
      paramn = (cjf)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hQE.hQJ;
      if (paramn != null) {
        break label529;
      }
      paramn = null;
      localObject1 = (cjf)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hQE.hQJ;
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (cjf)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hQE.hQJ;
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (cjf)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hQE.hQJ;
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((cjf)localObject3).GMv)
    {
      ae.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramn, localObject1, localObject2 });
      if (!bu.isNullOrNil((String)localObject1)) {
        break label569;
      }
      ae.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.DIh.errCode = -1;
      cq(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramn.qkQ;
      break;
      paramn = paramn.qkR;
      break label373;
      localObject1 = ((cjf)localObject1).GMp;
      break label397;
      localObject2 = ((cjf)localObject2).GMq;
      break label421;
    }
    label569:
    af.w(localPayInfo.dDH, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!bu.isNullOrNil(((eda)localObject3).Iie)))
    {
      this.DIp = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((eda)localObject3).Iie);
      paramString.putExtra("need_dialog", ((eda)localObject3).Iig);
      paramString.putExtra("dialog_text", ((eda)localObject3).Iih);
      paramString.putExtra("max_count", ((eda)localObject3).Iif.Ghq);
      paramString.putExtra("inteval_time", ((eda)localObject3).Iif.Ghp);
      paramString.putExtra("default_wording", ((eda)localObject3).Iif.Ghr);
      d.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.dmw = ((String)localObject1);
      this.DIi = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.DIg.appId;
      localPayInfo.dmw = ((String)localObject1);
      localPayInfo.partnerId = this.DIg.partnerId;
      localPayInfo.DHy = ((String)localObject2);
      localPayInfo.FEp = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramn;
      if (this.nTW > 0L)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(641L, 2L, bu.DD(this.nTW), true);
        if (localPayInfo.hwN == null) {
          localPayInfo.hwN = new Bundle();
        }
        localPayInfo.hwN.putLong("wallet_pay_key_check_time", this.nTW);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */