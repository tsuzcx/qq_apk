package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreference$2$1
  implements DialogPreference.a
{
  MMPreference$2$1(MMPreference.2 param2, DialogPreference paramDialogPreference, Preference paramPreference) {}
  
  public final void dEI()
  {
    AppMethodBeat.i(107209);
    MMPreference.access$202(this.zrG.zrE, true);
    if (this.zrF.zsk) {
      MMPreference.access$100(this.zrG.zrE).edit().putString(this.iLK.mKey, this.zrF.getValue()).commit();
    }
    MMPreference.access$300(this.zrG.zrE).notifyDataSetChanged();
    AppMethodBeat.o(107209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.2.1
 * JD-Core Version:    0.7.0.1
 */