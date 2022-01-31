package com.tencent.mm.ui.conversation;

import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.z;

final class n$10
  implements Runnable
{
  n$10(n paramn) {}
  
  public final void run()
  {
    Object localObject = this.vTV;
    LauncherUI localLauncherUI = (LauncherUI)((n)localObject).bMV;
    if ((localLauncherUI == null) || (localLauncherUI.uKP.uKi.jVi == 0))
    {
      localObject = ((n)localObject).vTt;
      if (((ConversationWithAppBrandListView)localObject).getFirstVisiblePosition() > ((ConversationWithAppBrandListView)localObject).getFirstHeaderVisible() + 16) {
        ((ConversationWithAppBrandListView)localObject).setSelection(((ConversationWithAppBrandListView)localObject).getFirstHeaderVisible() + 16);
      }
      ((ConversationWithAppBrandListView)localObject).post(new ConversationWithAppBrandListView.24((ConversationWithAppBrandListView)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.10
 * JD-Core Version:    0.7.0.1
 */