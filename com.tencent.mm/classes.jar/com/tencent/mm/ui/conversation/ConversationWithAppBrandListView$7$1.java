package com.tencent.mm.ui.conversation;

final class ConversationWithAppBrandListView$7$1
  implements Runnable
{
  ConversationWithAppBrandListView$7$1(ConversationWithAppBrandListView.7 param7) {}
  
  public final void run()
  {
    if (!this.vRX.vRW)
    {
      ConversationWithAppBrandListView.i(this.vRX.vRV);
      return;
    }
    ConversationWithAppBrandListView.e(this.vRX.vRV, true);
    ConversationWithAppBrandListView.j(this.vRX.vRV);
    this.vRX.vRV.postDelayed(new ConversationWithAppBrandListView.7.1.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.7.1
 * JD-Core Version:    0.7.0.1
 */