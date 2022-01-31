package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;

public class SettingsVoicePrintUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private ProgressDialog dnm = null;
  private com.tencent.mm.ui.base.preference.f dnn;
  private boolean jSI = false;
  private View jdj;
  private VoiceHeaderPreference pMi;
  
  private void bPm()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.jSI = false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_voiceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.add("settings_voiceprint_title");
      y.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.dnm != null) && (this.dnm.isShowing())) {
        this.dnm.dismiss();
      }
      paramPreference = this.mController.uMN;
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(paramPreference, getString(R.l.app_waiting), true, new SettingsVoicePrintUI.4(this));
      if (paramf.isChecked()) {
        au.Dk().a(new i(1), 0);
      }
      for (;;)
      {
        return true;
        au.Dk().a(new i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      startActivity(localIntent);
      return true;
    }
    if (paramPreference.equals("settings_voiceprint_reset"))
    {
      localIntent.setClass(this, VoiceCreateUI.class);
      localIntent.putExtra("KvoicePrintReset", true);
      localIntent.putExtra("kscene_type", 73);
      startActivityForResult(localIntent, 1);
      return true;
    }
    return false;
  }
  
  public final void initView()
  {
    au.Hx();
    int i = bk.e(c.Dz().get(40, Integer.valueOf(0)), 0);
    y.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.dnn = this.vdd;
    this.pMi = ((VoiceHeaderPreference)this.dnn.add("settings_voiceprint_header"));
    ((CheckBoxPreference)this.dnn.add("settings_voiceprint_title")).nd(true);
    this.dnn.notifyDataSetChanged();
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(R.l.app_waiting), true, new SettingsVoicePrintUI.2(this));
    au.Dk().a(new i(0), 0);
    this.dnn.bJ("settings_voiceprint_unlock", true);
    this.dnn.bJ("settings_voiceprint_reset", true);
    this.dnn.bJ("settings_voiceprint_create", true);
    setBackBtn(new SettingsVoicePrintUI.3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramIntent != null)) {
      this.jSI = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.settings_voiceprint);
    au.Dk().a(615, this);
    this.jdj = findViewById(R.h.mm_preference_list_content);
    initView();
    this.jdj.setBackgroundResource(R.e.white);
    au.Hx();
    c.Dz().c(ac.a.uou, Boolean.valueOf(false));
    au.Hx();
    c.Dz().c(ac.a.uov, Boolean.valueOf(false));
    au.Hx();
    c.Dz().c(ac.a.uow, Boolean.valueOf(false));
    au.Hx();
    c.Dz().c(ac.a.uox, Boolean.valueOf(false));
    y.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(615, this);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.VoiceSettingsUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      bPm();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new SettingsVoicePrintUI.6(this), new SettingsVoicePrintUI.7(this));
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jSI)
    {
      this.jSI = false;
      if ((this.dnm != null) && (this.dnm.isShowing())) {
        this.dnm.dismiss();
      }
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(R.l.app_waiting), true, new SettingsVoicePrintUI.1(this));
      y.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      au.Dk().a(new i(1), 0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.dnn.bJ("settings_voiceprint_unlock", true);
      this.dnn.bJ("settings_voiceprint_reset", true);
      this.dnn.bJ("settings_voiceprint_create", true);
      ((CheckBoxPreference)this.dnn.add("settings_voiceprint_title")).nd(false);
      this.pMi.cY(getString(R.l.voice_start_close), "");
      this.dnn.notifyDataSetChanged();
      if (this.dnm != null) {
        this.dnm.dismiss();
      }
    }
    label409:
    label596:
    for (;;)
    {
      return;
      if (paramm.getType() == 615)
      {
        paramString = (i)paramm;
        if (paramString.mStatus != 1) {
          break label473;
        }
        y.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
        this.dnn.bJ("settings_voiceprint_unlock", false);
        this.dnn.notifyDataSetChanged();
        paramInt1 = q.Gp();
        paramm = (CheckBoxPreference)this.dnn.add("settings_voiceprint_title");
        y.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.pLs) });
        if (paramString.pLs <= 0) {
          break label409;
        }
        y.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
        paramm.nd(true);
        this.dnn.bJ("settings_voiceprint_reset", false);
        this.dnn.bJ("settings_voiceprint_unlock", false);
        paramInt1 = 0x20000 | paramInt1;
        this.pMi.cY(getString(R.l.voice_start_open), "");
        y.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
        at.dVC.Y("last_login_use_voice", String.valueOf(paramInt1));
        au.Hx();
        c.Dz().o(40, Integer.valueOf(paramInt1));
        this.dnn.bJ("settings_voiceprint_create", true);
        this.dnn.bJ("settings_voiceprint_title", false);
        this.pMi.c(null);
        this.dnn.notifyDataSetChanged();
      }
      for (;;)
      {
        if (this.dnm == null) {
          break label596;
        }
        this.dnm.dismiss();
        return;
        y.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
        paramm.nd(false);
        this.dnn.bJ("settings_voiceprint_reset", true);
        this.dnn.bJ("settings_voiceprint_unlock", true);
        paramInt1 = 0xFFFDFFFF & paramInt1;
        this.pMi.cY(getString(R.l.voice_start_close), "");
        break;
        label473:
        y.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
        com.tencent.mm.plugin.report.service.h.nFQ.f(11390, new Object[] { Integer.valueOf(2) });
        this.dnn.bJ("settings_voiceprint_unlock", true);
        this.dnn.bJ("settings_voiceprint_reset", true);
        this.dnn.bJ("settings_voiceprint_create", true);
        this.dnn.bJ("settings_voiceprint_title", true);
        this.pMi.cY(getString(R.l.voice_start_title), getString(R.l.voice_start_tip));
        this.pMi.c(new SettingsVoicePrintUI.5(this));
        this.dnn.notifyDataSetChanged();
      }
    }
  }
  
  public final int xj()
  {
    return R.o.settings_voice_print;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */