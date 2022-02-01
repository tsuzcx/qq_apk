package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WebSearchExptSettingUI
  extends MMPreference
{
  private CheckBoxPreference Cap;
  private CheckBoxPreference Caq;
  private CheckBoxPreference GZT;
  private CheckBoxPreference GZU;
  private CheckBoxPreference GZV;
  
  private static void a(CheckBoxPreference paramCheckBoxPreference, int paramInt1, int paramInt2)
  {
    if ((paramInt2 & paramInt1) > 0)
    {
      paramCheckBoxPreference.mF = true;
      return;
    }
    paramCheckBoxPreference.mF = false;
  }
  
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
    this.Cap = ((CheckBoxPreference)getPreferenceScreen().aPN("expt_total_flag"));
    this.Caq = ((CheckBoxPreference)getPreferenceScreen().aPN("expt_open_tp_player_flag"));
    this.GZT = ((CheckBoxPreference)getPreferenceScreen().aPN("expt_close_preload_flag"));
    this.GZU = ((CheckBoxPreference)getPreferenceScreen().aPN("expt_reset_template_flag"));
    this.GZV = ((CheckBoxPreference)getPreferenceScreen().aPN("expt_apply_local_template"));
    int i = g.agR().agA().getInt(ah.a.GWl, 0);
    a(this.Cap, 1, i);
    a(this.Caq, 2, i);
    a(this.GZT, 4, i);
    a(this.GZU, 8, i);
    a(this.GZV, 16, i);
    AppMethodBeat.o(116565);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(116566);
    int k = g.agR().agA().getInt(ah.a.GWl, 0);
    int i;
    int j;
    if (paramPreference.mKey.equals("expt_total_flag"))
    {
      i = 1;
      j = 0;
    }
    for (;;)
    {
      if ((paramPreference instanceof CheckBoxPreference))
      {
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label214;
        }
        i |= k;
      }
      for (;;)
      {
        ac.i("MicroMsg.WebSearch.WebSearchExptSettingUI", "set flag %d", new Object[] { Integer.valueOf(i) });
        g.agR().agA().set(ah.a.GWl, Integer.valueOf(i));
        g.agR().agA().faa();
        if ((j != 0) && (com.tencent.mm.pluginsdk.g.e.DjW != null)) {
          com.tencent.mm.pluginsdk.g.e.DjW.bz(getContext());
        }
        AppMethodBeat.o(116566);
        return false;
        if (paramPreference.mKey.equals("expt_open_tp_player_flag"))
        {
          i = 2;
          j = 1;
          break;
        }
        if (paramPreference.mKey.equals("expt_close_preload_flag"))
        {
          i = 4;
          j = 1;
          break;
        }
        if (paramPreference.mKey.equals("expt_reset_template_flag"))
        {
          i = 8;
          j = 1;
          break;
        }
        if (!paramPreference.mKey.equals("expt_apply_local_template")) {
          break label224;
        }
        i = 16;
        j = 1;
        break;
        label214:
        i = (i ^ 0xFFFFFFFF) & k;
      }
      label224:
      i = 0;
      j = 0;
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