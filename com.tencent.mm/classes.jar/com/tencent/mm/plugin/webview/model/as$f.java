package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class as$f
{
  public int cNH;
  public String iIg;
  public HashMap<String, Long> uWR;
  public HashMap<String, Long> uWS;
  public boolean uWT;
  public String uWU;
  
  public as$f(as paramas)
  {
    AppMethodBeat.i(6762);
    this.iIg = "";
    this.uWT = true;
    this.uWR = new HashMap();
    this.uWS = new HashMap();
    AppMethodBeat.o(6762);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(6763);
    if (paramd != null)
    {
      int i = as.aDS();
      Iterator localIterator = this.uWR.entrySet().iterator();
      Object localObject;
      String str;
      long l;
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(6763);
          return;
        }
        localObject = this.uWU;
        if (str == null) {}
        for (;;)
        {
          as.b(paramd, (String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(this.cNH), this.uWU });
          if (as.access$000() == 1)
          {
            h.qsU.idkeyStat(32L, 18L, 1L, true);
            h.qsU.idkeyStat(32L, 19L, l, true);
          }
          h.qsU.idkeyStat(32L, 8L, 1L, true);
          h.qsU.idkeyStat(32L, 9L, l, true);
          ab.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(this.cNH), this.uWU });
          break;
          str = str.replace(",", "!");
        }
      }
      localIterator = this.uWS.entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject).getKey();
        l = ((Long)((Map.Entry)localObject).getValue()).longValue();
        if ((l < 0L) || (l > 180000L))
        {
          AppMethodBeat.o(6763);
          return;
        }
        localObject = this.uWU;
        if (str == null) {}
        for (;;)
        {
          as.b(paramd, (String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(this.cNH), this.uWU });
          if (as.access$000() == 1)
          {
            h.qsU.idkeyStat(32L, 20L, 1L, true);
            h.qsU.idkeyStat(32L, 21L, l, true);
          }
          h.qsU.idkeyStat(32L, 10L, 1L, true);
          h.qsU.idkeyStat(32L, 11L, l, true);
          ab.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(this.cNH), this.uWU });
          break;
          str = str.replace(",", "!");
        }
      }
    }
    AppMethodBeat.o(6763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as.f
 * JD-Core Version:    0.7.0.1
 */