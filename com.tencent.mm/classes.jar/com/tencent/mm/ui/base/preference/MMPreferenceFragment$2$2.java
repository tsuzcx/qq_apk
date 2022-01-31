package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreferenceFragment$2$2
  implements EditPreference.a
{
  MMPreferenceFragment$2$2(MMPreferenceFragment.2 param2, EditPreference paramEditPreference, Preference paramPreference) {}
  
  public final void dEI()
  {
    AppMethodBeat.i(107239);
    MMPreferenceFragment.c(this.zrX.zrW);
    if (this.zrH.zsk) {
      MMPreferenceFragment.b(this.zrX.zrW).edit().putString(this.iLK.mKey, this.zrH.value).commit();
    }
    MMPreferenceFragment.d(this.zrX.zrW).notifyDataSetChanged();
    AppMethodBeat.o(107239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment.2.2
 * JD-Core Version:    0.7.0.1
 */