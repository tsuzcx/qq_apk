package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.b.a.hc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b APG;
  private a APH;
  
  static
  {
    AppMethodBeat.i(77984);
    APG = new b();
    AppMethodBeat.o(77984);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(77982);
    if ("1".equals(paramc.eJy().get("canPreloadWidget")))
    {
      AppMethodBeat.o(77982);
      return true;
    }
    ad.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    AppMethodBeat.o(77982);
    return false;
  }
  
  public static b ejX()
  {
    return APG;
  }
  
  static final class a
    implements Runnable
  {
    int goS = 0;
    boolean kqq;
    List<dtm> list;
    ap mHandler;
    
    public a(List<dtm> paramList)
    {
      this.list = paramList;
    }
    
    private void ejY()
    {
      AppMethodBeat.i(77980);
      this.mHandler.postDelayed(this, 500L);
      AppMethodBeat.o(77980);
    }
    
    public final void run()
    {
      AppMethodBeat.i(77979);
      try
      {
        int i = this.goS + 1;
        this.goS = i;
        if (i > this.list.size())
        {
          ad.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.goS) });
          this.list = null;
          Thread.currentThread().interrupt();
          this.mHandler = null;
          AppMethodBeat.o(77979);
          return;
        }
        final dtm localdtm = (dtm)this.list.get(this.goS - 1);
        ad.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localdtm.dlB, localdtm.EIi });
        if (localdtm != null)
        {
          if ((TextUtils.isEmpty(localdtm.dlB)) || (TextUtils.isEmpty(localdtm.EIi)) || (TextUtils.isEmpty(localdtm.EIj)))
          {
            ad.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
            ejY();
            AppMethodBeat.o(77979);
            return;
          }
          ((i)g.ab(i.class)).a(localdtm.dlB, localdtm.CLL, localdtm.EIi, localdtm.EIj);
          if (((i)g.ab(i.class)).aa(localdtm.dlB, localdtm.CLL))
          {
            ad.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
            ejY();
            AppMethodBeat.o(77979);
            return;
          }
          ad.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
          h.vKh.dB(918, 1);
          final long l = System.currentTimeMillis();
          ((i)g.ab(i.class)).a(localdtm.dlB, localdtm.CLL, localdtm.EIj, new j()
          {
            public final void b(boolean paramAnonymousBoolean, long paramAnonymousLong)
            {
              AppMethodBeat.i(77978);
              ad.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              hc localhc;
              if (paramAnonymousBoolean)
              {
                h.vKh.dB(918, 2);
                b.a.a(b.a.this);
                localhc = new hc();
                localhc.dHL = localhc.t("appid", localdtm.dlB, true);
                localhc.ejy = localdtm.CLL;
                localhc.ehB = localhc.t("downloadUrl", localdtm.EIj, true);
                localhc.ejz = localhc.t("pkgMd5", localdtm.EIi, true);
                localhc.ejC = System.currentTimeMillis();
                if (!paramAnonymousBoolean) {
                  break label192;
                }
              }
              label192:
              for (long l = 1L;; l = 0L)
              {
                localhc.ejA = l;
                localhc.ejB = (System.currentTimeMillis() - l);
                localhc.ejD = paramAnonymousLong;
                localhc.aBj();
                AppMethodBeat.o(77978);
                return;
                h.vKh.dB(918, 3);
                break;
              }
            }
          });
        }
        AppMethodBeat.o(77979);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("WidgetPkgPreDownloadMgr", localException, "", new Object[0]);
        AppMethodBeat.o(77979);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */