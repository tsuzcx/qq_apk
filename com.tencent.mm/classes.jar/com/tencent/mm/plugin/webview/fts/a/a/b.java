package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b ChV;
  private a ChW;
  
  static
  {
    AppMethodBeat.i(77984);
    ChV = new b();
    AppMethodBeat.o(77984);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(77982);
    if ("1".equals(paramc.eYV().get("canPreloadWidget")))
    {
      AppMethodBeat.o(77982);
      return true;
    }
    ac.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    AppMethodBeat.o(77982);
    return false;
  }
  
  public static b ezs()
  {
    return ChV;
  }
  
  static final class a
    implements Runnable
  {
    int gPA = 0;
    boolean kRJ;
    List<dzd> list;
    ao mHandler;
    
    public a(List<dzd> paramList)
    {
      this.list = paramList;
    }
    
    private void ezt()
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
        int i = this.gPA + 1;
        this.gPA = i;
        if (i > this.list.size())
        {
          ac.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.gPA) });
          this.list = null;
          Thread.currentThread().interrupt();
          this.mHandler = null;
          AppMethodBeat.o(77979);
          return;
        }
        final dzd localdzd = (dzd)this.list.get(this.gPA - 1);
        ac.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localdzd.djj, localdzd.Gfu });
        if (localdzd != null)
        {
          if ((TextUtils.isEmpty(localdzd.djj)) || (TextUtils.isEmpty(localdzd.Gfu)) || (TextUtils.isEmpty(localdzd.Gfv)))
          {
            ac.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
            ezt();
            AppMethodBeat.o(77979);
            return;
          }
          ((i)g.ab(i.class)).a(localdzd.djj, localdzd.Eeo, localdzd.Gfu, localdzd.Gfv);
          if (((i)g.ab(i.class)).ae(localdzd.djj, localdzd.Eeo))
          {
            ac.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
            ezt();
            AppMethodBeat.o(77979);
            return;
          }
          ac.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
          h.wUl.dB(918, 1);
          final long l = System.currentTimeMillis();
          ((i)g.ab(i.class)).a(localdzd.djj, localdzd.Eeo, localdzd.Gfv, new j()
          {
            public final void b(boolean paramAnonymousBoolean, long paramAnonymousLong)
            {
              AppMethodBeat.i(77978);
              ac.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              iu localiu;
              if (paramAnonymousBoolean)
              {
                h.wUl.dB(918, 2);
                b.a.a(b.a.this);
                localiu = new iu();
                localiu.dFy = localiu.t("appid", localdzd.djj, true);
                localiu.elC = localdzd.Eeo;
                localiu.ejG = localiu.t("downloadUrl", localdzd.Gfv, true);
                localiu.elD = localiu.t("pkgMd5", localdzd.Gfu, true);
                localiu.elG = System.currentTimeMillis();
                if (!paramAnonymousBoolean) {
                  break label192;
                }
              }
              label192:
              for (long l = 1L;; l = 0L)
              {
                localiu.elE = l;
                localiu.elF = (System.currentTimeMillis() - l);
                localiu.elH = paramAnonymousLong;
                localiu.aHZ();
                AppMethodBeat.o(77978);
                return;
                h.wUl.dB(918, 3);
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
        ac.printErrStackTrace("WidgetPkgPreDownloadMgr", localException, "", new Object[0]);
        AppMethodBeat.o(77979);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */