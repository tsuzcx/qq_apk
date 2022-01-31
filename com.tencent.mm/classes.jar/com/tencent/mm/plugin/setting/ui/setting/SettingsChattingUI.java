package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

public class SettingsChattingUI
  extends MMPreference
{
  private f dnn;
  private boolean isDeleteCancel = false;
  private ProgressDialog nTd = null;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    paramf = paramPreference.mKey;
    int i = -1;
    switch (paramf.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        bool1 = false;
      }
      break;
    }
    do
    {
      return bool1;
      if (!paramf.equals("settings_voice_play_mode")) {
        break;
      }
      i = 0;
      break;
      if (!paramf.equals("settings_enter_button_send")) {
        break;
      }
      i = 1;
      break;
      if (!paramf.equals("settings_bak_chat")) {
        break;
      }
      i = 2;
      break;
      if (!paramf.equals("settings_chatting_bg")) {
        break;
      }
      i = 3;
      break;
      if (!paramf.equals("settings_emoji_manager")) {
        break;
      }
      i = 4;
      break;
      if (!paramf.equals("settings_reset")) {
        break;
      }
      i = 5;
      break;
      if (!paramf.equals("settings_recovery")) {
        break;
      }
      i = 6;
      break;
      boolean bool3 = ((Boolean)g.DP().Dz().get(26, Boolean.valueOf(false))).booleanValue();
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        y.d("MicroMsg.SettingsChattingUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        paramf = g.DP().Dz();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        paramf.o(26, Boolean.valueOf(bool1));
        return true;
      }
      paramf = (CheckBoxPreference)this.dnn.add("settings_enter_button_send");
    } while (paramf == null);
    bool1 = paramf.isChecked();
    y.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
    g.DP().Dz().o(66832, Boolean.valueOf(bool1));
    return true;
    paramf = new Intent().setClassName(this.mController.uMN, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
    MMWizardActivity.C(this.mController.uMN, paramf);
    return true;
    paramf = new Intent();
    paramf.setClass(this, SettingsChattingBackgroundUI.class);
    this.mController.uMN.startActivity(paramf);
    return true;
    paramf = new Intent();
    paramf.putExtra("10931", 2);
    d.b(this.mController.uMN, "emoji", ".ui.EmojiMineUI", paramf);
    return true;
    h.a(this.mController.uMN, getResources().getString(a.i.settings_reset_warning), "", getString(a.i.app_clear), getString(a.i.app_cancel), new SettingsChattingUI.2(this), null);
    return true;
    paramf = new Intent().setClassName(this.mController.uMN, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
    paramf.putExtra("scene", 1);
    this.mController.uMN.startActivity(paramf);
    return true;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_chatting);
    this.dnn = this.vdd;
    if (g.DP().Dz().getInt(89, 0) != 2) {
      this.dnn.ade("settings_recovery");
    }
    setBackBtn(new SettingsChattingUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!g.DN().Dc())
    {
      finish();
      return;
    }
    initView();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = (CheckBoxPreference)this.dnn.add("settings_voice_play_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).rHo = ((Boolean)g.DP().Dz().get(26, Boolean.valueOf(false))).booleanValue();
      ((Preference)localObject).vdK = false;
    }
    localObject = (CheckBoxPreference)this.dnn.add("settings_enter_button_send");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).rHo = ((Boolean)g.DP().Dz().get(66832, Boolean.valueOf(false))).booleanValue();
      ((Preference)localObject).vdK = false;
    }
    localObject = this.dnn.add("settings_text_size");
    if (localObject != null) {
      ((Preference)localObject).setSummary(getString(SetTextSizeUI.eb(this)));
    }
    this.dnn.notifyDataSetChanged();
  }
  
  public final int xj()
  {
    return a.k.settings_pref_chatting;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI
 * JD-Core Version:    0.7.0.1
 */