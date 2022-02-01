package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private int JgK;
  private CheckBoxPreference JhF;
  private boolean rED;
  private com.tencent.mm.ui.base.preference.f screen;
  private long tZb;
  private String username;
  
  private void fGj()
  {
    AppMethodBeat.i(74172);
    if (this.rED)
    {
      this.JhF.aF(getString(b.i.settings_show_username_open_hint));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.JhF.isEnabled())
    {
      this.JhF.aF(getString(b.i.settings_show_username_close_hint));
      AppMethodBeat.o(74172);
      return;
    }
    this.JhF.aF(getString(b.i.settings_show_username_disable_hint));
    AppMethodBeat.o(74172);
  }
  
  public int getResourceId()
  {
    return b.k.settings_hide_username;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74170);
    setMMTitle(b.i.settings_username);
    this.screen.byG("settings_my_username").aF(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.tZb & 0x4000) != 0L)
    {
      bool1 = true;
      this.rED = bool1;
      Log.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.JhF = ((CheckBoxPreference)this.screen.byG("settings_show_username"));
      this.JhF.WsF = false;
      localCheckBoxPreference = this.JhF;
      if (bool1) {
        break label149;
      }
    }
    label149:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.setChecked(bool1);
      if (Util.isNullOrNil(z.bdb())) {
        this.JhF.setEnabled(false);
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
    this.username = z.bda();
    if (Util.isNullOrNil(this.username)) {
      this.username = z.bcZ();
    }
    this.screen = getPreferenceScreen();
    this.tZb = z.bde();
    this.JgK = z.bdf();
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
    Log.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.rED) });
    if ((this.tZb & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.rED)
    {
      if (!this.rED) {
        break label194;
      }
      this.tZb |= 0x4000;
    }
    for (this.JgK |= 0x200;; this.JgK &= 0xFFFFFDFF)
    {
      h.aHH();
      h.aHG().aHp().i(147457, Long.valueOf(this.tZb));
      h.aHH();
      h.aHG().aHp().i(40, Integer.valueOf(this.JgK));
      bmy localbmy = new bmy();
      localbmy.SXP = 46;
      if (this.rED) {
        i = 2;
      }
      localbmy.HmX = i;
      ((n)h.ae(n.class)).bbK().d(new k.a(23, localbmy));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.tZb &= 0xFFFFBFFF;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool = false;
    AppMethodBeat.i(74171);
    if (paramPreference.mKey.equals("settings_show_username"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        bool = true;
      }
      this.rED = bool;
      fGj();
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
    fGj();
    AppMethodBeat.o(74173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI
 * JD-Core Version:    0.7.0.1
 */