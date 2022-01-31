package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FacingCreateChatRoomAllInOneUI$11
  extends ak
{
  FacingCreateChatRoomAllInOneUI$11(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(23993);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23993);
      return;
      if (FacingCreateChatRoomAllInOneUI.b(this.pGF) != null)
      {
        FacingCreateChatRoomAllInOneUI.b(this.pGF).setData(FacingCreateChatRoomAllInOneUI.c(this.pGF));
        AppMethodBeat.o(23993);
        return;
        FacingCreateChatRoomAllInOneUI.d(this.pGF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.11
 * JD-Core Version:    0.7.0.1
 */