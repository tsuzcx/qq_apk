package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WebSearchExptSettingUI
  extends MMPreference
{
  private CheckBoxPreference AHY;
  private CheckBoxPreference Lwb;
  
  public int getResourceId()
  {
    return 2131951766;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(116565);
    super.onCreate(paramBundle);
    setMMTitle(2131758652);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(116564);
        WebSearchExptSettingUI.this.finish();
        AppMethodBeat.o(116564);
        return false;
      }
    });
    this.AHY = ((CheckBoxPreference)getPreferenceScreen().aKk("expt_total_flag"));
    this.Lwb = ((CheckBoxPreference)getPreferenceScreen().aKk("expt_open_tp_player_flag"));
    int i = g.afB().afk().getInt(ae.a.Fxr, 0);
    if ((i & 0x1) > 0) {}
    for (this.AHY.lG = true; (i & 0x2) > 0; this.AHY.lG = false)
    {
      this.Lwb.lG = true;
      AppMethodBeat.o(116565);
      return;
    }
    this.Lwb.lG = false;
    AppMethodBeat.o(116565);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(116566);
    int k = g.afB().afk().getInt(ae.a.Fxr, 0);
    int j;
    int i;
    if (paramPreference.mKey.equals("expt_total_flag"))
    {
      j = 1;
      i = 0;
    }
    for (;;)
    {
      if ((paramPreference instanceof CheckBoxPreference))
      {
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label155;
        }
        j |= k;
      }
      for (;;)
      {
        ad.i("MicroMsg.WebSearch.WebSearchExptSettingUI", "set flag %d", new Object[] { Integer.valueOf(j) });
        g.afB().afk().set(ae.a.Fxr, Integer.valueOf(j));
        g.afB().afk().eKy();
        if ((i != 0) && (com.tencent.mm.pluginsdk.g.e.BRG != null)) {
          com.tencent.mm.pluginsdk.g.e.BRG.bw(getContext());
        }
        AppMethodBeat.o(116566);
        return false;
        if (!paramPreference.mKey.equals("expt_open_tp_player_flag")) {
          break label167;
        }
        j = 2;
        i = 1;
        break;
        label155:
        j = (j ^ 0xFFFFFFFF) & k;
      }
      label167:
      j = 0;
      i = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchExptSettingUI
 * JD-Core Version:    0.7.0.1
 */