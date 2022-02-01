package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ai;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/updater/model/DownloadCallbackListener;", "Lcom/tencent/mm/plugin/downloader/model/IFileDownloadCallback;", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "downloadId", "", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;J)V", "TAG", "", "getDownloadId", "()J", "getResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "onTaskFailed", "", "id", "errCode", "", "hasChangeUrl", "", "onTaskFinished", "savedFilePath", "onTaskMd5Checking", "onTaskPaused", "onTaskProgressChanged", "url", "revcLeng", "totalLen", "onTaskRemoved", "onTaskResumed", "onTaskStarted", "plugin-updater_release"})
public final class a
  implements m
{
  private final com.tencent.mm.plugin.hp.d.b NjO;
  private final String TAG;
  private final long fuD;
  
  public a(com.tencent.mm.plugin.hp.d.b paramb, long paramLong)
  {
    AppMethodBeat.i(196217);
    this.NjO = paramb;
    this.fuD = paramLong;
    this.TAG = "MicroMsg.Updater.DownloadCallbackListener";
    AppMethodBeat.o(196217);
  }
  
  public final void Hp(long paramLong)
  {
    AppMethodBeat.i(196203);
    Log.i(this.TAG, "onTaskRemoved cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong);
    if (this.fuD == paramLong)
    {
      com.tencent.mm.plugin.downloader.model.f.cPZ();
      com.tencent.mm.plugin.downloader.model.f.b((m)this);
    }
    AppMethodBeat.o(196203);
  }
  
  public final void Hq(long paramLong)
  {
    AppMethodBeat.i(196204);
    Log.i(this.TAG, "onTaskPaused cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong);
    AppMethodBeat.o(196204);
  }
  
  public final void Hr(long paramLong)
  {
    AppMethodBeat.i(196212);
    Log.i(this.TAG, "onTaskMd5Checking cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong);
    AppMethodBeat.o(196212);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(196207);
    p.k(paramString, "url");
    Log.i(this.TAG, "onTaskProgressChanged cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong1 + " revcLeng:" + paramLong2 + " totalLen:" + paramLong3);
    if (this.fuD == paramLong1) {
      h.ZvG.bc((Runnable)new c(paramLong2, paramLong3));
    }
    AppMethodBeat.o(196207);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196201);
    Log.i(this.TAG, "onTaskFailed cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong + " errCode:" + paramInt + " hasChangeUrl:" + paramBoolean);
    if (this.fuD == paramLong)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 13L, 1L, false);
      com.tencent.mm.plugin.downloader.model.f.cPZ();
      com.tencent.mm.plugin.downloader.model.f.b((m)this);
      h.ZvG.bc((Runnable)a.NjP);
    }
    AppMethodBeat.o(196201);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196196);
    Log.i(this.TAG, "onTaskFinished cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong + " hasChangeUrl:" + paramBoolean + " savedFilePath:" + paramString);
    if (this.fuD == paramLong)
    {
      com.tencent.mm.plugin.downloader.model.f.cPZ();
      com.tencent.mm.plugin.downloader.model.f.b((m)this);
      h.ZvG.bc((Runnable)b.NjQ);
      if (paramString != null)
      {
        Object localObject1 = b.NjU;
        localObject1 = this.NjO;
        p.k(localObject1, "response");
        p.k(paramString, "savePath");
        Log.i(b.TAG, "onDownloadFinish savePath:".concat(String.valueOf(paramString)));
        Object localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).smR;
        if (localObject2 == null) {}
        while (((Integer)localObject2).intValue() != 3)
        {
          localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject1).smR;
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(196196);
          return;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 8L, 1L, false);
        h.ZvG.d((Runnable)new b.a(paramString, (com.tencent.mm.plugin.hp.d.b)localObject1), "Updater");
        AppMethodBeat.o(196196);
        return;
        if (((Integer)localObject2).intValue() == 2)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 9L, 1L, false);
          paramString = new File(u.n(paramString, false));
          localObject2 = new ShareSecurityCheck(MMApplicationContext.getContext());
          try
          {
            paramBoolean = ((ShareSecurityCheck)localObject2).verifyPatchMetaSignature(paramString);
            if (!paramBoolean) {
              break label598;
            }
            if (!ai.abm().abp()) {
              break label566;
            }
            localObject2 = ((ShareSecurityCheck)localObject2).getPackagePropertiesIfPresent();
            if (localObject2 != null)
            {
              localObject2 = (String)((HashMap)localObject2).get("patch.client.ver");
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject2 = com.tencent.mm.plugin.hp.tinker.b.iv(com.tencent.mm.loader.j.a.CLIENT_VERSION, (String)localObject2);
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).eIh();
                ((com.tencent.mm.plugin.hp.tinker.b)localObject2).eIg();
              }
            }
            else
            {
              TinkerPatchResultService.a((com.tinkerboots.sdk.tinker.a.a)new b.b((com.tencent.mm.plugin.hp.d.b)localObject1));
              localObject2 = com.tencent.tinker.lib.e.a.mi(MMApplicationContext.getContext());
              p.j(localObject2, "Tinker.with(MMApplicationContext.getContext())");
              int i = ((com.tencent.tinker.lib.e.a)localObject2).isI().bDE(paramString.getAbsolutePath());
              Log.i(b.TAG, "start to run patch. ret = ".concat(String.valueOf(i)));
              switch (i)
              {
              default: 
                b.gsK();
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 21L, 1L, false);
                AppMethodBeat.o(196196);
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
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 30L, 1L, false);
            AppMethodBeat.o(196196);
            return;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 22L, 1L, false);
          AppMethodBeat.o(196196);
          return;
          label566:
          b.gsK();
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 20L, 1L, false);
          Log.i(b.TAG, "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientversion to recover.");
          AppMethodBeat.o(196196);
          return;
          label598:
          b.gsK();
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 17L, 1L, false);
          Log.i(b.TAG, "hot patch verfiy signature error");
        }
        AppMethodBeat.o(196196);
        return;
      }
    }
    AppMethodBeat.o(196196);
  }
  
  public final void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(196171);
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onTaskStarted cdnUrl:").append(this.NjO.smT).append(" downloadId:").append(this.fuD).append(" id:").append(paramLong).append(" savedFilePath:");
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    Log.i(str2, str1);
    if (this.fuD == paramLong)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 12L, 1L, false);
      h.ZvG.bc((Runnable)d.NjT);
    }
    AppMethodBeat.o(196171);
  }
  
  public final void n(long paramLong, String paramString)
  {
    AppMethodBeat.i(196210);
    Log.i(this.TAG, "onTaskResumed cdnUrl:" + this.NjO.smT + " downloadId:" + this.fuD + " id:" + paramLong);
    AppMethodBeat.o(196210);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a NjP;
    
    static
    {
      AppMethodBeat.i(196082);
      NjP = new a();
      AppMethodBeat.o(196082);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196081);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(com.tencent.mm.plugin.updater.a.c.updater_download_fail), 0).show();
      b localb = b.NjU;
      b.gsM();
      AppMethodBeat.o(196081);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b NjQ;
    
    static
    {
      AppMethodBeat.i(196012);
      NjQ = new b();
      AppMethodBeat.o(196012);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196009);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(com.tencent.mm.plugin.updater.a.c.updater_merge_wording), 0).show();
      Object localObject = b.NjU;
      localObject = b.NjU;
      localObject = b.getString(com.tencent.mm.plugin.updater.a.c.wechat);
      b localb = b.NjU;
      b.a((String)localObject, b.getString(com.tencent.mm.plugin.updater.a.c.updater_merge_wording), null);
      AppMethodBeat.o(196009);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(196039);
      Object localObject = b.NjU;
      localObject = b.NjU;
      localObject = b.getString(com.tencent.mm.plugin.updater.a.c.wechat);
      StringBuilder localStringBuilder = new StringBuilder();
      b localb = b.NjU;
      b.a((String)localObject, b.getString(com.tencent.mm.plugin.updater.a.c.updater_download_progress) + this.NjR * 100L / this.NjS + '%', null);
      AppMethodBeat.o(196039);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d NjT;
    
    static
    {
      AppMethodBeat.i(196065);
      NjT = new d();
      AppMethodBeat.o(196065);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196063);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(com.tencent.mm.plugin.updater.a.c.updater_download_start), 0).show();
      Object localObject = b.NjU;
      localObject = b.NjU;
      localObject = b.getString(com.tencent.mm.plugin.updater.a.c.wechat);
      b localb = b.NjU;
      b.a((String)localObject, b.getString(com.tencent.mm.plugin.updater.a.c.updater_download_progress, new Object[] { "0%" }), null);
      AppMethodBeat.o(196063);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.a
 * JD-Core Version:    0.7.0.1
 */