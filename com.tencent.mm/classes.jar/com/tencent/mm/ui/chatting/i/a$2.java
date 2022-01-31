package com.tencent.mm.ui.chatting.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.l;

final class a$2
  implements c.e
{
  a$2(a parama) {}
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(32509);
    ab.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    a.a(this.zOW, (a.a)paramb);
    AppMethodBeat.o(32509);
  }
  
  public final void b(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(32510);
    ab.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new l(paramView.getContext()).b(paramView, new a.2.1(this), new a.2.2(this, paramb));
    AppMethodBeat.o(32510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a.2
 * JD-Core Version:    0.7.0.1
 */