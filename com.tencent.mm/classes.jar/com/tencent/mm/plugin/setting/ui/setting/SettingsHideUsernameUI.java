package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI
  extends MMPreference
{
  private f dnn;
  private boolean gPg;
  private long iKA;
  private int nTP;
  private CheckBoxPreference nUq;
  private String username;
  
  private void bza()
  {
    if (this.gPg)
    {
      this.nUq.setSummary(getString(a.i.settings_show_username_open_hint));
      return;
    }
    if (this.nUq.isEnabled())
    {
      this.nUq.setSummary(getString(a.i.settings_show_username_close_hint));
      return;
    }
    this.nUq.setSummary(getString(a.i.settings_show_username_disable_hint));
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool = false;
    if (paramPreference.mKey.equals("settings_show_username"))
    {
      if (!((CheckBoxPreference)paramPreference).isChecked()) {
        bool = true;
      }
      this.gPg = bool;
      bza();
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    boolean bool2 = true;
    setMMTitle(a.i.settings_username);
    this.dnn.add("settings_my_username").setSummary(this.username);
    CheckBoxPreference localCheckBoxPreference;
    if ((this.iKA & 0x4000) != 0L)
    {
      bool1 = true;
      this.gPg = bool1;
      y.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[] { Boolean.valueOf(bool1) });
      this.nUq = ((CheckBoxPreference)this.dnn.add("settings_show_username"));
      this.nUq.vdK = false;
      localCheckBoxPreference = this.nUq;
      if (bool1) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCheckBoxPreference.rHo = bool1;
      if (bk.bl(q.Gl())) {
        this.nUq.setEnabled(false);
      }
      this.dnn.notifyDataSetChanged();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.username = q.Gk();
    if (bk.bl(this.username)) {
      this.username = q.Gj();
    }
    this.dnn = this.vdd;
    this.iKA = q.Go();
    this.nTP = q.Gp();
    initView();
    setBackBtn(new SettingsHideUsernameUI.1(this));
  }
  
  protected void onPause()
  {
    int j = 0;
    int i = 1;
    super.onPause();
    y.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[] { Boolean.valueOf(this.gPg) });
    if ((this.iKA & 0x4000) != 0L) {
      j = 1;
    }
    if (j != this.gPg)
    {
      if (!this.gPg) {
        break label184;
      }
      this.iKA |= 0x4000;
    }
    for (this.nTP |= 0x200;; this.nTP &= 0xFFFFFDFF)
    {
      g.DQ();
      g.DP().Dz().o(147457, Long.valueOf(this.iKA));
      g.DQ();
      g.DP().Dz().o(40, Integer.valueOf(this.nTP));
      zr localzr = new zr();
      localzr.sYS = 46;
      if (this.gPg) {
        i = 2;
      }
      localzr.nfn = i;
      ((j)g.r(j.class)).Fv().b(new i.a(23, localzr));
      return;
      label184:
      this.iKA &= 0xFFFFBFFF;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    bza();
  }
  
  public final int xj()
  {
    return a.k.settings_hide_username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI
 * JD-Core Version:    0.7.0.1
 */