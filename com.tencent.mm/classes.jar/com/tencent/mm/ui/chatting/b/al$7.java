package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.bg.d;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.chatting.e;
import java.util.List;

final class al$7
  implements TalkRoomPopupNav.a
{
  al$7(al paramal) {}
  
  public final void cBp()
  {
    if ((com.tencent.mm.r.a.bk(this.vsS.byx.vtz.getContext())) || (com.tencent.mm.r.a.bi(this.vsS.byx.vtz.getContext())))
    {
      y.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      return;
    }
    y.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(d.eEX.nz(this.vsS.byx.pSb.field_username).size()) });
    if (d.eEX.nA(this.vsS.byx.pSb.field_username))
    {
      al.b(this.vsS);
      return;
    }
    this.vsS.nn(true);
  }
  
  public final void cBq()
  {
    ru localru = new ru();
    localru.cbq.cbt = true;
    com.tencent.mm.sdk.b.a.udP.m(localru);
    al.a(this.vsS, this.vsS.byx.getTalkerUserName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.al.7
 * JD-Core Version:    0.7.0.1
 */