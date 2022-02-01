package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private boolean mku;
  private long nXu;
  private f screen;
  private String username;
  private int wgm;
  private CheckBoxPreference whd;
  
  private void dnW()
  {
    AppMethodBeat.i(74172);
    if (this.mku)
    {
      this.whd.setSummary(getString(2131763405));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.whd.isEnabled())
    {
      this.whd.setSummary(getString(2131763403));
      AppMethodBeat.o(74172);
      return;
    }
    this.whd.setSummary(getString(2131763404));
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
    this.screen.aKk("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.nXu & 0x4000) != 0L)
    {
      bool1 = true;
      this.mku = bool1;
      ad.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.whd = ((CheckBoxPreference)this.screen.aKk("settings_show_username"));
      this.whd.GfV = false;
      localCheckBoxPreference = this.whd;
      if (bool1) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.lG = bool1;
      if (bt.isNullOrNil(u.aqI())) {
        this.whd.setEnabled(false);
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
    this.username = u.aqH();
    if (bt.isNullOrNil(this.username)) {
      this.username = u.aqG();
    }
    this.screen = getPreferenceScreen();
    this.nXu = u.aqL();
    this.wgm = u.aqM();
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
    ad.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.mku) });
    if ((this.nXu & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.mku)
    {
      if (!this.mku) {
        break label194;
      }
      this.nXu |= 0x4000;
    }
    for (this.wgm |= 0x200;; this.wgm &= 0xFFFFFDFF)
    {
      g.afC();
      g.afB().afk().set(147457, Long.valueOf(this.nXu));
      g.afC();
      g.afB().afk().set(40, Integer.valueOf(this.wgm));
      amy localamy = new amy();
      localamy.DnY = 46;
      if (this.mku) {
        i = 2;
      }
      localamy.uMR = i;
      ((k)g.ab(k.class)).apL().c(new j.a(23, localamy));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.nXu &= 0xFFFFBFFF;
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
      this.mku = bool;
      dnW();
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
    dnW();
    AppMethodBeat.o(74173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI
 * JD-Core Version:    0.7.0.1
 */