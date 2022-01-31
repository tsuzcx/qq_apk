package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.m.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsRingtoneUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsRingtoneUI$2(SettingsRingtoneUI paramSettingsRingtoneUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    SharedPreferences.Editor localEditor = this.nVG.getSharedPreferences(ae.cqR(), 0).edit();
    if (SettingsRingtoneUI.a(this.nVG) != 0)
    {
      Object localObject = SettingsRingtoneUI.a(this.nVG, SettingsRingtoneUI.a(this.nVG));
      y.d("RingtonePickerActivity", "set ringtone to " + localObject);
      if (localObject != null)
      {
        paramMenuItem = ((Uri)localObject).toString();
        localObject = SettingsRingtoneUI.a(this.nVG, (Uri)localObject);
        localEditor.putString("settings.ringtone.name", (String)localObject);
        y.d("RingtonePickerActivity", "ringtone name: " + (String)localObject);
      }
    }
    for (;;)
    {
      localEditor.commit();
      f.fg(paramMenuItem);
      this.nVG.finish();
      return true;
      paramMenuItem = f.dAe;
      localEditor.putString("settings.ringtone.name", this.nVG.getString(a.i.settings_notification_ringtone_sys));
      y.d("RingtonePickerActivity", "set ringtone follow system");
      continue;
      paramMenuItem = f.dAe;
      localEditor.putString("settings.ringtone.name", this.nVG.getString(a.i.settings_notification_ringtone_sys));
      y.d("RingtonePickerActivity", "set ringtone follow system");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI.2
 * JD-Core Version:    0.7.0.1
 */