package com.tencent.mm.ui.base.preference;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class CheckBoxPreference$1
  implements MMSwitchBtn.a
{
  CheckBoxPreference$1(CheckBoxPreference paramCheckBoxPreference) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(107134);
    this.zqx.callChangeListener(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(107134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckBoxPreference.1
 * JD-Core Version:    0.7.0.1
 */