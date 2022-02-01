package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class q$1
  implements View.OnClickListener
{
  q$1(q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152179);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/applet/ContactListAnchor$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
    a.a(this, "com/tencent/mm/pluginsdk/ui/applet/ContactListAnchor$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(152179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.q.1
 * JD-Core Version:    0.7.0.1
 */