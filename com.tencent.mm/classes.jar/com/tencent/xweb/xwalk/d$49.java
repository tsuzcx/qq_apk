package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$49
  implements View.OnClickListener
{
  d$49(d paramd, CheckBox paramCheckBox) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154212);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = this.MTD;
    if (!this.MTD.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154212);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.49
 * JD-Core Version:    0.7.0.1
 */