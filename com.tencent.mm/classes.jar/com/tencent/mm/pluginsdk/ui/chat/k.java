package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k
  extends ac
  implements j
{
  public final void A(boolean paramBoolean, int paramInt) {}
  
  public final void cpE()
  {
    AppMethodBeat.i(104689);
    this.faJ.onHide();
    AppMethodBeat.o(104689);
  }
  
  public final void cpF() {}
  
  public final void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104687);
    this.faJ.a(paramEmojiInfo);
    AppMethodBeat.o(104687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.k
 * JD-Core Version:    0.7.0.1
 */