package com.tencent.mm.ui;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class q$1
  implements View.OnClickListener
{
  q$1(q paramq, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33391);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/LiteDependDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.UWC != null) {
      this.UWC.onClick(this.VYt, -1);
    }
    if (this.UWD) {
      this.VYt.dismiss();
    }
    a.a(this, "com/tencent/mm/ui/LiteDependDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(33391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.q.1
 * JD-Core Version:    0.7.0.1
 */