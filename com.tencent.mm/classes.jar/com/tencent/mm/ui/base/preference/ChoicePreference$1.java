package com.tencent.mm.ui.base.preference;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChoicePreference$1
  implements RadioGroup.OnCheckedChangeListener
{
  ChoicePreference$1(ChoicePreference paramChoicePreference) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    AppMethodBeat.i(107145);
    if (ChoicePreference.a(this.zqE) != null)
    {
      if (paramInt == -1) {
        break label92;
      }
      ChoicePreference.a(this.zqE, ChoicePreference.b(this.zqE)[(paramInt - 1048576)]);
    }
    for (;;)
    {
      ChoicePreference.a(this.zqE, paramInt);
      ChoicePreference.a(this.zqE).a(this.zqE, this.zqE.value);
      AppMethodBeat.o(107145);
      return;
      label92:
      ChoicePreference.a(this.zqE, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference.1
 * JD-Core Version:    0.7.0.1
 */