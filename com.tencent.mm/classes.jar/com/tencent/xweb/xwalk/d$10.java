package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$10
  implements View.OnClickListener
{
  d$10(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154161);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.aaht.iyG();
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.10
 * JD-Core Version:    0.7.0.1
 */