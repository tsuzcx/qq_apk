package com.tencent.mm.ui.chatting.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMTextView.a;

 enum a$a
  implements MMTextView.a
{
  static
  {
    AppMethodBeat.i(36616);
    KsQ = new a("TEXT_CALLBACK");
    KsR = new a[] { KsQ };
    AppMethodBeat.o(36616);
  }
  
  private a$a() {}
  
  public final void a(CharSequence paramCharSequence, long paramLong)
  {
    AppMethodBeat.i(36615);
    bv localbv = ((l)g.ab(l.class)).doJ().ys(paramLong);
    if (bu.isNullOrNil(localbv.field_talker))
    {
      ae.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(36615);
      return;
    }
    if ((localbv.field_flag & 0x10) == 0)
    {
      a.b(paramCharSequence, localbv);
      AppMethodBeat.o(36615);
      return;
    }
    ae.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(36615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.a.a
 * JD-Core Version:    0.7.0.1
 */