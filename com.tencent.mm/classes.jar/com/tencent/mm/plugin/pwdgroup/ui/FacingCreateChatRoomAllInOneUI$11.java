package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class FacingCreateChatRoomAllInOneUI$11
  extends ah
{
  FacingCreateChatRoomAllInOneUI$11(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 10001: 
      do
      {
        return;
      } while (FacingCreateChatRoomAllInOneUI.b(this.nbo) == null);
      FacingCreateChatRoomAllInOneUI.b(this.nbo).setData(FacingCreateChatRoomAllInOneUI.c(this.nbo));
      return;
    }
    FacingCreateChatRoomAllInOneUI.d(this.nbo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.11
 * JD-Core Version:    0.7.0.1
 */