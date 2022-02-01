package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI
  extends MMPreference
{
  private boolean isActive;
  private Preference nAF;
  private Preference nAG;
  private com.tencent.mm.ui.base.preference.f screen;
  private int yGe;
  private int yGf;
  private int yGg;
  private int yGh;
  private boolean yGi;
  private final TimePickerDialog.OnTimeSetListener yGj;
  
  public SettingsActiveTimeUI()
  {
    AppMethodBeat.i(74088);
    this.yGi = false;
    this.isActive = false;
    this.yGj = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(74087);
        if (SettingsActiveTimeUI.a(SettingsActiveTimeUI.this))
        {
          SettingsActiveTimeUI.a(SettingsActiveTimeUI.this, paramAnonymousInt1);
          SettingsActiveTimeUI.b(SettingsActiveTimeUI.this, paramAnonymousInt2);
          SettingsActiveTimeUI.b(SettingsActiveTimeUI.this);
        }
        for (;;)
        {
          SettingsActiveTimeUI.this.initView();
          AppMethodBeat.o(74087);
          return;
          SettingsActiveTimeUI.c(SettingsActiveTimeUI.this, paramAnonymousInt1);
          SettingsActiveTimeUI.d(SettingsActiveTimeUI.this, paramAnonymousInt2);
          SettingsActiveTimeUI.c(SettingsActiveTimeUI.this);
        }
      }
    };
    AppMethodBeat.o(74088);
  }
  
  private static String h(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74094);
    String str1 = ac.g(paramContext.getSharedPreferences(aj.fkC(), 0));
    String str2 = ac.fks();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, ac.aQq(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(74094);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = i.u(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(74094);
      return paramContext;
    }
  }
  
  public int getResourceId()
  {
    return 2131951724;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74090);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951724);
    this.nAG = this.screen.aVD("settings_active_begin_time");
    this.yGe = com.tencent.mm.n.f.abY();
    this.yGf = com.tencent.mm.n.f.aca();
    this.nAG.setSummary(h(this, this.yGe, this.yGf));
    this.nAF = this.screen.aVD("settings_active_end_time");
    this.yGg = com.tencent.mm.n.f.abX();
    this.yGh = com.tencent.mm.n.f.abZ();
    this.nAF.setSummary(h(this, this.yGg, this.yGh));
    boolean bool;
    if (!com.tencent.mm.n.f.abW())
    {
      bool = true;
      this.isActive = bool;
      ((CheckBoxPreference)this.screen.aVD("settings_active_silence_time")).oB = this.isActive;
      if (!this.isActive) {
        break label258;
      }
      this.nAG.setEnabled(true);
      this.nAF.setEnabled(true);
    }
    for (;;)
    {
      if (!this.isActive)
      {
        this.screen.d(this.nAG);
        this.screen.d(this.nAF);
      }
      this.screen.cP("settings_active_time_full", true);
      this.screen.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74086);
          SettingsActiveTimeUI.this.hideVKB();
          SettingsActiveTimeUI.this.finish();
          AppMethodBeat.o(74086);
          return true;
        }
      });
      AppMethodBeat.o(74090);
      return;
      bool = false;
      break;
      label258:
      this.nAG.setEnabled(false);
      this.nAF.setEnabled(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74089);
    super.onCreate(paramBundle);
    setMMTitle(2131763164);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(74089);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(74092);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(74092);
      return null;
    }
    if (this.yGi)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.yGj, this.yGe, this.yGf, false);
      AppMethodBeat.o(74092);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.yGj, this.yGg, this.yGh, false);
    AppMethodBeat.o(74092);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74095);
    super.onDestroy();
    ay.ou(2);
    AppMethodBeat.o(74095);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74091);
    if (paramPreference.mKey.equals("settings_active_begin_time"))
    {
      this.yGi = true;
      showDialog(1);
      AppMethodBeat.o(74091);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_end_time"))
    {
      this.yGi = false;
      showDialog(1);
      AppMethodBeat.o(74091);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_silence_time"))
    {
      paramf = (CheckBoxPreference)this.screen.aVD("settings_active_silence_time");
      boolean bool;
      if (!paramf.isChecked())
      {
        bool = true;
        com.tencent.mm.n.f.cZ(bool);
        PluginNotification.createActiveTimeNotification();
        paramPreference = g.yhR;
        if (!paramf.isChecked()) {
          break label167;
        }
      }
      label167:
      for (int i = 1;; i = 2)
      {
        paramPreference.f(11351, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        initView();
        AppMethodBeat.o(74091);
        return true;
        bool = false;
        break;
      }
    }
    AppMethodBeat.o(74091);
    return false;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    AppMethodBeat.i(74093);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(74093);
      return;
    }
    if (this.yGi)
    {
      ((TimePickerDialog)paramDialog).updateTime(this.yGe, this.yGf);
      AppMethodBeat.o(74093);
      return;
    }
    ((TimePickerDialog)paramDialog).updateTime(this.yGg, this.yGh);
    AppMethodBeat.o(74093);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI
 * JD-Core Version:    0.7.0.1
 */