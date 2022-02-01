package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class TalkRoomUI$1
  implements MTimerHandler.CallBack
{
  TalkRoomUI$1(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(29590);
    Log.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
    TalkRoomUI.a(this.Mlw);
    AppMethodBeat.o(29590);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.1
 * JD-Core Version:    0.7.0.1
 */