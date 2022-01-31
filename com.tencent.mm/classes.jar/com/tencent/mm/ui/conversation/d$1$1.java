package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.y;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    y.d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
    this.vPL.vPK.vPG.notifyDataSetChanged();
    this.vPL.vPK.cHV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d.1.1
 * JD-Core Version:    0.7.0.1
 */