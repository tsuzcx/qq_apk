package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class MMPreference$2$2
  implements EditPreference.a
{
  MMPreference$2$2(MMPreference.2 param2, EditPreference paramEditPreference, Preference paramPreference) {}
  
  public final void cBt()
  {
    MMPreference.c(this.vdj.vdh);
    if (this.vdk.vdK) {
      MMPreference.b(this.vdj.vdh).edit().putString(this.hcw.mKey, this.vdk.value).commit();
    }
    MMPreference.d(this.vdj.vdh).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.2.2
 * JD-Core Version:    0.7.0.1
 */