package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TalkRoomUI$7
  implements DialogInterface.OnClickListener
{
  TalkRoomUI$7(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29595);
    this.Mlw.finish();
    AppMethodBeat.o(29595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.7
 * JD-Core Version:    0.7.0.1
 */