package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreferenceFragment$2$1
  implements DialogPreference.a
{
  MMPreferenceFragment$2$1(MMPreferenceFragment.2 param2, DialogPreference paramDialogPreference, Preference paramPreference) {}
  
  public final void dEI()
  {
    AppMethodBeat.i(107238);
    MMPreferenceFragment.c(this.zrX.zrW);
    if (this.zrF.zsk) {
      MMPreferenceFragment.b(this.zrX.zrW).edit().putString(this.iLK.mKey, this.zrF.getValue()).commit();
    }
    MMPreferenceFragment.d(this.zrX.zrW).notifyDataSetChanged();
    AppMethodBeat.o(107238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment.2.1
 * JD-Core Version:    0.7.0.1
 */