package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class TalkRoomUI$9
  implements ap.a
{
  TalkRoomUI$9(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25913);
    TalkRoomUI.m(this.tdT);
    AppMethodBeat.o(25913);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.9
 * JD-Core Version:    0.7.0.1
 */