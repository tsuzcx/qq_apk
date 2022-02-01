package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private boolean nsb;
  private long pkQ;
  private f screen;
  private String username;
  private int yWu;
  private CheckBoxPreference yXm;
  
  private void dRe()
  {
    AppMethodBeat.i(74172);
    if (this.nsb)
    {
      this.yXm.setSummary(getString(2131763405));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.yXm.isEnabled())
    {
      this.yXm.setSummary(getString(2131763403));
      AppMethodBeat.o(74172);
      return;
    }
    this.yXm.setSummary(getString(2131763404));
    AppMethodBeat.o(74172);
  }
  
  public int getResourceId()
  {
    return 2131951720;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74170);
    setMMTitle(2131763490);
    this.screen.aXe("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.pkQ & 0x4000) != 0L)
    {
      bool1 = true;
      this.nsb = bool1;
      ae.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.yXm = ((CheckBoxPreference)this.screen.aXe("settings_show_username"));
      this.yXm.JOq = false;
      localCheckBoxPreference = this.yXm;
      if (bool1) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.setChecked(bool1);
      if (bu.isNullOrNil(v.aAE())) {
        this.yXm.setEnabled(false);
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
    this.username = v.aAD();
    if (bu.isNullOrNil(this.username)) {
      this.username = v.aAC();
    }
    this.screen = getPreferenceScreen();
    this.pkQ = v.aAH();
    this.yWu = v.aAI();
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
    ae.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.nsb) });
    if ((this.pkQ & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.nsb)
    {
      if (!this.nsb) {
        break label194;
      }
      this.pkQ |= 0x4000;
    }
    for (this.yWu |= 0x200;; this.yWu &= 0xFFFFFDFF)
    {
      g.ajS();
      g.ajR().ajA().set(147457, Long.valueOf(this.pkQ));
      g.ajS();
      g.ajR().ajA().set(40, Integer.valueOf(this.yWu));
      auo localauo = new auo();
      localauo.GLx = 46;
      if (this.nsb) {
        i = 2;
      }
      localauo.xsz = i;
      ((l)g.ab(l.class)).azE().d(new k.a(23, localauo));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.pkQ &= 0xFFFFBFFF;
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
      this.nsb = bool;
      dRe();
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
    dRe();
    AppMethodBeat.o(74173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI
 * JD-Core Version:    0.7.0.1
 */