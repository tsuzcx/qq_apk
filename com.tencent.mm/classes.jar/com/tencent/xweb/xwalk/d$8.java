package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;

final class d$8
  implements View.OnClickListener
{
  d$8(d paramd, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154159);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = this.aaht;
    localObject = this.aahw;
    int i = paramView.aahe.getSettings().getForceDarkMode();
    int j = paramView.aahe.getSettings().getForceDarkBehavior();
    if ((i != 0) && (i == 2)) {
      if (j == 2) {
        paramView.aahe.getSettings().setForceDarkBehavior(1);
      }
    }
    for (;;)
    {
      paramView.f((Button)localObject);
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154159);
      return;
      if (j == 1)
      {
        paramView.aahe.getSettings().setForceDarkMode(0);
      }
      else if (j == 0)
      {
        paramView.aahe.getSettings().setForceDarkMode(0);
      }
      else
      {
        paramView.aahe.getSettings().setForceDarkMode(2);
        paramView.aahe.getSettings().setForceDarkBehavior(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.8
 * JD-Core Version:    0.7.0.1
 */