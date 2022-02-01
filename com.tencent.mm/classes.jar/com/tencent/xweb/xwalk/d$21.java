package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$21
  implements View.OnClickListener
{
  d$21(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212940);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    d.du(this.ainW.mContext, this.ainW.ainL);
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.21
 * JD-Core Version:    0.7.0.1
 */