package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.List;

final class an$9
  implements TalkRoomPopupNav.a
{
  an$9(an paraman) {}
  
  public final void dEE()
  {
    AppMethodBeat.i(155495);
    if ((com.tencent.mm.r.a.bO(this.zIG.caz.zJz.getContext())) || (com.tencent.mm.r.a.bM(this.zIG.caz.zJz.getContext())))
    {
      ab.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(155495);
      return;
    }
    ab.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(d.fUO.uN(this.zIG.caz.txj.field_username).size()) });
    if (d.fUO.uO(this.zIG.caz.txj.field_username))
    {
      an.b(this.zIG);
      AppMethodBeat.o(155495);
      return;
    }
    this.zIG.qX(true);
    AppMethodBeat.o(155495);
  }
  
  public final void dEF()
  {
    AppMethodBeat.i(155496);
    tl localtl = new tl();
    localtl.cJT.cJW = true;
    com.tencent.mm.sdk.b.a.ymk.l(localtl);
    an.a(this.zIG, this.zIG.caz.getTalkerUserName());
    AppMethodBeat.o(155496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an.9
 * JD-Core Version:    0.7.0.1
 */