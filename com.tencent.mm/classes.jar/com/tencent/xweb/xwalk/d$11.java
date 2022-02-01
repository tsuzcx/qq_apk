package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$11
  implements View.OnClickListener
{
  d$11(d paramd, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154162);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.aahy.getVisibility() == 8)
    {
      this.aahy.setVisibility(0);
      ((Button)paramView).setText("隐藏插件设置");
    }
    for (;;)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154162);
      return;
      this.aahy.setVisibility(8);
      ((Button)paramView).setText("插件设置");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.11
 * JD-Core Version:    0.7.0.1
 */