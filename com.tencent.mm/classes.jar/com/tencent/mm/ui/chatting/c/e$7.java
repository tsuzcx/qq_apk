package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.d.a;
import java.util.Map;

final class e$7
  implements k.a
{
  e$7(e parame) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(31250);
    ab.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramString)));
    if (((d)this.zEC.caz.ay(d.class)).dHw())
    {
      e.a(this.zEC, com.tencent.mm.aj.a.e.c(((d)this.zEC.caz.ay(d.class)).dHt()));
      if (!this.zEC.zEv) {
        break label153;
      }
      n.f(this.zEC.caz.getTalkerUserName(), this.zEC.zEw);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString)) {
        this.zEC.caz.aWN();
      }
      AppMethodBeat.o(31250);
      return;
      e.a(this.zEC, n.nn(this.zEC.caz.getTalkerUserName()));
      break;
      label153:
      this.zEC.zEw.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e.7
 * JD-Core Version:    0.7.0.1
 */