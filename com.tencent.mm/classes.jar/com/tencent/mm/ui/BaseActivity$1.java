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
    AppMethodBeat.i(159086);
    this.Joc.finish();
    AppMethodBeat.o(159086);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.1
 * JD-Core Version:    0.7.0.1
 */