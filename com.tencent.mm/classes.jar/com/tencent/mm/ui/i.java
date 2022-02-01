package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.d;
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.x;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;

public final class i
{
  private static final String fgQ;
  
  static
  {
    AppMethodBeat.i(243255);
    fgQ = "https://" + WeChatHosts.domainString(R.l.host_work_weixin_qq_com) + "/wework_admin/commdownload?from=conv%s";
    AppMethodBeat.o(243255);
  }
  
  private static int aR(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33029);
    com.tencent.mm.api.c localc = af.bjv().Uo(paramString);
    if (localc.YY()) {
      paramString = localc.Zf();
    }
    paramString = af.bjF().Uj(paramString);
    int i;
    int j;
    label55:
    long l1;
    if (paramString != null)
    {
      i = paramString.field_qyUin;
      if (paramString == null) {
        break label203;
      }
      j = paramString.field_userUin;
      if (paramString == null) {
        break label209;
      }
      l1 = paramString.field_wwCorpId;
      label65:
      if (paramString == null) {
        break label215;
      }
    }
    label203:
    label209:
    label215:
    for (long l2 = paramString.field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      Log.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(33029);
      return paramInt2;
      i = 0;
      break;
      j = 0;
      break label55;
      l1 = 0L;
      break label65;
    }
  }
  
  public static void aS(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33031);
    Object localObject = af.bjv().Uo(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 4) {
        i = 3;
      }
      if (((com.tencent.mm.api.c)localObject).YY()) {
        paramString = ((com.tencent.mm.api.c)localObject).Zf();
      }
      paramString = af.bjF().Uj(paramString);
      localObject = new x(paramString, paramInt1, i, new Object());
      com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
      if (paramString.field_chatOpen)
      {
        paramInt2 = 1;
        if (!paramString.field_show_confirm) {
          break label199;
        }
      }
      label199:
      for (int j = 1;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(paramInt2), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(i) });
        AppMethodBeat.o(33031);
        return;
        paramInt2 = 0;
        break;
      }
    }
  }
  
  public static int cI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33024);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33024);
      return 0;
    }
    paramString = af.bjF().Uj(paramString);
    int i;
    if ((paramString != null) && ((paramString.field_userFlag & 0x2) != 0)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramString.field_wwExposeTimes < paramString.field_wwMaxExposeTimes) || (com.tencent.mm.pluginsdk.model.app.q.u(paramContext, "com.tencent.wework")))
      {
        AppMethodBeat.o(33024);
        return 2;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(33024);
        return 1;
      }
    }
    AppMethodBeat.o(33024);
    return 0;
  }
  
  public static void cJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33025);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33025);
      return;
    }
    if (!com.tencent.mm.pluginsdk.model.app.q.u(paramContext, "com.tencent.wework")) {
      af.bjF().Um(paramString);
    }
    AppMethodBeat.o(33025);
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33026);
    if (com.tencent.mm.pluginsdk.model.app.q.u(paramContext, "com.tencent.wework"))
    {
      aR(paramString, 4, paramInt);
      AppMethodBeat.o(33026);
      return;
    }
    aR(paramString, 5, paramInt);
    AppMethodBeat.o(33026);
  }
  
  public static void u(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(33027);
    aR(paramString, 1, paramInt);
    aS(paramString, 2, paramInt);
    d locald = af.bjF().Uk(paramString);
    Object localObject = null;
    String str;
    if ((4 == paramInt) || (3 == paramInt))
    {
      af.bjF();
      str = e.biQ();
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.length() > 0)
        {
          localObject = str;
          if (str.toLowerCase().startsWith("http"))
          {
            paramString = new Intent();
            paramString.putExtra("rawUrl", str);
            com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
            AppMethodBeat.o(33027);
            return;
          }
        }
      }
    }
    if (com.tencent.mm.pluginsdk.model.app.q.u(paramContext, "com.tencent.wework"))
    {
      aR(paramString, 2, paramInt);
      paramString = b.getPackageInfo(paramContext, "com.tencent.wework");
      if ((!Util.isNullOrNil(paramString.versionName)) && (paramString.versionName.compareTo("1.3.3") >= 0))
      {
        paramString = new Intent();
        paramString.setAction("android.intent.action.VIEW");
        if (((paramInt == 4) || (3 == paramInt)) && (localObject != null) && (((String)localObject).length() > 0)) {
          paramString.setData(Uri.parse((String)localObject));
        }
      }
      for (;;)
      {
        com.tencent.mm.co.a.post(new i.4(paramContext, paramString));
        AppMethodBeat.o(33027);
        return;
        if ((paramInt == 2) || (paramInt == 4) || (paramInt == 6)) {}
        for (localObject = "wxwork://createconversation";; localObject = "wxwork://conversationlist")
        {
          paramString.setData(Uri.parse((String)localObject));
          break;
        }
        paramString = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
      }
    }
    if (locald.field_use_preset_banner_tips)
    {
      com.tencent.mm.ui.base.h.a(paramContext, R.l.eCB, 0, R.l.eCA, R.l.app_cancel, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33021);
          i.v(this.val$context, paramString, paramInt);
          AppMethodBeat.o(33021);
        }
      }, null);
      AppMethodBeat.o(33027);
      return;
    }
    if (locald.field_show_confirm)
    {
      localObject = new f.a(paramContext);
      ((f.a)localObject).bBq(paramContext.getString(R.l.app_cancel));
      ((f.a)localObject).ayp(R.l.eCA);
      af.bjF();
      af.bjF();
      str = e.vJ(1);
      if (str == null) {
        ((f.a)localObject).bBl(paramContext.getString(R.l.eCB));
      }
      for (;;)
      {
        ((f.a)localObject).a(new f.c()new f.c
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        }, new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(33022);
            i.v(this.val$context, paramString, paramInt);
            AppMethodBeat.o(33022);
          }
        }).show();
        AppMethodBeat.o(33027);
        return;
        ((f.a)localObject).bBl(str);
      }
    }
    v(paramContext, paramString, paramInt);
    AppMethodBeat.o(33027);
  }
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33028);
    aR(paramString, 3, paramInt);
    aS(paramString, 3, paramInt);
    af.bjv();
    paramString = com.tencent.mm.ao.f.Ut(paramString);
    Object localObject = fgQ;
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format((String)localObject, new Object[] { paramString });
      localObject = com.tencent.mm.plugin.downloader.model.f.cPZ().ata(paramString);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3) && (u.agG(((FileDownloadTaskInfo)localObject).path))) {
        u.deleteFile(((FileDownloadTaskInfo)localObject).path);
      }
      w.makeText(paramContext, paramContext.getString(R.l.eCC), 2000).show();
      localObject = new Intent();
      ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
      ((Intent)localObject).putExtra("task_name", paramContext.getString(R.l.eCy));
      ((Intent)localObject).putExtra("title", paramContext.getString(R.l.eCy));
      ((Intent)localObject).putExtra("task_url", paramString);
      ((Intent)localObject).putExtra("fileType", 1);
      ((Intent)localObject).putExtra("package_name", "com.tencent.wework");
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/ui/EnterpriseHelper", "goToWwDownload", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/EnterpriseHelper", "goToWwDownload", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33028);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */