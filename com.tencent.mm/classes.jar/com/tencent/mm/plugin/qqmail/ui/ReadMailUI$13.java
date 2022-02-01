package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ReadMailUI$13
  implements View.OnClickListener
{
  ReadMailUI$13(ReadMailUI paramReadMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(215349);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ReadMailUI.i(this.xhG).setVisibility(8);
    ReadMailUI.e(this.xhG);
    a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(215349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13
 * JD-Core Version:    0.7.0.1
 */