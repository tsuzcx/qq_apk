package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$16
  implements View.OnClickListener
{
  d$16(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212906);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    d.pb(this.ainW.mContext);
    Toast.makeText(this.ainW.mContext, "开始检测插件更新", 0).show();
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.16
 * JD-Core Version:    0.7.0.1
 */