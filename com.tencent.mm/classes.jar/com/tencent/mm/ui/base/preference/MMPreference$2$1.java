package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class MMPreference$2$1
  implements DialogPreference.a
{
  MMPreference$2$1(MMPreference.2 param2, DialogPreference paramDialogPreference, Preference paramPreference) {}
  
  public final void cBt()
  {
    MMPreference.c(this.vdj.vdh);
    if (this.vdi.vdK) {
      MMPreference.b(this.vdj.vdh).edit().putString(this.hcw.mKey, this.vdi.getValue()).commit();
    }
    MMPreference.d(this.vdj.vdh).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.2.1
 * JD-Core Version:    0.7.0.1
 */