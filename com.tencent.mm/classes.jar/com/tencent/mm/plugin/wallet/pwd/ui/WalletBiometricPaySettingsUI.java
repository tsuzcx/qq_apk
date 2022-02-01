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
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.a;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private Preference Ddc;
  private Preference Ddd;
  private Preference Dde;
  private Preference Ddf;
  private int Ddg = 0;
  private boolean Ddh;
  private boolean Ddi;
  private boolean Ddj;
  private boolean Ddk;
  private com.tencent.mm.plugin.fingerprint.d.a trj;
  
  private void VY(int paramInt)
  {
    AppMethodBeat.i(69611);
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private void VZ(int paramInt)
  {
    AppMethodBeat.i(69612);
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    String str = getString(2131765650);
    if (paramInt == 1) {
      str = getString(2131765652);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", getString(2131765649), new DialogInterface.OnClickListener()
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
    return paramPreference.JOA == 2131494878;
  }
  
  private void eHG()
  {
    AppMethodBeat.i(69607);
    if (this.Ddg == 1)
    {
      a(this.Dde, false);
      a(this.Ddf, false);
    }
    for (;;)
    {
      a(this.Ddc, true);
      AppMethodBeat.o(69607);
      return;
      a(this.Ddd, false);
    }
  }
  
  private void eHH()
  {
    AppMethodBeat.i(69608);
    if ((this.Ddg == 2) || (this.Ddg == 3))
    {
      a(this.Ddd, true);
      a(this.Ddc, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void eHI()
  {
    AppMethodBeat.i(69609);
    if (this.Ddg == 1)
    {
      a(this.Dde, true);
      a(this.Ddf, false);
      a(this.Ddc, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void eHJ()
  {
    AppMethodBeat.i(69610);
    if (this.Ddg == 1)
    {
      a(this.Dde, false);
      a(this.Ddf, true);
      a(this.Ddc, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void eHK()
  {
    AppMethodBeat.i(69613);
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.trj.cRZ())
    {
      VY(1);
      if (this.Ddg == 1)
      {
        eHI();
        AppMethodBeat.o(69613);
        return;
      }
      eHH();
      AppMethodBeat.o(69613);
      return;
    }
    VZ(1);
    AppMethodBeat.o(69613);
  }
  
  private void eHL()
  {
    AppMethodBeat.i(69614);
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.trj.cSh())
    {
      VY(2);
      if (this.Ddg == 1)
      {
        eHJ();
        AppMethodBeat.o(69614);
        return;
      }
      eHH();
      AppMethodBeat.o(69614);
      return;
    }
    VZ(2);
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
    this.Ddc = localf.aXe("biometric_pay_close");
    this.Ddc.ade(8);
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.trj.cRT()), Boolean.valueOf(this.trj.cRW()) });
    if ((this.Ddg == 2) || (this.Ddg == 3))
    {
      this.Ddd = new Preference(this);
      this.Ddd.setKey("key_single_open");
      this.Ddd.setTitle(2131765073);
      this.Ddd.JOq = false;
      localf.a(this.Ddd, 0);
      this.Ddd.ade(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.Ddg == 1)
    {
      this.Ddf = new Preference(this);
      this.Ddf.setKey("key_faceid_open");
      this.Ddf.setTitle(2131765074);
      localf.a(this.Ddf, 0);
      this.Dde = new Preference(this);
      this.Dde.setKey("key_fingerprint_open");
      this.Dde.setTitle(2131765075);
      localf.a(this.Dde, 1);
      this.Ddf.ade(8);
      this.Dde.ade(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.eIk()) && (com.tencent.mm.plugin.wallet.b.a.eIj()))
    {
      this.Ddg = 1;
      if (this.Ddg != 1) {
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
      this.trj = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      ae.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.Ddg) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.eIj())
      {
        this.Ddg = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.eIk())
      {
        this.Ddg = 3;
        break;
      }
      ae.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label143:
      if (this.Ddg == 2) {
        setMMTitle(2131765637);
      } else {
        setMMTitle(2131765635);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69605);
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.Ddk = a(this.Ddc);
    if (this.Ddg == 1)
    {
      this.Ddi = a(this.Ddf);
      this.Ddj = a(this.Dde);
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(a(paramPreference)) });
      if (!a(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.Ddh = a(this.Ddd);
    }
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(2131759404);
      if (this.trj.cRW()) {
        paramPreference = getString(2131758805);
      }
      com.tencent.mm.ui.base.h.a(this, false, paramPreference, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.ui.h.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final cc localcc = new cc();
          cc.a locala = localcc.dnZ;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).cRT()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.dob = paramAnonymousInt;
            localcc.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localcc.doa != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  ae.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localcc.doa.retCode) });
                  if (localcc.doa.retCode == 0)
                  {
                    g.ajQ().gDv.a(new ad(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            com.tencent.mm.sdk.b.a.IvT.a(localcc, WalletBiometricPaySettingsUI.this.getMainLooper());
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
        if (this.Ddg == 2) {
          eHK();
        } else if (this.Ddg == 3) {
          eHL();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        eHK();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        eHL();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    ae.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.trj.cRT()), Boolean.valueOf(this.trj.cRW()) });
    if (this.Ddg == 1) {
      if (this.trj.cRT()) {
        eHI();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.trj.cRW())
      {
        eHJ();
      }
      else
      {
        eHG();
        continue;
        if ((this.trj.cRT()) || (this.trj.cRW())) {
          eHH();
        } else {
          eHG();
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