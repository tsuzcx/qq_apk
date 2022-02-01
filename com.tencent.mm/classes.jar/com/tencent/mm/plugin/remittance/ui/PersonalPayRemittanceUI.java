package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.az;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ero;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.f.m.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.model.g;
import com.tencent.mm.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import java.math.RoundingMode;

@com.tencent.mm.ui.base.a(3)
public class PersonalPayRemittanceUI
  extends WalletBaseUI
{
  private String Olk;
  private long Oll;
  private String Olm;
  private String Oln;
  private String Olo;
  private boolean Olp;
  private String app_id;
  private String displayName;
  private String hMy;
  private String nVs;
  private e pjp;
  private IListener<az> vrs;
  private j xcO;
  
  public PersonalPayRemittanceUI()
  {
    AppMethodBeat.i(288975);
    this.Olp = true;
    this.vrs = new IListener(f.hfK) {};
    AppMethodBeat.o(288975);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(288982);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(288982);
  }
  
  private void lA(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(288979);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString1 });
    g.a locala = new g.a(getContext());
    locala.bf("");
    paramString1 = locala.bDE(paramString1).NF(false);
    paramString1.Xdm = true;
    paramString1.aEX(a.i.wallet_alert_btn_i_know).b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(288995);
        Log.i("MicroMsg.PersonalPayRemittanceUI", "click error dialog");
        PersonalPayRemittanceUI.a(PersonalPayRemittanceUI.this, f.m.a.adwD, paramString2);
        AppMethodBeat.o(288995);
      }
    }).show();
    if (locala.pRv != null) {
      this.pjp = locala.pRv;
    }
    if (this.xcO != null)
    {
      this.xcO.cyW();
      this.xcO = null;
    }
    AppMethodBeat.o(288979);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(289027);
    a(f.m.a.adwE, "");
    super.onBackPressed();
    AppMethodBeat.o(289027);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289008);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    getWindow().addFlags(-2147483648);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.Olk = getIntent().getStringExtra("out_prepay_id");
    Log.i("MicroMsg.PersonalPayRemittanceUI", "app_id:%s，out_prepay_id：%s", new Object[] { this.app_id, this.Olk });
    if (Util.isNullOrNil(this.Olk)) {
      a(f.m.a.adwD, "out_prepay_id is empty");
    }
    addSceneEndListener(4912);
    doSceneProgress(new z(this.app_id, this.Olk), true);
    AppMethodBeat.o(289008);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(289012);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onDestroy()");
    super.onDestroy();
    this.vrs.dead();
    removeSceneEndListener(4912);
    removeSceneEndListener(4304);
    removeSceneEndListener(5003);
    removeSceneEndListener(5047);
    removeSceneEndListener(4587);
    AppMethodBeat.o(289012);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(289039);
    super.onPause();
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onPause()");
    AppMethodBeat.o(289039);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(289036);
    super.onResume();
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onResume()");
    AppMethodBeat.o(289036);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(289021);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof z))
    {
      hideProgress();
      hideLoading();
      Log.i("MicroMsg.PersonalPayRemittanceUI", "scene instanceof NetSceneC2CRequestPayment");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (z)paramp;
        if (paramString.Ojs == null)
        {
          paramString = new ero();
          Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneC2CRequestPayment on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.hAV), paramString.wYI });
          if (paramString.hAV != 0) {
            break label539;
          }
          if (paramString != null) {
            break label163;
          }
          Log.i("MicroMsg.PersonalPayRemittanceUI", "res == null");
          a(f.m.a.adwD, "request payment fail");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(289021);
        return true;
        paramString = paramString.Ojs;
        break;
        label163:
        Log.i("MicroMsg.PersonalPayRemittanceUI", "showHalfDialog：res.title：%s,res.head_img：%s，res.rcvr_info：%s，res.total_amount：%s，res.ok_button_wording：%s", new Object[] { paramString.title, paramString.Zga, paramString.Zgc, Long.valueOf(paramString.Oll), paramString.Zgd });
        this.xcO = new j(getContext(), 2, 3);
        Object localObject = View.inflate(getContext(), a.g.personal_pay_remittance_head, null);
        ((ImageView)((View)localObject).findViewById(a.f.back_cion)).setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(288998);
            PersonalPayRemittanceUI.e(PersonalPayRemittanceUI.this).cyW();
            PersonalPayRemittanceUI.f(PersonalPayRemittanceUI.this);
            PersonalPayRemittanceUI.g(PersonalPayRemittanceUI.this);
            PersonalPayRemittanceUI.a(PersonalPayRemittanceUI.this, f.m.a.adwE, "");
            AppMethodBeat.o(288998);
          }
        });
        TextView localTextView = (TextView)((View)localObject).findViewById(a.f.c2c_app_brand_title);
        localTextView.setText(paramString.title);
        paramp = View.inflate(getContext(), a.g.personal_pay_remittance_content, null);
        aw.a(localTextView.getPaint(), 0.8F);
        this.xcO.setHeaderView((View)localObject);
        localObject = (CdnImageView)paramp.findViewById(a.f.c2c_app_brand_avatar);
        if (!Util.isNullOrNil(paramString.Zga))
        {
          ((CdnImageView)localObject).setRoundCorner(true);
          ((CdnImageView)localObject).setRoundCornerRate(0.1F);
          ((CdnImageView)localObject).setUrl(paramString.Zga);
          this.nVs = paramString.Zga;
        }
        for (;;)
        {
          ((TextView)paramp.findViewById(a.f.c2c_app_brand_name)).setText(paramString.Zgc);
          this.displayName = paramString.Zgc;
          localObject = (TextView)paramp.findViewById(a.f.c2c_app_brand_money);
          this.Oll = paramString.Oll;
          ((TextView)localObject).setText(getString(a.i.remittance_personal_pay_money_format) + i.a(new StringBuilder().append(paramString.Oll).toString(), "100", 2, RoundingMode.HALF_UP));
          this.xcO.setCustomView(paramp);
          this.xcO.au(paramString.Zgd);
          this.xcO.aFe(0);
          this.xcO.agfR = new j.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(288992);
              Log.i("MicroMsg.PersonalPayRemittanceUI", "click pay button");
              PersonalPayRemittanceUI.h(PersonalPayRemittanceUI.this).alive();
              PersonalPayRemittanceUI.i(PersonalPayRemittanceUI.this);
              AppMethodBeat.o(288992);
            }
          };
          this.xcO.dDn();
          break;
          Log.i("MicroMsg.PersonalPayRemittanceUI", "res.head_img == null");
        }
        label539:
        lA(paramString.wYI, "request payment fail.");
        continue;
        Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
        lA(paramString, "request payment fail.");
      }
    }
    if ((paramp instanceof y))
    {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "scene instanceof NetSceneC2CPlaceOrder");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (y)paramp;
        if (paramString.Ojr == null) {}
        for (paramString = new un();; paramString = paramString.Ojr)
        {
          Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneC2CPlaceOrder on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.wuz), paramString.wuA });
          if (paramString.wuz != 0) {
            break label944;
          }
          if (paramString.YZV == null) {
            break;
          }
          hideProgress();
          hideLoading();
          Log.i("MicroMsg.PersonalPayRemittanceUI", "response.jump_remind != null");
          if (this.xcO != null)
          {
            this.xcO.cyW();
            this.xcO = null;
          }
          paramp = new Intent();
          paramp.putExtra("key_result_pay_result", f.m.a.adwD);
          paramp.putExtra("key_result_error_msg", "intercept by jump remind");
          setResult(-1, paramp);
          paramString = m.a(paramString.YZV);
          paramString.agTd = false;
          paramString.a(this, new g()
          {
            public final void fWQ()
            {
              AppMethodBeat.i(288994);
              PersonalPayRemittanceUI.a(PersonalPayRemittanceUI.this, f.m.a.adwD, "intercept by jump remind");
              AppMethodBeat.o(288994);
            }
          });
          AppMethodBeat.o(289021);
          return true;
        }
        Log.i("MicroMsg.PersonalPayRemittanceUI", "startPay");
        this.Olm = paramString.Olm;
        this.Oln = paramString.Oln;
        this.Olo = paramString.Olo;
        this.hMy = paramString.hMy;
        paramp = new PayInfo();
        paramp.hAT = paramString.hMy;
        paramp.Okk = 1;
        paramp.hUR = 65;
        paramp.nKf = new Bundle();
        paramp.nKf.putString("cashier_desc", paramString.OjY);
        paramp.nKf.putString("personalpay_order_id", paramString.Olm);
        paramp.nKf.putString("trans_id", paramString.Oln);
        paramp.nKf.putString("placeorder_ext", paramString.Olo);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramp);
      }
      for (;;)
      {
        AppMethodBeat.o(289021);
        return true;
        label944:
        hideProgress();
        hideLoading();
        lA(paramString.wuA, "place order fail.");
        continue;
        hideProgress();
        hideLoading();
        Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneC2CPlaceOrder on SceneEnd faile show error dialog ");
        lA(paramString, "place order fail.");
      }
    }
    if ((paramp instanceof w)) {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "scene instanceof NetScenePersonalPayCancelPay");
    }
    AppMethodBeat.o(289021);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(289030);
    AppMethodBeat.at(this, paramBoolean);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onWindowFocusChanged");
    if ((this.Olp) && (this.xcO != null) && (!this.xcO.isShowing()))
    {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.xcO.isShowing()) });
      this.xcO = null;
      a(f.m.a.adwE, "");
      com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.pjp != null) && (!this.pjp.isShowing()))
    {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.pjp.isShowing()) });
      this.pjp = null;
      a(f.m.a.adwD, "dialog fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(289030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.PersonalPayRemittanceUI
 * JD-Core Version:    0.7.0.1
 */