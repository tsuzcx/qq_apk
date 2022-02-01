package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsVoicePrintUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private VoiceHeaderPreference CnR;
  private ProgressDialog fOC = null;
  private View kFh;
  private boolean rup = false;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void eyb()
  {
    AppMethodBeat.i(29837);
    g.yxI.f(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.rup = false;
    AppMethodBeat.o(29837);
  }
  
  public int getResourceId()
  {
    return 2131951740;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29834);
    bc.aCg();
    int i = bu.m(c.ajA().get(40, Integer.valueOf(0)), 0);
    ae.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.screen = getPreferenceScreen();
    this.CnR = ((VoiceHeaderPreference)this.screen.aXe("settings_voiceprint_header"));
    ((CheckBoxPreference)this.screen.aXe("settings_voiceprint_title")).uo(true);
    this.screen.notifyDataSetChanged();
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fOC = h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    bc.ajj().a(new i(0), 0);
    this.screen.cT("settings_voiceprint_unlock", true);
    this.screen.cT("settings_voiceprint_reset", true);
    this.screen.cT("settings_voiceprint_create", true);
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
      this.rup = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
    AppMethodBeat.o(29838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29831);
    super.onCreate(paramBundle);
    setMMTitle(2131763495);
    bc.ajj().a(615, this);
    this.kFh = findViewById(2131302324);
    initView();
    this.kFh.setBackgroundResource(2131101179);
    bc.aCg();
    c.ajA().set(am.a.ILo, Boolean.FALSE);
    bc.aCg();
    c.ajA().set(am.a.ILp, Boolean.FALSE);
    bc.aCg();
    c.ajA().set(am.a.ILq, Boolean.FALSE);
    bc.aCg();
    c.ajA().set(am.a.ILr, Boolean.FALSE);
    ae.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    AppMethodBeat.o(29831);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29833);
    super.onDestroy();
    bc.ajj().b(615, this);
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    AppMethodBeat.o(29833);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29835);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_voiceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.aXe("settings_voiceprint_title");
      ae.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.fOC != null) && (this.fOC.isShowing())) {
        this.fOC.dismiss();
      }
      paramPreference = getContext();
      getString(2131755906);
      this.fOC = h.b(paramPreference, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        bc.ajj().a(new i(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(29835);
        return true;
        bc.ajj().a(new i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
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
      ae.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29839);
      return;
    }
    ae.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29839);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        eyb();
        AppMethodBeat.o(29839);
        return;
      }
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131756766), false, new SettingsVoicePrintUI.6(this), new SettingsVoicePrintUI.7(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29832);
    super.onResume();
    if (this.rup)
    {
      this.rup = false;
      if ((this.fOC != null) && (this.fOC.isShowing())) {
        this.fOC.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fOC = h.b(localAppCompatActivity, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      ae.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      bc.ajj().a(new i(1), 0);
    }
    AppMethodBeat.o(29832);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29836);
    ae.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.cT("settings_voiceprint_unlock", true);
      this.screen.cT("settings_voiceprint_reset", true);
      this.screen.cT("settings_voiceprint_create", true);
      ((CheckBoxPreference)this.screen.aXe("settings_voiceprint_title")).uo(false);
      this.CnR.gl(getString(2131764768), "");
      this.screen.notifyDataSetChanged();
      if (this.fOC != null) {
        this.fOC.dismiss();
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
      ae.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
      this.screen.cT("settings_voiceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = v.aAI();
      paramn = (CheckBoxPreference)this.screen.aXe("settings_voiceprint_title");
      ae.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.Cna) });
      if (paramString.Cna <= 0) {
        break label433;
      }
      ae.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
      paramn.uo(true);
      this.screen.cT("settings_voiceprint_reset", false);
      this.screen.cT("settings_voiceprint_unlock", false);
      paramInt1 = 0x20000 | paramInt1;
      this.CnR.gl(getString(2131764770), "");
      ae.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bb.hIK.aM("last_login_use_voice", String.valueOf(paramInt1));
      bc.aCg();
      c.ajA().set(40, Integer.valueOf(paramInt1));
      this.screen.cT("settings_voiceprint_create", true);
      this.screen.cT("settings_voiceprint_title", false);
      this.CnR.b(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.fOC != null) {
        this.fOC.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
      label433:
      ae.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
      paramn.uo(false);
      this.screen.cT("settings_voiceprint_reset", true);
      this.screen.cT("settings_voiceprint_unlock", true);
      paramInt1 = 0xFFFDFFFF & paramInt1;
      this.CnR.gl(getString(2131764768), "");
      break;
      label499:
      ae.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
      g.yxI.f(11390, new Object[] { Integer.valueOf(2) });
      this.screen.cT("settings_voiceprint_unlock", true);
      this.screen.cT("settings_voiceprint_reset", true);
      this.screen.cT("settings_voiceprint_create", true);
      this.screen.cT("settings_voiceprint_title", true);
      this.CnR.gl(getString(2131764772), getString(2131764771));
      this.CnR.b(new SettingsVoicePrintUI.5(this));
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