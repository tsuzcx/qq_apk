package com.tencent.mm.ui.chatting.h;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.j;

final class a$2
  implements c.e
{
  a$2(a parama) {}
  
  public final void a(int paramInt, c.b paramb)
  {
    y.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    a.a(this.vyA, (a.a)paramb);
  }
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    y.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new j(paramView.getContext()).b(paramView, new a.2.1(this), new a.2.2(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a.2
 * JD-Core Version:    0.7.0.1
 */