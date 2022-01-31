package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a.b;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;

final class a$2
  extends c
{
  a$2(a parama) {}
  
  public final String getName()
  {
    return "SyncFileTask";
  }
  
  public final void send()
  {
    AppMethodBeat.i(26266);
    if (this.uGL.uGC.cYE() != null) {
      this.uGL.uGC.cYE().cYK();
    }
    r.a(20009, null, false);
    r.a(20017, null, false);
    AppMethodBeat.o(26266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.2
 * JD-Core Version:    0.7.0.1
 */