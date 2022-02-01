package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.bz.a;
import com.tencent.mm.g.a.bz.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private com.tencent.mm.plugin.fingerprint.d.a rbu;
  private Preference zSL;
  private Preference zSM;
  private Preference zSN;
  private Preference zSO;
  private int zSP = 0;
  private boolean zSQ;
  private boolean zSR;
  private boolean zSS;
  private boolean zST;
  
  private void Rp(int paramInt)
  {
    AppMethodBeat.i(69611);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private void Rq(int paramInt)
  {
    AppMethodBeat.i(69612);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    String str = getString(2131765650);
    if (paramInt == 1) {
      str = getString(2131765652);
    }
    h.a(this, str, "", getString(2131765649), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(69612);
  }
  
  private static void a(Preference paramPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(69606);
    if (paramBoolean) {}
    for (int i = 2131494878;; i = 2131494879)
    {
      paramPreference.setWidgetLayoutResource(i);
      AppMethodBeat.o(69606);
      return;
    }
  }
  
  private static boolean a(Preference paramPreference)
  {
    return paramPreference.Gge == 2131494878;
  }
  
  private void eaD()
  {
    AppMethodBeat.i(69607);
    if (this.zSP == 1)
    {
      a(this.zSN, false);
      a(this.zSO, false);
    }
    for (;;)
    {
      a(this.zSL, true);
      AppMethodBeat.o(69607);
      return;
      a(this.zSM, false);
    }
  }
  
  private void eaE()
  {
    AppMethodBeat.i(69608);
    if ((this.zSP == 2) || (this.zSP == 3))
    {
      a(this.zSM, true);
      a(this.zSL, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void eaF()
  {
    AppMethodBeat.i(69609);
    if (this.zSP == 1)
    {
      a(this.zSN, true);
      a(this.zSO, false);
      a(this.zSL, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void eaG()
  {
    AppMethodBeat.i(69610);
    if (this.zSP == 1)
    {
      a(this.zSN, false);
      a(this.zSO, true);
      a(this.zSL, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void eaH()
  {
    AppMethodBeat.i(69613);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.rbu.ctT())
    {
      Rp(1);
      if (this.zSP == 1)
      {
        eaF();
        AppMethodBeat.o(69613);
        return;
      }
      eaE();
      AppMethodBeat.o(69613);
      return;
    }
    Rq(1);
    AppMethodBeat.o(69613);
  }
  
  private void eaI()
  {
    AppMethodBeat.i(69614);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.rbu.cub())
    {
      Rp(2);
      if (this.zSP == 1)
      {
        eaG();
        AppMethodBeat.o(69614);
        return;
      }
      eaE();
      AppMethodBeat.o(69614);
      return;
    }
    Rq(2);
    AppMethodBeat.o(69614);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public int getResourceId()
  {
    return 2131951756;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69603);
    f localf = getPreferenceScreen();
    this.zSL = localf.aKk("biometric_pay_close");
    this.zSL.Yb(8);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.rbu.ctN()), Boolean.valueOf(this.rbu.ctQ()) });
    if ((this.zSP == 2) || (this.zSP == 3))
    {
      this.zSM = new Preference(this);
      this.zSM.setKey("key_single_open");
      this.zSM.setTitle(2131765073);
      this.zSM.GfV = false;
      localf.a(this.zSM, 0);
      this.zSM.Yb(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.zSP == 1)
    {
      this.zSO = new Preference(this);
      this.zSO.setKey("key_faceid_open");
      this.zSO.setTitle(2131765074);
      localf.a(this.zSO, 0);
      this.zSN = new Preference(this);
      this.zSN.setKey("key_fingerprint_open");
      this.zSN.setTitle(2131765075);
      localf.a(this.zSN, 1);
      this.zSO.Yb(8);
      this.zSN.Yb(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.ebh()) && (com.tencent.mm.plugin.wallet.b.a.ebg()))
    {
      this.zSP = 1;
      if (this.zSP != 1) {
        break label143;
      }
      setMMTitle(2131765072);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69599);
          WalletBiometricPaySettingsUI.this.finish();
          AppMethodBeat.o(69599);
          return false;
        }
      });
      this.rbu = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.zSP) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.ebg())
      {
        this.zSP = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.ebh())
      {
        this.zSP = 3;
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label143:
      if (this.zSP == 2) {
        setMMTitle(2131765637);
      } else {
        setMMTitle(2131765635);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69605);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.zST = a(this.zSL);
    if (this.zSP == 1)
    {
      this.zSR = a(this.zSO);
      this.zSS = a(this.zSN);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(a(paramPreference)) });
      if (!a(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.zSQ = a(this.zSM);
    }
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(2131759404);
      if (this.rbu.ctQ()) {
        paramPreference = getString(2131758805);
      }
      h.a(this, false, paramPreference, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.ui.g.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final bz localbz = new bz();
          bz.a locala = localbz.def;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).ctN()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.deh = paramAnonymousInt;
            localbz.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localbz.deg != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localbz.deg.retCode) });
                  if (localbz.deg.retCode == 0)
                  {
                    com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.wallet_core.c.ad(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            com.tencent.mm.sdk.b.a.ESL.a(localbz, WalletBiometricPaySettingsUI.this.getMainLooper());
            WalletBiometricPaySettingsUI.d(WalletBiometricPaySettingsUI.this);
            paramf.notifyDataSetChanged();
            AppMethodBeat.o(69601);
            return;
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    for (;;)
    {
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(69605);
      return false;
      if ("key_single_open".equals(paramPreference.mKey))
      {
        if (this.zSP == 2) {
          eaH();
        } else if (this.zSP == 3) {
          eaI();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        eaH();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        eaI();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.rbu.ctN()), Boolean.valueOf(this.rbu.ctQ()) });
    if (this.zSP == 1) {
      if (this.rbu.ctN()) {
        eaF();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.rbu.ctQ())
      {
        eaG();
      }
      else
      {
        eaD();
        continue;
        if ((this.rbu.ctN()) || (this.rbu.ctQ())) {
          eaE();
        } else {
          eaD();
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI
 * JD-Core Version:    0.7.0.1
 */