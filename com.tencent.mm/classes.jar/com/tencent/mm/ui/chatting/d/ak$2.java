package com.tencent.mm.ui.chatting.d;

import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.e.a;

final class ak$2
  implements Runnable
{
  ak$2(ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(35447);
    if (this.WMD.fgR != null)
    {
      Object localObject = (u)this.WMD.fgR.bC(u.class);
      ((u)localObject).hPj().setLbsMode(false);
      ((u)localObject).hPj().RjJ = false;
      ((u)localObject).hPj().hll();
      ChatFooter localChatFooter = ((u)localObject).hPj();
      localChatFooter.RjK = false;
      if (localChatFooter.Rjb != null) {
        localChatFooter.Rjb.setVisibility(0);
      }
      localChatFooter.Es(true);
      localObject = ((u)localObject).hPj();
      if (((ChatFooter)localObject).RiX != null) {
        ((ChatFooter)localObject).RiX.setVisibility(0);
      }
    }
    AppMethodBeat.o(35447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ak.2
 * JD-Core Version:    0.7.0.1
 */