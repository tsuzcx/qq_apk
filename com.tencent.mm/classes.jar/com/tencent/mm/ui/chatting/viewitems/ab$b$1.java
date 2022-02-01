package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ab$b$1
  implements View.OnLongClickListener
{
  ab$b$1(ab.b paramb, ab.a parama, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc) {}
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(255318);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
    try
    {
      final long l = ((Long)this.aeQV.aeQs.getTag(ab.b.access$300())).longValue();
      if (!com.tencent.mm.plugin.msgquote.model.a.gdN())
      {
        Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV long click disable:%s", new Object[] { Long.valueOf(l) });
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(255318);
        return true;
      }
      Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV long click msgId:%s", new Object[] { Long.valueOf(l) });
      localObject = (MsgQuoteItem)this.aeQV.Aoo.getTag();
      ((ao)this.XSz.cm(ao.class)).d(paramView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255685);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ab.e.a(ab.b.1.this.XSz, ab.b.1.this.oiL, paramView, l, this.aeQX, ab.b.1.this.aeQW.wQm);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255685);
        }
      });
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV long click Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(255318);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b.1
 * JD-Core Version:    0.7.0.1
 */