package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;

final class FindMoreFriendsUI$18
  implements Runnable
{
  FindMoreFriendsUI$18(FindMoreFriendsUI paramFindMoreFriendsUI, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(232491);
    c.b(this.OBd.getContext(), "webview", ".ui.tools.WebViewUI", this.val$intent);
    AppMethodBeat.o(232491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.18
 * JD-Core Version:    0.7.0.1
 */