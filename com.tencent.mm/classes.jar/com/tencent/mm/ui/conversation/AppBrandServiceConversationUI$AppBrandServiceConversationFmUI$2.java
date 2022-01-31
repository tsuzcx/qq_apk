package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2
  implements MMSlideDelView.f
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
      return;
    }
    paramObject = paramObject.toString();
    AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$800(this.vOR, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */