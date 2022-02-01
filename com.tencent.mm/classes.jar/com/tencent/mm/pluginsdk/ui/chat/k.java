package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.z;
import com.tencent.mm.api.z.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k
  extends z
  implements j
{
  public final void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104687);
    this.cJL.a(paramEmojiInfo);
    AppMethodBeat.o(104687);
  }
  
  public final void cOw()
  {
    AppMethodBeat.i(104689);
    this.cJL.onHide();
    AppMethodBeat.o(104689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.k
 * JD-Core Version:    0.7.0.1
 */