package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum BaseConversationUI$a
{
  static
  {
    AppMethodBeat.i(38184);
    KrU = new a("ACTIVITY_CREATE", 0);
    KrV = new a("ACTIVITY_RESUME", 1);
    KrW = new a("ACTIVITY_PAUSE", 2);
    KrX = new a[] { KrU, KrV, KrW };
    AppMethodBeat.o(38184);
  }
  
  private BaseConversationUI$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.a
 * JD-Core Version:    0.7.0.1
 */