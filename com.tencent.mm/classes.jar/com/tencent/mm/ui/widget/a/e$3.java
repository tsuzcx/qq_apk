package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class e$3
  implements View.OnClickListener
{
  e$3(e parame, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251769);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.acrP != null) {
      this.acrP.onClick(this.aged, -2);
    }
    if (this.acrQ) {
      this.aged.cancel();
    }
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.3
 * JD-Core Version:    0.7.0.1
 */