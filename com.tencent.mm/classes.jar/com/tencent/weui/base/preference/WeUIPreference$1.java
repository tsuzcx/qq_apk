package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WeUIPreference$1
  implements Preference.OnPreferenceChangeListener
{
  WeUIPreference$1(WeUIPreference paramWeUIPreference) {}
  
  public final boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    AppMethodBeat.i(113260);
    if ((!WeUIPreference.a(this.BCz)) && (paramPreference.isEnabled()) && (paramPreference.isSelectable()))
    {
      WeUIPreference.a(this.BCz, true);
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label162;
      }
      paramObject = (CheckBoxPreference)paramPreference;
      paramObject.vxW = paramObject.isChecked();
      if (paramObject.isPersistent()) {
        WeUIPreference.b(this.BCz).edit().putBoolean(paramPreference.getKey(), paramObject.isChecked()).commit();
      }
      WeUIPreference.c(this.BCz);
    }
    label162:
    for (int i = 1;; i = 0)
    {
      if (paramPreference.getKey() != null) {
        WeUIPreference.d(this.BCz);
      }
      if (i != 0) {
        WeUIPreference.d(this.BCz).notifyDataSetChanged();
      }
      WeUIPreference.a(this.BCz, false);
      if (i != 0)
      {
        AppMethodBeat.o(113260);
        return true;
      }
      AppMethodBeat.o(113260);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.1
 * JD-Core Version:    0.7.0.1
 */