package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.util.c;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.h;

final class d$20
  implements View.OnClickListener
{
  d$20(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154173);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = h.brX(this.SGe.SFQ);
    if (paramView == null)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154173);
      return;
    }
    int i = paramView.hvk();
    if (i < 0)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154173);
      return;
    }
    localObject = paramView.atd(i);
    paramView.atc(-1);
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      c.bsB((String)localObject);
    }
    Toast.makeText(this.SGe.SzQ, "清理完成", 0).show();
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.20
 * JD-Core Version:    0.7.0.1
 */