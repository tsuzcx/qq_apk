package com.tencent.mm.ui.chatting.h;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.j;

final class d$2
  implements c.e
{
  d$2(d paramd) {}
  
  public final void a(int paramInt, c.b paramb)
  {
    y.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    d.a(this.vyO, paramb);
  }
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    y.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new j(paramView.getContext()).b(paramView, new d.2.1(this, paramb), new d.2.2(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d.2
 * JD-Core Version:    0.7.0.1
 */