package com.tencent.mm.ui.voicesearch;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SearchConversationResultUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SearchConversationResultUI$2(SearchConversationResultUI paramSearchConversationResultUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35316);
    this.ABB.finish();
    AppMethodBeat.o(35316);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI.2
 * JD-Core Version:    0.7.0.1
 */