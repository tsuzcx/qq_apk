package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private int PrC;
  private CheckBoxPreference Ptr;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean uPP;
  private String username;
  private long xct;
  
  private void gVJ()
  {
    AppMethodBeat.i(74172);
    if (this.uPP)
    {
      this.Ptr.aS(getString(b.i.settings_show_username_open_hint));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.Ptr.isEnabled())
    {
      this.Ptr.aS(getString(b.i.settings_show_username_close_hint));
      AppMethodBeat.o(74172);
      return;
    }
    this.Ptr.aS(getString(b.i.settings_show_username_disable_hint));
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
    this.screen.bAi("settings_my_username").aS(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.xct & 0x4000) != 0L)
    {
      bool1 = true;
      this.uPP = bool1;
      Log.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.Ptr = ((CheckBoxPreference)this.screen.bAi("settings_show_username"));
      this.Ptr.adZV = false;
      localCheckBoxPreference = this.Ptr;
      if (bool1) {
        break label149;
      }
    }
    label149:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.setChecked(bool1);
      if (Util.isNullOrNil(z.bAO())) {
        this.Ptr.setEnabled(false);
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
    this.username = z.bAN();
    if (Util.isNullOrNil(this.username)) {
      this.username = z.bAM();
    }
    this.screen = getPreferenceScreen();
    this.xct = z.bAR();
    this.PrC = z.bAU();
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
    Log.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.uPP) });
    if ((this.xct & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.uPP)
    {
      if (!this.uPP) {
        break label194;
      }
      this.xct |= 0x4000;
    }
    for (this.PrC |= 0x200;; this.PrC &= 0xFFFFFDFF)
    {
      h.baF();
      h.baE().ban().B(147457, Long.valueOf(this.xct));
      h.baF();
      h.baE().ban().B(40, Integer.valueOf(this.PrC));
      cas localcas = new cas();
      localcas.aajJ = 46;
      if (this.uPP) {
        i = 2;
      }
      localcas.NkL = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(23, localcas));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.xct &= 0xFFFFBFFF;
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
      this.uPP = bool;
      gVJ();
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
    gVJ();
    AppMethodBeat.o(74173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI
 * JD-Core Version:    0.7.0.1
 */