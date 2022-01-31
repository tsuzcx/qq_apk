package com.tencent.mm.ui.chatting.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMTextView.a;

 enum a$a
  implements MMTextView.a
{
  static
  {
    AppMethodBeat.i(32676);
    zPR = new a("TEXT_CALLBACK");
    zPS = new a[] { zPR };
    AppMethodBeat.o(32676);
  }
  
  private a$a() {}
  
  public final void a(CharSequence paramCharSequence, long paramLong)
  {
    AppMethodBeat.i(32675);
    bi localbi = ((j)g.E(j.class)).bPQ().kB(paramLong);
    if (bo.isNullOrNil(localbi.field_talker))
    {
      ab.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(32675);
      return;
    }
    if ((localbi.field_flag & 0x10) == 0)
    {
      a.b(paramCharSequence, localbi);
      AppMethodBeat.o(32675);
      return;
    }
    ab.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(32675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */