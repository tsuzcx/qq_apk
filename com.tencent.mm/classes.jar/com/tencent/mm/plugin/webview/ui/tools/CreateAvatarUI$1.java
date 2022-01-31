package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CreateAvatarUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CreateAvatarUI$1(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7353);
    this.vam.finish();
    AppMethodBeat.o(7353);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.1
 * JD-Core Version:    0.7.0.1
 */