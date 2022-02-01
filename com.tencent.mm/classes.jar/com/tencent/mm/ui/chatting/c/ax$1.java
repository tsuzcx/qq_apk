package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.storage.bl;

final class ax$1
  implements be.a
{
  ax$1(ax paramax, long paramLong) {}
  
  public final boolean aus()
  {
    AppMethodBeat.i(35727);
    az.arV();
    bl localbl = c.apO().rm(this.oeT);
    localbl.eMu();
    b.huc.a(localbl, true);
    az.arV();
    c.apO().a(this.oeT, localbl);
    AppMethodBeat.o(35727);
    return false;
  }
  
  public final boolean aut()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ax.1
 * JD-Core Version:    0.7.0.1
 */