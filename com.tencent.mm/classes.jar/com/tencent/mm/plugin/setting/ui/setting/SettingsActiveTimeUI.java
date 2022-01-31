package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI
  extends MMPreference
{
  private boolean isActive;
  private Preference jGO;
  private Preference jGP;
  private int qHI;
  private int qHJ;
  private int qHK;
  private int qHL;
  private boolean qHM;
  private final TimePickerDialog.OnTimeSetListener qHN;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public SettingsActiveTimeUI()
  {
    AppMethodBeat.i(127156);
    this.qHM = false;
    this.isActive = false;
    this.qHN = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(127155);
        if (SettingsActiveTimeUI.a(SettingsActiveTimeUI.this))
        {
          SettingsActiveTimeUI.a(SettingsActiveTimeUI.this, paramAnonymousInt1);
          SettingsActiveTimeUI.b(SettingsActiveTimeUI.this, paramAnonymousInt2);
          SettingsActiveTimeUI.b(SettingsActiveTimeUI.this);
        }
        for (;;)
        {
          SettingsActiveTimeUI.this.initView();
          AppMethodBeat.o(127155);
          return;
          SettingsActiveTimeUI.c(SettingsActiveTimeUI.this, paramAnonymousInt1);
          SettingsActiveTimeUI.d(SettingsActiveTimeUI.this, paramAnonymousInt2);
          SettingsActiveTimeUI.c(SettingsActiveTimeUI.this);
        }
      }
    };
    AppMethodBeat.o(127156);
  }
  
  private static String d(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127162);
    String str1 = aa.g(paramContext.getSharedPreferences(ah.dsP(), 0));
    String str2 = aa.dsG();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, aa.apg(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(127162);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = com.tencent.mm.pluginsdk.f.h.r(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(127162);
      return paramContext;
    }
  }
  
  public int getResourceId()
  {
    return 2131165280;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127164);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165280);
    this.jGP = this.screen.atx("settings_active_begin_time");
    this.qHI = com.tencent.mm.m.f.MO();
    this.qHJ = com.tencent.mm.m.f.MQ();
    this.jGP.setSummary(d(this, this.qHI, this.qHJ));
    this.jGO = this.screen.atx("settings_active_end_time");
    this.qHK = com.tencent.mm.m.f.MN();
    this.qHL = com.tencent.mm.m.f.MP();
    this.jGO.setSummary(d(this, this.qHK, this.qHL));
    boolean bool;
    if (!com.tencent.mm.m.f.MM())
    {
      bool = true;
      this.isActive = bool;
      ((CheckBoxPreference)this.screen.atx("settings_active_silence_time")).vxW = this.isActive;
      if (!this.isActive) {
        break label257;
      }
      this.jGP.setEnabled(true);
      this.jGO.setEnabled(true);
    }
    for (;;)
    {
      if (!this.isActive)
      {
        this.screen.d(this.jGP);
        this.screen.d(this.jGO);
      }
      this.screen.cl("settings_active_time_full", true);
      this.screen.notifyDataSetChanged();
      setBackBtn(new SettingsActiveTimeUI.1(this));
      AppMethodBeat.o(127164);
      return;
      bool = false;
      break;
      label257:
      this.jGP.setEnabled(false);
      this.jGO.setEnabled(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127157);
    super.onCreate(paramBundle);
    setMMTitle(2131303197);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(127157);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(127160);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(127160);
      return null;
    }
    if (this.qHM)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.qHN, this.qHI, this.qHJ, false);
      AppMethodBeat.o(127160);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.qHN, this.qHK, this.qHL, false);
    AppMethodBeat.o(127160);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127165);
    super.onDestroy();
    au.kA(2);
    AppMethodBeat.o(127165);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127159);
    if (paramPreference.mKey.equals("settings_active_begin_time"))
    {
      this.qHM = true;
      showDialog(1);
      AppMethodBeat.o(127159);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_end_time"))
    {
      this.qHM = false;
      showDialog(1);
      AppMethodBeat.o(127159);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_silence_time"))
    {
      paramf = (CheckBoxPreference)this.screen.atx("settings_active_silence_time");
      boolean bool;
      if (!paramf.isChecked())
      {
        bool = true;
        com.tencent.mm.m.f.cc(bool);
        PluginNotification.createActiveTimeNotification();
        paramPreference = com.tencent.mm.plugin.report.service.h.qsU;
        if (!paramf.isChecked()) {
          break label167;
        }
      }
      label167:
      for (int i = 1;; i = 2)
      {
        paramPreference.e(11351, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        initView();
        AppMethodBeat.o(127159);
        return true;
        bool = false;
        break;
      }
    }
    AppMethodBeat.o(127159);
    return false;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    AppMethodBeat.i(127161);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(127161);
      return;
    }
    if (this.qHM)
    {
      ((TimePickerDialog)paramDialog).updateTime(this.qHI, this.qHJ);
      AppMethodBeat.o(127161);
      return;
    }
    ((TimePickerDialog)paramDialog).updateTime(this.qHK, this.qHL);
    AppMethodBeat.o(127161);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI
 * JD-Core Version:    0.7.0.1
 */