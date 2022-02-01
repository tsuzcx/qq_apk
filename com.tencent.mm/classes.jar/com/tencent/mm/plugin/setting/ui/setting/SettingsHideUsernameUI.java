package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private int Dbj;
  private CheckBoxPreference Dce;
  private boolean oBV;
  private long qAb;
  private f screen;
  private String username;
  
  private void eTf()
  {
    AppMethodBeat.i(74172);
    if (this.oBV)
    {
      this.Dce.setSummary(getString(2131765587));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.Dce.isEnabled())
    {
      this.Dce.setSummary(getString(2131765585));
      AppMethodBeat.o(74172);
      return;
    }
    this.Dce.setSummary(getString(2131765586));
    AppMethodBeat.o(74172);
  }
  
  public int getResourceId()
  {
    return 2132017265;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74170);
    setMMTitle(2131765675);
    this.screen.bmg("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.qAb & 0x4000) != 0L)
    {
      bool1 = true;
      this.oBV = bool1;
      Log.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.Dce = ((CheckBoxPreference)this.screen.bmg("settings_show_username"));
      this.Dce.OZw = false;
      localCheckBoxPreference = this.Dce;
      if (bool1) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.setChecked(bool1);
      if (Util.isNullOrNil(z.aUa())) {
        this.Dce.setEnabled(false);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74170);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74169);
    super.onCreate(paramBundle);
    this.username = z.aTZ();
    if (Util.isNullOrNil(this.username)) {
      this.username = z.aTY();
    }
    this.screen = getPreferenceScreen();
    this.qAb = z.aUd();
    this.Dbj = z.aUe();
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74168);
        SettingsHideUsernameUI.this.finish();
        AppMethodBeat.o(74168);
        return true;
      }
    });
    AppMethodBeat.o(74169);
  }
  
  public void onPause()
  {
    int j = 0;
    int i = 1;
    AppMethodBeat.i(74174);
    super.onPause();
    Log.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.oBV) });
    if ((this.qAb & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.oBV)
    {
      if (!this.oBV) {
        break label194;
      }
      this.qAb |= 0x4000;
    }
    for (this.Dbj |= 0x200;; this.Dbj &= 0xFFFFFDFF)
    {
      g.aAi();
      g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
      g.aAi();
      g.aAh().azQ().set(40, Integer.valueOf(this.Dbj));
      bfx localbfx = new bfx();
      localbfx.LPB = 46;
      if (this.oBV) {
        i = 2;
      }
      localbfx.BsD = i;
      ((l)g.af(l.class)).aSM().d(new k.a(23, localbfx));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.qAb &= 0xFFFFBFFF;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool = false;
    AppMethodBeat.i(74171);
    if (paramPreference.mKey.equals("settings_show_username"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        bool = true;
      }
      this.oBV = bool;
      eTf();
      AppMethodBeat.o(74171);
      return true;
    }
    AppMethodBeat.o(74171);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74173);
    super.onResume();
    eTf();
    AppMethodBeat.o(74173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI
 * JD-Core Version:    0.7.0.1
 */