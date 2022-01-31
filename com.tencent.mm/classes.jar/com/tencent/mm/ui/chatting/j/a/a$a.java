package com.tencent.mm.ui.chatting.j.a;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMTextView.a;

 enum a$a
  implements MMTextView.a
{
  private a$a() {}
  
  public final void a(CharSequence paramCharSequence, long paramLong)
  {
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong);
    if (bk.bl(localbi.field_talker))
    {
      y.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    if ((localbi.field_flag & 0x10) == 0)
    {
      a.b(paramCharSequence, localbi);
      return;
    }
    y.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */