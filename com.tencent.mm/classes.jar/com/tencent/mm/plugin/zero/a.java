package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.zero.b.a
{
  private com.tencent.mm.n.e EIr;
  private com.tencent.mm.n.c EIs;
  
  public a()
  {
    AppMethodBeat.i(132988);
    this.EIr = new com.tencent.mm.n.e();
    this.EIs = new com.tencent.mm.n.c();
    AppMethodBeat.o(132988);
  }
  
  public final com.tencent.mm.n.e acA()
  {
    AppMethodBeat.i(132989);
    g.ajD();
    g.ajA().aiF();
    com.tencent.mm.n.e locale = this.EIr;
    AppMethodBeat.o(132989);
    return locale;
  }
  
  public final com.tencent.mm.n.c acB()
  {
    AppMethodBeat.i(132990);
    g.ajD();
    g.ajA().aiF();
    com.tencent.mm.n.c localc = this.EIs;
    AppMethodBeat.o(132990);
    return localc;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(132991);
    if (paramc.gBH)
    {
      paramc = this.EIs;
      com.tencent.mm.vfs.e locale1 = new com.tencent.mm.vfs.e(b.arU() + "configlist/");
      if (locale1.exists())
      {
        com.tencent.mm.vfs.e locale2 = new com.tencent.mm.vfs.e(com.tencent.mm.n.c.ges);
        if (!locale2.exists())
        {
          ad.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.a(locale1, locale2);
        }
      }
    }
    this.EIr.vw();
    this.EIs.init();
    AppMethodBeat.o(132991);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */