package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.zero.b.a
{
  private e FaP;
  private com.tencent.mm.n.c FaQ;
  
  public a()
  {
    AppMethodBeat.i(132988);
    this.FaP = new e();
    this.FaQ = new com.tencent.mm.n.c();
    AppMethodBeat.o(132988);
  }
  
  public final e acL()
  {
    AppMethodBeat.i(132989);
    g.ajS();
    g.ajP().aiU();
    e locale = this.FaP;
    AppMethodBeat.o(132989);
    return locale;
  }
  
  public final com.tencent.mm.n.c acM()
  {
    AppMethodBeat.i(132990);
    g.ajS();
    g.ajP().aiU();
    com.tencent.mm.n.c localc = this.FaQ;
    AppMethodBeat.o(132990);
    return localc;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132991);
    if (paramc.gEo)
    {
      paramc = this.FaQ;
      k localk1 = new k(b.asj() + "configlist/");
      if (localk1.exists())
      {
        k localk2 = new k(com.tencent.mm.n.c.ggA);
        if (!localk2.exists())
        {
          ae.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.a(localk1, localk2);
        }
      }
    }
    this.FaP.vw();
    this.FaQ.init();
    AppMethodBeat.o(132991);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */