package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class e$15
  implements View.OnClickListener
{
  e$15(e parame, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251846);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.agef.acqV != null) {
      this.agef.acqV.onClick(this.aged, -2);
    }
    this.aged.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.15
 * JD-Core Version:    0.7.0.1
 */