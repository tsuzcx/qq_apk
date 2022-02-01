package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import org.xwalk.core.XWalkEnvironment;

final class d$5
  implements View.OnClickListener
{
  d$5(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154156);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    XWalkEnvironment.clearAllVersion(this.aaht.aaaH);
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.5
 * JD-Core Version:    0.7.0.1
 */