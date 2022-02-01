package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.au;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.f.l.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.math.RoundingMode;

@com.tencent.mm.ui.base.a(3)
public class PersonalPayRemittanceUI
  extends WalletBaseUI
{
  private IListener<au> InK;
  private String InS;
  private long InT;
  private String InU;
  private String InV;
  private String InW;
  private boolean InX;
  private String app_id;
  private String jmB;
  private String lqp;
  private d mpz;
  private com.tencent.mm.ui.widget.a.g tZx;
  
  public PersonalPayRemittanceUI()
  {
    AppMethodBeat.i(276689);
    this.InX = true;
    this.InK = new IListener() {};
    AppMethodBeat.o(276689);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(276695);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(276695);
  }
  
  private void ke(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(276693);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString1 });
    f.a locala = new f.a(getContext());
    locala.aR("");
    paramString1 = locala.bBl(paramString1).HL(false);
    paramString1.Qlf = true;
    paramString1.ayp(a.i.wallet_alert_btn_i_know).b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(273003);
        Log.i("MicroMsg.PersonalPayRemittanceUI", "click error dialog");
        PersonalPayRemittanceUI.a(PersonalPayRemittanceUI.this, f.l.a.VSu, paramString2);
        AppMethodBeat.o(273003);
      }
    }).show();
    if (locala.mUO != null) {
      this.mpz = locala.mUO;
    }
    if (this.tZx != null)
    {
      this.tZx.bYF();
      this.tZx = null;
    }
    AppMethodBeat.o(276693);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(276694);
    a(f.l.a.VSv, "");
    super.onBackPressed();
    AppMethodBeat.o(276694);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276690);
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
    this.InS = getIntent().getStringExtra("out_prepay_id");
    Log.i("MicroMsg.PersonalPayRemittanceUI", "app_id:%s，out_prepay_id：%s", new Object[] { this.app_id, this.InS });
    if (Util.isNullOrNil(this.InS)) {
      a(f.l.a.VSu, "out_prepay_id is empty");
    }
    addSceneEndListener(4912);
    doSceneProgress(new y(this.app_id, this.InS), true);
    AppMethodBeat.o(276690);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(276691);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onDestroy()");
    super.onDestroy();
    this.InK.dead();
    removeSceneEndListener(4912);
    removeSceneEndListener(4304);
    removeSceneEndListener(5003);
    removeSceneEndListener(5047);
    removeSceneEndListener(4587);
    AppMethodBeat.o(276691);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(276699);
    super.onPause();
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onPause()");
    AppMethodBeat.o(276699);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(276698);
    super.onResume();
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onResume()");
    AppMethodBeat.o(276698);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(276692);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof y))
    {
      hideProgress();
      hideLoading();
      Log.i("MicroMsg.PersonalPayRemittanceUI", "scene instanceof NetSceneC2CRequestPayment");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (y)paramq;
        if (paramString.Imb == null)
        {
          paramString = new dyk();
          Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneC2CRequestPayment on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.fwx), paramString.tVo });
          if (paramString.fwx != 0) {
            break label539;
          }
          if (paramString != null) {
            break label163;
          }
          Log.i("MicroMsg.PersonalPayRemittanceUI", "res == null");
          a(f.l.a.VSu, "request payment fail");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(276692);
        return true;
        paramString = paramString.Imb;
        break;
        label163:
        Log.i("MicroMsg.PersonalPayRemittanceUI", "showHalfDialog：res.title：%s,res.head_img：%s，res.rcvr_info：%s，res.total_amount：%s，res.ok_button_wording：%s", new Object[] { paramString.title, paramString.ShU, paramString.ShW, Long.valueOf(paramString.InT), paramString.ShX });
        this.tZx = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 3);
        Object localObject = View.inflate(getContext(), a.g.personal_pay_remittance_head, null);
        ((ImageView)((View)localObject).findViewById(a.f.back_cion)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(271288);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/PersonalPayRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            PersonalPayRemittanceUI.d(PersonalPayRemittanceUI.this).bYF();
            PersonalPayRemittanceUI.e(PersonalPayRemittanceUI.this);
            PersonalPayRemittanceUI.f(PersonalPayRemittanceUI.this);
            PersonalPayRemittanceUI.a(PersonalPayRemittanceUI.this, f.l.a.VSv, "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/PersonalPayRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(271288);
          }
        });
        TextView localTextView = (TextView)((View)localObject).findViewById(a.f.c2c_app_brand_title);
        localTextView.setText(paramString.title);
        paramq = View.inflate(getContext(), a.g.personal_pay_remittance_content, null);
        ar.a(localTextView.getPaint(), 0.8F);
        this.tZx.setHeaderView((View)localObject);
        localObject = (CdnImageView)paramq.findViewById(a.f.c2c_app_brand_avatar);
        if (!Util.isNullOrNil(paramString.ShU))
        {
          ((CdnImageView)localObject).setRoundCorner(true);
          ((CdnImageView)localObject).setRoundCornerRate(0.1F);
          ((CdnImageView)localObject).setUrl(paramString.ShU);
          this.lqp = paramString.ShU;
        }
        for (;;)
        {
          ((TextView)paramq.findViewById(a.f.c2c_app_brand_name)).setText(paramString.ShW);
          this.jmB = paramString.ShW;
          localObject = (TextView)paramq.findViewById(a.f.c2c_app_brand_money);
          this.InT = paramString.InT;
          ((TextView)localObject).setText(getString(a.i.remittance_personal_pay_money_format) + com.tencent.mm.wallet_core.ui.g.a(new StringBuilder().append(paramString.InT).toString(), "100", 2, RoundingMode.HALF_UP));
          this.tZx.setCustomView(paramq);
          this.tZx.ah(paramString.ShX);
          this.tZx.ayu(0);
          this.tZx.YnF = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(272005);
              Log.i("MicroMsg.PersonalPayRemittanceUI", "click pay button");
              PersonalPayRemittanceUI.g(PersonalPayRemittanceUI.this).alive();
              PersonalPayRemittanceUI.h(PersonalPayRemittanceUI.this);
              AppMethodBeat.o(272005);
            }
          };
          this.tZx.eik();
          break;
          Log.i("MicroMsg.PersonalPayRemittanceUI", "res.head_img == null");
        }
        label539:
        ke(paramString.tVo, "request payment fail.");
        continue;
        Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
        ke(paramString, "request payment fail.");
      }
    }
    if ((paramq instanceof x))
    {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "scene instanceof NetSceneC2CPlaceOrder");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (x)paramq;
        if (paramString.Ima == null) {}
        for (paramString = new sx();; paramString = paramString.Ima)
        {
          Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneC2CPlaceOrder on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.tqa), paramString.tqb });
          if (paramString.tqa != 0) {
            break label936;
          }
          if (paramString.Scd == null) {
            break;
          }
          hideProgress();
          hideLoading();
          Log.i("MicroMsg.PersonalPayRemittanceUI", "response.jump_remind != null");
          if (this.tZx != null)
          {
            this.tZx.bYF();
            this.tZx = null;
          }
          paramq = new Intent();
          paramq.putExtra("key_result_pay_result", f.l.a.VSu);
          paramq.putExtra("key_result_error_msg", "intercept by jump remind");
          setResult(-1, paramq);
          paramString = m.a(paramString.Scd);
          paramString.YVj = false;
          paramString.a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void eOt()
            {
              AppMethodBeat.i(204861);
              PersonalPayRemittanceUI.a(PersonalPayRemittanceUI.this, f.l.a.VSu, "intercept by jump remind");
              AppMethodBeat.o(204861);
            }
          });
          AppMethodBeat.o(276692);
          return true;
        }
        Log.i("MicroMsg.PersonalPayRemittanceUI", "startPay");
        this.InU = paramString.InU;
        this.InV = paramString.InV;
        this.InW = paramString.InW;
        paramq = new PayInfo();
        paramq.fwv = paramString.fHb;
        paramq.ImU = 1;
        paramq.fOY = 65;
        paramq.lfu = new Bundle();
        paramq.lfu.putString("cashier_desc", paramString.ImI);
        paramq.lfu.putString("personalpay_order_id", paramString.InU);
        paramq.lfu.putString("trans_id", paramString.InV);
        paramq.lfu.putString("placeorder_ext", paramString.InW);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramq);
      }
      for (;;)
      {
        AppMethodBeat.o(276692);
        return true;
        label936:
        hideProgress();
        hideLoading();
        ke(paramString.tqb, "place order fail.");
        continue;
        hideProgress();
        hideLoading();
        Log.i("MicroMsg.PersonalPayRemittanceUI", "NetSceneC2CPlaceOrder on SceneEnd faile show error dialog ");
        ke(paramString, "place order fail.");
      }
    }
    if ((paramq instanceof v)) {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "scene instanceof NetScenePersonalPayCancelPay");
    }
    AppMethodBeat.o(276692);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(276697);
    AppMethodBeat.at(this, paramBoolean);
    Log.i("MicroMsg.PersonalPayRemittanceUI", "onWindowFocusChanged");
    if ((this.InX) && (this.tZx != null) && (!this.tZx.isShowing()))
    {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.tZx.isShowing()) });
      this.tZx = null;
      a(f.l.a.VSv, "");
      com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.mpz != null) && (!this.mpz.isShowing()))
    {
      Log.i("MicroMsg.PersonalPayRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.mpz.isShowing()) });
      this.mpz = null;
      a(f.l.a.VSu, "dialog fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(276697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.PersonalPayRemittanceUI
 * JD-Core Version:    0.7.0.1
 */