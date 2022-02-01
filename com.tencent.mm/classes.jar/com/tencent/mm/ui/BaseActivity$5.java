package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseActivity$5
  implements View.OnLongClickListener
{
  BaseActivity$5(BaseActivity paramBaseActivity, BaseActivity.b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(159090);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    boolean bool = BaseActivity.a(paramView, this.advj);
    a.a(bool, this, "com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(159090);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.5
 * JD-Core Version:    0.7.0.1
 */