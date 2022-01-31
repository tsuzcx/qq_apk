package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.storage.bi;

final class ap$1
  implements az.a
{
  ap$1(ap paramap, long paramLong) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(153840);
    aw.aaz();
    bi localbi = c.YC().kB(this.kYi);
    localbi.dyi();
    b.fRu.a(localbi, true);
    aw.aaz();
    c.YC().a(this.kYi, localbi);
    AppMethodBeat.o(153840);
    return false;
  }
  
  public final boolean acT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ap.1
 * JD-Core Version:    0.7.0.1
 */