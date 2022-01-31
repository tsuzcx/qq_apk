package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class an$f
{
  public int cfb;
  public String gZO = "";
  public HashMap<String, Long> rgE = new HashMap();
  public HashMap<String, Long> rgF = new HashMap();
  public boolean rgG = true;
  public String rgH;
  
  public an$f(an paraman) {}
  
  public final void c(d paramd)
  {
    int i;
    Iterator localIterator;
    String str;
    long l;
    if (paramd != null)
    {
      i = an.ccb();
      localIterator = this.rgE.entrySet().iterator();
      if (!localIterator.hasNext()) {
        break label335;
      }
      localObject = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject).getKey();
      l = ((Long)((Map.Entry)localObject).getValue()).longValue();
      if ((l >= 0L) && (l <= 180000L)) {
        break label85;
      }
    }
    label85:
    label349:
    do
    {
      return;
      localObject = this.rgH;
      if (str == null) {}
      for (;;)
      {
        an.a(paramd, (String)localObject, new Object[] { Integer.valueOf(5), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(this.cfb), this.rgH });
        if (an.access$000() == 1)
        {
          h.nFQ.a(32L, 18L, 1L, true);
          h.nFQ.a(32L, 19L, l, true);
        }
        h.nFQ.a(32L, 8L, 1L, true);
        h.nFQ.a(32L, 9L, l, true);
        y.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(this.cfb), this.rgH });
        break;
        str = str.replace(",", "!");
      }
      localIterator = this.rgF.entrySet().iterator();
      if (!localIterator.hasNext()) {
        break label646;
      }
      localObject = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject).getKey();
      l = ((Long)((Map.Entry)localObject).getValue()).longValue();
    } while ((l < 0L) || (l > 180000L));
    label335:
    Object localObject = this.rgH;
    if (str == null) {}
    for (;;)
    {
      an.a(paramd, (String)localObject, new Object[] { Integer.valueOf(6), Long.valueOf(l), Integer.valueOf(i), str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(this.cfb), this.rgH });
      if (an.access$000() == 1)
      {
        h.nFQ.a(32L, 20L, 1L, true);
        h.nFQ.a(32L, 21L, l, true);
      }
      h.nFQ.a(32L, 10L, 1L, true);
      h.nFQ.a(32L, 11L, l, true);
      y.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(this.cfb), this.rgH });
      break label349;
      label646:
      break;
      str = str.replace(",", "!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an.f
 * JD-Core Version:    0.7.0.1
 */