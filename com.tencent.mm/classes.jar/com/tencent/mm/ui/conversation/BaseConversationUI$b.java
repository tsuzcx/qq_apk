package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class BaseConversationUI$b
  implements Runnable
{
  int bpE;
  Intent cyu;
  int requestCode;
  int zep = 0;
  
  private BaseConversationUI$b(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34074);
    if (aw.RG())
    {
      ab.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.zep) });
      this.AgT.startChatting(BaseConversationUI.access$1500(this.AgT));
      al.d(new BaseConversationUI.b.1(this));
      AppMethodBeat.o(34074);
      return;
    }
    if (this.zep >= 3)
    {
      ab.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
      AppMethodBeat.o(34074);
      return;
    }
    ab.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", new Object[] { Integer.valueOf(this.zep) });
    this.zep += 1;
    al.p(this, 300L);
    AppMethodBeat.o(34074);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(34075);
    String str = super.toString() + "|PostSelectImageJob";
    AppMethodBeat.o(34075);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.b
 * JD-Core Version:    0.7.0.1
 */