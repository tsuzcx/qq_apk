package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera
  extends MMPreference
{
  private f dnn;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    paramf = paramPreference.mKey;
    ac.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool1 = ((Boolean)g.DP().Dz().get(ac.a.uuD, Boolean.valueOf(true))).booleanValue();
      paramPreference = g.DP().Dz();
      locala = ac.a.uuD;
      if (!bool1)
      {
        bool1 = true;
        paramPreference.c(locala, Boolean.valueOf(bool1));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool1 = ((Boolean)g.DP().Dz().get(ac.a.uuF, Boolean.valueOf(true))).booleanValue();
        paramPreference = g.DP().Dz();
        locala = ac.a.uuF;
        if (bool1) {
          break label194;
        }
        bool1 = true;
        label118:
        paramPreference.c(locala, Boolean.valueOf(bool1));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool1 = ((Boolean)g.DP().Dz().get(ac.a.uuG, Boolean.valueOf(true))).booleanValue();
        paramf = g.DP().Dz();
        paramPreference = ac.a.uuG;
        if (bool1) {
          break label199;
        }
      }
    }
    label194:
    label199:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramf.c(paramPreference, Boolean.valueOf(bool1));
      return false;
      bool1 = false;
      break;
      bool1 = false;
      break label118;
    }
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    setMMTitle(a.i.settings_photo_video);
    setBackBtn(new SettingsAboutCamera.1(this));
    boolean bool = ((Boolean)g.DP().Dz().get(ac.a.uuD, Boolean.valueOf(true))).booleanValue();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("settings_auto_mul_terminal_sync");
    localCheckBoxPreference.vdK = false;
    localCheckBoxPreference.rHo = bool;
    bool = ((Boolean)g.DP().Dz().get(ac.a.uuF, Boolean.valueOf(true))).booleanValue();
    localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("settings_take_photo_auto_save_photo");
    localCheckBoxPreference.vdK = false;
    localCheckBoxPreference.rHo = bool;
    bool = ((Boolean)g.DP().Dz().get(ac.a.uuG, Boolean.valueOf(true))).booleanValue();
    localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("settings_take_photo_auto_save_video");
    localCheckBoxPreference.rHo = bool;
    localCheckBoxPreference.vdK = false;
    this.dnn.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public final int xj()
  {
    return a.k.settings_pref_camera;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */