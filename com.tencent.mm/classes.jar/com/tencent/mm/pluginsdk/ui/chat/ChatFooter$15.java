package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class ChatFooter$15
  implements AppPanel.b
{
  ChatFooter$15(ChatFooter paramChatFooter) {}
  
  public final void dnZ()
  {
    AppMethodBeat.i(155424);
    boolean bool = b.a(ChatFooter.b(this.vXU), "android.permission.RECORD_AUDIO", 80, "", "");
    ab.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), ChatFooter.b(this.vXU) });
    if (!bool)
    {
      AppMethodBeat.o(155424);
      return;
    }
    int i = aw.Rc().adt();
    if ((i == 4) || (i == 6))
    {
      ChatFooter.ag(this.vXU);
      AppMethodBeat.o(155424);
      return;
    }
    if ((ChatFooter.k(this.vXU) == null) || (!ChatFooter.k(this.vXU).isShowing())) {
      ChatFooter.a(this.vXU, h.h(this.vXU.getContext(), 2131304713, 2131297087));
    }
    AppMethodBeat.o(155424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.15
 * JD-Core Version:    0.7.0.1
 */