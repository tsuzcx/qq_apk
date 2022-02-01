package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

final class FacingCreateChatRoomAllInOneUI$11
  extends ao
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
      if (FacingCreateChatRoomAllInOneUI.b(this.vRL) != null)
      {
        FacingCreateChatRoomAllInOneUI.b(this.vRL).setData(FacingCreateChatRoomAllInOneUI.c(this.vRL));
        AppMethodBeat.o(27632);
        return;
        FacingCreateChatRoomAllInOneUI.d(this.vRL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.11
 * JD-Core Version:    0.7.0.1
 */