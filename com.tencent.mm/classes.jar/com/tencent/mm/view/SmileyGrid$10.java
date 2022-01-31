package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.b.e.c;

final class SmileyGrid$10
  implements e.c
{
  SmileyGrid$10(SmileyGrid paramSmileyGrid, EmojiInfo paramEmojiInfo) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(62907);
    if ((paramBoolean) && (!bo.isNullOrNil(this.AQQ.Al()))) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KH(this.AQQ.Al());
    }
    AppMethodBeat.o(62907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.SmileyGrid.10
 * JD-Core Version:    0.7.0.1
 */