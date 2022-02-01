package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200370);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.Lua.bqD();
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(200370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g.6
 * JD-Core Version:    0.7.0.1
 */