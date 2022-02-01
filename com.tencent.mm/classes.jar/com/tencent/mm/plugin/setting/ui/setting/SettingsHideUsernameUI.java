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
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private boolean mMv;
  private long oAP;
  private f screen;
  private String username;
  private int xrC;
  private CheckBoxPreference xst;
  
  private void dCe()
  {
    AppMethodBeat.i(74172);
    if (this.mMv)
    {
      this.xst.setSummary(getString(2131763405));
      AppMethodBeat.o(74172);
      return;
    }
    if (this.xst.isEnabled())
    {
      this.xst.setSummary(getString(2131763403));
      AppMethodBeat.o(74172);
      return;
    }
    this.xst.setSummary(getString(2131763404));
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
    this.screen.aPN("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.oAP & 0x4000) != 0L)
    {
      bool1 = true;
      this.mMv = bool1;
      ac.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.xst = ((CheckBoxPreference)this.screen.aPN("settings_show_username"));
      this.xst.HFK = false;
      localCheckBoxPreference = this.xst;
      if (bool1) {
        break label148;
      }
    }
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.mF = bool1;
      if (bs.isNullOrNil(u.axy())) {
        this.xst.setEnabled(false);
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
    this.username = u.axx();
    if (bs.isNullOrNil(this.username)) {
      this.username = u.axw();
    }
    this.screen = getPreferenceScreen();
    this.oAP = u.axB();
    this.xrC = u.axC();
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
    ac.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.mMv) });
    if ((this.oAP & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.mMv)
    {
      if (!this.mMv) {
        break label194;
      }
      this.oAP |= 0x4000;
    }
    for (this.xrC |= 0x200;; this.xrC &= 0xFFFFFDFF)
    {
      g.agS();
      g.agR().agA().set(147457, Long.valueOf(this.oAP));
      g.agS();
      g.agR().agA().set(40, Integer.valueOf(this.xrC));
      aqc localaqc = new aqc();
      localaqc.EIY = 46;
      if (this.mMv) {
        i = 2;
      }
      localaqc.vVH = i;
      ((k)g.ab(k.class)).awA().c(new j.a(23, localaqc));
      AppMethodBeat.o(74174);
      return;
      label194:
      this.oAP &= 0xFFFFBFFF;
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
      this.mMv = bool;
      dCe();
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
    dCe();
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