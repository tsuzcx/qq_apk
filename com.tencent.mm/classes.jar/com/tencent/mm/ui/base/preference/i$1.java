package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class i$1
  implements Preference.a
{
  i$1(i parami) {}
  
  public final boolean a(Preference paramPreference, Object paramObject)
  {
    if ((!i.a(this.vdw)) && (paramPreference.isEnabled()) && (paramPreference.vdI))
    {
      i.a(this.vdw, true);
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label155;
      }
      paramObject = (CheckBoxPreference)paramPreference;
      paramObject.rHo = paramObject.isChecked();
      if (paramObject.vdK) {
        i.b(this.vdw).edit().putBoolean(paramPreference.mKey, paramObject.isChecked()).commit();
      }
      i.c(this.vdw);
    }
    label155:
    for (int i = 1;; i = 0)
    {
      if (paramPreference.mKey != null) {
        this.vdw.a(i.d(this.vdw), paramPreference);
      }
      if (i != 0) {
        i.d(this.vdw).notifyDataSetChanged();
      }
      i.a(this.vdw, false);
      return i != 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i.1
 * JD-Core Version:    0.7.0.1
 */