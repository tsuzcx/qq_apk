package com.tencent.mm.plugin.updater.model;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import d.g.b.p;
import d.l;
import d.v;
import java.io.File;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/updater/model/ManualUpdaterProcessor;", "", "()V", "NOTIFICATION_ID", "", "TAG", "", "cancelNotification", "", "checkAndShowInstallBsPatchDialog", "", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "dealWithAlphaVersion", "getString", "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onDownloadFinish", "savePath", "patchRollBack", "prepareToDownload", "process", "processBsPatch", "processHotPatch", "showNotification", "title", "text", "pendingIntent", "Landroid/app/PendingIntent;", "updateFailToast", "plugin-updater_release"})
public final class b
{
  public static final b BVV;
  public static final String TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
  private static final int jVQ = 8341;
  
  static
  {
    AppMethodBeat.i(197787);
    BVV = new b();
    TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
    jVQ = 8341;
    AppMethodBeat.o(197787);
  }
  
  public static void a(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(197779);
    ae.i(TAG, "prepare to download fileMd5:" + paramb.nZM + " fileSize:" + paramb.fileSize + " cdnUrl:" + paramb.gKg);
    if ((p.i(g.getExternalStorageState(), "mounted") ^ true))
    {
      ae.e(TAG, "no sdcard.");
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 9L, 1L, false);
      AppMethodBeat.o(197779);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.re(paramb.fileSize))
    {
      ae.e(TAG, "sdcard is full.");
      h.MqF.aM((Runnable)b.d.BWc);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 10L, 1L, false);
      AppMethodBeat.o(197779);
      return;
    }
    ak.getContext();
    com.tencent.mm.plugin.hp.d.d.dfG();
    com.tencent.mm.plugin.hp.d.d.dfH();
    g.a locala = new g.a();
    locala.abb(paramb.gKg);
    locala.abd(paramb.nZN);
    locala.abe(paramb.nZM);
    locala.jP(false);
    locala.jR(true);
    locala.cdL();
    locala.jQ(false);
    locala.BB(2);
    long l = com.tencent.mm.plugin.downloader.model.f.cdA().a(locala.cdK());
    com.tencent.mm.plugin.downloader.model.f.cdA();
    com.tencent.mm.plugin.downloader.model.f.a((com.tencent.mm.plugin.downloader.model.m)new a(paramb, l));
    ae.i(TAG, "download start");
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 11L, 1L, false);
    AppMethodBeat.o(197779);
  }
  
  public static void a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(197783);
    p.h(paramString1, "title");
    p.h(paramString2, "text");
    paramString1 = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(null).F(true).i(System.currentTimeMillis()).f((CharSequence)paramString1).g((CharSequence)paramString2).a(paramPendingIntent).as(com.tencent.mm.bq.a.dzu()).build();
    paramString2 = ak.getContext().getSystemService("notification");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(197783);
      throw paramString1;
    }
    ((NotificationManager)paramString2).notify(jVQ, paramString1);
    AppMethodBeat.o(197783);
  }
  
  public static boolean b(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(197781);
    ae.i(TAG, "checkAndShowInstallBsPatchDialog");
    paramb = com.tencent.mm.plugin.hp.d.d.aot(paramb.uUU);
    if ((o.fB(paramb)) && (com.tencent.mm.d.a.fb(paramb)))
    {
      ae.i(TAG, "checkAndShowInstallBsPatchDialog apk ready ".concat(String.valueOf(paramb)));
      r.b(ak.getContext(), paramb, null, false);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 5L, 1L, false);
      AppMethodBeat.o(197781);
      return true;
    }
    AppMethodBeat.o(197781);
    return false;
  }
  
  static void evq()
  {
    AppMethodBeat.i(197780);
    ae.i(TAG, "updateFailToast");
    h.MqF.aM((Runnable)e.BWd);
    AppMethodBeat.o(197780);
  }
  
  public static void evr()
  {
    AppMethodBeat.i(197782);
    Object localObject = ak.getContext();
    final com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lq((Context)localObject);
    p.g(locala, "tinker");
    if (!locala.gcW())
    {
      ae.w(TAG, "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      AppMethodBeat.o(197782);
      return;
    }
    ae.i(TAG, "tinker wait screen to clean patch and kill all process");
    new com.tencent.mm.modelmulti.m((Context)localObject, (m.a)new c((Context)localObject, locala));
    localObject = new SharePatchInfo(locala.gcV().MEc, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
    SharePatchInfo.rewritePatchInfoFileWithLock(locala.gcX(), (SharePatchInfo)localObject, locala.gcY());
    AppMethodBeat.o(197782);
  }
  
  public static void evs()
  {
    AppMethodBeat.i(197784);
    Object localObject = ak.getContext().getSystemService("notification");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(197784);
      throw ((Throwable)localObject);
    }
    ((NotificationManager)localObject).cancel(jVQ);
    AppMethodBeat.o(197784);
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(197785);
    String str = ak.getContext().getString(paramInt);
    p.g(str, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(197785);
    return str;
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197786);
    p.h(paramVarArgs, "args");
    paramVarArgs = ak.getContext().getString(paramInt, new Object[] { paramVarArgs });
    p.g(paramVarArgs, "MMApplicationContext.get…().getString(resId, args)");
    AppMethodBeat.o(197786);
    return paramVarArgs;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(197769);
      Object localObject3 = new File(this.BVW);
      Object localObject1 = com.tencent.mm.plugin.hp.d.d.aot(this.BVX.uUU);
      Object localObject2 = com.tencent.mm.plugin.hp.d.d.fJ(ak.getContext());
      localObject3 = ((File)localObject3).getAbsolutePath();
      long l = ch.aDc();
      int i = com.tencent.mm.plugin.hp.a.b.p((String)localObject2, (String)localObject3, (String)localObject1, this.BVX.uUU);
      localObject2 = b.BVV;
      ae.i(b.evt(), "merge bs diff costTime:" + (ch.aDc() - l) + ' ' + (String)localObject3 + ' ' + (String)localObject1 + " retCode:" + i);
      SharePatchFileUtil.safeDeleteFile(new File((String)localObject3));
      if (i == 0)
      {
        localObject1 = b.BVV;
        if (!b.c(this.BVX))
        {
          localObject1 = b.BVV;
          b.evu();
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 19L, 1L, false);
          AppMethodBeat.o(197769);
          return;
        }
        h.MqF.aM((Runnable)1.BVY);
        AppMethodBeat.o(197769);
        return;
      }
      localObject1 = b.BVV;
      b.evu();
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 18L, 1L, false);
      AppMethodBeat.o(197769);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/tinker/lib/service/PatchResult;", "kotlin.jvm.PlatformType", "onPatchResult"})
  static final class b
    implements com.tinkerboots.sdk.tinker.a.a
  {
    b(com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void a(com.tencent.tinker.lib.service.a parama)
    {
      AppMethodBeat.i(197773);
      TinkerPatchResultService.a(null);
      b localb = b.BVV;
      ae.i(b.evt(), "patchResult costTime: %s, path: %s, isSuccess: %b", new Object[] { Long.valueOf(parama.mxN), parama.MDH, Boolean.valueOf(parama.drc) });
      if (parama.drc)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 23L, 1L, false);
        h.MqF.aM((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197772);
            Object localObject1 = new com.tencent.mm.ui.widget.a.f.a(ak.getContext());
            Object localObject2 = b.BVV;
            localObject2 = bu.DB(this.BVZ.BVX.fileSize);
            p.g(localObject2, "Util.getSizeMB(response.fileSize.toLong())");
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).aZq(b.getString(2131766995, new Object[] { localObject2 }));
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).c((f.c)1.BWa);
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).zi(true);
            ((com.tencent.mm.ui.widget.a.f.a)localObject1).show();
            localObject1 = b.BVV;
            ae.i(b.evt(), "hotPatchInstallSuccessDialog show");
            AppMethodBeat.o(197772);
          }
        });
        AppMethodBeat.o(197773);
        return;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 24L, 1L, false);
      parama = b.BVV;
      b.evu();
      AppMethodBeat.o(197773);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isOn", "", "onScreenStateChange"})
  static final class c
    implements m.a
  {
    c(Context paramContext, com.tencent.tinker.lib.e.a parama) {}
    
    public final void eR(boolean paramBoolean)
    {
      AppMethodBeat.i(197774);
      if (!paramBoolean)
      {
        Object localObject1 = b.BVV;
        ae.i(b.evt(), "app is background now, i can kill quietly");
        ShareTinkerInternals.killAllOtherProcess(this.crf);
        locala.dft();
        localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      AppMethodBeat.o(197774);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e BWd;
    
    static
    {
      AppMethodBeat.i(197778);
      BWd = new e();
      AppMethodBeat.o(197778);
    }
    
    public final void run()
    {
      AppMethodBeat.i(197777);
      Object localObject = ak.getContext();
      b localb = b.BVV;
      Toast.makeText((Context)localObject, (CharSequence)b.getString(2131766997), 1).show();
      localObject = b.BVV;
      b.evs();
      AppMethodBeat.o(197777);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b
 * JD-Core Version:    0.7.0.1
 */