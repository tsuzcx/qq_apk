package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;

public class SelectSexUI
  extends MMPreference
{
  private int fuA = -1;
  private f screen;
  private SelectPreference vNQ;
  private SelectPreference vNR;
  
  public int getResourceId()
  {
    return 2132017257;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73949);
    this.screen = getPreferenceScreen();
    this.vNQ = ((SelectPreference)this.screen.bmg("select_male"));
    this.vNR = ((SelectPreference)this.screen.bmg("select_female"));
    int i = Util.nullAs((Integer)g.aAh().azQ().get(12290, null), 0);
    if (i == 1) {
      this.vNQ.isSelected = true;
    }
    for (;;)
    {
      setMMTitle(2131765167);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73946);
          SelectSexUI.this.hideVKB();
          SelectSexUI.this.finish();
          AppMethodBeat.o(73946);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73947);
          SelectSexUI.a(SelectSexUI.this);
          SelectSexUI.this.finish();
          AppMethodBeat.o(73947);
          return true;
        }
      }, null, t.b.OGU);
      AppMethodBeat.o(73949);
      return;
      if (i == 2) {
        this.vNR.isSelected = true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73948);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(73948);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73950);
    paramPreference = paramPreference.mKey;
    if (paramPreference.equals("select_male"))
    {
      this.fuA = 1;
      this.vNQ.isSelected = true;
      this.vNR.isSelected = false;
      paramf.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(73950);
      return false;
      if (paramPreference.equals("select_female"))
      {
        this.fuA = 2;
        this.vNQ.isSelected = false;
        this.vNR.isSelected = true;
        paramf.notifyDataSetChanged();
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
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelectSexUI
 * JD-Core Version:    0.7.0.1
 */