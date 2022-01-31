package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseActivity$1
  implements MenuItem.OnMenuItemClickListener
{
  BaseActivity$1(BaseActivity paramBaseActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112445);
    this.yUh.finish();
    AppMethodBeat.o(112445);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.1
 * JD-Core Version:    0.7.0.1
 */