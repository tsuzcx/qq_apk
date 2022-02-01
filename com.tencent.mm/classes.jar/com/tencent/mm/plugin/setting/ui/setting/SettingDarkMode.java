package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
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
  private boolean gtO;
  private int mvy = 0;
  private boolean rHX = false;
  private com.tencent.mm.ui.base.preference.f screen;
  private int uow = 0;
  private boolean yUY;
  private SelectPreference yUZ;
  private SelectPreference yVa;
  private int yVb = 0;
  private boolean yVc;
  private boolean yVd;
  
  private void dQP()
  {
    AppMethodBeat.i(190325);
    com.tencent.mm.plugin.report.service.g localg;
    int j;
    int k;
    int m;
    if (this.rHX)
    {
      if (al.fCb())
      {
        ay.aRW(ak.fow()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(190325);
        return;
      }
      if (this.yVd != this.yUY) {
        this.mvy = 4;
      }
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      j = this.mvy;
      k = this.yVb;
      m = this.uow;
      if (!al.fBV()) {
        break label186;
      }
    }
    label186:
    for (int i = 1;; i = 0)
    {
      localg.f(18893, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(2), Integer.valueOf(m), Integer.valueOf(i) });
      ae.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.mvy), Integer.valueOf(this.yVb), Integer.valueOf(this.uow) });
      AppMethodBeat.o(190325);
      return;
    }
  }
  
  private void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(190322);
    if (!al.fBV()) {
      this.screen.cT("manual_title", true);
    }
    for (;;)
    {
      this.screen.cT("dark_mode", paramBoolean);
      this.screen.cT("normal_mode", paramBoolean);
      AppMethodBeat.o(190322);
      return;
      this.screen.cT("manual_title", paramBoolean);
    }
  }
  
  public int getResourceId()
  {
    return 2131951714;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190321);
    setMMTitle(getString(2131763205));
    this.screen = getPreferenceScreen();
    if (!al.fBV())
    {
      ay.aRW(ak.fow()).putBoolean("dark_mode_follow_system", false);
      al.fCc();
    }
    this.gtO = al.isDarkMode();
    this.yVc = this.gtO;
    ay.aRW(ak.fow()).putBoolean("dark_mode_follow_system_need_report", false);
    this.yUY = ay.aRW(ak.fow()).getBoolean("dark_mode_follow_system", false);
    this.yVd = this.yUY;
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aXe("follow_system");
    this.yUZ = ((SelectPreference)this.screen.aXe("dark_mode"));
    this.yVa = ((SelectPreference)this.screen.aXe("normal_mode"));
    if (!al.fBV())
    {
      this.screen.cT("follow_system", true);
      this.screen.cT("manual_title", true);
      if (!this.yUY) {
        break label270;
      }
      qU(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(190317);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(190317);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(190318);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(190318);
          return true;
        }
      }, null, s.b.JwA);
      AppMethodBeat.o(190321);
      return;
      if (localCheckBoxPreference == null) {
        break;
      }
      localCheckBoxPreference.setChecked(this.yUY);
      localCheckBoxPreference.uo(this.yUY);
      localCheckBoxPreference.JOq = false;
      break;
      label270:
      qU(false);
      if (this.gtO)
      {
        this.yUZ.isSelected = true;
        this.yVa.isSelected = false;
      }
      else
      {
        this.yVa.isSelected = true;
        this.yUZ.isSelected = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190320);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(190320);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190324);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(190324);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(190324);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(190323);
    String str = paramPreference.mKey;
    this.rHX = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.mvy = 4;
        if (al.j(getResources()))
        {
          i = 1;
          this.yVb = i;
          this.uow = 1;
          this.yVd = true;
          qU(true);
        }
      }
      for (;;)
      {
        this.yVc = this.gtO;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(190323);
        return false;
        i = 0;
        break;
        this.mvy = 4;
        if (this.gtO) {}
        for (i = 1;; i = 0)
        {
          this.yVb = i;
          this.uow = 2;
          this.yVd = false;
          qU(false);
          if (!this.gtO) {
            break label168;
          }
          this.yUZ.isSelected = true;
          this.yVa.isSelected = false;
          break;
        }
        label168:
        this.yVa.isSelected = true;
        this.yUZ.isSelected = false;
      }
    }
    boolean bool = this.gtO;
    if (str.equals("dark_mode"))
    {
      this.yUZ.isSelected = true;
      this.yVa.isSelected = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.mvy = 2;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.yVb = i;
      this.uow = 2;
      this.yVc = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.yUZ.isSelected = false;
      this.yVa.isSelected = true;
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