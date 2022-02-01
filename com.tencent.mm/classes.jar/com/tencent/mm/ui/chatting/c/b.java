package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.a.a.a;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements c
{
  public b()
  {
    AppMethodBeat.i(254128);
    com.tencent.mm.chatting.a.a.lPG = new a.a.a()
    {
      public final com.tencent.mm.chatting.a a(MMActivity paramAnonymousMMActivity)
      {
        AppMethodBeat.i(254131);
        paramAnonymousMMActivity = new a(paramAnonymousMMActivity);
        AppMethodBeat.o(254131);
        return paramAnonymousMMActivity;
      }
    };
    AppMethodBeat.o(254128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b
 * JD-Core Version:    0.7.0.1
 */