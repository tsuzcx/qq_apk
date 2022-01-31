package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fp.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends com.tencent.mm.sdk.b.c<fp>
{
  public c()
  {
    AppMethodBeat.i(35600);
    this.__eventId = fp.class.getName().hashCode();
    AppMethodBeat.o(35600);
  }
  
  private boolean a(fp paramfp)
  {
    AppMethodBeat.i(35601);
    if (!(paramfp instanceof fp))
    {
      ab.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      AppMethodBeat.o(35601);
      return false;
    }
    an.a locala = ag.coV();
    locala.a(paramfp.ctH.type, paramfp.ctH.username, new c.1(this, paramfp));
    locala.a(1, paramfp.ctH.username, paramfp.ctH.ctJ, paramfp.ctH.ctK);
    AppMethodBeat.o(35601);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */