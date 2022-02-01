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
import com.tencent.mm.g.b.a.hg;
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
  private IconPreference Dwk;
  private IconPreference Dwl;
  private IconPreference Dwm;
  private IconPreference Dwn;
  private boolean Dwo = false;
  private boolean Dwp = true;
  private boolean Dwq = true;
  private boolean Dwr = true;
  private int fPp = 0;
  private d iKm;
  private int mScene = -1;
  private f screen;
  
  private void K(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129954);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    q(paramInt1, localIntent);
    AppMethodBeat.o(129954);
  }
  
  private void a(Preference paramPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(129961);
    if ((paramPreference instanceof IconPreference))
    {
      paramPreference = (IconPreference)paramPreference;
      paramPreference.jO(com.tencent.mm.cc.a.fromDPToPix(this, 20), com.tencent.mm.cc.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.aco(2131691078);
        }
        for (;;)
        {
          paramPreference.acp(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.aco(2131691075);
        }
      }
      paramPreference.aco(2131691077);
      paramPreference.acp(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(129965);
    this.iKm = com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.iKm.setCanceledOnTouchOutside(false);
    this.iKm.show();
    AppMethodBeat.o(129965);
  }
  
  private void eKm()
  {
    AppMethodBeat.i(129956);
    eKq();
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa()) });
    eKn();
    eKo();
    eKp();
    AppMethodBeat.o(129956);
  }
  
  private void eKn()
  {
    AppMethodBeat.i(129957);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.Dwa;
    if (!com.tencent.mm.plugin.walletlock.c.g.eKe())
    {
      ad.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.cP("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = m.gp(getContext());
    localg = com.tencent.mm.plugin.walletlock.c.g.Dwa;
    if (com.tencent.mm.plugin.walletlock.c.g.eJs())
    {
      if (!bool)
      {
        this.screen.cP("wallet_lock_fingerprint", false);
        this.Dwk.setDesc(getString(2131765344));
        this.Dwk.fzA();
        a(this.Dwk, true, false);
        this.Dwk.setEnabled(false);
        this.Dwk.Jsx = true;
        this.Dwq = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.Dwp)
      {
        this.screen.cP("wallet_lock_fingerprint", false);
        a(this.Dwk, true, true);
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.cP("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.cP("wallet_lock_fingerprint", false);
      a(this.Dwk, false, true);
    }
    AppMethodBeat.o(129957);
  }
  
  private void eKo()
  {
    AppMethodBeat.i(129958);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.Dwa;
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.eJE()) });
    if ((com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() == 2) || (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() == 3))
    {
      a(this.Dwl, false, true);
      this.screen.cP("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(129958);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() == 1)
    {
      if (this.Dwp)
      {
        a(this.Dwl, true, true);
        this.screen.cP("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.Dwl, false, true);
      this.screen.cP("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(129958);
  }
  
  private void eKp()
  {
    AppMethodBeat.i(129959);
    if (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() == 0)
    {
      if (this.Dwp)
      {
        a(this.Dwm, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.Dwm, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void eKq()
  {
    AppMethodBeat.i(129960);
    if ((this.Dwk != null) && (this.Dwq)) {
      a(this.Dwk, false, this.Dwq);
    }
    if ((this.Dwn != null) && (this.Dwr)) {
      a(this.Dwn, false, this.Dwr);
    }
    if (this.Dwl != null) {
      a(this.Dwl, false, true);
    }
    if (this.Dwm != null) {
      a(this.Dwm, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void eKr()
  {
    AppMethodBeat.i(129963);
    this.iKm = com.tencent.mm.ui.base.h.d(this, getString(2131765362), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129947);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(129947);
      }
    });
    this.iKm.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129963);
  }
  
  private void q(int paramInt, Intent paramIntent)
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
        if (this.Dwo)
        {
          q(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        abY(getString(2131765347));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.Dwo) {
          q(paramInt2, paramIntent);
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129948);
            try
            {
              com.tencent.soter.a.a.agO(3);
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
        abY(getString(2131765359));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).VM(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.Dwa;
        com.tencent.mm.plugin.walletlock.c.g.eJv();
        eKm();
        Toast.makeText(this, getString(2131765341), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.eKg();
        if (this.Dwo) {
          K(-1, 0, "close wallet lock ok");
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129949);
            try
            {
              com.tencent.soter.a.a.agO(3);
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
        paramIntent = new hg();
        paramIntent.ecM = 14L;
        paramIntent.erV = 2L;
        paramIntent.aLk();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        abY(getString(2131765342));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.Dwo)
    {
      K(0, 4, "user cancel setting wallet lock");
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
    this.Dwk = ((IconPreference)this.screen.aVD("wallet_lock_fingerprint"));
    this.Dwl = ((IconPreference)this.screen.aVD("wallet_lock_gesture"));
    this.Dwm = ((IconPreference)this.screen.aVD("wallet_lock_close"));
    this.Dwn = ((IconPreference)this.screen.aVD("wallet_lock_faceid"));
    this.Dwk.acw(8);
    this.Dwl.acw(8);
    this.Dwm.acw(8);
    this.Dwn.acw(8);
    this.screen.cP("wallet_lock_faceid", true);
    this.fPp = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.Dwo = true;
      this.Dwp = false;
    }
    paramBundle = new hg();
    paramBundle.ecM = 13L;
    paramBundle.erV = 1L;
    paramBundle.erW = this.fPp;
    paramBundle.aLk();
    ad.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.Dwo), Boolean.valueOf(this.Dwp) });
    AppMethodBeat.o(129950);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.iKm != null) && (this.iKm.isShowing())) {
      this.iKm.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      eKq();
      a(paramPreference, true, true);
      if ((this.Dwq) && ((!this.Dwp) || (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() != 2)))
      {
        if (com.tencent.soter.core.a.lc(this)) {
          break label72;
        }
        eKr();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label72:
        if ((!this.Dwp) || (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() != 2))
        {
          ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      eKq();
      a(paramPreference, true, true);
      if ((this.Dwr) && ((!this.Dwp) || (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() != 3)))
      {
        if (com.tencent.soter.core.a.aU(this, 2)) {
          break label185;
        }
        eKr();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label185:
        if ((!this.Dwp) || (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() == 3))
        {
          ad.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      eKq();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() != 1)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      eKq();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.Dwa.eKa() != 0)
      {
        ad.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(this, 3);
        paramf = new hg();
        paramf.ecM = 14L;
        paramf.erV = 1L;
        paramf.aLk();
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).aJ(this);
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
    eKm();
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