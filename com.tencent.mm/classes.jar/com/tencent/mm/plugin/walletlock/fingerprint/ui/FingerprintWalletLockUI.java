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
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI
  extends MMActivity
  implements com.tencent.mm.plugin.walletlock.ui.a
{
  private boolean BTP = false;
  private TextView BTV;
  private TextView BTW;
  private TextView BTX;
  private Animation BTY;
  private String BTZ;
  private String BUa;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d BUb;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h BUc;
  private com.tencent.mm.plugin.walletlock.c.b BUd;
  private String BUe = "-1";
  private int BUf = -1;
  private int BUg = -1;
  private String Lj;
  private TextView gzg;
  private String iXf = null;
  private boolean isCancelled = false;
  private com.tencent.mm.ui.widget.a.d kCl = null;
  private String mToken;
  private ProgressDialog opZ = null;
  private int skY = 0;
  private boolean uQf = true;
  
  private void Qr(String paramString)
  {
    AppMethodBeat.i(129735);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.skY > 1)
    {
      this.skY = i;
      dismissDialog();
      if (this.BTV != null)
      {
        this.BTV.setText(paramString);
        this.BTV.setTextColor(getResources().getColor(2131100798));
        this.BTV.setVisibility(4);
        if (this.BTY == null) {
          this.BTY = AnimationUtils.loadAnimation(getContext(), 2130772050);
        }
        this.BTV.startAnimation(this.BTY);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129707);
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
            AppMethodBeat.o(129707);
          }
        }, this.BTY.getDuration());
      }
      AppMethodBeat.o(129735);
      return;
    }
    AppMethodBeat.o(129735);
  }
  
  private void TV(int paramInt)
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
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(129734);
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = getString(2131765355);
    }
    dismissDialog();
    this.kCl = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129706);
        FingerprintWalletLockUI.this.finish();
        AppMethodBeat.o(129706);
      }
    });
    this.kCl.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129734);
  }
  
  private void aLi()
  {
    AppMethodBeat.i(129733);
    if ((this.opZ != null) && (this.opZ.isShowing())) {
      this.opZ.dismiss();
    }
    AppMethodBeat.o(129733);
  }
  
  private void ck(int paramInt, String paramString)
  {
    AppMethodBeat.i(129737);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt), paramString });
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
    aLi();
    if ((this.kCl != null) && (this.kCl.isShowing())) {
      this.kCl.dismiss();
    }
    AppMethodBeat.o(129728);
  }
  
  private void evr()
  {
    AppMethodBeat.i(129726);
    if (this.Lj.equals("action.verify_pattern"))
    {
      this.BTV.setText(2131765356);
      this.BTV.setTextColor(getResources().getColor(2131100711));
      this.BTX.setVisibility(0);
      AppMethodBeat.o(129726);
      return;
    }
    this.BTV.setText(2131765349);
    this.BTV.setTextColor(getResources().getColor(2131100711));
    this.BTX.setVisibility(8);
    AppMethodBeat.o(129726);
  }
  
  private void evs()
  {
    AppMethodBeat.i(129727);
    aLi();
    com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.BUf) });
    if (this.BUf == 2) {
      locala.acJ(2131765363).acM(2131765367).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129714);
          FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
          AppMethodBeat.o(129714);
        }
      }).acN(2131755691).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129713);
          ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
          AppMethodBeat.o(129713);
        }
      });
    }
    for (;;)
    {
      this.kCl = locala.fvp();
      this.kCl.setCanceledOnTouchOutside(false);
      this.kCl.show();
      AppMethodBeat.o(129727);
      return;
      locala.acJ(2131765362).aRO(getString(2131755835)).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129715);
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.evv();
          AppMethodBeat.o(129715);
        }
      });
    }
  }
  
  private void evt()
  {
    AppMethodBeat.i(129730);
    ac.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.BUa });
    if (bs.isNullOrNil(this.BUa))
    {
      finish();
      AppMethodBeat.o(129730);
      return;
    }
    Object localObject1 = this.BUa;
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
      this.BUd = new a(this);
      this.BUe = "-1";
      if (this.BUc == null) {
        this.BUc = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.BUc;
      Object localObject2 = this.BUd;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).BTS = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().kT(this).aeq(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).BTS).a((com.tencent.soter.a.a.b)localObject3).aTy(com.tencent.mm.plugin.walletlock.c.g.BVG.BVH).aep(3).JXF;
      com.tencent.mm.plugin.walletlock.c.g.BVG.BVI = null;
      ac.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(129730);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.BVG.BVI;
      if (localObject2 == null)
      {
        Qr(getString(2131765351));
        AppMethodBeat.o(129730);
        return;
      }
      localObject1 = ((j)localObject2).JWJ;
      localObject2 = ((j)localObject2).signature;
      if (this.BUb != null)
      {
        this.opZ = com.tencent.mm.ui.base.h.b(this, getString(2131765358), false, null);
        this.BUb.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void aZ(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129708);
            ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
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
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.zw(SystemClock.elapsedRealtime());
      evu();
    }
  }
  
  private void evu()
  {
    AppMethodBeat.i(129731);
    this.uQf = false;
    ap.n(new Runnable()
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
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      i.BVK.ua(true);
      i.BVK.ub(true);
      ((Intent)localObject).addFlags(131072);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772140, 2130772145);
      AppMethodBeat.o(129731);
      return;
    }
    ac.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(129731);
  }
  
  private void release()
  {
    AppMethodBeat.i(129736);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.isCancelled) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129736);
      return;
    }
    this.isCancelled = true;
    if (this.BUc != null) {
      this.BUc.release();
    }
    if (this.BUb != null) {
      this.BUb.release();
    }
    f.fDM().fDN();
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
    this.BTV = ((TextView)findViewById(2131300099));
    this.BTW = ((TextView)findViewById(2131303155));
    this.gzg = ((TextView)findViewById(2131300095));
    this.BTX = ((TextView)findViewById(2131300096));
    this.BTW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129703);
        FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
        AppMethodBeat.o(129703);
      }
    });
    this.gzg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(129710);
        FingerprintWalletLockUI.evv();
        FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
        AppMethodBeat.o(129710);
      }
    });
    this.BTX.setOnClickListener(new View.OnClickListener()
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
    ac.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ac.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
      AppMethodBeat.o(129739);
      return;
    }
    paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        evu();
        com.tencent.mm.plugin.walletlock.c.h.evZ();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.uQf = false;
        Ys(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.aAa(this.BUe);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.zw(SystemClock.elapsedRealtime());
        evu();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt2 == -1)
      {
        this.uQf = false;
        Ys(getString(2131765371));
        AppMethodBeat.o(129739);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          evu();
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.BVK.ewf();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          evu();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.uQf = false;
          Ys(getString(2131765359));
          AppMethodBeat.o(129739);
          return;
        }
        finish();
        i.BVK.ewf();
        AppMethodBeat.o(129739);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).TU(0);
          paramIntent = com.tencent.mm.plugin.walletlock.c.g.BVG;
          com.tencent.mm.plugin.walletlock.c.g.evp();
          Toast.makeText(this, getString(2131765341), 0).show();
          evu();
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == -1)
        {
          this.uQf = false;
          Ys(getString(2131765342));
          AppMethodBeat.o(129739);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.BVK.ewf();
        }
      }
    }
    AppMethodBeat.o(129739);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129729);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    finish();
    i.BVK.ewf();
    AppMethodBeat.o(129729);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129722);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.Lj = paramBundle.getStringExtra("action");
    this.BUa = this.Lj;
    this.BTZ = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.iXf = paramBundle.getStringExtra("key_pay_passwd");
    this.BUg = paramBundle.getIntExtra("scene", -1);
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.Lj, this.BTZ });
    if (this.Lj.equals("action.verify_pattern"))
    {
      this.BUf = 2;
      com.tencent.mm.plugin.walletlock.c.h.ewb();
      AppMethodBeat.o(129722);
      return;
    }
    if (this.Lj.equals("action.switch_on_pattern")) {
      this.BUf = 1;
    }
    AppMethodBeat.o(129722);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129724);
    super.onPause();
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    dismissDialog();
    release();
    this.uQf = true;
    AppMethodBeat.o(129724);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129723);
    super.onResume();
    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.uQf) });
    if (!this.uQf)
    {
      AppMethodBeat.o(129723);
      return;
    }
    this.BUb = new c();
    this.BUc = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    f.fDM().fDN();
    this.opZ = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, null);
    evr();
    Object localObject;
    if (this.Lj.equals("action.switch_on_pattern"))
    {
      this.BTP = false;
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.BTP) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.BVG;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.evX();
      localObject = com.tencent.mm.plugin.walletlock.c.g.BVG;
      if ((!com.tencent.mm.plugin.walletlock.c.g.evm()) || (bool)) {
        break label620;
      }
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.evy()) {
        break label518;
      }
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).TU(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.BVG;
      com.tencent.mm.plugin.walletlock.c.g.evV();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(ai.getPackageName());
      bool = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GOO, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(2131765369));
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOO, Boolean.TRUE);
        com.tencent.mm.kernel.g.agR().agA().faa();
      }
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.wUl.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      ac.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(129723);
      return;
      this.BTP = true;
      break;
      label518:
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      aLi();
      this.kCl = new com.tencent.mm.ui.widget.a.d.a(this).acJ(2131765364).acM(2131765368).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129717);
          ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
          AppMethodBeat.o(129717);
        }
      }).e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(129716);
          ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
          FingerprintWalletLockUI.this.finish();
          FingerprintWalletLockUI.evv();
          AppMethodBeat.o(129716);
        }
      }).fvp();
      this.kCl.setCanceledOnTouchOutside(false);
      this.kCl.b(getString(2131765340), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(129704);
          ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(FingerprintWalletLockUI.this, 5);
          AppMethodBeat.o(129704);
        }
      });
      this.kCl.show();
      continue;
      label620:
      if (!com.tencent.soter.core.a.kP(this))
      {
        evs();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.iXf);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.BTP);
        this.BUb.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a()
        {
          public final void aZ(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(129712);
            ac.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(System.currentTimeMillis()) });
            if (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
            {
              ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
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
    private WeakReference<FingerprintWalletLockUI> slA;
    
    public a(FingerprintWalletLockUI paramFingerprintWalletLockUI)
    {
      AppMethodBeat.i(129718);
      this.slA = null;
      this.slA = new WeakReference(paramFingerprintWalletLockUI);
      AppMethodBeat.o(129718);
    }
    
    private FingerprintWalletLockUI evw()
    {
      AppMethodBeat.i(129719);
      if (this.slA != null)
      {
        FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.slA.get();
        AppMethodBeat.o(129719);
        return localFingerprintWalletLockUI;
      }
      AppMethodBeat.o(129719);
      return null;
    }
    
    public final void evx()
    {
      AppMethodBeat.i(129720);
      FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
      FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
      AppMethodBeat.o(129720);
    }
    
    public final void y(int paramInt, String paramString)
    {
      AppMethodBeat.i(129721);
      ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(FingerprintWalletLockUI.this)) });
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
      {
        paramString = new gd();
        paramString.dNx = 3L;
        paramString.ebp = 1L;
        paramString.aHZ();
      }
      if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) != 1) {
          break label167;
        }
        paramString = new gd();
        paramString.dNx = 7L;
        paramString.ebp = 1L;
        paramString.aHZ();
      }
      while (FingerprintWalletLockUI.c(FingerprintWalletLockUI.this))
      {
        AppMethodBeat.o(129721);
        return;
        label167:
        if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
        {
          paramString = new gd();
          paramString.dNx = 9L;
          paramString.ebp = 1L;
          paramString.aHZ();
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(129721);
        return;
        ac.i("MicroMsg.FingerprintWalletLockUI", "identify success");
        if (evw() != null) {
          FingerprintWalletLockUI.f(evw());
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.switch_on_pattern")))
        {
          paramString = new gd();
          paramString.dNx = 3L;
          paramString.ebp = 2L;
          paramString.aHZ();
        }
        if ((FingerprintWalletLockUI.d(FingerprintWalletLockUI.this) != null) && (FingerprintWalletLockUI.d(FingerprintWalletLockUI.this).equals("action.verify_pattern")))
        {
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 1)
          {
            paramString = new gd();
            paramString.dNx = 7L;
            paramString.ebp = 2L;
            paramString.aHZ();
            AppMethodBeat.o(129721);
            return;
          }
          if (FingerprintWalletLockUI.e(FingerprintWalletLockUI.this) == 2)
          {
            paramString = new gd();
            paramString.dNx = 9L;
            paramString.ebp = 2L;
            paramString.aHZ();
            AppMethodBeat.o(129721);
            return;
            ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
            AppMethodBeat.o(129721);
            return;
            ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            if (evw() != null)
            {
              FingerprintWalletLockUI.a(evw(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
              AppMethodBeat.o(129721);
              return;
              ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
              if (evw() != null)
              {
                FingerprintWalletLockUI.a(evw(), paramInt, FingerprintWalletLockUI.this.getString(2131765354));
                AppMethodBeat.o(129721);
                return;
                if (evw() != null)
                {
                  FingerprintWalletLockUI.b(evw(), paramInt, FingerprintWalletLockUI.this.getString(2131765346));
                  AppMethodBeat.o(129721);
                  return;
                  if (evw() != null)
                  {
                    FingerprintWalletLockUI.b(evw(), paramInt, FingerprintWalletLockUI.this.getString(2131765363));
                    AppMethodBeat.o(129721);
                    return;
                    ac.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                    if (evw() != null) {
                      FingerprintWalletLockUI.b(evw(), paramInt, FingerprintWalletLockUI.this.getString(2131765353));
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