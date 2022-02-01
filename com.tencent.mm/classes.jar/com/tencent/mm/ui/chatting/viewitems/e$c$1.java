package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.storage.cc;

final class e$c$1
  implements View.OnClickListener
{
  e$c$1(Boolean paramBoolean, long paramLong, cc paramcc, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36760);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.aeOv.booleanValue()) {
      n.i(this.hkO, this.oiL.field_talker, this.aeOw);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36760);
      return;
      n.am(this.hkO, this.aeOw);
      this.oiL.setStatus(5);
      bh.bCz();
      c.bzD().sl(this.hkO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.c.1
 * JD-Core Version:    0.7.0.1
 */