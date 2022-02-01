package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.c;
import org.xwalk.core.XWalkEnvironment;

public class SettingDarkMode
  extends MMPreference
{
  private int CKR = 0;
  private SelectPreference Jfp;
  private SelectPreference Jfq;
  private int Jfr = 0;
  private boolean Jfs;
  private boolean Jft;
  private boolean cpt;
  private boolean jRR;
  private int oEk = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean wNV = false;
  
  private void fFU()
  {
    AppMethodBeat.i(263993);
    com.tencent.mm.plugin.report.service.h localh;
    int j;
    int k;
    int m;
    if (this.wNV)
    {
      if (ar.aEk())
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(263993);
        return;
      }
      if (this.Jft != this.jRR) {
        this.oEk = 4;
      }
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      j = this.oEk;
      k = this.Jfr;
      m = this.CKR;
      if (!ar.aEf()) {
        break label186;
      }
    }
    label186:
    for (int i = 1;; i = 0)
    {
      localh.a(18893, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(2), Integer.valueOf(m), Integer.valueOf(i) });
      Log.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.oEk), Integer.valueOf(this.Jfr), Integer.valueOf(this.CKR) });
      AppMethodBeat.o(263993);
      return;
    }
  }
  
  private void xN(boolean paramBoolean)
  {
    AppMethodBeat.i(263988);
    if (!ar.aEf()) {
      this.screen.dz("manual_title", true);
    }
    for (;;)
    {
      this.screen.dz("dark_mode", paramBoolean);
      this.screen.dz("normal_mode", paramBoolean);
      AppMethodBeat.o(263988);
      return;
      this.screen.dz("manual_title", paramBoolean);
    }
  }
  
  public int getResourceId()
  {
    return b.k.setting_redesign;
  }
  
  public void initView()
  {
    AppMethodBeat.i(263986);
    setMMTitle(getString(b.i.settings_dark_mode));
    this.screen = getPreferenceScreen();
    if (!ar.aEf())
    {
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", false);
      ar.hIV();
    }
    this.cpt = ar.isDarkMode();
    this.Jfs = this.cpt;
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", false);
    this.jRR = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system", false);
    this.Jft = this.jRR;
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.byG("follow_system");
    this.Jfp = ((SelectPreference)this.screen.byG("dark_mode"));
    this.Jfq = ((SelectPreference)this.screen.byG("normal_mode"));
    if (!ar.aEf())
    {
      this.screen.dz("follow_system", true);
      this.screen.dz("manual_title", true);
      if (!this.jRR) {
        break label272;
      }
      xN(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(263611);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(263611);
          return true;
        }
      });
      addTextOptionMenu(0, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(264106);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(264106);
          return true;
        }
      }, null, w.b.Wao);
      AppMethodBeat.o(263986);
      return;
      if (localCheckBoxPreference == null) {
        break;
      }
      localCheckBoxPreference.setChecked(this.jRR);
      localCheckBoxPreference.BT(this.jRR);
      localCheckBoxPreference.WsF = false;
      break;
      label272:
      xN(false);
      if (this.cpt)
      {
        this.Jfp.isSelected = true;
        this.Jfq.isSelected = false;
      }
      else
      {
        this.Jfq.isSelected = true;
        this.Jfp.isSelected = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263982);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(263982);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263992);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(263992);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(263992);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(263991);
    String str = paramPreference.mKey;
    this.wNV = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.oEk = 4;
        if (ar.f(getResources()))
        {
          i = 1;
          this.Jfr = i;
          this.CKR = 1;
          this.Jft = true;
          xN(true);
        }
      }
      for (;;)
      {
        this.Jfs = this.cpt;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(263991);
        return false;
        i = 0;
        break;
        this.oEk = 4;
        if (this.cpt) {}
        for (i = 1;; i = 0)
        {
          this.Jfr = i;
          this.CKR = 2;
          this.Jft = false;
          xN(false);
          if (!this.cpt) {
            break label168;
          }
          this.Jfp.isSelected = true;
          this.Jfq.isSelected = false;
          break;
        }
        label168:
        this.Jfq.isSelected = true;
        this.Jfp.isSelected = false;
      }
    }
    boolean bool = this.cpt;
    if (str.equals("dark_mode"))
    {
      this.Jfp.isSelected = true;
      this.Jfq.isSelected = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.oEk = 2;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.Jfr = i;
      this.CKR = 2;
      this.Jfs = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.Jfp.isSelected = false;
      this.Jfq.isSelected = true;
      paramf.notifyDataSetChanged();
      bool = false;
      break label228;
      label295:
      i = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode
 * JD-Core Version:    0.7.0.1
 */