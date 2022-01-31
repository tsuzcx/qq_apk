package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ResourcesExceedUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ResourcesExceedUI$1(ResourcesExceedUI paramResourcesExceedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30984);
    this.zCd.finish();
    AppMethodBeat.o(30984);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ResourcesExceedUI.1
 * JD-Core Version:    0.7.0.1
 */