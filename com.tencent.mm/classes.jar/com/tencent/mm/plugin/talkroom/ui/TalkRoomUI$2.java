package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;

final class TalkRoomUI$2
  implements View.OnClickListener
{
  TalkRoomUI$2(TalkRoomUI paramTalkRoomUI, i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25908);
    this.tdU.dismiss();
    AppMethodBeat.o(25908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.2
 * JD-Core Version:    0.7.0.1
 */