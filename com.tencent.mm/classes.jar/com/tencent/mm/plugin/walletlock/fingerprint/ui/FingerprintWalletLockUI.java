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
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private boolean Ivd = false;
  private TextView Ivj;
  private TextView Ivk;
  private TextView Ivl;
  private Animation Ivm;
  private String Ivn;
  private String Ivo;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d Ivp;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h Ivq;
  private com.tencent.mm.plugin.walletlock.c.b Ivr;
  private String Ivs = "-1";
  private int Ivt = -1;
  private int Ivu = -1;
  private String Nl;
  private TextView hOu;
  private boolean isCancelled = false;
  private String krw = null;
  private String mToken;
  private com.tencent.mm.ui.widget.a.d mhs = null;
  private ProgressDialog qoU = null;
  private int wFZ = 0;
  private boolean zzT = true;
  
  private void aeu(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.wFZ > 1)
    {
      this.wFZ = i;
      dismissDialog();
      if (this.Ivj != null)
      {
        this.Ivj.setText(paramString);
        this.Ivj.setTextColor(getResources().getColor(2131100994));
        this.Ivj.setVisibility(4);
        if (this.Ivm == null) {
          this.Ivm = AnimationUtils.loadAnimation(getContext(), 2130772062);
        }
        this.Ivj.startAnimation(this.Ivm);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.Ivm.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void afa(int paramInt)
  {
    AppMethodBeat.i(129732);
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      AppMethodBeat.o(129732);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(2131767804));
      }
    }
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(2131767798);
    }
    dismissDialog();
    this.mhs = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.mhs.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void biW()
  {
    AppMethodBeat.i(129733);
    if ((this.qoU != null) && (this.qoU.isShowing())) {
      this.qoU.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void cK(int paramInt, String paramString)
  {
    AppMethodBeat.i(129737);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt), paramString });
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
    biW();
    if ((this.mhs != null) && (this.mhs.isShowing())) {
      this.mhs.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void fUO()
  {
    AppMethodBeat.i(129726);
    if (this.Nl.equals("action.verify_pattern"))
    {
      this.Ivj.setText(2131767799);
      this.Ivj.setTextColor(getResources().getColor(2131100904));
      this.Ivl.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.Ivj.setText(2131767792);
    this.Ivj.setTextColor(getResources().getColor(2131100904));
    this.Ivl.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void fUP()
  {
    AppMethodBeat.i(129727);
    biW();
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.Ivt) });
    if (this.Ivt == 2) {
      locala.aoS(2131767806).aoV(2131767810).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).aoW(2131755761).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129713);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
          AppMethodBeat.o(129713);
        }
      });
    }
    for (;;)
    {
      this.mhs = locala.hbn();
      this.mhs.setCanceledOnTouchOutside(false);
      this.mhs.show();
      AppMethodBeat.o(129727);
      return;
      locala.aoS(2131767805).bou(getString(2131755921)).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.fUS();
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void fUQ()
  {
    AppMethodBeat.i(129730);
    Log.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.Ivo });
    if (Util.isNullOrNil(this.Ivo))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.Ivo;
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
      this.Ivr = new a(this);
      this.Ivs = "-1";
      if (this.Ivq == null) {
        this.Ivq = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.Ivq;
      Object localObject2 = this.Ivr;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).Ivg = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().lh(this).aqM(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).Ivg).a((com.tencent.soter.a.a.b)localObject3).bqn(com.tencent.mm.plugin.walletlock.c.g.IwU.IwV).aqL(3).RQV;
      com.tencent.mm.plugin.walletlock.c.g.IwU.IwW = null;
      Log.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.IwU.IwW;
      if (localObject2 == null)
      {
        aeu(getString(2131767794));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).RPZ;
      localObject2 = ((j)localObject2).signature;
      if (this.Ivp != null)
      {
        this.qoU = com.tencent.mm.ui.base.h.a(this, getString(2131767801), false, null);
        this.Ivp.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bg(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129708);
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.k(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129708);
              return;
            }
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(2131767790));
            AppMethodBeat.o(129708);
          }
        }, this.mToken, (String)localObject1, (String)localObject2);
      }
      AppMethodBeat.o(129730);
      return;
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.LU(SystemClock.elapsedRealtime());
      fUR();
    }
  }
  
  private void fUR()
  {
    AppMethodBeat.i(129731);
    this.zzT = false;
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      i.IwY.yH(true);
      i.IwY.yI(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772165, 2130772170);
      AppMethodBeat.o(129731);
      return;
    }
    Log.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(129731);
  }
  
  private void release()
  {
    AppMethodBeat.i(129736);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.isCancelled) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129736);
      return;
    }
    this.isCancelled = true;
    if (this.Ivq != null) {
      this.Ivq.release();
    }
    if (this.Ivp != null) {
      this.Ivp.release();
    }
    f.hlO().hlP();
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
    return 2131494694;
  }
  
  public void initView()
  {
    AppMethodBeat.i(129725);
    super.initView();
    this.Ivj = ((TextView)findViewById(2131301534));
    this.Ivk = ((TextView)findViewById(2131305812));
    this.hOu = ((TextView)findViewById(2131301530));
    this.Ivl = ((TextView)findViewById(2131301531));
    this.Ivk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129703);
      }
    });
    this.hOu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FingerprintWalletLockUI.fUS();
        FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129710);
      }
    });
    this.Ivl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    Log.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
      AppMethodBeat.o(129739);
      return;
    }
    paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        fUR();
        com.tencent.mm.plugin.walletlock.c.h.fVw();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.zzT = false;
        amW(getString(2131767814));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.aWg(this.Ivs);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.LU(SystemClock.elapsedRealtime());
        fUR();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.zzT = false;
        amW(getString(2131767814));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          fUR();
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.IwY.fVC();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          fUR();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.zzT = false;
          amW(getString(2131767802));
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.IwY.fVC();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(0);
          paramIntent = com.tencent.mm.plugin.walletlock.c.g.IwU;
          com.tencent.mm.plugin.walletlock.c.g.fUM();
          Toast.makeText(this, getString(2131767784), 0).show();
          fUR();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.zzT = false;
          amW(getString(2131767785));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.IwY.fVC();
        }
      }
    }
    AppMethodBeat.o(129739);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129729);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    finish();
    i.IwY.fVC();
    AppMethodBeat.o(129729);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129722);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.Nl = paramBundle.getStringExtra("action");
    this.Ivo = this.Nl;
    this.Ivn = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.krw = paramBundle.getStringExtra("key_pay_passwd");
    this.Ivu = paramBundle.getIntExtra("scene", -1);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.Nl, this.Ivn });
    if (this.Nl.equals("action.verify_pattern"))
    {
      this.Ivt = 2;
      com.tencent.mm.plugin.walletlock.c.h.fVy();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.Nl.equals("action.switch_on_pattern")) {
      this.Ivt = 1;
    }
    AppMethodBeat.o(129722);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129724);
    super.onPause();
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    dismissDialog();
    release();
    this.zzT = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.zzT) });
    if (!this.zzT)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.Ivp = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
    this.Ivq = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    f.hlO().hlP();
    this.qoU = com.tencent.mm.ui.base.h.a(this, getString(2131756029), false, null);
    fUO();
    Object localObject;
    if (this.Nl.equals("action.switch_on_pattern"))
    {
      this.Ivd = false;
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.Ivd) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.IwU;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.fVu();
      localObject = com.tencent.mm.plugin.walletlock.c.g.IwU;
      if ((!com.tencent.mm.plugin.walletlock.c.g.fUJ()) || (bool)) {
        break label620;
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.fUV()) {
        break label518;
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.IwU;
      com.tencent.mm.plugin.walletlock.c.g.fVs();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(MMApplicationContext.getPackageName());
      bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Oea, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(2131767812));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oea, Boolean.TRUE);
        com.tencent.mm.kernel.g.aAh().azQ().gBI();
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.CyF.a(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      Log.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.Ivd = true;
      break;
      label518:
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      biW();
      this.mhs = new com.tencent.mm.ui.widget.a.d.a(this).aoS(2131767807).aoV(2131767811).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129717);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
          AppMethodBeat.o(129717);
        }
      }).f(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(129716);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.fUS();
          AppMethodBeat.o(129716);
        }
      }).hbn();
      this.mhs.setCanceledOnTouchOutside(false);
      this.mhs.b(getString(2131767783), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).m(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.mhs.show();
      continue;
      label620:
      if (!com.tencent.soter.core.a.ld(this))
      {
        fUP();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.krw);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.Ivd);
        this.Ivp.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bg(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129712);
            Log.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(System.currentTimeMillis()) });
            if (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
            {
              Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
              AppMethodBeat.o(129712);
              return;
            }
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.h(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129712);
              return;
            }
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(2131767789));
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
    private WeakReference<FingerprintWalletLockUI> wGB;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.wGB = null;
      this.wGB = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI fUT()
    {
      AppMethodBeat.i(129719);
      if (this.wGB != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.wGB.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void A(int paramInt, String paramString)
    {
      AppMethodBeat.i(129721);
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(FingerprintWalletLockUI.this)) });
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
      {
        paramString = new kz();
        paramString.eEH = 3L;
        paramString.eXI = 1L;
        paramString.bfK();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new kz();
        paramString.eEH = 7L;
        paramString.eXI = 1L;
        paramString.bfK();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new kz();
          paramString.eEH = 9L;
          paramString.eXI = 1L;
          paramString.bfK();
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(129721);
        return;
        Log.i("MicroMsg.FingerprintWalletLockUI", "identify success");
        if (fUT() != null) {
          FingerprintWalletLockUI.f(fUT());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new kz();
          paramString.eEH = 3L;
          paramString.eXI = 2L;
          paramString.bfK();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new kz();
            paramString.eEH = 7L;
            paramString.eXI = 2L;
            paramString.bfK();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new kz();
            paramString.eEH = 9L;
            paramString.eXI = 2L;
            paramString.bfK();
            AppMethodBeat.o(129721);
            return;
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (fUT() != null)
            {
              FingerprintWalletLockUI.a(fUT(), paramInt, FingerprintWalletLockUI.this.getString(2131767797));
              AppMethodBeat.o(129721);
              return;
              Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (fUT() != null)
              {
                FingerprintWalletLockUI.a(fUT(), paramInt, FingerprintWalletLockUI.this.getString(2131767797));
                AppMethodBeat.o(129721);
                return;
                if (fUT() != null)
                {
                  FingerprintWalletLockUI.b(fUT(), paramInt, FingerprintWalletLockUI.this.getString(2131767789));
                  AppMethodBeat.o(129721);
                  return;
                  if (fUT() != null)
                  {
                    FingerprintWalletLockUI.b(fUT(), paramInt, FingerprintWalletLockUI.this.getString(2131767806));
                    AppMethodBeat.o(129721);
                    return;
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (fUT() != null) {
                      FingerprintWalletLockUI.b(fUT(), paramInt, FingerprintWalletLockUI.this.getString(2131767796));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public final void fUU()
    {
      AppMethodBeat.i(129720);
      FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
      FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
      AppMethodBeat.o(129720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */