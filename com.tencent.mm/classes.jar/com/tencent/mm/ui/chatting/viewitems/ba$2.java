package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ba$2
  extends am.a
{
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(33447);
    ab.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      AppMethodBeat.o(33447);
      return true;
    }
    AppMethodBeat.o(33447);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.2
 * JD-Core Version:    0.7.0.1
 */