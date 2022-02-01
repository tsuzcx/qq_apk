package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI
  extends MMPreference
{
  private final TimePickerDialog.OnTimeSetListener PrA;
  private int Prv;
  private int Prw;
  private int Prx;
  private int Pry;
  private boolean Prz;
  private boolean isActive;
  private com.tencent.mm.ui.base.preference.f screen;
  private Preference vel;
  private Preference vem;
  
  public SettingsActiveTimeUI()
  {
    AppMethodBeat.i(74088);
    this.Prz = false;
    this.isActive = false;
    this.PrA = new TimePickerDialog.OnTimeSetListener()
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
  
  private static String n(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74094);
    String str1 = LocaleUtil.loadApplicationLanguageSettings(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str2 = LocaleUtil.getApplicationLanguage();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, LocaleUtil.transLanguageToLocale(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(74094);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = com.tencent.mm.pluginsdk.platformtools.f.A(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(74094);
      return paramContext;
    }
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_active_time;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74090);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.aBe(b.k.settings_pref_active_time);
    boolean bool;
    if (!com.tencent.mm.k.h.aQX())
    {
      bool = true;
      this.isActive = bool;
      ((CheckBoxPreference)this.screen.bAi("settings_active_silence_time")).setChecked(this.isActive);
      this.vem = this.screen.bAi("settings_active_begin_time");
      this.Prv = com.tencent.mm.k.h.aQZ();
      this.Prw = com.tencent.mm.k.h.aRb();
      this.vem.aS(n(this, this.Prv, this.Prw));
      this.vel = this.screen.bAi("settings_active_end_time");
      this.Prx = com.tencent.mm.k.h.aQY();
      this.Pry = com.tencent.mm.k.h.aRa();
      this.vel.aS(n(this, this.Prx, this.Pry));
      if (!this.isActive) {
        break label242;
      }
      this.vem.setEnabled(true);
      this.vel.setEnabled(true);
    }
    for (;;)
    {
      if (!this.isActive)
      {
        this.screen.e(this.vem);
        this.screen.e(this.vel);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74090);
      return;
      bool = false;
      break;
      label242:
      this.vem.setEnabled(false);
      this.vel.setEnabled(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74089);
    super.onCreate(paramBundle);
    setMMTitle(b.i.settings_active_time);
    initView();
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
    if (this.Prz)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.PrA, this.Prv, this.Prw, false);
      AppMethodBeat.o(74092);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.PrA, this.Prx, this.Pry, false);
    AppMethodBeat.o(74092);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74095);
    super.onDestroy();
    bf.vg(2);
    AppMethodBeat.o(74095);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74091);
    if (paramPreference.mKey.equals("settings_active_begin_time"))
    {
      this.Prz = true;
      showDialog(1);
      AppMethodBeat.o(74091);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_end_time"))
    {
      this.Prz = false;
      showDialog(1);
      AppMethodBeat.o(74091);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_silence_time"))
    {
      paramf = (CheckBoxPreference)this.screen.bAi("settings_active_silence_time");
      boolean bool;
      if (!paramf.isChecked())
      {
        bool = true;
        com.tencent.mm.k.h.eW(bool);
        PluginNotification.createActiveTimeNotification();
        paramPreference = com.tencent.mm.plugin.report.service.h.OAn;
        if (!paramf.isChecked()) {
          break label167;
        }
      }
      label167:
      for (int i = 1;; i = 2)
      {
        paramPreference.b(11351, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
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
    if (this.Prz)
    {
      ((TimePickerDialog)paramDialog).updateTime(this.Prv, this.Prw);
      AppMethodBeat.o(74093);
      return;
    }
    ((TimePickerDialog)paramDialog).updateTime(this.Prx, this.Pry);
    AppMethodBeat.o(74093);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI
 * JD-Core Version:    0.7.0.1
 */