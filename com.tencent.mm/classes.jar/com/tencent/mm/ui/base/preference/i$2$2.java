package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class i$2$2
  implements EditPreference.a
{
  i$2$2(i.2 param2, EditPreference paramEditPreference, Preference paramPreference) {}
  
  public final void cBt()
  {
    i.c(this.vdx.vdw);
    if (this.vdk.vdK) {
      i.b(this.vdx.vdw).edit().putString(this.hcw.mKey, this.vdk.value).commit();
    }
    i.d(this.vdx.vdw).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i.2.2
 * JD-Core Version:    0.7.0.1
 */