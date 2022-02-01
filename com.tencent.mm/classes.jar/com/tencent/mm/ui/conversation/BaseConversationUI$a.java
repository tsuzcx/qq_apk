package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum BaseConversationUI$a
{
  static
  {
    AppMethodBeat.i(38184);
    afmj = new a("ACTIVITY_CREATE", 0);
    afmk = new a("ACTIVITY_RESUME", 1);
    afml = new a("ACTIVITY_PAUSE", 2);
    afmm = new a[] { afmj, afmk, afml };
    AppMethodBeat.o(38184);
  }
  
  private BaseConversationUI$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.a
 * JD-Core Version:    0.7.0.1
 */