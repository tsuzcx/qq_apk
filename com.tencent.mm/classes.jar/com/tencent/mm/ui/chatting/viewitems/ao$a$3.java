package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.d.a;

final class ao$a$3
  implements View.OnClickListener
{
  ao$a$3(ao.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33358);
    paramView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramView).getTag();
    if (((ag)ao.a.a(this.zXK).ay(ag.class)).oF(paramView.cEE.field_msgId) == ChattingItemTranslate.b.zXw) {
      ((ag)ao.a.a(this.zXK).ay(ag.class)).a(paramView.cEE, true, paramView.position, 1);
    }
    AppMethodBeat.o(33358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.a.3
 * JD-Core Version:    0.7.0.1
 */