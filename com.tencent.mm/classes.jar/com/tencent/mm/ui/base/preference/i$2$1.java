package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class i$2$1
  implements DialogPreference.a
{
  i$2$1(i.2 param2, DialogPreference paramDialogPreference, Preference paramPreference) {}
  
  public final void cBt()
  {
    i.c(this.vdx.vdw);
    if (this.vdi.vdK) {
      i.b(this.vdx.vdw).edit().putString(this.hcw.mKey, this.vdi.getValue()).commit();
    }
    i.d(this.vdx.vdw).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i.2.1
 * JD-Core Version:    0.7.0.1
 */