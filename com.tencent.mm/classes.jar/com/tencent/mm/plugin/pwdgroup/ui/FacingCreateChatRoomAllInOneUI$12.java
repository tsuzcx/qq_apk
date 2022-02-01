package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class FacingCreateChatRoomAllInOneUI$12
  extends MMHandler
{
  FacingCreateChatRoomAllInOneUI$12(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
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
      if (FacingCreateChatRoomAllInOneUI.b(this.Nhe) != null)
      {
        FacingCreateChatRoomAllInOneUI.b(this.Nhe).setData(FacingCreateChatRoomAllInOneUI.c(this.Nhe));
        AppMethodBeat.o(27632);
        return;
        FacingCreateChatRoomAllInOneUI.d(this.Nhe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.12
 * JD-Core Version:    0.7.0.1
 */