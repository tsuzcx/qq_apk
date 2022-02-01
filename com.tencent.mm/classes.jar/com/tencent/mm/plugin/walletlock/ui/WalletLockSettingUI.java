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
import com.tencent.mm.f.b.a.nv;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.f;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.a.i;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;

public class WalletLockSettingUI
  extends MMPreference
{
  private IconPreference Prj;
  private IconPreference Prk;
  private IconPreference Prl;
  private IconPreference Prm;
  private boolean Prn = false;
  private boolean Pro = true;
  private boolean Prp = true;
  private boolean Prq = true;
  private int jaR = 0;
  private int mScene = -1;
  private d mpz;
  private f screen;
  
  private void L(int paramInt1, int paramInt2, String paramString)
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
      paramPreference.mu(com.tencent.mm.ci.a.fromDPToPix(this, 20), com.tencent.mm.ci.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.auE(a.f.radio_on);
        }
        for (;;)
        {
          paramPreference.auF(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.auE(a.f.radio_default_on);
        }
      }
      paramPreference.auE(a.f.radio_off);
      paramPreference.auF(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(129965);
    this.mpz = com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.mpz.setCanceledOnTouchOutside(false);
    this.mpz.show();
    AppMethodBeat.o(129965);
  }
  
  private void gOj()
  {
    AppMethodBeat.i(129956);
    gOn();
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(g.PqZ.gNX()) });
    gOk();
    gOl();
    gOm();
    AppMethodBeat.o(129956);
  }
  
  private void gOk()
  {
    AppMethodBeat.i(129957);
    g localg = g.PqZ;
    if (!g.gOb())
    {
      Log.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.dz("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = m.ig(getContext());
    localg = g.PqZ;
    if (g.gNp())
    {
      if (!bool)
      {
        this.screen.dz("wallet_lock_fingerprint", false);
        this.Prj.setDesc(getString(a.g.PoD));
        this.Prj.hKI();
        a(this.Prj, true, false);
        this.Prj.setEnabled(false);
        this.Prj.Wrw = true;
        this.Prp = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.Pro)
      {
        this.screen.dz("wallet_lock_fingerprint", false);
        a(this.Prj, true, true);
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.dz("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.dz("wallet_lock_fingerprint", false);
      a(this.Prj, false, true);
    }
    AppMethodBeat.o(129957);
  }
  
  private void gOl()
  {
    AppMethodBeat.i(129958);
    g localg = g.PqZ;
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(g.gNB()) });
    if ((g.PqZ.gNX() == 2) || (g.PqZ.gNX() == 3))
    {
      a(this.Prk, false, true);
      this.screen.dz("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(129958);
      return;
    }
    if (g.PqZ.gNX() == 1)
    {
      if (this.Pro)
      {
        a(this.Prk, true, true);
        this.screen.dz("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.Prk, false, true);
      this.screen.dz("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(129958);
  }
  
  private void gOm()
  {
    AppMethodBeat.i(129959);
    if (g.PqZ.gNX() == 0)
    {
      if (this.Pro)
      {
        a(this.Prl, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.Prl, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void gOn()
  {
    AppMethodBeat.i(129960);
    if ((this.Prj != null) && (this.Prp)) {
      a(this.Prj, false, this.Prp);
    }
    if ((this.Prm != null) && (this.Prq)) {
      a(this.Prm, false, this.Prq);
    }
    if (this.Prk != null) {
      a(this.Prk, false, true);
    }
    if (this.Prl != null) {
      a(this.Prl, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void gOo()
  {
    AppMethodBeat.i(129963);
    this.mpz = com.tencent.mm.ui.base.h.d(this, getString(a.g.PoQ), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129947);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(129947);
      }
    });
    this.mpz.setCanceledOnTouchOutside(false);
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
    return a.i.Ppe;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(129964);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
      AppMethodBeat.o(129964);
      return;
    }
    int i = paramIntent.getIntExtra("key_err_code", -1);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
    if (paramInt1 == 1)
    {
      Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
      if (i == 0)
      {
        if (this.Prn)
        {
          q(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        auQ(getString(a.g.PoF));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.Prn) {
          q(paramInt2, paramIntent);
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129948);
            try
            {
              com.tencent.soter.a.a.aAx(3);
              AppMethodBeat.o(129948);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
              AppMethodBeat.o(129948);
            }
          }
        }, "WalletLockRemoveAuthKey");
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        auQ(getString(a.g.PoO));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((b)com.tencent.mm.kernel.h.ae(b.class)).amN(0);
        paramIntent = g.PqZ;
        g.gNs();
        gOj();
        Toast.makeText(this, getString(a.g.PoB), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.gOd();
        if (this.Prn) {
          L(-1, 0, "close wallet lock ok");
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129949);
            try
            {
              com.tencent.soter.a.a.aAx(3);
              AppMethodBeat.o(129949);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
              AppMethodBeat.o(129949);
            }
          }
        }, "WalletLockRemoveAuthKey");
        paramIntent = new nv();
        paramIntent.gCd = 14L;
        paramIntent.han = 2L;
        paramIntent.bpa();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        auQ(getString(a.g.PoC));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.Prn)
    {
      L(0, 4, "user cancel setting wallet lock");
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
    setMMTitle(a.g.PoT);
    this.screen = getPreferenceScreen();
    this.screen = getPreferenceScreen();
    this.Prj = ((IconPreference)this.screen.byG("wallet_lock_fingerprint"));
    this.Prk = ((IconPreference)this.screen.byG("wallet_lock_gesture"));
    this.Prl = ((IconPreference)this.screen.byG("wallet_lock_close"));
    this.Prm = ((IconPreference)this.screen.byG("wallet_lock_faceid"));
    this.Prj.auG(0);
    this.Prk.auG(0);
    this.Prl.auG(0);
    this.Prm.auG(0);
    this.Prj.auO(8);
    this.Prk.auO(8);
    this.Prl.auO(8);
    this.Prm.auO(8);
    this.screen.dz("wallet_lock_faceid", true);
    this.jaR = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.Prn = true;
      this.Pro = false;
    }
    paramBundle = new nv();
    paramBundle.gCd = 13L;
    paramBundle.han = 1L;
    paramBundle.hao = this.jaR;
    paramBundle.bpa();
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.Prn), Boolean.valueOf(this.Pro) });
    AppMethodBeat.o(129950);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.mpz != null) && (this.mpz.isShowing())) {
      this.mpz.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      gOn();
      a(paramPreference, true, true);
      if ((this.Prp) && ((!this.Pro) || (g.PqZ.gNX() != 2)))
      {
        if (com.tencent.soter.core.a.mb(this)) {
          break label72;
        }
        gOo();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label72:
        if ((!this.Pro) || (g.PqZ.gNX() != 2))
        {
          Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((b)com.tencent.mm.kernel.h.ae(b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      gOn();
      a(paramPreference, true, true);
      if ((this.Prq) && ((!this.Pro) || (g.PqZ.gNX() != 3)))
      {
        if (com.tencent.soter.core.a.bo(this, 2)) {
          break label185;
        }
        gOo();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label185:
        if ((!this.Pro) || (g.PqZ.gNX() == 3))
        {
          Log.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((b)com.tencent.mm.kernel.h.ae(b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      gOn();
      a(paramPreference, true, true);
      if (g.PqZ.gNX() != 1)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((b)com.tencent.mm.kernel.h.ae(b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      gOn();
      a(paramPreference, true, true);
      if (g.PqZ.gNX() != 0)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((b)com.tencent.mm.kernel.h.ae(b.class)).n(this, 3);
        paramf = new nv();
        paramf.gCd = 14L;
        paramf.han = 1L;
        paramf.bpa();
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((b)com.tencent.mm.kernel.h.ae(b.class)).aV(this);
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
    gOj();
    AppMethodBeat.o(129951);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI
 * JD-Core Version:    0.7.0.1
 */