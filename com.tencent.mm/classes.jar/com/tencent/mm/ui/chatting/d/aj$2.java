package com.tencent.mm.ui.chatting.d;

import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.e.a;

final class aj$2
  implements Runnable
{
  aj$2(aj paramaj) {}
  
  public final void run()
  {
    AppMethodBeat.i(35447);
    if (this.Psc.dom != null)
    {
      Object localObject = (u)this.Psc.dom.bh(u.class);
      ((u)localObject).gPO().setLbsMode(false);
      ((u)localObject).gPO().KiV = false;
      ((u)localObject).gPO().gqm();
      ChatFooter localChatFooter = ((u)localObject).gPO();
      localChatFooter.KiW = false;
      if (localChatFooter.Kir != null) {
        localChatFooter.Kir.setVisibility(0);
      }
      localChatFooter.Am(true);
      localObject = ((u)localObject).gPO();
      if (((ChatFooter)localObject).Kin != null) {
        ((ChatFooter)localObject).Kin.setVisibility(0);
      }
    }
    AppMethodBeat.o(35447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aj.2
 * JD-Core Version:    0.7.0.1
 */