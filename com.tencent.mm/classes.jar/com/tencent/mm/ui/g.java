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
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.e;
import com.tencent.mm.am.x;
import com.tencent.mm.api.c;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.i;

public final class g
{
  private static int aR(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33029);
    c localc = ag.aFZ().DD(paramString);
    if (localc.Ko()) {
      paramString = localc.Kv();
    }
    paramString = ag.aGi().Dy(paramString);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      ad.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
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
    Object localObject = ag.aFZ().DD(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 4) {
        i = 3;
      }
      if (((c)localObject).Ko()) {
        paramString = ((c)localObject).Kv();
      }
      paramString = ag.aGi().Dy(paramString);
      localObject = new x(paramString, paramInt1, i, new Object());
      com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
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
        com.tencent.mm.plugin.report.service.g.yhR.f(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(paramInt2), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(i) });
        AppMethodBeat.o(33031);
        return;
        paramInt2 = 0;
        break;
      }
    }
  }
  
  public static int cg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33024);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33024);
      return 0;
    }
    paramString = ag.aGi().Dy(paramString);
    int i;
    if ((paramString != null) && ((paramString.field_userFlag & 0x2) != 0)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramString.field_wwExposeTimes < paramString.field_wwMaxExposeTimes) || (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework")))
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
  
  public static void ch(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33025);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33025);
      return;
    }
    if (!com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework")) {
      ag.aGi().DB(paramString);
    }
    AppMethodBeat.o(33025);
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33026);
    if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework"))
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
    com.tencent.mm.am.d locald = ag.aGi().Dz(paramString);
    Object localObject = null;
    String str;
    if ((4 == paramInt) || (3 == paramInt))
    {
      ag.aGi();
      str = e.aFs();
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
            com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
            AppMethodBeat.o(33027);
            return;
          }
        }
      }
    }
    if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework"))
    {
      aR(paramString, 2, paramInt);
      paramString = com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(paramContext, "com.tencent.wework");
      if ((!bt.isNullOrNil(paramString.versionName)) && (paramString.versionName.compareTo("1.3.3") >= 0))
      {
        paramString = new Intent();
        paramString.setAction("android.intent.action.VIEW");
        if (((paramInt == 4) || (3 == paramInt)) && (localObject != null) && (((String)localObject).length() > 0)) {
          paramString.setData(Uri.parse((String)localObject));
        }
      }
      for (;;)
      {
        a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33023);
            try
            {
              com.tencent.mm.pluginsdk.model.app.h.b(this.val$context, paramString, this.val$context.getString(2131758451));
              AppMethodBeat.o(33023);
              return;
            }
            catch (Throwable localThrowable)
            {
              AppMethodBeat.o(33023);
            }
          }
        });
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
      com.tencent.mm.ui.base.h.a(paramContext, 2131758454, 0, 2131758453, 2131755691, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33021);
          g.v(this.val$context, paramString, paramInt);
          AppMethodBeat.o(33021);
        }
      }, null);
      AppMethodBeat.o(33027);
      return;
    }
    if (locald.field_show_confirm)
    {
      localObject = new f.a(paramContext);
      ((f.a)localObject).aXT(paramContext.getString(2131755691));
      ((f.a)localObject).afp(2131758453);
      ag.aGi();
      ag.aGi();
      str = e.oV(1);
      if (str == null) {
        ((f.a)localObject).aXO(paramContext.getString(2131758454));
      }
      for (;;)
      {
        ((f.a)localObject).a(new f.c()new f.c
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        }, new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(33022);
            g.v(this.val$context, paramString, paramInt);
            AppMethodBeat.o(33022);
          }
        }).show();
        AppMethodBeat.o(33027);
        return;
        ((f.a)localObject).aXO(str);
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
    ag.aFZ();
    if (bt.isNullOrNil(com.tencent.mm.am.f.DH(paramString))) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format("https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s", new Object[] { paramString });
      Object localObject = com.tencent.mm.plugin.downloader.model.f.ccl().aaj(paramString);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3) && (i.fv(((FileDownloadTaskInfo)localObject).path))) {
        i.deleteFile(((FileDownloadTaskInfo)localObject).path);
      }
      t.makeText(paramContext, paramContext.getString(2131758455), 2000).show();
      localObject = new g.a();
      ((g.a)localObject).aak(paramString);
      ((g.a)localObject).aam(paramContext.getString(2131758451));
      ((g.a)localObject).Bp(1);
      ((g.a)localObject).jQ(true);
      com.tencent.mm.plugin.downloader.model.f.ccl().a(((g.a)localObject).pmN);
      AppMethodBeat.o(33028);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */