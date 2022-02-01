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
import com.tencent.mm.g.b.a.gd;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;

public class WalletLockSettingUI
  extends MMPreference
{
  private IconPreference BVQ;
  private IconPreference BVR;
  private IconPreference BVS;
  private IconPreference BVT;
  private boolean BVU = false;
  private boolean BVV = true;
  private boolean BVW = true;
  private boolean BVX = true;
  private int fwc = 0;
  private d iri;
  private int mScene = -1;
  private f screen;
  
  private void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129954);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    q(paramInt1, localIntent);
    AppMethodBeat.o(129954);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(129965);
    this.iri = com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.iri.setCanceledOnTouchOutside(false);
    this.iri.show();
    AppMethodBeat.o(129965);
  }
  
  private void a(Preference paramPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(129961);
    if ((paramPreference instanceof IconPreference))
    {
      paramPreference = (IconPreference)paramPreference;
      paramPreference.jC(com.tencent.mm.cc.a.fromDPToPix(this, 20), com.tencent.mm.cc.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.aae(2131691078);
        }
        for (;;)
        {
          paramPreference.aaf(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.aae(2131691075);
        }
      }
      paramPreference.aae(2131691077);
      paramPreference.aaf(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void ewg()
  {
    AppMethodBeat.i(129956);
    ewk();
    ac.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.BVG.evU()) });
    ewh();
    ewi();
    ewj();
    AppMethodBeat.o(129956);
  }
  
  private void ewh()
  {
    AppMethodBeat.i(129957);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
    if (!com.tencent.mm.plugin.walletlock.c.g.evY())
    {
      ac.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.cK("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = m.gm(getContext());
    localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
    if (com.tencent.mm.plugin.walletlock.c.g.evm())
    {
      if (!bool)
      {
        this.screen.cK("wallet_lock_fingerprint", false);
        this.BVQ.setDesc(getString(2131765344));
        this.BVQ.fjl();
        a(this.BVQ, true, false);
        this.BVQ.setEnabled(false);
        this.BVQ.HEH = true;
        this.BVW = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.BVV)
      {
        this.screen.cK("wallet_lock_fingerprint", false);
        a(this.BVQ, true, true);
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.cK("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.cK("wallet_lock_fingerprint", false);
      a(this.BVQ, false, true);
    }
    AppMethodBeat.o(129957);
  }
  
  private void ewi()
  {
    AppMethodBeat.i(129958);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.BVG;
    ac.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.evy()) });
    if ((com.tencent.mm.plugin.walletlock.c.g.BVG.evU() == 2) || (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() == 3))
    {
      a(this.BVR, false, true);
      this.screen.cK("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(129958);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() == 1)
    {
      if (this.BVV)
      {
        a(this.BVR, true, true);
        this.screen.cK("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.BVR, false, true);
      this.screen.cK("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(129958);
  }
  
  private void ewj()
  {
    AppMethodBeat.i(129959);
    if (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() == 0)
    {
      if (this.BVV)
      {
        a(this.BVS, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.BVS, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void ewk()
  {
    AppMethodBeat.i(129960);
    if ((this.BVQ != null) && (this.BVW)) {
      a(this.BVQ, false, this.BVW);
    }
    if ((this.BVT != null) && (this.BVX)) {
      a(this.BVT, false, this.BVX);
    }
    if (this.BVR != null) {
      a(this.BVR, false, true);
    }
    if (this.BVS != null) {
      a(this.BVS, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void ewl()
  {
    AppMethodBeat.i(129963);
    this.iri = com.tencent.mm.ui.base.h.d(this, getString(2131765362), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(129947);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(129947);
      }
    });
    this.iri.setCanceledOnTouchOutside(false);
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
    ac.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ac.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
      AppMethodBeat.o(129964);
      return;
    }
    int i = paramIntent.getIntExtra("key_err_code", -1);
    ac.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
    if (paramInt1 == 1)
    {
      ac.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
      if (i == 0)
      {
        if (this.BVU)
        {
          q(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        ac.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        Ys(getString(2131765347));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      ac.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.BVU) {
          q(paramInt2, paramIntent);
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129948);
            try
            {
              com.tencent.soter.a.a.aeo(3);
              AppMethodBeat.o(129948);
              return;
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
              AppMethodBeat.o(129948);
            }
          }
        }, "WalletLockRemoveAuthKey");
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4)
      {
        ac.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        Ys(getString(2131765359));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).TU(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.BVG;
        com.tencent.mm.plugin.walletlock.c.g.evp();
        ewg();
        Toast.makeText(this, getString(2131765341), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.ewa();
        if (this.BVU) {
          I(-1, 0, "close wallet lock ok");
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(129949);
            try
            {
              com.tencent.soter.a.a.aeo(3);
              AppMethodBeat.o(129949);
              return;
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
              AppMethodBeat.o(129949);
            }
          }
        }, "WalletLockRemoveAuthKey");
        paramIntent = new gd();
        paramIntent.dNx = 14L;
        paramIntent.ebp = 2L;
        paramIntent.aHZ();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        Ys(getString(2131765342));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    ac.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.BVU)
    {
      I(0, 4, "user cancel setting wallet lock");
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
    this.BVQ = ((IconPreference)this.screen.aPN("wallet_lock_fingerprint"));
    this.BVR = ((IconPreference)this.screen.aPN("wallet_lock_gesture"));
    this.BVS = ((IconPreference)this.screen.aPN("wallet_lock_close"));
    this.BVT = ((IconPreference)this.screen.aPN("wallet_lock_faceid"));
    this.BVQ.aam(8);
    this.BVR.aam(8);
    this.BVS.aam(8);
    this.BVT.aam(8);
    this.screen.cK("wallet_lock_faceid", true);
    this.fwc = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.BVU = true;
      this.BVV = false;
    }
    paramBundle = new gd();
    paramBundle.dNx = 13L;
    paramBundle.ebp = 1L;
    paramBundle.ebq = this.fwc;
    paramBundle.aHZ();
    ac.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.BVU), Boolean.valueOf(this.BVV) });
    AppMethodBeat.o(129950);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.iri != null) && (this.iri.isShowing())) {
      this.iri.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      ewk();
      a(paramPreference, true, true);
      if ((this.BVW) && ((!this.BVV) || (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() != 2)))
      {
        if (com.tencent.soter.core.a.kP(this)) {
          break label72;
        }
        ewl();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label72:
        if ((!this.BVV) || (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() != 2))
        {
          ac.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      ewk();
      a(paramPreference, true, true);
      if ((this.BVX) && ((!this.BVV) || (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() != 3)))
      {
        if (com.tencent.soter.core.a.aR(this, 2)) {
          break label185;
        }
        ewl();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label185:
        if ((!this.BVV) || (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() == 3))
        {
          ac.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      ewk();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() != 1)
      {
        ac.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      ewk();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.BVG.evU() != 0)
      {
        ac.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).m(this, 3);
        paramf = new gd();
        paramf.dNx = 14L;
        paramf.ebp = 1L;
        paramf.aHZ();
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
    ewg();
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