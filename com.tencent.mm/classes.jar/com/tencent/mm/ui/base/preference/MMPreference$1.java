package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class MMPreference$1
  implements Preference.a
{
  MMPreference$1(MMPreference paramMMPreference) {}
  
  public final boolean a(Preference paramPreference, Object paramObject)
  {
    if ((!MMPreference.a(this.vdh)) && (paramPreference.isEnabled()) && (paramPreference.vdI))
    {
      MMPreference.a(this.vdh, true);
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label155;
      }
      paramObject = (CheckBoxPreference)paramPreference;
      paramObject.rHo = paramObject.isChecked();
      if (paramObject.vdK) {
        MMPreference.b(this.vdh).edit().putBoolean(paramPreference.mKey, paramObject.isChecked()).commit();
      }
      MMPreference.c(this.vdh);
    }
    label155:
    for (int i = 1;; i = 0)
    {
      if (paramPreference.mKey != null) {
        this.vdh.a(MMPreference.d(this.vdh), paramPreference);
      }
      if (i != 0) {
        MMPreference.d(this.vdh).notifyDataSetChanged();
      }
      MMPreference.a(this.vdh, false);
      return i != 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.1
 * JD-Core Version:    0.7.0.1
 */