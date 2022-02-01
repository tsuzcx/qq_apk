package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class b$a
  implements com.tencent.mm.pluginsdk.j.a.c.g
{
  private final com.tencent.mm.sdk.b.c FhZ;
  private final cf.a Fia;
  private final h Fib;
  
  public b$a()
  {
    AppMethodBeat.i(151923);
    this.FhZ = new com.tencent.mm.sdk.b.c() {};
    this.Fia = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(151921);
        paramAnonymousa = z.a(paramAnonymousa.gte.FNI);
        if (bu.isNullOrNil(paramAnonymousa))
        {
          ae.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
          AppMethodBeat.o(151921);
          return;
        }
        ae.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(paramAnonymousa)));
        Map localMap;
        if (!bu.isNullOrNil(paramAnonymousa))
        {
          localMap = bx.M(paramAnonymousa, "sysmsg");
          j.A(0L, 0L);
          if (localMap != null) {
            break label167;
          }
          paramAnonymousa = "null";
          ae.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
          if (localMap != null) {
            break label180;
          }
          j.A(0L, 30L);
        }
        for (;;)
        {
          if ((localMap != null) && (localMap.size() > 0) && (bu.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
          {
            e.k(".sysmsg", "delete", localMap);
            e.k(".sysmsg", "cache", localMap);
            e.k(".sysmsg", "decrypt", localMap);
          }
          AppMethodBeat.o(151921);
          return;
          label167:
          paramAnonymousa = String.valueOf(localMap.size());
          break;
          label180:
          j.A(0L, 31L);
        }
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.Fib = new h();
    AppMethodBeat.o(151923);
  }
  
  public final String afK()
  {
    return "CheckResUpdate";
  }
  
  public final n.a c(l paraml)
  {
    AppMethodBeat.i(151926);
    if (!(paraml instanceof c))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
      AppMethodBeat.o(151926);
      return null;
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
    paraml = new d((c)paraml);
    AppMethodBeat.o(151926);
    return paraml;
  }
  
  public final void feu()
  {
    AppMethodBeat.i(151924);
    a.IvT.c(this.FhZ);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("resourcemgr", this.Fia, true);
    com.tencent.mm.kernel.g.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151922);
        p.bMY();
        AppMethodBeat.o(151922);
      }
    }, 10000L);
    AppMethodBeat.o(151924);
  }
  
  public final com.tencent.mm.pluginsdk.j.a.c.h fev()
  {
    return this.Fib;
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(151925);
    a.IvT.d(this.FhZ);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("resourcemgr", this.Fia, true);
    AppMethodBeat.o(151925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */