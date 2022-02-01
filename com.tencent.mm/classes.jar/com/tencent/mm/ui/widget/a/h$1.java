package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.o;

public final class h$1
  implements View.OnClickListener
{
  public h$1(o paramo, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192630);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.Jol.dismiss();
    if (this.KXD != null) {
      this.KXD.onClick(paramView);
    }
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(192630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h.1
 * JD-Core Version:    0.7.0.1
 */