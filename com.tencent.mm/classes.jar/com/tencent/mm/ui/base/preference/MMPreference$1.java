package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreference$1
  implements Preference.a
{
  MMPreference$1(MMPreference paramMMPreference) {}
  
  public final boolean a(Preference paramPreference, Object paramObject)
  {
    AppMethodBeat.i(107208);
    if ((!MMPreference.access$000(this.zrE)) && (paramPreference.isEnabled()) && (paramPreference.zsi))
    {
      MMPreference.access$002(this.zrE, true);
      if (!(paramPreference instanceof CheckBoxPreference)) {
        break label171;
      }
      paramObject = (CheckBoxPreference)paramPreference;
      paramObject.vxW = paramObject.isChecked();
      if (paramObject.zsk) {
        MMPreference.access$100(this.zrE).edit().putBoolean(paramPreference.mKey, paramObject.isChecked()).commit();
      }
      MMPreference.access$202(this.zrE, true);
    }
    label171:
    for (int i = 1;; i = 0)
    {
      if (paramPreference.mKey != null) {
        this.zrE.onPreferenceTreeClick(MMPreference.access$300(this.zrE), paramPreference);
      }
      if (i != 0) {
        MMPreference.access$300(this.zrE).notifyDataSetChanged();
      }
      MMPreference.access$002(this.zrE, false);
      if (i != 0)
      {
        AppMethodBeat.o(107208);
        return true;
      }
      AppMethodBeat.o(107208);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.1
 * JD-Core Version:    0.7.0.1
 */