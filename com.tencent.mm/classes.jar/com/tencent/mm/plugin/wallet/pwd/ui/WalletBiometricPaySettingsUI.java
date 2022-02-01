package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.bz.a;
import com.tencent.mm.g.a.bz.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private Preference Blf;
  private Preference Blg;
  private Preference Blh;
  private Preference Bli;
  private int Blj = 0;
  private boolean Blk;
  private boolean Bll;
  private boolean Blm;
  private boolean Bln;
  private com.tencent.mm.plugin.fingerprint.d.a sjO;
  
  private void Ty(int paramInt)
  {
    AppMethodBeat.i(69611);
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private void Tz(int paramInt)
  {
    AppMethodBeat.i(69612);
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
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
    return paramPreference.HFU == 2131494878;
  }
  
  private void epZ()
  {
    AppMethodBeat.i(69607);
    if (this.Blj == 1)
    {
      a(this.Blh, false);
      a(this.Bli, false);
    }
    for (;;)
    {
      a(this.Blf, true);
      AppMethodBeat.o(69607);
      return;
      a(this.Blg, false);
    }
  }
  
  private void eqa()
  {
    AppMethodBeat.i(69608);
    if ((this.Blj == 2) || (this.Blj == 3))
    {
      a(this.Blg, true);
      a(this.Blf, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void eqb()
  {
    AppMethodBeat.i(69609);
    if (this.Blj == 1)
    {
      a(this.Blh, true);
      a(this.Bli, false);
      a(this.Blf, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void eqc()
  {
    AppMethodBeat.i(69610);
    if (this.Blj == 1)
    {
      a(this.Blh, false);
      a(this.Bli, true);
      a(this.Blf, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void eqd()
  {
    AppMethodBeat.i(69613);
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.sjO.cHf())
    {
      Ty(1);
      if (this.Blj == 1)
      {
        eqb();
        AppMethodBeat.o(69613);
        return;
      }
      eqa();
      AppMethodBeat.o(69613);
      return;
    }
    Tz(1);
    AppMethodBeat.o(69613);
  }
  
  private void eqe()
  {
    AppMethodBeat.i(69614);
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.sjO.cHn())
    {
      Ty(2);
      if (this.Blj == 1)
      {
        eqc();
        AppMethodBeat.o(69614);
        return;
      }
      eqa();
      AppMethodBeat.o(69614);
      return;
    }
    Tz(2);
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
    this.Blf = localf.aPN("biometric_pay_close");
    this.Blf.aam(8);
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.sjO.cGZ()), Boolean.valueOf(this.sjO.cHc()) });
    if ((this.Blj == 2) || (this.Blj == 3))
    {
      this.Blg = new Preference(this);
      this.Blg.setKey("key_single_open");
      this.Blg.setTitle(2131765073);
      this.Blg.HFK = false;
      localf.a(this.Blg, 0);
      this.Blg.aam(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.Blj == 1)
    {
      this.Bli = new Preference(this);
      this.Bli.setKey("key_faceid_open");
      this.Bli.setTitle(2131765074);
      localf.a(this.Bli, 0);
      this.Blh = new Preference(this);
      this.Blh.setKey("key_fingerprint_open");
      this.Blh.setTitle(2131765075);
      localf.a(this.Blh, 1);
      this.Bli.aam(8);
      this.Blh.aam(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.eqD()) && (com.tencent.mm.plugin.wallet.b.a.eqC()))
    {
      this.Blj = 1;
      if (this.Blj != 1) {
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
      this.sjO = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      ac.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.Blj) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.eqC())
      {
        this.Blj = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.eqD())
      {
        this.Blj = 3;
        break;
      }
      ac.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label143:
      if (this.Blj == 2) {
        setMMTitle(2131765637);
      } else {
        setMMTitle(2131765635);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69605);
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.Bln = a(this.Blf);
    if (this.Blj == 1)
    {
      this.Bll = a(this.Bli);
      this.Blm = a(this.Blh);
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(a(paramPreference)) });
      if (!a(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.Blk = a(this.Blg);
    }
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(2131759404);
      if (this.sjO.cHc()) {
        paramPreference = getString(2131758805);
      }
      h.a(this, false, paramPreference, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.ui.g.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final bz localbz = new bz();
          bz.a locala = localbz.dbB;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).cGZ()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.dbD = paramAnonymousInt;
            localbz.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localbz.dbC != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  ac.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localbz.dbC.retCode) });
                  if (localbz.dbC.retCode == 0)
                  {
                    com.tencent.mm.kernel.g.agQ().ghe.a(new ad(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            com.tencent.mm.sdk.b.a.GpY.a(localbz, WalletBiometricPaySettingsUI.this.getMainLooper());
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
        if (this.Blj == 2) {
          eqd();
        } else if (this.Blj == 3) {
          eqe();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        eqd();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        eqe();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    ac.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.sjO.cGZ()), Boolean.valueOf(this.sjO.cHc()) });
    if (this.Blj == 1) {
      if (this.sjO.cGZ()) {
        eqb();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.sjO.cHc())
      {
        eqc();
      }
      else
      {
        epZ();
        continue;
        if ((this.sjO.cGZ()) || (this.sjO.cHc())) {
          eqa();
        } else {
          epZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI
 * JD-Core Version:    0.7.0.1
 */