package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.ui.base.MMHorList.a;

final class TalkRoomAvatarsFrame$1
  implements MMHorList.a
{
  TalkRoomAvatarsFrame$1(TalkRoomAvatarsFrame paramTalkRoomAvatarsFrame) {}
  
  public final void arA()
  {
    TalkRoomAvatarsFrame.c(this.pBR).post(new TalkRoomAvatarsFrame.1.1(this));
  }
  
  public final void bMM()
  {
    TalkRoomAvatarsFrame.a(this.pBR).stopTimer();
  }
  
  public final void bMN()
  {
    TalkRoomAvatarsFrame.a(this.pBR).S(2000L, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.1
 * JD-Core Version:    0.7.0.1
 */