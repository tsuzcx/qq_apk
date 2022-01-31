package com.tencent.mm.ui.websearch;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebSearchBaseActivity$1
  implements MenuItem.OnMenuItemClickListener
{
  WebSearchBaseActivity$1(WebSearchBaseActivity paramWebSearchBaseActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35380);
    this.ABQ.finish();
    AppMethodBeat.o(35380);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.websearch.WebSearchBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */