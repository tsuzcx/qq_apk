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
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private boolean DLO = false;
  private TextView DLU;
  private TextView DLV;
  private TextView DLW;
  private Animation DLX;
  private String DLY;
  private String DLZ;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d DMa;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h DMb;
  private com.tencent.mm.plugin.walletlock.c.b DMc;
  private String DMd = "-1";
  private int DMe = -1;
  private int DMf = -1;
  private String Nb;
  private TextView gVA;
  private boolean isCancelled = false;
  private String jth = null;
  private com.tencent.mm.ui.widget.a.d lcb = null;
  private String mToken;
  private ProgressDialog oZW = null;
  private int tst = 0;
  private boolean wft = true;
  
  private void UG(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.tst > 1)
    {
      this.tst = i;
      dismissDialog();
      if (this.DLU != null)
      {
        this.DLU.setText(paramString);
        this.DLU.setTextColor(getResources().getColor(2131100798));
        this.DLU.setVisibility(4);
        if (this.DLX == null) {
          this.DLX = AnimationUtils.loadAnimation(getContext(), 2130772050);
        }
        this.DLU.startAnimation(this.DLX);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.DLX.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void Wu(int paramInt)
  {
    AppMethodBeat.i(129732);
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      AppMethodBeat.o(129732);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(2131765361));
      }
    }
  }
  
  private void aOP()
  {
    AppMethodBeat.i(129733);
    if ((this.oZW != null) && (this.oZW.isShowing())) {
      this.oZW.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = getString(2131765355);
    }
    dismissDialog();
    this.lcb = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.lcb.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void cs(int paramInt, String paramString)
  {
    AppMethodBeat.i(129737);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt), paramString });
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
    aOP();
    if ((this.lcb != null) && (this.lcb.isShowing())) {
      this.lcb.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void eNf()
  {
    AppMethodBeat.i(129726);
    if (this.Nb.equals("action.verify_pattern"))
    {
      this.DLU.setText(2131765356);
      this.DLU.setTextColor(getResources().getColor(2131100711));
      this.DLW.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.DLU.setText(2131765349);
    this.DLU.setTextColor(getResources().getColor(2131100711));
    this.DLW.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void eNg()
  {
    AppMethodBeat.i(129727);
    aOP();
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.DMe) });
    if (this.DMe == 2) {
      locala.afR(2131765363).afU(2131765367).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).afV(2131755691).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129713);
          ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
          AppMethodBeat.o(129713);
        }
      });
    }
    for (;;)
    {
      this.lcb = locala.fQv();
      this.lcb.setCanceledOnTouchOutside(false);
      this.lcb.show();
      AppMethodBeat.o(129727);
      return;
      locala.afR(2131765362).aZo(getString(2131755835)).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.eNj();
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void eNh()
  {
    AppMethodBeat.i(129730);
    ae.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.DLZ });
    if (bu.isNullOrNil(this.DLZ))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.DLZ;
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
      this.DMc = new a(this);
      this.DMd = "-1";
      if (this.DMb == null) {
        this.DMb = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.DMb;
      Object localObject2 = this.DMc;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).DLR = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().lm(this).ahz(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).DLR).a((com.tencent.soter.a.a.b)localObject3).bbb(com.tencent.mm.plugin.walletlock.c.g.DNF.DNG).ahy(3).Mox;
      com.tencent.mm.plugin.walletlock.c.g.DNF.DNH = null;
      ae.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.DNF.DNH;
      if (localObject2 == null)
      {
        UG(getString(2131765351));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).MnB;
      localObject2 = ((j)localObject2).signature;
      if (this.DMa != null)
      {
        this.oZW = com.tencent.mm.ui.base.h.b(this, getString(2131765358), false, null);
        this.DMa.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bb(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129708);
            ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
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
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.CG(SystemClock.elapsedRealtime());
      eNi();
    }
  }
  
  private void eNi()
  {
    AppMethodBeat.i(129731);
    this.wft = false;
    ar.o(new Runnable()
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
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      i.DNJ.uS(true);
      i.DNJ.uT(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772140, 2130772145);
      AppMethodBeat.o(129731);
      return;
    }
    ae.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(129731);
  }
  
  private void release()
  {
    AppMethodBeat.i(129736);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.isCancelled) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129736);
      return;
    }
    this.isCancelled = true;
    if (this.DMb != null) {
      this.DMb.release();
    }
    if (this.DMa != null) {
      this.DMa.release();
    }
    f.fZD().fZE();
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
    this.DLU = ((TextView)findViewById(2131300099));
    this.DLV = ((TextView)findViewById(2131303155));
    this.gVA = ((TextView)findViewById(2131300095));
    this.DLW = ((TextView)findViewById(2131300096));
    this.DLV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129703);
      }
    });
    this.gVA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FingerprintWalletLockUI.eNj();
        FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129710);
      }
    });
    this.DLW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    ae.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ae.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
      AppMethodBeat.o(129739);
      return;
    }
    paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        eNi();
        com.tencent.mm.plugin.walletlock.c.h.eNN();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.wft = false;
        acP(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.aGE(this.DMd);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.CG(SystemClock.elapsedRealtime());
        eNi();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.wft = false;
        acP(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          eNi();
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.DNJ.eNT();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          eNi();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.wft = false;
          acP(getString(2131765359));
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.DNJ.eNT();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).Wt(0);
          paramIntent = com.tencent.mm.plugin.walletlock.c.g.DNF;
          com.tencent.mm.plugin.walletlock.c.g.eNd();
          Toast.makeText(this, getString(2131765341), 0).show();
          eNi();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.wft = false;
          acP(getString(2131765342));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.DNJ.eNT();
        }
      }
    }
    AppMethodBeat.o(129739);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129729);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    finish();
    i.DNJ.eNT();
    AppMethodBeat.o(129729);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129722);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.Nb = paramBundle.getStringExtra("action");
    this.DLZ = this.Nb;
    this.DLY = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.jth = paramBundle.getStringExtra("key_pay_passwd");
    this.DMf = paramBundle.getIntExtra("scene", -1);
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.Nb, this.DLY });
    if (this.Nb.equals("action.verify_pattern"))
    {
      this.DMe = 2;
      com.tencent.mm.plugin.walletlock.c.h.eNP();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.Nb.equals("action.switch_on_pattern")) {
      this.DMe = 1;
    }
    AppMethodBeat.o(129722);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129724);
    super.onPause();
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    dismissDialog();
    release();
    this.wft = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.wft) });
    if (!this.wft)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.DMa = new c();
    this.DMb = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    f.fZD().fZE();
    this.oZW = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, null);
    eNf();
    Object localObject;
    if (this.Nb.equals("action.switch_on_pattern"))
    {
      this.DLO = false;
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.DLO) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.DNF;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.eNL();
      localObject = com.tencent.mm.plugin.walletlock.c.g.DNF;
      if ((!com.tencent.mm.plugin.walletlock.c.g.eNa()) || (bool)) {
        break label620;
      }
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.eNm()) {
        break label518;
      }
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).Wt(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.DNF;
      com.tencent.mm.plugin.walletlock.c.g.eNJ();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(ak.getPackageName());
      bool = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IVI, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(2131765369));
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVI, Boolean.TRUE);
        com.tencent.mm.kernel.g.ajR().ajA().fuc();
      }
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.g.yxI.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      ae.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.DLO = true;
      break;
      label518:
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      aOP();
      this.lcb = new com.tencent.mm.ui.widget.a.d.a(this).afR(2131765364).afU(2131765368).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129717);
          ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
          AppMethodBeat.o(129717);
        }
      }).e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(129716);
          ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.eNj();
          AppMethodBeat.o(129716);
        }
      }).fQv();
      this.lcb.setCanceledOnTouchOutside(false);
      this.lcb.b(getString(2131765340), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.lcb.show();
      continue;
      label620:
      if (!com.tencent.soter.core.a.li(this))
      {
        eNg();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.jth);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.DLO);
        this.DMa.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bb(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129712);
            ae.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(System.currentTimeMillis()) });
            if (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
            {
              ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
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
    private WeakReference<FingerprintWalletLockUI> tsV;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.tsV = null;
      this.tsV = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI eNk()
    {
      AppMethodBeat.i(129719);
      if (this.tsV != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.tsV.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void eNl()
    {
      AppMethodBeat.i(129720);
      FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
      FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
      AppMethodBeat.o(129720);
    }
    
    public final void y(int paramInt, String paramString)
    {
      AppMethodBeat.i(129721);
      ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(FingerprintWalletLockUI.this)) });
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
      {
        paramString = new hi();
        paramString.eeh = 3L;
        paramString.etC = 1L;
        paramString.aLH();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new hi();
        paramString.eeh = 7L;
        paramString.etC = 1L;
        paramString.aLH();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new hi();
          paramString.eeh = 9L;
          paramString.etC = 1L;
          paramString.aLH();
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(129721);
        return;
        ae.i("MicroMsg.FingerprintWalletLockUI", "identify success");
        if (eNk() != null) {
          FingerprintWalletLockUI.f(eNk());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new hi();
          paramString.eeh = 3L;
          paramString.etC = 2L;
          paramString.aLH();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new hi();
            paramString.eeh = 7L;
            paramString.etC = 2L;
            paramString.aLH();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new hi();
            paramString.eeh = 9L;
            paramString.etC = 2L;
            paramString.aLH();
            AppMethodBeat.o(129721);
            return;
            ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (eNk() != null)
            {
              FingerprintWalletLockUI.a(eNk(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
              AppMethodBeat.o(129721);
              return;
              ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (eNk() != null)
              {
                FingerprintWalletLockUI.a(eNk(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
                AppMethodBeat.o(129721);
                return;
                if (eNk() != null)
                {
                  FingerprintWalletLockUI.b(eNk(), paramInt, FingerprintWalletLockUI.this.getString(2131765346));
                  AppMethodBeat.o(129721);
                  return;
                  if (eNk() != null)
                  {
                    FingerprintWalletLockUI.b(eNk(), paramInt, FingerprintWalletLockUI.this.getString(2131765363));
                    AppMethodBeat.o(129721);
                    return;
                    ae.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (eNk() != null) {
                      FingerprintWalletLockUI.b(eNk(), paramInt, FingerprintWalletLockUI.this.getString(2131765353));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */