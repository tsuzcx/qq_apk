package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.eff;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b DLc;
  private a DLd;
  
  static
  {
    AppMethodBeat.i(77984);
    DLc = new b();
    AppMethodBeat.o(77984);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(77982);
    if ("1".equals(paramc.foF().get("canPreloadWidget")))
    {
      AppMethodBeat.o(77982);
      return true;
    }
    ad.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    AppMethodBeat.o(77982);
    return false;
  }
  
  public static b eOh()
  {
    return DLc;
  }
  
  static final class a
    implements Runnable
  {
    List<eff> list;
    boolean lom;
    ap mHandler;
    int rko = 0;
    
    public a(List<eff> paramList)
    {
      this.list = paramList;
    }
    
    private void eOi()
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
        int i = this.rko + 1;
        this.rko = i;
        if (i > this.list.size())
        {
          ad.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.rko) });
          this.list = null;
          Thread.currentThread().interrupt();
          this.mHandler = null;
          AppMethodBeat.o(77979);
          return;
        }
        final eff localeff = (eff)this.list.get(this.rko - 1);
        ad.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localeff.duW, localeff.HQB });
        if (localeff != null)
        {
          if ((TextUtils.isEmpty(localeff.duW)) || (TextUtils.isEmpty(localeff.HQB)) || (TextUtils.isEmpty(localeff.xcP)))
          {
            ad.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
            eOi();
            AppMethodBeat.o(77979);
            return;
          }
          ((i)com.tencent.mm.kernel.g.ab(i.class)).a(localeff.duW, localeff.FKN, localeff.HQB, localeff.xcP);
          if (((i)com.tencent.mm.kernel.g.ab(i.class)).ai(localeff.duW, localeff.FKN))
          {
            ad.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
            eOi();
            AppMethodBeat.o(77979);
            return;
          }
          ad.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
          com.tencent.mm.plugin.report.service.g.yhR.dD(918, 1);
          final long l = System.currentTimeMillis();
          ((i)com.tencent.mm.kernel.g.ab(i.class)).a(localeff.duW, localeff.FKN, localeff.xcP, new j()
          {
            public final void b(boolean paramAnonymousBoolean, long paramAnonymousLong)
            {
              AppMethodBeat.i(77978);
              ad.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              ka localka;
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.g.yhR.dD(918, 2);
                b.a.a(b.a.this);
                localka = new ka();
                localka.dSD = localka.t("appid", localeff.duW, true);
                localka.eCJ = localeff.FKN;
                localka.eAH = localka.t("downloadUrl", localeff.xcP, true);
                localka.eCK = localka.t("pkgMd5", localeff.HQB, true);
                localka.eCN = System.currentTimeMillis();
                if (!paramAnonymousBoolean) {
                  break label192;
                }
              }
              label192:
              for (long l = 1L;; l = 0L)
              {
                localka.eCL = l;
                localka.eCM = (System.currentTimeMillis() - l);
                localka.eCO = paramAnonymousLong;
                localka.aLk();
                AppMethodBeat.o(77978);
                return;
                com.tencent.mm.plugin.report.service.g.yhR.dD(918, 3);
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