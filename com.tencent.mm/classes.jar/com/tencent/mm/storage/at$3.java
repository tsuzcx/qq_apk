package com.tencent.mm.storage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class at$3
  implements j.a
{
  at$3(at paramat) {}
  
  public final void a(String paramString, l paraml)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        if (paramString.equalsIgnoreCase("delete_emoji_info_notify"))
        {
          at.uBo = true;
          at.uBp = true;
          return;
        }
      } while (!g.DK());
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramString);
    } while ((paramString == null) || (paramString.field_catalog != EmojiInfo.uCZ));
    at.uBo = true;
    at.uBp = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.at.3
 * JD-Core Version:    0.7.0.1
 */