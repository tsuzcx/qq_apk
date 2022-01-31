package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseActivity$5
  implements View.OnLongClickListener
{
  BaseActivity$5(BaseActivity paramBaseActivity, BaseActivity.b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(112449);
    boolean bool = BaseActivity.a(paramView, this.yUi);
    AppMethodBeat.o(112449);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.5
 * JD-Core Version:    0.7.0.1
 */