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
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.aj;
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
  private boolean fXS;
  private int lQK = 0;
  private boolean qPN = false;
  private com.tencent.mm.ui.base.preference.f screen;
  private int tfy = 0;
  private boolean xqq;
  private SelectPreference xqr;
  private SelectPreference xqs;
  private int xqt = 0;
  private boolean xqu;
  private boolean xqv;
  
  private void dBQ()
  {
    AppMethodBeat.i(191000);
    if (this.qPN)
    {
      if (aj.fhJ())
      {
        aw.aKT(ai.eUX()).putBoolean("dark_mode_follow_system_need_report", true);
        AppMethodBeat.o(191000);
        return;
      }
      h.wUl.f(18893, new Object[] { Integer.valueOf(this.lQK), Integer.valueOf(this.xqt), Integer.valueOf(1), Integer.valueOf(this.tfy) });
      ac.i("MicroMsg.mmui.MMPreference", "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", new Object[] { Integer.valueOf(18893), Integer.valueOf(this.lQK), Integer.valueOf(this.xqt), Integer.valueOf(this.tfy) });
    }
    AppMethodBeat.o(191000);
  }
  
  private void qm(boolean paramBoolean)
  {
    AppMethodBeat.i(190997);
    this.screen.cK("manual_title", paramBoolean);
    this.screen.cK("dark_mode", paramBoolean);
    this.screen.cK("normal_mode", paramBoolean);
    AppMethodBeat.o(190997);
  }
  
  public int getResourceId()
  {
    return 2131951714;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190996);
    setMMTitle(getString(2131763205));
    this.screen = getPreferenceScreen();
    this.fXS = aj.DT();
    this.xqu = this.fXS;
    aw.aKT(ai.eUX()).putBoolean("dark_mode_follow_system_need_report", false);
    this.xqq = aw.aKT(ai.eUX()).getBoolean("dark_mode_follow_system", false);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aPN("follow_system");
    this.xqr = ((SelectPreference)this.screen.aPN("dark_mode"));
    this.xqs = ((SelectPreference)this.screen.aPN("normal_mode"));
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.mF = this.xqq;
      localCheckBoxPreference.wT(this.xqq);
      localCheckBoxPreference.HFK = false;
    }
    if (this.xqq) {
      qm(true);
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(190992);
          SettingDarkMode.this.finish();
          AppMethodBeat.o(190992);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(190993);
          SettingDarkMode.a(SettingDarkMode.this);
          AppMethodBeat.o(190993);
          return true;
        }
      }, null, s.b.Hom);
      AppMethodBeat.o(190996);
      return;
      qm(false);
      if (this.fXS)
      {
        this.xqr.isSelected = true;
        this.xqs.isSelected = false;
      }
      else
      {
        this.xqs.isSelected = true;
        this.xqr.isSelected = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190995);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(190995);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190999);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(190999);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(190999);
    return bool;
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(190998);
    String str = paramPreference.mKey;
    this.qPN = true;
    if (str.equals("follow_system"))
    {
      if (((CheckBoxPreference)paramPreference).isChecked())
      {
        this.lQK = 4;
        if (aj.j(getResources()))
        {
          i = 1;
          this.xqt = i;
          this.tfy = 1;
          this.xqv = true;
          qm(true);
        }
      }
      for (;;)
      {
        this.xqu = this.fXS;
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(190998);
        return false;
        i = 0;
        break;
        this.lQK = 4;
        if (this.fXS) {}
        for (i = 1;; i = 0)
        {
          this.xqt = i;
          this.tfy = 2;
          this.xqv = false;
          qm(false);
          if (!this.fXS) {
            break label168;
          }
          this.xqr.isSelected = true;
          this.xqs.isSelected = false;
          break;
        }
        label168:
        this.xqs.isSelected = true;
        this.xqr.isSelected = false;
      }
    }
    boolean bool = this.fXS;
    if (str.equals("dark_mode"))
    {
      this.xqr.isSelected = true;
      this.xqs.isSelected = false;
      paramf.notifyDataSetChanged();
      bool = true;
      label228:
      this.lQK = 4;
      if (!bool) {
        break label295;
      }
    }
    for (;;)
    {
      this.xqt = i;
      this.tfy = 2;
      this.xqu = bool;
      break;
      if (!str.equals("normal_mode")) {
        break label228;
      }
      this.xqr.isSelected = false;
      this.xqs.isSelected = true;
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