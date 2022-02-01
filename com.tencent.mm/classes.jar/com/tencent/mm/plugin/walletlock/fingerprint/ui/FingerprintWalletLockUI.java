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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private int ByW = 0;
  private boolean FeN = true;
  private boolean Ppi = false;
  private TextView Ppo;
  private TextView Ppp;
  private TextView Ppq;
  private Animation Ppr;
  private String Pps;
  private String Ppt;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d Ppu;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h Ppv;
  private com.tencent.mm.plugin.walletlock.c.b Ppw;
  private String Ppx = "-1";
  private int Ppy = -1;
  private int Ppz = -1;
  private String eb;
  private boolean isCancelled = false;
  private TextView kCQ;
  private String mToken;
  private String njf = null;
  private com.tencent.mm.ui.widget.a.d pfx = null;
  private ProgressDialog tND = null;
  
  private void amO(int paramInt)
  {
    AppMethodBeat.i(129732);
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.by.c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      AppMethodBeat.o(129732);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(a.g.PoP));
      }
    }
  }
  
  private void amo(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.ByW > 1)
    {
      this.ByW = i;
      dismissDialog();
      if (this.Ppo != null)
      {
        this.Ppo.setText(paramString);
        this.Ppo.setTextColor(getResources().getColor(a.b.red));
        this.Ppo.setVisibility(4);
        if (this.Ppr == null) {
          this.Ppr = AnimationUtils.loadAnimation(getContext(), a.a.PnJ);
        }
        this.Ppo.startAnimation(this.Ppr);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.Ppr.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(a.g.PoL);
    }
    dismissDialog();
    this.pfx = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.pfx.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void bsu()
  {
    AppMethodBeat.i(129733);
    if ((this.tND != null) && (this.tND.isShowing())) {
      this.tND.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void cL(int paramInt, String paramString)
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
    bsu();
    if ((this.pfx != null) && (this.pfx.isShowing())) {
      this.pfx.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void gNu()
  {
    AppMethodBeat.i(129726);
    if (this.eb.equals("action.verify_pattern"))
    {
      this.Ppo.setText(a.g.PoM);
      this.Ppo.setTextColor(getResources().getColor(a.b.normal_text_color));
      this.Ppq.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.Ppo.setText(a.g.PoH);
    this.Ppo.setTextColor(getResources().getColor(a.b.normal_text_color));
    this.Ppq.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void gNv()
  {
    AppMethodBeat.i(129727);
    bsu();
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.Ppy) });
    if (this.Ppy == 2) {
      locala.ayg(a.g.PoR).ayj(a.g.PoU).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).ayk(a.g.app_cancel).d(new DialogInterface.OnClickListener()
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
      this.pfx = locala.icu();
      this.pfx.setCanceledOnTouchOutside(false);
      this.pfx.show();
      AppMethodBeat.o(129727);
      return;
      locala.ayg(a.g.PoQ).bBj(getString(a.g.app_ok)).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.gNy();
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void gNw()
  {
    AppMethodBeat.i(129730);
    Log.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.Ppt });
    if (Util.isNullOrNil(this.Ppt))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.Ppt;
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
      this.Ppw = new a(this);
      this.Ppx = "-1";
      if (this.Ppv == null) {
        this.Ppv = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.Ppv;
      Object localObject2 = this.Ppw;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).Ppl = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().mf(this).aAz(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).Ppl).a((com.tencent.soter.a.a.b)localObject3).bDg(g.PqZ.Pra).aAy(3).Ztz;
      g.PqZ.Prb = null;
      Log.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = g.PqZ.Prb;
      if (localObject2 == null)
      {
        amo(getString(a.g.PoI));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).ZsE;
      localObject2 = ((j)localObject2).signature;
      if (this.Ppu != null)
      {
        this.tND = com.tencent.mm.ui.base.h.a(this, getString(a.g.PoN), false, null);
        this.Ppu.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bh(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129708);
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.k(FingerprintWalletLockUI.this);
              AppMethodBeat.o(129708);
              return;
            }
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(a.g.PoF));
            AppMethodBeat.o(129708);
          }
        }, this.mToken, (String)localObject1, (String)localObject2);
      }
      AppMethodBeat.o(129730);
      return;
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ts(SystemClock.elapsedRealtime());
      gNx();
    }
  }
  
  private void gNx()
  {
    AppMethodBeat.i(129731);
    this.FeN = false;
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
      i.Prd.CC(true);
      i.Prd.CD(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(a.a.slide_left_in, a.a.slide_right_out);
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
    if (this.Ppv != null) {
      this.Ppv.release();
    }
    if (this.Ppu != null) {
      this.Ppu.release();
    }
    com.tencent.soter.a.g.f.ipn().ipo();
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
    return a.e.PnX;
  }
  
  public void initView()
  {
    AppMethodBeat.i(129725);
    super.initView();
    this.Ppo = ((TextView)findViewById(a.d.PnS));
    this.Ppp = ((TextView)findViewById(a.d.PnV));
    this.kCQ = ((TextView)findViewById(a.d.PnQ));
    this.Ppq = ((TextView)findViewById(a.d.PnR));
    this.Ppp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129703);
      }
    });
    this.kCQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FingerprintWalletLockUI.gNy();
        FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129710);
      }
    });
    this.Ppq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129711);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        gNx();
        com.tencent.mm.plugin.walletlock.c.h.gOc();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.FeN = false;
        auQ(getString(a.g.PoX));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.bhN(this.Ppx);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ts(SystemClock.elapsedRealtime());
        gNx();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.FeN = false;
        auQ(getString(a.g.PoX));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          gNx();
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.Prd.gOi();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          gNx();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.FeN = false;
          auQ(getString(a.g.PoO));
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.Prd.gOi();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).amN(0);
          paramIntent = g.PqZ;
          g.gNs();
          Toast.makeText(this, getString(a.g.PoB), 0).show();
          gNx();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.FeN = false;
          auQ(getString(a.g.PoC));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.Prd.gOi();
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
    i.Prd.gOi();
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
    this.eb = paramBundle.getStringExtra("action");
    this.Ppt = this.eb;
    this.Pps = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.njf = paramBundle.getStringExtra("key_pay_passwd");
    this.Ppz = paramBundle.getIntExtra("scene", -1);
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.eb, this.Pps });
    if (this.eb.equals("action.verify_pattern"))
    {
      this.Ppy = 2;
      com.tencent.mm.plugin.walletlock.c.h.gOe();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.eb.equals("action.switch_on_pattern")) {
      this.Ppy = 1;
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
    this.FeN = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.FeN) });
    if (!this.FeN)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.Ppu = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
    this.Ppv = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    com.tencent.soter.a.g.f.ipn().ipo();
    this.tND = com.tencent.mm.ui.base.h.a(this, getString(a.g.app_waiting), false, null);
    gNu();
    Object localObject;
    if (this.eb.equals("action.switch_on_pattern"))
    {
      this.Ppi = false;
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.Ppi) });
      localObject = g.PqZ;
      boolean bool = g.gOa();
      localObject = g.PqZ;
      if ((!g.gNp()) || (bool)) {
        break label620;
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!e.gNB()) {
        break label518;
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).amN(1);
      localObject = g.PqZ;
      g.gNY();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(MMApplicationContext.getPackageName());
      bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vsl, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(a.g.PoW));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsl, Boolean.TRUE);
        com.tencent.mm.kernel.h.aHG().aHp().hxT();
      }
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.IzE.a(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      Log.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.Ppi = true;
      break;
      label518:
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      bsu();
      this.pfx = new com.tencent.mm.ui.widget.a.d.a(this).ayg(a.g.PoS).ayj(a.g.PoV).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129717);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
          AppMethodBeat.o(129717);
        }
      }).f(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(129716);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.gNy();
          AppMethodBeat.o(129716);
        }
      }).icu();
      this.pfx.setCanceledOnTouchOutside(false);
      this.pfx.b(getString(a.g.PoA), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).n(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.pfx.show();
      continue;
      label620:
      if (!com.tencent.soter.core.a.mb(this))
      {
        gNv();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.njf);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.Ppi);
        this.Ppu.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void bh(int paramAnonymousInt, String paramAnonymousString)
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
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(a.g.PoE));
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
    private WeakReference<FingerprintWalletLockUI> Bzx;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.Bzx = null;
      this.Bzx = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI gNz()
    {
      AppMethodBeat.i(129719);
      if (this.Bzx != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.Bzx.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void B(int paramInt, String paramString)
    {
      AppMethodBeat.i(129721);
      Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(FingerprintWalletLockUI.this)) });
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
      {
        paramString = new nv();
        paramString.gCd = 3L;
        paramString.han = 1L;
        paramString.bpa();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new nv();
        paramString.gCd = 7L;
        paramString.han = 1L;
        paramString.bpa();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new nv();
          paramString.gCd = 9L;
          paramString.han = 1L;
          paramString.bpa();
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
        if (gNz() != null) {
          FingerprintWalletLockUI.f(gNz());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new nv();
          paramString.gCd = 3L;
          paramString.han = 2L;
          paramString.bpa();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new nv();
            paramString.gCd = 7L;
            paramString.han = 2L;
            paramString.bpa();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new nv();
            paramString.gCd = 9L;
            paramString.han = 2L;
            paramString.bpa();
            AppMethodBeat.o(129721);
            return;
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (gNz() != null)
            {
              FingerprintWalletLockUI.a(gNz(), paramInt, FingerprintWalletLockUI.this.getString(a.g.PoK));
              AppMethodBeat.o(129721);
              return;
              Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (gNz() != null)
              {
                FingerprintWalletLockUI.a(gNz(), paramInt, FingerprintWalletLockUI.this.getString(a.g.PoK));
                AppMethodBeat.o(129721);
                return;
                if (gNz() != null)
                {
                  FingerprintWalletLockUI.b(gNz(), paramInt, FingerprintWalletLockUI.this.getString(a.g.PoE));
                  AppMethodBeat.o(129721);
                  return;
                  if (gNz() != null)
                  {
                    FingerprintWalletLockUI.b(gNz(), paramInt, FingerprintWalletLockUI.this.getString(a.g.PoR));
                    AppMethodBeat.o(129721);
                    return;
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (gNz() != null) {
                      FingerprintWalletLockUI.b(gNz(), paramInt, FingerprintWalletLockUI.this.getString(a.g.PoJ));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public final void gNA()
    {
      AppMethodBeat.i(129720);
      FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
      FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
      AppMethodBeat.o(129720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */