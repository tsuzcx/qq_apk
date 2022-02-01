package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r.b;

public class SelectSexUI
  extends MMPreference
{
  private int evp = -1;
  private SelectPreference qPt;
  private SelectPreference qPu;
  private f screen;
  
  public int getResourceId()
  {
    return 2131951712;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73949);
    this.screen = getPreferenceScreen();
    this.qPt = ((SelectPreference)this.screen.aKk("select_male"));
    this.qPu = ((SelectPreference)this.screen.aKk("select_female"));
    int i = bt.a((Integer)g.afB().afk().get(12290, null), 0);
    if (i == 1) {
      this.qPt.ira = true;
    }
    for (;;)
    {
      setMMTitle(2131763018);
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
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73947);
          SelectSexUI.a(SelectSexUI.this);
          SelectSexUI.this.finish();
          AppMethodBeat.o(73947);
          return true;
        }
      }, null, r.b.FOB);
      AppMethodBeat.o(73949);
      return;
      if (i == 2) {
        this.qPu.ira = true;
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
      this.evp = 1;
      this.qPt.ira = true;
      this.qPu.ira = false;
      paramf.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(73950);
      return false;
      if (paramPreference.equals("select_female"))
      {
        this.evp = 2;
        this.qPt.ira = false;
        this.qPu.ira = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelectSexUI
 * JD-Core Version:    0.7.0.1
 */