package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI
  extends MMPreference
{
  private boolean Prl = false;
  private boolean Prm = false;
  private String ltf = "";
  private f screen;
  
  public int getResourceId()
  {
    return b.k.settings_about_timeline;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74073);
    this.screen = getPreferenceScreen();
    setMMTitle(b.i.settings_pirvate_timeline);
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
    this.ltf = z.bAM();
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
    if ((this.Prl) && (q.Qki != null))
    {
      ffs localffs = q.Qki.cS(this.ltf, this.Prm);
      if (localffs == null)
      {
        AppMethodBeat.o(74072);
        return;
      }
      Log.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + localffs.toString());
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(51, localffs));
    }
    AppMethodBeat.o(74072);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
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
      if (this.Prm) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      this.Prm = bool;
      if (q.Qki != null) {
        q.Qki.cR(this.ltf, this.Prm);
      }
      this.Prl = true;
      AppMethodBeat.o(74071);
      return false;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74070);
    super.onResume();
    Object localObject = new ffs();
    if (q.Qki != null) {
      localObject = q.Qki.aWV(this.ltf);
    }
    if (localObject == null) {
      Log.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74070);
      return;
      int i = ((ffs)localObject).abFF;
      localObject = (CheckBoxPreference)this.screen.bAi("timeline_stranger_show");
      if (localObject != null)
      {
        if ((i & 0x1) > 0) {}
        SharedPreferences localSharedPreferences;
        for (boolean bool = true;; bool = false)
        {
          this.Prm = bool;
          localSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
          if (this.Prm) {
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