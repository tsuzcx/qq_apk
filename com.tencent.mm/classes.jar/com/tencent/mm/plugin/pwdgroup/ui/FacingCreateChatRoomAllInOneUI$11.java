package com.tencent.mm.plugin.pwdgroup.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;

final class FacingCreateChatRoomAllInOneUI$11
  extends aq
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
      if (FacingCreateChatRoomAllInOneUI.b(this.xoM) != null)
      {
        FacingCreateChatRoomAllInOneUI.b(this.xoM).setData(FacingCreateChatRoomAllInOneUI.c(this.xoM));
        AppMethodBeat.o(27632);
        return;
        FacingCreateChatRoomAllInOneUI.d(this.xoM);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.11
 * JD-Core Version:    0.7.0.1
 */