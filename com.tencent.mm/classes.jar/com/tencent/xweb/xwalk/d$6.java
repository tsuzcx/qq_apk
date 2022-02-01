package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import org.xwalk.core.XWalkInitializer;

final class d$6
  implements View.OnClickListener
{
  d$6(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154157);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ((TextView)this.MvU.MvM.findViewById(2131306169)).setText(this.MvU.zO(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.6
 * JD-Core Version:    0.7.0.1
 */