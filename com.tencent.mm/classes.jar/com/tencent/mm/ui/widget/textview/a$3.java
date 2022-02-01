package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ap;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159852);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ap.d("SelectableTextHelper", "onClick", new Object[0]);
    if (this.LfZ.gMe != null) {
      this.LfZ.gMe.onClick(paramView);
    }
    this.LfZ.LfQ = true;
    this.LfZ.LfR = true;
    this.LfZ.fNs();
    this.LfZ.fNt();
    if (this.LfZ.LfB != null) {
      this.LfZ.LfB.dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/textview/SelectableTextHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.3
 * JD-Core Version:    0.7.0.1
 */