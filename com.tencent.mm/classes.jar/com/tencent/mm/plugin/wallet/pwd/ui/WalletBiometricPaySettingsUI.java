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
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.a;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private boolean CLA;
  private boolean CLB;
  private Preference CLt;
  private Preference CLu;
  private Preference CLv;
  private Preference CLw;
  private int CLx = 0;
  private boolean CLy;
  private boolean CLz;
  private com.tencent.mm.plugin.fingerprint.d.a tgq;
  
  private void Vq(int paramInt)
  {
    AppMethodBeat.i(69611);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private void Vr(int paramInt)
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
    return paramPreference.JtL == 2131494878;
  }
  
  private void eDZ()
  {
    AppMethodBeat.i(69607);
    if (this.CLx == 1)
    {
      a(this.CLv, false);
      a(this.CLw, false);
    }
    for (;;)
    {
      a(this.CLt, true);
      AppMethodBeat.o(69607);
      return;
      a(this.CLu, false);
    }
  }
  
  private void eEa()
  {
    AppMethodBeat.i(69608);
    if ((this.CLx == 2) || (this.CLx == 3))
    {
      a(this.CLu, true);
      a(this.CLt, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void eEb()
  {
    AppMethodBeat.i(69609);
    if (this.CLx == 1)
    {
      a(this.CLv, true);
      a(this.CLw, false);
      a(this.CLt, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void eEc()
  {
    AppMethodBeat.i(69610);
    if (this.CLx == 1)
    {
      a(this.CLv, false);
      a(this.CLw, true);
      a(this.CLt, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void eEd()
  {
    AppMethodBeat.i(69613);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.tgq.cPu())
    {
      Vq(1);
      if (this.CLx == 1)
      {
        eEb();
        AppMethodBeat.o(69613);
        return;
      }
      eEa();
      AppMethodBeat.o(69613);
      return;
    }
    Vr(1);
    AppMethodBeat.o(69613);
  }
  
  private void eEe()
  {
    AppMethodBeat.i(69614);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.tgq.cPC())
    {
      Vq(2);
      if (this.CLx == 1)
      {
        eEc();
        AppMethodBeat.o(69614);
        return;
      }
      eEa();
      AppMethodBeat.o(69614);
      return;
    }
    Vr(2);
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
    this.CLt = localf.aVD("biometric_pay_close");
    this.CLt.acw(8);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.tgq.cPo()), Boolean.valueOf(this.tgq.cPr()) });
    if ((this.CLx == 2) || (this.CLx == 3))
    {
      this.CLu = new Preference(this);
      this.CLu.setKey("key_single_open");
      this.CLu.setTitle(2131765073);
      this.CLu.JtB = false;
      localf.a(this.CLu, 0);
      this.CLu.acw(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.CLx == 1)
    {
      this.CLw = new Preference(this);
      this.CLw.setKey("key_faceid_open");
      this.CLw.setTitle(2131765074);
      localf.a(this.CLw, 0);
      this.CLv = new Preference(this);
      this.CLv.setKey("key_fingerprint_open");
      this.CLv.setTitle(2131765075);
      localf.a(this.CLv, 1);
      this.CLw.acw(8);
      this.CLv.acw(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.eED()) && (com.tencent.mm.plugin.wallet.b.a.eEC()))
    {
      this.CLx = 1;
      if (this.CLx != 1) {
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
      this.tgq = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.CLx) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.eEC())
      {
        this.CLx = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.eED())
      {
        this.CLx = 3;
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label143:
      if (this.CLx == 2) {
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
    this.CLB = a(this.CLt);
    if (this.CLx == 1)
    {
      this.CLz = a(this.CLw);
      this.CLA = a(this.CLv);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(a(paramPreference)) });
      if (!a(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.CLy = a(this.CLu);
    }
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(2131759404);
      if (this.tgq.cPr()) {
        paramPreference = getString(2131758805);
      }
      h.a(this, false, paramPreference, "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.ui.g.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final cc localcc = new cc();
          cc.a locala = localcc.dmX;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).cPo()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.dmZ = paramAnonymousInt;
            localcc.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localcc.dmY != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localcc.dmY.retCode) });
                  if (localcc.dmY.retCode == 0)
                  {
                    com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.wallet_core.c.ad(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            com.tencent.mm.sdk.b.a.IbL.a(localcc, WalletBiometricPaySettingsUI.this.getMainLooper());
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
        if (this.CLx == 2) {
          eEd();
        } else if (this.CLx == 3) {
          eEe();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        eEd();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        eEe();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.tgq.cPo()), Boolean.valueOf(this.tgq.cPr()) });
    if (this.CLx == 1) {
      if (this.tgq.cPo()) {
        eEb();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.tgq.cPr())
      {
        eEc();
      }
      else
      {
        eDZ();
        continue;
        if ((this.tgq.cPo()) || (this.tgq.cPr())) {
          eEa();
        } else {
          eDZ();
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