package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class c$b$6
  implements View.OnClickListener
{
  public c$b$6(c.b paramb, InstantAutoCompleteTextView paramInstantAutoCompleteTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67281);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/recharge/ui/form/MallCommonHintViewConfig$MobileConfigure$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.HBx.requestFocus();
    a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallCommonHintViewConfig$MobileConfigure$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.b.6
 * JD-Core Version:    0.7.0.1
 */