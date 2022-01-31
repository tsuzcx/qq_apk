package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera
  extends MMPreference
{
  private final String qGQ = "settings_auto_mul_terminal_sync";
  private final String qGR = "settings_take_photo_auto_save_photo";
  private final String qGS = "settings_take_photo_auto_save_video";
  private final String qGT = "settings_sns_auto_play_switch";
  private final String qGU = "settings_sns_auto_play_tip";
  private f screen;
  
  public int getResourceId()
  {
    return 2131165281;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127083);
    this.screen = getPreferenceScreen();
    setMMTitle(2131303365);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127080);
        SettingsAboutCamera.this.hideVKB();
        SettingsAboutCamera.this.finish();
        AppMethodBeat.o(127080);
        return true;
      }
    });
    boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yEG, Boolean.TRUE)).booleanValue();
    Object localObject = (CheckBoxPreference)this.screen.atx("settings_auto_mul_terminal_sync");
    ((Preference)localObject).zsk = false;
    ((CheckBoxPreference)localObject).vxW = bool;
    bool = ((Boolean)g.RL().Ru().get(ac.a.yEI, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.atx("settings_take_photo_auto_save_photo");
    ((Preference)localObject).zsk = false;
    ((CheckBoxPreference)localObject).vxW = bool;
    bool = ((Boolean)g.RL().Ru().get(ac.a.yEJ, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.atx("settings_take_photo_auto_save_video");
    ((CheckBoxPreference)localObject).vxW = bool;
    ((Preference)localObject).zsk = false;
    bool = ((Boolean)g.RL().Ru().get(ac.a.yEK, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.atx("settings_sns_auto_play_switch");
    ((CheckBoxPreference)localObject).vxW = bool;
    ((Preference)localObject).zsk = false;
    this.screen.notifyDataSetChanged();
    if (((a)g.E(a.class)).a(a.a.lSu, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((a)g.E(a.class)).a(a.a.lSv, "");
      int j = i;
      if (!bo.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          ab.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.cl("settings_sns_auto_play_switch", true);
        this.screen.cl("settings_sns_auto_play_tip", true);
      }
      AppMethodBeat.o(127083);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127081);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127081);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(154177);
    super.onDestroy();
    al localal = new al();
    localal.cUA = 2;
    if (((Boolean)g.RL().Ru().get(ac.a.yEG, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localal.cUB = i;
      if (!((Boolean)g.RL().Ru().get(ac.a.yEI, Boolean.TRUE)).booleanValue()) {
        break label164;
      }
      i = 1;
      label81:
      localal.cUC = i;
      if (!((Boolean)g.RL().Ru().get(ac.a.yEJ, Boolean.TRUE)).booleanValue()) {
        break label169;
      }
      i = 1;
      label112:
      localal.cUD = i;
      if (!((Boolean)g.RL().Ru().get(ac.a.yEK, Boolean.TRUE)).booleanValue()) {
        break label174;
      }
    }
    label164:
    label169:
    label174:
    for (int i = j;; i = 2)
    {
      localal.cUE = i;
      localal.ake();
      AppMethodBeat.o(154177);
      return;
      i = 2;
      break;
      i = 2;
      break label81;
      i = 2;
      break label112;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int i = 1;
    AppMethodBeat.i(127082);
    paramf = paramPreference.mKey;
    boolean bool;
    ac.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)g.RL().Ru().get(ac.a.yEG, Boolean.TRUE)).booleanValue();
      paramPreference = g.RL().Ru();
      locala = ac.a.yEG;
      if (!bool)
      {
        bool = true;
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)g.RL().Ru().get(ac.a.yEI, Boolean.TRUE)).booleanValue();
        paramPreference = g.RL().Ru();
        locala = ac.a.yEI;
        if (bool) {
          break label342;
        }
        bool = true;
        label136:
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)g.RL().Ru().get(ac.a.yEJ, Boolean.TRUE)).booleanValue();
        paramPreference = g.RL().Ru();
        locala = ac.a.yEJ;
        if (bool) {
          break label348;
        }
        bool = true;
        label199:
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)g.RL().Ru().get(ac.a.yEK, Boolean.TRUE)).booleanValue();
        paramPreference = g.RL().Ru();
        locala = ac.a.yEK;
        if (bool) {
          break label354;
        }
        bool = true;
        label262:
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
      paramPreference = new al();
      paramPreference.cUA = 3;
      if (!bo.isEqual(paramf, "settings_auto_mul_terminal_sync")) {
        break label365;
      }
      if (!((Boolean)g.RL().Ru().get(ac.a.yEG, Boolean.TRUE)).booleanValue()) {
        break label360;
      }
      label319:
      paramPreference.cUB = i;
    }
    label342:
    label348:
    label354:
    label360:
    label365:
    do
    {
      paramPreference.ake();
      AppMethodBeat.o(127082);
      return false;
      bool = false;
      break;
      bool = false;
      break label136;
      bool = false;
      break label199;
      bool = false;
      break label262;
      i = 2;
      break label319;
      if (bo.isEqual(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)g.RL().Ru().get(ac.a.yEI, Boolean.TRUE)).booleanValue()) {}
        for (i = j;; i = 2)
        {
          paramPreference.cUC = i;
          break;
        }
      }
      if (bo.isEqual(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)g.RL().Ru().get(ac.a.yEJ, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.cUD = i;
          break;
        }
      }
    } while (!bo.isEqual(paramf, "settings_sns_auto_play_switch"));
    if (((Boolean)g.RL().Ru().get(ac.a.yEK, Boolean.TRUE)).booleanValue()) {}
    for (i = m;; i = 2)
    {
      paramPreference.cUE = i;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */