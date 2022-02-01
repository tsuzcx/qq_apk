package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class e$8
  implements View.OnClickListener
{
  e$8(e parame, e.a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159298);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.ageg != null) {
      this.ageg.dTb();
    }
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.8
 * JD-Core Version:    0.7.0.1
 */