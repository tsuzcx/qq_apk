package com.tencent.mm.plugin.updater.model;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import d.g.b.p;
import d.l;
import d.v;
import java.io.File;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/updater/model/ManualUpdaterProcessor;", "", "()V", "NOTIFICATION_ID", "", "TAG", "", "cancelNotification", "", "checkAndShowInstallBsPatchDialog", "", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "dealWithAlphaVersion", "getString", "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onDownloadFinish", "savePath", "patchRollBack", "prepareToDownload", "process", "processBsPatch", "processHotPatch", "showNotification", "title", "text", "pendingIntent", "Landroid/app/PendingIntent;", "updateFailToast", "plugin-updater_release"})
public final class b
{
  public static final b BEx;
  public static final String TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
  private static final int jSz = 8341;
  
  static
  {
    AppMethodBeat.i(214574);
    BEx = new b();
    TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
    jSz = 8341;
    AppMethodBeat.o(214574);
  }
  
  public static void a(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(214566);
    ad.i(TAG, "prepare to download fileMd5:" + paramb.nUg + " fileSize:" + paramb.fileSize + " cdnUrl:" + paramb.gHx);
    if ((p.i(g.getExternalStorageState(), "mounted") ^ true))
    {
      ad.e(TAG, "no sdcard.");
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 9L, 1L, false);
      AppMethodBeat.o(214566);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.qR(paramb.fileSize))
    {
      ad.e(TAG, "sdcard is full.");
      h.LTJ.aP((Runnable)b.d.BEE);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 10L, 1L, false);
      AppMethodBeat.o(214566);
      return;
    }
    aj.getContext();
    com.tencent.mm.plugin.hp.d.d.dcO();
    com.tencent.mm.plugin.hp.d.d.dcP();
    g.a locala = new g.a();
    locala.aak(paramb.gHx);
    locala.aam(paramb.nUh);
    locala.aan(paramb.nUg);
    locala.jQ(false);
    locala.jS(true);
    locala.ccw();
    locala.jR(false);
    locala.Bp(2);
    long l = com.tencent.mm.plugin.downloader.model.f.ccl().a(locala.ccv());
    com.tencent.mm.plugin.downloader.model.f.ccl();
    com.tencent.mm.plugin.downloader.model.f.a((com.tencent.mm.plugin.downloader.model.m)new a(paramb, l));
    ad.i(TAG, "download start");
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 11L, 1L, false);
    AppMethodBeat.o(214566);
  }
  
  public static void a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(214570);
    p.h(paramString1, "title");
    p.h(paramString2, "text");
    paramString1 = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(null).F(true).i(System.currentTimeMillis()).f((CharSequence)paramString1).g((CharSequence)paramString2).a(paramPendingIntent).as(com.tencent.mm.br.a.dwe()).build();
    paramString2 = aj.getContext().getSystemService("notification");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(214570);
      throw paramString1;
    }
    ((NotificationManager)paramString2).notify(jSz, paramString1);
    AppMethodBeat.o(214570);
  }
  
  public static boolean b(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(214568);
    ad.i(TAG, "checkAndShowInstallBsPatchDialog");
    paramb = com.tencent.mm.plugin.hp.d.d.anr(paramb.uJh);
    if ((com.tencent.mm.vfs.i.fv(paramb)) && (com.tencent.mm.d.a.eW(paramb)))
    {
      ad.i(TAG, "checkAndShowInstallBsPatchDialog apk ready ".concat(String.valueOf(paramb)));
      r.b(aj.getContext(), paramb, null, false);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 5L, 1L, false);
      AppMethodBeat.o(214568);
      return true;
    }
    AppMethodBeat.o(214568);
    return false;
  }
  
  static void erJ()
  {
    AppMethodBeat.i(214567);
    ad.i(TAG, "updateFailToast");
    h.LTJ.aP((Runnable)e.BEF);
    AppMethodBeat.o(214567);
  }
  
  public static void erK()
  {
    AppMethodBeat.i(214569);
    Object localObject = aj.getContext();
    final com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lk((Context)localObject);
    p.g(locala, "tinker");
    if (!locala.fYx())
    {
      ad.w(TAG, "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      AppMethodBeat.o(214569);
      return;
    }
    ad.i(TAG, "tinker wait screen to clean patch and kill all process");
    new com.tencent.mm.modelmulti.m((Context)localObject, (m.a)new c((Context)localObject, locala));
    localObject = new SharePatchInfo(locala.fYw().Mhf, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex");
    SharePatchInfo.rewritePatchInfoFileWithLock(locala.fYy(), (SharePatchInfo)localObject, locala.fYz());
    AppMethodBeat.o(214569);
  }
  
  public static void erL()
  {
    AppMethodBeat.i(214571);
    Object localObject = aj.getContext().getSystemService("notification");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(214571);
      throw ((Throwable)localObject);
    }
    ((NotificationManager)localObject).cancel(jSz);
    AppMethodBeat.o(214571);
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(214572);
    String str = aj.getContext().getString(paramInt);
    p.g(str, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(214572);
    return str;
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214573);
    p.h(paramVarArgs, "args");
    paramVarArgs = aj.getContext().getString(paramInt, new Object[] { paramVarArgs });
    p.g(paramVarArgs, "MMApplicationContext.get…().getString(resId, args)");
    AppMethodBeat.o(214573);
    return paramVarArgs;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(214556);
      Object localObject3 = new File(this.BEy);
      Object localObject1 = com.tencent.mm.plugin.hp.d.d.anr(this.BEz.uJh);
      Object localObject2 = com.tencent.mm.plugin.hp.d.d.fE(aj.getContext());
      localObject3 = ((File)localObject3).getAbsolutePath();
      long l = cf.aCM();
      int i = com.tencent.mm.plugin.hp.a.b.p((String)localObject2, (String)localObject3, (String)localObject1, this.BEz.uJh);
      localObject2 = b.BEx;
      ad.i(b.erM(), "merge bs diff costTime:" + (cf.aCM() - l) + ' ' + (String)localObject3 + ' ' + (String)localObject1 + " retCode:" + i);
      SharePatchFileUtil.safeDeleteFile(new File((String)localObject3));
      if (i == 0)
      {
        localObject1 = b.BEx;
        if (!b.c(this.BEz))
        {
          localObject1 = b.BEx;
          b.erN();
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 19L, 1L, false);
          AppMethodBeat.o(214556);
          return;
        }
        h.LTJ.aP((Runnable)1.BEA);
        AppMethodBeat.o(214556);
        return;
      }
      localObject1 = b.BEx;
      b.erN();
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 18L, 1L, false);
      AppMethodBeat.o(214556);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/tinker/lib/service/PatchResult;", "kotlin.jvm.PlatformType", "onPatchResult"})
  static final class b
    implements com.tinkerboots.sdk.tinker.a.a
  {
    b(com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void a(com.tencent.tinker.lib.service.a parama)
    {
      AppMethodBeat.i(214560);
      TinkerPatchResultService.a(null);
      b localb = b.BEx;
      ad.i(b.erM(), "patchResult costTime: %s, path: %s, isSuccess: %b", new Object[] { Long.valueOf(parama.msQ), parama.MgK, Boolean.valueOf(parama.dpX) });
      if (parama.dpX)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 23L, 1L, false);
        h.LTJ.aP((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(214559);
            Object localObject1 = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
            Object localObject2 = b.BEx;
            localObject2 = bt.Dd(this.BEB.BEz.fileSize);
            p.g(localObject2, "Util.getSizeMB(response.fileSize.toLong())");
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).aXO(b.getString(2131766995, new Object[] { localObject2 }));
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).c((f.c)1.BEC);
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).yU(true);
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).show();
            localObject1 = b.BEx;
            ad.i(b.erM(), "hotPatchInstallSuccessDialog show");
            AppMethodBeat.o(214559);
          }
        });
        AppMethodBeat.o(214560);
        return;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 24L, 1L, false);
      parama = b.BEx;
      b.erN();
      AppMethodBeat.o(214560);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isOn", "", "onScreenStateChange"})
  static final class c
    implements m.a
  {
    c(Context paramContext, com.tencent.tinker.lib.e.a parama) {}
    
    public final void ch(boolean paramBoolean)
    {
      AppMethodBeat.i(214561);
      if (!paramBoolean)
      {
        Object localObject1 = b.BEx;
        ad.i(b.erM(), "app is background now, i can kill quietly");
        ShareTinkerInternals.killAllOtherProcess(this.cqB);
        locala.dcB();
        localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      AppMethodBeat.o(214561);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e BEF;
    
    static
    {
      AppMethodBeat.i(214565);
      BEF = new e();
      AppMethodBeat.o(214565);
    }
    
    public final void run()
    {
      AppMethodBeat.i(214564);
      Object localObject = aj.getContext();
      b localb = b.BEx;
      Toast.makeText((Context)localObject, (CharSequence)b.getString(2131766997), 1).show();
      localObject = b.BEx;
      b.erL();
      AppMethodBeat.o(214564);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b
 * JD-Core Version:    0.7.0.1
 */