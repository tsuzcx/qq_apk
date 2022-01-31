package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class TalkRoomUI$1
  implements ap.a
{
  TalkRoomUI$1(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25907);
    ab.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
    TalkRoomUI.a(this.tdT);
    AppMethodBeat.o(25907);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.1
 * JD-Core Version:    0.7.0.1
 */