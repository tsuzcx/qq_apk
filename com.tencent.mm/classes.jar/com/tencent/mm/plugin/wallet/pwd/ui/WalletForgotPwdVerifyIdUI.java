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
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdVerifyIdUI
  extends WalletBaseUI
  implements View.OnLayoutChangeListener
{
  private boolean DdM;
  private MMEditText DdR;
  private TextView DdS;
  private WalletFormView DdT;
  private Button DdU;
  private TextView DdV;
  private LinearLayout DdW;
  ViewGroup.MarginLayoutParams DdX;
  ViewGroup.MarginLayoutParams DdY;
  private View DdZ;
  private boolean Dea = false;
  private boolean Deb = false;
  private boolean Dec = false;
  private boolean Ded = false;
  private TextView gqi;
  private View kFh;
  private int keyHeight = 0;
  private int lya = 0;
  
  private void eHU()
  {
    AppMethodBeat.i(69693);
    ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
    new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69684);
        WalletForgotPwdVerifyIdUI.c(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.d(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.this.DdX = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.DdX.topMargin = com.tencent.mm.ui.aq.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
        WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.DdX);
        WalletForgotPwdVerifyIdUI.this.DdY = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.DdY.topMargin = com.tencent.mm.ui.aq.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
        WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.DdY);
        AppMethodBeat.o(69684);
      }
    }, 100L);
    AppMethodBeat.o(69693);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69691);
    ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
    int i = com.tencent.mm.plugin.wallet_core.model.t.eJa().eKO().field_cre_type;
    String str1 = com.tencent.mm.plugin.wallet_core.model.t.eJa().eKO().field_cre_name;
    String str2 = com.tencent.mm.plugin.wallet_core.model.t.eJa().eKO().field_true_name;
    this.DdR.setHint(getString(2131765180, new Object[] { f.bak(str2) }));
    if (!bu.isNullOrNil(str1)) {
      this.DdS.setText(str1);
    }
    while (i == 1)
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this.DdT);
      setEditFocusListener(this.DdT, 1, false, false, true);
      AppMethodBeat.o(69691);
      return;
      ae.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
    }
    ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
    AppMethodBeat.o(69691);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69690);
    super.finish();
    getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet.pwd.a.class.hashCode());
    com.tencent.mm.plugin.wallet.pwd.a locala = (com.tencent.mm.plugin.wallet.pwd.a)com.tencent.mm.wallet_core.a.bs(this);
    if ((locala != null) && (locala.Dca != null)) {
      locala.Dca.run(-1);
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
    ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.DdZ = findViewById(2131304246);
    this.lya = getWindowManager().getDefaultDisplay().getHeight();
    this.keyHeight = (this.lya / 3);
    this.DdZ.addOnLayoutChangeListener(this);
    this.DdM = getInput().getBoolean("key_is_force_bind", false);
    if (!this.DdM)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 6));
      setContentViewVisibility(4);
    }
    this.DdR = ((MMEditText)findViewById(2131302661));
    this.DdS = ((TextView)findViewById(2131300911));
    this.DdT = ((WalletFormView)findViewById(2131300910));
    this.DdU = ((Button)findViewById(2131302852));
    this.DdV = ((TextView)findViewById(2131303551));
    this.kFh = findViewById(2131304239);
    this.gqi = ((TextView)findViewById(2131305902));
    this.DdW = ((LinearLayout)findViewById(2131302663));
    this.DdT.setEnabled(false);
    this.DdT.setFocusable(false);
    this.DdU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69682);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this).getText();
        int i = com.tencent.mm.plugin.wallet_core.model.t.eJf().eJR();
        localObject = WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText().toString();
        if ((!bu.isNullOrNil(paramAnonymousView)) && (!bu.isNullOrNil((String)localObject)))
        {
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_identity", paramAnonymousView);
          WalletForgotPwdVerifyIdUI.this.getInput().putInt("key_id_type", i);
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_true_name", (String)localObject);
          if (WalletForgotPwdVerifyIdUI.this.getProcess() != null)
          {
            WalletForgotPwdVerifyIdUI.this.getProcess().dyY.putString("key_identity", paramAnonymousView);
            WalletForgotPwdVerifyIdUI.this.getProcess().dyY.putInt("key_id_type", i);
            WalletForgotPwdVerifyIdUI.this.getProcess().dyY.putString("key_true_name", (String)localObject);
          }
          WalletForgotPwdVerifyIdUI.this.getNetController().r(new Object[] { paramAnonymousView, Integer.valueOf(i), localObject });
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69682);
      }
    });
    this.DdV.setOnClickListener(new WalletForgotPwdVerifyIdUI.2(this));
    updateView();
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69687);
        if (paramAnonymousBoolean)
        {
          ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
          WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this), WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this));
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69687);
          return;
        }
        ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
        WalletForgotPwdVerifyIdUI.j(WalletForgotPwdVerifyIdUI.this);
        WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this).scrollTo(0, 0);
        AppMethodBeat.o(69687);
      }
    });
    this.DdR.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69688);
        if (paramAnonymousBoolean)
        {
          ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69688);
          return;
        }
        ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
        AppMethodBeat.o(69688);
      }
    });
    this.DdR.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(69685);
        ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText());
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
    this.DdT.a(new TextWatcher()
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
      ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
      eHU();
      AppMethodBeat.o(69694);
      return;
    }
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt4 - paramInt8 > this.keyHeight)) {
      ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
    }
    AppMethodBeat.o(69694);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69692);
    ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) {
        break label67;
      }
      updateView();
      setContentViewVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(69692);
      return false;
      label67:
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pwd.a.t))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.t)paramn;
        getInput().putInt("key_is_support_face", paramString.DcN);
        getInput().putInt("key_face_action_scene", paramString.scene);
        getInput().putString("key_face_action_package", paramString.packageName);
        getInput().putString("key_face_action_package_sign", paramString.dGY);
        if (paramString.DcO == 1)
        {
          com.tencent.mm.wallet_core.c.ad.fVY();
          paramn = com.tencent.mm.wallet_core.c.ad.getCrtNo();
          com.tencent.mm.wallet_core.c.b.fVM();
          if (!com.tencent.mm.wallet_core.c.b.isCertExist(paramn))
          {
            ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
            doSceneForceProgress(new p(paramString.DcL, paramString.DcM, paramString.dOf));
          }
          else
          {
            ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
            getProcess().a(this, 0, getInput());
          }
        }
        else
        {
          ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
          getProcess().a(this, 0, getInput());
        }
      }
      else if ((paramn instanceof p))
      {
        ae.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI
 * JD-Core Version:    0.7.0.1
 */