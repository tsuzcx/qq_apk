package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.b.a.kc;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b Eda;
  private a Edb;
  
  static
  {
    AppMethodBeat.i(77984);
    Eda = new b();
    AppMethodBeat.o(77984);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(77982);
    if ("1".equals(paramc.fsy().get("canPreloadWidget")))
    {
      AppMethodBeat.o(77982);
      return true;
    }
    ae.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    AppMethodBeat.o(77982);
    return false;
  }
  
  public static b eRS()
  {
    return Eda;
  }
  
  static final class a
    implements Runnable
  {
    List<egw> list;
    boolean lsK;
    aq mHandler;
    int rss = 0;
    
    public a(List<egw> paramList)
    {
      this.list = paramList;
    }
    
    private void eRT()
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
        int i = this.rss + 1;
        this.rss = i;
        if (i > this.list.size())
        {
          ae.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.rss) });
          this.list = null;
          Thread.currentThread().interrupt();
          this.mHandler = null;
          AppMethodBeat.o(77979);
          return;
        }
        final egw localegw = (egw)this.list.get(this.rss - 1);
        ae.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localegw.dwb, localegw.IkI });
        if (localegw != null)
        {
          if ((TextUtils.isEmpty(localegw.dwb)) || (TextUtils.isEmpty(localegw.IkI)) || (TextUtils.isEmpty(localegw.xsG)))
          {
            ae.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
            eRT();
            AppMethodBeat.o(77979);
            return;
          }
          ((i)com.tencent.mm.kernel.g.ab(i.class)).a(localegw.dwb, localegw.Gdm, localegw.IkI, localegw.xsG);
          if (((i)com.tencent.mm.kernel.g.ab(i.class)).aj(localegw.dwb, localegw.Gdm))
          {
            ae.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
            eRT();
            AppMethodBeat.o(77979);
            return;
          }
          ae.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
          com.tencent.mm.plugin.report.service.g.yxI.dD(918, 1);
          final long l = System.currentTimeMillis();
          ((i)com.tencent.mm.kernel.g.ab(i.class)).a(localegw.dwb, localegw.Gdm, localegw.xsG, new j()
          {
            public final void b(boolean paramAnonymousBoolean, long paramAnonymousLong)
            {
              AppMethodBeat.i(77978);
              ae.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              kc localkc;
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.g.yxI.dD(918, 2);
                b.a.a(b.a.this);
                localkc = new kc();
                localkc.dTT = localkc.t("appid", localegw.dwb, true);
                localkc.eEs = localegw.Gdm;
                localkc.eCq = localkc.t("downloadUrl", localegw.xsG, true);
                localkc.eEt = localkc.t("pkgMd5", localegw.IkI, true);
                localkc.eEw = System.currentTimeMillis();
                if (!paramAnonymousBoolean) {
                  break label192;
                }
              }
              label192:
              for (long l = 1L;; l = 0L)
              {
                localkc.eEu = l;
                localkc.eEv = (System.currentTimeMillis() - l);
                localkc.eEx = paramAnonymousLong;
                localkc.aLH();
                AppMethodBeat.o(77978);
                return;
                com.tencent.mm.plugin.report.service.g.yxI.dD(918, 3);
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
        ae.printErrStackTrace("WidgetPkgPreDownloadMgr", localException, "", new Object[0]);
        AppMethodBeat.o(77979);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */