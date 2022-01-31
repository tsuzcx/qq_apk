package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.bi;

final class ReadMailProxy$6
  implements Runnable
{
  ReadMailProxy$6(ReadMailProxy paramReadMailProxy, long paramLong, String paramString) {}
  
  public final void run()
  {
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.byn);
    localbi.setContent(localbi.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.gBn + "</digest>"));
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.byn, localbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.6
 * JD-Core Version:    0.7.0.1
 */