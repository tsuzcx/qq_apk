package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.bi;

final class ReadMailProxy$6
  implements Runnable
{
  ReadMailProxy$6(ReadMailProxy paramReadMailProxy, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(68095);
    bi localbi = ((j)g.E(j.class)).bPQ().kB(this.cap);
    localbi.setContent(localbi.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.hZi + "</digest>"));
    ((j)g.E(j.class)).bPQ().a(this.cap, localbi);
    AppMethodBeat.o(68095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.6
 * JD-Core Version:    0.7.0.1
 */