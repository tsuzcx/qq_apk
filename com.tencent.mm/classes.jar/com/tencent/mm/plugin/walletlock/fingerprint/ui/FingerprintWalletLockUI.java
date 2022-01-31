package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;

public class FingerprintWalletLockUI
  extends MMActivity
{
  private String Dx;
  private String gJv = null;
  private com.tencent.mm.ui.widget.b.c hUL = null;
  private boolean isCancelled = false;
  private TextView jCY;
  private ProgressDialog kFY = null;
  private int mGM = 0;
  private String mToken;
  private boolean oMy = true;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d uEA;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h uEB;
  private com.tencent.mm.plugin.walletlock.c.b uEC;
  private String uED = "-1";
  private int uEE = -1;
  private int uEF = -1;
  private boolean uEn = false;
  private TextView uEu;
  private TextView uEv;
  private TextView uEw;
  private Animation uEx;
  private String uEy;
  private String uEz;
  
  private void EC(String paramString)
  {
    AppMethodBeat.i(51530);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.mGM > 1)
    {
      this.mGM = i;
      dismissDialog();
      if (this.uEu != null)
      {
        this.uEu.setText(paramString);
        this.uEu.setTextColor(getResources().getColor(2131690391));
        this.uEu.setVisibility(4);
        if (this.uEx == null) {
          this.uEx = AnimationUtils.loadAnimation(getContext(), 2131034184);
        }
        this.uEu.startAnimation(this.uEx);
        al.p(new FingerprintWalletLockUI.5(this), this.uEx.getDuration());
      }
      AppMethodBeat.o(51530);
      return;
    }
    AppMethodBeat.o(51530);
  }
  
  private void IM(int paramInt)
  {
    AppMethodBeat.i(51527);
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.bq.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      AppMethodBeat.o(51527);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(2131305169));
      }
    }
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(51529);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = getString(2131305163);
    }
    dismissDialog();
    this.hUL = com.tencent.mm.ui.base.h.a(this, str, "", new FingerprintWalletLockUI.4(this));
    this.hUL.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(51529);
  }
  
  private void aCV()
  {
    AppMethodBeat.i(51528);
    if ((this.kFY != null) && (this.kFY.isShowing())) {
      this.kFY.dismiss();
    }
    AppMethodBeat.o(51528);
  }
  
  private void bv(int paramInt, String paramString)
  {
    AppMethodBeat.i(51532);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt), paramString });
    release();
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_err_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(51532);
  }
  
  private void cXD()
  {
    AppMethodBeat.i(51521);
    if (this.Dx.equals("action.verify_pattern"))
    {
      this.uEu.setText(2131305164);
      this.uEu.setTextColor(getResources().getColor(2131690322));
      this.uEw.setVisibility(0);
      AppMethodBeat.o(51521);
      return;
    }
    this.uEu.setText(2131305157);
    this.uEu.setTextColor(getResources().getColor(2131690322));
    this.uEw.setVisibility(8);
    AppMethodBeat.o(51521);
  }
  
  private void cXE()
  {
    AppMethodBeat.i(51522);
    aCV();
    c.a locala = new c.a(this);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.uEE) });
    if (this.uEE == 2) {
      locala.Rf(2131305171).Ri(2131305175).a(new FingerprintWalletLockUI.12(this)).Rj(2131296888).b(new FingerprintWalletLockUI.11(this));
    }
    for (;;)
    {
      this.hUL = locala.aLZ();
      this.hUL.setCanceledOnTouchOutside(false);
      this.hUL.show();
      AppMethodBeat.o(51522);
      return;
      locala.Rf(2131305170).avs(getString(2131297018)).a(new FingerprintWalletLockUI.13(this));
    }
  }
  
  private void cXF()
  {
    AppMethodBeat.i(51525);
    ab.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.uEz });
    if (bo.isNullOrNil(this.uEz))
    {
      finish();
      AppMethodBeat.o(51525);
      return;
    }
    Object localObject1 = this.uEz;
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
      AppMethodBeat.o(51525);
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
      this.uEC = new FingerprintWalletLockUI.a(this, this);
      this.uED = "-1";
      if (this.uEB == null) {
        this.uEB = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
      }
      localObject1 = this.uEB;
      Object localObject2 = this.uEC;
      Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
      ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).uEr = new com.tencent.soter.a.a.a();
      localObject3 = new b.a().jn(this).Sp(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).uEr).a((com.tencent.soter.a.a.b)localObject3).awQ(com.tencent.mm.plugin.walletlock.c.g.uGh.uGi).So(3).Bnv;
      com.tencent.mm.plugin.walletlock.c.g.uGh.uGj = null;
      ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
      com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
      AppMethodBeat.o(51525);
      return;
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.uGh.uGj;
      if (localObject2 == null)
      {
        EC(getString(2131305159));
        AppMethodBeat.o(51525);
        return;
      }
      localObject1 = ((j)localObject2).BmG;
      localObject2 = ((j)localObject2).signature;
      if (this.uEA != null)
      {
        this.kFY = com.tencent.mm.ui.base.h.b(this, getString(2131305166), false, null);
        this.uEA.a(new d.a()
        {
          public final void aC(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(51503);
            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
            if (paramAnonymousInt == 0)
            {
              FingerprintWalletLockUI.k(FingerprintWalletLockUI.this);
              AppMethodBeat.o(51503);
              return;
            }
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(2131305155));
            AppMethodBeat.o(51503);
          }
        }, this.mToken, (String)localObject1, (String)localObject2);
      }
      AppMethodBeat.o(51525);
      return;
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.ni(SystemClock.elapsedRealtime());
      cXG();
    }
  }
  
  private void cXG()
  {
    AppMethodBeat.i(51526);
    this.oMy = false;
    al.p(new FingerprintWalletLockUI.3(this), 200L);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localIntent != null)
    {
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      i.uGl.oe(true);
      i.uGl.of(true);
      localIntent.addFlags(131072);
      startActivity(localIntent);
      overridePendingTransition(2131034262, 2131034267);
      AppMethodBeat.o(51526);
      return;
    }
    ab.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    AppMethodBeat.o(51526);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(51523);
    aCV();
    if ((this.hUL != null) && (this.hUL.isShowing())) {
      this.hUL.dismiss();
    }
    AppMethodBeat.o(51523);
  }
  
  private void release()
  {
    AppMethodBeat.i(51531);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.isCancelled) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(51531);
      return;
    }
    this.isCancelled = true;
    if (this.uEB != null) {
      this.uEB.release();
    }
    if (this.uEA != null) {
      this.uEA.release();
    }
    f.dVD().dVE();
    AppMethodBeat.o(51531);
  }
  
  public void finish()
  {
    AppMethodBeat.i(51533);
    super.finish();
    release();
    AppMethodBeat.o(51533);
  }
  
  public int getLayoutId()
  {
    return 2130969599;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51520);
    super.initView();
    this.uEu = ((TextView)findViewById(2131824178));
    this.uEv = ((TextView)findViewById(2131824179));
    this.jCY = ((TextView)findViewById(2131824175));
    this.uEw = ((TextView)findViewById(2131824176));
    this.uEv.setOnClickListener(new FingerprintWalletLockUI.1(this));
    this.jCY.setOnClickListener(new FingerprintWalletLockUI.8(this));
    this.uEw.setOnClickListener(new FingerprintWalletLockUI.9(this));
    AppMethodBeat.o(51520);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(51534);
    ab.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ab.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
      AppMethodBeat.o(51534);
      return;
    }
    paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0)
      {
        cXG();
        com.tencent.mm.plugin.walletlock.c.h.cYl();
        AppMethodBeat.o(51534);
        return;
      }
      if (paramInt2 == -1)
      {
        this.oMy = false;
        La(getString(2131305179));
        AppMethodBeat.o(51534);
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0)
      {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.afY(this.uED);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.ni(SystemClock.elapsedRealtime());
        cXG();
        AppMethodBeat.o(51534);
        return;
      }
      if (paramInt2 == -1)
      {
        this.oMy = false;
        La(getString(2131305179));
        AppMethodBeat.o(51534);
      }
    }
    else
    {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          cXG();
          AppMethodBeat.o(51534);
          return;
        }
        finish();
        i.uGl.cYr();
        AppMethodBeat.o(51534);
        return;
      }
      if (paramInt1 == 4)
      {
        if (paramInt2 == 0)
        {
          cXG();
          AppMethodBeat.o(51534);
          return;
        }
        if (paramInt2 == -1)
        {
          this.oMy = false;
          La(getString(2131305167));
          AppMethodBeat.o(51534);
          return;
        }
        finish();
        i.uGl.cYr();
        AppMethodBeat.o(51534);
        return;
      }
      if (paramInt1 == 5)
      {
        if (paramInt2 == 0)
        {
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).IL(0);
          paramIntent = com.tencent.mm.plugin.walletlock.c.g.uGh;
          com.tencent.mm.plugin.walletlock.c.g.cXB();
          Toast.makeText(this, getString(2131305149), 0).show();
          cXG();
          AppMethodBeat.o(51534);
          return;
        }
        if (paramInt2 == -1)
        {
          this.oMy = false;
          La(getString(2131305150));
          AppMethodBeat.o(51534);
          return;
        }
        if (paramInt2 == 4)
        {
          finish();
          i.uGl.cYr();
        }
      }
    }
    AppMethodBeat.o(51534);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51524);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    finish();
    i.uGl.cYr();
    AppMethodBeat.o(51524);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51517);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.Dx = paramBundle.getStringExtra("action");
    this.uEz = this.Dx;
    this.uEy = paramBundle.getStringExtra("next_action");
    this.mToken = paramBundle.getStringExtra("token");
    this.gJv = paramBundle.getStringExtra("key_pay_passwd");
    this.uEF = paramBundle.getIntExtra("scene", -1);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.Dx, this.uEy });
    if (this.Dx.equals("action.verify_pattern"))
    {
      this.uEE = 2;
      com.tencent.mm.plugin.walletlock.c.h.cYn();
      AppMethodBeat.o(51517);
      return;
    }
    if (this.Dx.equals("action.switch_on_pattern")) {
      this.uEE = 1;
    }
    AppMethodBeat.o(51517);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51519);
    super.onPause();
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    dismissDialog();
    release();
    this.oMy = true;
    AppMethodBeat.o(51519);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51518);
    super.onResume();
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.oMy) });
    if (!this.oMy)
    {
      AppMethodBeat.o(51518);
      return;
    }
    this.uEA = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
    this.uEB = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.isCancelled = false;
    f.dVD().dVE();
    this.kFY = com.tencent.mm.ui.base.h.b(this, getString(2131297112), false, null);
    cXD();
    Object localObject;
    if (this.Dx.equals("action.switch_on_pattern"))
    {
      this.uEn = false;
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.uEn) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.uGh;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.cYj();
      localObject = com.tencent.mm.plugin.walletlock.c.g.uGh;
      if ((!com.tencent.mm.plugin.walletlock.c.g.cXy()) || (bool)) {
        break label553;
      }
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.cXK()) {
        break label451;
      }
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.walletlock.a.b.class)).IL(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.uGh;
      com.tencent.mm.plugin.walletlock.c.g.cYh();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(ah.getPackageName());
      bool = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yIc, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(2131305177));
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIc, Boolean.TRUE);
        com.tencent.mm.kernel.g.RL().Ru().dww();
      }
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      startActivity((Intent)localObject);
      com.tencent.mm.plugin.report.service.h.qsU.e(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      ab.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(51518);
      return;
      this.uEn = true;
      break;
      label451:
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      aCV();
      this.hUL = new c.a(this).Rf(2131305172).Ri(2131305176).a(new FingerprintWalletLockUI.15(this)).e(new FingerprintWalletLockUI.14(this)).aLZ();
      this.hUL.setCanceledOnTouchOutside(false);
      this.hUL.b(getString(2131305148), false, new FingerprintWalletLockUI.2(this));
      this.hUL.show();
      continue;
      label553:
      if (!com.tencent.soter.core.a.ji(this))
      {
        cXE();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.gJv);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.uEn);
        this.uEA.a(new FingerprintWalletLockUI.10(this), (Bundle)localObject);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */