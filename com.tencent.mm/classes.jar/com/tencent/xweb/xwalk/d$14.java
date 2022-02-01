package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$14
  implements View.OnClickListener
{
  d$14(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154165);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    d.lF(this.SGe.SzQ);
    Toast.makeText(this.SGe.SzQ, "开始检测插件更新", 0).show();
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.14
 * JD-Core Version:    0.7.0.1
 */