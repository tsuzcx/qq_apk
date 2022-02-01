package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.e.g;

public final class ab
  implements View.OnClickListener
{
  com.tencent.mm.ui.chatting.e.a Jdu;
  
  public ab(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.Jdu = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33517);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView.getTag() instanceof e.g))
    {
      r.gj(paramView);
      this.Jdu.bOo();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(33517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */