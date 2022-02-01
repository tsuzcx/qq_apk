package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$23
  implements View.OnLongClickListener
{
  d$23(d paramd) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(154176);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    this.ainW.kjf();
    a.a(true, this, "com/tencent/xweb/xwalk/WebDebugPage$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(154176);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.23
 * JD-Core Version:    0.7.0.1
 */