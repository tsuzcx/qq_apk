package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum BaseConversationUI$a
{
  static
  {
    AppMethodBeat.i(34065);
    AgX = new a("ACTIVITY_CREATE", 0);
    AgY = new a("ACTIVITY_RESUME", 1);
    AgZ = new a("ACTIVITY_PAUSE", 2);
    Aha = new a[] { AgX, AgY, AgZ };
    AppMethodBeat.o(34065);
  }
  
  private BaseConversationUI$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.a
 * JD-Core Version:    0.7.0.1
 */