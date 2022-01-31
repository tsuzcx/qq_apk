package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class an$l
{
  public int cfb;
  public String rgH;
  public HashMap<String, Long> rgS = new HashMap();
  
  public an$l(an paraman) {}
  
  public final void bm(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
    }
    while (!this.rgS.containsKey(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      long l1 = ((Long)this.rgS.get(paramString)).longValue();
      long l2 = bk.UY();
      this.rgS.put(paramString, Long.valueOf(l2 - l1));
      return;
    }
    this.rgS.put(paramString, Long.valueOf(-1L));
  }
  
  public final void c(d paramd)
  {
    if (paramd == null) {
      return;
    }
    int i = an.ccb();
    Iterator localIterator = this.rgS.entrySet().iterator();
    label23:
    String str1;
    long l;
    String str2;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      str1 = (String)((Map.Entry)localObject).getKey();
      l = ((Long)((Map.Entry)localObject).getValue()).longValue();
      h.nFQ.a(32L, 2L, 1L, true);
      if (l == -1L)
      {
        h.nFQ.a(32L, 13L, 1L, true);
        y.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[] { str1, Integer.valueOf(i) });
      }
      if ((l >= 0L) && (l <= 60000L))
      {
        str2 = this.rgH;
        if (str1 != null) {
          break label321;
        }
      }
    }
    label321:
    for (Object localObject = str1;; localObject = str1.replace(",", "!"))
    {
      an.a(paramd, str2, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(i), localObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(this.cfb), this.rgH });
      y.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { str1, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(this.cfb), this.rgH });
      h.nFQ.a(32L, 6L, l, true);
      break label23;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an.l
 * JD-Core Version:    0.7.0.1
 */