package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.h.a;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.repairer.ui.b.f;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newPath", "getNewPath", "setNewPath", "(Ljava/lang/String;)V", "oldAPKPath", "getOldAPKPath", "setOldAPKPath", "patchPath", "getPatchPath", "setPatchPath", "tmpPath", "getTmpPath", "setTmpPath", "updateDlg", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "checkTinkerBoostInstall", "", "dialogInfo", "Lcom/tencent/mm/protocal/protobuf/TinkerInstallDialog;", "getApkMd5", "file", "getCurrentApkMD5", "context", "Landroid/content/Context;", "getCurrentApkPath", "getLayoutId", "", "getShortIps", "", "()[Ljava/lang/String;", "goToUpdateWebView", "", "clientVersion", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "toastTip", "string", "Source", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerPatchDemoUI
  extends BaseRepairerUI
{
  private String Oxk = "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/Download/1/old.apk";
  private String Oxl = "/data/data/com.tencent.mm/MicroMsg/WebNetFile/12637862876476128361873";
  private String Oxm = "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/Download/hdiff/_tmp";
  private com.tencent.mm.ui.widget.a.e Oxn;
  private final String TAG = "MicroMsg.RepairerPatchDemoUI";
  private String paz = "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/Download/hdiff/newapkmd5.apk";
  
  private static final void a(RepairerPatchDemoUI paramRepairerPatchDemoUI)
  {
    AppMethodBeat.i(278390);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    fne localfne = com.tencent.mm.plugin.hp.b.d.fQq();
    if (localfne == null)
    {
      kotlin.g.b.s.u("更新数据为空，dialog = null", "string");
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"更新数据为空，dialog = null", 1).show();
      Log.i(paramRepairerPatchDemoUI.TAG, "have tinker update dialogInfo is null.");
      AppMethodBeat.o(278390);
      return;
    }
    if (com.tencent.mm.plugin.hp.b.d.fQr())
    {
      com.tencent.threadpool.h.ahAA.bm(new RepairerPatchDemoUI..ExternalSyntheticLambda15(localfne, paramRepairerPatchDemoUI));
      Log.i(paramRepairerPatchDemoUI.TAG, "have tinker update.");
      AppMethodBeat.o(278390);
      return;
    }
    Log.i(paramRepairerPatchDemoUI.TAG, kotlin.g.b.s.X("have tinker UpdateUtil.isNeedShowTinkerDialog() = ", Boolean.valueOf(com.tencent.mm.plugin.hp.b.d.fQr())));
    AppMethodBeat.o(278390);
  }
  
  private static final void a(RepairerPatchDemoUI paramRepairerPatchDemoUI, View paramView)
  {
    AppMethodBeat.i(278382);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPatchDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    Toast.makeText((Context)paramRepairerPatchDemoUI, (CharSequence)"触发自动更新的逻辑", 1).show();
    paramRepairerPatchDemoUI = new String[3];
    com.tencent.mm.plugin.hp.model.b.fPK();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278382);
  }
  
  private static final void a(RepairerPatchDemoUI paramRepairerPatchDemoUI, fne paramfne)
  {
    AppMethodBeat.i(278438);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    if (paramRepairerPatchDemoUI.Oxn != null)
    {
      com.tencent.mm.ui.widget.a.e locale = paramRepairerPatchDemoUI.Oxn;
      kotlin.g.b.s.checkNotNull(locale);
      if (locale.isShowing())
      {
        Log.i(paramRepairerPatchDemoUI.TAG, "update dialog is showing.");
        AppMethodBeat.o(278438);
        return;
      }
    }
    if (paramfne.hDq == 4)
    {
      com.tencent.mm.plugin.hp.a.c.t(121, -100, 0L);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 121L, 1L, false);
    }
    for (;;)
    {
      paramRepairerPatchDemoUI.Oxn = k.a((Context)paramRepairerPatchDemoUI.getContext(), paramfne.msg, paramfne.title, paramfne.abNm, paramfne.IVk, false, new RepairerPatchDemoUI..ExternalSyntheticLambda0(paramRepairerPatchDemoUI, paramfne), new RepairerPatchDemoUI..ExternalSyntheticLambda1(paramfne));
      com.tencent.mm.plugin.hp.b.d.fQs();
      AppMethodBeat.o(278438);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 60L, 1L, false);
    }
  }
  
  private static final void a(RepairerPatchDemoUI paramRepairerPatchDemoUI, fne paramfne, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(278423);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    v.b((Context)paramRepairerPatchDemoUI.getContext(), paramfne.abNl, null, false);
    if (paramfne.hDq != 4) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 50L, 1L, false);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(278423);
      return;
      com.tencent.mm.plugin.hp.a.c.t(123, -100, 0L);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 123L, 1L, false);
    }
  }
  
  private static final void a(RepairerPatchDemoUI paramRepairerPatchDemoUI, fne paramfne, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(278445);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    Log.i(paramRepairerPatchDemoUI.TAG, "onDialogClick %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      int i = paramfne.abNn;
      paramRepairerPatchDemoUI = MMApplicationContext.getContext().getString(b.f.updater_nv_url, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(i), Integer.valueOf(1) });
      kotlin.g.b.s.s(paramRepairerPatchDemoUI, "getContext().getString(R…uage(), clientVersion, 1)");
      paramfne = new Intent();
      paramfne.putExtra("rawUrl", paramRepairerPatchDemoUI);
      paramfne.putExtra("showShare", false);
      paramfne.putExtra("show_bottom", false);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramfne);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 28L, 1L, false);
    }
    AppMethodBeat.o(278445);
  }
  
  private static final void a(fne paramfne, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(278453);
    ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(paramfne.abNn);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 29L, 1L, false);
    AppMethodBeat.o(278453);
  }
  
  private static final void a(fne paramfne, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(278430);
    if (paramfne.hDq != 4) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 57L, 1L, false);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).openUpdater()) {
        ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(paramfne.abNn);
      }
      AppMethodBeat.o(278430);
      return;
      com.tencent.mm.plugin.hp.a.c.t(122, -100, 0L);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 122L, 1L, false);
    }
  }
  
  private static final void a(fne paramfne, RepairerPatchDemoUI paramRepairerPatchDemoUI)
  {
    AppMethodBeat.i(278484);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    String str;
    Object localObject;
    if (paramfne != null)
    {
      str = paramfne.JEM;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject, "getContext()");
      if (n.T(str, ju((Context)localObject), true)) {}
    }
    else
    {
      if ((paramfne == null) || (paramfne.hDq != 4)) {
        break label219;
      }
    }
    if (paramfne.hDq == 4)
    {
      str = paramRepairerPatchDemoUI.TAG;
      localObject = paramfne.JEM;
      Context localContext = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localContext, "getContext()");
      Log.i(str, "checkTinkerBoostInstall, oldApkMd5 is equal?: %s", new Object[] { Boolean.valueOf(n.T((String)localObject, ju(localContext), true)) });
    }
    if ((y.ZC(paramfne.abNl)) && (com.tencent.mm.d.a.hZ(paramfne.abNl)))
    {
      com.tencent.threadpool.h.ahAA.bk(new RepairerPatchDemoUI..ExternalSyntheticLambda14(paramRepairerPatchDemoUI, paramfne));
      AppMethodBeat.o(278484);
      return;
    }
    if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
    {
      com.tencent.threadpool.h.ahAA.bk(new RepairerPatchDemoUI..ExternalSyntheticLambda13(paramRepairerPatchDemoUI, paramfne));
      AppMethodBeat.o(278484);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new RepairerPatchDemoUI..ExternalSyntheticLambda12(paramRepairerPatchDemoUI, paramfne));
    label219:
    AppMethodBeat.o(278484);
  }
  
  private static final boolean a(RepairerPatchDemoUI paramRepairerPatchDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278344);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    paramRepairerPatchDemoUI.finish();
    AppMethodBeat.o(278344);
    return true;
  }
  
  private static final void b(RepairerPatchDemoUI paramRepairerPatchDemoUI, View paramView)
  {
    AppMethodBeat.i(278398);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPatchDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    Toast.makeText((Context)paramRepairerPatchDemoUI, (CharSequence)"触发手动安装弹窗", 1).show();
    MMHandlerThread.postToMainThreadDelayed(new RepairerPatchDemoUI..ExternalSyntheticLambda11(paramRepairerPatchDemoUI), 100L);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278398);
  }
  
  private static final void b(RepairerPatchDemoUI paramRepairerPatchDemoUI, fne paramfne)
  {
    AppMethodBeat.i(278463);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    if (paramRepairerPatchDemoUI.Oxn != null)
    {
      localObject = paramRepairerPatchDemoUI.Oxn;
      kotlin.g.b.s.checkNotNull(localObject);
      if (((com.tencent.mm.ui.widget.a.e)localObject).isShowing())
      {
        Log.i(paramRepairerPatchDemoUI.TAG, "update dialog is showing.");
        AppMethodBeat.o(278463);
        return;
      }
    }
    Log.i(paramRepairerPatchDemoUI.TAG, "show update dialog");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 27L, 1L, false);
    Object localObject = new g.a(MMApplicationContext.getContext());
    ((g.a)localObject).bDE(MMApplicationContext.getContext().getString(b.f.updater_tip));
    ((g.a)localObject).aEX(b.f.updater_confirm);
    ((g.a)localObject).NF(true);
    ((g.a)localObject).c(new RepairerPatchDemoUI..ExternalSyntheticLambda10(paramRepairerPatchDemoUI, paramfne));
    ((g.a)localObject).d(new RepairerPatchDemoUI..ExternalSyntheticLambda2(paramfne));
    ((g.a)localObject).show();
    paramRepairerPatchDemoUI.Oxn = ((g.a)localObject).pRv;
    com.tencent.mm.plugin.hp.b.d.fQs();
    AppMethodBeat.o(278463);
  }
  
  private static final void c(RepairerPatchDemoUI paramRepairerPatchDemoUI, View paramView)
  {
    AppMethodBeat.i(278407);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPatchDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    Toast.makeText((Context)paramRepairerPatchDemoUI, (CharSequence)"触发手动更新", 1).show();
    if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).openUpdater()) {
      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(2, (Context)paramRepairerPatchDemoUI);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278407);
  }
  
  private static final void c(RepairerPatchDemoUI paramRepairerPatchDemoUI, fne paramfne)
  {
    AppMethodBeat.i(278477);
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    Log.i(paramRepairerPatchDemoUI.TAG, "path:%s,apkMd5:%s", new Object[] { paramfne.abNl, paramfne.JEL });
    try
    {
      com.tencent.mm.network.e locale = com.tencent.mm.kernel.h.baD().mCm.oun.bGg();
      if (locale == null)
      {
        AppMethodBeat.o(278477);
        return;
      }
    }
    finally
    {
      Object localObject1;
      for (;;)
      {
        Log.printErrStackTrace(paramRepairerPatchDemoUI.TAG, localThrowable, "", new Object[0]);
        localObject1 = null;
      }
      Object localObject2 = paramfne.mOI;
      kotlin.g.b.s.s(localObject2, "dialogInfo.cdnUrl");
      Object localObject3 = paramfne.mOI;
      kotlin.g.b.s.s(localObject3, "dialogInfo.cdnUrl");
      localObject2 = ((String)localObject2).substring(0, n.b((CharSequence)localObject3, '/') + 1);
      kotlin.g.b.s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject3 = paramfne.mOI;
      kotlin.g.b.s.s(localObject3, "dialogInfo.cdnUrl");
      String str = paramfne.mOI;
      kotlin.g.b.s.s(str, "dialogInfo.cdnUrl");
      localObject3 = ((String)localObject3).substring(n.b((CharSequence)str, '/') + 1);
      kotlin.g.b.s.s(localObject3, "(this as java.lang.String).substring(startIndex)");
      localObject2 = new com.tencent.mm.d.h((String)localObject2, paramfne.versionCode);
      ((com.tencent.mm.d.h)localObject2).a(new h.a(paramfne.JEM, paramfne.JEL, paramfne.patchMd5, (String)localObject3, paramfne.tQE));
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("intent_short_ips", getShortIps());
      ((Intent)localObject3).putExtra("intent_client_version", com.tencent.mm.protocal.d.Yxh);
      ((Intent)localObject3).putExtra("intent_extra_session", localObject1.sA(1));
      ((Intent)localObject3).putExtra("intent_extra_cookie", localObject1.bFZ());
      ((Intent)localObject3).putExtra("intent_extra_ecdhkey", localObject1.bGb());
      ((Intent)localObject3).putExtra("intent_extra_uin", localObject1.getUin());
      ((Intent)localObject3).putExtra("intent_update_type", 3);
      ((Intent)localObject3).putExtra("intent_extra_desc", paramfne.msg);
      ((Intent)localObject3).putExtra("intent_extra_md5", paramfne.patchMd5);
      ((Intent)localObject3).putExtra("intent_extra_size", paramfne.tQE);
      ((Intent)localObject3).putExtra("intent_extra_download_url", new String[] { paramfne.mOI });
      ((Intent)localObject3).putExtra("intent_extra_patchInfo", ((com.tencent.mm.d.h)localObject2).aBN());
      ((Intent)localObject3).putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
      ((Intent)localObject3).putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
      ((Intent)localObject3).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
      ((Intent)localObject3).putExtra("intent_extra_tinker_patch", true);
      ((Intent)localObject3).putExtra("intent_extra_download_mode", 1);
      com.tencent.mm.plugin.y.d.gdL().aC((Context)paramRepairerPatchDemoUI.getContext(), (Intent)localObject3);
      com.tencent.mm.plugin.hp.b.d.fQs();
      AppMethodBeat.o(278477);
    }
  }
  
  private static final void d(RepairerPatchDemoUI paramRepairerPatchDemoUI, View paramView)
  {
    AppMethodBeat.i(278414);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPatchDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRepairerPatchDemoUI, "this$0");
    boolean bool1 = SharePatchFileUtil.deleteDir(new File(com.tencent.mm.plugin.hp.b.d.fQv()));
    boolean bool2 = SharePatchFileUtil.deleteDir(new File("/data/data/com.tencent.mm/MicroMsg/WebNetFile/"));
    paramView = (Context)paramRepairerPatchDemoUI;
    if ((bool1) && (bool2)) {}
    for (paramRepairerPatchDemoUI = "删除成功";; paramRepairerPatchDemoUI = "删除失败")
    {
      Toast.makeText(paramView, (CharSequence)paramRepairerPatchDemoUI, 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278414);
      return;
    }
  }
  
  private static final void eV(View paramView)
  {
    AppMethodBeat.i(278361);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.kernel.h.baH().postToWorker(RepairerPatchDemoUI..ExternalSyntheticLambda17.INSTANCE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278361);
  }
  
  private static final void gNm()
  {
    AppMethodBeat.i(278349);
    com.tencent.mm.plugin.hp.model.b.fPJ();
    AppMethodBeat.o(278349);
  }
  
  private static final void gNn()
  {
    AppMethodBeat.i(278369);
    com.tencent.mm.plugin.hp.model.b.aFf();
    AppMethodBeat.o(278369);
  }
  
  private static String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(278324);
    if ((z.pBU != null) && (z.pBU.length() > 0))
    {
      localObject = z.pBU;
      AppMethodBeat.o(278324);
      return new String[] { localObject };
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    String[] arrayOfString;
    int k;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = o.bsm((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      k = ((List)localObject).size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      arrayOfString[i] = ((o)((List)localObject).get(i)).KbS;
      if (j > k)
      {
        AppMethodBeat.o(278324);
        return arrayOfString;
        localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
        break;
      }
      i = j;
    }
  }
  
  private static String iH(Context paramContext)
  {
    AppMethodBeat.i(278339);
    kotlin.g.b.s.u(paramContext, "context");
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(278339);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private static final void iQ(View paramView)
  {
    AppMethodBeat.i(278376);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.kernel.h.baH().postToWorker(RepairerPatchDemoUI..ExternalSyntheticLambda16.INSTANCE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPatchDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278376);
  }
  
  private static String ju(Context paramContext)
  {
    AppMethodBeat.i(278333);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = iH(paramContext);
    if ((paramContext == null) || (!new u(paramContext).jKS()))
    {
      AppMethodBeat.o(278333);
      return null;
    }
    com.tencent.mm.d.a locala = com.tencent.mm.d.a.hY(paramContext);
    if ((locala != null) && (locala.hem != null))
    {
      paramContext = locala.hem.apkMd5;
      AppMethodBeat.o(278333);
      return paramContext;
    }
    paramContext = y.bub(paramContext);
    AppMethodBeat.o(278333);
    return paramContext;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278630);
    super.onCreate(paramBundle);
    setMMTitle("apk更新方式-(UnZip+Hdiff算法)Demo");
    setBackBtn(new RepairerPatchDemoUI..ExternalSyntheticLambda3(this));
    ((TextView)findViewById(b.c.Ouz)).setText((CharSequence)this.Oxk);
    ((TextView)findViewById(b.c.OuC)).setText((CharSequence)this.Oxl);
    ((TextView)findViewById(b.c.Ouy)).setText((CharSequence)this.paz);
    ((Button)findViewById(b.c.ok_btn)).setOnClickListener(RepairerPatchDemoUI..ExternalSyntheticLambda8.INSTANCE);
    ((Button)findViewById(b.c.OuD)).setOnClickListener(RepairerPatchDemoUI..ExternalSyntheticLambda9.INSTANCE);
    ((Button)findViewById(b.c.Otr)).setOnClickListener(new RepairerPatchDemoUI..ExternalSyntheticLambda7(this));
    ((Button)findViewById(b.c.Ots)).setOnClickListener(new RepairerPatchDemoUI..ExternalSyntheticLambda6(this));
    ((Button)findViewById(b.c.OtR)).setOnClickListener(new RepairerPatchDemoUI..ExternalSyntheticLambda4(this));
    ((Button)findViewById(b.c.clear_btn)).setOnClickListener(new RepairerPatchDemoUI..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(278630);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerPatchDemoUI
 * JD-Core Version:    0.7.0.1
 */