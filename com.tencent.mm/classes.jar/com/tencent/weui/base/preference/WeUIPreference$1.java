package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

final class WeUIPreference$1
  implements Preference.OnPreferenceChangeListener
{
  WeUIPreference$1(WeUIPreference paramWeUIPreference) {}
  
  public final boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if ((!WeUIPreference.a(this.xfT)) && (paramPreference.isEnabled()) && (paramPreference.isSelectable()))
    {
      WeUIPreference.a(this.xfT, true);
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label137;
      }
      paramObject = (CheckBoxPreference)paramPreference;
      paramObject.rHo = paramObject.isChecked();
      if (paramObject.isPersistent()) {
        WeUIPreference.b(this.xfT).edit().putBoolean(paramPreference.getKey(), paramObject.isChecked()).commit();
      }
      WeUIPreference.c(this.xfT);
    }
    label137:
    for (int i = 1;; i = 0)
    {
      paramPreference.getKey();
      if (i != 0) {
        WeUIPreference.d(this.xfT).notifyDataSetChanged();
      }
      WeUIPreference.a(this.xfT, false);
      return i != 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.1
 * JD-Core Version:    0.7.0.1
 */