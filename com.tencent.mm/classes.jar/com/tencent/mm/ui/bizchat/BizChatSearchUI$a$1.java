package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.l;
import com.tencent.mm.model.aw;

final class BizChatSearchUI$a$1
  implements Runnable
{
  BizChatSearchUI$a$1(BizChatSearchUI.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(30137);
    if (!this.zuc.equals(BizChatSearchUI.a.d(this.zud)))
    {
      AppMethodBeat.o(30137);
      return;
    }
    l locall = new l(BizChatSearchUI.a.f(this.zud), this.zuc, 0);
    aw.Rc().a(locall, 0);
    AppMethodBeat.o(30137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.a.1
 * JD-Core Version:    0.7.0.1
 */