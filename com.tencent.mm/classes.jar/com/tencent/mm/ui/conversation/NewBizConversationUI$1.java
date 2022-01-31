package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class NewBizConversationUI$1
  implements MenuItem.OnMenuItemClickListener
{
  NewBizConversationUI$1(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (aa.Br(0)) {
      ((m)g.r(m.class)).a(ae.getContext(), new NewBizConversationUI.1.1(this));
    }
    for (;;)
    {
      return true;
      y.e("MicroMsg.NewBizConversationUI", "fts h5 template not avail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.1
 * JD-Core Version:    0.7.0.1
 */