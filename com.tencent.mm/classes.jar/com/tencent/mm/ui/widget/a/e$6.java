package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class e$6
  implements View.OnClickListener
{
  e$6(e parame, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251776);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.agef.acqY != null) {
      this.agef.acqY.onClick(this.aged, -3);
    }
    this.aged.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.6
 * JD-Core Version:    0.7.0.1
 */