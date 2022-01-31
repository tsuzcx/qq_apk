package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class TalkRoomUI$5
  implements ap.a
{
  TalkRoomUI$5(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25910);
    ab.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
    TalkRoomUI.q(this.tdT);
    AppMethodBeat.o(25910);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.5
 * JD-Core Version:    0.7.0.1
 */