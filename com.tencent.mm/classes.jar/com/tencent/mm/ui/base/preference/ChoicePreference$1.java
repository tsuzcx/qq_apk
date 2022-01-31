package com.tencent.mm.ui.base.preference;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

final class ChoicePreference$1
  implements RadioGroup.OnCheckedChangeListener
{
  ChoicePreference$1(ChoicePreference paramChoicePreference) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (ChoicePreference.a(this.vcd) != null)
    {
      if (paramInt == -1) {
        break label82;
      }
      ChoicePreference.a(this.vcd, ChoicePreference.b(this.vcd)[(paramInt - 1048576)]);
    }
    for (;;)
    {
      ChoicePreference.a(this.vcd, paramInt);
      ChoicePreference.a(this.vcd).a(this.vcd, this.vcd.value);
      return;
      label82:
      ChoicePreference.a(this.vcd, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference.1
 * JD-Core Version:    0.7.0.1
 */