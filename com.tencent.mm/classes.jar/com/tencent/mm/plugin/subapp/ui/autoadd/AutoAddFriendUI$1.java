package com.tencent.mm.plugin.subapp.ui.autoadd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class AutoAddFriendUI$1
  implements MMSwitchBtn.a
{
  AutoAddFriendUI$1(AutoAddFriendUI paramAutoAddFriendUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(25329);
    AutoAddFriendUI.a(this.sXJ, paramBoolean, 2097152, 32);
    AppMethodBeat.o(25329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI.1
 * JD-Core Version:    0.7.0.1
 */