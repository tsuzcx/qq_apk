package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.af.b;
import com.tencent.mm.sdk.platformtools.ah;

final class TalkRoomReceiver$1
  implements af.b
{
  public final void cancel()
  {
    AppMethodBeat.i(25789);
    TalkRoomReceiver.bv(ah.getContext());
    AppMethodBeat.o(25789);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(25788);
    TalkRoomReceiver.bu(ah.getContext());
    AppMethodBeat.o(25788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver.1
 * JD-Core Version:    0.7.0.1
 */