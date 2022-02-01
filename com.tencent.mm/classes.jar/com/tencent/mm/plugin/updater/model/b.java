package com.tencent.mm.plugin.updater.model;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.widget.Toast;
import androidx.core.app.e.d;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.plugin.updater.a.c;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/updater/model/ManualUpdaterProcessor;", "", "()V", "NOTIFICATION_ID", "", "TAG", "", "cancelNotification", "", "checkAndShowInstallBsPatchDialog", "", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "dealWithAlphaVersion", "getString", "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onDownloadFinish", "savePath", "patchRollBack", "prepareToDownload", "process", "processBsPatch", "processHotPatch", "showApplyPatchSuccessDialog", "showNotification", "title", "text", "pendingIntent", "Landroid/app/PendingIntent;", "updateFailToast", "plugin-updater_release"})
public final class b
{
  public static final b NjU;
  static final String TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
  private static final int nSX = 8341;
  
  static
  {
    AppMethodBeat.i(196148);
    NjU = new b();
    TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
    nSX = 8341;
    AppMethodBeat.o(196148);
  }
  
  public static void a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(196141);
    p.k(paramString1, "title");
    p.k(paramString2, "text");
    paramString1 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(null).W(true).e(System.currentTimeMillis()).k((CharSequence)paramString1).l((CharSequence)paramString2).a(paramPendingIntent).bn(com.tencent.mm.bx.a.fkG()).gr();
    paramString2 = MMApplicationContext.getContext().getSystemService("notification");
    if (paramString2 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(196141);
      throw paramString1;
    }
    ((NotificationManager)paramString2).notify(nSX, paramString1);
    AppMethodBeat.o(196141);
  }
  
  private static void b(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196125);
    Log.i(TAG, "handle bspatch");
    if (com.tencent.mm.plugin.hp.d.c.aLR(paramb.clientVersion))
    {
      Log.i(TAG, "handle alpha version " + paramb.clientVersion);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 4L, 1L, false);
      g(paramb);
      AppMethodBeat.o(196125);
      return;
    }
    if (!f(paramb))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 6L, 1L, false);
      d(paramb);
    }
    AppMethodBeat.o(196125);
  }
  
  private static void c(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196126);
    Log.i(TAG, "handle hotpatch");
    d(paramb);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 7L, 1L, false);
    AppMethodBeat.o(196126);
  }
  
  private static void d(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196127);
    Log.i(TAG, "prepare to download fileMd5:" + paramb.smU + " fileSize:" + paramb.fileSize + " cdnUrl:" + paramb.smT);
    if ((p.h(g.avJ(), "mounted") ^ true))
    {
      Log.e(TAG, "no sdcard.");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 9L, 1L, false);
      AppMethodBeat.o(196127);
      return;
    }
    if (!e.EY(paramb.fileSize))
    {
      Log.e(TAG, "sdcard is full.");
      h.ZvG.bc((Runnable)b.d.NjZ);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 10L, 1L, false);
      AppMethodBeat.o(196127);
      return;
    }
    MMApplicationContext.getContext();
    com.tencent.mm.plugin.hp.d.d.eIx();
    com.tencent.mm.plugin.hp.d.d.eIy();
    g.a locala = new g.a();
    locala.atc(paramb.smT);
    locala.ate(paramb.coY);
    locala.setFileMD5(paramb.smU);
    locala.me(false);
    locala.mg(true);
    locala.cQl();
    locala.mf(false);
    locala.IS(2);
    long l = com.tencent.mm.plugin.downloader.model.f.cPZ().a(locala.cQk());
    com.tencent.mm.plugin.downloader.model.f.cPZ();
    com.tencent.mm.plugin.downloader.model.f.a((com.tencent.mm.plugin.downloader.model.m)new a(paramb, l));
    Log.i(TAG, "download start");
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 11L, 1L, false);
    AppMethodBeat.o(196127);
  }
  
  static void e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196128);
    gsM();
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 23L, 1L, false);
    h.ZvG.bc((Runnable)new e(paramb));
    AppMethodBeat.o(196128);
  }
  
  private static boolean f(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196130);
    Log.i(TAG, "checkAndShowInstallBsPatchDialog");
    paramb = com.tencent.mm.plugin.hp.d.d.aLU(paramb.DNx);
    if ((u.agG(paramb)) && (com.tencent.mm.d.a.gz(paramb)))
    {
      Log.i(TAG, "checkAndShowInstallBsPatchDialog apk ready ".concat(String.valueOf(paramb)));
      r.b(MMApplicationContext.getContext(), paramb, null, false);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 5L, 1L, false);
      AppMethodBeat.o(196130);
      return true;
    }
    AppMethodBeat.o(196130);
    return false;
  }
  
  private static void g(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196138);
    Log.i(TAG, "dealWithAlphaVersion " + paramb.clientVersion);
    Object localObject = MMApplicationContext.getContext();
    String str1;
    String str2;
    if (Util.isNullOrNil(paramb.DNz))
    {
      str1 = ((Context)localObject).getString(com.tencent.mm.plugin.boots.b.a.app_recommend_update_alpha);
      if (!Util.isNullOrNil(paramb.DNA)) {
        break label283;
      }
      str2 = "";
      label68:
      if (!Util.isNullOrNil(paramb.DNB)) {
        break label291;
      }
    }
    label283:
    label291:
    for (paramb = "http://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";; paramb = paramb.DNB)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
      localIntent.putExtra("rawUrl", paramb);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.setFlags(872415232);
      paramb = PendingIntent.getActivity((Context)localObject, 0, localIntent, 268435456);
      localObject = com.tencent.mm.bx.a.cp((Context)localObject, "reminder_channel_id").n(null).e(System.currentTimeMillis()).k((CharSequence)str1).l((CharSequence)str2).a(paramb);
      p.j(localObject, "NotificationHelper.getNo…tentIntent(pendingIntent)");
      ((e.d)localObject).bn(com.tencent.mm.bx.a.fkG());
      p.j(str1, "title");
      p.j(str2, "text");
      a(str1, str2, paramb);
      AppMethodBeat.o(196138);
      return;
      str1 = paramb.DNz;
      break;
      str2 = paramb.DNA;
      break label68;
    }
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(196145);
    String str = MMApplicationContext.getContext().getString(paramInt);
    p.j(str, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(196145);
    return str;
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196147);
    p.k(paramVarArgs, "args");
    paramVarArgs = MMApplicationContext.getContext().getString(paramInt, new Object[] { paramVarArgs });
    p.j(paramVarArgs, "MMApplicationContext.get…().getString(resId, args)");
    AppMethodBeat.o(196147);
    return paramVarArgs;
  }
  
  static void gsK()
  {
    AppMethodBeat.i(196129);
    Log.i(TAG, "updateFailToast");
    h.ZvG.bc((Runnable)f.Nkb);
    AppMethodBeat.o(196129);
  }
  
  private static void gsL()
  {
    AppMethodBeat.i(196133);
    Object localObject = MMApplicationContext.getContext();
    final com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.mi((Context)localObject);
    p.j(locala, "tinker");
    if (!locala.isF())
    {
      Log.w(TAG, "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      AppMethodBeat.o(196133);
      return;
    }
    Log.i(TAG, "tinker wait screen to clean patch and kill all process");
    new com.tencent.mm.modelmulti.m((Context)localObject, (m.a)new c((Context)localObject, locala));
    localObject = new SharePatchInfo(locala.isE().ZMP, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
    SharePatchInfo.rewritePatchInfoFileWithLock(locala.isG(), (SharePatchInfo)localObject, locala.isH());
    AppMethodBeat.o(196133);
  }
  
  public static void gsM()
  {
    AppMethodBeat.i(196144);
    Object localObject = MMApplicationContext.getContext().getSystemService("notification");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(196144);
      throw ((Throwable)localObject);
    }
    ((NotificationManager)localObject).cancel(nSX);
    AppMethodBeat.o(196144);
  }
  
  public final void a(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(196119);
    p.k(paramb, "response");
    if (!paramb.eIt())
    {
      Log.i(TAG, "check response error");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 0L, 1L, false);
      AppMethodBeat.o(196119);
      return;
    }
    if (paramb.eIu())
    {
      Log.i(TAG, "need to rollback");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 1L, 1L, false);
      gsL();
      AppMethodBeat.o(196119);
      return;
    }
    if (!paramb.eIq())
    {
      Log.i(TAG, "check not need to update");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 2L, 1L, false);
      AppMethodBeat.o(196119);
      return;
    }
    if (paramb.eIv())
    {
      Log.i(TAG, "lower client version");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 3L, 1L, false);
      AppMethodBeat.o(196119);
      return;
    }
    if (CrashReportFactory.isOnlinePatchBlocked())
    {
      Log.i(TAG, "patch downloading is blocked by assist.");
      AppMethodBeat.o(196119);
      return;
    }
    Integer localInteger = paramb.smR;
    if (localInteger == null)
    {
      localInteger = paramb.smR;
      if (localInteger != null) {
        break label235;
      }
    }
    label235:
    while (localInteger.intValue() != 2)
    {
      Log.i(TAG, "full apk not support, comming soon");
      AppMethodBeat.o(196119);
      return;
      if (localInteger.intValue() != 3) {
        break;
      }
      b(paramb);
      AppMethodBeat.o(196119);
      return;
    }
    c(paramb);
    AppMethodBeat.o(196119);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(196002);
      Object localObject3 = new File(u.n(this.NjV, false));
      Object localObject1 = com.tencent.mm.plugin.hp.d.d.aLU(this.NjW.DNx);
      Object localObject2 = com.tencent.mm.plugin.hp.d.d.hm(MMApplicationContext.getContext());
      localObject3 = ((File)localObject3).getAbsolutePath();
      long l = cm.bfE();
      int i = com.tencent.mm.plugin.hp.a.b.y((String)localObject2, (String)localObject3, (String)localObject1, this.NjW.DNx);
      localObject2 = b.NjU;
      Log.i(b.gsN(), "merge bs diff costTime:" + (cm.bfE() - l) + ' ' + (String)localObject3 + ' ' + (String)localObject1 + " retCode:" + i);
      SharePatchFileUtil.safeDeleteFile(new File((String)localObject3));
      if (i == 0)
      {
        localObject1 = b.NjU;
        if (!b.h(this.NjW))
        {
          localObject1 = b.NjU;
          b.gsO();
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 19L, 1L, false);
          AppMethodBeat.o(196002);
          return;
        }
        h.ZvG.bc((Runnable)1.NjX);
        AppMethodBeat.o(196002);
        return;
      }
      localObject1 = b.NjU;
      b.gsO();
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 18L, 1L, false);
      AppMethodBeat.o(196002);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/tinker/lib/service/PatchResult;", "kotlin.jvm.PlatformType", "onPatchResult"})
  static final class b
    implements com.tinkerboots.sdk.tinker.a.a
  {
    b(com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void a(com.tencent.tinker.lib.service.a parama)
    {
      AppMethodBeat.i(196088);
      TinkerPatchResultService.a(null);
      b localb = b.NjU;
      Log.i(b.gsN(), "patchResult costTime: %s, path: %s, isSuccess: %b", new Object[] { Long.valueOf(parama.costTime), parama.ZMu, Boolean.valueOf(parama.isSuccess) });
      if (parama.isSuccess)
      {
        parama = b.NjU;
        b.i(this.NjW);
        AppMethodBeat.o(196088);
        return;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 24L, 1L, false);
      parama = b.NjU;
      b.gsO();
      AppMethodBeat.o(196088);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isOn", "", "onScreenStateChange"})
  static final class c
    implements m.a
  {
    c(Context paramContext, com.tencent.tinker.lib.e.a parama) {}
    
    public final void gt(boolean paramBoolean)
    {
      AppMethodBeat.i(196078);
      if (!paramBoolean)
      {
        Object localObject1 = b.NjU;
        Log.i(b.gsN(), "app is background now, i can kill quietly");
        ShareTinkerInternals.killAllOtherProcess(this.$context);
        locala.eIk();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      AppMethodBeat.o(196078);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(com.tencent.mm.plugin.hp.d.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(196023);
      Object localObject1 = new f.a(MMApplicationContext.getContext());
      Object localObject2 = b.NjU;
      int i = a.c.updater_hotpath_success;
      localObject2 = Util.getSizeMB(this.NjW.fileSize);
      p.j(localObject2, "Util.getSizeMB(response.fileSize.toLong())");
      ((f.a)localObject1).bBl(b.getString(i, new Object[] { localObject2 }));
      ((f.a)localObject1).c((f.c)1.Nka);
      ((f.a)localObject1).HL(true);
      ((f.a)localObject1).show();
      localObject1 = b.NjU;
      Log.i(b.gsN(), "hotPatchInstallSuccessDialog show");
      AppMethodBeat.o(196023);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f Nkb;
    
    static
    {
      AppMethodBeat.i(196060);
      Nkb = new f();
      AppMethodBeat.o(196060);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196059);
      Object localObject = MMApplicationContext.getContext();
      b localb = b.NjU;
      Toast.makeText((Context)localObject, (CharSequence)b.getString(a.c.updater_merge_fail), 1).show();
      localObject = b.NjU;
      b.gsM();
      AppMethodBeat.o(196059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b
 * JD-Core Version:    0.7.0.1
 */