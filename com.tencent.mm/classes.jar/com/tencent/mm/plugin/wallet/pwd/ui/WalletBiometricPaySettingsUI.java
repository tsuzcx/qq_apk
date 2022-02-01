package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.cr;
import com.tencent.mm.autogen.a.cr.a;
import com.tencent.mm.autogen.a.cr.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.l;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private com.tencent.mm.plugin.fingerprint.c.a Hfq;
  private Preference VpV;
  private Preference VpW;
  private Preference VpX;
  private Preference VpY;
  private ResultReceiver VpZ;
  private boolean Vqa = false;
  private int Vqb = 0;
  private boolean Vqc;
  private boolean Vqd;
  private boolean Vqe;
  private boolean Vqf;
  
  private static void a(Preference paramPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(69606);
    if (paramBoolean) {}
    for (int i = a.g.mm_preference_radio_checked;; i = a.g.mm_preference_radio_unchecked)
    {
      paramPreference.aBp(i);
      AppMethodBeat.o(69606);
      return;
    }
  }
  
  private void arX(int paramInt)
  {
    AppMethodBeat.i(69611);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private static boolean b(Preference paramPreference)
  {
    return paramPreference.aeaf == a.g.mm_preference_radio_checked;
  }
  
  private void igD()
  {
    AppMethodBeat.i(69607);
    if (this.Vqb == 1)
    {
      a(this.VpX, false);
      a(this.VpY, false);
    }
    for (;;)
    {
      a(this.VpV, true);
      AppMethodBeat.o(69607);
      return;
      a(this.VpW, false);
    }
  }
  
  private void igE()
  {
    AppMethodBeat.i(69608);
    if ((this.Vqb == 2) || (this.Vqb == 3))
    {
      a(this.VpW, true);
      a(this.VpV, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void igF()
  {
    AppMethodBeat.i(69609);
    if (this.Vqb == 1)
    {
      a(this.VpX, true);
      a(this.VpY, false);
      a(this.VpV, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void igG()
  {
    AppMethodBeat.i(69610);
    if (this.Vqb == 1)
    {
      a(this.VpX, false);
      a(this.VpY, true);
      a(this.VpV, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void igH()
  {
    AppMethodBeat.i(69613);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.Hfq.ftw())
    {
      arX(1);
      if (this.Vqb == 1)
      {
        igF();
        AppMethodBeat.o(69613);
        return;
      }
      igE();
      AppMethodBeat.o(69613);
      return;
    }
    showEnrollBiometricGuideAlert(1);
    AppMethodBeat.o(69613);
  }
  
  private void igI()
  {
    AppMethodBeat.i(69614);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.Hfq.ftE())
    {
      arX(2);
      if (this.Vqb == 1)
      {
        igG();
        AppMethodBeat.o(69614);
        return;
      }
      igE();
      AppMethodBeat.o(69614);
      return;
    }
    showEnrollBiometricGuideAlert(2);
    AppMethodBeat.o(69614);
  }
  
  private void showEnrollBiometricGuideAlert(int paramInt)
  {
    AppMethodBeat.i(69612);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    String str = getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_text);
    if (paramInt == 1) {
      str = getString(a.i.wallet_password_setting_ui_set_sys_fp_guide_text);
    }
    k.a(this, str, "", getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(69612);
  }
  
  public final boolean d(int paramInt1, int paramInt2, String paramString, p paramp)
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
    this.VpV = localf.bAi("biometric_pay_close");
    this.VpV.aBq(8);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.Hfq.ftq()), Boolean.valueOf(this.Hfq.ftt()) });
    if ((this.Vqb == 2) || (this.Vqb == 3))
    {
      this.VpW = new Preference(this);
      this.VpW.setKey("key_single_open");
      this.VpW.setTitle(a.i.wallet_biometric_pay_open);
      this.VpW.adZV = false;
      localf.a(this.VpW, 0);
      this.VpW.aBq(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.Vqb == 1)
    {
      this.VpY = new Preference(this);
      this.VpY.setKey("key_faceid_open");
      this.VpY.setTitle(a.i.wallet_biometric_pay_open_faceid);
      localf.a(this.VpY, 0);
      this.VpX = new Preference(this);
      this.VpX.setKey("key_fingerprint_open");
      this.VpX.setTitle(a.i.wallet_biometric_pay_open_fingerprint);
      localf.a(this.VpX, 1);
      this.VpY.aBq(8);
      this.VpX.aBq(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.ihj()) && (com.tencent.mm.plugin.wallet.b.a.ihi()))
    {
      this.Vqb = 1;
      if (this.Vqb != 1) {
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
      this.VpZ = ((ResultReceiver)getIntent().getParcelableExtra("key_should_update_result_receiver"));
      this.Hfq = ((com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class));
      Log.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.Vqb) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.ihi())
      {
        this.Vqb = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.ihj())
      {
        this.Vqb = 3;
        break;
      }
      Log.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label160:
      if (this.Vqb == 2) {
        setMMTitle(a.i.wallet_password_setting_ui_fingerprint_title);
      } else {
        setMMTitle(a.i.wallet_password_setting_ui_faceid_title);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(315634);
    super.onPause();
    if ((this.Vqa) && (this.VpZ != null)) {
      this.VpZ.send(0, null);
    }
    AppMethodBeat.o(315634);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69605);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.Vqf = b(this.VpV);
    if (this.Vqb == 1)
    {
      this.Vqd = b(this.VpY);
      this.Vqe = b(this.VpX);
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(b(paramPreference)) });
      if (!b(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.Vqc = b(this.VpW);
    }
    this.Vqa = true;
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(a.i.fingerprint_close);
      if (this.Hfq.ftt()) {
        paramPreference = getString(a.i.faceid_close);
      }
      k.a(this, false, paramPreference, "", getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = l.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final cr localcr = new cr();
          cr.a locala = localcr.hCB;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).ftq()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.hCD = paramAnonymousInt;
            localcr.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localcr.hCC != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  Log.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localcr.hCC.retCode) });
                  if (localcr.hCC.retCode == 0)
                  {
                    h.baD().mCm.a(new ae(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            localcr.asyncPublish(WalletBiometricPaySettingsUI.this.getMainLooper());
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
        if (this.Vqb == 2) {
          igH();
        } else if (this.Vqb == 3) {
          igI();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        igH();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        igI();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.Hfq.ftq()), Boolean.valueOf(this.Hfq.ftt()) });
    if (this.Vqb == 1) {
      if (this.Hfq.ftq()) {
        igF();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.Hfq.ftt())
      {
        igG();
      }
      else
      {
        igD();
        continue;
        if ((this.Hfq.ftq()) || (this.Hfq.ftt())) {
          igE();
        } else {
          igD();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI
 * JD-Core Version:    0.7.0.1
 */