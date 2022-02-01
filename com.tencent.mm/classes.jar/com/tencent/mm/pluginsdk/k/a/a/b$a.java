package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.k.a.c.g;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.m.a;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class b$a
  implements g
{
  private final IListener QZv;
  private final ck.a QZw;
  private final h QZx;
  
  public b$a()
  {
    AppMethodBeat.i(151923);
    this.QZv = new IListener() {};
    this.QZw = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(151921);
        paramAnonymousa = z.a(paramAnonymousa.jQG.RIF);
        if (Util.isNullOrNil(paramAnonymousa))
        {
          Log.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
          AppMethodBeat.o(151921);
          return;
        }
        Log.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(paramAnonymousa)));
        Map localMap;
        if (!Util.isNullOrNil(paramAnonymousa))
        {
          localMap = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
          j.F(0L, 0L);
          if (localMap != null) {
            break label168;
          }
          paramAnonymousa = "null";
          Log.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
          if (localMap != null) {
            break label181;
          }
          j.F(0L, 30L);
        }
        for (;;)
        {
          if ((localMap != null) && (localMap.size() > 0) && (Util.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
          {
            e.j(".sysmsg", "delete", localMap);
            e.j(".sysmsg", "cache", localMap);
            e.j(".sysmsg", "decrypt", localMap);
          }
          AppMethodBeat.o(151921);
          return;
          label168:
          paramAnonymousa = String.valueOf(localMap.size());
          break;
          label181:
          j.F(0L, 31L);
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.QZx = new h();
    AppMethodBeat.o(151923);
  }
  
  public final String aCt()
  {
    return "CheckResUpdate";
  }
  
  public final m.a c(k paramk)
  {
    AppMethodBeat.i(151926);
    if (!(paramk instanceof c))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
      AppMethodBeat.o(151926);
      return null;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
    paramk = new d((c)paramk);
    AppMethodBeat.o(151926);
    return paramk;
  }
  
  public final void hik()
  {
    AppMethodBeat.i(151924);
    EventCenter.instance.addListener(this.QZv);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("resourcemgr", this.QZw, true);
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151922);
        p.cxi();
        AppMethodBeat.o(151922);
      }
    }, 10000L);
    AppMethodBeat.o(151924);
  }
  
  public final com.tencent.mm.pluginsdk.k.a.c.h hil()
  {
    return this.QZx;
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(151925);
    EventCenter.instance.removeListener(this.QZv);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("resourcemgr", this.QZw, true);
    AppMethodBeat.o(151925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */