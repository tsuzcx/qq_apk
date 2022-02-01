package com.tencent.mm.ui.chatting.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class aw$8
  implements View.OnClickListener
{
  aw$8(aw paramaw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35547);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(35547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aw.8
 * JD-Core Version:    0.7.0.1
 */