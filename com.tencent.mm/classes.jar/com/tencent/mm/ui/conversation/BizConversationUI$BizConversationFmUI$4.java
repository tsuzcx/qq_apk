package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class BizConversationUI$BizConversationFmUI$4
  implements MMSlideDelView.c
{
  BizConversationUI$BizConversationFmUI$4(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(34119);
    int i = BizConversationUI.BizConversationFmUI.d(this.Ahf).getPositionForView(paramView);
    AppMethodBeat.o(34119);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.4
 * JD-Core Version:    0.7.0.1
 */