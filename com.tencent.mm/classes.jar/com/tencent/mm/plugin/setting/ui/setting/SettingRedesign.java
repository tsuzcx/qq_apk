package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

public class SettingRedesign
  extends MMPreference
{
  private f dnn;
  private boolean nST;
  
  private void refresh()
  {
    if (this.nST != ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Intro_Need_Clear_Top ", true);
      b.eUR.q(localIntent, this.mController.uMN);
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("redesign_actionbar"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked()) {
        ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
      }
    }
    else {
      return false;
    }
    ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
    return false;
  }
  
  public final void initView()
  {
    boolean bool = false;
    setMMTitle("Redesign");
    this.dnn = this.vdd;
    this.nST = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("redesign_actionbar");
    if (localCheckBoxPreference != null)
    {
      if (!this.nST) {
        bool = true;
      }
      localCheckBoxPreference.rHo = bool;
    }
    setBackBtn(new SettingRedesign.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      refresh();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final int xj()
  {
    return a.k.setting_redesign;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingRedesign
 * JD-Core Version:    0.7.0.1
 */