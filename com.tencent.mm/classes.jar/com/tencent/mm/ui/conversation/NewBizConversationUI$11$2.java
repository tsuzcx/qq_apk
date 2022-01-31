package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class NewBizConversationUI$11$2
  implements n.d
{
  NewBizConversationUI$11$2(NewBizConversationUI.11 param11) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      y.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
      return;
    }
    paramMenuItem = new Intent(this.vTI.vTG.mController.uMN, BizTimeLineNewMsgUI.class);
    paramMenuItem.putExtra("biz_time_line_line_enter_scene", 2);
    this.vTI.vTG.startActivity(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.11.2
 * JD-Core Version:    0.7.0.1
 */