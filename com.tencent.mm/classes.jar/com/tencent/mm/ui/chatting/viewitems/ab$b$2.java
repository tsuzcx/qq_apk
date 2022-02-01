package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ab$b$2
  implements View.OnClickListener
{
  ab$b$2(ab.b paramb, ab.a parama, com.tencent.mm.ui.chatting.d.a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(255320);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    try
    {
      long l = ((Long)this.aeQV.aeQs.getTag(ab.b.access$300())).longValue();
      Log.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
      localObject = (MsgQuoteItem)this.aeQV.Aoo.getTag();
      ab.e.a(this.XSz, this.aeQW, paramView, l, (MsgQuoteItem)localObject, this.aeQW.wQm);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255320);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b.2
 * JD-Core Version:    0.7.0.1
 */