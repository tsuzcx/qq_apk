package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.a.d.a.a;
import com.tencent.mm.aj.a.d.a.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.ab;

final class BizChatroomInfoUI$3
  implements d.a
{
  BizChatroomInfoUI$3(BizChatroomInfoUI paramBizChatroomInfoUI) {}
  
  public final void a(d.a.b paramb)
  {
    AppMethodBeat.i(30199);
    if ((paramb != null) && (paramb.fxB != null) && (paramb.fxq == BizChatroomInfoUI.g(this.zuv)) && (paramb.fxA != d.a.a.fxx))
    {
      ab.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
      paramb = z.afk().aG(BizChatroomInfoUI.g(this.zuv));
      BizChatroomInfoUI.a(this.zuv, paramb);
      BizChatroomInfoUI.h(this.zuv);
    }
    AppMethodBeat.o(30199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.3
 * JD-Core Version:    0.7.0.1
 */