package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseActivity$4
  implements View.OnClickListener
{
  BaseActivity$4(BaseActivity paramBaseActivity, BaseActivity.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159089);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    BaseActivity.a(BaseActivity.b(this.VQZ), this.VRb);
    a.a(this, "com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.4
 * JD-Core Version:    0.7.0.1
 */