package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.oc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.fbm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final b IPA;
  private a IPB;
  
  static
  {
    AppMethodBeat.i(77984);
    IPA = new b();
    AppMethodBeat.o(77984);
  }
  
  public static boolean a(c paramc)
  {
    AppMethodBeat.i(77982);
    if ("1".equals(paramc.gzz().get("canPreloadWidget")))
    {
      AppMethodBeat.o(77982);
      return true;
    }
    Log.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
    AppMethodBeat.o(77982);
    return false;
  }
  
  public static b gaE()
  {
    return IPA;
  }
  
  static final class a
    implements Runnable
  {
    boolean ifP;
    List<fbm> list;
    MMHandler mHandler;
    int sTB = 0;
    
    public a(List<fbm> paramList)
    {
      this.list = paramList;
    }
    
    private void gaF()
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
        int i = this.sTB + 1;
        this.sTB = i;
        if (i > this.list.size())
        {
          Log.i("WidgetPkgPreDownloadMgr", "download over, index %d", new Object[] { Integer.valueOf(this.sTB) });
          this.list = null;
          Thread.currentThread().interrupt();
          this.mHandler = null;
          AppMethodBeat.o(77979);
          return;
        }
        final fbm localfbm = (fbm)this.list.get(this.sTB - 1);
        Log.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", new Object[] { localfbm.dNI, localfbm.NxJ });
        if (localfbm != null)
        {
          if ((TextUtils.isEmpty(localfbm.dNI)) || (TextUtils.isEmpty(localfbm.NxJ)) || (TextUtils.isEmpty(localfbm.BsJ)))
          {
            Log.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
            gaF();
            AppMethodBeat.o(77979);
            return;
          }
          ((i)g.af(i.class)).a(localfbm.dNI, localfbm.KXD, localfbm.NxJ, localfbm.BsJ);
          if (((i)g.af(i.class)).an(localfbm.dNI, localfbm.KXD))
          {
            Log.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
            gaF();
            AppMethodBeat.o(77979);
            return;
          }
          Log.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
          h.CyF.dN(918, 1);
          final long l = System.currentTimeMillis();
          ((i)g.af(i.class)).a(localfbm.dNI, localfbm.KXD, localfbm.BsJ, new j()
          {
            public final void b(boolean paramAnonymousBoolean, long paramAnonymousLong)
            {
              AppMethodBeat.i(77978);
              Log.i("WidgetPkgPreDownloadMgr", "down succ %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              oc localoc;
              if (paramAnonymousBoolean)
              {
                h.CyF.dN(918, 2);
                b.a.a(b.a.this);
                localoc = new oc();
                localoc.enR = localoc.x("appid", localfbm.dNI, true);
                localoc.exo = localfbm.KXD;
                localoc.fgP = localoc.x("downloadUrl", localfbm.BsJ, true);
                localoc.fiT = localoc.x("pkgMd5", localfbm.NxJ, true);
                localoc.fiW = System.currentTimeMillis();
                if (!paramAnonymousBoolean) {
                  break label192;
                }
              }
              label192:
              for (long l = 1L;; l = 0L)
              {
                localoc.fiU = l;
                localoc.fiV = (System.currentTimeMillis() - l);
                localoc.fiX = paramAnonymousLong;
                localoc.bfK();
                AppMethodBeat.o(77978);
                return;
                h.CyF.dN(918, 3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */