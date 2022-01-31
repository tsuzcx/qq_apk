package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FacingCreateChatRoomAllInOneUI$13
  implements MMPwdInputView.a
{
  FacingCreateChatRoomAllInOneUI$13(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void q(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(23995);
    ab.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    FacingCreateChatRoomAllInOneUI.a(this.pGF, paramString);
    if (paramBoolean)
    {
      FacingCreateChatRoomAllInOneUI.a(this.pGF, true);
      FacingCreateChatRoomAllInOneUI.e(this.pGF);
    }
    AppMethodBeat.o(23995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.13
 * JD-Core Version:    0.7.0.1
 */