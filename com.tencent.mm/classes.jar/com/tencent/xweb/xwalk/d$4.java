package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView;
import org.xwalk.core.Log;

final class d$4
  implements View.OnClickListener
{
  d$4(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154155);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.ainW.ainP.setVisibility(8);
    paramView = this.ainW;
    Log.i("WebDebugPage", "killRendererProcess");
    paramView.ainK.loadUrl("chrome://crash");
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.4
 * JD-Core Version:    0.7.0.1
 */