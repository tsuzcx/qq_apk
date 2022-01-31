package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private l mFC;
  private boolean tYA;
  private boolean tYB;
  private boolean tYC;
  private Preference tYu;
  private Preference tYv;
  private Preference tYw;
  private Preference tYx;
  private int tYy = 0;
  private boolean tYz;
  
  private void Ip(int paramInt)
  {
    AppMethodBeat.i(46232);
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(46232);
  }
  
  private void Iq(int paramInt)
  {
    AppMethodBeat.i(46233);
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    String str = getString(2131305436);
    if (paramInt == 1) {
      str = getString(2131305438);
    }
    h.a(this, str, "", getString(2131305435), new WalletBiometricPaySettingsUI.4(this));
    AppMethodBeat.o(46233);
  }
  
  private static void a(Preference paramPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(46227);
    if (paramBoolean) {}
    for (int i = 2130970249;; i = 2130970250)
    {
      paramPreference.setWidgetLayoutResource(i);
      AppMethodBeat.o(46227);
      return;
    }
  }
  
  private static boolean a(Preference paramPreference)
  {
    return paramPreference.zsq == 2130970249;
  }
  
  private void cSr()
  {
    AppMethodBeat.i(46228);
    if (this.tYy == 1)
    {
      a(this.tYw, false);
      a(this.tYx, false);
    }
    for (;;)
    {
      a(this.tYu, true);
      AppMethodBeat.o(46228);
      return;
      a(this.tYv, false);
    }
  }
  
  private void cSs()
  {
    AppMethodBeat.i(46229);
    if ((this.tYy == 2) || (this.tYy == 3))
    {
      a(this.tYv, true);
      a(this.tYu, false);
    }
    AppMethodBeat.o(46229);
  }
  
  private void cSt()
  {
    AppMethodBeat.i(46230);
    if (this.tYy == 1)
    {
      a(this.tYw, true);
      a(this.tYx, false);
      a(this.tYu, false);
    }
    AppMethodBeat.o(46230);
  }
  
  private void cSu()
  {
    AppMethodBeat.i(46231);
    if (this.tYy == 1)
    {
      a(this.tYw, false);
      a(this.tYx, true);
      a(this.tYu, false);
    }
    AppMethodBeat.o(46231);
  }
  
  private void cSv()
  {
    AppMethodBeat.i(46234);
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.mFC.bzb())
    {
      Ip(1);
      if (this.tYy == 1)
      {
        cSt();
        AppMethodBeat.o(46234);
        return;
      }
      cSs();
      AppMethodBeat.o(46234);
      return;
    }
    Iq(1);
    AppMethodBeat.o(46234);
  }
  
  private void cSw()
  {
    AppMethodBeat.i(46235);
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.mFC.bzo())
    {
      Ip(2);
      if (this.tYy == 1)
      {
        cSu();
        AppMethodBeat.o(46235);
        return;
      }
      cSs();
      AppMethodBeat.o(46235);
      return;
    }
    Iq(2);
    AppMethodBeat.o(46235);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public int getResourceId()
  {
    return 2131165311;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46224);
    f localf = getPreferenceScreen();
    this.tYu = localf.atx("biometric_pay_close");
    this.tYu.OW(8);
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.mFC.byS()), Boolean.valueOf(this.mFC.byV()) });
    if ((this.tYy == 2) || (this.tYy == 3))
    {
      this.tYv = new Preference(this);
      this.tYv.setKey("key_single_open");
      this.tYv.setTitle(2131304886);
      this.tYv.zsk = false;
      localf.a(this.tYv, 0);
      this.tYv.OW(8);
      AppMethodBeat.o(46224);
      return;
    }
    if (this.tYy == 1)
    {
      this.tYx = new Preference(this);
      this.tYx.setKey("key_faceid_open");
      this.tYx.setTitle(2131304887);
      localf.a(this.tYx, 0);
      this.tYw = new Preference(this);
      this.tYw.setKey("key_fingerprint_open");
      this.tYw.setTitle(2131304888);
      localf.a(this.tYw, 1);
      this.tYx.OW(8);
      this.tYw.OW(8);
    }
    AppMethodBeat.o(46224);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46223);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.cSU()) && (com.tencent.mm.plugin.wallet.b.a.cST()))
    {
      this.tYy = 1;
      if (this.tYy != 1) {
        break label143;
      }
      setMMTitle(2131304885);
    }
    for (;;)
    {
      setBackBtn(new WalletBiometricPaySettingsUI.1(this));
      this.mFC = ((l)g.E(l.class));
      ab.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.tYy) });
      initView();
      AppMethodBeat.o(46223);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.cST())
      {
        this.tYy = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.cSU())
      {
        this.tYy = 3;
        break;
      }
      ab.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label143:
      if (this.tYy == 2) {
        setMMTitle(2131305423);
      } else {
        setMMTitle(2131305421);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(46226);
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.tYC = a(this.tYu);
    if (this.tYy == 1)
    {
      this.tYA = a(this.tYx);
      this.tYB = a(this.tYw);
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(a(paramPreference)) });
      if (!a(paramPreference)) {
        break;
      }
      AppMethodBeat.o(46226);
      return false;
      this.tYz = a(this.tYv);
    }
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(2131299963);
      if (this.mFC.byV()) {
        paramPreference = getString(2131299646);
      }
      h.a(this, false, paramPreference, "", getString(2131297018), getString(2131296888), new WalletBiometricPaySettingsUI.2(this, paramf), new WalletBiometricPaySettingsUI.3(this));
    }
    for (;;)
    {
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(46226);
      return false;
      if ("key_single_open".equals(paramPreference.mKey))
      {
        if (this.tYy == 2) {
          cSv();
        } else if (this.tYy == 3) {
          cSw();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        cSv();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        cSw();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46225);
    super.onResume();
    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.mFC.byS()), Boolean.valueOf(this.mFC.byV()) });
    if (this.tYy == 1) {
      if (this.mFC.byS()) {
        cSt();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(46225);
      return;
      if (this.mFC.byV())
      {
        cSu();
      }
      else
      {
        cSr();
        continue;
        if ((this.mFC.byS()) || (this.mFC.byV())) {
          cSs();
        } else {
          cSr();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI
 * JD-Core Version:    0.7.0.1
 */