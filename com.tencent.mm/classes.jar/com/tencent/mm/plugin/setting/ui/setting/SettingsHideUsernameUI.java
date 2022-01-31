package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private boolean iqO;
  private long kRf;
  private int qHP;
  private CheckBoxPreference qIw;
  private f screen;
  private String username;
  
  private void ckk()
  {
    AppMethodBeat.i(127234);
    if (this.iqO)
    {
      this.qIw.setSummary(getString(2131303423));
      AppMethodBeat.o(127234);
      return;
    }
    if (this.qIw.isEnabled())
    {
      this.qIw.setSummary(getString(2131303421));
      AppMethodBeat.o(127234);
      return;
    }
    this.qIw.setSummary(getString(2131303422));
    AppMethodBeat.o(127234);
  }
  
  public int getResourceId()
  {
    return 2131165276;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(127232);
    setMMTitle(2131303508);
    this.screen.atx("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.kRf & 0x4000) != 0L)
    {
      bool1 = true;
      this.iqO = bool1;
      ab.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.qIw = ((CheckBoxPreference)this.screen.atx("settings_show_username"));
      this.qIw.zsk = false;
      localCheckBoxPreference = this.qIw;
      if (bool1) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.vxW = bool1;
      if (bo.isNullOrNil(r.Zp())) {
        this.qIw.setEnabled(false);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127232);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127231);
    super.onCreate(paramBundle);
    this.username = r.Zo();
    if (bo.isNullOrNil(this.username)) {
      this.username = r.Zn();
    }
    this.screen = getPreferenceScreen();
    this.kRf = r.Zs();
    this.qHP = r.Zt();
    initView();
    setBackBtn(new SettingsHideUsernameUI.1(this));
    AppMethodBeat.o(127231);
  }
  
  public void onPause()
  {
    int j = 0;
    int i = 1;
    AppMethodBeat.i(127236);
    super.onPause();
    ab.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.iqO) });
    if ((this.kRf & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.iqO)
    {
      if (!this.iqO) {
        break label194;
      }
      this.kRf |= 0x4000;
    }
    for (this.qHP |= 0x200;; this.qHP &= 0xFFFFFDFF)
    {
      g.RM();
      g.RL().Ru().set(147457, Long.valueOf(this.kRf));
      g.RM();
      g.RL().Ru().set(40, Integer.valueOf(this.qHP));
      aek localaek = new aek();
      localaek.wXn = 46;
      if (this.iqO) {
        i = 2;
      }
      localaek.pKC = i;
      ((j)g.E(j.class)).Yz().c(new j.a(23, localaek));
      AppMethodBeat.o(127236);
      return;
      label194:
      this.kRf &= 0xFFFFBFFF;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool = false;
    AppMethodBeat.i(127233);
    if (paramPreference.mKey.equals("settings_show_username"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        bool = true;
      }
      this.iqO = bool;
      ckk();
      AppMethodBeat.o(127233);
      return true;
    }
    AppMethodBeat.o(127233);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127235);
    super.onResume();
    ckk();
    AppMethodBeat.o(127235);
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