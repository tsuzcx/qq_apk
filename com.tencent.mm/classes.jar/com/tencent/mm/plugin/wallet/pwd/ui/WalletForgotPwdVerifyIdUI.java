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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.pwd.a.a;
import com.tencent.mm.plugin.wallet.pwd.a.t;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private boolean BlP;
  private MMEditText BlU;
  private TextView BlV;
  private WalletFormView BlW;
  private Button BlX;
  private TextView BlY;
  private LinearLayout BlZ;
  ViewGroup.MarginLayoutParams Bma;
  ViewGroup.MarginLayoutParams Bmb;
  private View Bmc;
  private boolean Bmd = false;
  private boolean Bme = false;
  private boolean Bmf = false;
  private boolean Bmg = false;
  private TextView fUk;
  private int kWC = 0;
  private int keyHeight = 0;
  private View khe;
  
  private void cL()
  {
    AppMethodBeat.i(69691);
    ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
    int i = s.ert().eta().field_cre_type;
    String str1 = s.ert().eta().field_cre_name;
    String str2 = s.ert().eta().field_true_name;
    this.BlU.setHint(getString(2131765180, new Object[] { e.aSI(str2) }));
    if (!bs.isNullOrNil(str1)) {
      this.BlV.setText(str1);
    }
    while (i == 1)
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this.BlW);
      setEditFocusListener(this.BlW, 1, false, false, true);
      AppMethodBeat.o(69691);
      return;
      ac.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
    }
    ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
    AppMethodBeat.o(69691);
  }
  
  private void eqn()
  {
    AppMethodBeat.i(69693);
    ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
    new com.tencent.mm.sdk.platformtools.ao().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69684);
        WalletForgotPwdVerifyIdUI.c(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.d(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.this.Bma = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.Bma.topMargin = com.tencent.mm.ui.ao.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
        WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.Bma);
        WalletForgotPwdVerifyIdUI.this.Bmb = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.Bmb.topMargin = com.tencent.mm.ui.ao.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
        WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.Bmb);
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
    com.tencent.mm.plugin.wallet.pwd.a locala = (com.tencent.mm.plugin.wallet.pwd.a)com.tencent.mm.wallet_core.a.br(this);
    if ((locala != null) && (locala.Bkg != null)) {
      locala.Bkg.run(-1);
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
    ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.Bmc = findViewById(2131304246);
    this.kWC = getWindowManager().getDefaultDisplay().getHeight();
    this.keyHeight = (this.kWC / 3);
    this.Bmc.addOnLayoutChangeListener(this);
    this.BlP = getInput().getBoolean("key_is_force_bind", false);
    if (!this.BlP)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 6));
      setContentViewVisibility(4);
    }
    this.BlU = ((MMEditText)findViewById(2131302661));
    this.BlV = ((TextView)findViewById(2131300911));
    this.BlW = ((WalletFormView)findViewById(2131300910));
    this.BlX = ((Button)findViewById(2131302852));
    this.BlY = ((TextView)findViewById(2131303551));
    this.khe = findViewById(2131304239);
    this.fUk = ((TextView)findViewById(2131305902));
    this.BlZ = ((LinearLayout)findViewById(2131302663));
    this.BlW.setEnabled(false);
    this.BlW.setFocusable(false);
    this.BlX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69682);
        paramAnonymousView = WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this).getText();
        int i = s.ery().esk();
        String str = WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText().toString();
        if ((!bs.isNullOrNil(paramAnonymousView)) && (!bs.isNullOrNil(str)))
        {
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_identity", paramAnonymousView);
          WalletForgotPwdVerifyIdUI.this.getInput().putInt("key_id_type", i);
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_true_name", str);
          if (WalletForgotPwdVerifyIdUI.this.getProcess() != null)
          {
            WalletForgotPwdVerifyIdUI.this.getProcess().dmf.putString("key_identity", paramAnonymousView);
            WalletForgotPwdVerifyIdUI.this.getProcess().dmf.putInt("key_id_type", i);
            WalletForgotPwdVerifyIdUI.this.getProcess().dmf.putString("key_true_name", str);
          }
          WalletForgotPwdVerifyIdUI.this.getNetController().s(new Object[] { paramAnonymousView, Integer.valueOf(i), str });
        }
        AppMethodBeat.o(69682);
      }
    });
    this.BlY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69683);
        e.o(WalletForgotPwdVerifyIdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
        AppMethodBeat.o(69683);
      }
    });
    cL();
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69687);
        if (paramAnonymousBoolean)
        {
          ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
          WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this), WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this));
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69687);
          return;
        }
        ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
        WalletForgotPwdVerifyIdUI.j(WalletForgotPwdVerifyIdUI.this);
        WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this).scrollTo(0, 0);
        AppMethodBeat.o(69687);
      }
    });
    this.BlU.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69688);
        if (paramAnonymousBoolean)
        {
          ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69688);
          return;
        }
        ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
        AppMethodBeat.o(69688);
      }
    });
    this.BlU.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(69685);
        ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText());
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
    this.BlW.a(new TextWatcher()
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
      ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
      eqn();
      AppMethodBeat.o(69694);
      return;
    }
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt4 - paramInt8 > this.keyHeight)) {
      ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
    }
    AppMethodBeat.o(69694);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69692);
    ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) {
        break label67;
      }
      cL();
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
        getInput().putInt("key_is_support_face", paramString.BkT);
        getInput().putInt("key_face_action_scene", paramString.scene);
        getInput().putString("key_face_action_package", paramString.packageName);
        getInput().putString("key_face_action_package_sign", paramString.dtT);
        if (paramString.BkU == 1)
        {
          com.tencent.mm.wallet_core.c.ad.fAs();
          paramn = com.tencent.mm.wallet_core.c.ad.getCrtNo();
          b.fAg();
          if (!b.isCertExist(paramn))
          {
            ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
            doSceneForceProgress(new p(paramString.BkR, paramString.BkS, paramString.dAC));
          }
          else
          {
            ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
            getProcess().a(this, 0, getInput());
          }
        }
        else
        {
          ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
          getProcess().a(this, 0, getInput());
        }
      }
      else if ((paramn instanceof p))
      {
        ac.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
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