package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class PrepareBindXMailUI$2
  implements View.OnClickListener
{
  PrepareBindXMailUI$2(PrepareBindXMailUI paramPrepareBindXMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(266965);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.NoW.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.2
 * JD-Core Version:    0.7.0.1
 */