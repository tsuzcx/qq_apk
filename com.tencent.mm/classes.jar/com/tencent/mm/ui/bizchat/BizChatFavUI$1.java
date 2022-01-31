package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.a.b.a;
import com.tencent.mm.aj.a.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class BizChatFavUI$1
  implements b.a
{
  BizChatFavUI$1(BizChatFavUI paramBizChatFavUI) {}
  
  public final void a(b.a.b paramb)
  {
    AppMethodBeat.i(30107);
    if ((paramb != null) && (paramb.fxr != null) && (BizChatFavUI.a(this.ztz).equals(paramb.fxr.field_brandUserName)))
    {
      ab.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
      if (BizChatFavUI.b(this.ztz)) {
        BizChatFavUI.c(this.ztz).Ku();
      }
    }
    AppMethodBeat.o(30107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.1
 * JD-Core Version:    0.7.0.1
 */