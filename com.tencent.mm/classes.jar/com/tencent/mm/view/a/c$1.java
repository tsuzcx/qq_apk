package com.tencent.mm.view.a;

import com.tencent.mm.as.a.c.e;
import com.tencent.mm.h.a.cr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class c$1
  implements e
{
  c$1(c paramc) {}
  
  public final void g(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof EmojiInfo)))
      {
        cr localcr = new cr();
        localcr.bIQ.scene = 1;
        localcr.bIQ.bIR = ((EmojiInfo)paramVarArgs);
        localcr.bIQ.context = this.wwQ.mContext;
        a.udP.m(localcr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.c.1
 * JD-Core Version:    0.7.0.1
 */