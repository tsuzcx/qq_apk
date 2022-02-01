package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class FacingCreateChatRoomAllInOneUI$1
  implements MTimerHandler.CallBack
{
  FacingCreateChatRoomAllInOneUI$1(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(27622);
    FacingCreateChatRoomAllInOneUI.a(this.BoY);
    AppMethodBeat.o(27622);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.1
 * JD-Core Version:    0.7.0.1
 */