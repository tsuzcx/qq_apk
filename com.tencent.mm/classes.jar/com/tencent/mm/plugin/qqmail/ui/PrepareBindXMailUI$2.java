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
    AppMethodBeat.i(250503);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Hrj.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(250503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.2
 * JD-Core Version:    0.7.0.1
 */