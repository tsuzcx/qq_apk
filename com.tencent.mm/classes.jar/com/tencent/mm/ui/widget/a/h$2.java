package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.p;

public final class h$2
  implements View.OnClickListener
{
  public h$2(p paramp, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198282);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.OTQ.dismiss();
    if (this.QOV != null) {
      this.QOV.onClick(paramView);
    }
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h.2
 * JD-Core Version:    0.7.0.1
 */