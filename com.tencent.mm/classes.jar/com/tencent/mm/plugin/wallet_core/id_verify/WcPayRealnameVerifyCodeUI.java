package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
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
import com.tencent.mm.al.n;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.wallet_core.id_verify.model.c;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WcPayRealnameVerifyCodeUI
  extends WalletBaseUI
{
  private Button iwY;
  private WalletFormView zYp;
  private WalletFormView zYq;
  private Button zYr;
  private TextView zYs;
  private ViewGroup zYt;
  private TextView zYu;
  private a zYv;
  private String zYw = "+86";
  private boolean zYx = false;
  
  private void ebs()
  {
    AppMethodBeat.i(174473);
    this.zYu.setText(this.zYw);
    AppMethodBeat.o(174473);
  }
  
  public int getLayoutId()
  {
    return 2131496065;
  }
  
  public void initView()
  {
    AppMethodBeat.i(174470);
    this.zYp = ((WalletFormView)findViewById(2131307070));
    this.zYq = ((WalletFormView)findViewById(2131307072));
    this.zYr = ((Button)findViewById(2131307071));
    this.iwY = ((Button)findViewById(2131307067));
    this.zYs = ((TextView)findViewById(2131307066));
    this.zYt = ((ViewGroup)findViewById(2131307068));
    this.zYu = ((TextView)findViewById(2131307069));
    int i = getResources().getDimensionPixelSize(2131165480);
    int j = getResources().getDimensionPixelSize(2131165274);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    localLayoutParams.rightMargin = j;
    this.zYp.getInfoIv().setLayoutParams(localLayoutParams);
    this.zYp.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.zYp.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(2131099735));
    this.zYq.getContentEt().setPadding(this.zYq.getContentEt().getPaddingLeft(), this.zYq.getContentEt().getPaddingTop(), 0, this.zYq.getContentEt().getPaddingBottom());
    this.zYr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174458);
        ad.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click resend btn");
        WcPayRealnameVerifyCodeUI.a(WcPayRealnameVerifyCodeUI.this);
        paramAnonymousView = WcPayRealnameVerifyCodeUI.this.getNetController();
        if ((paramAnonymousView instanceof a.b))
        {
          paramAnonymousView = (a.b)paramAnonymousView;
          String str1 = WcPayRealnameVerifyCodeUI.b(WcPayRealnameVerifyCodeUI.this).getText();
          String str2 = WcPayRealnameVerifyCodeUI.c(WcPayRealnameVerifyCodeUI.this);
          ad.i("MicroMsg.RealNameVerifyProcess", "do resend verify code");
          ad.i("MicroMsg.RealNameVerifyProcess", "do send sms: %s", new Object[] { str1 });
          String str3 = a.S(paramAnonymousView.zXk).getString("realname_verify_process_req_key", "");
          new com.tencent.mm.plugin.wallet_core.id_verify.model.b(str1, str2, paramAnonymousView.zXn, str3).auK().b(new a.b.2(paramAnonymousView));
          if (paramAnonymousView.zXn == 0) {
            paramAnonymousView.zXn += 1;
          }
          AppMethodBeat.o(174458);
          return;
        }
        ad.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
        AppMethodBeat.o(174458);
      }
    });
    this.iwY.setOnClickListener(new v()
    {
      public final void bOU()
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
            ad.i("MicroMsg.RealNameVerifyProcess", "do check verify code");
            ((WalletBaseUI)((a.b)localObject).activity).showProgress();
            new c(a.R(((a.b)localObject).zXk).getString("realname_verify_process_req_key", ""), str1, str2, str3).auK().b(new a.b.1((a.b)localObject));
            AppMethodBeat.o(174459);
            return;
          }
          ad.w("MicroMsg.WcPayRealNameVerifyCodeUI", "wrong controller");
        }
        AppMethodBeat.o(174459);
      }
    });
    this.zYp.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
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
        if ((!bt.isNullOrNil(WcPayRealnameVerifyCodeUI.c(WcPayRealnameVerifyCodeUI.this))) && (!bt.isNullOrNil(WcPayRealnameVerifyCodeUI.b(WcPayRealnameVerifyCodeUI.this).getText())))
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
      
      public final boolean dfX()
      {
        return false;
      }
    });
    this.zYp.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(174461);
        ad.i("MicroMsg.WcPayRealNameVerifyCodeUI", "phone valid change: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
        WcPayRealnameVerifyCodeUI.d(WcPayRealnameVerifyCodeUI.this);
        AppMethodBeat.o(174461);
      }
    });
    this.zYq.a(new TextWatcher()
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
    this.zYt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174463);
        ad.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click phone code layout");
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WcPayRealnameVerifyCodeUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        WcPayRealnameVerifyCodeUI.this.startActivityForResult(paramAnonymousView, 1);
        AppMethodBeat.o(174463);
      }
    });
    ebs();
    this.zYs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(174466);
        ad.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click verify code fail tv");
        paramAnonymousView = new e(WcPayRealnameVerifyCodeUI.this.getContext(), 1, false);
        final View localView = WcPayRealnameVerifyCodeUI.this.getLayoutInflater().inflate(2131496064, null);
        ((Button)localView.findViewById(2131300871)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(174464);
            paramAnonymousView.bfo();
            AppMethodBeat.o(174464);
          }
        });
        paramAnonymousView.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(174465);
            paramAnonymous2l.clear();
            paramAnonymousView.setFooterView(null);
            paramAnonymousView.setFooterView(localView);
            AppMethodBeat.o(174465);
          }
        };
        paramAnonymousView.ffu();
        paramAnonymousView.csG();
        AppMethodBeat.o(174466);
      }
    });
    AppMethodBeat.o(174470);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(174471);
    if ((paramInt1 == 1) && (paramInt2 == 100))
    {
      String str = paramIntent.getStringExtra("country_name");
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.WcPayRealNameVerifyCodeUI", "user canceled this select");
        AppMethodBeat.o(174471);
        return;
      }
      this.zYw = ("+" + paramIntent.getStringExtra("couttry_code"));
      ad.i("MicroMsg.WcPayRealNameVerifyCodeUI", "countryName: %s, countryCode: %s", new Object[] { str, this.zYw });
      ebs();
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(174457);
        paramAnonymousMenuItem = WcPayRealnameVerifyCodeUI.this.getProcess();
        if (paramAnonymousMenuItem != null) {
          paramAnonymousMenuItem.g(WcPayRealnameVerifyCodeUI.this.getContext(), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(174457);
          return false;
          WcPayRealnameVerifyCodeUI.this.finish();
        }
      }
    }, 2131689492);
    initView();
    AppMethodBeat.o(174469);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(174472);
    super.onDestroy();
    if (this.zYv != null) {
      this.zYv.cancel();
    }
    AppMethodBeat.o(174472);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setText(WcPayRealnameVerifyCodeUI.this.getString(2131766059));
      WcPayRealnameVerifyCodeUI.i(WcPayRealnameVerifyCodeUI.this);
      WcPayRealnameVerifyCodeUI.g(WcPayRealnameVerifyCodeUI.this);
      AppMethodBeat.o(174468);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(174467);
      WcPayRealnameVerifyCodeUI.h(WcPayRealnameVerifyCodeUI.this).setText(WcPayRealnameVerifyCodeUI.this.getString(2131766058, new Object[] { paramLong / 1000L + "s" }));
      AppMethodBeat.o(174467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */