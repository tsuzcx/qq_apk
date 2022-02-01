package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.transmit.g.a;
import com.tencent.mm.ui.widget.a.f;

final class e$3
  implements View.OnClickListener
{
  e$3(e.f paramf, f paramf1, g.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(255208);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
    this.aeMW.aeOK = true;
    this.lCP.cyW();
    if (this.aeMX != null) {
      this.aeMX.jxp();
    }
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(255208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.3
 * JD-Core Version:    0.7.0.1
 */