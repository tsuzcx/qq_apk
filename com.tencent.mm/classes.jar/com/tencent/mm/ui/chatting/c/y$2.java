package com.tencent.mm.ui.chatting.c;

import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;

final class y$2
  implements Runnable
{
  y$2(y paramy) {}
  
  public final void run()
  {
    AppMethodBeat.i(31552);
    if (this.zGU.caz != null)
    {
      Object localObject = (o)this.zGU.caz.ay(o.class);
      ((o)localObject).dIg().setLbsMode(false);
      ((o)localObject).dIg().vWu = false;
      ((o)localObject).dIg().doh();
      ChatFooter localChatFooter = ((o)localObject).dIg();
      if (localChatFooter.vWc != null) {
        localChatFooter.vWc.setVisibility(0);
      }
      localObject = ((o)localObject).dIg();
      if (((ChatFooter)localObject).vVY != null) {
        ((ChatFooter)localObject).vVY.setVisibility(0);
      }
    }
    AppMethodBeat.o(31552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y.2
 * JD-Core Version:    0.7.0.1
 */