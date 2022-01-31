package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class at$3
  implements k.a
{
  at$3(at paramat) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(62711);
    if (paramString == null)
    {
      AppMethodBeat.o(62711);
      return;
    }
    if (paramString.equalsIgnoreCase("delete_emoji_info_notify"))
    {
      at.a(this.yNJ).cj(true);
      at.a(this.yNJ).ck(true);
      at.a(this.yNJ).cm(true);
      AppMethodBeat.o(62711);
      return;
    }
    if (g.RG())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramString);
      if (paramString != null)
      {
        if (paramString.field_catalog == EmojiInfo.yPm)
        {
          at.a(this.yNJ).cj(true);
          at.a(this.yNJ).ck(true);
          AppMethodBeat.o(62711);
          return;
        }
        if (bo.isEqual(paramString.field_groupId, "capture")) {
          at.a(this.yNJ).cm(true);
        }
      }
    }
    AppMethodBeat.o(62711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.at.3
 * JD-Core Version:    0.7.0.1
 */