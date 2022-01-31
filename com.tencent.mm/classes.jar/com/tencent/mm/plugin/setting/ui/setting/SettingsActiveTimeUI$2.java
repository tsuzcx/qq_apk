package com.tencent.mm.plugin.setting.ui.setting;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;

final class SettingsActiveTimeUI$2
  implements TimePickerDialog.OnTimeSetListener
{
  SettingsActiveTimeUI$2(SettingsActiveTimeUI paramSettingsActiveTimeUI) {}
  
  public final void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    if (SettingsActiveTimeUI.a(this.nTO))
    {
      SettingsActiveTimeUI.a(this.nTO, paramInt1);
      SettingsActiveTimeUI.b(this.nTO, paramInt2);
      SettingsActiveTimeUI.b(this.nTO);
    }
    for (;;)
    {
      this.nTO.initView();
      return;
      SettingsActiveTimeUI.c(this.nTO, paramInt1);
      SettingsActiveTimeUI.d(this.nTO, paramInt2);
      SettingsActiveTimeUI.c(this.nTO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI.2
 * JD-Core Version:    0.7.0.1
 */