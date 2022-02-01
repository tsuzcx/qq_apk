package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.zero.b.a
{
  private com.tencent.mm.m.e Dey;
  private com.tencent.mm.m.c Dez;
  
  public a()
  {
    AppMethodBeat.i(132988);
    this.Dey = new com.tencent.mm.m.e();
    this.Dez = new com.tencent.mm.m.c();
    AppMethodBeat.o(132988);
  }
  
  public final com.tencent.mm.m.e ZY()
  {
    AppMethodBeat.i(132989);
    g.agS();
    g.agP().afT();
    com.tencent.mm.m.e locale = this.Dey;
    AppMethodBeat.o(132989);
    return locale;
  }
  
  public final com.tencent.mm.m.c ZZ()
  {
    AppMethodBeat.i(132990);
    g.agS();
    g.agP().afT();
    com.tencent.mm.m.c localc = this.Dez;
    AppMethodBeat.o(132990);
    return localc;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132991);
    if (paramc.ghX)
    {
      paramc = this.Dez;
      com.tencent.mm.vfs.e locale1 = new com.tencent.mm.vfs.e(b.aph() + "configlist/");
      if (locale1.exists())
      {
        com.tencent.mm.vfs.e locale2 = new com.tencent.mm.vfs.e(com.tencent.mm.m.c.fKR);
        if (!locale2.exists())
        {
          ac.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.a(locale1, locale2);
        }
      }
    }
    this.Dey.tX();
    this.Dez.init();
    AppMethodBeat.o(132991);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */