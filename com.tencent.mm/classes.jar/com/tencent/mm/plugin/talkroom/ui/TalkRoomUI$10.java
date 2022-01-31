package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.plugin.talkroom.model.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;

final class TalkRoomUI$10
  implements am.a
{
  TalkRoomUI$10(TalkRoomUI paramTalkRoomUI) {}
  
  public final boolean tC()
  {
    int j = 15;
    boolean bool = false;
    int i;
    if (TalkRoomUI.b(this.pCk) == 3)
    {
      i = b.bMu().RH();
      if (i > 15) {
        break label154;
      }
      if (!TalkRoomUI.e(this.pCk)) {
        break label149;
      }
      i = j;
      label41:
      TalkRoomUI.f(this.pCk);
      j = i;
      if (TalkRoomUI.g(this.pCk) >= 5)
      {
        TalkRoomUI localTalkRoomUI = this.pCk;
        if (!TalkRoomUI.e(this.pCk)) {
          bool = true;
        }
        TalkRoomUI.a(localTalkRoomUI, bool);
        TalkRoomUI.h(this.pCk);
      }
    }
    label149:
    label154:
    for (j = i;; j = i)
    {
      TalkRoomUI.d(this.pCk);
      TalkRoomUI.i(this.pCk).setValue(j);
      return true;
      if (bk.bl(TalkRoomUI.c(this.pCk)))
      {
        TalkRoomUI.d(this.pCk);
        return false;
      }
      i = b.bMu().RI();
      break;
      i = 0;
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.10
 * JD-Core Version:    0.7.0.1
 */