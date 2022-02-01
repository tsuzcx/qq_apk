package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.component.api.r;
import com.tencent.mm.ui.chatting.component.api.x;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=r.class)
class u
  extends a
  implements r
{
  public final void jjh()
  {
    AppMethodBeat.i(256152);
    super.jjh();
    if (!ac.hGo())
    {
      Object localObject = ((x)this.hlc.cm(x.class)).jsd();
      if ((localObject != null) && (au.bwY(this.hlc.Uxa.field_username)))
      {
        localObject = ((ChatFooter)localObject).getChatFooterPanel();
        if (localObject != null)
        {
          ((ChatFooterPanel)localObject).setShowSearch(false);
          ((ChatFooterPanel)localObject).bDL();
        }
      }
    }
    AppMethodBeat.o(256152);
  }
  
  public final boolean jrT()
  {
    AppMethodBeat.i(256145);
    boolean bool = au.bwY(this.hlc.getTalkerUserName());
    AppMethodBeat.o(256145);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.u
 * JD-Core Version:    0.7.0.1
 */