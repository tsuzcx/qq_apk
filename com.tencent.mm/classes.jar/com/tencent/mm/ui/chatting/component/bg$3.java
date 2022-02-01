package com.tencent.mm.ui.chatting.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class bg$3
  implements View.OnClickListener
{
  bg$3(bg parambg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35540);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(35540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bg.3
 * JD-Core Version:    0.7.0.1
 */