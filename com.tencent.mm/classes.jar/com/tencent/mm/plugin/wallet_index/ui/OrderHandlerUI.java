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
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private PayReq AxM;
  private PayResp AxN;
  private boolean AxO;
  private String AxP;
  private boolean AxQ;
  private boolean AxR;
  private boolean AxS;
  private boolean AxT;
  private boolean AxU;
  private c AxV;
  public String TAG;
  private String dcE;
  private String hrm;
  private long mLu;
  private int mScene;
  private PayReq.Options options;
  private c uxB;
  private boolean vEq;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.AxO = false;
    this.mScene = 0;
    this.AxP = "";
    this.AxQ = false;
    this.mLu = 0L;
    this.AxR = false;
    this.AxS = false;
    this.AxT = false;
    this.vEq = false;
    this.AxU = false;
    this.uxB = new c() {};
    this.AxV = new c() {};
    AppMethodBeat.o(71868);
  }
  
  private void Ug(String paramString)
  {
    AppMethodBeat.i(71880);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131765901);
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
  
  private PayReq bBn()
  {
    AppMethodBeat.i(71871);
    if (y.k(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(y.be(getIntent()));
      AppMethodBeat.o(71871);
      return localObject;
    }
  }
  
  private void bX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.AxP)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        Ug(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      br(this, this.AxP);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.hrm, this.AxN, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private void br(Context paramContext, String paramString)
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
    if (bt.T(paramContext, paramString))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.adn(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private void efC()
  {
    AppMethodBeat.i(71878);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
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
    if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.eBg().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
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
    nx localnx = new nx();
    localnx.dsX.ret = 1;
    com.tencent.mm.sdk.b.a.ESL.l(localnx);
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    ad.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.vEq), bt.eGN().toString() });
    if (this.vEq)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.vEq = true;
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
    ad.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.AxN, Boolean.valueOf(this.AxO) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        ad.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.AxN, Boolean.valueOf(this.AxO), Integer.valueOf(paramInt1) });
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
    if ((this.AxN != null) && (!this.AxO))
    {
      ad.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.AxN.errCode = -2;
      bX("", false);
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
    this.mLu = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ab.fka();
    com.tencent.mm.sdk.b.a.ESL.c(this.uxB);
    com.tencent.mm.sdk.b.a.ESL.c(this.AxV);
    com.tencent.mm.wallet_core.b.fjk();
    this.AxR = com.tencent.mm.wallet_core.b.b(b.a.pom, true);
    if ((this.AxR) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY")))
    {
      bool1 = true;
      this.AxS = bool1;
      if ((!this.AxR) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY"))) {
        break label197;
      }
    }
    label197:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.AxT = bool1;
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fnl();
      AppMethodBeat.o(71869);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(397, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(2655, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(283, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.uxB);
    com.tencent.mm.sdk.b.a.ESL.d(this.AxV);
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = bBn();
    Object localObject1;
    String str1;
    label388:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.AxM == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.AxM.prepayId))))
    {
      this.AxM = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      ad.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.hrm = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.hrm == null) || (this.hrm.length() == 0))
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
        this.AxN = ((PayResp)localObject1);
        this.AxN.prepayId = localPayReq.prepayId;
        this.AxN.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label388;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        ad.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.AxN.errCode = -1;
        this.AxN.errStr = getString(2131761837);
        e.a(this, this.hrm, this.AxN, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        ad.e(this.TAG, "onCreate, checkAppResult fail");
        this.AxN.errCode = -1;
        e.a(this, this.hrm, this.AxN, this.options);
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
          boolean bool3;
          boolean bool4;
          boolean bool5;
          ad.printErrStackTrace(this.TAG, localNameNotFoundException1, "", new Object[0]);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          try
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.bI(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = bBn();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            bool3 = ((String)localObject1).startsWith("sns_");
            bool4 = ((String)localObject1).startsWith("tax_");
            bool5 = ((String)localObject1).startsWith("seb_ff_");
            if ((!bool3) && (!bool4) && (!bool5)) {
              break label663;
            }
            bool1 = true;
            bool3 = this.AxT;
            if (bool1) {
              break label668;
            }
            bool2 = true;
            this.AxT = (bool2 & bool3);
            bool3 = this.AxS;
            if (bool1) {
              break label673;
            }
            bool1 = true;
            this.AxS = (bool1 & bool3);
            if ((this.mScene != 1) || (!this.AxT)) {
              break;
            }
            efC();
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayH5Pay(this, getIntent().getExtras(), str1, str2, (String)localObject2, (String)localObject4);
            AppMethodBeat.o(71870);
            return;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            boolean bool1;
            boolean bool2;
            Object localObject3;
            break label641;
          }
          localNameNotFoundException1 = localNameNotFoundException1;
          localObject1 = localObject5;
        }
        label641:
        localObject3 = localObject1;
        continue;
        label663:
        bool1 = false;
        continue;
        label668:
        bool2 = false;
        continue;
        label673:
        bool1 = false;
      }
      if ((this.mScene == 0) && (this.AxS))
      {
        efC();
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
        AppMethodBeat.o(71870);
        return;
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(397, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(2655, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.c.g(localPayReq, str1, str2, localObject3, (String)localObject4);
      localObject1 = localObject5;
      if (!bt.isNullOrNil(localPayReq.prepayId))
      {
        if (!localPayReq.prepayId.startsWith("up_")) {
          break label875;
        }
        localObject1 = new l(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
      AppMethodBeat.o(71870);
      return;
      label875:
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
      localPayInfo.dtb = 36;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(paramn.getType(), this);
      ad.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.g)paramn;
      paramn = (byq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.gUT.gUX;
      if (paramn != null) {
        break label233;
      }
      paramn = null;
      label154:
      this.AxP = paramn;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      ad.e(this.TAG, "onSceneEnd, auth access denied");
      this.AxN.errCode = -1;
      bX(paramString, true);
      paramInt1 = localPayInfo.dtb;
      if (this.AxM != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.AxM.prepayId)
    {
      af.v(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.dtb = 2;
      break;
      paramn = paramn.DVy;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.AxN.errCode = -1;
      bX(paramString, true);
      paramInt1 = localPayInfo.dtb;
      if (this.AxM == null) {}
      for (paramString = "";; paramString = this.AxM.prepayId)
      {
        af.v(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramn = (byq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.gUT.gUX;
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramn == null)
    {
      paramInt1 = -1;
      paramn = (byq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.gUT.gUX;
      if (paramn != null) {
        break label529;
      }
      paramn = null;
      localObject1 = (byq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.gUT.gUX;
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (byq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.gUT.gUX;
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (byq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.gUT.gUX;
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((byq)localObject3).DoV)
    {
      ad.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramn, localObject1, localObject2 });
      if (!bt.isNullOrNil((String)localObject1)) {
        break label569;
      }
      ad.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.AxN.errCode = -1;
      bX(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramn.oXv;
      break;
      paramn = paramn.oXw;
      break label373;
      localObject1 = ((byq)localObject1).DoP;
      break label397;
      localObject2 = ((byq)localObject2).DoQ;
      break label421;
    }
    label569:
    af.v(localPayInfo.dtb, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!bt.isNullOrNil(((dpt)localObject3).EFF)))
    {
      this.AxU = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((dpt)localObject3).EFF);
      paramString.putExtra("need_dialog", ((dpt)localObject3).EFH);
      paramString.putExtra("dialog_text", ((dpt)localObject3).EFI);
      paramString.putExtra("max_count", ((dpt)localObject3).EFG.COZ);
      paramString.putExtra("inteval_time", ((dpt)localObject3).EFG.COY);
      paramString.putExtra("default_wording", ((dpt)localObject3).EFG.CPa);
      d.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.dcE = ((String)localObject1);
      this.AxO = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.AxM.appId;
      localPayInfo.dcE = ((String)localObject1);
      localPayInfo.partnerId = this.AxM.partnerId;
      localPayInfo.Axg = ((String)localObject2);
      localPayInfo.Cor = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramn;
      if (this.mLu > 0L)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(641L, 2L, bt.vM(this.mLu), true);
        if (localPayInfo.Cos == null) {
          localPayInfo.Cos = new Bundle();
        }
        localPayInfo.Cos.putLong("wallet_pay_key_check_time", this.mLu);
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