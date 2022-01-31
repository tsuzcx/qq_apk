package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class NewBizConversationUI$6
  implements MMSlideDelView.f
{
  NewBizConversationUI$6(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(34537);
    if (paramObject == null)
    {
      ab.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
      AppMethodBeat.o(34537);
      return;
    }
    paramObject = paramObject.toString();
    NewBizConversationUI.b(this.AlC, paramObject);
    AppMethodBeat.o(34537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.6
 * JD-Core Version:    0.7.0.1
 */