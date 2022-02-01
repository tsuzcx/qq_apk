package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FMessageConversationUI$7
  implements MenuItem.OnMenuItemClickListener
{
  FMessageConversationUI$7(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(289554);
    this.MeO.finish();
    AppMethodBeat.o(289554);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.7
 * JD-Core Version:    0.7.0.1
 */