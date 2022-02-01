package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;

final class d$10
  implements View.OnClickListener
{
  d$10(d paramd, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154161);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = this.ainW;
    localObject = this.ainZ;
    int i = paramView.ainK.getSettings().getForceDarkMode();
    int j = paramView.ainK.getSettings().getForceDarkBehavior();
    if ((i != 0) && (i == 2)) {
      if (j == 2) {
        paramView.ainK.getSettings().setForceDarkBehavior(1);
      }
    }
    for (;;)
    {
      paramView.d((Button)localObject);
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154161);
      return;
      if (j == 1)
      {
        paramView.ainK.getSettings().setForceDarkMode(0);
      }
      else if (j == 0)
      {
        paramView.ainK.getSettings().setForceDarkMode(0);
      }
      else
      {
        paramView.ainK.getSettings().setForceDarkMode(2);
        paramView.ainK.getSettings().setForceDarkBehavior(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.10
 * JD-Core Version:    0.7.0.1
 */