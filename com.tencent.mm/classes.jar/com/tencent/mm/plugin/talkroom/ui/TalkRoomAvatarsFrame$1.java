package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MMHorList.a;

final class TalkRoomAvatarsFrame$1
  implements MMHorList.a
{
  TalkRoomAvatarsFrame$1(TalkRoomAvatarsFrame paramTalkRoomAvatarsFrame) {}
  
  public final void aQl()
  {
    AppMethodBeat.i(25893);
    TalkRoomAvatarsFrame.c(this.tdA).post(new TalkRoomAvatarsFrame.1.1(this));
    AppMethodBeat.o(25893);
  }
  
  public final void cHQ()
  {
    AppMethodBeat.i(25891);
    TalkRoomAvatarsFrame.a(this.tdA).stopTimer();
    AppMethodBeat.o(25891);
  }
  
  public final void crx()
  {
    AppMethodBeat.i(25892);
    TalkRoomAvatarsFrame.a(this.tdA).ag(2000L, 2000L);
    AppMethodBeat.o(25892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.1
 * JD-Core Version:    0.7.0.1
 */