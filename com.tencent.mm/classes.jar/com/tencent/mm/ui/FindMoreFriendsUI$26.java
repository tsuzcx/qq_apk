package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;

final class FindMoreFriendsUI$26
  implements Runnable
{
  FindMoreFriendsUI$26(FindMoreFriendsUI paramFindMoreFriendsUI, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(250133);
    c.b(this.adyF.getContext(), "webview", ".ui.tools.WebViewUI", this.val$intent);
    AppMethodBeat.o(250133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.26
 * JD-Core Version:    0.7.0.1
 */