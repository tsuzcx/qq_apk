package com.tencent.mm.ui.chatting.b;

import android.widget.ImageButton;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;

final class x$2
  implements Runnable
{
  x$2(x paramx) {}
  
  public final void run()
  {
    if (this.vrp.byx != null)
    {
      Object localObject = (n)this.vrp.byx.ac(n.class);
      ((n)localObject).cEq().setLbsMode(false);
      ((n)localObject).cEq().sfn = false;
      ((n)localObject).cEq().cne();
      ChatFooter localChatFooter = ((n)localObject).cEq();
      if (localChatFooter.seX != null) {
        localChatFooter.seX.setVisibility(0);
      }
      localObject = ((n)localObject).cEq();
      if (((ChatFooter)localObject).seU != null) {
        ((ChatFooter)localObject).seU.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.x.2
 * JD-Core Version:    0.7.0.1
 */