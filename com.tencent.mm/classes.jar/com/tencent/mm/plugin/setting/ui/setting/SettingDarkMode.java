package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.sns.ui.widget.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.y.b;
import com.tencent.xweb.ao;

public class SettingDarkMode
  extends MMPreference
{
  private boolean Akx = false;
  private int IEZ = 0;
  private SelectPreference PpR;
  private SelectPreference PpS;
  private int PpT = 0;
  private boolean PpU;
  private boolean PpV;
  private boolean ehd;
  private boolean mrb;
  private int rHu = 0;
  private f screen;
  
  private void CF(boolean paramBoolean)
  {
    AppMethodBeat.i(298696);
    if (!aw.aXj()) {
      this.screen.eh("manual_title", true);
    }
    for (;;)
    {
      this.screen.eh("dark_mode", paramBoolean);
      this.screen.eh("normal_mode", paramBoolean);
      AppMethodBeat.o(298696);
      return;
      this.screen.eh("manual_title", paramBoolean);
    }
  }
  
  private void gVi()
  {
    AppMethodBeat.i(298700);
    com.tencent.mm.plugin.report.service.h localh;
    int j;
    int k;
    int m;
    if (this.Akx)
    {
      if (aw.aXo())
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(298700);
        return;
      }
      if (this.PpV != this.mrb) {
        this.rHu = 4;
      }
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      j = this.rHu;
      k = this.PpT;
      m = this.IEZ;
      if (!aw.aXj()) {
        break label186;
      }
    }
    label186:
    for (int i = 1;; i = 0)
    {
      localh.b(18893, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(2), Integer.valueOf(m), Integer.valueOf(i) });
      Log.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.rHu), Integer.valueOf(this.PpT), Integer.valueOf(this.IEZ) });
      AppMethodBeat.o(298700);
      return;
    }
  }
  
  public int getResourceId()
  {
    return b.k.setting_redesign;
  }
  
  public void initView()
  {
    AppMethodBeat.i(298756);
    setMMTitle(getString(b.i.settings_dark_mode));
    this.screen = getPreferenceScreen();
    if (!aw.aXj())
    {
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", false);
      aw.jlk();
    }
    this.ehd = aw.isDarkMode();
    this.PpU = this.ehd;
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", false);
    this.mrb = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system", false);
    this.PpV = this.mrb;
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("follow_system");
    this.PpR = ((SelectPreference)this.screen.bAi("dark_mode"));
    this.PpS = ((SelectPreference)this.screen.bAi("normal_mode"));
    if (!aw.aXj())
    {
      this.screen.eh("follow_system", true);
      this.screen.eh("manual_title", true);
      if (!this.mrb) {
        break label272;
      }
      CF(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(299298);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(299298);
          return true;
        }
      });
      addTextOptionMenu(0, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(299294);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(299294);
          return true;
        }
      }, null, y.b.adEJ);
      AppMethodBeat.o(298756);
      return;
      if (localCheckBoxPreference == null) {
        break;
      }
      localCheckBoxPreference.setChecked(this.mrb);
      localCheckBoxPreference.Hy(this.mrb);
      localCheckBoxPreference.adZV = false;
      break;
      label272:
      CF(false);
      if (this.ehd)
      {
        this.PpR.isSelected = true;
        this.PpS.isSelected = false;
      }
      else
      {
        this.PpS.isSelected = true;
        this.PpR.isSelected = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298746);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(298746);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(298766);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(298766);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(298766);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(298762);
    String str = paramPreference.mKey;
    this.Akx = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.rHu = 4;
        if (aw.f(getResources()))
        {
          i = 1;
          this.PpT = i;
          this.IEZ = 1;
          this.PpV = true;
          CF(true);
        }
      }
      for (;;)
      {
        this.PpU = this.ehd;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(298762);
        return false;
        i = 0;
        break;
        this.rHu = 4;
        if (this.ehd) {}
        for (i = 1;; i = 0)
        {
          this.PpT = i;
          this.IEZ = 2;
          this.PpV = false;
          CF(false);
          if (!this.ehd) {
            break label168;
          }
          this.PpR.isSelected = true;
          this.PpS.isSelected = false;
          break;
        }
        label168:
        this.PpS.isSelected = true;
        this.PpR.isSelected = false;
      }
    }
    boolean bool = this.ehd;
    if (str.equals("dark_mode"))
    {
      this.PpR.isSelected = true;
      this.PpS.isSelected = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.rHu = 2;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.PpT = i;
      this.IEZ = 2;
      this.PpU = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.PpR.isSelected = false;
      this.PpS.isSelected = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode
 * JD-Core Version:    0.7.0.1
 */