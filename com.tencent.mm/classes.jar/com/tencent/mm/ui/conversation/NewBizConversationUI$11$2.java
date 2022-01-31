package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class NewBizConversationUI$11$2
  implements n.d
{
  NewBizConversationUI$11$2(NewBizConversationUI.11 param11) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34545);
    switch (paramMenuItem.getItemId())
    {
    default: 
      ab.w("MicroMsg.NewBizConversationUI", "default onMMMenuItemSelected err");
      AppMethodBeat.o(34545);
      return;
    }
    paramMenuItem = new Intent(this.AlE.AlC.getContext(), BizTimeLineNewMsgUI.class);
    paramMenuItem.putExtra("biz_time_line_line_enter_scene", 2);
    this.AlE.AlC.startActivity(paramMenuItem);
    AppMethodBeat.o(34545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.11.2
 * JD-Core Version:    0.7.0.1
 */