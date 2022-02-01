package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;

final class FindMoreFriendsUI$19
  implements Runnable
{
  FindMoreFriendsUI$19(FindMoreFriendsUI paramFindMoreFriendsUI, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(290403);
    c.b(this.VUs.getContext(), "webview", ".ui.tools.WebViewUI", this.val$intent);
    AppMethodBeat.o(290403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.19
 * JD-Core Version:    0.7.0.1
 */