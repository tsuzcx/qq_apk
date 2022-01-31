package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI
  extends MMPreference
{
  private boolean bFk = false;
  private com.tencent.mm.ui.base.preference.f dnn;
  private Preference hNl;
  private Preference hNm;
  private int nTI;
  private int nTJ;
  private int nTK;
  private int nTL;
  private boolean nTM = false;
  private final TimePickerDialog.OnTimeSetListener nTN = new SettingsActiveTimeUI.2(this);
  
  private static String c(Context paramContext, int paramInt1, int paramInt2)
  {
    String str1 = x.e(paramContext.getSharedPreferences(ae.cqR(), 0));
    String str2 = x.cqJ();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2)))) {
      return DateFormat.getTimeInstance(3, x.Zi(str1)).format(new Time(paramInt1, paramInt2, 0));
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1) {
      return com.tencent.mm.pluginsdk.f.h.p(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("settings_active_begin_time"))
    {
      this.nTM = true;
      showDialog(1);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_end_time"))
    {
      this.nTM = false;
      showDialog(1);
      return true;
    }
    if (paramPreference.mKey.equals("settings_active_silence_time"))
    {
      paramf = (CheckBoxPreference)this.dnn.add("settings_active_silence_time");
      boolean bool;
      if (!paramf.isChecked())
      {
        bool = true;
        com.tencent.mm.m.f.bA(bool);
        paramPreference = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!paramf.isChecked()) {
          break label140;
        }
      }
      label140:
      for (int i = 1;; i = 2)
      {
        paramPreference.f(11351, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        initView();
        return true;
        bool = false;
        break;
      }
    }
    return false;
  }
  
  protected final void initView()
  {
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(a.k.settings_pref_active_time);
    this.hNm = this.dnn.add("settings_active_begin_time");
    this.nTI = com.tencent.mm.m.f.zY();
    this.nTJ = com.tencent.mm.m.f.Aa();
    this.hNm.setSummary(c(this, this.nTI, this.nTJ));
    this.hNl = this.dnn.add("settings_active_end_time");
    this.nTK = com.tencent.mm.m.f.zX();
    this.nTL = com.tencent.mm.m.f.zZ();
    this.hNl.setSummary(c(this, this.nTK, this.nTL));
    boolean bool;
    if (!com.tencent.mm.m.f.zW())
    {
      bool = true;
      this.bFk = bool;
      ((CheckBoxPreference)this.dnn.add("settings_active_silence_time")).rHo = this.bFk;
      if (!this.bFk) {
        break label248;
      }
      this.hNm.setEnabled(true);
      this.hNl.setEnabled(true);
    }
    for (;;)
    {
      if (!this.bFk)
      {
        this.dnn.c(this.hNm);
        this.dnn.c(this.hNl);
      }
      this.dnn.bJ("settings_active_time_full", true);
      this.dnn.notifyDataSetChanged();
      setBackBtn(new SettingsActiveTimeUI.1(this));
      return;
      bool = false;
      break;
      label248:
      this.hNm.setEnabled(false);
      this.hNl.setEnabled(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.settings_active_time);
    this.dnn = this.vdd;
    initView();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    if (this.nTM) {
      return new TimePickerDialog(this.mController.uMN, this.nTN, this.nTI, this.nTJ, false);
    }
    return new TimePickerDialog(this.mController.uMN, this.nTN, this.nTK, this.nTL, false);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    as.hO(2);
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.nTM)
    {
      ((TimePickerDialog)paramDialog).updateTime(this.nTI, this.nTJ);
      return;
    }
    ((TimePickerDialog)paramDialog).updateTime(this.nTK, this.nTL);
  }
  
  public final int xj()
  {
    return a.k.settings_pref_active_time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI
 * JD-Core Version:    0.7.0.1
 */