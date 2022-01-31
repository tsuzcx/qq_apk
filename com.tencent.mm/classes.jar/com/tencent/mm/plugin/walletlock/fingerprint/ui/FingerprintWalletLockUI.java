package com.tencent.mm.plugin.walletlock.fingerprint.ui;

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
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.1;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h.2;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;

public class FingerprintWalletLockUI
  extends MMActivity
{
  private String CO;
  private String fdD;
  private String frT = null;
  private com.tencent.mm.ui.widget.a.c gym = null;
  private TextView hJw;
  private ProgressDialog khj = null;
  private int klW = 0;
  private boolean mnq = true;
  private boolean ndI = false;
  private boolean qPg = false;
  private TextView qPn;
  private TextView qPo;
  private Animation qPp;
  private String qPq;
  private String qPr;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.d qPs;
  private com.tencent.mm.plugin.walletlock.fingerprint.a.h qPt;
  private com.tencent.mm.plugin.walletlock.c.b qPu;
  private String qPv = "-1";
  private int qPw = -1;
  private int qPx = -1;
  
  private void AY(String paramString)
  {
    String str = paramString;
    if (bk.bl(paramString)) {
      str = getString(a.g.wallet_lock_fingerprint_verify_system_error);
    }
    dismissDialog();
    this.gym = com.tencent.mm.ui.base.h.a(this, str, "", new FingerprintWalletLockUI.3(this));
    this.gym.setCanceledOnTouchOutside(false);
  }
  
  private void Ba(int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramInt == 1) {
      localIntent.putExtra("action", "action.touchlock_verify_by_paypwd");
    }
    for (;;)
    {
      localIntent.putExtra("key_wallet_lock_type", 2);
      com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
      return;
      if (paramInt == 2)
      {
        localIntent.putExtra("action", "action.touchlock_need_verify_paypwd");
        localIntent.putExtra("key_wallet_lock_input_new_fp_tips", getString(a.g.wallet_lock_new_fingerprint_need_verify_paypwd_tips));
      }
    }
  }
  
  private void aQ(int paramInt, String paramString)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt), paramString });
    release();
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_err_msg", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  private void bTy()
  {
    if ((this.khj != null) && (this.khj.isShowing())) {
      this.khj.dismiss();
    }
  }
  
  private void bXV()
  {
    if (this.CO.equals("action.verify_pattern"))
    {
      this.qPn.setText(a.g.wallet_lock_fingerprint_verify_tips);
      this.qPn.setTextColor(getResources().getColor(a.b.normal_text_color));
      this.qPo.setVisibility(0);
      return;
    }
    this.qPn.setText(a.g.wallet_lock_fingerprint_open_tips);
    this.qPn.setTextColor(getResources().getColor(a.b.normal_text_color));
    this.qPo.setVisibility(8);
  }
  
  private void bXW()
  {
    bTy();
    c.a locala = new c.a(this);
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", new Object[] { Integer.valueOf(this.qPw) });
    if (this.qPw == 2) {
      locala.Iq(a.g.wallet_lock_no_fingerprint_when_offline_verify).Is(a.g.wallet_lock_set_again).a(new FingerprintWalletLockUI.10(this)).It(a.g.app_cancel).b(new FingerprintWalletLockUI.9(this));
    }
    for (;;)
    {
      this.gym = locala.aoP();
      this.gym.setCanceledOnTouchOutside(false);
      this.gym.show();
      return;
      locala.Iq(a.g.wallet_lock_no_fingerprint_tips).aeD(getString(a.g.app_ok)).a(new FingerprintWalletLockUI.11(this));
    }
  }
  
  private void bXX()
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", new Object[] { this.qPr });
    if (bk.bl(this.qPr)) {
      finish();
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = this.qPr;
      int i = -1;
      switch (((String)localObject1).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
        case 0: 
        case 1: 
          this.qPu = new FingerprintWalletLockUI.a(this, this);
          this.qPv = "-1";
          if (this.qPt == null) {
            this.qPt = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
          }
          localObject1 = this.qPt;
          localObject2 = this.qPu;
          Object localObject3 = new h.1((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2);
          ((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).qPk = new com.tencent.soter.a.a.a();
          localObject3 = new b.a().hM(this).Jt(1).a(((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1).qPk).a((com.tencent.soter.a.a.b)localObject3).afV(com.tencent.mm.plugin.walletlock.c.g.qQZ.qRa).Js(3).wPV;
          com.tencent.mm.plugin.walletlock.c.g.qQZ.qRb = null;
          y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
          com.tencent.soter.a.a.a(new h.2((com.tencent.mm.plugin.walletlock.fingerprint.a.h)localObject1, (com.tencent.mm.plugin.walletlock.c.b)localObject2), (com.tencent.soter.a.g.b)localObject3);
          return;
          if (((String)localObject1).equals("action.switch_on_pattern"))
          {
            i = 0;
            continue;
            if (((String)localObject1).equals("action.verify_pattern"))
            {
              i = 1;
              continue;
              if (((String)localObject1).equals("next_action.switch_on_pattern"))
              {
                i = 2;
                continue;
                if (((String)localObject1).equals("next_action.goto_protected_page")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      localObject2 = com.tencent.mm.plugin.walletlock.c.g.qQZ.qRb;
      if (localObject2 == null)
      {
        tR(getString(a.g.wallet_lock_fingerprint_system_error));
        return;
      }
      localObject1 = ((j)localObject2).wPi;
      localObject2 = ((j)localObject2).signature;
    } while (this.qPs == null);
    this.khj = com.tencent.mm.ui.base.h.b(this, getString(a.g.wallet_lock_fingerprint_verifying), false, null);
    this.qPs.a(new FingerprintWalletLockUI.5(this), this.fdD, (String)localObject1, (String)localObject2);
    return;
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.gM(SystemClock.elapsedRealtime());
    bXY();
  }
  
  private void bXY()
  {
    this.mnq = false;
    ai.l(new FingerprintWalletLockUI.2(this), 200L);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("page_intent");
    if (localIntent != null)
    {
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
      i.qRd.kV(true);
      i.qRd.kW(true);
      localIntent.addFlags(131072);
      startActivity(localIntent);
      overridePendingTransition(a.a.slide_left_in, a.a.slide_right_out);
      return;
    }
    y.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
  }
  
  private void dismissDialog()
  {
    bTy();
    if ((this.gym != null) && (this.gym.isShowing())) {
      this.gym.dismiss();
    }
  }
  
  private void release()
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", new Object[] { Boolean.valueOf(this.ndI) });
    if (this.ndI) {
      return;
    }
    this.ndI = true;
    if (this.qPt != null)
    {
      com.tencent.mm.plugin.walletlock.fingerprint.a.h localh = this.qPt;
      y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
      if (localh.qPk != null) {
        localh.qPk.oj(true);
      }
    }
    if (this.qPs != null) {
      this.qPs.release();
    }
    f.cPH().cPI();
  }
  
  private void tR(String paramString)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - this.klW > 1)
    {
      this.klW = i;
      dismissDialog();
      if (this.qPn != null)
      {
        this.qPn.setText(paramString);
        this.qPn.setTextColor(getResources().getColor(a.b.red));
        this.qPn.setVisibility(4);
        if (this.qPp == null) {
          this.qPp = AnimationUtils.loadAnimation(this.mController.uMN, a.a.fingerprint_tips_anim);
        }
        this.qPn.startAnimation(this.qPp);
        ai.l(new Runnable()
        {
          public final void run()
          {
            FingerprintWalletLockUI.j(FingerprintWalletLockUI.this).setVisibility(0);
          }
        }, this.qPp.getDuration());
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    release();
  }
  
  protected final int getLayoutId()
  {
    return a.e.fingerprint_wallet_lock_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    this.qPn = ((TextView)findViewById(a.d.fingerprint_tips));
    this.qPo = ((TextView)findViewById(a.d.pay_pwd_verify));
    this.hJw = ((TextView)findViewById(a.d.fingerprint_lock_close_btn));
    this.qPo.setOnClickListener(new FingerprintWalletLockUI.1(this));
    this.hJw.setOnClickListener(new FingerprintWalletLockUI.7(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {
      y.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramInt2 = paramIntent.getIntExtra("key_err_code", -1);
            y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", new Object[] { Integer.valueOf(paramInt2) });
            if (paramInt1 != 1) {
              break;
            }
            if (paramInt2 == 0)
            {
              bXY();
              com.tencent.mm.plugin.walletlock.c.h.bYB();
              return;
            }
          } while (paramInt2 != -1);
          this.mnq = false;
          AY(getString(a.g.wallet_lock_verify_by_pay_pwd_error));
          return;
          if (paramInt1 != 2) {
            break;
          }
          if (paramInt2 == 0)
          {
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ra(this.qPv);
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.gM(SystemClock.elapsedRealtime());
            bXY();
            return;
          }
        } while (paramInt2 != -1);
        this.mnq = false;
        AY(getString(a.g.wallet_lock_verify_by_pay_pwd_error));
        return;
        if (paramInt1 == 3)
        {
          if (paramInt2 == 0)
          {
            bXY();
            return;
          }
          finish();
          i.qRd.bYH();
          return;
        }
        if (paramInt1 == 4)
        {
          if (paramInt2 == 0)
          {
            bXY();
            return;
          }
          if (paramInt2 == -1)
          {
            this.mnq = false;
            AY(getString(a.g.wallet_lock_gesture_open_failed));
            return;
          }
          finish();
          i.qRd.bYH();
          return;
        }
      } while (paramInt1 != 5);
      if (paramInt2 == 0)
      {
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.walletlock.a.b.class)).AZ(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.qQZ;
        com.tencent.mm.plugin.walletlock.c.g.bXT();
        Toast.makeText(this, getString(a.g.wallet_lock_close_all_success), 0).show();
        bXY();
        return;
      }
      if (paramInt2 == -1)
      {
        this.mnq = false;
        AY(getString(a.g.wallet_lock_close_error));
        return;
      }
    } while (paramInt2 != 4);
    finish();
    i.qRd.bYH();
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
    finish();
    i.qRd.bYH();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    initView();
    paramBundle = getIntent();
    this.CO = paramBundle.getStringExtra("action");
    this.qPr = this.CO;
    this.qPq = paramBundle.getStringExtra("next_action");
    this.fdD = paramBundle.getStringExtra("token");
    this.frT = paramBundle.getStringExtra("key_pay_passwd");
    this.qPx = paramBundle.getIntExtra("scene", -1);
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", new Object[] { this.CO, this.qPq });
    if (this.CO.equals("action.verify_pattern"))
    {
      this.qPw = 2;
      com.tencent.mm.plugin.walletlock.c.h.bYD();
    }
    while (!this.CO.equals("action.switch_on_pattern")) {
      return;
    }
    this.qPw = 1;
  }
  
  protected void onPause()
  {
    super.onPause();
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
    dismissDialog();
    release();
    this.mnq = true;
  }
  
  protected void onResume()
  {
    super.onResume();
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", new Object[] { Boolean.valueOf(this.mnq) });
    if (!this.mnq) {
      return;
    }
    this.qPs = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
    this.qPt = new com.tencent.mm.plugin.walletlock.fingerprint.a.h();
    this.ndI = false;
    f.cPH().cPI();
    this.khj = com.tencent.mm.ui.base.h.b(this, getString(a.g.app_waiting), false, null);
    bXV();
    Object localObject;
    if (this.CO.equals("action.switch_on_pattern"))
    {
      this.qPg = false;
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", new Object[] { Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.qPg) });
      localObject = com.tencent.mm.plugin.walletlock.c.g.qQZ;
      boolean bool = com.tencent.mm.plugin.walletlock.c.g.bYz();
      localObject = com.tencent.mm.plugin.walletlock.c.g.qQZ;
      if ((!com.tencent.mm.plugin.walletlock.c.g.bXQ()) || (bool)) {
        break label537;
      }
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
      if (!com.tencent.mm.plugin.walletlock.gesture.a.e.bYc()) {
        break label435;
      }
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.walletlock.a.b.class)).AZ(1);
      localObject = com.tencent.mm.plugin.walletlock.c.g.qQZ;
      com.tencent.mm.plugin.walletlock.c.g.bYx();
      finish();
      localObject = new Intent(this, GestureGuardLogicUI.class);
      ((Intent)localObject).addFlags(131072);
      ((Intent)localObject).putExtra("action", "action.verify_pattern");
      ((Intent)localObject).putExtra("next_action", "next_action.goto_protected_page");
      ((Intent)localObject).putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
      ((Intent)localObject).setPackage(ae.getPackageName());
      bool = com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uxS, false);
      if (!bool)
      {
        ((Intent)localObject).putExtra("verify_title", getString(a.g.wallet_lock_verify_by_gesture_when_not_support_fingerprint));
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxS, Boolean.valueOf(true));
        com.tencent.mm.kernel.g.DP().Dz().mC(true);
      }
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", new Object[] { Boolean.valueOf(bool) });
      startActivity((Intent)localObject);
      com.tencent.mm.plugin.report.service.h.nFQ.f(12097, new Object[] { Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      y.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      return;
      this.qPg = true;
      break;
      label435:
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
      bTy();
      this.gym = new c.a(this).Iq(a.g.wallet_lock_not_support_fingerprint).Is(a.g.wallet_lock_set_gesture).a(new FingerprintWalletLockUI.13(this)).e(new FingerprintWalletLockUI.12(this)).aoP();
      this.gym.setCanceledOnTouchOutside(false);
      this.gym.b(getString(a.g.wallet_lock_close), false, new FingerprintWalletLockUI.14(this));
      this.gym.show();
      continue;
      label537:
      if (!com.tencent.soter.core.a.hH(this))
      {
        bXW();
      }
      else
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_pay_passwd", this.frT);
        ((Bundle)localObject).putBoolean("key_fp_lock_offline_mode", this.qPg);
        this.qPs.a(new FingerprintWalletLockUI.8(this), (Bundle)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI
 * JD-Core Version:    0.7.0.1
 */