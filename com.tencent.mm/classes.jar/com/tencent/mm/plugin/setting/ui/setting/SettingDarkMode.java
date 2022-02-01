package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.c;
import org.xwalk.core.XWalkEnvironment;

public class SettingDarkMode
  extends MMPreference
{
  private SelectPreference CZO;
  private SelectPreference CZP;
  private int CZQ = 0;
  private boolean CZR;
  private boolean CZS;
  private boolean crv;
  private boolean hfZ;
  private int nGn = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean thE = false;
  private int xGO = 0;
  
  private void eSQ()
  {
    AppMethodBeat.i(256493);
    h localh;
    int j;
    int k;
    int m;
    if (this.thE)
    {
      if (ao.awS())
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(256493);
        return;
      }
      if (this.CZS != this.hfZ) {
        this.nGn = 4;
      }
      localh = h.CyF;
      j = this.nGn;
      k = this.CZQ;
      m = this.xGO;
      if (!ao.awN()) {
        break label186;
      }
    }
    label186:
    for (int i = 1;; i = 0)
    {
      localh.a(18893, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(2), Integer.valueOf(m), Integer.valueOf(i) });
      Log.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.nGn), Integer.valueOf(this.CZQ), Integer.valueOf(this.xGO) });
      AppMethodBeat.o(256493);
      return;
    }
  }
  
  private void up(boolean paramBoolean)
  {
    AppMethodBeat.i(256490);
    if (!ao.awN()) {
      this.screen.jdMethod_do("manual_title", true);
    }
    for (;;)
    {
      this.screen.jdMethod_do("dark_mode", paramBoolean);
      this.screen.jdMethod_do("normal_mode", paramBoolean);
      AppMethodBeat.o(256490);
      return;
      this.screen.jdMethod_do("manual_title", paramBoolean);
    }
  }
  
  public int getResourceId()
  {
    return 2132017259;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256489);
    setMMTitle(getString(2131765373));
    this.screen = getPreferenceScreen();
    if (!ao.awN())
    {
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", false);
      ao.gJU();
    }
    this.crv = ao.isDarkMode();
    this.CZR = this.crv;
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", false);
    this.hfZ = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system", false);
    this.CZS = this.hfZ;
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bmg("follow_system");
    this.CZO = ((SelectPreference)this.screen.bmg("dark_mode"));
    this.CZP = ((SelectPreference)this.screen.bmg("normal_mode"));
    if (!ao.awN())
    {
      this.screen.jdMethod_do("follow_system", true);
      this.screen.jdMethod_do("manual_title", true);
      if (!this.hfZ) {
        break label270;
      }
      up(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(256485);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(256485);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(256486);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(256486);
          return true;
        }
      }, null, t.b.OGU);
      AppMethodBeat.o(256489);
      return;
      if (localCheckBoxPreference == null) {
        break;
      }
      localCheckBoxPreference.setChecked(this.hfZ);
      localCheckBoxPreference.xZ(this.hfZ);
      localCheckBoxPreference.OZw = false;
      break;
      label270:
      up(false);
      if (this.crv)
      {
        this.CZO.isSelected = true;
        this.CZP.isSelected = false;
      }
      else
      {
        this.CZP.isSelected = true;
        this.CZO.isSelected = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256488);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(256488);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(256492);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(256492);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(256492);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(256491);
    String str = paramPreference.mKey;
    this.thE = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.nGn = 4;
        if (ao.f(getResources()))
        {
          i = 1;
          this.CZQ = i;
          this.xGO = 1;
          this.CZS = true;
          up(true);
        }
      }
      for (;;)
      {
        this.CZR = this.crv;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(256491);
        return false;
        i = 0;
        break;
        this.nGn = 4;
        if (this.crv) {}
        for (i = 1;; i = 0)
        {
          this.CZQ = i;
          this.xGO = 2;
          this.CZS = false;
          up(false);
          if (!this.crv) {
            break label168;
          }
          this.CZO.isSelected = true;
          this.CZP.isSelected = false;
          break;
        }
        label168:
        this.CZP.isSelected = true;
        this.CZO.isSelected = false;
      }
    }
    boolean bool = this.crv;
    if (str.equals("dark_mode"))
    {
      this.CZO.isSelected = true;
      this.CZP.isSelected = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.nGn = 2;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.CZQ = i;
      this.xGO = 2;
      this.CZR = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.CZO.isSelected = false;
      this.CZP.isSelected = true;
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