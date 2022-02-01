package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import org.xwalk.core.R.id;

final class d$42
  implements View.OnClickListener
{
  d$42(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212827);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = (LinearLayout)this.ainW.ainP.findViewById(R.id.config_memu);
    if (((LinearLayout)localObject).getVisibility() == 8)
    {
      ((LinearLayout)localObject).setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
    }
    for (;;)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212827);
      return;
      ((LinearLayout)localObject).setVisibility(8);
      ((Button)paramView).setText("高级设置");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.42
 * JD-Core Version:    0.7.0.1
 */