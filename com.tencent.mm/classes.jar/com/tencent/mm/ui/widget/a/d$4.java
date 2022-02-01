package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$4
  implements View.OnClickListener
{
  d$4(d paramd, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159300);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.UWC != null) {
      this.UWC.onClick(this.Ymr, -1);
    }
    if (this.UWD) {
      this.Ymr.dismiss();
    }
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d.4
 * JD-Core Version:    0.7.0.1
 */