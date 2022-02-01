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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.pwd.a.a;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
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
  private boolean HJG;
  private TextView HJL;
  private WalletFormView HJM;
  private Button HJN;
  private TextView HJO;
  private LinearLayout HJP;
  ViewGroup.MarginLayoutParams HJQ;
  ViewGroup.MarginLayoutParams HJR;
  private View HJS;
  private boolean HJT = false;
  private boolean HJU = false;
  private boolean HJV = false;
  private boolean HJW = false;
  private TextView hbb;
  private int keyHeight = 0;
  private View lJI;
  private int mEY = 0;
  private MMEditText trx;
  
  private void fPg()
  {
    AppMethodBeat.i(69693);
    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69684);
        WalletForgotPwdVerifyIdUI.c(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.d(WalletForgotPwdVerifyIdUI.this).setVisibility(8);
        WalletForgotPwdVerifyIdUI.this.HJQ = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.HJQ.topMargin = at.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
        WalletForgotPwdVerifyIdUI.e(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.HJQ);
        WalletForgotPwdVerifyIdUI.this.HJR = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).getLayoutParams());
        WalletForgotPwdVerifyIdUI.this.HJR.topMargin = at.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
        WalletForgotPwdVerifyIdUI.f(WalletForgotPwdVerifyIdUI.this).setLayoutParams(WalletForgotPwdVerifyIdUI.this.HJR);
        AppMethodBeat.o(69684);
      }
    }, 100L);
    AppMethodBeat.o(69693);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(69691);
    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
    int i = com.tencent.mm.plugin.wallet_core.model.t.fQD().fRN().field_cre_type;
    String str1 = com.tencent.mm.plugin.wallet_core.model.t.fQD().fRN().field_cre_name;
    String str2 = com.tencent.mm.plugin.wallet_core.model.t.fQD().fRN().field_true_name;
    this.trx.setHint(getString(2131767623, new Object[] { f.bps(str2) }));
    if (!Util.isNullOrNil(str1)) {
      this.HJL.setText(str1);
    }
    while (i == 1)
    {
      com.tencent.mm.wallet_core.ui.formview.a.d(this.HJM);
      setEditFocusListener(this.HJM, 1, false, false, true);
      AppMethodBeat.o(69691);
      return;
      Log.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
    }
    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
    AppMethodBeat.o(69691);
  }
  
  public void finish()
  {
    AppMethodBeat.i(69690);
    super.finish();
    getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet.pwd.a.class.hashCode());
    com.tencent.mm.plugin.wallet.pwd.a locala = (com.tencent.mm.plugin.wallet.pwd.a)com.tencent.mm.wallet_core.a.by(this);
    if ((locala != null) && (locala.HHO != null)) {
      locala.HHO.run(-1);
    }
    AppMethodBeat.o(69690);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496935;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69689);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
    setActionbarColor(getContext().getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.HJS = findViewById(2131307165);
    this.mEY = getWindowManager().getDefaultDisplay().getHeight();
    this.keyHeight = (this.mEY / 3);
    this.HJS.addOnLayoutChangeListener(this);
    this.HJG = getInput().getBoolean("key_is_force_bind", false);
    if (!this.HJG)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 6));
      setContentViewVisibility(4);
    }
    this.trx = ((MMEditText)findViewById(2131305215));
    this.HJL = ((TextView)findViewById(2131302522));
    this.HJM = ((WalletFormView)findViewById(2131302521));
    this.HJN = ((Button)findViewById(2131305423));
    this.HJO = ((TextView)findViewById(2131306326));
    this.lJI = findViewById(2131307157);
    this.hbb = ((TextView)findViewById(2131309195));
    this.HJP = ((LinearLayout)findViewById(2131305217));
    this.HJM.setEnabled(false);
    this.HJM.setFocusable(false);
    this.HJN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69682);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this).getText();
        int i = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRu();
        localObject = WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText().toString();
        if ((!Util.isNullOrNil(paramAnonymousView)) && (!Util.isNullOrNil((String)localObject)))
        {
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_identity", paramAnonymousView);
          WalletForgotPwdVerifyIdUI.this.getInput().putInt("key_id_type", i);
          WalletForgotPwdVerifyIdUI.this.getInput().putString("key_true_name", (String)localObject);
          if (WalletForgotPwdVerifyIdUI.this.getProcess() != null)
          {
            WalletForgotPwdVerifyIdUI.this.getProcess().dQL.putString("key_identity", paramAnonymousView);
            WalletForgotPwdVerifyIdUI.this.getProcess().dQL.putInt("key_id_type", i);
            WalletForgotPwdVerifyIdUI.this.getProcess().dQL.putString("key_true_name", (String)localObject);
          }
          WalletForgotPwdVerifyIdUI.this.getNetController().r(new Object[] { paramAnonymousView, Integer.valueOf(i), localObject });
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69682);
      }
    });
    this.HJO.setOnClickListener(new WalletForgotPwdVerifyIdUI.2(this));
    updateView();
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69687);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
          WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this), WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this));
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69687);
          return;
        }
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
        WalletForgotPwdVerifyIdUI.j(WalletForgotPwdVerifyIdUI.this);
        WalletForgotPwdVerifyIdUI.h(WalletForgotPwdVerifyIdUI.this).scrollTo(0, 0);
        AppMethodBeat.o(69687);
      }
    });
    this.trx.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69688);
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
          WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
          AppMethodBeat.o(69688);
          return;
        }
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
        AppMethodBeat.o(69688);
      }
    });
    this.trx.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(69685);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.b(WalletForgotPwdVerifyIdUI.this).getText());
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
    this.HJM.a(new TextWatcher()
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
      Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
      fPg();
      AppMethodBeat.o(69694);
      return;
    }
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt4 - paramInt8 > this.keyHeight)) {
      Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
    }
    AppMethodBeat.o(69694);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69692);
    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramq instanceof com.tencent.mm.plugin.wallet_core.c.ad)) {
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
      if ((paramq instanceof com.tencent.mm.plugin.wallet.pwd.a.t))
      {
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.t)paramq;
        getInput().putInt("key_is_support_face", paramString.HIB);
        getInput().putInt("key_face_action_scene", paramString.scene);
        getInput().putString("key_face_action_package", paramString.packageName);
        getInput().putString("key_face_action_package_sign", paramString.dYK);
        if (paramString.HIC == 1)
        {
          com.tencent.mm.wallet_core.c.ad.hhv();
          paramq = com.tencent.mm.wallet_core.c.ad.getCrtNo();
          com.tencent.mm.wallet_core.c.b.hhj();
          if (!com.tencent.mm.wallet_core.c.b.isCertExist(paramq))
          {
            Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
            doSceneForceProgress(new p(paramString.HIz, paramString.HIA));
          }
          else
          {
            Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
            getProcess().a(this, 0, getInput());
          }
        }
        else
        {
          Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
          getProcess().a(this, 0, getInput());
        }
      }
      else if ((paramq instanceof p))
      {
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
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