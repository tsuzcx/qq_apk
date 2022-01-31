package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class BaseConversationUI$c
  implements Runnable
{
  int aYY;
  int bQU;
  Intent bQV;
  int uQe = 0;
  
  private BaseConversationUI$c(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    if (au.DK())
    {
      y.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.uQe) });
      this.vPi.startChatting(BaseConversationUI.access$1500(this.vPi));
      ai.d(new BaseConversationUI.c.1(this));
      return;
    }
    if (this.uQe >= 3)
    {
      y.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
      return;
    }
    y.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", new Object[] { Integer.valueOf(this.uQe) });
    this.uQe += 1;
    ai.l(this, 300L);
  }
  
  public final String toString()
  {
    return super.toString() + "|PostSelectImageJob";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.c
 * JD-Core Version:    0.7.0.1
 */