package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class s$2
  implements View.OnClickListener
{
  s$2(s params) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152230);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/applet/ContactListRow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ContactListRow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(152230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.2
 * JD-Core Version:    0.7.0.1
 */