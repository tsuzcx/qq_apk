package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.storage.cc;

final class e$c$2
  implements View.OnClickListener
{
  e$c$2(Boolean paramBoolean, long paramLong, String paramString, cc paramcc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36761);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!this.aeOv.booleanValue())
    {
      n.an(this.hkO, this.aeOw);
      this.oiL.setStatus(1);
      bh.bCz();
      c.bzD().sl(this.hkO);
    }
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.c.2
 * JD-Core Version:    0.7.0.1
 */