package com.tencent.mm.plugin.welab.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class WelabAppInfoUI$2
  implements MMSwitchBtn.a
{
  WelabAppInfoUI$2(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(80600);
    if (WelabAppInfoUI.a(this.vvu).field_Switch == 2)
    {
      WelabAppInfoUI.a(this.vvu).field_Switch = 1;
      AppMethodBeat.o(80600);
      return;
    }
    if (WelabAppInfoUI.a(this.vvu).field_Switch == 1) {
      WelabAppInfoUI.a(this.vvu).field_Switch = 2;
    }
    AppMethodBeat.o(80600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.2
 * JD-Core Version:    0.7.0.1
 */