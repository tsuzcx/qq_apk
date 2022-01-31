package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.qm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.storage.bi;

final class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2, qm paramqm) {}
  
  public final void run()
  {
    AppMethodBeat.i(23132);
    bi localbi = this.pjg.cHb.cmQ;
    if (d.Wh(localbi.field_talker)) {
      this.pjh.pjd.ca(localbi);
    }
    AppMethodBeat.o(23132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d.2.1
 * JD-Core Version:    0.7.0.1
 */