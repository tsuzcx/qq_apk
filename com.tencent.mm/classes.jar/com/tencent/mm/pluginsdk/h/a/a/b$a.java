package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.n.a;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class b$a
  implements com.tencent.mm.pluginsdk.h.a.c.g
{
  private final com.tencent.mm.sdk.b.c BSm;
  private final cc.a BSn;
  private final h BSo;
  
  public b$a()
  {
    AppMethodBeat.i(151923);
    this.BSm = new com.tencent.mm.sdk.b.c() {};
    this.BSn = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(151921);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        if (bt.isNullOrNil(paramAnonymousa))
        {
          ad.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
          AppMethodBeat.o(151921);
          return;
        }
        ad.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(paramAnonymousa)));
        Map localMap;
        if (!bt.isNullOrNil(paramAnonymousa))
        {
          localMap = bw.K(paramAnonymousa, "sysmsg");
          j.D(0L, 0L);
          if (localMap != null) {
            break label167;
          }
          paramAnonymousa = "null";
          ad.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
          if (localMap != null) {
            break label180;
          }
          j.D(0L, 30L);
        }
        for (;;)
        {
          if ((localMap != null) && (localMap.size() > 0) && (bt.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
          {
            e.i(".sysmsg", "delete", localMap);
            e.i(".sysmsg", "cache", localMap);
            e.i(".sysmsg", "decrypt", localMap);
          }
          AppMethodBeat.o(151921);
          return;
          label167:
          paramAnonymousa = String.valueOf(localMap.size());
          break;
          label180:
          j.D(0L, 31L);
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.BSo = new h();
    AppMethodBeat.o(151923);
  }
  
  public final String asy()
  {
    return "CheckResUpdate";
  }
  
  public final n.a c(l paraml)
  {
    AppMethodBeat.i(151926);
    if (!(paraml instanceof c))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
      AppMethodBeat.o(151926);
      return null;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
    paraml = new d((c)paraml);
    AppMethodBeat.o(151926);
    return paraml;
  }
  
  public final void ewp()
  {
    AppMethodBeat.i(151924);
    a.ESL.c(this.BSm);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("resourcemgr", this.BSn, true);
    com.tencent.mm.kernel.g.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151922);
        p.bAT();
        AppMethodBeat.o(151922);
      }
    }, 10000L);
    AppMethodBeat.o(151924);
  }
  
  public final com.tencent.mm.pluginsdk.h.a.c.h ewq()
  {
    return this.BSo;
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(151925);
    a.ESL.d(this.BSm);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("resourcemgr", this.BSn, true);
    AppMethodBeat.o(151925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */