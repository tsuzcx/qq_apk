package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.ce.a;
import com.tencent.mm.g.a.ce.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@com.tencent.mm.ui.base.a(0)
public class WalletBiometricPaySettingsUI
  extends WalletPreferenceUI
{
  private Preference HIQ;
  private Preference HIR;
  private Preference HIS;
  private Preference HIT;
  private int HIU = 0;
  private boolean HIV;
  private boolean HIW;
  private boolean HIX;
  private boolean HIY;
  private com.tencent.mm.plugin.fingerprint.d.a wEQ;
  
  private static void a(Preference paramPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(69606);
    if (paramBoolean) {}
    for (int i = 2131495615;; i = 2131495616)
    {
      paramPreference.setWidgetLayoutResource(i);
      AppMethodBeat.o(69606);
      return;
    }
  }
  
  private void aeA(int paramInt)
  {
    AppMethodBeat.i(69611);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", new Object[] { Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("open_scene", 1);
    localBundle.putInt("key_open_biometric_type", paramInt);
    com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", localBundle);
    AppMethodBeat.o(69611);
  }
  
  private void aeB(int paramInt)
  {
    AppMethodBeat.i(69612);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", new Object[] { Integer.valueOf(paramInt) });
    String str = getString(2131768103);
    if (paramInt == 1) {
      str = getString(2131768105);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", getString(2131768102), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(69612);
  }
  
  private static boolean b(Preference paramPreference)
  {
    return paramPreference.OZG == 2131495615;
  }
  
  private void fOS()
  {
    AppMethodBeat.i(69607);
    if (this.HIU == 1)
    {
      a(this.HIS, false);
      a(this.HIT, false);
    }
    for (;;)
    {
      a(this.HIQ, true);
      AppMethodBeat.o(69607);
      return;
      a(this.HIR, false);
    }
  }
  
  private void fOT()
  {
    AppMethodBeat.i(69608);
    if ((this.HIU == 2) || (this.HIU == 3))
    {
      a(this.HIR, true);
      a(this.HIQ, false);
    }
    AppMethodBeat.o(69608);
  }
  
  private void fOU()
  {
    AppMethodBeat.i(69609);
    if (this.HIU == 1)
    {
      a(this.HIS, true);
      a(this.HIT, false);
      a(this.HIQ, false);
    }
    AppMethodBeat.o(69609);
  }
  
  private void fOV()
  {
    AppMethodBeat.i(69610);
    if (this.HIU == 1)
    {
      a(this.HIS, false);
      a(this.HIT, true);
      a(this.HIQ, false);
    }
    AppMethodBeat.o(69610);
  }
  
  private void fOW()
  {
    AppMethodBeat.i(69613);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
    if (this.wEQ.dJU())
    {
      aeA(1);
      if (this.HIU == 1)
      {
        fOU();
        AppMethodBeat.o(69613);
        return;
      }
      fOT();
      AppMethodBeat.o(69613);
      return;
    }
    aeB(1);
    AppMethodBeat.o(69613);
  }
  
  private void fOX()
  {
    AppMethodBeat.i(69614);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
    if (this.wEQ.dKc())
    {
      aeA(2);
      if (this.HIU == 1)
      {
        fOV();
        AppMethodBeat.o(69614);
        return;
      }
      fOT();
      AppMethodBeat.o(69614);
      return;
    }
    aeB(2);
    AppMethodBeat.o(69614);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public int getResourceId()
  {
    return 2132017301;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69603);
    f localf = getPreferenceScreen();
    this.HIQ = localf.bmg("biometric_pay_close");
    this.HIQ.alO(8);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", new Object[] { Boolean.valueOf(this.wEQ.dJO()), Boolean.valueOf(this.wEQ.dJR()) });
    if ((this.HIU == 2) || (this.HIU == 3))
    {
      this.HIR = new Preference(this);
      this.HIR.setKey("key_single_open");
      this.HIR.setTitle(2131767516);
      this.HIR.OZw = false;
      localf.a(this.HIR, 0);
      this.HIR.alO(8);
      AppMethodBeat.o(69603);
      return;
    }
    if (this.HIU == 1)
    {
      this.HIT = new Preference(this);
      this.HIT.setKey("key_faceid_open");
      this.HIT.setTitle(2131767517);
      localf.a(this.HIT, 0);
      this.HIS = new Preference(this);
      this.HIS.setKey("key_fingerprint_open");
      this.HIS.setTitle(2131767518);
      localf.a(this.HIS, 1);
      this.HIT.alO(8);
      this.HIS.alO(8);
    }
    AppMethodBeat.o(69603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69602);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.plugin.wallet.b.a.fPC()) && (com.tencent.mm.plugin.wallet.b.a.fPB()))
    {
      this.HIU = 1;
      if (this.HIU != 1) {
        break label143;
      }
      setMMTitle(2131767515);
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
      this.wEQ = ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class));
      Log.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", new Object[] { Integer.valueOf(this.HIU) });
      initView();
      AppMethodBeat.o(69602);
      return;
      if (com.tencent.mm.plugin.wallet.b.a.fPB())
      {
        this.HIU = 2;
        break;
      }
      if (com.tencent.mm.plugin.wallet.b.a.fPC())
      {
        this.HIU = 3;
        break;
      }
      Log.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
      finish();
      break;
      label143:
      if (this.HIU == 2) {
        setMMTitle(2131768090);
      } else {
        setMMTitle(2131768088);
      }
    }
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69605);
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", new Object[] { paramPreference.mKey });
    this.HIY = b(this.HIQ);
    if (this.HIU == 1)
    {
      this.HIW = b(this.HIT);
      this.HIX = b(this.HIS);
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", new Object[] { Boolean.valueOf(b(paramPreference)) });
      if (!b(paramPreference)) {
        break;
      }
      AppMethodBeat.o(69605);
      return false;
      this.HIV = b(this.HIR);
    }
    if ("biometric_pay_close".equals(paramPreference.mKey))
    {
      paramPreference = getString(2131760692);
      if (this.wEQ.dJR()) {
        paramPreference = getString(2131759126);
      }
      com.tencent.mm.ui.base.h.a(this, false, paramPreference, "", getString(2131755921), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(69601);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.ui.h.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
          final ce localce = new ce();
          ce.a locala = localce.dFo;
          if (WalletBiometricPaySettingsUI.a(WalletBiometricPaySettingsUI.this).dJO()) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 2)
          {
            locala.dFq = paramAnonymousInt;
            localce.callback = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(69600);
                if (localce.dFp != null)
                {
                  if (paramAnonymousDialogInterface != null) {
                    paramAnonymousDialogInterface.dismiss();
                  }
                  Log.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(localce.dFp.retCode) });
                  if (localce.dFp.retCode == 0)
                  {
                    g.aAg().hqi.a(new ad(null, 19), 0);
                    AppMethodBeat.o(69600);
                    return;
                  }
                  WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                  WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                }
                AppMethodBeat.o(69600);
              }
            };
            EventCenter.instance.asyncPublish(localce, WalletBiometricPaySettingsUI.this.getMainLooper());
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
        if (this.HIU == 2) {
          fOW();
        } else if (this.HIU == 3) {
          fOX();
        }
      }
      else if ("key_fingerprint_open".equals(paramPreference.mKey)) {
        fOW();
      } else if ("key_faceid_open".equals(paramPreference.mKey)) {
        fOX();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69604);
    super.onResume();
    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", new Object[] { Boolean.valueOf(this.wEQ.dJO()), Boolean.valueOf(this.wEQ.dJR()) });
    if (this.HIU == 1) {
      if (this.wEQ.dJO()) {
        fOU();
      }
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(69604);
      return;
      if (this.wEQ.dJR())
      {
        fOV();
      }
      else
      {
        fOS();
        continue;
        if ((this.wEQ.dJO()) || (this.wEQ.dJR())) {
          fOT();
        } else {
          fOS();
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