package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class TalkRoomUI$5
  implements MTimerHandler.CallBack
{
  TalkRoomUI$5(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(29593);
    Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
    TalkRoomUI.q(this.FRv);
    AppMethodBeat.o(29593);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.5
 * JD-Core Version:    0.7.0.1
 */