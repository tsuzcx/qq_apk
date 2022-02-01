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
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private int DuA = -1;
  private boolean Duj = false;
  private TextView Dup;
  private TextView Duq;
  private TextView Dur;
  private Animation Dus;
  private String Dut;
  private String Duu;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d Duv;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h Duw;
  private com.tencent.mm.plugin.walletlock.c.b Dux;
  private String Duy = "-1";
  private int Duz = -1;
  private String Nb;
  private TextView gSR;
  private boolean isCancelled = false;
  private String jqo = null;
  private com.tencent.mm.ui.widget.a.d kYs = null;
  private String mToken;
  private ProgressDialog oTu = null;
  private int thA = 0;
  private boolean vTp = true;
  
  private void TW(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.thA > 1)
    {
      this.thA = i;
      dismissDialog();
      if (this.Dup != null)
      {
        this.Dup.setText(paramString);
        this.Dup.setTextColor(getResources().getColor(2131100798));
        this.Dup.setVisibility(4);
        if (this.Dus == null) {
          this.Dus = AnimationUtils.loadAnimation(getContext(), 2130772050);
        }
        this.Dup.startAnimation(this.Dus);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.Dus.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void VN(int paramInt)
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
  
  private void aOs()
  {
    AppMethodBeat.i(129733);
    if ((this.oTu != null) && (this.oTu.isShowing())) {
      this.oTu.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = getString(2131765355);
    }
    dismissDialog();
    this.kYs = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.kYs.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void cs(int paramInt, String paramString)
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
    aOs();
    if ((this.kYs != null) && (this.kYs.isShowing())) {
      this.kYs.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void eJA()
  {
    AppMethodBeat.i(129731);
    this.vTp = false;
    aq.o(new Runnable()
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
      i.Dwe.uK(true);
      i.Dwe.uL(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772140, 2130772145);
      AppMethodBeat.o(129731);
      return;
    }
    ad.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(129731);
  }
  
  private void eJx()
  {
    AppMethodBeat.i(129726);
    if (this.Nb.equals("action.verify_pattern"))
    {
      this.Dup.setText(2131765356);
      this.Dup.setTextColor(getResources().getColor(2131100711));
      this.Dur.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.Dup.setText(2131765349);
    this.Dup.setTextColor(getResources().getColor(2131100711));
    this.Dur.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void eJy()
  {
    AppMethodBeat.i(129727);
    aOs();
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.Duz) });
    if (this.Duz == 2) {
      locala.afi(2131765363).afl(2131765367).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).afm(2131755691).d(new DialogInterface.OnClickListener()
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
      this.kYs = locala.fMb();
      this.kYs.setCanceledOnTouchOutside(false);
      this.kYs.show();
      AppMethodBeat.o(129727);
      return;
      locala.afi(2131765362).aXM(getString(2131755835)).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.eJB();
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void eJz()
  {
    AppMethodBeat.i(129730);
    ad.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.Duu });
    if (bt.isNullOrNil(this.Duu))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.Duu;
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
      this.Dux = new a(this);
      this.Duy = "-1";
      if (this.Duw == null) {
        this.Duw = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.Duw;
      Object localObject2 = this.Dux;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).Dum = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().lg(this).agQ(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).Dum).a((com.tencent.soter.a.a.b)localObject3).aZy(com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwb).agP(3).LRA;
      com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwc = null;
      ad.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwc;
      if (localObject2 == null)
      {
        TW(getString(2131765351));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).LQE;
      localObject2 = ((j)localObject2).signature;
      if (this.Duv != null)
      {
        this.oTu = com.tencent.mm.ui.base.h.b(this, getString(2131765358), false, null);
        this.Duv.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bc(int paramAnonymousInt, String paramAnonymousString)
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
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ci(SystemClock.elapsedRealtime());
      eJA();
    }
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
    if (this.Duw != null) {
      this.Duw.release();
    }
    if (this.Duv != null) {
      this.Duv.release();
    }
    f.fVe().fVf();
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
    this.Dup = ((TextView)findViewById(2131300099));
    this.Duq = ((TextView)findViewById(2131303155));
    this.gSR = ((TextView)findViewById(2131300095));
    this.Dur = ((TextView)findViewById(2131300096));
    this.Duq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129703);
      }
    });
    this.gSR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FingerprintWalletLockUI.eJB();
        FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129710);
      }
    });
    this.Dur.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        eJA();
        com.tencent.mm.plugin.walletlock.c.h.eKf();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.vTp = false;
        abY(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.aFk(this.Duy);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ci(SystemClock.elapsedRealtime());
        eJA();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.vTp = false;
        abY(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          eJA();
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.Dwe.eKl();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          eJA();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.vTp = false;
          abY(getString(2131765359));
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.Dwe.eKl();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).VM(0);
          paramIntent = com.tencent.mm.plugin.walletlock.c.g.Dwa;
          com.tencent.mm.plugin.walletlock.c.g.eJv();
          Toast.makeText(this, getString(2131765341), 0).show();
          eJA();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.vTp = false;
          abY(getString(2131765342));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.Dwe.eKl();
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
    i.Dwe.eKl();
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
    this.Nb = paramBundle.getStringExtra("action");
    this.Duu = this.Nb;
    this.Dut = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.jqo = paramBundle.getStringExtra("key_pay_passwd");
    this.DuA = paramBundle.getIntExtra("scene", -1);
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.Nb, this.Dut });
    if (this.Nb.equals("action.verify_pattern"))
    {
      this.Duz = 2;
      com.tencent.mm.plugin.walletlock.c.h.eKh();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.Nb.equals("action.switch_on_pattern")) {
      this.Duz = 1;
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
    this.vTp = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.vTp) });
    if (!this.vTp)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.Duv = new c();
    this.Duw = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    f.fVe().fVf();
    this.oTu = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, null);
    eJx();
    Object localObject;
    if (this.Nb.equals("action.switch_on_pattern"))
    {
      this.Duj = false;
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.Duj) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.Dwa;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.eKd();
      localObject = com.tencent.mm.plugin.walletlock.c.g.Dwa;
      if ((!com.tencent.mm.plugin.walletlock.c.g.eJs()) || (bool)) {
        break label620;
      }
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.eJE()) {
        break label518;
      }
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).VM(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.Dwa;
      com.tencent.mm.plugin.walletlock.c.g.eKb();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(aj.getPackageName());
      bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IBj, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(2131765369));
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBj, Boolean.TRUE);
        com.tencent.mm.kernel.g.ajC().ajl().fqc();
      }
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.g.yhR.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      ad.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.Duj = true;
      break;
      label518:
      ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      aOs();
      this.kYs = new com.tencent.mm.ui.widget.a.d.a(this).afi(2131765364).afl(2131765368).c(new DialogInterface.OnClickListener()
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
          FingerprintWalletLockUI.eJB();
          AppMethodBeat.o(129716);
        }
      }).fMb();
      this.kYs.setCanceledOnTouchOutside(false);
      this.kYs.b(getString(2131765340), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.kYs.show();
      continue;
      label620:
      if (!com.tencent.soter.core.a.lc(this))
      {
        eJy();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.jqo);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.Duj);
        this.Duv.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bc(int paramAnonymousInt, String paramAnonymousString)
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
    private WeakReference<FingerprintWalletLockUI> tic;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.tic = null;
      this.tic = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI eJC()
    {
      AppMethodBeat.i(129719);
      if (this.tic != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.tic.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void eJD()
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
        paramString = new hg();
        paramString.ecM = 3L;
        paramString.erV = 1L;
        paramString.aLk();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new hg();
        paramString.ecM = 7L;
        paramString.erV = 1L;
        paramString.aLk();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new hg();
          paramString.ecM = 9L;
          paramString.erV = 1L;
          paramString.aLk();
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
        if (eJC() != null) {
          FingerprintWalletLockUI.f(eJC());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new hg();
          paramString.ecM = 3L;
          paramString.erV = 2L;
          paramString.aLk();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new hg();
            paramString.ecM = 7L;
            paramString.erV = 2L;
            paramString.aLk();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new hg();
            paramString.ecM = 9L;
            paramString.erV = 2L;
            paramString.aLk();
            AppMethodBeat.o(129721);
            return;
            ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (eJC() != null)
            {
              FingerprintWalletLockUI.a(eJC(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
              AppMethodBeat.o(129721);
              return;
              ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (eJC() != null)
              {
                FingerprintWalletLockUI.a(eJC(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
                AppMethodBeat.o(129721);
                return;
                if (eJC() != null)
                {
                  FingerprintWalletLockUI.b(eJC(), paramInt, FingerprintWalletLockUI.this.getString(2131765346));
                  AppMethodBeat.o(129721);
                  return;
                  if (eJC() != null)
                  {
                    FingerprintWalletLockUI.b(eJC(), paramInt, FingerprintWalletLockUI.this.getString(2131765363));
                    AppMethodBeat.o(129721);
                    return;
                    ad.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (eJC() != null) {
                      FingerprintWalletLockUI.b(eJC(), paramInt, FingerprintWalletLockUI.this.getString(2131765353));
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