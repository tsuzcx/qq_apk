package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ReadMailUI$14
  implements View.OnClickListener
{
  ReadMailUI$14(ReadMailUI paramReadMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(123162);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ReadMailUI.y(this.xhG);
    a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(123162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.14
 * JD-Core Version:    0.7.0.1
 */