package com.tencent.mm.view.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.chat.j;

public final class a$4
  implements View.OnClickListener
{
  public a$4(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105282);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/manager/SmileyPanelManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (a.h(this.LRn) != null) {
      a.h(this.LRn).ddB();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/manager/SmileyPanelManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(105282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.d.a.4
 * JD-Core Version:    0.7.0.1
 */