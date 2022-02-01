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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import d.g.b.p;
import d.l;
import java.io.File;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/updater/model/DownloadCallbackListener;", "Lcom/tencent/mm/plugin/downloader/model/IFileDownloadCallback;", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "downloadId", "", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;J)V", "TAG", "", "getDownloadId", "()J", "getResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "onTaskFailed", "", "id", "errCode", "", "hasChangeUrl", "", "onTaskFinished", "savedFilePath", "onTaskMd5Checking", "onTaskPaused", "onTaskProgressChanged", "url", "revcLeng", "totalLen", "onTaskRemoved", "onTaskResumed", "onTaskStarted", "plugin-updater_release"})
public final class a
  implements m
{
  private final com.tencent.mm.plugin.hp.d.b BVP;
  private final String TAG;
  private final long dkO;
  
  public a(com.tencent.mm.plugin.hp.d.b paramb, long paramLong)
  {
    AppMethodBeat.i(197766);
    this.BVP = paramb;
    this.dkO = paramLong;
    this.TAG = "MicroMsg.Updater.DownloadCallbackListener";
    AppMethodBeat.o(197766);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(197760);
    ae.i(this.TAG, "onTaskFailed cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong + " errCode:" + paramInt + " hasChangeUrl:" + paramBoolean);
    if (this.dkO == paramLong)
    {
      e.ywz.idkeyStat(1429L, 13L, 1L, false);
      f.cdA();
      f.b((m)this);
      h.MqF.aM((Runnable)a.BVQ);
    }
    AppMethodBeat.o(197760);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(197763);
    p.h(paramString, "url");
    ae.i(this.TAG, "onTaskProgressChanged cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong1 + " revcLeng:" + paramLong2 + " totalLen:" + paramLong3);
    if (this.dkO == paramLong1) {
      h.MqF.aM((Runnable)new c(paramLong2, paramLong3));
    }
    AppMethodBeat.o(197763);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197759);
    ae.i(this.TAG, "onTaskFinished cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong + " hasChangeUrl:" + paramBoolean + " savedFilePath:" + paramString);
    if (this.dkO == paramLong)
    {
      f.cdA();
      f.b((m)this);
      h.MqF.aM((Runnable)b.BVR);
      if (paramString != null)
      {
        Object localObject1 = b.BVV;
        localObject1 = this.BVP;
        p.h(localObject1, "response");
        p.h(paramString, "savePath");
        ae.i(b.TAG, "onDownloadFinish savePath:".concat(String.valueOf(paramString)));
        Object localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).nZK;
        if (localObject2 == null) {}
        while (((Integer)localObject2).intValue() != 3)
        {
          localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).nZK;
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(197759);
          return;
        }
        e.ywz.idkeyStat(1429L, 8L, 1L, false);
        h.MqF.f((Runnable)new b.a(paramString, (com.tencent.mm.plugin.hp.d.b)localObject1), "Updater");
        AppMethodBeat.o(197759);
        return;
        if (((Integer)localObject2).intValue() == 2)
        {
          e.ywz.idkeyStat(1429L, 9L, 1L, false);
          paramString = new File(paramString);
          localObject2 = new ShareSecurityCheck(ak.getContext());
          if (((ShareSecurityCheck)localObject2).verifyPatchMetaSignature(paramString))
          {
            if (ag.Mw().Mz())
            {
              localObject2 = ((ShareSecurityCheck)localObject2).getPackagePropertiesIfPresent();
              if (localObject2 != null)
              {
                localObject2 = (String)((HashMap)localObject2).get("patch.client.ver");
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  break label452;
                }
                localObject2 = com.tencent.mm.plugin.hp.tinker.b.hA(com.tencent.mm.loader.j.a.hju, (String)localObject2);
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).dfq();
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).dfp();
              }
              for (;;)
              {
                TinkerPatchResultService.a((com.tinkerboots.sdk.tinker.a.a)new b.b((com.tencent.mm.plugin.hp.d.b)localObject1));
                localObject1 = com.tencent.tinker.lib.e.a.lq(ak.getContext());
                p.g(localObject1, "Tinker.with(MMApplicationContext.getContext())");
                int i = ((com.tencent.tinker.lib.e.a)localObject1).gcZ().bbr(paramString.getAbsolutePath());
                ae.i(b.TAG, "start to run patch. ret = ".concat(String.valueOf(i)));
                if ((i == 0) && (i == -3)) {
                  break;
                }
                b.evq();
                e.ywz.idkeyStat(1429L, 21L, 1L, false);
                AppMethodBeat.o(197759);
                return;
                label452:
                ae.e(b.TAG, "Fail to get patch clientversion.");
              }
              e.ywz.idkeyStat(1429L, 22L, 1L, false);
              AppMethodBeat.o(197759);
              return;
            }
            b.evq();
            e.ywz.idkeyStat(1429L, 20L, 1L, false);
            ae.i(b.TAG, "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientversion to recover.");
            AppMethodBeat.o(197759);
            return;
          }
          b.evq();
          e.ywz.idkeyStat(1429L, 17L, 1L, false);
          ae.i(b.TAG, "hot patch verfiy signature error");
        }
        AppMethodBeat.o(197759);
        return;
      }
    }
    AppMethodBeat.o(197759);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(197758);
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onTaskStarted cdnUrl:").append(this.BVP.gKg).append(" downloadId:").append(this.dkO).append(" id:").append(paramLong).append(" savedFilePath:");
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    ae.i(str2, str1);
    if (this.dkO == paramLong)
    {
      e.ywz.idkeyStat(1429L, 12L, 1L, false);
      h.MqF.aM((Runnable)d.BVU);
    }
    AppMethodBeat.o(197758);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(197764);
    ae.i(this.TAG, "onTaskResumed cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong);
    AppMethodBeat.o(197764);
  }
  
  public final void sY(long paramLong)
  {
    AppMethodBeat.i(197761);
    ae.i(this.TAG, "onTaskRemoved cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong);
    if (this.dkO == paramLong)
    {
      f.cdA();
      f.b((m)this);
    }
    AppMethodBeat.o(197761);
  }
  
  public final void sZ(long paramLong)
  {
    AppMethodBeat.i(197762);
    ae.i(this.TAG, "onTaskPaused cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong);
    AppMethodBeat.o(197762);
  }
  
  public final void ta(long paramLong)
  {
    AppMethodBeat.i(197765);
    ae.i(this.TAG, "onTaskMd5Checking cdnUrl:" + this.BVP.gKg + " downloadId:" + this.dkO + " id:" + paramLong);
    AppMethodBeat.o(197765);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a BVQ;
    
    static
    {
      AppMethodBeat.i(197752);
      BVQ = new a();
      AppMethodBeat.o(197752);
    }
    
    public final void run()
    {
      AppMethodBeat.i(197751);
      Toast.makeText(ak.getContext(), (CharSequence)ak.getContext().getString(2131766991), 0).show();
      b localb = b.BVV;
      b.evs();
      AppMethodBeat.o(197751);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b BVR;
    
    static
    {
      AppMethodBeat.i(197754);
      BVR = new b();
      AppMethodBeat.o(197754);
    }
    
    public final void run()
    {
      AppMethodBeat.i(197753);
      Toast.makeText(ak.getContext(), (CharSequence)ak.getContext().getString(2131766998), 0).show();
      Object localObject = b.BVV;
      localObject = b.BVV;
      localObject = b.getString(2131767038);
      b localb = b.BVV;
      b.a((String)localObject, b.getString(2131766998), null);
      AppMethodBeat.o(197753);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(197755);
      Object localObject = b.BVV;
      localObject = b.BVV;
      localObject = b.getString(2131767038);
      StringBuilder localStringBuilder = new StringBuilder();
      b localb = b.BVV;
      b.a((String)localObject, b.getString(2131766992) + this.BVS * 100L / this.BVT + '%', null);
      AppMethodBeat.o(197755);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d BVU;
    
    static
    {
      AppMethodBeat.i(197757);
      BVU = new d();
      AppMethodBeat.o(197757);
    }
    
    public final void run()
    {
      AppMethodBeat.i(197756);
      Toast.makeText(ak.getContext(), (CharSequence)ak.getContext().getString(2131766993), 0).show();
      Object localObject = b.BVV;
      localObject = b.BVV;
      localObject = b.getString(2131767038);
      b localb = b.BVV;
      b.a((String)localObject, b.getString(2131766992, new Object[] { "0%" }), null);
      AppMethodBeat.o(197756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.a
 * JD-Core Version:    0.7.0.1
 */