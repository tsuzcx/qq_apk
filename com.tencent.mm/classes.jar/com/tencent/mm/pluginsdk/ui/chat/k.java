package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t;
import com.tencent.mm.api.t.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k
  extends t
  implements j
{
  public final void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62452);
    this.bWo.a(paramEmojiInfo);
    AppMethodBeat.o(62452);
  }
  
  public final void C(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62453);
    this.bWo.a(paramEmojiInfo);
    AppMethodBeat.o(62453);
  }
  
  public final boolean bPD()
  {
    return true;
  }
  
  public final boolean bPE()
  {
    return true;
  }
  
  public final void bPF()
  {
    AppMethodBeat.i(62454);
    this.bWo.onHide();
    AppMethodBeat.o(62454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.k
 * JD-Core Version:    0.7.0.1
 */