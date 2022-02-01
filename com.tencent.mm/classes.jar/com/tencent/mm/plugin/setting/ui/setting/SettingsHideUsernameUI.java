package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private boolean nmR;
  private long pek;
  private f screen;
  private String username;
  private int yGl;
  private CheckBoxPreference yHc;
  
  private void dNH()
  {
    AppMethodBeat.i(74172);
    if (this.nmR)
    {
      this.yHc.setSummary(getString(2131763405));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.yHc.isEnabled())
    {
      this.yHc.setSummary(getString(2131763403));
      AppMethodBeat.o(74172);
      return;
    }
    this.yHc.setSummary(getString(2131763404));
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
    this.screen.aVD("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.pek & 0x4000) != 0L)
    {
      bool1 = true;
      this.nmR = bool1;
      ad.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.yHc = ((CheckBoxPreference)this.screen.aVD("settings_show_username"));
      this.yHc.JtB = false;
      localCheckBoxPreference = this.yHc;
      if (bool1) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.oB = bool1;
      if (bt.isNullOrNil(u.aAo())) {
        this.yHc.setEnabled(false);
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
    this.username = u.aAn();
    if (bt.isNullOrNil(this.username)) {
      this.username = u.aAm();
    }
    this.screen = getPreferenceScreen();
    this.pek = u.aAr();
    this.yGl = u.aAs();
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
    ad.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.nmR) });
    if ((this.pek & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.nmR)
    {
      if (!this.nmR) {
        break label194;
      }
      this.pek |= 0x4000;
    }
    for (this.yGl |= 0x200;; this.yGl &= 0xFFFFFDFF)
    {
      g.ajD();
      g.ajC().ajl().set(147457, Long.valueOf(this.pek));
      g.ajD();
      g.ajC().ajl().set(40, Integer.valueOf(this.yGl));
      aty localaty = new aty();
      localaty.GrZ = 46;
      if (this.nmR) {
        i = 2;
      }
      localaty.xcI = i;
      ((l)g.ab(l.class)).azo().c(new k.a(23, localaty));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.pek &= 0xFFFFBFFF;
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
      this.nmR = bool;
      dNH();
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
    dNH();
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