package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bv;

final class ReadMailProxy$5
  implements Runnable
{
  ReadMailProxy$5(ReadMailProxy paramReadMailProxy, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(122820);
    bv localbv = ((l)g.ab(l.class)).doJ().ys(this.cXy);
    localbv.setContent(localbv.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + this.pKk + "</digest>"));
    ((l)g.ab(l.class)).doJ().a(this.cXy, localbv);
    AppMethodBeat.o(122820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.5
 * JD-Core Version:    0.7.0.1
 */