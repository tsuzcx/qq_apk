package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.e.g;

public final class af
  implements View.OnClickListener
{
  com.tencent.mm.ui.chatting.e.a WbU;
  
  public af(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.WbU = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33517);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView.getTag() instanceof e.g))
    {
      s.hL(paramView);
      this.WbU.cAe();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(33517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.af
 * JD-Core Version:    0.7.0.1
 */