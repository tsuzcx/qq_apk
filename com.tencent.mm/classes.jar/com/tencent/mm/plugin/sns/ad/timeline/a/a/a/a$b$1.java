package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class a$b$1
  implements View.OnClickListener
{
  a$b$1(a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202088);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    try
    {
      if ((this.DxC.oXS != null) && (this.DxC.oXS.isShowing())) {
        this.DxC.oXS.bMo();
      }
      label67:
      a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202088);
      return;
    }
    catch (Throwable paramView)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.1
 * JD-Core Version:    0.7.0.1
 */