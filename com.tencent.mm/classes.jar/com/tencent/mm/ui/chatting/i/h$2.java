package com.tencent.mm.ui.chatting.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.l;

final class h$2
  implements c.e
{
  h$2(h paramh) {}
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(32644);
    ab.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramb == null)
    {
      ab.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(32644);
      return;
    }
    paramb = (h.a)paramb;
    if (paramb.getType() == 5)
    {
      h.a(this.zPF, paramView, paramb);
      AppMethodBeat.o(32644);
      return;
    }
    if (paramb.getType() == 7)
    {
      h.a(this.zPF, paramb);
      AppMethodBeat.o(32644);
      return;
    }
    if (paramb.getType() == 15)
    {
      h.b(this.zPF, paramb);
      AppMethodBeat.o(32644);
      return;
    }
    if (paramb.getType() == 26)
    {
      h.c(this.zPF, paramb);
      AppMethodBeat.o(32644);
      return;
    }
    if (paramb.getType() == 27)
    {
      h.d(this.zPF, paramb);
      AppMethodBeat.o(32644);
      return;
    }
    ab.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[] { Integer.valueOf(paramb.getType()) });
    AppMethodBeat.o(32644);
  }
  
  public final void b(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(32645);
    ab.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new l(paramView.getContext()).b(paramView, new h.2.1(this), new h.2.2(this, paramb, paramInt));
    AppMethodBeat.o(32645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.h.2
 * JD-Core Version:    0.7.0.1
 */