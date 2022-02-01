package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private TextView ABA;
  private TextView ABB;
  private TextView ABC;
  private Animation ABD;
  private String ABE;
  private String ABF;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d ABG;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h ABH;
  private com.tencent.mm.plugin.walletlock.c.b ABI;
  private String ABJ = "-1";
  private int ABK = -1;
  private int ABL = -1;
  private boolean ABu = false;
  private String Ko;
  private boolean isCancelled = false;
  private String ixc = null;
  private com.tencent.mm.ui.widget.a.d kby = null;
  private String mToken;
  private TextView mut;
  private ProgressDialog nMZ = null;
  private int rcE = 0;
  private boolean tHJ = true;
  
  private void Mp(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.rcE > 1)
    {
      this.rcE = i;
      dismissDialog();
      if (this.ABA != null)
      {
        this.ABA.setText(paramString);
        this.ABA.setTextColor(getResources().getColor(2131100798));
        this.ABA.setVisibility(4);
        if (this.ABD == null) {
          this.ABD = AnimationUtils.loadAnimation(getContext(), 2130772050);
        }
        this.ABA.startAnimation(this.ABD);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.ABD.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void RL(int paramInt)
  {
    AppMethodBeat.i(129732);
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.bs.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      AppMethodBeat.o(129732);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(2131765361));
      }
    }
  }
  
  private void Ug(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = getString(2131765355);
    }
    dismissDialog();
    this.kby = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.kby.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void aEr()
  {
    AppMethodBeat.i(129733);
    if ((this.nMZ != null) && (this.nMZ.isShowing())) {
      this.nMZ.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void ch(int paramInt, String paramString)
  {
    AppMethodBeat.i(129737);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt), paramString });
    release();
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_err_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(129737);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(129728);
    aEr();
    if ((this.kby != null) && (this.kby.isShowing())) {
      this.kby.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void efX()
  {
    AppMethodBeat.i(129726);
    if (this.Ko.equals("action.verify_pattern"))
    {
      this.ABA.setText(2131765356);
      this.ABA.setTextColor(getResources().getColor(2131100711));
      this.ABC.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.ABA.setText(2131765349);
    this.ABA.setTextColor(getResources().getColor(2131100711));
    this.ABC.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void efY()
  {
    AppMethodBeat.i(129727);
    aEr();
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.ABK) });
    if (this.ABK == 2) {
      locala.aay(2131765363).aaB(2131765367).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).aaC(2131755691).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129713);
          ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
          AppMethodBeat.o(129713);
        }
      });
    }
    for (;;)
    {
      this.kby = locala.fft();
      this.kby.setCanceledOnTouchOutside(false);
      this.kby.show();
      AppMethodBeat.o(129727);
      return;
      locala.aay(2131765362).aMm(getString(2131755835)).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.egb();
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void efZ()
  {
    AppMethodBeat.i(129730);
    ad.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.ABF });
    if (bt.isNullOrNil(this.ABF))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.ABF;
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(129730);
      return;
      if (!((String)localObject1).equals("action.switch_on_pattern")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject1).equals("action.verify_pattern")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject1).equals("next_action.switch_on_pattern")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject1).equals("next_action.goto_protected_page")) {
        break;
      }
      i = 3;
      break;
      this.ABI = new a(this);
      this.ABJ = "-1";
      if (this.ABH == null) {
        this.ABH = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.ABH;
      Object localObject2 = this.ABI;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).ABx = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().kH(this).abX(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).ABx).a((com.tencent.soter.a.a.b)localObject3).aNV(com.tencent.mm.plugin.walletlock.c.g.ADl.ADm).abW(3).IvW;
      com.tencent.mm.plugin.walletlock.c.g.ADl.ADn = null;
      ad.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.ADl.ADn;
      if (localObject2 == null)
      {
        Mp(getString(2131765351));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).Iva;
      localObject2 = ((j)localObject2).signature;
      if (this.ABG != null)
      {
        this.nMZ = com.tencent.mm.ui.base.h.b(this, getString(2131765358), false, null);
        this.ABG.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void aU(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129708);
            ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.k(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129708);
              return;
            }
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(2131765347));
            AppMethodBeat.o(129708);
          }
        }, this.mToken, (String)localObject1, (String)localObject2);
      }
      AppMethodBeat.o(129730);
      return;
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.uT(SystemClock.elapsedRealtime());
      ega();
    }
  }
  
  private void ega()
  {
    AppMethodBeat.i(129731);
    this.tHJ = false;
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(129705);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129705);
      }
    }, 200L);
    Object localObject = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localObject != null)
    {
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      i.ADp.sZ(true);
      i.ADp.ta(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772140, 2130772145);
      AppMethodBeat.o(129731);
      return;
    }
    ad.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(129731);
  }
  
  private void release()
  {
    AppMethodBeat.i(129736);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.isCancelled) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129736);
      return;
    }
    this.isCancelled = true;
    if (this.ABH != null) {
      this.ABH.release();
    }
    if (this.ABG != null) {
      this.ABG.release();
    }
    f.fnw().fnx();
    AppMethodBeat.o(129736);
  }
  
  public void finish()
  {
    AppMethodBeat.i(129738);
    super.finish();
    release();
    AppMethodBeat.o(129738);
  }
  
  public int getLayoutId()
  {
    return 2131494140;
  }
  
  public void initView()
  {
    AppMethodBeat.i(129725);
    super.initView();
    this.ABA = ((TextView)findViewById(2131300099));
    this.ABB = ((TextView)findViewById(2131303155));
    this.mut = ((TextView)findViewById(2131300095));
    this.ABC = ((TextView)findViewById(2131300096));
    this.ABB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        AppMethodBeat.o(129703);
      }
    });
    this.mut.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        FingerprintWalletLockUI.egb();
        FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
        AppMethodBeat.o(129710);
      }
    });
    this.ABC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129711);
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        AppMethodBeat.o(129711);
      }
    });
    AppMethodBeat.o(129725);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(129739);
    ad.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ad.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
      AppMethodBeat.o(129739);
      return;
    }
    paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        ega();
        com.tencent.mm.plugin.walletlock.c.h.egF();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.tHJ = false;
        Ug(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.auJ(this.ABJ);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.uT(SystemClock.elapsedRealtime());
        ega();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.tHJ = false;
        Ug(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          ega();
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.ADp.egL();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          ega();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.tHJ = false;
          Ug(getString(2131765359));
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.ADp.egL();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).RK(0);
          paramIntent = com.tencent.mm.plugin.walletlock.c.g.ADl;
          com.tencent.mm.plugin.walletlock.c.g.efV();
          Toast.makeText(this, getString(2131765341), 0).show();
          ega();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.tHJ = false;
          Ug(getString(2131765342));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.ADp.egL();
        }
      }
    }
    AppMethodBeat.o(129739);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129729);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    finish();
    i.ADp.egL();
    AppMethodBeat.o(129729);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129722);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.Ko = paramBundle.getStringExtra("action");
    this.ABF = this.Ko;
    this.ABE = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.ixc = paramBundle.getStringExtra("key_pay_passwd");
    this.ABL = paramBundle.getIntExtra("scene", -1);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.Ko, this.ABE });
    if (this.Ko.equals("action.verify_pattern"))
    {
      this.ABK = 2;
      com.tencent.mm.plugin.walletlock.c.h.egH();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.Ko.equals("action.switch_on_pattern")) {
      this.ABK = 1;
    }
    AppMethodBeat.o(129722);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129724);
    super.onPause();
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    dismissDialog();
    release();
    this.tHJ = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.tHJ) });
    if (!this.tHJ)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.ABG = new c();
    this.ABH = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    f.fnw().fnx();
    this.nMZ = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, null);
    efX();
    Object localObject;
    if (this.Ko.equals("action.switch_on_pattern"))
    {
      this.ABu = false;
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.ABu) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.ADl;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.egD();
      localObject = com.tencent.mm.plugin.walletlock.c.g.ADl;
      if ((!com.tencent.mm.plugin.walletlock.c.g.efS()) || (bool)) {
        break label620;
      }
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.ege()) {
        break label518;
      }
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).RK(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.ADl;
      com.tencent.mm.plugin.walletlock.c.g.egB();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(aj.getPackageName());
      bool = com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FqY, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(2131765369));
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqY, Boolean.TRUE);
        com.tencent.mm.kernel.g.afB().afk().eKy();
      }
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.vKh.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      ad.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.ABu = true;
      break;
      label518:
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      aEr();
      this.kby = new com.tencent.mm.ui.widget.a.d.a(this).aay(2131765364).aaB(2131765368).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129717);
          ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
          AppMethodBeat.o(129717);
        }
      }).e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(129716);
          ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.egb();
          AppMethodBeat.o(129716);
        }
      }).fft();
      this.kby.setCanceledOnTouchOutside(false);
      this.kby.b(getString(2131765340), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.kby.show();
      continue;
      label620:
      if (!com.tencent.soter.core.a.kD(this))
      {
        efY();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.ixc);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.ABu);
        this.ABG.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void aU(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129712);
            ad.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(System.currentTimeMillis()) });
            if (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
            {
              ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
              AppMethodBeat.o(129712);
              return;
            }
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.h(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129712);
              return;
            }
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(2131765346));
            AppMethodBeat.o(129712);
          }
        }, (Bundle)localObject);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    implements com.tencent.mm.plugin.walletlock.c.b
  {
    private WeakReference<FingerprintWalletLockUI> rdg;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.rdg = null;
      this.rdg = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI egc()
    {
      AppMethodBeat.i(129719);
      if (this.rdg != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.rdg.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void egd()
    {
      AppMethodBeat.i(129720);
      FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
      FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
      AppMethodBeat.o(129720);
    }
    
    public final void y(int paramInt, String paramString)
    {
      AppMethodBeat.i(129721);
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(FingerprintWalletLockUI.this)) });
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
      {
        paramString = new en();
        paramString.dMW = 3L;
        paramString.dZx = 1L;
        paramString.aBj();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new en();
        paramString.dMW = 7L;
        paramString.dZx = 1L;
        paramString.aBj();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new en();
          paramString.dMW = 9L;
          paramString.dZx = 1L;
          paramString.aBj();
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(129721);
        return;
        ad.i("MicroMsg.FingerprintWalletLockUI", "identify success");
        if (egc() != null) {
          FingerprintWalletLockUI.f(egc());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new en();
          paramString.dMW = 3L;
          paramString.dZx = 2L;
          paramString.aBj();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new en();
            paramString.dMW = 7L;
            paramString.dZx = 2L;
            paramString.aBj();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new en();
            paramString.dMW = 9L;
            paramString.dZx = 2L;
            paramString.aBj();
            AppMethodBeat.o(129721);
            return;
            ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (egc() != null)
            {
              FingerprintWalletLockUI.a(egc(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
              AppMethodBeat.o(129721);
              return;
              ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (egc() != null)
              {
                FingerprintWalletLockUI.a(egc(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
                AppMethodBeat.o(129721);
                return;
                if (egc() != null)
                {
                  FingerprintWalletLockUI.b(egc(), paramInt, FingerprintWalletLockUI.this.getString(2131765346));
                  AppMethodBeat.o(129721);
                  return;
                  if (egc() != null)
                  {
                    FingerprintWalletLockUI.b(egc(), paramInt, FingerprintWalletLockUI.this.getString(2131765363));
                    AppMethodBeat.o(129721);
                    return;
                    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (egc() != null) {
                      FingerprintWalletLockUI.b(egc(), paramInt, FingerprintWalletLockUI.this.getString(2131765353));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */