package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreference$2$2
  implements EditPreference.a
{
  MMPreference$2$2(MMPreference.2 param2, EditPreference paramEditPreference, Preference paramPreference) {}
  
  public final void dEI()
  {
    AppMethodBeat.i(107210);
    MMPreference.access$202(this.zrG.zrE, true);
    if (this.zrH.zsk) {
      MMPreference.access$100(this.zrG.zrE).edit().putString(this.iLK.mKey, this.zrH.value).commit();
    }
    MMPreference.access$300(this.zrG.zrE).notifyDataSetChanged();
    AppMethodBeat.o(107210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.2.2
 * JD-Core Version:    0.7.0.1
 */