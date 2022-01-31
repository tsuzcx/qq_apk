package com.tencent.mm.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseActivity$2
  implements View.OnClickListener
{
  BaseActivity$2(BaseActivity paramBaseActivity, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112446);
    this.ksX.onMenuItemClick(null);
    AppMethodBeat.o(112446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.2
 * JD-Core Version:    0.7.0.1
 */