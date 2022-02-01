package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import d.g.b.p;
import d.l;
import java.io.File;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/updater/model/DownloadCallbackListener;", "Lcom/tencent/mm/plugin/downloader/model/IFileDownloadCallback;", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "downloadId", "", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;J)V", "TAG", "", "getDownloadId", "()J", "getResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "onTaskFailed", "", "id", "errCode", "", "hasChangeUrl", "", "onTaskFinished", "savedFilePath", "onTaskMd5Checking", "onTaskPaused", "onTaskProgressChanged", "url", "revcLeng", "totalLen", "onTaskRemoved", "onTaskResumed", "onTaskStarted", "plugin-updater_release"})
public final class a
  implements m
{
  private final com.tencent.mm.plugin.hp.d.b BEr;
  private final String TAG;
  private final long djM;
  
  public a(com.tencent.mm.plugin.hp.d.b paramb, long paramLong)
  {
    AppMethodBeat.i(214553);
    this.BEr = paramb;
    this.djM = paramLong;
    this.TAG = "MicroMsg.Updater.DownloadCallbackListener";
    AppMethodBeat.o(214553);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(214547);
    ad.i(this.TAG, "onTaskFailed cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong + " errCode:" + paramInt + " hasChangeUrl:" + paramBoolean);
    if (this.djM == paramLong)
    {
      e.ygI.idkeyStat(1429L, 13L, 1L, false);
      f.ccl();
      f.b((m)this);
      h.LTJ.aP((Runnable)a.BEs);
    }
    AppMethodBeat.o(214547);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(214550);
    p.h(paramString, "url");
    ad.i(this.TAG, "onTaskProgressChanged cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong1 + " revcLeng:" + paramLong2 + " totalLen:" + paramLong3);
    if (this.djM == paramLong1) {
      h.LTJ.aP((Runnable)new c(paramLong2, paramLong3));
    }
    AppMethodBeat.o(214550);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(214546);
    ad.i(this.TAG, "onTaskFinished cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong + " hasChangeUrl:" + paramBoolean + " savedFilePath:" + paramString);
    if (this.djM == paramLong)
    {
      f.ccl();
      f.b((m)this);
      h.LTJ.aP((Runnable)b.BEt);
      if (paramString != null)
      {
        Object localObject1 = b.BEx;
        localObject1 = this.BEr;
        p.h(localObject1, "response");
        p.h(paramString, "savePath");
        ad.i(b.TAG, "onDownloadFinish savePath:".concat(String.valueOf(paramString)));
        Object localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).nUe;
        if (localObject2 == null) {}
        while (((Integer)localObject2).intValue() != 3)
        {
          localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).nUe;
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(214546);
          return;
        }
        e.ygI.idkeyStat(1429L, 8L, 1L, false);
        h.LTJ.f((Runnable)new b.a(paramString, (com.tencent.mm.plugin.hp.d.b)localObject1), "Updater");
        AppMethodBeat.o(214546);
        return;
        if (((Integer)localObject2).intValue() == 2)
        {
          e.ygI.idkeyStat(1429L, 9L, 1L, false);
          paramString = new File(paramString);
          localObject2 = new ShareSecurityCheck(aj.getContext());
          if (((ShareSecurityCheck)localObject2).verifyPatchMetaSignature(paramString))
          {
            if (ag.MB().ME())
            {
              localObject2 = ((ShareSecurityCheck)localObject2).getPackagePropertiesIfPresent();
              if (localObject2 != null)
              {
                localObject2 = (String)((HashMap)localObject2).get("patch.client.ver");
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label452;
                }
                localObject2 = com.tencent.mm.plugin.hp.tinker.b.ht(com.tencent.mm.loader.j.a.hgG, (String)localObject2);
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).dcy();
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).dcx();
              }
              for (;;)
              {
                TinkerPatchResultService.a((com.tinkerboots.sdk.tinker.a.a)new b.b((com.tencent.mm.plugin.hp.d.b)localObject1));
                localObject1 = com.tencent.tinker.lib.e.a.lk(aj.getContext());
                p.g(localObject1, "Tinker.with(MMApplicationContext.getContext())");
                int i = ((com.tencent.tinker.lib.e.a)localObject1).fYA().aZO(paramString.getAbsolutePath());
                ad.i(b.TAG, "start to run patch. ret = ".concat(String.valueOf(i)));
                if ((i == 0) && (i == -3)) {
                  break;
                }
                b.erJ();
                e.ygI.idkeyStat(1429L, 21L, 1L, false);
                AppMethodBeat.o(214546);
                return;
                label452:
                ad.e(b.TAG, "Fail to get patch clientversion.");
              }
              e.ygI.idkeyStat(1429L, 22L, 1L, false);
              AppMethodBeat.o(214546);
              return;
            }
            b.erJ();
            e.ygI.idkeyStat(1429L, 20L, 1L, false);
            ad.i(b.TAG, "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientversion to recover.");
            AppMethodBeat.o(214546);
            return;
          }
          b.erJ();
          e.ygI.idkeyStat(1429L, 17L, 1L, false);
          ad.i(b.TAG, "hot patch verfiy signature error");
        }
        AppMethodBeat.o(214546);
        return;
      }
    }
    AppMethodBeat.o(214546);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(214545);
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onTaskStarted cdnUrl:").append(this.BEr.gHx).append(" downloadId:").append(this.djM).append(" id:").append(paramLong).append(" savedFilePath:");
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    ad.i(str2, str1);
    if (this.djM == paramLong)
    {
      e.ygI.idkeyStat(1429L, 12L, 1L, false);
      h.LTJ.aP((Runnable)d.BEw);
    }
    AppMethodBeat.o(214545);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(214551);
    ad.i(this.TAG, "onTaskResumed cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong);
    AppMethodBeat.o(214551);
  }
  
  public final void sL(long paramLong)
  {
    AppMethodBeat.i(214548);
    ad.i(this.TAG, "onTaskRemoved cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong);
    if (this.djM == paramLong)
    {
      f.ccl();
      f.b((m)this);
    }
    AppMethodBeat.o(214548);
  }
  
  public final void sM(long paramLong)
  {
    AppMethodBeat.i(214549);
    ad.i(this.TAG, "onTaskPaused cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong);
    AppMethodBeat.o(214549);
  }
  
  public final void sN(long paramLong)
  {
    AppMethodBeat.i(214552);
    ad.i(this.TAG, "onTaskMd5Checking cdnUrl:" + this.BEr.gHx + " downloadId:" + this.djM + " id:" + paramLong);
    AppMethodBeat.o(214552);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a BEs;
    
    static
    {
      AppMethodBeat.i(214539);
      BEs = new a();
      AppMethodBeat.o(214539);
    }
    
    public final void run()
    {
      AppMethodBeat.i(214538);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131766991), 0).show();
      b localb = b.BEx;
      b.erL();
      AppMethodBeat.o(214538);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b BEt;
    
    static
    {
      AppMethodBeat.i(214541);
      BEt = new b();
      AppMethodBeat.o(214541);
    }
    
    public final void run()
    {
      AppMethodBeat.i(214540);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131766998), 0).show();
      Object localObject = b.BEx;
      localObject = b.BEx;
      localObject = b.getString(2131767038);
      b localb = b.BEx;
      b.a((String)localObject, b.getString(2131766998), null);
      AppMethodBeat.o(214540);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(214542);
      Object localObject = b.BEx;
      localObject = b.BEx;
      localObject = b.getString(2131767038);
      StringBuilder localStringBuilder = new StringBuilder();
      b localb = b.BEx;
      b.a((String)localObject, b.getString(2131766992) + this.BEu * 100L / this.BEv + '%', null);
      AppMethodBeat.o(214542);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d BEw;
    
    static
    {
      AppMethodBeat.i(214544);
      BEw = new d();
      AppMethodBeat.o(214544);
    }
    
    public final void run()
    {
      AppMethodBeat.i(214543);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131766993), 0).show();
      Object localObject = b.BEx;
      localObject = b.BEx;
      localObject = b.getString(2131767038);
      b localb = b.BEx;
      b.a((String)localObject, b.getString(2131766992, new Object[] { "0%" }), null);
      AppMethodBeat.o(214543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.a
 * JD-Core Version:    0.7.0.1
 */