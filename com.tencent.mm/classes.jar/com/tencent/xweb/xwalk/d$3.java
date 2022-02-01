package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$3
  implements View.OnClickListener
{
  d$3(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154154);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.MvU.MvM.setVisibility(8);
    this.MvU.bgm();
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.3
 * JD-Core Version:    0.7.0.1
 */