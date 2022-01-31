package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class TalkRoomUI$10
  implements ap.a
{
  TalkRoomUI$10(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean onTimerExpired()
  {
    int j = 15;
    boolean bool = false;
    AppMethodBeat.i(25914);
    int i;
    if (TalkRoomUI.b(this.tdT) == 3)
    {
      i = b.cHs().akQ();
      if (i > 15) {
        break label172;
      }
      if (!TalkRoomUI.e(this.tdT)) {
        break label167;
      }
      i = j;
      label47:
      TalkRoomUI.f(this.tdT);
      j = i;
      if (TalkRoomUI.g(this.tdT) >= 5)
      {
        TalkRoomUI localTalkRoomUI = this.tdT;
        if (!TalkRoomUI.e(this.tdT)) {
          bool = true;
        }
        TalkRoomUI.a(localTalkRoomUI, bool);
        TalkRoomUI.h(this.tdT);
      }
    }
    label167:
    label172:
    for (j = i;; j = i)
    {
      TalkRoomUI.d(this.tdT);
      TalkRoomUI.i(this.tdT).setValue(j);
      AppMethodBeat.o(25914);
      return true;
      if (bo.isNullOrNil(TalkRoomUI.c(this.tdT)))
      {
        TalkRoomUI.d(this.tdT);
        AppMethodBeat.o(25914);
        return false;
      }
      i = b.cHs().akR();
      break;
      i = 0;
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.10
 * JD-Core Version:    0.7.0.1
 */