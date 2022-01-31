package com.tencent.mm.pluginsdk.ui.preference;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SpecialCheckBoxPreference$1
  implements CompoundButton.OnCheckedChangeListener
{
  SpecialCheckBoxPreference$1(SpecialCheckBoxPreference paramSpecialCheckBoxPreference) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(28123);
    int i = paramCompoundButton.getId();
    if (i == 2131826194)
    {
      SpecialCheckBoxPreference.a(this.wbS);
      AppMethodBeat.o(28123);
      return;
    }
    if (i == 2131826195)
    {
      SpecialCheckBoxPreference.b(this.wbS);
      AppMethodBeat.o(28123);
      return;
    }
    if (i == 2131826196) {
      SpecialCheckBoxPreference.c(this.wbS);
    }
    AppMethodBeat.o(28123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference.1
 * JD-Core Version:    0.7.0.1
 */