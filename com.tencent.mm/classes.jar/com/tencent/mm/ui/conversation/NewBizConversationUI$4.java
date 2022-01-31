package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class NewBizConversationUI$4
  implements MMSlideDelView.c
{
  NewBizConversationUI$4(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(34535);
    int i = NewBizConversationUI.f(this.AlC).getPositionForView(paramView);
    AppMethodBeat.o(34535);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.4
 * JD-Core Version:    0.7.0.1
 */