package com.tencent.mm.view.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class c$2
  implements com.tencent.mm.as.a.c.d
{
  public final byte[] h(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof EmojiInfo))) {
        return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a((EmojiInfo)paramVarArgs);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a.c.2
 * JD-Core Version:    0.7.0.1
 */