package com.tencent.weui.base.preference;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class CheckBoxPreference$1
  implements MMSwitchBtn.a
{
  CheckBoxPreference$1(CheckBoxPreference paramCheckBoxPreference) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(113248);
    CheckBoxPreference.a(this.BCx, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(113248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.weui.base.preference.CheckBoxPreference.1
 * JD-Core Version:    0.7.0.1
 */