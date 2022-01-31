package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class b$a
  implements com.tencent.mm.pluginsdk.g.a.c.g
{
  private final com.tencent.mm.sdk.b.c rWu = new b.a.1(this);
  private final h rWv = new h();
  private final bx.a rhn = new b.a.2(this);
  
  public final String acb()
  {
    return "CheckResUpdate";
  }
  
  public final n.a c(l paraml)
  {
    if (!(paraml instanceof c))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
      return null;
    }
    y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
    return new d((c)paraml);
  }
  
  public final void ccB()
  {
    a.udP.c(this.rWu);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("resourcemgr", this.rhn, true);
    com.tencent.mm.kernel.g.DS().k(new b.a.3(this), 10000L);
  }
  
  public final com.tencent.mm.pluginsdk.g.a.c.h ccC()
  {
    return this.rWv;
  }
  
  public final void onAccountRelease()
  {
    a.udP.d(this.rWu);
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("resourcemgr", this.rhn, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */