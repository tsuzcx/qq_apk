package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.c;
import org.xwalk.core.XWalkEnvironment;

public class SettingDarkMode
  extends MMPreference
{
  private boolean fTY;
  private int loK = 0;
  private boolean qhl = false;
  private int rXG = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean wfc;
  private SelectPreference wfd;
  private SelectPreference wfe;
  private int wff = 0;
  private boolean wfg;
  private boolean wfh;
  
  private void dnJ()
  {
    AppMethodBeat.i(186535);
    if (this.qhl)
    {
      if (ai.eRZ())
      {
        ax.aFC(aj.eFD()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(186535);
        return;
      }
      h.vKh.f(18893, new Object[] { Integer.valueOf(this.loK), Integer.valueOf(this.wff), Integer.valueOf(1), Integer.valueOf(this.rXG) });
      ad.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.loK), Integer.valueOf(this.wff), Integer.valueOf(this.rXG) });
    }
    AppMethodBeat.o(186535);
  }
  
  private void pn(boolean paramBoolean)
  {
    AppMethodBeat.i(186532);
    this.screen.cE("manual_title", paramBoolean);
    this.screen.cE("dark_mode", paramBoolean);
    this.screen.cE("normal_mode", paramBoolean);
    AppMethodBeat.o(186532);
  }
  
  public int getResourceId()
  {
    return 2131951714;
  }
  
  public void initView()
  {
    AppMethodBeat.i(186531);
    setMMTitle(getString(2131763205));
    this.screen = getPreferenceScreen();
    this.fTY = ai.Eq();
    this.wfg = this.fTY;
    ax.aFC(aj.eFD()).putBoolean("dark_mode_follow_system_need_report", false);
    this.wfc = ax.aFC(aj.eFD()).getBoolean("dark_mode_follow_system", false);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aKk("follow_system");
    this.wfd = ((SelectPreference)this.screen.aKk("dark_mode"));
    this.wfe = ((SelectPreference)this.screen.aKk("normal_mode"));
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.lG = this.wfc;
      localCheckBoxPreference.vP(this.wfc);
      localCheckBoxPreference.GfV = false;
    }
    if (this.wfc) {
      pn(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(186527);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(186527);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(186528);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(186528);
          return true;
        }
      }, null, r.b.FOB);
      AppMethodBeat.o(186531);
      return;
      pn(false);
      if (this.fTY)
      {
        this.wfd.ira = true;
        this.wfe.ira = false;
      }
      else
      {
        this.wfe.ira = true;
        this.wfd.ira = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186530);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(186530);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(186534);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(186534);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(186534);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(186533);
    String str = paramPreference.mKey;
    this.qhl = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.loK = 4;
        if (ai.j(getResources()))
        {
          i = 1;
          this.wff = i;
          this.rXG = 1;
          this.wfh = true;
          pn(true);
        }
      }
      for (;;)
      {
        this.wfg = this.fTY;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(186533);
        return false;
        i = 0;
        break;
        this.loK = 4;
        if (this.fTY) {}
        for (i = 1;; i = 0)
        {
          this.wff = i;
          this.rXG = 2;
          this.wfh = false;
          pn(false);
          if (!this.fTY) {
            break label168;
          }
          this.wfd.ira = true;
          this.wfe.ira = false;
          break;
        }
        label168:
        this.wfe.ira = true;
        this.wfd.ira = false;
      }
    }
    boolean bool = this.fTY;
    if (str.equals("dark_mode"))
    {
      this.wfd.ira = true;
      this.wfe.ira = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.loK = 4;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.wff = i;
      this.rXG = 2;
      this.wfg = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.wfd.ira = false;
      this.wfe.ira = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode
 * JD-Core Version:    0.7.0.1
 */