package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a;
import com.tencent.mm.sdk.platformtools.y;

final class FacingCreateChatRoomAllInOneUI$13
  implements MMPwdInputView.a
{
  FacingCreateChatRoomAllInOneUI$13(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void l(boolean paramBoolean, String paramString)
  {
    y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    FacingCreateChatRoomAllInOneUI.a(this.nbo, paramString);
    if (paramBoolean)
    {
      FacingCreateChatRoomAllInOneUI.a(this.nbo, true);
      FacingCreateChatRoomAllInOneUI.e(this.nbo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.13
 * JD-Core Version:    0.7.0.1
 */