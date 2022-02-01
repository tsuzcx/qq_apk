package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class TalkRoomUI$9
  implements MTimerHandler.CallBack
{
  TalkRoomUI$9(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(29596);
    TalkRoomUI.m(this.Mlw);
    AppMethodBeat.o(29596);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.9
 * JD-Core Version:    0.7.0.1
 */