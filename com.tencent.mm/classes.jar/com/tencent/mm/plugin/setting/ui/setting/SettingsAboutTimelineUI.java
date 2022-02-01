package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutTimelineUI
  extends MMPreference
{
  private String fnC = "";
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean xrm = false;
  private boolean xrn = false;
  
  public int getResourceId()
  {
    return 2131951716;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74073);
    this.screen = getPreferenceScreen();
    setMMTitle(2131763348);
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
    this.fnC = u.axw();
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
    if ((this.xrm) && (o.xMb != null))
    {
      dbt localdbt = o.xMb.bD(this.fnC, this.xrn);
      if (localdbt == null)
      {
        AppMethodBeat.o(74072);
        return;
      }
      ac.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + localdbt.toString());
      ((k)g.ab(k.class)).awA().c(new j.a(51, localdbt));
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
      if (this.xrn) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      this.xrn = bool;
      if (o.xMb != null) {
        o.xMb.bC(this.fnC, this.xrn);
      }
      this.xrm = true;
      AppMethodBeat.o(74071);
      return false;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74070);
    super.onResume();
    Object localObject = new dbt();
    if (o.xMb != null) {
      localObject = o.xMb.asG(this.fnC);
    }
    if (localObject == null) {
      ac.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74070);
      return;
      int i = ((dbt)localObject).FLb;
      localObject = (CheckBoxPreference)this.screen.aPN("timeline_stranger_show");
      if (localObject != null)
      {
        if ((i & 0x1) > 0) {}
        SharedPreferences localSharedPreferences;
        for (boolean bool = true;; bool = false)
        {
          this.xrn = bool;
          localSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
          if (this.xrn) {
            break label169;
          }
          ((CheckBoxPreference)localObject).mF = true;
          localSharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
          break;
        }
        label169:
        ((CheckBoxPreference)localObject).mF = false;
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