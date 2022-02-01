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
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI
  extends MMPreference
{
  private boolean isActive;
  private Preference nai;
  private Preference naj;
  private com.tencent.mm.ui.base.preference.f screen;
  private final TimePickerDialog.OnTimeSetListener xrA;
  private int xrv;
  private int xrw;
  private int xrx;
  private int xry;
  private boolean xrz;
  
  public SettingsActiveTimeUI()
  {
    AppMethodBeat.i(74088);
    this.xrz = false;
    this.isActive = false;
    this.xrA = new TimePickerDialog.OnTimeSetListener()
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
    String str1 = ab.g(paramContext.getSharedPreferences(ai.eUX(), 0));
    String str2 = ab.eUO();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, ab.aKK(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(74094);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = com.tencent.mm.pluginsdk.g.h.u(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
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
    this.naj = this.screen.aPN("settings_active_begin_time");
    this.xrv = com.tencent.mm.m.f.Zy();
    this.xrw = com.tencent.mm.m.f.ZA();
    this.naj.setSummary(h(this, this.xrv, this.xrw));
    this.nai = this.screen.aPN("settings_active_end_time");
    this.xrx = com.tencent.mm.m.f.Zx();
    this.xry = com.tencent.mm.m.f.Zz();
    this.nai.setSummary(h(this, this.xrx, this.xry));
    boolean bool;
    if (!com.tencent.mm.m.f.Zw())
    {
      bool = true;
      this.isActive = bool;
      ((CheckBoxPreference)this.screen.aPN("settings_active_silence_time")).mF = this.isActive;
      if (!this.isActive) {
        break label258;
      }
      this.naj.setEnabled(true);
      this.nai.setEnabled(true);
    }
    for (;;)
    {
      if (!this.isActive)
      {
        this.screen.d(this.naj);
        this.screen.d(this.nai);
      }
      this.screen.cK("settings_active_time_full", true);
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
      this.naj.setEnabled(false);
      this.nai.setEnabled(false);
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
    if (this.xrz)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.xrA, this.xrv, this.xrw, false);
      AppMethodBeat.o(74092);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.xrA, this.xrx, this.xry, false);
    AppMethodBeat.o(74092);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74095);
    super.onDestroy();
    ax.nU(2);
    AppMethodBeat.o(74095);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74091);
    if (paramPreference.mKey.equals("settings_active_begin_time"))
    {
      this.xrz = true;
      showDialog(1);
      AppMethodBeat.o(74091);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_end_time"))
    {
      this.xrz = false;
      showDialog(1);
      AppMethodBeat.o(74091);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_silence_time"))
    {
      paramf = (CheckBoxPreference)this.screen.aPN("settings_active_silence_time");
      boolean bool;
      if (!paramf.isChecked())
      {
        bool = true;
        com.tencent.mm.m.f.cX(bool);
        PluginNotification.createActiveTimeNotification();
        paramPreference = com.tencent.mm.plugin.report.service.h.wUl;
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
    if (this.xrz)
    {
      ((TimePickerDialog)paramDialog).updateTime(this.xrv, this.xrw);
      AppMethodBeat.o(74093);
      return;
    }
    ((TimePickerDialog)paramDialog).updateTime(this.xrx, this.xry);
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