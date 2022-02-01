package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class a$b$2
  implements View.OnClickListener
{
  a$b$2(a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202089);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    try
    {
      this.DxC.sendRequest();
      label41:
      a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/impl/AdCouponActionButtonClick$AdCouponHalfScreenPrompt$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202089);
      return;
    }
    catch (Throwable paramView)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.2
 * JD-Core Version:    0.7.0.1
 */