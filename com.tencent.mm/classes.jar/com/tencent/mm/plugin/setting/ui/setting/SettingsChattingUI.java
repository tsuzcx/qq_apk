package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingUI
  extends MMPreference
{
  private boolean isDeleteCancel = false;
  private ProgressDialog qHd = null;
  private f screen;
  
  public int getResourceId()
  {
    return 2131165282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127217);
    setMMTitle(2131303227);
    this.screen = getPreferenceScreen();
    if (g.RL().Ru().getInt(89, 0) != 2) {
      this.screen.aty("settings_recovery");
    }
    setBackBtn(new SettingsChattingUI.1(this));
    AppMethodBeat.o(127217);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127216);
    super.onCreate(paramBundle);
    if (!g.RJ().QU())
    {
      finish();
      AppMethodBeat.o(127216);
      return;
    }
    initView();
    AppMethodBeat.o(127216);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(127219);
    paramf = paramPreference.mKey;
    int i = -1;
    switch (paramf.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(127219);
        return false;
        if (paramf.equals("settings_voice_play_mode"))
        {
          i = 0;
          continue;
          if (paramf.equals("settings_enter_button_send"))
          {
            i = 1;
            continue;
            if (paramf.equals("settings_bak_chat"))
            {
              i = 2;
              continue;
              if (paramf.equals("settings_chatting_bg"))
              {
                i = 3;
                continue;
                if (paramf.equals("settings_emoji_manager"))
                {
                  i = 4;
                  continue;
                  if (paramf.equals("settings_reset"))
                  {
                    i = 5;
                    continue;
                    if (paramf.equals("settings_recovery")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    boolean bool3 = ((Boolean)g.RL().Ru().get(26, Boolean.FALSE)).booleanValue();
    if (!bool3) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.SettingsChattingUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      paramf = g.RL().Ru();
      bool1 = bool2;
      if (!bool3) {
        bool1 = true;
      }
      paramf.set(26, Boolean.valueOf(bool1));
      AppMethodBeat.o(127219);
      return true;
    }
    paramf = (CheckBoxPreference)this.screen.atx("settings_enter_button_send");
    if (paramf != null)
    {
      bool1 = paramf.isChecked();
      ab.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
      g.RL().Ru().set(66832, Boolean.valueOf(bool1));
    }
    AppMethodBeat.o(127219);
    return true;
    startActivity(new Intent().setClassName(getContext(), "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI"));
    AppMethodBeat.o(127219);
    return true;
    paramf = new Intent();
    paramf.setClass(this, SettingsChattingBackgroundUI.class);
    getContext().startActivity(paramf);
    AppMethodBeat.o(127219);
    return true;
    paramf = new Intent();
    paramf.putExtra("10931", 2);
    d.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
    AppMethodBeat.o(127219);
    return true;
    h.d(getContext(), getResources().getString(2131303402), "", getString(2131296891), getString(2131296888), new SettingsChattingUI.2(this), null);
    AppMethodBeat.o(127219);
    return true;
    paramf = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
    paramf.putExtra("scene", 1);
    getContext().startActivity(paramf);
    AppMethodBeat.o(127219);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127218);
    super.onResume();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("settings_voice_play_mode");
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.vxW = ((Boolean)g.RL().Ru().get(26, Boolean.FALSE)).booleanValue();
      localCheckBoxPreference.zsk = false;
    }
    localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("settings_enter_button_send");
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.vxW = ((Boolean)g.RL().Ru().get(66832, Boolean.FALSE)).booleanValue();
      localCheckBoxPreference.zsk = false;
    }
    AppMethodBeat.o(127218);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI
 * JD-Core Version:    0.7.0.1
 */