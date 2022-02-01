package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.xwalk.updater.f;

final class d$6
  implements View.OnClickListener
{
  d$6(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154157);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    f.ph(this.ainW.mContext);
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.6
 * JD-Core Version:    0.7.0.1
 */