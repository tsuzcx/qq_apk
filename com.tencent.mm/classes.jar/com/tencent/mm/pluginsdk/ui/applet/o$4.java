package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.p;

final class o$4
  implements View.OnClickListener
{
  o$4(y.a parama, View paramView, p paramp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232192);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.Kfe != null) {
      this.Kfe.a(true, o.gj(this.val$view), o.gk(this.val$view));
    }
    this.Kff.dismiss();
    this.Kff.setFocusable(false);
    this.Kff.setTouchable(false);
    a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ConfirmDialog$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.4
 * JD-Core Version:    0.7.0.1
 */