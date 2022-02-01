package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class FacingCreateChatRoomAllInOneUI$11
  extends ap
{
  FacingCreateChatRoomAllInOneUI$11(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(27632);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27632);
      return;
      if (FacingCreateChatRoomAllInOneUI.b(this.uIU) != null)
      {
        FacingCreateChatRoomAllInOneUI.b(this.uIU).setData(FacingCreateChatRoomAllInOneUI.c(this.uIU));
        AppMethodBeat.o(27632);
        return;
        FacingCreateChatRoomAllInOneUI.d(this.uIU);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.11
 * JD-Core Version:    0.7.0.1
 */