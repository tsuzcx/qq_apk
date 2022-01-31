package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

final class b$a
  implements Runnable
{
  int eSO = 0;
  boolean isStopped;
  List<cyy> list;
  ak mHandler;
  
  public b$a(List<cyy> paramList)
  {
    this.list = paramList;
  }
  
  private void daF()
  {
    AppMethodBeat.i(5768);
    this.mHandler.postDelayed(this, 500L);
    AppMethodBeat.o(5768);
  }
  
  public final void run()
  {
    AppMethodBeat.i(5767);
    try
    {
      int i = this.eSO + 1;
      this.eSO = i;
      if (i > this.list.size())
      {
        ab.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.eSO) });
        this.list = null;
        Thread.currentThread().interrupt();
        this.mHandler = null;
        AppMethodBeat.o(5767);
        return;
      }
      cyy localcyy = (cyy)this.list.get(this.eSO - 1);
      ab.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localcyy.cwc, localcyy.yfW });
      if (localcyy != null)
      {
        if ((TextUtils.isEmpty(localcyy.cwc)) || (TextUtils.isEmpty(localcyy.yfW)) || (TextUtils.isEmpty(localcyy.yfX)))
        {
          ab.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
          daF();
          AppMethodBeat.o(5767);
          return;
        }
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.g.class)).a(localcyy.cwc, localcyy.wAy, localcyy.yfW, localcyy.yfX);
        if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.g.class)).S(localcyy.cwc, localcyy.wAy))
        {
          ab.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
          daF();
          AppMethodBeat.o(5767);
          return;
        }
        ab.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
        h.qsU.cT(918, 1);
        long l = System.currentTimeMillis();
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.g.class)).a(localcyy.cwc, localcyy.wAy, localcyy.yfX, new b.a.1(this, localcyy, l));
      }
      AppMethodBeat.o(5767);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("WidgetPkgPreDownloadMgr", localException, "", new Object[0]);
      AppMethodBeat.o(5767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */