package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsVoicePrintUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private ProgressDialog eeN = null;
  private View iDS;
  private boolean mne = false;
  private com.tencent.mm.ui.base.preference.f screen;
  private VoiceHeaderPreference tse;
  
  private void cLs()
  {
    AppMethodBeat.i(26155);
    com.tencent.mm.plugin.report.service.h.qsU.e(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.mne = false;
    AppMethodBeat.o(26155);
  }
  
  public int getResourceId()
  {
    return 2131165296;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26152);
    aw.aaz();
    int i = bo.f(c.Ru().get(40, Integer.valueOf(0)), 0);
    ab.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.screen = getPreferenceScreen();
    this.tse = ((VoiceHeaderPreference)this.screen.atx("settings_voiceprint_header"));
    ((CheckBoxPreference)this.screen.atx("settings_voiceprint_title")).qH(true);
    this.screen.notifyDataSetChanged();
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131297112), true, new SettingsVoicePrintUI.2(this));
    aw.Rc().a(new i(0), 0);
    this.screen.cl("settings_voiceprint_unlock", true);
    this.screen.cl("settings_voiceprint_reset", true);
    this.screen.cl("settings_voiceprint_create", true);
    setBackBtn(new SettingsVoicePrintUI.3(this));
    AppMethodBeat.o(26152);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26156);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramIntent != null)) {
      this.mne = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
    AppMethodBeat.o(26156);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26149);
    super.onCreate(paramBundle);
    setMMTitle(2131303513);
    aw.Rc().a(615, this);
    this.iDS = findViewById(2131826247);
    initView();
    this.iDS.setBackgroundResource(2131690709);
    aw.aaz();
    c.Ru().set(ac.a.yyq, Boolean.FALSE);
    aw.aaz();
    c.Ru().set(ac.a.yyr, Boolean.FALSE);
    aw.aaz();
    c.Ru().set(ac.a.yys, Boolean.FALSE);
    aw.aaz();
    c.Ru().set(ac.a.yyt, Boolean.FALSE);
    ab.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    AppMethodBeat.o(26149);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26151);
    super.onDestroy();
    aw.Rc().b(615, this);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    AppMethodBeat.o(26151);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26153);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_voiceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.atx("settings_voiceprint_title");
      ab.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.eeN != null) && (this.eeN.isShowing())) {
        this.eeN.dismiss();
      }
      paramPreference = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(paramPreference, getString(2131297112), true, new SettingsVoicePrintUI.4(this));
      if (paramf.isChecked()) {
        aw.Rc().a(new i(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(26153);
        return true;
        aw.Rc().a(new i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      startActivity(localIntent);
      AppMethodBeat.o(26153);
      return true;
    }
    if (paramPreference.equals("settings_voiceprint_reset"))
    {
      localIntent.setClass(this, VoiceCreateUI.class);
      localIntent.putExtra("KvoicePrintReset", true);
      localIntent.putExtra("kscene_type", 73);
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(26153);
      return true;
    }
    AppMethodBeat.o(26153);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26157);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(26157);
      return;
    }
    ab.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26157);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cLs();
        AppMethodBeat.o(26157);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131297837), false, new SettingsVoicePrintUI.6(this), new SettingsVoicePrintUI.7(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26150);
    super.onResume();
    if (this.mne)
    {
      this.mne = false;
      if ((this.eeN != null) && (this.eeN.isShowing())) {
        this.eeN.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131297112), true, new SettingsVoicePrintUI.1(this));
      ab.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      aw.Rc().a(new i(1), 0);
    }
    AppMethodBeat.o(26150);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26154);
    ab.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.cl("settings_voiceprint_unlock", true);
      this.screen.cl("settings_voiceprint_reset", true);
      this.screen.cl("settings_voiceprint_create", true);
      ((CheckBoxPreference)this.screen.atx("settings_voiceprint_title")).qH(false);
      this.tse.en(getString(2131304592), "");
      this.screen.notifyDataSetChanged();
      if (this.eeN != null) {
        this.eeN.dismiss();
      }
      AppMethodBeat.o(26154);
      return;
    }
    if (paramm.getType() == 615)
    {
      paramString = (i)paramm;
      if (paramString.mStatus != 1) {
        break label489;
      }
      ab.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
      this.screen.cl("settings_voiceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = r.Zt();
      paramm = (CheckBoxPreference)this.screen.atx("settings_voiceprint_title");
      ab.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.tro) });
      if (paramString.tro <= 0) {
        break label425;
      }
      ab.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
      paramm.qH(true);
      this.screen.cl("settings_voiceprint_reset", false);
      this.screen.cl("settings_voiceprint_unlock", false);
      paramInt1 = 0x20000 | paramInt1;
      this.tse.en(getString(2131304594), "");
      ab.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      av.flM.ao("last_login_use_voice", String.valueOf(paramInt1));
      aw.aaz();
      c.Ru().set(40, Integer.valueOf(paramInt1));
      this.screen.cl("settings_voiceprint_create", true);
      this.screen.cl("settings_voiceprint_title", false);
      this.tse.a(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.eeN != null) {
        this.eeN.dismiss();
      }
      AppMethodBeat.o(26154);
      return;
      label425:
      ab.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
      paramm.qH(false);
      this.screen.cl("settings_voiceprint_reset", true);
      this.screen.cl("settings_voiceprint_unlock", true);
      paramInt1 = 0xFFFDFFFF & paramInt1;
      this.tse.en(getString(2131304592), "");
      break;
      label489:
      ab.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
      com.tencent.mm.plugin.report.service.h.qsU.e(11390, new Object[] { Integer.valueOf(2) });
      this.screen.cl("settings_voiceprint_unlock", true);
      this.screen.cl("settings_voiceprint_reset", true);
      this.screen.cl("settings_voiceprint_create", true);
      this.screen.cl("settings_voiceprint_title", true);
      this.tse.en(getString(2131304596), getString(2131304595));
      this.tse.a(new SettingsVoicePrintUI.5(this));
      this.screen.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */