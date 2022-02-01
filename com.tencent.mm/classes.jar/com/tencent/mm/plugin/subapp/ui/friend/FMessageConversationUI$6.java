package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FMessageConversationUI$6
  implements MenuItem.OnMenuItemClickListener
{
  FMessageConversationUI$6(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(29042);
    this.BiI.finish();
    AppMethodBeat.o(29042);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.6
 * JD-Core Version:    0.7.0.1
 */