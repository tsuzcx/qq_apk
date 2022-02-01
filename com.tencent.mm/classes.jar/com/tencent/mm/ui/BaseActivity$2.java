package com.tencent.mm.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseActivity$2
  implements View.OnClickListener
{
  BaseActivity$2(BaseActivity paramBaseActivity, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159087);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/BaseActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.Jod.onMenuItemClick(null);
    a.a(this, "com/tencent/mm/ui/BaseActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.2
 * JD-Core Version:    0.7.0.1
 */