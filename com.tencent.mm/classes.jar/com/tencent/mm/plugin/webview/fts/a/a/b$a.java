package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cli;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class b$a
  implements Runnable
{
  int jQL = 0;
  List<cli> list;
  ah mHandler;
  boolean rag;
  
  public b$a(List<cli> paramList)
  {
    this.list = paramList;
  }
  
  private void caG()
  {
    this.mHandler.postDelayed(this, 500L);
  }
  
  public final void run()
  {
    try
    {
      int i = this.jQL + 1;
      this.jQL = i;
      if (i > this.list.size())
      {
        y.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.jQL) });
        this.list = null;
        Thread.currentThread().interrupt();
        this.mHandler = null;
        return;
      }
      cli localcli = (cli)this.list.get(this.jQL - 1);
      y.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localcli.bOL, localcli.tYD });
      if (localcli == null) {
        return;
      }
      if ((TextUtils.isEmpty(localcli.bOL)) || (TextUtils.isEmpty(localcli.tYD)) || (TextUtils.isEmpty(localcli.tYE)))
      {
        y.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
        caG();
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("WidgetPkgPreDownloadMgr", localException, "", new Object[0]);
      return;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.g.class)).a(localException.bOL, localException.sEs, localException.tYD, localException.tYE);
    if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.g.class)).K(localException.bOL, localException.sEs))
    {
      y.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
      caG();
      return;
    }
    y.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
    h.nFQ.h(918L, 1L, 1L);
    long l = System.currentTimeMillis();
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.g.class)).a(localException.bOL, localException.sEs, localException.tYE, new b.a.1(this, localException, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */