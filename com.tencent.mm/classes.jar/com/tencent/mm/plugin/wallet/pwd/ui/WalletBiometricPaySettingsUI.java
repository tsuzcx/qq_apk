package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ci;
import com.tencent.mm.f.a.ci.a;
import com.tencent.mm.f.a.ci.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private com.tencent.mm.plugin.fingerprint.d.a BxN;
  private Preference OAI;
  private Preference OAJ;
  private Preference OAK;
  private Preference OAL;
  private ResultReceiver OAM;
  private boolean OAN = false;
  private int OAO = 0;
  private boolean OAP;
  private boolean OAQ;
  private boolean OAR;
  private boolean OAS;
  
  private static void a(Preference paramPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(69606);
    if (paramBoolean) {}
    for (int i = a.g.mm_preference_radio_checked;; i = a.g.mm_preference_radio_unchecked)
    {
      paramPreference.auN(i);
      AppMethodBeat.o(69606);
      return;
    }
  }
  
  private static boolean a(Preference paramPreference)
  {
    return paramPreference.WsP == a.g.mm_preference_radio_checked;
  }
  
  private void amn(int paramInt)
  {
    AppMethodBeat.i(69611);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private void gHA()
  {
    AppMethodBeat.i(69609);
    if (this.OAO == 1)
    {
      a(this.OAK, true);
      a(this.OAL, false);
      a(this.OAI, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void gHB()
  {
    AppMethodBeat.i(69610);
    if (this.OAO == 1)
    {
      a(this.OAK, false);
      a(this.OAL, true);
      a(this.OAI, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void gHC()
  {
    AppMethodBeat.i(69613);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.BxN.eot())
    {
      amn(1);
      if (this.OAO == 1)
      {
        gHA();
        AppMethodBeat.o(69613);
        return;
      }
      gHz();
      AppMethodBeat.o(69613);
      return;
    }
    showEnrollBiometricGuideAlert(1);
    AppMethodBeat.o(69613);
  }
  
  private void gHD()
  {
    AppMethodBeat.i(69614);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.BxN.eoB())
    {
      amn(2);
      if (this.OAO == 1)
      {
        gHB();
        AppMethodBeat.o(69614);
        return;
      }
      gHz();
      AppMethodBeat.o(69614);
      return;
    }
    showEnrollBiometricGuideAlert(2);
    AppMethodBeat.o(69614);
  }
  
  private void gHy()
  {
    AppMethodBeat.i(69607);
    if (this.OAO == 1)
    {
      a(this.OAK, false);
      a(this.OAL, false);
    }
    for (;;)
    {
      a(this.OAI, true);
      AppMethodBeat.o(69607);
      return;
      a(this.OAJ, false);
    }
  }
  
  private void gHz()
  {
    AppMethodBeat.i(69608);
    if ((this.OAO == 2) || (this.OAO == 3))
    {
      a(this.OAJ, true);
      a(this.OAI, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void showEnrollBiometricGuideAlert(int paramInt)
  {
    AppMethodBeat.i(69612);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    String str = getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_text);
    if (paramInt == 1) {
      str = getString(a.i.wallet_password_setting_ui_set_sys_fp_guide_text);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(69612);
  }
  
  public final boolean f(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public int getResourceId()
  {
    return a.m.wallet_biometric_pay_settings_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69603);
    f localf = getPreferenceScreen();
    this.OAI = localf.byG("biometric_pay_close");
    this.OAI.auO(8);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.BxN.eon()), Boolean.valueOf(this.BxN.eoq()) });
    if ((this.OAO == 2) || (this.OAO == 3))
    {
      this.OAJ = new Preference(this);
      this.OAJ.setKey("key_single_open");
      this.OAJ.setTitle(a.i.wallet_biometric_pay_open);
      this.OAJ.WsF = false;
      localf.a(this.OAJ, 0);
      this.OAJ.auO(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.OAO == 1)
    {
      this.OAL = new Preference(this);
      this.OAL.setKey("key_faceid_open");
      this.OAL.setTitle(a.i.wallet_biometric_pay_open_faceid);
      localf.a(this.OAL, 0);
      this.OAK = new Preference(this);
      this.OAK.setKey("key_fingerprint_open");
      this.OAK.setTitle(a.i.wallet_biometric_pay_open_fingerprint);
      localf.a(this.OAK, 1);
      this.OAL.auO(8);
      this.OAK.auO(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.gIf()) && (com.tencent.mm.plugin.wallet.b.a.gIe()))
    {
      this.OAO = 1;
      if (this.OAO != 1) {
        break label160;
      }
      setMMTitle(a.i.wallet_biometric_pay_multi_title);
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
      this.OAM = ((ResultReceiver)getIntent().getParcelableExtra("key_should_update_result_receiver"));
      this.BxN = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class));
      Log.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.OAO) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.gIe())
      {
        this.OAO = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.gIf())
      {
        this.OAO = 3;
        break;
      }
      Log.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label160:
      if (this.OAO == 2) {
        setMMTitle(a.i.wallet_password_setting_ui_fingerprint_title);
      } else {
        setMMTitle(a.i.wallet_password_setting_ui_faceid_title);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(275137);
    super.onPause();
    if ((this.OAN) && (this.OAM != null)) {
      this.OAM.send(0, null);
    }
    AppMethodBeat.o(275137);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69605);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.OAS = a(this.OAI);
    if (this.OAO == 1)
    {
      this.OAQ = a(this.OAL);
      this.OAR = a(this.OAK);
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(a(paramPreference)) });
      if (!a(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.OAP = a(this.OAJ);
    }
    this.OAN = true;
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(a.i.fingerprint_close);
      if (this.BxN.eoq()) {
        paramPreference = getString(a.i.faceid_close);
      }
      com.tencent.mm.ui.base.h.a(this, false, paramPreference, "", getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = i.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final ci localci = new ci();
          ci.a locala = localci.fxW;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).eon()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.fxY = paramAnonymousInt;
            localci.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localci.fxX != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  Log.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localci.fxX.retCode) });
                  if (localci.fxX.retCode == 0)
                  {
                    com.tencent.mm.kernel.h.aHF().kcd.a(new ae(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            EventCenter.instance.asyncPublish(localci, WalletBiometricPaySettingsUI.this.getMainLooper());
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
        if (this.OAO == 2) {
          gHC();
        } else if (this.OAO == 3) {
          gHD();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        gHC();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        gHD();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.BxN.eon()), Boolean.valueOf(this.BxN.eoq()) });
    if (this.OAO == 1) {
      if (this.BxN.eon()) {
        gHA();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.BxN.eoq())
      {
        gHB();
      }
      else
      {
        gHy();
        continue;
        if ((this.BxN.eon()) || (this.BxN.eoq())) {
          gHz();
        } else {
          gHy();
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