package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.bo;

final class ReadMailProxy$6
  implements Runnable
{
  ReadMailProxy$6(ReadMailProxy paramReadMailProxy, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(122821);
    bo localbo = ((k)g.ab(k.class)).dcr().vP(this.cLo);
    localbo.setContent(localbo.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.oZW + "</digest>"));
    ((k)g.ab(k.class)).dcr().a(this.cLo, localbo);
    AppMethodBeat.o(122821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.6
 * JD-Core Version:    0.7.0.1
 */