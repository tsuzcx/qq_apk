package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.rd;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.protocal.protobuf.fmf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class b
{
  private static final b PLP;
  private a PLQ;
  
  static
  {
    AppMethodBeat.i(77984);
    PLP = new b();
    AppMethodBeat.o(77984);
  }
  
  public static b gTx()
  {
    return PLP;
  }
  
  static final class a
    implements Runnable
  {
    boolean kUD;
    List<fmf> list;
    MMHandler mHandler;
    int wzx = 0;
    
    public a(List<fmf> paramList)
    {
      this.list = paramList;
    }
    
    private void aDg()
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
        int i = this.wzx + 1;
        this.wzx = i;
        if (i > this.list.size())
        {
          Log.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.wzx) });
          this.list = null;
          Thread.currentThread().interrupt();
          this.mHandler = null;
          AppMethodBeat.o(77979);
          return;
        }
        final fmf localfmf = (fmf)this.list.get(this.wzx - 1);
        Log.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localfmf.appid, localfmf.ULa });
        if (localfmf != null)
        {
          if ((TextUtils.isEmpty(localfmf.appid)) || (TextUtils.isEmpty(localfmf.ULa)) || (TextUtils.isEmpty(localfmf.Hnd)))
          {
            Log.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
            aDg();
            AppMethodBeat.o(77979);
            return;
          }
          ((i)com.tencent.mm.kernel.h.ae(i.class)).a(localfmf.appid, localfmf.RYM, localfmf.ULa, localfmf.Hnd);
          if (((i)com.tencent.mm.kernel.h.ae(i.class)).aF(localfmf.appid, localfmf.RYM))
          {
            Log.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
            aDg();
            AppMethodBeat.o(77979);
            return;
          }
          Log.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
          com.tencent.mm.plugin.report.service.h.IzE.el(918, 1);
          final long l = System.currentTimeMillis();
          ((i)com.tencent.mm.kernel.h.ae(i.class)).a(localfmf.appid, localfmf.RYM, localfmf.Hnd, new j()
          {
            public final void b(boolean paramAnonymousBoolean, long paramAnonymousLong)
            {
              AppMethodBeat.i(77978);
              Log.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              rd localrd;
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.plugin.report.service.h.IzE.el(918, 2);
                b.a.a(b.a.this);
                localrd = new rd();
                localrd.giT = localrd.z("appid", localfmf.appid, true);
                localrd.gty = localfmf.RYM;
                localrd.hka = localrd.z("downloadUrl", localfmf.Hnd, true);
                localrd.hmd = localrd.z("pkgMd5", localfmf.ULa, true);
                localrd.hmg = System.currentTimeMillis();
                if (!paramAnonymousBoolean) {
                  break label192;
                }
              }
              label192:
              for (long l = 1L;; l = 0L)
              {
                localrd.hme = l;
                localrd.hmf = (System.currentTimeMillis() - l);
                localrd.hmh = paramAnonymousLong;
                localrd.bpa();
                AppMethodBeat.o(77978);
                return;
                com.tencent.mm.plugin.report.service.h.IzE.el(918, 3);
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
        Log.printErrStackTrace("WidgetPkgPreDownloadMgr", localException, "", new Object[0]);
        AppMethodBeat.o(77979);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */