package com.tencent.mm.pluginsdk.ui.preference;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.R.h;

final class SpecialCheckBoxPreference$1
  implements CompoundButton.OnCheckedChangeListener
{
  SpecialCheckBoxPreference$1(SpecialCheckBoxPreference paramSpecialCheckBoxPreference) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = paramCompoundButton.getId();
    if (i == R.h.room_placed_to_the_top) {
      SpecialCheckBoxPreference.a(this.sjm);
    }
    do
    {
      return;
      if (i == R.h.room_notify_new_msg)
      {
        SpecialCheckBoxPreference.b(this.sjm);
        return;
      }
    } while (i != R.h.room_save_to_contact);
    SpecialCheckBoxPreference.c(this.sjm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference.1
 * JD-Core Version:    0.7.0.1
 */