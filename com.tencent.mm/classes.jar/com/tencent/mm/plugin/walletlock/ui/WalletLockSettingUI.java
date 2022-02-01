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
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b;
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
  private IconPreference Ixe;
  private IconPreference Ixf;
  private IconPreference Ixg;
  private IconPreference Ixh;
  private boolean Ixi = false;
  private boolean Ixj = true;
  private boolean Ixk = true;
  private boolean Ixl = true;
  private int gwE = 0;
  private d jzT;
  private int mScene = -1;
  private f screen;
  
  private void M(int paramInt1, int paramInt2, String paramString)
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
      paramPreference.lb(com.tencent.mm.cb.a.fromDPToPix(this, 20), com.tencent.mm.cb.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.alG(2131691380);
        }
        for (;;)
        {
          paramPreference.alH(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.alG(2131691377);
        }
      }
      paramPreference.alG(2131691379);
      paramPreference.alH(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(129965);
    this.jzT = com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.jzT.setCanceledOnTouchOutside(false);
    this.jzT.show();
    AppMethodBeat.o(129965);
  }
  
  private void fVD()
  {
    AppMethodBeat.i(129956);
    fVH();
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.IwU.fVr()) });
    fVE();
    fVF();
    fVG();
    AppMethodBeat.o(129956);
  }
  
  private void fVE()
  {
    AppMethodBeat.i(129957);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
    if (!com.tencent.mm.plugin.walletlock.c.g.fVv())
    {
      Log.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.jdMethod_do("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = m.hf(getContext());
    localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
    if (com.tencent.mm.plugin.walletlock.c.g.fUJ())
    {
      if (!bool)
      {
        this.screen.jdMethod_do("wallet_lock_fingerprint", false);
        this.Ixe.setDesc(getString(2131767787));
        this.Ixe.gLF();
        a(this.Ixe, true, false);
        this.Ixe.setEnabled(false);
        this.Ixe.OYn = true;
        this.Ixk = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.Ixj)
      {
        this.screen.jdMethod_do("wallet_lock_fingerprint", false);
        a(this.Ixe, true, true);
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.jdMethod_do("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.jdMethod_do("wallet_lock_fingerprint", false);
      a(this.Ixe, false, true);
    }
    AppMethodBeat.o(129957);
  }
  
  private void fVF()
  {
    AppMethodBeat.i(129958);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.IwU;
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.fUV()) });
    if ((com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() == 2) || (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() == 3))
    {
      a(this.Ixf, false, true);
      this.screen.jdMethod_do("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(129958);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() == 1)
    {
      if (this.Ixj)
      {
        a(this.Ixf, true, true);
        this.screen.jdMethod_do("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.Ixf, false, true);
      this.screen.jdMethod_do("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(129958);
  }
  
  private void fVG()
  {
    AppMethodBeat.i(129959);
    if (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() == 0)
    {
      if (this.Ixj)
      {
        a(this.Ixg, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.Ixg, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void fVH()
  {
    AppMethodBeat.i(129960);
    if ((this.Ixe != null) && (this.Ixk)) {
      a(this.Ixe, false, this.Ixk);
    }
    if ((this.Ixh != null) && (this.Ixl)) {
      a(this.Ixh, false, this.Ixl);
    }
    if (this.Ixf != null) {
      a(this.Ixf, false, true);
    }
    if (this.Ixg != null) {
      a(this.Ixg, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void fVI()
  {
    AppMethodBeat.i(129963);
    this.jzT = com.tencent.mm.ui.base.h.d(this, getString(2131767805), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129947);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(129947);
      }
    });
    this.jzT.setCanceledOnTouchOutside(false);
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
    return 2132017303;
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
        if (this.Ixi)
        {
          q(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        amW(getString(2131767790));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.Ixi) {
          q(paramInt2, paramIntent);
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129948);
            try
            {
              com.tencent.soter.a.a.aqK(3);
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
        amW(getString(2131767802));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((b)com.tencent.mm.kernel.g.af(b.class)).aeZ(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.IwU;
        com.tencent.mm.plugin.walletlock.c.g.fUM();
        fVD();
        Toast.makeText(this, getString(2131767784), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.fVx();
        if (this.Ixi) {
          M(-1, 0, "close wallet lock ok");
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129949);
            try
            {
              com.tencent.soter.a.a.aqK(3);
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
        paramIntent = new kz();
        paramIntent.eEH = 14L;
        paramIntent.eXI = 2L;
        paramIntent.bfK();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        amW(getString(2131767785));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.Ixi)
    {
      M(0, 4, "user cancel setting wallet lock");
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
    setMMTitle(2131767809);
    this.screen = getPreferenceScreen();
    this.screen = getPreferenceScreen();
    this.Ixe = ((IconPreference)this.screen.bmg("wallet_lock_fingerprint"));
    this.Ixf = ((IconPreference)this.screen.bmg("wallet_lock_gesture"));
    this.Ixg = ((IconPreference)this.screen.bmg("wallet_lock_close"));
    this.Ixh = ((IconPreference)this.screen.bmg("wallet_lock_faceid"));
    this.Ixe.alO(8);
    this.Ixf.alO(8);
    this.Ixg.alO(8);
    this.Ixh.alO(8);
    this.screen.jdMethod_do("wallet_lock_faceid", true);
    this.gwE = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.Ixi = true;
      this.Ixj = false;
    }
    paramBundle = new kz();
    paramBundle.eEH = 13L;
    paramBundle.eXI = 1L;
    paramBundle.eXJ = this.gwE;
    paramBundle.bfK();
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.Ixi), Boolean.valueOf(this.Ixj) });
    AppMethodBeat.o(129950);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.jzT != null) && (this.jzT.isShowing())) {
      this.jzT.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      fVH();
      a(paramPreference, true, true);
      if ((this.Ixk) && ((!this.Ixj) || (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() != 2)))
      {
        if (com.tencent.soter.core.a.ld(this)) {
          break label72;
        }
        fVI();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label72:
        if ((!this.Ixj) || (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() != 2))
        {
          Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((b)com.tencent.mm.kernel.g.af(b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      fVH();
      a(paramPreference, true, true);
      if ((this.Ixl) && ((!this.Ixj) || (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() != 3)))
      {
        if (com.tencent.soter.core.a.aV(this, 2)) {
          break label185;
        }
        fVI();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label185:
        if ((!this.Ixj) || (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() == 3))
        {
          Log.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((b)com.tencent.mm.kernel.g.af(b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      fVH();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() != 1)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((b)com.tencent.mm.kernel.g.af(b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      fVH();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.IwU.fVr() != 0)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((b)com.tencent.mm.kernel.g.af(b.class)).m(this, 3);
        paramf = new kz();
        paramf.eEH = 14L;
        paramf.eXI = 1L;
        paramf.bfK();
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((b)com.tencent.mm.kernel.g.af(b.class)).aQ(this);
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
    fVD();
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