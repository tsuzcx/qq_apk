package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class b$a
  implements com.tencent.mm.pluginsdk.g.a.c.g
{
  private final com.tencent.mm.sdk.b.c vNl;
  private final bz.a vNm;
  private final h vNn;
  
  public b$a()
  {
    AppMethodBeat.i(79481);
    this.vNl = new com.tencent.mm.sdk.b.c() {};
    this.vNm = new b.a.2(this);
    this.vNn = new h();
    AppMethodBeat.o(79481);
  }
  
  public final String avS()
  {
    return "CheckResUpdate";
  }
  
  public final n.a c(l paraml)
  {
    AppMethodBeat.i(79484);
    if (!(paraml instanceof c))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
      AppMethodBeat.o(79484);
      return null;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
    paraml = new d((c)paraml);
    AppMethodBeat.o(79484);
    return paraml;
  }
  
  public final void dmd()
  {
    AppMethodBeat.i(79482);
    a.ymk.c(this.vNl);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("resourcemgr", this.vNm, true);
    com.tencent.mm.kernel.g.RO().o(new b.a.3(this), 10000L);
    AppMethodBeat.o(79482);
  }
  
  public final com.tencent.mm.pluginsdk.g.a.c.h dme()
  {
    return this.vNn;
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(79483);
    a.ymk.d(this.vNl);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("resourcemgr", this.vNm, true);
    AppMethodBeat.o(79483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */