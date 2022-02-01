package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$31
  implements View.OnClickListener
{
  d$31(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154184);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = (LinearLayout)this.MvU.MvM.findViewById(2131298553);
    if (((LinearLayout)localObject).getVisibility() == 8)
    {
      ((LinearLayout)localObject).setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
    }
    for (;;)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154184);
      return;
      ((LinearLayout)localObject).setVisibility(8);
      ((Button)paramView).setText("高级设置");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.31
 * JD-Core Version:    0.7.0.1
 */