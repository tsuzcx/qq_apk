package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;

final class am$2
  implements ChatFooter.c
{
  am$2(am paramam) {}
  
  public final void a(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(31740);
    if (paramBoolean1.booleanValue())
    {
      if (paramBoolean2.booleanValue())
      {
        paramBoolean1 = this.zIC;
        paramBoolean2 = Boolean.TRUE;
        am.a(paramBoolean1, paramBoolean2, paramBoolean2);
        AppMethodBeat.o(31740);
        return;
      }
      am.a(this.zIC, Boolean.FALSE, Boolean.TRUE);
    }
    AppMethodBeat.o(31740);
  }
  
  public final void b(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(31741);
    if (paramBoolean1.booleanValue())
    {
      if (paramBoolean2.booleanValue())
      {
        am.a(this.zIC, Boolean.TRUE, Boolean.FALSE);
        AppMethodBeat.o(31741);
        return;
      }
      paramBoolean1 = this.zIC;
      paramBoolean2 = Boolean.FALSE;
      am.a(paramBoolean1, paramBoolean2, paramBoolean2);
    }
    AppMethodBeat.o(31741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.am.2
 * JD-Core Version:    0.7.0.1
 */