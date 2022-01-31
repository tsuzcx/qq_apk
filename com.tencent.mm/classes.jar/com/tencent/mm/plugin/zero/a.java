package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.zero.b.a
{
  private com.tencent.mm.m.e vIP;
  private com.tencent.mm.m.c vIQ;
  
  public a()
  {
    AppMethodBeat.i(58738);
    this.vIP = new com.tencent.mm.m.e();
    this.vIQ = new com.tencent.mm.m.c();
    AppMethodBeat.o(58738);
  }
  
  public final com.tencent.mm.m.e Nq()
  {
    AppMethodBeat.i(58739);
    g.RM();
    g.RJ().QQ();
    com.tencent.mm.m.e locale = this.vIP;
    AppMethodBeat.o(58739);
    return locale;
  }
  
  public final com.tencent.mm.m.c Nr()
  {
    AppMethodBeat.i(58740);
    g.RM();
    g.RJ().QQ();
    com.tencent.mm.m.c localc = this.vIQ;
    AppMethodBeat.o(58740);
    return localc;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(58741);
    if (paramc.eIj)
    {
      paramc = this.vIQ;
      File localFile1 = new File(com.tencent.mm.compatible.util.e.eQz + "configlist/");
      if (localFile1.exists())
      {
        File localFile2 = new File(com.tencent.mm.m.c.etL);
        if (!localFile2.exists())
        {
          ab.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.d(localFile1, localFile2);
        }
      }
    }
    this.vIP.ph();
    this.vIQ.init();
    AppMethodBeat.o(58741);
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */