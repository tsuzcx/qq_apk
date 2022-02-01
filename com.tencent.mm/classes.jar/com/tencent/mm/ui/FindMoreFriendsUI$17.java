package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;

final class FindMoreFriendsUI$17
  implements Runnable
{
  FindMoreFriendsUI$17(FindMoreFriendsUI paramFindMoreFriendsUI, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(33050);
    d.b(this.HiV.getContext(), "webview", ".ui.tools.WebViewUI", this.val$intent);
    AppMethodBeat.o(33050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.17
 * JD-Core Version:    0.7.0.1
 */