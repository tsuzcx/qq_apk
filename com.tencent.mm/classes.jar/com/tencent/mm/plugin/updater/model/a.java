package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/updater/model/DownloadCallbackListener;", "Lcom/tencent/mm/plugin/downloader/model/IFileDownloadCallback;", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "downloadId", "", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;J)V", "TAG", "", "getDownloadId", "()J", "getResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "onTaskFailed", "", "id", "errCode", "", "hasChangeUrl", "", "onTaskFinished", "savedFilePath", "onTaskMd5Checking", "onTaskPaused", "onTaskProgressChanged", "url", "revcLeng", "totalLen", "onTaskRemoved", "onTaskResumed", "onTaskStarted", "plugin-updater_release"})
public final class a
  implements m
{
  private final com.tencent.mm.plugin.hp.d.b Gwv;
  private final String TAG;
  private final long dCa;
  
  public a(com.tencent.mm.plugin.hp.d.b paramb, long paramLong)
  {
    AppMethodBeat.i(194731);
    this.Gwv = paramb;
    this.dCa = paramLong;
    this.TAG = "MicroMsg.Updater.DownloadCallbackListener";
    AppMethodBeat.o(194731);
  }
  
  public final void Bd(long paramLong)
  {
    AppMethodBeat.i(194726);
    Log.i(this.TAG, "onTaskRemoved cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong);
    if (this.dCa == paramLong)
    {
      f.cBv();
      f.b((m)this);
    }
    AppMethodBeat.o(194726);
  }
  
  public final void Be(long paramLong)
  {
    AppMethodBeat.i(194727);
    Log.i(this.TAG, "onTaskPaused cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong);
    AppMethodBeat.o(194727);
  }
  
  public final void Bf(long paramLong)
  {
    AppMethodBeat.i(194730);
    Log.i(this.TAG, "onTaskMd5Checking cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong);
    AppMethodBeat.o(194730);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(194728);
    p.h(paramString, "url");
    Log.i(this.TAG, "onTaskProgressChanged cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong1 + " revcLeng:" + paramLong2 + " totalLen:" + paramLong3);
    if (this.dCa == paramLong1) {
      h.RTc.aV((Runnable)new c(paramLong2, paramLong3));
    }
    AppMethodBeat.o(194728);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194725);
    Log.i(this.TAG, "onTaskFailed cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong + " errCode:" + paramInt + " hasChangeUrl:" + paramBoolean);
    if (this.dCa == paramLong)
    {
      e.Cxv.idkeyStat(1429L, 13L, 1L, false);
      f.cBv();
      f.b((m)this);
      h.RTc.aV((Runnable)a.Gww);
    }
    AppMethodBeat.o(194725);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(194724);
    Log.i(this.TAG, "onTaskFinished cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong + " hasChangeUrl:" + paramBoolean + " savedFilePath:" + paramString);
    if (this.dCa == paramLong)
    {
      f.cBv();
      f.b((m)this);
      h.RTc.aV((Runnable)b.Gwx);
      if (paramString != null)
      {
        Object localObject1 = b.GwB;
        localObject1 = this.Gwv;
        p.h(localObject1, "response");
        p.h(paramString, "savePath");
        Log.i(b.TAG, "onDownloadFinish savePath:".concat(String.valueOf(paramString)));
        Object localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).pkI;
        if (localObject2 == null) {}
        while (((Integer)localObject2).intValue() != 3)
        {
          localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).pkI;
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(194724);
          return;
        }
        e.Cxv.idkeyStat(1429L, 8L, 1L, false);
        h.RTc.b((Runnable)new b.a(paramString, (com.tencent.mm.plugin.hp.d.b)localObject1), "Updater");
        AppMethodBeat.o(194724);
        return;
        if (((Integer)localObject2).intValue() == 2)
        {
          e.Cxv.idkeyStat(1429L, 9L, 1L, false);
          paramString = new File(s.k(paramString, false));
          localObject2 = new ShareSecurityCheck(MMApplicationContext.getContext());
          try
          {
            paramBoolean = ((ShareSecurityCheck)localObject2).verifyPatchMetaSignature(paramString);
            if (!paramBoolean) {
              break label598;
            }
            if (!ag.WK().WN()) {
              break label566;
            }
            localObject2 = ((ShareSecurityCheck)localObject2).getPackagePropertiesIfPresent();
            if (localObject2 != null)
            {
              localObject2 = (String)((HashMap)localObject2).get("patch.client.ver");
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject2 = com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, (String)localObject2);
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).dZk();
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).dZj();
              }
            }
            else
            {
              TinkerPatchResultService.a((com.tinkerboots.sdk.tinker.a.a)new b.b((com.tencent.mm.plugin.hp.d.b)localObject1));
              localObject2 = com.tencent.tinker.lib.e.a.lk(MMApplicationContext.getContext());
              p.g(localObject2, "Tinker.with(MMApplicationContext.getContext())");
              int i = ((com.tencent.tinker.lib.e.a)localObject2).hph().bqH(paramString.getAbsolutePath());
              Log.i(b.TAG, "start to run patch. ret = ".concat(String.valueOf(i)));
              switch (i)
              {
              default: 
                b.fAJ();
                e.Cxv.idkeyStat(1429L, 21L, 1L, false);
                AppMethodBeat.o(194724);
                return;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace(b.TAG, (Throwable)localException, "verifyPatchMetaSignature", new Object[0]);
              paramBoolean = false;
              continue;
              Log.e(b.TAG, "Fail to get patch clientversion.");
            }
            b.e((com.tencent.mm.plugin.hp.d.b)localObject1);
            e.Cxv.idkeyStat(1429L, 30L, 1L, false);
            AppMethodBeat.o(194724);
            return;
          }
          e.Cxv.idkeyStat(1429L, 22L, 1L, false);
          AppMethodBeat.o(194724);
          return;
          label566:
          b.fAJ();
          e.Cxv.idkeyStat(1429L, 20L, 1L, false);
          Log.i(b.TAG, "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientversion to recover.");
          AppMethodBeat.o(194724);
          return;
          label598:
          b.fAJ();
          e.Cxv.idkeyStat(1429L, 17L, 1L, false);
          Log.i(b.TAG, "hot patch verfiy signature error");
        }
        AppMethodBeat.o(194724);
        return;
      }
    }
    AppMethodBeat.o(194724);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(194723);
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onTaskStarted cdnUrl:").append(this.Gwv.pkK).append(" downloadId:").append(this.dCa).append(" id:").append(paramLong).append(" savedFilePath:");
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    Log.i(str2, str1);
    if (this.dCa == paramLong)
    {
      e.Cxv.idkeyStat(1429L, 12L, 1L, false);
      h.RTc.aV((Runnable)d.GwA);
    }
    AppMethodBeat.o(194723);
  }
  
  public final void l(long paramLong, String paramString)
  {
    AppMethodBeat.i(194729);
    Log.i(this.TAG, "onTaskResumed cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + paramLong);
    AppMethodBeat.o(194729);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a Gww;
    
    static
    {
      AppMethodBeat.i(194717);
      Gww = new a();
      AppMethodBeat.o(194717);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194716);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(2131766936), 0).show();
      b localb = b.GwB;
      b.fAL();
      AppMethodBeat.o(194716);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b Gwx;
    
    static
    {
      AppMethodBeat.i(194719);
      Gwx = new b();
      AppMethodBeat.o(194719);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194718);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(2131766943), 0).show();
      Object localObject = b.GwB;
      localObject = b.GwB;
      localObject = b.getString(2131768649);
      b localb = b.GwB;
      b.a((String)localObject, b.getString(2131766943), null);
      AppMethodBeat.o(194718);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(194720);
      Object localObject = b.GwB;
      localObject = b.GwB;
      localObject = b.getString(2131768649);
      StringBuilder localStringBuilder = new StringBuilder();
      b localb = b.GwB;
      b.a((String)localObject, b.getString(2131766937) + this.Gwy * 100L / this.Gwz + '%', null);
      AppMethodBeat.o(194720);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d GwA;
    
    static
    {
      AppMethodBeat.i(194722);
      GwA = new d();
      AppMethodBeat.o(194722);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194721);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(2131766938), 0).show();
      Object localObject = b.GwB;
      localObject = b.GwB;
      localObject = b.getString(2131768649);
      b localb = b.GwB;
      b.a((String)localObject, b.getString(2131766937, new Object[] { "0%" }), null);
      AppMethodBeat.o(194721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.a
 * JD-Core Version:    0.7.0.1
 */