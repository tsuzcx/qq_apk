package com.tencent.mm.plugin.updater.model;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.am;
import com.tencent.mm.app.am.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.plugin.boots.b.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.plugin.updater.a.c;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pluginsdk.platformtools.c.a;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/updater/model/ManualUpdaterProcessor;", "", "()V", "NOTIFICATION_ID", "", "TAG", "", "cancelNotification", "", "checkAndShowInstallPatchDialog", "", "newApkMd5", "dealWithAlphaVersion", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getString", "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onDownloadFinish", "savePath", "patchRollBack", "prepareToDownload", "process", "processBsAndHPatch", "processHotPatch", "showApplyPatchSuccessDialog", "showNotification", "title", "text", "pendingIntent", "Landroid/app/PendingIntent;", "updateFailToast", "plugin-updater_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b TWK;
  private static final int qSJ;
  
  static
  {
    AppMethodBeat.i(266178);
    TWK = new b();
    TAG = "MicroMsg.Updater.ManualUpdaterProcessor";
    qSJ = 8341;
    AppMethodBeat.o(266178);
  }
  
  private static final void a(Context paramContext, com.tencent.tinker.lib.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(266172);
    if (!paramBoolean)
    {
      Log.i(TAG, "app is background now, i can kill quietly");
      ShareTinkerInternals.killAllOtherProcess(paramContext);
      parama.fQd();
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      parama = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramContext.aYi(), "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor", "patchRollBack$lambda-10", "(Landroid/content/Context;Lcom/tencent/tinker/lib/tinker/Tinker;Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor", "patchRollBack$lambda-10", "(Landroid/content/Context;Lcom/tencent/tinker/lib/tinker/Tinker;Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    }
    AppMethodBeat.o(266172);
  }
  
  private static final void a(com.tencent.mm.plugin.hp.b.b paramb, com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(266138);
    s.u(paramb, "$response");
    TinkerPatchResultService.a(null);
    Log.i(TAG, "patchResult costTime: %s, path: %s, isSuccess: %b", new Object[] { Long.valueOf(parama.costTime), parama.ahRw, Boolean.valueOf(parama.isSuccess) });
    if (parama.isSuccess)
    {
      f(paramb);
      AppMethodBeat.o(266138);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 24L, 1L, false);
    hPW();
    AppMethodBeat.o(266138);
  }
  
  public static void a(com.tencent.mm.plugin.hp.b.b paramb, String paramString)
  {
    AppMethodBeat.i(266011);
    s.u(paramb, "response");
    s.u(paramString, "savePath");
    Log.i(TAG, s.X("onDownloadFinish savePath:", paramString));
    Object localObject = paramb.vyQ;
    if (localObject == null)
    {
      localObject = paramb.vyQ;
      if (localObject != null) {
        break label124;
      }
    }
    label124:
    while (((Integer)localObject).intValue() != 4)
    {
      localObject = paramb.vyQ;
      if (localObject != null) {
        break label175;
      }
      AppMethodBeat.o(266011);
      return;
      if (((Integer)localObject).intValue() != 3) {
        break;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 8L, 1L, false);
      com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda5(paramString, paramb), "Updater");
      AppMethodBeat.o(266011);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 8L, 1L, false);
    com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda4(paramb, paramString), "Updater");
    AppMethodBeat.o(266011);
    return;
    label175:
    if (((Integer)localObject).intValue() == 2)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 9L, 1L, false);
      paramString = new File(y.n(paramString, false));
      localObject = new ShareSecurityCheck(MMApplicationContext.getContext());
      try
      {
        bool = ((ShareSecurityCheck)localObject).verifyPatchMetaSignature(paramString);
        if (!bool) {
          break label520;
        }
        if (!am.a.hiV.aDh()) {
          break label487;
        }
        localObject = ((ShareSecurityCheck)localObject).getPackagePropertiesIfPresent();
        if (localObject != null)
        {
          localObject = (String)((HashMap)localObject).get("patch.client.ver");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = com.tencent.mm.plugin.hp.tinker.b.jF(com.tencent.mm.loader.i.a.CLIENT_VERSION, (String)localObject);
            ((com.tencent.mm.plugin.hp.tinker.b)localObject).fQa();
            ((com.tencent.mm.plugin.hp.tinker.b)localObject).fPZ();
          }
        }
        else
        {
          TinkerPatchResultService.a(new b..ExternalSyntheticLambda2(paramb));
          int i = com.tencent.tinker.lib.e.a.oy(MMApplicationContext.getContext()).ahRG.bGk(paramString.getAbsolutePath());
          Log.i(TAG, s.X("start to run patch. ret = ", Integer.valueOf(i)));
          switch (i)
          {
          default: 
            hPW();
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 21L, 1L, false);
            AppMethodBeat.o(266011);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "verifyPatchMetaSignature", new Object[0]);
          boolean bool = false;
          continue;
          Log.e(TAG, "Fail to get patch clientversion.");
        }
        f(paramb);
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 30L, 1L, false);
        AppMethodBeat.o(266011);
        return;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 22L, 1L, false);
      AppMethodBeat.o(266011);
      return;
      label487:
      hPW();
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 20L, 1L, false);
      Log.i(TAG, "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientversion to recover.");
      AppMethodBeat.o(266011);
      return;
      hPW();
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 17L, 1L, false);
      Log.i(TAG, "hot patch verfiy signature error");
    }
    label520:
    AppMethodBeat.o(266011);
  }
  
  private static final void a(String paramString, com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266099);
    s.u(paramString, "$savePath");
    s.u(paramb, "$response");
    Object localObject = new File(y.n(paramString, false));
    paramString = com.tencent.mm.plugin.hp.b.d.aIO(paramb.JEL);
    String str = com.tencent.mm.plugin.hp.b.d.iH(MMApplicationContext.getContext());
    localObject = ((File)localObject).getAbsolutePath();
    long l = cn.bDw();
    int i = com.tencent.mm.plugin.hp.a.b.B(str, (String)localObject, paramString, paramb.JEL);
    Log.i(TAG, "merge bs diff costTime:" + (cn.bDw() - l) + ' ' + localObject + ' ' + paramString + " retCode:" + i);
    SharePatchFileUtil.safeDeleteFile(new File((String)localObject));
    if (i == 0)
    {
      paramString = paramb.JEL;
      s.s(paramString, "response.newApkMd5");
      if (!beV(paramString))
      {
        hPW();
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 19L, 1L, false);
        AppMethodBeat.o(266099);
        return;
      }
      com.tencent.threadpool.h.ahAA.bk(b..ExternalSyntheticLambda9.INSTANCE);
      AppMethodBeat.o(266099);
      return;
    }
    hPW();
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 18L, 1L, false);
    AppMethodBeat.o(266099);
  }
  
  public static void a(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(266057);
    s.u(paramString1, "title");
    s.u(paramString2, "text");
    paramString1 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(null).aC(true).bt(System.currentTimeMillis()).l((CharSequence)paramString1).m((CharSequence)paramString2);
    paramString1.bor = paramPendingIntent;
    paramString1 = paramString1.eb(com.tencent.mm.bq.a.guX()).DA();
    s.s(paramString1, "getNotificationBuilder(M…ficationIconRs()).build()");
    paramString2 = MMApplicationContext.getContext().getSystemService("notification");
    if (paramString2 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(266057);
      throw paramString1;
    }
    ((NotificationManager)paramString2).notify(qSJ, paramString1);
    AppMethodBeat.o(266057);
  }
  
  private static final void aE(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(266146);
    Log.i(TAG, s.X("hotPatchInstallSuccessDialog click ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      paramString = com.tencent.mm.pluginsdk.platformtools.c.XUP;
      if (paramString != null) {
        paramString.cF(MMApplicationContext.getContext());
      }
    }
    AppMethodBeat.o(266146);
  }
  
  /* Error */
  private static final void b(com.tencent.mm.plugin.hp.b.b paramb, String paramString)
  {
    // Byte code:
    //   0: ldc_w 598
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 198
    //   9: invokestatic 204	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc_w 433
    //   16: invokestatic 204	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   22: ldc_w 600
    //   25: aload_0
    //   26: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 436	com/tencent/mm/plugin/hp/b/b:JEL	Ljava/lang/String;
    //   36: astore 9
    //   38: new 303	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: iconst_0
    //   44: invokestatic 309	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   47: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 10
    //   52: aload 9
    //   54: invokestatic 442	com/tencent/mm/plugin/hp/b/d:aIO	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 11
    //   59: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   62: invokestatic 446	com/tencent/mm/plugin/hp/b/d:iH	(Landroid/content/Context;)Ljava/lang/String;
    //   65: astore 8
    //   67: aload 10
    //   69: invokevirtual 393	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: astore 7
    //   74: aload 8
    //   76: astore 6
    //   78: invokestatic 605	com/tencent/mm/plugin/hp/a/a:fPF	()Z
    //   81: ifeq +18 -> 99
    //   84: aload 8
    //   86: astore 6
    //   88: invokestatic 610	com/tencent/mm/plugin/hp/a/c:fPG	()Z
    //   91: ifeq +8 -> 99
    //   94: ldc_w 612
    //   97: astore 6
    //   99: invokestatic 605	com/tencent/mm/plugin/hp/a/a:fPF	()Z
    //   102: ifeq +793 -> 895
    //   105: invokestatic 615	com/tencent/mm/plugin/hp/a/c:fPH	()Z
    //   108: ifeq +787 -> 895
    //   111: ldc_w 617
    //   114: astore 7
    //   116: invokestatic 620	com/tencent/mm/plugin/hp/b/d:fQv	()Ljava/lang/String;
    //   119: ldc_w 622
    //   122: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   125: astore 8
    //   127: aload 6
    //   129: aload 8
    //   131: invokestatic 626	com/tencent/mm/plugin/hp/a/c:jD	(Ljava/lang/String;Ljava/lang/String;)Z
    //   134: ifeq +563 -> 697
    //   137: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   140: ldc_w 628
    //   143: aload 8
    //   145: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   148: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 8
    //   153: astore 6
    //   155: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   158: new 460	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 630
    //   165: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 9
    //   170: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: ldc_w 632
    //   176: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 10
    //   181: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc_w 634
    //   187: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 10
    //   192: invokevirtual 637	java/io/File:length	()J
    //   195: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: ldc_w 639
    //   201: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_1
    //   205: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 634
    //   211: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: new 303	java/io/File
    //   217: dup
    //   218: aload_1
    //   219: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: invokevirtual 637	java/io/File:length	()J
    //   225: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 641
    //   231: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 7
    //   236: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: ldc_w 634
    //   242: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: new 303	java/io/File
    //   248: dup
    //   249: aload 7
    //   251: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   254: invokevirtual 637	java/io/File:length	()J
    //   257: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: ldc_w 643
    //   263: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 6
    //   268: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: ldc_w 634
    //   274: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: new 303	java/io/File
    //   280: dup
    //   281: aload 6
    //   283: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: invokevirtual 637	java/io/File:length	()J
    //   289: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: ldc_w 645
    //   295: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 8
    //   300: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 647
    //   306: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   312: invokestatic 446	com/tencent/mm/plugin/hp/b/d:iH	(Landroid/content/Context;)Ljava/lang/String;
    //   315: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload 10
    //   326: invokevirtual 393	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   329: invokestatic 650	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   332: ifeq +382 -> 714
    //   335: aload 10
    //   337: invokevirtual 637	java/io/File:length	()J
    //   340: lconst_0
    //   341: lcmp
    //   342: ifle +372 -> 714
    //   345: bipush 112
    //   347: bipush 156
    //   349: lconst_0
    //   350: invokestatic 654	com/tencent/mm/plugin/hp/a/c:t	(IIJ)V
    //   353: getstatic 660	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   356: ldc2_w 661
    //   359: ldc2_w 663
    //   362: lconst_1
    //   363: iconst_0
    //   364: invokevirtual 665	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   367: aload 11
    //   369: invokestatic 650	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   372: ifeq +42 -> 414
    //   375: new 303	java/io/File
    //   378: dup
    //   379: aload 11
    //   381: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: invokevirtual 637	java/io/File:length	()J
    //   387: lconst_0
    //   388: lcmp
    //   389: ifne +25 -> 414
    //   392: new 303	java/io/File
    //   395: dup
    //   396: aload 11
    //   398: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   401: invokestatic 489	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   404: pop
    //   405: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   408: ldc_w 667
    //   411: invokestatic 670	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: invokestatic 452	com/tencent/mm/model/cn:bDw	()J
    //   417: lstore_3
    //   418: aload 6
    //   420: aload 7
    //   422: aload 11
    //   424: aload_0
    //   425: invokestatic 673	com/tencent/mm/plugin/hp/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/hp/b/b;)I
    //   428: istore_2
    //   429: invokestatic 452	com/tencent/mm/model/cn:bDw	()J
    //   432: lload_3
    //   433: lsub
    //   434: ldc2_w 674
    //   437: ldiv
    //   438: lstore_3
    //   439: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   442: new 460	java/lang/StringBuilder
    //   445: dup
    //   446: ldc_w 677
    //   449: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: lload_3
    //   453: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: bipush 32
    //   458: invokevirtual 470	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   461: aload 7
    //   463: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   466: bipush 32
    //   468: invokevirtual 470	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   471: aload 11
    //   473: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   476: ldc_w 475
    //   479: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: iload_2
    //   483: invokevirtual 481	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   486: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: iload_2
    //   493: ifne +279 -> 772
    //   496: bipush 106
    //   498: iload_2
    //   499: lload_3
    //   500: invokestatic 654	com/tencent/mm/plugin/hp/a/c:t	(IIJ)V
    //   503: getstatic 660	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   506: ldc2_w 661
    //   509: ldc2_w 678
    //   512: lconst_1
    //   513: iconst_0
    //   514: invokevirtual 665	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   517: iload_2
    //   518: ifne +58 -> 576
    //   521: aload_0
    //   522: aload 9
    //   524: putfield 682	com/tencent/mm/plugin/hp/b/b:JEM	Ljava/lang/String;
    //   527: aload 6
    //   529: invokestatic 685	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   532: astore_1
    //   533: aload_1
    //   534: ldc_w 687
    //   537: invokestatic 494	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   540: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   543: new 460	java/lang/StringBuilder
    //   546: dup
    //   547: ldc_w 689
    //   550: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   553: aload_1
    //   554: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 691
    //   560: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_0
    //   564: getfield 682	com/tencent/mm/plugin/hp/b/b:JEM	Ljava/lang/String;
    //   567: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload 8
    //   578: aload 6
    //   580: invokevirtual 695	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   583: ifeq +27 -> 610
    //   586: aload 8
    //   588: invokestatic 698	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   591: istore 5
    //   593: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   596: ldc_w 700
    //   599: iload 5
    //   601: invokestatic 235	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   604: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   607: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: new 303	java/io/File
    //   613: dup
    //   614: aload 7
    //   616: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   619: invokestatic 489	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   622: istore 5
    //   624: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   627: ldc_w 702
    //   630: iload 5
    //   632: invokestatic 235	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   635: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   638: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: iload_2
    //   642: ifne +233 -> 875
    //   645: aload 9
    //   647: ldc_w 703
    //   650: invokestatic 494	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   653: aload 9
    //   655: invokestatic 498	com/tencent/mm/plugin/updater/model/b:beV	(Ljava/lang/String;)Z
    //   658: ifne +180 -> 838
    //   661: invokestatic 258	com/tencent/mm/plugin/updater/model/b:hPW	()V
    //   664: getstatic 247	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   667: ldc2_w 248
    //   670: ldc2_w 499
    //   673: lconst_1
    //   674: iconst_0
    //   675: invokevirtual 255	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   678: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   681: ldc_w 705
    //   684: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: invokestatic 708	com/tencent/mm/plugin/hp/b/d:fQA	()V
    //   690: ldc_w 598
    //   693: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   696: return
    //   697: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   700: ldc_w 710
    //   703: aload 6
    //   705: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   708: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: goto -556 -> 155
    //   714: bipush 113
    //   716: bipush 156
    //   718: lconst_0
    //   719: invokestatic 654	com/tencent/mm/plugin/hp/a/c:t	(IIJ)V
    //   722: getstatic 660	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   725: ldc2_w 661
    //   728: ldc2_w 711
    //   731: lconst_1
    //   732: iconst_0
    //   733: invokevirtual 665	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   736: goto -369 -> 367
    //   739: astore_0
    //   740: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   743: ldc_w 714
    //   746: aload_0
    //   747: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   750: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   753: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   756: ldc_w 705
    //   759: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: invokestatic 708	com/tencent/mm/plugin/hp/b/d:fQA	()V
    //   765: ldc_w 598
    //   768: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   771: return
    //   772: getstatic 660	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   775: ldc2_w 661
    //   778: ldc2_w 715
    //   781: lconst_1
    //   782: iconst_0
    //   783: invokevirtual 665	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   786: bipush 105
    //   788: iload_2
    //   789: lload_3
    //   790: invokestatic 654	com/tencent/mm/plugin/hp/a/c:t	(IIJ)V
    //   793: goto -276 -> 517
    //   796: astore_0
    //   797: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   800: ldc_w 705
    //   803: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: invokestatic 708	com/tencent/mm/plugin/hp/b/d:fQA	()V
    //   809: ldc_w 598
    //   812: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   815: aload_0
    //   816: athrow
    //   817: astore_1
    //   818: getstatic 124	com/tencent/mm/plugin/updater/model/b:TAG	Ljava/lang/String;
    //   821: ldc_w 718
    //   824: aload_1
    //   825: invokestatic 269	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   828: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: ldc_w 719
    //   834: astore_1
    //   835: goto -295 -> 540
    //   838: bipush 114
    //   840: bipush 156
    //   842: lconst_0
    //   843: invokestatic 654	com/tencent/mm/plugin/hp/a/c:t	(IIJ)V
    //   846: getstatic 660	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   849: ldc2_w 661
    //   852: ldc2_w 720
    //   855: lconst_1
    //   856: iconst_0
    //   857: invokevirtual 665	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   860: getstatic 283	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   863: getstatic 726	com/tencent/mm/plugin/updater/model/b$$ExternalSyntheticLambda6:INSTANCE	Lcom/tencent/mm/plugin/updater/model/b$$ExternalSyntheticLambda6;
    //   866: invokeinterface 510 2 0
    //   871: pop
    //   872: goto -194 -> 678
    //   875: invokestatic 258	com/tencent/mm/plugin/updater/model/b:hPW	()V
    //   878: getstatic 247	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   881: ldc2_w 248
    //   884: ldc2_w 511
    //   887: lconst_1
    //   888: iconst_0
    //   889: invokevirtual 255	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   892: goto -214 -> 678
    //   895: goto -779 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	898	0	paramb	com.tencent.mm.plugin.hp.b.b
    //   0	898	1	paramString	String
    //   428	361	2	i	int
    //   417	373	3	l	long
    //   591	40	5	bool	boolean
    //   76	628	6	str1	String
    //   72	543	7	str2	String
    //   65	522	8	str3	String
    //   36	618	9	str4	String
    //   50	286	10	localFile	File
    //   57	415	11	str5	String
    // Exception table:
    //   from	to	target	type
    //   19	74	739	java/lang/Exception
    //   78	84	739	java/lang/Exception
    //   88	94	739	java/lang/Exception
    //   99	111	739	java/lang/Exception
    //   116	151	739	java/lang/Exception
    //   155	367	739	java/lang/Exception
    //   367	414	739	java/lang/Exception
    //   414	492	739	java/lang/Exception
    //   496	517	739	java/lang/Exception
    //   521	527	739	java/lang/Exception
    //   540	576	739	java/lang/Exception
    //   576	610	739	java/lang/Exception
    //   610	641	739	java/lang/Exception
    //   645	678	739	java/lang/Exception
    //   697	711	739	java/lang/Exception
    //   714	736	739	java/lang/Exception
    //   772	793	739	java/lang/Exception
    //   818	831	739	java/lang/Exception
    //   838	872	739	java/lang/Exception
    //   875	892	739	java/lang/Exception
    //   19	74	796	finally
    //   78	84	796	finally
    //   88	94	796	finally
    //   99	111	796	finally
    //   116	151	796	finally
    //   155	367	796	finally
    //   367	414	796	finally
    //   414	492	796	finally
    //   496	517	796	finally
    //   521	527	796	finally
    //   527	540	796	finally
    //   540	576	796	finally
    //   576	610	796	finally
    //   610	641	796	finally
    //   645	678	796	finally
    //   697	711	796	finally
    //   714	736	796	finally
    //   740	753	796	finally
    //   772	793	796	finally
    //   818	831	796	finally
    //   838	872	796	finally
    //   875	892	796	finally
    //   527	540	817	java/lang/Exception
  }
  
  private static boolean beV(String paramString)
  {
    AppMethodBeat.i(266028);
    Log.i(TAG, s.X("HdiffApk checkAndShowInstallPatchDialog, newApkMd5 = ", paramString));
    paramString = com.tencent.mm.plugin.hp.b.d.aIO(paramString);
    if ((y.ZC(paramString)) && (com.tencent.mm.d.a.hZ(paramString)))
    {
      Log.i(TAG, s.X("checkAndShowInstallPatchDialog apk ready ", paramString));
      v.b(MMApplicationContext.getContext(), paramString, null, false);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 5L, 1L, false);
      AppMethodBeat.o(266028);
      return true;
    }
    AppMethodBeat.o(266028);
    return false;
  }
  
  private static void c(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(265982);
    Log.i(TAG, "processBsAndHPatch");
    Object localObject = paramb.vyQ;
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(TAG, "HdiffApk, manual,handle alpha version " + paramb.clientVersion + ", isHdiffDisableAlphaSwitch = " + bool);
      if ((!com.tencent.mm.plugin.hp.b.c.aIL(paramb.clientVersion)) || (!bool)) {
        break label120;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 4L, 1L, false);
      g(paramb);
      AppMethodBeat.o(265982);
      return;
      if ((((Integer)localObject).intValue() != 4) || (com.tencent.mm.plugin.hp.a.c.fPI())) {
        break;
      }
    }
    label120:
    localObject = paramb.JEL;
    s.s(localObject, "response.newApkMd5");
    if (!beV((String)localObject))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 6L, 1L, false);
      e(paramb);
      paramb = paramb.vyQ;
      if (paramb == null)
      {
        AppMethodBeat.o(265982);
        return;
      }
      if (paramb.intValue() == 4)
      {
        com.tencent.mm.plugin.hp.a.c.t(111, -100, 0L);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 111L, 1L, false);
      }
    }
    AppMethodBeat.o(265982);
  }
  
  private static void d(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(265989);
    Log.i(TAG, "handle hotpatch");
    e(paramb);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 7L, 1L, false);
    AppMethodBeat.o(265989);
  }
  
  private static void e(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266002);
    Log.i(TAG, "prepare to download fileMd5:" + paramb.vyS + " fileSize:" + paramb.fileSize + " cdnUrl:" + paramb.mOI);
    if (!s.p(g.aQd(), "mounted"))
    {
      Log.e(TAG, "no sdcard.");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 9L, 1L, false);
      AppMethodBeat.o(266002);
      return;
    }
    if (!e.hq(paramb.fileSize))
    {
      Log.e(TAG, "sdcard is full.");
      com.tencent.threadpool.h.ahAA.bk(b..ExternalSyntheticLambda8.INSTANCE);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 10L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 55L, 1L, false);
      AppMethodBeat.o(266002);
      return;
    }
    MMApplicationContext.getContext();
    com.tencent.mm.plugin.hp.b.d.fQt();
    com.tencent.mm.plugin.hp.b.d.fQu();
    Object localObject = new com.tencent.mm.plugin.downloader.model.g.a();
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).amR(paramb.mOI);
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).amT(paramb.egJ);
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).setFileMD5(paramb.vyS);
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).nA(false);
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).nC(true);
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).duF();
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).nB(false);
    ((com.tencent.mm.plugin.downloader.model.g.a)localObject).JA(2);
    long l = com.tencent.mm.plugin.downloader.model.f.duv().a(((com.tencent.mm.plugin.downloader.model.g.a)localObject).xoe);
    com.tencent.mm.plugin.downloader.model.f.duv();
    com.tencent.mm.plugin.downloader.model.c.a((m)new a(paramb, l));
    Log.i(TAG, "download start");
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 11L, 1L, false);
    localObject = paramb.vyQ;
    if (localObject == null)
    {
      AppMethodBeat.o(266002);
      return;
    }
    if (((Integer)localObject).intValue() == 4)
    {
      localObject = new czn();
      ((czn)localObject).aaEU = String.valueOf(l);
      ((czn)localObject).mOI = paramb.mOI;
      ((czn)localObject).startTime = System.currentTimeMillis();
      ((czn)localObject).vXL = "2";
      com.tencent.mm.plugin.hp.b.d.a((czn)localObject);
    }
    AppMethodBeat.o(266002);
  }
  
  private static void f(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266017);
    hPY();
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 23L, 1L, false);
    com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda3(paramb));
    AppMethodBeat.o(266017);
  }
  
  private static void g(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266050);
    Log.i(TAG, s.X("dealWithAlphaVersion ", paramb.clientVersion));
    Object localObject = MMApplicationContext.getContext();
    String str1;
    String str2;
    if (Util.isNullOrNil(paramb.JEN))
    {
      str1 = ((Context)localObject).getString(b.a.app_recommend_update_alpha);
      if (!Util.isNullOrNil(paramb.JEO)) {
        break label264;
      }
      str2 = "";
      label58:
      if (!Util.isNullOrNil(paramb.JEP)) {
        break label272;
      }
    }
    label264:
    label272:
    for (paramb = "http://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";; paramb = paramb.JEP)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setClassName(MMApplicationContext.getPackageName(), s.X(MMApplicationContext.getSourcePackageName(), ".plugin.webview.ui.tools.WebViewUI"));
      localIntent.putExtra("rawUrl", paramb);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.setFlags(872415232);
      paramb = PendingIntent.getActivity((Context)localObject, 0, localIntent, 268435456);
      localObject = com.tencent.mm.bq.a.cA((Context)localObject, "reminder_channel_id").o(null).bt(System.currentTimeMillis()).l((CharSequence)str1).m((CharSequence)str2);
      ((f.d)localObject).bor = paramb;
      s.s(localObject, "getNotificationBuilder(c…tentIntent(pendingIntent)");
      ((f.d)localObject).eb(com.tencent.mm.bq.a.guX());
      s.s(str1, "title");
      s.s(str2, "text");
      a(str1, str2, paramb);
      AppMethodBeat.o(266050);
      return;
      str1 = paramb.JEN;
      break;
      str2 = paramb.JEO;
      break label58;
    }
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(266065);
    String str = MMApplicationContext.getContext().getString(paramInt);
    s.s(str, "getContext().getString(resId)");
    AppMethodBeat.o(266065);
    return str;
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(266077);
    s.u(paramVarArgs, "args");
    paramVarArgs = MMApplicationContext.getContext().getString(paramInt, new Object[] { paramVarArgs });
    s.s(paramVarArgs, "getContext().getString(resId, args)");
    AppMethodBeat.o(266077);
    return paramVarArgs;
  }
  
  private static final void h(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266159);
    s.u(paramb, "$response");
    com.tencent.mm.ui.widget.a.g.a locala = new com.tencent.mm.ui.widget.a.g.a(MMApplicationContext.getContext());
    int i = a.c.updater_hotpath_success;
    paramb = Util.getSizeMB(paramb.fileSize);
    s.s(paramb, "getSizeMB(response.fileSize.toLong())");
    locala.bDE(getString(i, new Object[] { paramb }));
    locala.c(b..ExternalSyntheticLambda1.INSTANCE);
    locala.NF(true);
    locala.show();
    Log.i(TAG, "hotPatchInstallSuccessDialog show");
    AppMethodBeat.o(266159);
  }
  
  private static void hPW()
  {
    AppMethodBeat.i(266023);
    Log.i(TAG, "updateFailToast");
    com.tencent.threadpool.h.ahAA.bk(b..ExternalSyntheticLambda7.INSTANCE);
    AppMethodBeat.o(266023);
  }
  
  private static void hPX()
  {
    AppMethodBeat.i(266037);
    Object localObject = MMApplicationContext.getContext();
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.oy((Context)localObject);
    if (!locala.ahRN)
    {
      Log.w(TAG, "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      AppMethodBeat.o(266037);
      return;
    }
    Log.i(TAG, "tinker wait screen to clean patch and kill all process");
    new r((Context)localObject, new b..ExternalSyntheticLambda0((Context)localObject, locala));
    localObject = new SharePatchInfo(locala.ahRM.ahRR, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
    SharePatchInfo.rewritePatchInfoFileWithLock(locala.ahRJ, (SharePatchInfo)localObject, locala.ahRK);
    AppMethodBeat.o(266037);
  }
  
  public static void hPY()
  {
    AppMethodBeat.i(266062);
    Object localObject = MMApplicationContext.getContext().getSystemService("notification");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
      AppMethodBeat.o(266062);
      throw ((Throwable)localObject);
    }
    ((NotificationManager)localObject).cancel(qSJ);
    AppMethodBeat.o(266062);
  }
  
  private static final void hPZ()
  {
    AppMethodBeat.i(266083);
    Toast.makeText(MMApplicationContext.getContext(), a.c.sdcard_full_title, 0).show();
    AppMethodBeat.o(266083);
  }
  
  private static final void hQa()
  {
    AppMethodBeat.i(266089);
    hPY();
    AppMethodBeat.o(266089);
  }
  
  private static final void hQb()
  {
    AppMethodBeat.i(266106);
    hPY();
    AppMethodBeat.o(266106);
  }
  
  private static final void hQc()
  {
    AppMethodBeat.i(266165);
    Toast.makeText(MMApplicationContext.getContext(), (CharSequence)getString(a.c.updater_merge_fail), 1).show();
    hPY();
    AppMethodBeat.o(266165);
  }
  
  public final void b(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(266225);
    s.u(paramb, "response");
    if (!paramb.fQm())
    {
      Log.i(TAG, "check response error");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 0L, 1L, false);
      AppMethodBeat.o(266225);
      return;
    }
    if (paramb.fQn())
    {
      Log.i(TAG, "need to rollback");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 1L, 1L, false);
      hPX();
      AppMethodBeat.o(266225);
      return;
    }
    if (!paramb.fQj())
    {
      Log.i(TAG, "check not need to update");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 2L, 1L, false);
      AppMethodBeat.o(266225);
      return;
    }
    if (paramb.fQo())
    {
      Log.i(TAG, "lower client version");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 3L, 1L, false);
      AppMethodBeat.o(266225);
      return;
    }
    if (CrashReportFactory.isOnlinePatchBlocked())
    {
      Log.i(TAG, "patch downloading is blocked by assist.");
      AppMethodBeat.o(266225);
      return;
    }
    Integer localInteger = paramb.vyQ;
    if (localInteger == null)
    {
      localInteger = paramb.vyQ;
      if (localInteger != null) {
        break label244;
      }
      localInteger = paramb.vyQ;
      if (localInteger != null) {
        break label255;
      }
    }
    label244:
    label255:
    while (localInteger.intValue() != 2)
    {
      Log.i(TAG, "full apk not support, comming soon");
      AppMethodBeat.o(266225);
      return;
      if (localInteger.intValue() != 3) {
        break;
      }
      for (;;)
      {
        c(paramb);
        AppMethodBeat.o(266225);
        return;
        if (localInteger.intValue() != 4) {
          break;
        }
      }
    }
    d(paramb);
    AppMethodBeat.o(266225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b
 * JD-Core Version:    0.7.0.1
 */