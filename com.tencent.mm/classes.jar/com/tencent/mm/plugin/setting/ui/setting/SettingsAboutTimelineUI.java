package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI
  extends MMPreference
{
  private String dZZ = "";
  private boolean qHA = false;
  private boolean qHz = false;
  private f screen;
  
  public int getResourceId()
  {
    return 2131165272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127141);
    this.screen = getPreferenceScreen();
    setMMTitle(2131303366);
    setBackBtn(new SettingsAboutTimelineUI.1(this));
    this.dZZ = r.Zn();
    AppMethodBeat.o(127141);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127137);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127137);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127140);
    super.onDestroy();
    if ((this.qHz) && (n.raR != null))
    {
      cfj localcfj = n.raR.bo(this.dZZ, this.qHA);
      if (localcfj == null)
      {
        AppMethodBeat.o(127140);
        return;
      }
      ab.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + localcfj.toString());
      ((j)g.E(j.class)).Yz().c(new j.a(51, localcfj));
    }
    AppMethodBeat.o(127140);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127139);
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
      if (this.qHA) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      this.qHA = bool;
      if (n.raR != null) {
        n.raR.bn(this.dZZ, this.qHA);
      }
      this.qHz = true;
      AppMethodBeat.o(127139);
      return false;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127138);
    super.onResume();
    Object localObject = new cfj();
    if (n.raR != null) {
      localObject = n.raR.Zu(this.dZZ);
    }
    if (localObject == null) {
      ab.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127138);
      return;
      int i = ((cfj)localObject).xPN;
      localObject = (CheckBoxPreference)this.screen.atx("timeline_stranger_show");
      if (localObject != null)
      {
        if ((i & 0x1) > 0) {}
        SharedPreferences localSharedPreferences;
        for (boolean bool = true;; bool = false)
        {
          this.qHA = bool;
          localSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
          if (this.qHA) {
            break label169;
          }
          ((CheckBoxPreference)localObject).vxW = true;
          localSharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
          break;
        }
        label169:
        ((CheckBoxPreference)localObject).vxW = false;
        localSharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI
 * JD-Core Version:    0.7.0.1
 */