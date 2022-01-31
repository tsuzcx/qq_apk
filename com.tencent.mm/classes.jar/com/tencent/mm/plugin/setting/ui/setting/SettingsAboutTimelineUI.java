package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI
  extends MMPreference
{
  private String diG = "";
  private f dnn;
  private boolean nTA = false;
  private boolean nTz = false;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("timline_outside_permiss"))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("k_sns_tag_id", 4L);
      paramPreference.putExtra("k_sns_from_settings_about_sns", 1);
      d.b(this, "sns", ".ui.SnsBlackDetailUI", paramPreference);
    }
    if (paramf.equals("timeline_black_permiss"))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("k_sns_tag_id", 5L);
      paramPreference.putExtra("k_sns_from_settings_about_sns", 2);
      d.b(this, "sns", ".ui.SnsTagDetailUI", paramPreference);
    }
    if (paramf.equals("timeline_stranger_show")) {
      if (this.nTA) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      this.nTA = bool;
      if (n.omD != null) {
        n.omD.aY(this.diG, this.nTA);
      }
      this.nTz = true;
      return false;
    }
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    setMMTitle(a.i.settings_pirvate_timeline);
    setBackBtn(new SettingsAboutTimelineUI.1(this));
    this.diG = q.Gj();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    but localbut;
    if ((this.nTz) && (n.omD != null))
    {
      localbut = n.omD.aZ(this.diG, this.nTA);
      if (localbut != null) {}
    }
    else
    {
      return;
    }
    y.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + localbut.toString());
    ((j)g.r(j.class)).Fv().b(new i.a(51, localbut));
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = new but();
    if (n.omD != null) {
      localObject = n.omD.MN(this.diG);
    }
    if (localObject == null) {
      y.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      int i = ((but)localObject).tLp;
      localObject = (CheckBoxPreference)this.dnn.add("timeline_stranger_show");
      if (localObject != null)
      {
        if ((i & 0x1) > 0) {}
        SharedPreferences localSharedPreferences;
        for (boolean bool = true;; bool = false)
        {
          this.nTA = bool;
          localSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
          if (this.nTA) {
            break label159;
          }
          ((CheckBoxPreference)localObject).rHo = true;
          localSharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
          break;
        }
        label159:
        ((CheckBoxPreference)localObject).rHo = false;
        localSharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
      }
    }
  }
  
  public final int xj()
  {
    return a.k.settings_about_timeline;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI
 * JD-Core Version:    0.7.0.1
 */