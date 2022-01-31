package com.tencent.mm.ui.chatting.h;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.j;

final class h$2
  implements c.e
{
  h$2(h paramh) {}
  
  public final void a(int paramInt, c.b paramb)
  {
    y.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramb == null)
    {
      y.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramb = (h.a)paramb;
    if (paramb.getType() == 5)
    {
      h.a(this.vzi, paramb);
      return;
    }
    if (paramb.getType() == 7)
    {
      h.b(this.vzi, paramb);
      return;
    }
    if (paramb.getType() == 15)
    {
      h.c(this.vzi, paramb);
      return;
    }
    if (paramb.getType() == 26)
    {
      h.d(this.vzi, paramb);
      return;
    }
    if (paramb.getType() == 27)
    {
      h.e(this.vzi, paramb);
      return;
    }
    y.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[] { Integer.valueOf(paramb.getType()) });
  }
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    y.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new j(paramView.getContext()).b(paramView, new h.2.1(this), new h.2.2(this, paramb, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.h.2
 * JD-Core Version:    0.7.0.1
 */