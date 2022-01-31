package com.tencent.mm.plugin.subapp.ui.autoadd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class AutoAddFriendUI$2
  implements MMSwitchBtn.a
{
  AutoAddFriendUI$2(AutoAddFriendUI paramAutoAddFriendUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(25330);
    AutoAddFriendUI.a(this.sXJ, paramBoolean, 32, 4);
    AppMethodBeat.o(25330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.autoadd.AutoAddFriendUI.2
 * JD-Core Version:    0.7.0.1
 */