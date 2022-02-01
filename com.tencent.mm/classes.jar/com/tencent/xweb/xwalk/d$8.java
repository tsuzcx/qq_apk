package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import org.xwalk.core.R.id;
import org.xwalk.core.XWalkInitializeLog;

final class d$8
  implements View.OnClickListener
{
  d$8(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154159);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ((TextView)this.ainW.ainP.findViewById(R.id.txtVersion)).setText(this.ainW.Pb(true) + "\n\n" + XWalkInitializeLog.getXWalkInitializeLog());
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.8
 * JD-Core Version:    0.7.0.1
 */