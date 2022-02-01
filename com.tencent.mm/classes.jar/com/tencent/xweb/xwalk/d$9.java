package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.y;
import org.xwalk.core.XWalkEnvironment;

final class d$9
  implements View.OnClickListener
{
  d$9(d paramd, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154160);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = y.hsF();
    boolean bool;
    if (!y.hsF().SAa)
    {
      bool = true;
      paramView.Ej(bool);
      paramView = XWalkEnvironment.getXWalkUpdateConfigUrl();
      paramView = paramView.substring(paramView.lastIndexOf('/') + 1);
      paramView = "(当前为" + paramView + ")";
      localObject = this.SGi;
      if (!y.hsF().SAa) {
        break label145;
      }
    }
    label145:
    for (paramView = "使用正式版config".concat(String.valueOf(paramView));; paramView = "使用测试config".concat(String.valueOf(paramView)))
    {
      ((Button)localObject).setText(paramView);
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154160);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.9
 * JD-Core Version:    0.7.0.1
 */