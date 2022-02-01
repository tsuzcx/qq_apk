package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$35
  implements View.OnClickListener
{
  d$35(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154188);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = (LinearLayout)this.SGe.SFW.findViewById(2131298987);
    if (((LinearLayout)localObject).getVisibility() == 8)
    {
      ((LinearLayout)localObject).setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
    }
    for (;;)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154188);
      return;
      ((LinearLayout)localObject).setVisibility(8);
      ((Button)paramView).setText("高级设置");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.35
 * JD-Core Version:    0.7.0.1
 */