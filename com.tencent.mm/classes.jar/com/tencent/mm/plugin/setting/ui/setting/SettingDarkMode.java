package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.c;
import org.xwalk.core.XWalkEnvironment;

public class SettingDarkMode
  extends MMPreference
{
  private boolean isDarkMode;
  private int mqA = 0;
  private boolean rzM = false;
  private com.tencent.mm.ui.base.preference.f screen;
  private int udo = 0;
  private boolean yET;
  private SelectPreference yEU;
  private SelectPreference yEV;
  private int yEW = 0;
  private boolean yEX;
  private boolean yEY;
  
  private void dNt()
  {
    AppMethodBeat.i(220963);
    com.tencent.mm.plugin.report.service.g localg;
    int j;
    int k;
    int m;
    if (this.rzM)
    {
      if (al.fxZ())
      {
        ax.aQz(aj.fkC()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(220963);
        return;
      }
      if (this.yEY != this.yET) {
        this.mqA = 4;
      }
      localg = com.tencent.mm.plugin.report.service.g.yhR;
      j = this.mqA;
      k = this.yEW;
      m = this.udo;
      if (!al.fxT()) {
        break label186;
      }
    }
    label186:
    for (int i = 1;; i = 0)
    {
      localg.f(18893, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(2), Integer.valueOf(m), Integer.valueOf(i) });
      ad.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.mqA), Integer.valueOf(this.yEW), Integer.valueOf(this.udo) });
      AppMethodBeat.o(220963);
      return;
    }
  }
  
  private void qN(boolean paramBoolean)
  {
    AppMethodBeat.i(220960);
    if (!al.fxT()) {
      this.screen.cP("manual_title", true);
    }
    for (;;)
    {
      this.screen.cP("dark_mode", paramBoolean);
      this.screen.cP("normal_mode", paramBoolean);
      AppMethodBeat.o(220960);
      return;
      this.screen.cP("manual_title", paramBoolean);
    }
  }
  
  public int getResourceId()
  {
    return 2131951714;
  }
  
  public void initView()
  {
    AppMethodBeat.i(220959);
    setMMTitle(getString(2131763205));
    this.screen = getPreferenceScreen();
    if (!al.fxT())
    {
      ax.aQz(aj.fkC()).putBoolean("dark_mode_follow_system", false);
      al.fya();
    }
    this.isDarkMode = al.isDarkMode();
    this.yEX = this.isDarkMode;
    ax.aQz(aj.fkC()).putBoolean("dark_mode_follow_system_need_report", false);
    this.yET = ax.aQz(aj.fkC()).getBoolean("dark_mode_follow_system", false);
    this.yEY = this.yET;
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aVD("follow_system");
    this.yEU = ((SelectPreference)this.screen.aVD("dark_mode"));
    this.yEV = ((SelectPreference)this.screen.aVD("normal_mode"));
    if (!al.fxT())
    {
      this.screen.cP("follow_system", true);
      this.screen.cP("manual_title", true);
      if (!this.yET) {
        break label270;
      }
      qN(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(220955);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(220955);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(220956);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(220956);
          return true;
        }
      }, null, s.b.JbS);
      AppMethodBeat.o(220959);
      return;
      if (localCheckBoxPreference == null) {
        break;
      }
      localCheckBoxPreference.oB = this.yET;
      localCheckBoxPreference.xE(this.yET);
      localCheckBoxPreference.JtB = false;
      break;
      label270:
      qN(false);
      if (this.isDarkMode)
      {
        this.yEU.isSelected = true;
        this.yEV.isSelected = false;
      }
      else
      {
        this.yEV.isSelected = true;
        this.yEU.isSelected = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(220958);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(220958);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(220962);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(220962);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(220962);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(220961);
    String str = paramPreference.mKey;
    this.rzM = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.mqA = 4;
        if (al.j(getResources()))
        {
          i = 1;
          this.yEW = i;
          this.udo = 1;
          this.yEY = true;
          qN(true);
        }
      }
      for (;;)
      {
        this.yEX = this.isDarkMode;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(220961);
        return false;
        i = 0;
        break;
        this.mqA = 4;
        if (this.isDarkMode) {}
        for (i = 1;; i = 0)
        {
          this.yEW = i;
          this.udo = 2;
          this.yEY = false;
          qN(false);
          if (!this.isDarkMode) {
            break label168;
          }
          this.yEU.isSelected = true;
          this.yEV.isSelected = false;
          break;
        }
        label168:
        this.yEV.isSelected = true;
        this.yEU.isSelected = false;
      }
    }
    boolean bool = this.isDarkMode;
    if (str.equals("dark_mode"))
    {
      this.yEU.isSelected = true;
      this.yEV.isSelected = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.mqA = 2;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.yEW = i;
      this.udo = 2;
      this.yEX = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.yEU.isSelected = false;
      this.yEV.isSelected = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode
 * JD-Core Version:    0.7.0.1
 */