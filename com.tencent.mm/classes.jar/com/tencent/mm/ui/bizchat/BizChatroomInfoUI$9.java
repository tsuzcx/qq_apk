package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.b;

final class BizChatroomInfoUI$9
  implements h.b
{
  BizChatroomInfoUI$9(BizChatroomInfoUI paramBizChatroomInfoUI, String paramString) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(30208);
    boolean bool = BizChatroomInfoUI.a(this.zuv, this.zux, paramCharSequence);
    AppMethodBeat.o(30208);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.9
 * JD-Core Version:    0.7.0.1
 */