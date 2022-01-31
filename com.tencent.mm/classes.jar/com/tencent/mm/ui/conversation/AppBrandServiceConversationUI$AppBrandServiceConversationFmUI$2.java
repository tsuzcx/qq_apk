package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2
  implements MMSlideDelView.f
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(33986);
    if (paramObject == null)
    {
      ab.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
      AppMethodBeat.o(33986);
      return;
    }
    paramObject = paramObject.toString();
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$800(this.AgB, paramObject);
    AppMethodBeat.o(33986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */