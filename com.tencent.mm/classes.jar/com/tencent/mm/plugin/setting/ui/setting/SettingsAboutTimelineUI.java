package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutTimelineUI
  extends MMPreference
{
  private boolean DaS = false;
  private boolean DaT = false;
  private String gna = "";
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2132017261;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74073);
    this.screen = getPreferenceScreen();
    setMMTitle(2131765530);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74068);
        SettingsAboutTimelineUI.this.hideVKB();
        SettingsAboutTimelineUI.this.finish();
        AppMethodBeat.o(74068);
        return true;
      }
    });
    this.gna = z.aTY();
    AppMethodBeat.o(74073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74069);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74069);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74072);
    super.onDestroy();
    if ((this.DaS) && (o.DCN != null))
    {
      ebj localebj = o.DCN.cg(this.gna, this.DaT);
      if (localebj == null)
      {
        AppMethodBeat.o(74072);
        return;
      }
      Log.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + localebj.toString());
      ((l)g.af(l.class)).aSM().d(new k.a(51, localebj));
    }
    AppMethodBeat.o(74072);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74071);
    paramf = paramPreference.mKey;
    if (paramf.equals("timline_outside_permiss"))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("k_sns_tag_id", 4L);
      paramPreference.putExtra("k_sns_from_settings_about_sns", 1);
      c.b(this, "sns", ".ui.SnsBlackDetailUI", paramPreference);
    }
    if (paramf.equals("timeline_black_permiss"))
    {
      paramPreference = new Intent();
      paramPreference.putExtra("k_sns_tag_id", 5L);
      paramPreference.putExtra("k_sns_from_settings_about_sns", 2);
      c.b(this, "sns", ".ui.SnsTagDetailUI", paramPreference);
    }
    if (paramf.equals("timeline_stranger_show")) {
      if (this.DaT) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      this.DaT = bool;
      if (o.DCN != null) {
        o.DCN.cf(this.gna, this.DaT);
      }
      this.DaS = true;
      AppMethodBeat.o(74071);
      return false;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74070);
    super.onResume();
    Object localObject = new ebj();
    if (o.DCN != null) {
      localObject = o.DCN.aNV(this.gna);
    }
    if (localObject == null) {
      Log.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74070);
      return;
      int i = ((ebj)localObject).Nbc;
      localObject = (CheckBoxPreference)this.screen.bmg("timeline_stranger_show");
      if (localObject != null)
      {
        if ((i & 0x1) > 0) {}
        SharedPreferences localSharedPreferences;
        for (boolean bool = true;; bool = false)
        {
          this.DaT = bool;
          localSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
          if (this.DaT) {
            break label169;
          }
          ((CheckBoxPreference)localObject).setChecked(true);
          localSharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
          break;
        }
        label169:
        ((CheckBoxPreference)localObject).setChecked(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI
 * JD-Core Version:    0.7.0.1
 */