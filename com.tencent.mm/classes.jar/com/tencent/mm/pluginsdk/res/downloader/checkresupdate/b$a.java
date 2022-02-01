package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.app.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.res.downloader.model.g;
import com.tencent.mm.pluginsdk.res.downloader.model.k;
import com.tencent.mm.pluginsdk.res.downloader.model.m.a;
import com.tencent.mm.pluginsdk.res.downloader.model.s.a;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class b$a
  implements g
{
  private final h XVA;
  private final IListener XVy;
  private final cl.a XVz;
  
  public b$a()
  {
    AppMethodBeat.i(151923);
    this.XVy = new CheckResUpdateHelper.CheckResUpdateResDownloaderPlugin.1(this, f.hfK);
    this.XVz = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(151921);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
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
          j.ac(0L, 0L);
          if (localMap != null) {
            break label168;
          }
          paramAnonymousa = "null";
          Log.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
          if (localMap != null) {
            break label181;
          }
          j.ac(0L, 30L);
        }
        for (;;)
        {
          if ((localMap != null) && (localMap.size() > 0) && (Util.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
          {
            e.k(".sysmsg", "delete", localMap);
            e.k(".sysmsg", "cache", localMap);
            e.k(".sysmsg", "decrypt", localMap);
          }
          AppMethodBeat.o(151921);
          return;
          label168:
          paramAnonymousa = String.valueOf(localMap.size());
          break;
          label181:
          j.ac(0L, 31L);
        }
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.XVA = new h();
    AppMethodBeat.o(151923);
  }
  
  public final String aVp()
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
  
  public final void iJh()
  {
    AppMethodBeat.i(151924);
    this.XVy.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("resourcemgr", this.XVz, true);
    com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151922);
        p.cZW();
        AppMethodBeat.o(151922);
      }
    }, 10000L);
    AppMethodBeat.o(151924);
  }
  
  public final com.tencent.mm.pluginsdk.res.downloader.model.h iJi()
  {
    return this.XVA;
  }
  
  public final s.a iJj()
  {
    return null;
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(151925);
    this.XVy.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("resourcemgr", this.XVz, true);
    AppMethodBeat.o(151925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.a
 * JD-Core Version:    0.7.0.1
 */