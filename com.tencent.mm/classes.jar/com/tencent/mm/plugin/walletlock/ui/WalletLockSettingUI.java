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
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;

public class WalletLockSettingUI
  extends MMPreference
{
  private IconPreference DNP;
  private IconPreference DNQ;
  private IconPreference DNR;
  private IconPreference DNS;
  private boolean DNT = false;
  private boolean DNU = true;
  private boolean DNV = true;
  private boolean DNW = true;
  private int fRv = 0;
  private d iNf;
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
      paramPreference.jS(com.tencent.mm.cb.a.fromDPToPix(this, 20), com.tencent.mm.cb.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.acV(2131691078);
        }
        for (;;)
        {
          paramPreference.acW(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.acV(2131691075);
        }
      }
      paramPreference.acV(2131691077);
      paramPreference.acW(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(129965);
    this.iNf = com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.iNf.setCanceledOnTouchOutside(false);
    this.iNf.show();
    AppMethodBeat.o(129965);
  }
  
  private void eNU()
  {
    AppMethodBeat.i(129956);
    eNY();
    ae.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.DNF.eNI()) });
    eNV();
    eNW();
    eNX();
    AppMethodBeat.o(129956);
  }
  
  private void eNV()
  {
    AppMethodBeat.i(129957);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.DNF;
    if (!com.tencent.mm.plugin.walletlock.c.g.eNM())
    {
      ae.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.cT("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = m.gu(getContext());
    localg = com.tencent.mm.plugin.walletlock.c.g.DNF;
    if (com.tencent.mm.plugin.walletlock.c.g.eNa())
    {
      if (!bool)
      {
        this.screen.cT("wallet_lock_fingerprint", false);
        this.DNP.setDesc(getString(2131765344));
        this.DNP.fDC();
        a(this.DNP, true, false);
        this.DNP.setEnabled(false);
        this.DNP.JNm = true;
        this.DNV = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.DNU)
      {
        this.screen.cT("wallet_lock_fingerprint", false);
        a(this.DNP, true, true);
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.cT("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.cT("wallet_lock_fingerprint", false);
      a(this.DNP, false, true);
    }
    AppMethodBeat.o(129957);
  }
  
  private void eNW()
  {
    AppMethodBeat.i(129958);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.DNF;
    ae.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.eNm()) });
    if ((com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() == 2) || (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() == 3))
    {
      a(this.DNQ, false, true);
      this.screen.cT("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(129958);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() == 1)
    {
      if (this.DNU)
      {
        a(this.DNQ, true, true);
        this.screen.cT("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.DNQ, false, true);
      this.screen.cT("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(129958);
  }
  
  private void eNX()
  {
    AppMethodBeat.i(129959);
    if (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() == 0)
    {
      if (this.DNU)
      {
        a(this.DNR, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.DNR, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void eNY()
  {
    AppMethodBeat.i(129960);
    if ((this.DNP != null) && (this.DNV)) {
      a(this.DNP, false, this.DNV);
    }
    if ((this.DNS != null) && (this.DNW)) {
      a(this.DNS, false, this.DNW);
    }
    if (this.DNQ != null) {
      a(this.DNQ, false, true);
    }
    if (this.DNR != null) {
      a(this.DNR, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void eNZ()
  {
    AppMethodBeat.i(129963);
    this.iNf = com.tencent.mm.ui.base.h.d(this, getString(2131765362), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129947);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(129947);
      }
    });
    this.iNf.setCanceledOnTouchOutside(false);
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
    ae.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ae.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
      AppMethodBeat.o(129964);
      return;
    }
    int i = paramIntent.getIntExtra("key_err_code", -1);
    ae.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
    if (paramInt1 == 1)
    {
      ae.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
      if (i == 0)
      {
        if (this.DNT)
        {
          q(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        ae.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        acP(getString(2131765347));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      ae.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.DNT) {
          q(paramInt2, paramIntent);
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129948);
            try
            {
              com.tencent.soter.a.a.ahx(3);
              AppMethodBeat.o(129948);
              return;
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
              AppMethodBeat.o(129948);
            }
          }
        }, "WalletLockRemoveAuthKey");
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4)
      {
        ae.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        acP(getString(2131765359));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).Wt(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.DNF;
        com.tencent.mm.plugin.walletlock.c.g.eNd();
        eNU();
        Toast.makeText(this, getString(2131765341), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.eNO();
        if (this.DNT) {
          K(-1, 0, "close wallet lock ok");
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129949);
            try
            {
              com.tencent.soter.a.a.ahx(3);
              AppMethodBeat.o(129949);
              return;
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
              AppMethodBeat.o(129949);
            }
          }
        }, "WalletLockRemoveAuthKey");
        paramIntent = new hi();
        paramIntent.eeh = 14L;
        paramIntent.etC = 2L;
        paramIntent.aLH();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        acP(getString(2131765342));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    ae.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.DNT)
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
    this.DNP = ((IconPreference)this.screen.aXe("wallet_lock_fingerprint"));
    this.DNQ = ((IconPreference)this.screen.aXe("wallet_lock_gesture"));
    this.DNR = ((IconPreference)this.screen.aXe("wallet_lock_close"));
    this.DNS = ((IconPreference)this.screen.aXe("wallet_lock_faceid"));
    this.DNP.ade(8);
    this.DNQ.ade(8);
    this.DNR.ade(8);
    this.DNS.ade(8);
    this.screen.cT("wallet_lock_faceid", true);
    this.fRv = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.DNT = true;
      this.DNU = false;
    }
    paramBundle = new hi();
    paramBundle.eeh = 13L;
    paramBundle.etC = 1L;
    paramBundle.etD = this.fRv;
    paramBundle.aLH();
    ae.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.DNT), Boolean.valueOf(this.DNU) });
    AppMethodBeat.o(129950);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.iNf != null) && (this.iNf.isShowing())) {
      this.iNf.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      eNY();
      a(paramPreference, true, true);
      if ((this.DNV) && ((!this.DNU) || (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() != 2)))
      {
        if (com.tencent.soter.core.a.li(this)) {
          break label72;
        }
        eNZ();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label72:
        if ((!this.DNU) || (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() != 2))
        {
          ae.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      eNY();
      a(paramPreference, true, true);
      if ((this.DNW) && ((!this.DNU) || (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() != 3)))
      {
        if (com.tencent.soter.core.a.aU(this, 2)) {
          break label185;
        }
        eNZ();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label185:
        if ((!this.DNU) || (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() == 3))
        {
          ae.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      eNY();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() != 1)
      {
        ae.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      eNY();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.DNF.eNI() != 0)
      {
        ae.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(this, 3);
        paramf = new hi();
        paramf.eeh = 14L;
        paramf.etC = 1L;
        paramf.aLH();
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).aK(this);
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
    eNU();
    AppMethodBeat.o(129951);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI
 * JD-Core Version:    0.7.0.1
 */