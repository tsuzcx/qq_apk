package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.pwd.a.a;
import com.tencent.mm.plugin.wallet.pwd.a.t;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdVerifyIdUI
  extends WalletBaseUI
  implements View.OnLayoutChangeListener
{
  private TextView fQp;
  private View jGG;
  private int keyHeight = 0;
  private int kvo = 0;
  private MMEditText zTA;
  private TextView zTB;
  private WalletFormView zTC;
  private Button zTD;
  private TextView zTE;
  private LinearLayout zTF;
  ViewGroup.MarginLayoutParams zTG;
  ViewGroup.MarginLayoutParams zTH;
  private View zTI;
  private boolean zTJ = false;
  private boolean zTK = false;
  private boolean zTL = false;
  private boolean zTM = false;
  private boolean zTv;
  
  private void cE()
  {
    AppMethodBeat.i(69691);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
    int i = s.ebX().edF().field_cre_type;
    String str1 = s.ebX().edF().field_cre_name;
    String str2 = s.ebX().edF().field_true_name;
    this.zTA.setHint(getString(2131765180, new Object[] { e.aNf(str2) }));
    if (!bt.isNullOrNil(str1)) {
      this.zTB.setText(str1);
    }
    while (i == 1)
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this.zTC);
      setEditFocusListener(this.zTC, 1, false, false, true);
      AppMethodBeat.o(69691);
      return;
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
    AppMethodBeat.o(69691);
  }
  
  private void eaR()
  {
    AppMethodBeat.i(69693);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69684);
        WalletForgotPwdVerifyIdUI.c(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.d(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.this.zTG = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.zTG.topMargin = ao.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
        WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.zTG);
        WalletForgotPwdVerifyIdUI.this.zTH = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.zTH.topMargin = ao.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
        WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.zTH);
        AppMethodBeat.o(69684);
      }
    }, 100L);
    AppMethodBeat.o(69693);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69690);
    super.finish();
    getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet.pwd.a.class.hashCode());
    com.tencent.mm.plugin.wallet.pwd.a locala = (com.tencent.mm.plugin.wallet.pwd.a)com.tencent.mm.wallet_core.a.bo(this);
    if ((locala != null) && (locala.zRM != null)) {
      locala.zRM.run(-1);
    }
    AppMethodBeat.o(69690);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495955;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69689);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.zTI = findViewById(2131304246);
    this.kvo = getWindowManager().getDefaultDisplay().getHeight();
    this.keyHeight = (this.kvo / 3);
    this.zTI.addOnLayoutChangeListener(this);
    this.zTv = getInput().getBoolean("key_is_force_bind", false);
    if (!this.zTv)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 6));
      setContentViewVisibility(4);
    }
    this.zTA = ((MMEditText)findViewById(2131302661));
    this.zTB = ((TextView)findViewById(2131300911));
    this.zTC = ((WalletFormView)findViewById(2131300910));
    this.zTD = ((Button)findViewById(2131302852));
    this.zTE = ((TextView)findViewById(2131303551));
    this.jGG = findViewById(2131304239);
    this.fQp = ((TextView)findViewById(2131305902));
    this.zTF = ((LinearLayout)findViewById(2131302663));
    this.zTC.setEnabled(false);
    this.zTC.setFocusable(false);
    this.zTD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69682);
        paramAnonymousView = WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this).getText();
        int i = s.ecc().ecP();
        String str = WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText().toString();
        if ((!bt.isNullOrNil(paramAnonymousView)) && (!bt.isNullOrNil(str)))
        {
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_identity", paramAnonymousView);
          WalletForgotPwdVerifyIdUI.this.getInput().putInt("key_id_type", i);
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_true_name", str);
          if (WalletForgotPwdVerifyIdUI.this.getProcess() != null)
          {
            WalletForgotPwdVerifyIdUI.this.getProcess().dow.putString("key_identity", paramAnonymousView);
            WalletForgotPwdVerifyIdUI.this.getProcess().dow.putInt("key_id_type", i);
            WalletForgotPwdVerifyIdUI.this.getProcess().dow.putString("key_true_name", str);
          }
          WalletForgotPwdVerifyIdUI.this.getNetController().q(new Object[] { paramAnonymousView, Integer.valueOf(i), str });
        }
        AppMethodBeat.o(69682);
      }
    });
    this.zTE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69683);
        e.p(WalletForgotPwdVerifyIdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
        AppMethodBeat.o(69683);
      }
    });
    cE();
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69687);
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
          WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this), WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this));
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69687);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
        WalletForgotPwdVerifyIdUI.j(WalletForgotPwdVerifyIdUI.this);
        WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this).scrollTo(0, 0);
        AppMethodBeat.o(69687);
      }
    });
    this.zTA.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69688);
        if (paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69688);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
        AppMethodBeat.o(69688);
      }
    });
    this.zTA.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(69685);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText());
        if ((WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText() == null) || ("".equals(WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText().toString()))) {
          WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, false);
        }
        for (;;)
        {
          WalletForgotPwdVerifyIdUI.g(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69685);
          return;
          WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, true);
        }
      }
    });
    this.zTC.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(69686);
        if (WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this).getText() != null) {
          WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this, true);
        }
        for (;;)
        {
          WalletForgotPwdVerifyIdUI.g(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69686);
          return;
          WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this, false);
        }
      }
    });
    AppMethodBeat.o(69689);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(69694);
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt8 - paramInt4 > this.keyHeight))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
      eaR();
      AppMethodBeat.o(69694);
      return;
    }
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt4 - paramInt8 > this.keyHeight)) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
    }
    AppMethodBeat.o(69694);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69692);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) {
        break label67;
      }
      cE();
      setContentViewVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69692);
      return false;
      label67:
      if ((paramn instanceof t))
      {
        paramString = (t)paramn;
        getInput().putInt("key_is_support_face", paramString.zSz);
        getInput().putInt("key_face_action_scene", paramString.scene);
        getInput().putString("key_face_action_package", paramString.packageName);
        getInput().putString("key_face_action_package_sign", paramString.dwg);
        if (paramString.zSA == 1)
        {
          com.tencent.mm.wallet_core.c.ad.fkc();
          paramn = com.tencent.mm.wallet_core.c.ad.getCrtNo();
          b.fjR();
          if (!b.isCertExist(paramn))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
            doSceneForceProgress(new p(paramString.zSx, paramString.zSy, paramString.dCQ));
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
            getProcess().a(this, 0, getInput());
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
          getProcess().a(this, 0, getInput());
        }
      }
      else if ((paramn instanceof p))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
        getProcess().a(this, 0, getInput());
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI
 * JD-Core Version:    0.7.0.1
 */