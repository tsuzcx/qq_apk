package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class TalkRoomUI$1
  implements av.a
{
  TalkRoomUI$1(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(29590);
    ad.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
    TalkRoomUI.a(this.yKo);
    AppMethodBeat.o(29590);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.1
 * JD-Core Version:    0.7.0.1
 */