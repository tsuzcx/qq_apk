package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsVoicePrintUI
  extends MMPreference
  implements g
{
  private VoiceHeaderPreference AwV;
  private ProgressDialog fts = null;
  private View khe;
  private boolean qCu = false;
  private f screen;
  
  private void egK()
  {
    AppMethodBeat.i(29837);
    com.tencent.mm.plugin.report.service.h.wUl.f(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.qCu = false;
    AppMethodBeat.o(29837);
  }
  
  public int getResourceId()
  {
    return 2131951740;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29834);
    az.ayM();
    int i = bs.l(c.agA().get(40, Integer.valueOf(0)), 0);
    ac.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.screen = getPreferenceScreen();
    this.AwV = ((VoiceHeaderPreference)this.screen.aPN("settings_voiceprint_header"));
    ((CheckBoxPreference)this.screen.aPN("settings_voiceprint_title")).wT(true);
    this.screen.notifyDataSetChanged();
    if ((this.fts != null) && (this.fts.isShowing())) {
      this.fts.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    az.agi().a(new i(0), 0);
    this.screen.cK("settings_voiceprint_unlock", true);
    this.screen.cK("settings_voiceprint_reset", true);
    this.screen.cK("settings_voiceprint_create", true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29827);
        SettingsVoicePrintUI.this.finish();
        AppMethodBeat.o(29827);
        return true;
      }
    });
    AppMethodBeat.o(29834);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(29838);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramIntent != null)) {
      this.qCu = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
    AppMethodBeat.o(29838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29831);
    super.onCreate(paramBundle);
    setMMTitle(2131763495);
    az.agi().a(615, this);
    this.khe = findViewById(2131302324);
    initView();
    this.khe.setBackgroundResource(2131101179);
    az.ayM();
    c.agA().set(ah.a.GEz, Boolean.FALSE);
    az.ayM();
    c.agA().set(ah.a.GEA, Boolean.FALSE);
    az.ayM();
    c.agA().set(ah.a.GEB, Boolean.FALSE);
    az.ayM();
    c.agA().set(ah.a.GEC, Boolean.FALSE);
    ac.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    AppMethodBeat.o(29831);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29833);
    super.onDestroy();
    az.agi().b(615, this);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    AppMethodBeat.o(29833);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29835);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_voiceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.aPN("settings_voiceprint_title");
      ac.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.fts != null) && (this.fts.isShowing())) {
        this.fts.dismiss();
      }
      paramPreference = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(paramPreference, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        az.agi().a(new i(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(29835);
        return true;
        az.agi().a(new i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29835);
      return true;
    }
    if (paramPreference.equals("settings_voiceprint_reset"))
    {
      localIntent.setClass(this, VoiceCreateUI.class);
      localIntent.putExtra("KvoicePrintReset", true);
      localIntent.putExtra("kscene_type", 73);
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(29835);
      return true;
    }
    AppMethodBeat.o(29835);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29839);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29839);
      return;
    }
    ac.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29839);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        egK();
        AppMethodBeat.o(29839);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29829);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = SettingsVoicePrintUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(29829);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29830);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(29830);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29832);
    super.onResume();
    if (this.qCu)
    {
      this.qCu = false;
      if ((this.fts != null) && (this.fts.isShowing())) {
        this.fts.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      ac.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      az.agi().a(new i(1), 0);
    }
    AppMethodBeat.o(29832);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29836);
    ac.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.cK("settings_voiceprint_unlock", true);
      this.screen.cK("settings_voiceprint_reset", true);
      this.screen.cK("settings_voiceprint_create", true);
      ((CheckBoxPreference)this.screen.aPN("settings_voiceprint_title")).wT(false);
      this.AwV.fX(getString(2131764768), "");
      this.screen.notifyDataSetChanged();
      if (this.fts != null) {
        this.fts.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
    }
    if (paramn.getType() == 615)
    {
      paramString = (i)paramn;
      if (paramString.mStatus != 1) {
        break label499;
      }
      ac.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
      this.screen.cK("settings_voiceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = u.axC();
      paramn = (CheckBoxPreference)this.screen.aPN("settings_voiceprint_title");
      ac.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.Awe) });
      if (paramString.Awe <= 0) {
        break label433;
      }
      ac.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
      paramn.wT(true);
      this.screen.cK("settings_voiceprint_reset", false);
      this.screen.cK("settings_voiceprint_unlock", false);
      paramInt1 = 0x20000 | paramInt1;
      this.AwV.fX(getString(2131764770), "");
      ac.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      ay.hnA.aL("last_login_use_voice", String.valueOf(paramInt1));
      az.ayM();
      c.agA().set(40, Integer.valueOf(paramInt1));
      this.screen.cK("settings_voiceprint_create", true);
      this.screen.cK("settings_voiceprint_title", false);
      this.AwV.c(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.fts != null) {
        this.fts.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
      label433:
      ac.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
      paramn.wT(false);
      this.screen.cK("settings_voiceprint_reset", true);
      this.screen.cK("settings_voiceprint_unlock", true);
      paramInt1 = 0xFFFDFFFF & paramInt1;
      this.AwV.fX(getString(2131764768), "");
      break;
      label499:
      ac.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
      com.tencent.mm.plugin.report.service.h.wUl.f(11390, new Object[] { Integer.valueOf(2) });
      this.screen.cK("settings_voiceprint_unlock", true);
      this.screen.cK("settings_voiceprint_reset", true);
      this.screen.cK("settings_voiceprint_create", true);
      this.screen.cK("settings_voiceprint_title", true);
      this.AwV.fX(getString(2131764772), getString(2131764771));
      this.AwV.c(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29828);
          boolean bool = b.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
          ac.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), SettingsVoicePrintUI.this });
          if (!bool)
          {
            AppMethodBeat.o(29828);
            return;
          }
          SettingsVoicePrintUI.a(SettingsVoicePrintUI.this);
          AppMethodBeat.o(29828);
        }
      });
      this.screen.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */