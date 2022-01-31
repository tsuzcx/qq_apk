package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreferenceFragment$1
  implements Preference.a
{
  MMPreferenceFragment$1(MMPreferenceFragment paramMMPreferenceFragment) {}
  
  public final boolean a(Preference paramPreference, Object paramObject)
  {
    AppMethodBeat.i(107237);
    if ((!MMPreferenceFragment.a(this.zrW)) && (paramPreference.isEnabled()) && (paramPreference.zsi))
    {
      MMPreferenceFragment.a(this.zrW, true);
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label170;
      }
      paramObject = (CheckBoxPreference)paramPreference;
      paramObject.vxW = paramObject.isChecked();
      if (paramObject.zsk) {
        MMPreferenceFragment.b(this.zrW).edit().putBoolean(paramPreference.mKey, paramObject.isChecked()).commit();
      }
      MMPreferenceFragment.c(this.zrW);
    }
    label170:
    for (int i = 1;; i = 0)
    {
      if (paramPreference.mKey != null) {
        this.zrW.onPreferenceTreeClick(MMPreferenceFragment.d(this.zrW), paramPreference);
      }
      if (i != 0) {
        MMPreferenceFragment.d(this.zrW).notifyDataSetChanged();
      }
      MMPreferenceFragment.a(this.zrW, false);
      if (i != 0)
      {
        AppMethodBeat.o(107237);
        return true;
      }
      AppMethodBeat.o(107237);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment.1
 * JD-Core Version:    0.7.0.1
 */