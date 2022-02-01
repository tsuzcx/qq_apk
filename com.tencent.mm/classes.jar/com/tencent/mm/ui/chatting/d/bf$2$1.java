package com.tencent.mm.ui.chatting.d;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;

final class bf$2$1
  implements Runnable
{
  bf$2$1(bf.2 param2, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(35728);
    if (this.qQL == 0)
    {
      bf.b(this.Pvg.Pve);
      this.Pvg.Pve.a(Util.safeParseLong(this.val$id), ChattingItemTranslate.c.PPp);
      bf.a(this.Pvg.Pve, Util.safeParseLong(this.val$id));
      AppMethodBeat.o(35728);
      return;
    }
    if (this.qQL == 3) {
      h.cD(this.Pvg.Pve.dom.Pwc.getContext(), this.Pvg.Pve.dom.Pwc.getMMResources().getString(2131757544));
    }
    for (;;)
    {
      this.Pvg.Pve.a(Util.safeParseLong(this.val$id), ChattingItemTranslate.c.PPm);
      this.Pvg.Pve.dom.cmy();
      AppMethodBeat.o(35728);
      return;
      if (this.qQL != 5) {
        h.cD(this.Pvg.Pve.dom.Pwc.getContext(), this.Pvg.Pve.dom.Pwc.getMMResources().getString(2131757539));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bf.2.1
 * JD-Core Version:    0.7.0.1
 */