package com.tencent.mm.plugin.updater.model;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/updater/model/ManualUpdaterProcessor;", "", "()V", "NOTIFICATION_ID", "", "TAG", "", "cancelNotification", "", "checkAndShowInstallBsPatchDialog", "", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "dealWithAlphaVersion", "getString", "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onDownloadFinish", "savePath", "patchRollBack", "prepareToDownload", "process", "processBsPatch", "processHotPatch", "showApplyPatchSuccessDialog", "showNotification", "title", "text", "pendingIntent", "Landroid/app/PendingIntent;", "updateFailToast", "plugin-updater_release"})
public final class b
{
  public static final b GwB;
  static final String TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
  private static final int kYM = 8341;
  
  static
  {
    AppMethodBeat.i(194757);
    GwB = new b();
    TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
    kYM = 8341;
    AppMethodBeat.o(194757);
  }
  
  public static void a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(194753);
    p.h(paramString1, "title");
    p.h(paramString2, "text");
    paramString1 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(null).E(true).i(System.currentTimeMillis()).f((CharSequence)paramString1).g((CharSequence)paramString2).a(paramPendingIntent).as(com.tencent.mm.bq.a.ezb()).build();
    paramString2 = MMApplicationContext.getContext().getSystemService("notification");
    if (paramString2 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(194753);
      throw paramString1;
    }
    ((NotificationManager)paramString2).notify(kYM, paramString1);
    AppMethodBeat.o(194753);
  }
  
  private static void b(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194745);
    Log.i(TAG, "handle bspatch");
    if (com.tencent.mm.plugin.hp.d.c.aBK(paramb.clientVersion))
    {
      Log.i(TAG, "handle alpha version " + paramb.clientVersion);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 4L, 1L, false);
      g(paramb);
      AppMethodBeat.o(194745);
      return;
    }
    if (!f(paramb))
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 6L, 1L, false);
      d(paramb);
    }
    AppMethodBeat.o(194745);
  }
  
  private static void c(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194746);
    Log.i(TAG, "handle hotpatch");
    d(paramb);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 7L, 1L, false);
    AppMethodBeat.o(194746);
  }
  
  private static void d(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194747);
    Log.i(TAG, "prepare to download fileMd5:" + paramb.pkL + " fileSize:" + paramb.fileSize + " cdnUrl:" + paramb.pkK);
    if ((p.j(g.getExternalStorageState(), "mounted") ^ true))
    {
      Log.e(TAG, "no sdcard.");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 9L, 1L, false);
      AppMethodBeat.o(194747);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.yV(paramb.fileSize))
    {
      Log.e(TAG, "sdcard is full.");
      h.RTc.aV((Runnable)b.d.GwG);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 10L, 1L, false);
      AppMethodBeat.o(194747);
      return;
    }
    MMApplicationContext.getContext();
    com.tencent.mm.plugin.hp.d.d.dZA();
    com.tencent.mm.plugin.hp.d.d.dZB();
    g.a locala = new g.a();
    locala.alj(paramb.pkK);
    locala.all(paramb.cri);
    locala.setFileMD5(paramb.pkL);
    locala.kS(false);
    locala.kU(true);
    locala.cBH();
    locala.kT(false);
    locala.Fl(2);
    long l = f.cBv().a(locala.cBG());
    f.cBv();
    f.a((com.tencent.mm.plugin.downloader.model.m)new a(paramb, l));
    Log.i(TAG, "download start");
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 11L, 1L, false);
    AppMethodBeat.o(194747);
  }
  
  static void e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194748);
    fAL();
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 23L, 1L, false);
    h.RTc.aV((Runnable)new e(paramb));
    AppMethodBeat.o(194748);
  }
  
  private static boolean f(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194750);
    Log.i(TAG, "checkAndShowInstallBsPatchDialog");
    paramb = com.tencent.mm.plugin.hp.d.d.aBN(paramb.ynv);
    if ((s.YS(paramb)) && (com.tencent.mm.d.a.fP(paramb)))
    {
      Log.i(TAG, "checkAndShowInstallBsPatchDialog apk ready ".concat(String.valueOf(paramb)));
      r.b(MMApplicationContext.getContext(), paramb, null, false);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 5L, 1L, false);
      AppMethodBeat.o(194750);
      return true;
    }
    AppMethodBeat.o(194750);
    return false;
  }
  
  static void fAJ()
  {
    AppMethodBeat.i(194749);
    Log.i(TAG, "updateFailToast");
    h.RTc.aV((Runnable)f.GwI);
    AppMethodBeat.o(194749);
  }
  
  private static void fAK()
  {
    AppMethodBeat.i(194751);
    Object localObject = MMApplicationContext.getContext();
    final com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lk((Context)localObject);
    p.g(locala, "tinker");
    if (!locala.hpe())
    {
      Log.w(TAG, "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      AppMethodBeat.o(194751);
      return;
    }
    Log.i(TAG, "tinker wait screen to clean patch and kill all process");
    new com.tencent.mm.modelmulti.m((Context)localObject, (m.a)new c((Context)localObject, locala));
    localObject = new SharePatchInfo(locala.hpd().Ske, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
    SharePatchInfo.rewritePatchInfoFileWithLock(locala.hpf(), (SharePatchInfo)localObject, locala.hpg());
    AppMethodBeat.o(194751);
  }
  
  public static void fAL()
  {
    AppMethodBeat.i(194754);
    Object localObject = MMApplicationContext.getContext().getSystemService("notification");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(194754);
      throw ((Throwable)localObject);
    }
    ((NotificationManager)localObject).cancel(kYM);
    AppMethodBeat.o(194754);
  }
  
  private static void g(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194752);
    Log.i(TAG, "dealWithAlphaVersion " + paramb.clientVersion);
    Object localObject = MMApplicationContext.getContext();
    String str1;
    String str2;
    if (Util.isNullOrNil(paramb.ynx))
    {
      str1 = ((Context)localObject).getString(2131755960);
      if (!Util.isNullOrNil(paramb.yny)) {
        break label283;
      }
      str2 = "";
      label68:
      if (!Util.isNullOrNil(paramb.ynz)) {
        break label291;
      }
    }
    label283:
    label291:
    for (paramb = "http://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";; paramb = paramb.ynz)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
      localIntent.putExtra("rawUrl", paramb);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.setFlags(872415232);
      paramb = PendingIntent.getActivity((Context)localObject, 0, localIntent, 268435456);
      localObject = com.tencent.mm.bq.a.cd((Context)localObject, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)str1).g((CharSequence)str2).a(paramb);
      p.g(localObject, "NotificationHelper.getNo…tentIntent(pendingIntent)");
      ((s.c)localObject).as(com.tencent.mm.bq.a.ezb());
      p.g(str1, "title");
      p.g(str2, "text");
      a(str1, str2, paramb);
      AppMethodBeat.o(194752);
      return;
      str1 = paramb.ynx;
      break;
      str2 = paramb.yny;
      break label68;
    }
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(194755);
    String str = MMApplicationContext.getContext().getString(paramInt);
    p.g(str, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(194755);
    return str;
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194756);
    p.h(paramVarArgs, "args");
    paramVarArgs = MMApplicationContext.getContext().getString(paramInt, new Object[] { paramVarArgs });
    p.g(paramVarArgs, "MMApplicationContext.get…().getString(resId, args)");
    AppMethodBeat.o(194756);
    return paramVarArgs;
  }
  
  public final void a(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(194744);
    p.h(paramb, "response");
    if (!paramb.dZw())
    {
      Log.i(TAG, "check response error");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 0L, 1L, false);
      AppMethodBeat.o(194744);
      return;
    }
    if (paramb.dZx())
    {
      Log.i(TAG, "need to rollback");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 1L, 1L, false);
      fAK();
      AppMethodBeat.o(194744);
      return;
    }
    if (!paramb.dZt())
    {
      Log.i(TAG, "check not need to update");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 2L, 1L, false);
      AppMethodBeat.o(194744);
      return;
    }
    if (paramb.dZy())
    {
      Log.i(TAG, "lower client version");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 3L, 1L, false);
      AppMethodBeat.o(194744);
      return;
    }
    if (CrashReportFactory.isOnlinePatchBlocked())
    {
      Log.i(TAG, "patch downloading is blocked by assist.");
      AppMethodBeat.o(194744);
      return;
    }
    Integer localInteger = paramb.pkI;
    if (localInteger == null)
    {
      localInteger = paramb.pkI;
      if (localInteger != null) {
        break label235;
      }
    }
    label235:
    while (localInteger.intValue() != 2)
    {
      Log.i(TAG, "full apk not support, comming soon");
      AppMethodBeat.o(194744);
      return;
      if (localInteger.intValue() != 3) {
        break;
      }
      b(paramb);
      AppMethodBeat.o(194744);
      return;
    }
    c(paramb);
    AppMethodBeat.o(194744);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(194734);
      Object localObject3 = new File(this.GwC);
      Object localObject1 = com.tencent.mm.plugin.hp.d.d.aBN(this.GwD.ynv);
      Object localObject2 = com.tencent.mm.plugin.hp.d.d.gp(MMApplicationContext.getContext());
      localObject3 = ((File)localObject3).getAbsolutePath();
      long l = cl.aWA();
      int i = com.tencent.mm.plugin.hp.a.b.t((String)localObject2, (String)localObject3, (String)localObject1, this.GwD.ynv);
      localObject2 = b.GwB;
      Log.i(b.fAM(), "merge bs diff costTime:" + (cl.aWA() - l) + ' ' + (String)localObject3 + ' ' + (String)localObject1 + " retCode:" + i);
      SharePatchFileUtil.safeDeleteFile(new File((String)localObject3));
      if (i == 0)
      {
        localObject1 = b.GwB;
        if (!b.h(this.GwD))
        {
          localObject1 = b.GwB;
          b.fAN();
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 19L, 1L, false);
          AppMethodBeat.o(194734);
          return;
        }
        h.RTc.aV((Runnable)1.GwE);
        AppMethodBeat.o(194734);
        return;
      }
      localObject1 = b.GwB;
      b.fAN();
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 18L, 1L, false);
      AppMethodBeat.o(194734);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/tinker/lib/service/PatchResult;", "kotlin.jvm.PlatformType", "onPatchResult"})
  static final class b
    implements com.tinkerboots.sdk.tinker.a.a
  {
    b(com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void a(com.tencent.tinker.lib.service.a parama)
    {
      AppMethodBeat.i(194735);
      TinkerPatchResultService.a(null);
      b localb = b.GwB;
      Log.i(b.fAM(), "patchResult costTime: %s, path: %s, isSuccess: %b", new Object[] { Long.valueOf(parama.costTime), parama.SjJ, Boolean.valueOf(parama.isSuccess) });
      if (parama.isSuccess)
      {
        parama = b.GwB;
        b.i(this.GwD);
        AppMethodBeat.o(194735);
        return;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 24L, 1L, false);
      parama = b.GwB;
      b.fAN();
      AppMethodBeat.o(194735);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isOn", "", "onScreenStateChange"})
  static final class c
    implements m.a
  {
    c(Context paramContext, com.tencent.tinker.lib.e.a parama) {}
    
    public final void fH(boolean paramBoolean)
    {
      AppMethodBeat.i(194736);
      if (!paramBoolean)
      {
        Object localObject1 = b.GwB;
        Log.i(b.fAM(), "app is background now, i can kill quietly");
        ShareTinkerInternals.killAllOtherProcess(this.$context);
        locala.dZn();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      AppMethodBeat.o(194736);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(194741);
      Object localObject1 = new f.a(MMApplicationContext.getContext());
      Object localObject2 = b.GwB;
      localObject2 = Util.getSizeMB(this.GwD.fileSize);
      p.g(localObject2, "Util.getSizeMB(response.fileSize.toLong())");
      ((f.a)localObject1).bow(b.getString(2131766940, new Object[] { localObject2 }));
      ((f.a)localObject1).c((f.c)1.GwH);
      ((f.a)localObject1).Dq(true);
      ((f.a)localObject1).show();
      localObject1 = b.GwB;
      Log.i(b.fAM(), "hotPatchInstallSuccessDialog show");
      AppMethodBeat.o(194741);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f GwI;
    
    static
    {
      AppMethodBeat.i(194743);
      GwI = new f();
      AppMethodBeat.o(194743);
    }
    
    public final void run()
    {
      AppMethodBeat.i(194742);
      Object localObject = MMApplicationContext.getContext();
      b localb = b.GwB;
      Toast.makeText((Context)localObject, (CharSequence)b.getString(2131766942), 1).show();
      localObject = b.GwB;
      b.fAL();
      AppMethodBeat.o(194742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b
 * JD-Core Version:    0.7.0.1
 */