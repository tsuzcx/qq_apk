package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.storage.ca;

final class e$c$1
  implements View.OnClickListener
{
  e$c$1(Boolean paramBoolean, long paramLong, String paramString1, String paramString2, ca paramca) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36760);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.Xex.booleanValue()) {
      m.aa(this.fgE, this.Xey);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36760);
      return;
      m.X(this.fgE, this.Xey);
      this.lrk.setStatus(5);
      bh.beI();
      c.bbO().Oq(this.fgE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.c.1
 * JD-Core Version:    0.7.0.1
 */