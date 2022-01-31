package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class FacingCreateChatRoomAllInOneUI$17
  implements ap.a
{
  FacingCreateChatRoomAllInOneUI$17(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(24002);
    FacingCreateChatRoomAllInOneUI.a(this.pGF, false);
    FacingCreateChatRoomAllInOneUI.a(this.pGF, FacingCreateChatRoomAllInOneUI.a.pGN);
    AppMethodBeat.o(24002);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.17
 * JD-Core Version:    0.7.0.1
 */