package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.y.b;

public class SelectSexUI
  extends MMPreference
{
  private SelectPreference FTP;
  private SelectPreference FTQ;
  private com.tencent.mm.ui.base.preference.f screen;
  private int sex = -1;
  
  public int getResourceId()
  {
    return b.k.select_sex;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73949);
    this.screen = getPreferenceScreen();
    this.FTP = ((SelectPreference)this.screen.bAi("select_male"));
    this.FTQ = ((SelectPreference)this.screen.bAi("select_female"));
    int i = Util.nullAs((Integer)h.baE().ban().d(12290, null), 0);
    if (i == 1) {
      this.FTP.isSelected = true;
    }
    for (;;)
    {
      setMMTitle(b.i.select_sex);
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
      addTextOptionMenu(0, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73947);
          SelectSexUI.a(SelectSexUI.this);
          SelectSexUI.this.finish();
          AppMethodBeat.o(73947);
          return true;
        }
      }, null, y.b.adEJ);
      AppMethodBeat.o(73949);
      return;
      if (i == 2) {
        this.FTQ.isSelected = true;
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(73950);
    paramPreference = paramPreference.mKey;
    if (paramPreference.equals("select_male"))
    {
      this.sex = 1;
      this.FTP.isSelected = true;
      this.FTQ.isSelected = false;
      paramf.notifyDataSetChanged();
    }
    for (;;)
    {
      AppMethodBeat.o(73950);
      return false;
      if (paramPreference.equals("select_female"))
      {
        this.sex = 2;
        this.FTP.isSelected = false;
        this.FTQ.isSelected = true;
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