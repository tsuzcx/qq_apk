package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TalkRoomUI$16
  implements View.OnClickListener
{
  TalkRoomUI$16(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25923);
    this.tdT.onBackPressed();
    AppMethodBeat.o(25923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.16
 * JD-Core Version:    0.7.0.1
 */