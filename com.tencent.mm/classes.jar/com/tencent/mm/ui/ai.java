package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.chatting.viewitems.e.g;

public final class ai
  implements View.OnClickListener
{
  com.tencent.mm.ui.chatting.d.a adHw;
  
  public ai(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.adHw = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33517);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getTag() instanceof e.g))
    {
      u.li(paramView);
      this.adHw.dcZ();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(33517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ai
 * JD-Core Version:    0.7.0.1
 */