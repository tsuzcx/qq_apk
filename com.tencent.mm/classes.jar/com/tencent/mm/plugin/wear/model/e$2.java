package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;

final class e$2
  implements h.a
{
  e$2(e parame) {}
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(26298);
    if (paramc == null)
    {
      AppMethodBeat.o(26298);
      return;
    }
    if ((paramc.oDS > 0) && (a.cYy().uGC.uGU.uHI.equals(paramc.talker))) {
      a.cYy().uGI.a(new e.2.1(this));
    }
    AppMethodBeat.o(26298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.2
 * JD-Core Version:    0.7.0.1
 */