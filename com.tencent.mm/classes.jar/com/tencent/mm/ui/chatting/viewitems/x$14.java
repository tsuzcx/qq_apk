package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.g;
import com.tencent.mm.ui.l;

final class x$14
  implements l
{
  x$14(x paramx) {}
  
  public final void dBY() {}
  
  public final void dBZ() {}
  
  public final void dCa() {}
  
  public final void dCb() {}
  
  public final void dCc() {}
  
  public final void dCd()
  {
    AppMethodBeat.i(33143);
    ab.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
    com.tencent.mm.sdk.b.a.ymk.d(x.e(this.zVk));
    if (x.b(this.zVk) != null) {
      ((g)x.b(this.zVk).ay(g.class)).b(this);
    }
    AppMethodBeat.o(33143);
  }
  
  public final void dCe() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.14
 * JD-Core Version:    0.7.0.1
 */