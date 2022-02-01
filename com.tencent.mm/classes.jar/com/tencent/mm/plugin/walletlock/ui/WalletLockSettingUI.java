package com.tencent.mm.plugin.walletlock.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;

public class WalletLockSettingUI
  extends MMPreference
{
  private boolean ADA = true;
  private boolean ADB = true;
  private boolean ADC = true;
  private IconPreference ADv;
  private IconPreference ADw;
  private IconPreference ADx;
  private IconPreference ADy;
  private boolean ADz = false;
  private int fsv = 0;
  private d hRe;
  private int mScene = -1;
  private f screen;
  
  private void J(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129954);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    p(paramInt1, localIntent);
    AppMethodBeat.o(129954);
  }
  
  private void Ug(String paramString)
  {
    AppMethodBeat.i(129965);
    this.hRe = com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.hRe.setCanceledOnTouchOutside(false);
    this.hRe.show();
    AppMethodBeat.o(129965);
  }
  
  private void a(Preference paramPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(129961);
    if ((paramPreference instanceof IconPreference))
    {
      paramPreference = (IconPreference)paramPreference;
      paramPreference.jq(com.tencent.mm.cd.a.fromDPToPix(this, 20), com.tencent.mm.cd.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.XT(2131691078);
        }
        for (;;)
        {
          paramPreference.XU(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.XT(2131691075);
        }
      }
      paramPreference.XT(2131691077);
      paramPreference.XU(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void egM()
  {
    AppMethodBeat.i(129956);
    egQ();
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.ADl.egA()) });
    egN();
    egO();
    egP();
    AppMethodBeat.o(129956);
  }
  
  private void egN()
  {
    AppMethodBeat.i(129957);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
    if (!com.tencent.mm.plugin.walletlock.c.g.egE())
    {
      ad.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.cE("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = m.ga(getContext());
    localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
    if (com.tencent.mm.plugin.walletlock.c.g.efS())
    {
      if (!bool)
      {
        this.screen.cE("wallet_lock_fingerprint", false);
        this.ADv.setDesc(getString(2131765344));
        this.ADv.eTz();
        a(this.ADv, true, false);
        this.ADv.setEnabled(false);
        this.ADv.GeS = true;
        this.ADB = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.ADA)
      {
        this.screen.cE("wallet_lock_fingerprint", false);
        a(this.ADv, true, true);
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.cE("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.cE("wallet_lock_fingerprint", false);
      a(this.ADv, false, true);
    }
    AppMethodBeat.o(129957);
  }
  
  private void egO()
  {
    AppMethodBeat.i(129958);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.ADl;
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.ege()) });
    if ((com.tencent.mm.plugin.walletlock.c.g.ADl.egA() == 2) || (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() == 3))
    {
      a(this.ADw, false, true);
      this.screen.cE("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(129958);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() == 1)
    {
      if (this.ADA)
      {
        a(this.ADw, true, true);
        this.screen.cE("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.ADw, false, true);
      this.screen.cE("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(129958);
  }
  
  private void egP()
  {
    AppMethodBeat.i(129959);
    if (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() == 0)
    {
      if (this.ADA)
      {
        a(this.ADx, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.ADx, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void egQ()
  {
    AppMethodBeat.i(129960);
    if ((this.ADv != null) && (this.ADB)) {
      a(this.ADv, false, this.ADB);
    }
    if ((this.ADy != null) && (this.ADC)) {
      a(this.ADy, false, this.ADC);
    }
    if (this.ADw != null) {
      a(this.ADw, false, true);
    }
    if (this.ADx != null) {
      a(this.ADx, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void egR()
  {
    AppMethodBeat.i(129963);
    this.hRe = com.tencent.mm.ui.base.h.d(this, getString(2131765362), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129947);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(129947);
      }
    });
    this.hRe.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129963);
  }
  
  private void p(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(129955);
    setResult(paramInt, paramIntent);
    finish();
    AppMethodBeat.o(129955);
  }
  
  public int getResourceId()
  {
    return 2131951758;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(129964);
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ad.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
      AppMethodBeat.o(129964);
      return;
    }
    int i = paramIntent.getIntExtra("key_err_code", -1);
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
    if (paramInt1 == 1)
    {
      ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
      if (i == 0)
      {
        if (this.ADz)
        {
          p(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        Ug(getString(2131765347));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.ADz) {
          p(paramInt2, paramIntent);
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129948);
            try
            {
              com.tencent.soter.a.a.abV(3);
              AppMethodBeat.o(129948);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
              AppMethodBeat.o(129948);
            }
          }
        }, "WalletLockRemoveAuthKey");
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        Ug(getString(2131765359));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).RK(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.ADl;
        com.tencent.mm.plugin.walletlock.c.g.efV();
        egM();
        Toast.makeText(this, getString(2131765341), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.egG();
        if (this.ADz) {
          J(-1, 0, "close wallet lock ok");
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129949);
            try
            {
              com.tencent.soter.a.a.abV(3);
              AppMethodBeat.o(129949);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
              AppMethodBeat.o(129949);
            }
          }
        }, "WalletLockRemoveAuthKey");
        paramIntent = new en();
        paramIntent.dMW = 14L;
        paramIntent.dZx = 2L;
        paramIntent.aBj();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        Ug(getString(2131765342));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.ADz)
    {
      J(0, 4, "user cancel setting wallet lock");
      AppMethodBeat.o(129953);
      return;
    }
    finish();
    AppMethodBeat.o(129953);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129950);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(129946);
        if (WalletLockSettingUI.a(WalletLockSettingUI.this)) {
          WalletLockSettingUI.a(WalletLockSettingUI.this, "user cancel setting wallet lock");
        }
        for (;;)
        {
          AppMethodBeat.o(129946);
          return false;
          WalletLockSettingUI.this.finish();
        }
      }
    });
    setMMTitle(2131765366);
    this.screen = getPreferenceScreen();
    this.screen = getPreferenceScreen();
    this.ADv = ((IconPreference)this.screen.aKk("wallet_lock_fingerprint"));
    this.ADw = ((IconPreference)this.screen.aKk("wallet_lock_gesture"));
    this.ADx = ((IconPreference)this.screen.aKk("wallet_lock_close"));
    this.ADy = ((IconPreference)this.screen.aKk("wallet_lock_faceid"));
    this.ADv.Yb(8);
    this.ADw.Yb(8);
    this.ADx.Yb(8);
    this.ADy.Yb(8);
    this.screen.cE("wallet_lock_faceid", true);
    this.fsv = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.ADz = true;
      this.ADA = false;
    }
    paramBundle = new en();
    paramBundle.dMW = 13L;
    paramBundle.dZx = 1L;
    paramBundle.dZy = this.fsv;
    paramBundle.aBj();
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.ADz), Boolean.valueOf(this.ADA) });
    AppMethodBeat.o(129950);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.hRe != null) && (this.hRe.isShowing())) {
      this.hRe.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      egQ();
      a(paramPreference, true, true);
      if ((this.ADB) && ((!this.ADA) || (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() != 2)))
      {
        if (com.tencent.soter.core.a.kD(this)) {
          break label72;
        }
        egR();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label72:
        if ((!this.ADA) || (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() != 2))
        {
          ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      egQ();
      a(paramPreference, true, true);
      if ((this.ADC) && ((!this.ADA) || (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() != 3)))
      {
        if (com.tencent.soter.core.a.aL(this, 2)) {
          break label185;
        }
        egR();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label185:
        if ((!this.ADA) || (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() == 3))
        {
          ad.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      egQ();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() != 1)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      egQ();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.ADl.egA() != 0)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(this, 3);
        paramf = new en();
        paramf.dMW = 14L;
        paramf.dZx = 1L;
        paramf.aBj();
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).aF(this);
      AppMethodBeat.o(129962);
      return true;
    }
    AppMethodBeat.o(129962);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129951);
    super.onResume();
    egM();
    AppMethodBeat.o(129951);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI
 * JD-Core Version:    0.7.0.1
 */