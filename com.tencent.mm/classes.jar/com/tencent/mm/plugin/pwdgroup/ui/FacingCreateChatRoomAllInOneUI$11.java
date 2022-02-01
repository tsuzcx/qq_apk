package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class FacingCreateChatRoomAllInOneUI$11
  extends MMHandler
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
      if (FacingCreateChatRoomAllInOneUI.b(this.Hjr) != null)
      {
        FacingCreateChatRoomAllInOneUI.b(this.Hjr).setData(FacingCreateChatRoomAllInOneUI.c(this.Hjr));
        AppMethodBeat.o(27632);
        return;
        FacingCreateChatRoomAllInOneUI.d(this.Hjr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.11
 * JD-Core Version:    0.7.0.1
 */