package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.g;

final class TalkRoomUI$11$1
  implements DialogInterface.OnClickListener
{
  TalkRoomUI$11$1(TalkRoomUI.11 param11) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25915);
    TalkRoomUI.j(this.tdV.tdT);
    b.cHs().cHH();
    this.tdV.tdT.finish();
    AppMethodBeat.o(25915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.11.1
 * JD-Core Version:    0.7.0.1
 */