package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.wallet_core.id_verify.model.c;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.HashSet;

public class WcPayRealnameVerifyCodeUI
  extends WalletBaseUI
{
  private WalletFormView VzO;
  private WalletFormView VzP;
  private Button VzQ;
  private TextView VzR;
  private ViewGroup VzS;
  private TextView VzT;
  private a VzU;
  private String VzV = "+86";
  private boolean VzW = false;
  private Button qgp;
  
  private void ihS()
  {
    AppMethodBeat.i(174473);
    this.VzT.setText(this.VzV);
    AppMethodBeat.o(174473);
  }
  
  public int getLayoutId()
  {
    return a.g.wc_pay_realname_verify_code_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(174470);
    this.VzO = ((WalletFormView)findViewById(a.f.wprc_phone_et));
    this.VzP = ((WalletFormView)findViewById(a.f.wprc_verify_code_et));
    this.VzQ = ((Button)findViewById(a.f.wprc_resend_verify_code_btn));
    this.qgp = ((Button)findViewById(a.f.wprc_next_btn));
    this.VzR = ((TextView)findViewById(a.f.wprc_get_verify_code_fail_tv));
    this.VzS = ((ViewGroup)findViewById(a.f.wprc_phone_code_layout));
    this.VzT = ((TextView)findViewById(a.f.wprc_phone_code_tv));
    int i = getResources().getDimensionPixelSize(a.d.LargePadding);
    int j = getResources().getDimensionPixelSize(a.d.Edge_0_5_A);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.VzO.getInfoIv().setLayoutParams(localLayoutParams);
    this.VzO.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.VzO.getInfoIv().setClearBtnDrawableId(a.h.icons_filled_close2, getResources().getColor(a.c.FG_2));
    this.VzP.getContentEt().setPadding(this.VzP.getContentEt().getPaddingLeft(), this.VzP.getContentEt().getPaddingTop(), 0, this.VzP.getContentEt().getPaddingBottom());
    this.VzQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174458);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click resend btn");
        WcPayRealnameVerifyCodeUI.a(WcPayRealnameVerifyCodeUI.this);
        paramAnonymousView = WcPayRealnameVerifyCodeUI.this.getNetController();
        if ((paramAnonymousView instanceof a.b))
        {
          paramAnonymousView = (a.b)paramAnonymousView;
          localObject = WcPayRealnameVerifyCodeUI.b(WcPayRealnameVerifyCodeUI.this).getText();
          String str1 = WcPayRealnameVerifyCodeUI.c(WcPayRealnameVerifyCodeUI.this);
          Log.i("MicroMsg.RealNameVerifyProcess", "do resend verify code");
          Log.i("MicroMsg.RealNameVerifyProcess", "do send sms: %s", new Object[] { localObject });
          String str2 = a.S(paramAnonymousView.VyK).getString("realname_verify_process_req_key", "");
          new com.tencent.mm.plugin.wallet_core.id_verify.model.b((String)localObject, str1, paramAnonymousView.VyN, str2).bFJ().b(new a.b.2(paramAnonymousView));
          if (paramAnonymousView.VyN == 0) {
            paramAnonymousView.VyN += 1;
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174458);
          return;
          Log.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
        }
      }
    });
    this.qgp.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(174459);
        WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
        if (WcPayRealnameVerifyCodeUI.e(WcPayRealnameVerifyCodeUI.this).isEnabled())
        {
          Object localObject = WcPayRealnameVerifyCodeUI.this.getNetController();
          if ((localObject instanceof a.b))
          {
            localObject = (a.b)localObject;
            String str1 = WcPayRealnameVerifyCodeUI.b(WcPayRealnameVerifyCodeUI.this).getText();
            String str2 = WcPayRealnameVerifyCodeUI.c(WcPayRealnameVerifyCodeUI.this);
            String str3 = WcPayRealnameVerifyCodeUI.f(WcPayRealnameVerifyCodeUI.this).getText();
            Log.i("MicroMsg.RealNameVerifyProcess", "do check verify code");
            ((WalletBaseUI)((a.b)localObject).activity).showProgress();
            new c(a.R(((a.b)localObject).VyK).getString("realname_verify_process_req_key", ""), str1, str2, str3).bFJ().b(new a.b.1((a.b)localObject));
            AppMethodBeat.o(174459);
            return;
          }
          Log.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
        }
        AppMethodBeat.o(174459);
      }
    });
    this.VzO.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
    {
      public final boolean a(WalletFormView paramAnonymousWalletFormView)
      {
        AppMethodBeat.i(174460);
        if ("+86".equals(WcPayRealnameVerifyCodeUI.c(WcPayRealnameVerifyCodeUI.this)))
        {
          boolean bool = paramAnonymousWalletFormView.isPhoneNum();
          AppMethodBeat.o(174460);
          return bool;
        }
        if ((!Util.isNullOrNil(WcPayRealnameVerifyCodeUI.c(WcPayRealnameVerifyCodeUI.this))) && (!Util.isNullOrNil(WcPayRealnameVerifyCodeUI.b(WcPayRealnameVerifyCodeUI.this).getText())))
        {
          AppMethodBeat.o(174460);
          return true;
        }
        AppMethodBeat.o(174460);
        return false;
      }
      
      public final boolean a(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean b(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
      {
        return false;
      }
      
      public final String c(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
      {
        return null;
      }
      
      public final boolean gGa()
      {
        return false;
      }
    });
    this.VzO.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(174461);
        Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "phone valid change: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
        WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
        AppMethodBeat.o(174461);
      }
    });
    this.VzP.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(174462);
        WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
        AppMethodBeat.o(174462);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.VzS.setOnClickListener(new WcPayRealnameVerifyCodeUI.7(this));
    ihS();
    this.VzR.setOnClickListener(new WcPayRealnameVerifyCodeUI.8(this));
    AppMethodBeat.o(174470);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174471);
    if ((paramInt1 == 1) && (paramInt2 == 100))
    {
      String str = paramIntent.getStringExtra("country_name");
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "user canceled this select");
        AppMethodBeat.o(174471);
        return;
      }
      this.VzV = ("+" + paramIntent.getStringExtra("couttry_code"));
      Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "countryName: %s, countryCode: %s", new Object[] { str, this.VzV });
      ihS();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(174471);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(174469);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.c.BG_5));
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(174457);
        paramAnonymousMenuItem = WcPayRealnameVerifyCodeUI.this.getProcess();
        if (paramAnonymousMenuItem != null) {
          paramAnonymousMenuItem.i(WcPayRealnameVerifyCodeUI.this.getContext(), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(174457);
          return false;
          WcPayRealnameVerifyCodeUI.this.finish();
        }
      }
    }, a.h.actionbar_icon_dark_close);
    initView();
    AppMethodBeat.o(174469);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(174472);
    super.onDestroy();
    if (this.VzU != null) {
      this.VzU.cancel();
    }
    AppMethodBeat.o(174472);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301368);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(g.class);
    AppMethodBeat.o(301368);
  }
  
  final class a
    extends CountDownTimer
  {
    public a()
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(174468);
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setText(WcPayRealnameVerifyCodeUI.this.getString(a.i.wc_pay_realname_resend_verify_code_text_1));
      WcPayRealnameVerifyCodeUI.i(WcPayRealnameVerifyCodeUI.this);
      WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
      AppMethodBeat.o(174468);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(174467);
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setText(WcPayRealnameVerifyCodeUI.this.getString(a.i.wc_pay_realname_resend_verify_code_text, new Object[] { paramLong / 1000L + "s" }));
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setContentDescription(WcPayRealnameVerifyCodeUI.this.getString(a.i.wc_pay_realname_resend_verify_code_text_2, new Object[] { paramLong / 1000L }));
      AppMethodBeat.o(174467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */