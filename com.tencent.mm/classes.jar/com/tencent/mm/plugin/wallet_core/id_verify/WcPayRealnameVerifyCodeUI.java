package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.wallet_core.id_verify.model.c;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WcPayRealnameVerifyCodeUI
  extends WalletBaseUI
{
  private WalletFormView HRV;
  private WalletFormView HRW;
  private Button HRX;
  private TextView HRY;
  private ViewGroup HRZ;
  private TextView HSa;
  private a HSb;
  private String HSc = "+86";
  private boolean HSd = false;
  private Button krs;
  
  private void fPY()
  {
    AppMethodBeat.i(174473);
    this.HSa.setText(this.HSc);
    AppMethodBeat.o(174473);
  }
  
  public int getLayoutId()
  {
    return 2131497045;
  }
  
  public void initView()
  {
    AppMethodBeat.i(174470);
    this.HRV = ((WalletFormView)findViewById(2131310594));
    this.HRW = ((WalletFormView)findViewById(2131310596));
    this.HRX = ((Button)findViewById(2131310595));
    this.krs = ((Button)findViewById(2131310591));
    this.HRY = ((TextView)findViewById(2131310590));
    this.HRZ = ((ViewGroup)findViewById(2131310592));
    this.HSa = ((TextView)findViewById(2131310593));
    int i = getResources().getDimensionPixelSize(2131165498);
    int j = getResources().getDimensionPixelSize(2131165277);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.HRV.getInfoIv().setLayoutParams(localLayoutParams);
    this.HRV.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.HRV.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099749));
    this.HRW.getContentEt().setPadding(this.HRW.getContentEt().getPaddingLeft(), this.HRW.getContentEt().getPaddingTop(), 0, this.HRW.getContentEt().getPaddingBottom());
    this.HRX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174458);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
          String str2 = a.S(paramAnonymousView.HQQ).getString("realname_verify_process_req_key", "");
          new com.tencent.mm.plugin.wallet_core.id_verify.model.b((String)localObject, str1, paramAnonymousView.HQT, str2).aYI().b(new a.b.2(paramAnonymousView));
          if (paramAnonymousView.HQT == 0) {
            paramAnonymousView.HQT += 1;
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
    this.krs.setOnClickListener(new x()
    {
      public final void czW()
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
            new c(a.R(((a.b)localObject).HQQ).getString("realname_verify_process_req_key", ""), str1, str2, str3).aYI().b(new a.b.1((a.b)localObject));
            AppMethodBeat.o(174459);
            return;
          }
          Log.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
        }
        AppMethodBeat.o(174459);
      }
    });
    this.HRV.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
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
      
      public final boolean eIg()
      {
        return false;
      }
    });
    this.HRV.setOnInputValidChangeListener(new WcPayRealnameVerifyCodeUI.5(this));
    this.HRW.a(new WcPayRealnameVerifyCodeUI.6(this));
    this.HRZ.setOnClickListener(new WcPayRealnameVerifyCodeUI.7(this));
    fPY();
    this.HRY.setOnClickListener(new WcPayRealnameVerifyCodeUI.8(this));
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
      this.HSc = ("+" + paramIntent.getStringExtra("couttry_code"));
      Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "countryName: %s, countryCode: %s", new Object[] { str, this.HSc });
      fPY();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(174471);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(174469);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setBackBtn(new WcPayRealnameVerifyCodeUI.1(this), 2131689494);
    initView();
    AppMethodBeat.o(174469);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(174472);
    super.onDestroy();
    if (this.HSb != null) {
      this.HSb.cancel();
    }
    AppMethodBeat.o(174472);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
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
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setText(WcPayRealnameVerifyCodeUI.this.getString(2131768514));
      WcPayRealnameVerifyCodeUI.i(WcPayRealnameVerifyCodeUI.this);
      WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
      AppMethodBeat.o(174468);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(174467);
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setText(WcPayRealnameVerifyCodeUI.this.getString(2131768513, new Object[] { paramLong / 1000L + "s" }));
      AppMethodBeat.o(174467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */