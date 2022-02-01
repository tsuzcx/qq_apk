package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class u$3
  implements View.OnClickListener
{
  u$3(p paramp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142232);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.OTQ.dismiss();
    a.a(this, "com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(142232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.u.3
 * JD-Core Version:    0.7.0.1
 */