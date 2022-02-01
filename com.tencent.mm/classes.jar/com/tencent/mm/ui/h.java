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
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e;
import com.tencent.mm.al.x;
import com.tencent.mm.ch.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.s;

public final class h
{
  private static final String dol;
  
  static
  {
    AppMethodBeat.i(232475);
    dol = "https://" + WeChatHosts.domainString(2131761751) + "/wework_admin/commdownload?from=conv%s";
    AppMethodBeat.o(232475);
  }
  
  private static int aP(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33029);
    com.tencent.mm.api.c localc = ag.bah().MT(paramString);
    if (localc.UG()) {
      paramString = localc.UN();
    }
    paramString = ag.bar().MO(paramString);
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
      com.tencent.mm.plugin.report.service.h.CyF.a(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
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
  
  public static void aQ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33031);
    Object localObject = ag.bah().MT(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 4) {
        i = 3;
      }
      if (((com.tencent.mm.api.c)localObject).UG()) {
        paramString = ((com.tencent.mm.api.c)localObject).UN();
      }
      paramString = ag.bar().MO(paramString);
      localObject = new x(paramString, paramInt1, i, new Object());
      g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
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
        com.tencent.mm.plugin.report.service.h.CyF.a(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(paramInt2), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(i) });
        AppMethodBeat.o(33031);
        return;
        paramInt2 = 0;
        break;
      }
    }
  }
  
  public static int cy(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33024);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33024);
      return 0;
    }
    paramString = ag.bar().MO(paramString);
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
  
  public static void cz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33025);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33025);
      return;
    }
    if (!com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework")) {
      ag.bar().MR(paramString);
    }
    AppMethodBeat.o(33025);
  }
  
  public static void r(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33026);
    if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework"))
    {
      aP(paramString, 4, paramInt);
      AppMethodBeat.o(33026);
      return;
    }
    aP(paramString, 5, paramInt);
    AppMethodBeat.o(33026);
  }
  
  public static void s(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(33027);
    aP(paramString, 1, paramInt);
    aQ(paramString, 2, paramInt);
    d locald = ag.bar().MP(paramString);
    Object localObject = null;
    String str;
    if ((4 == paramInt) || (3 == paramInt))
    {
      ag.bar();
      str = e.aZA();
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
            com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
            AppMethodBeat.o(33027);
            return;
          }
        }
      }
    }
    if (com.tencent.mm.pluginsdk.model.app.q.s(paramContext, "com.tencent.wework"))
    {
      aP(paramString, 2, paramInt);
      paramString = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(paramContext, "com.tencent.wework");
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
        a.post(new h.4(paramContext, paramString));
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
      com.tencent.mm.ui.base.h.a(paramContext, 2131758752, 0, 2131758751, 2131755761, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33021);
          h.t(this.val$context, paramString, paramInt);
          AppMethodBeat.o(33021);
        }
      }, null);
      AppMethodBeat.o(33027);
      return;
    }
    if (locald.field_show_confirm)
    {
      localObject = new f.a(paramContext);
      ((f.a)localObject).boB(paramContext.getString(2131755761));
      ((f.a)localObject).apa(2131758751);
      ag.bar();
      ag.bar();
      str = e.sM(1);
      if (str == null) {
        ((f.a)localObject).bow(paramContext.getString(2131758752));
      }
      for (;;)
      {
        ((f.a)localObject).a(new f.c()new f.c
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        }, new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(33022);
            h.t(this.val$context, paramString, paramInt);
            AppMethodBeat.o(33022);
          }
        }).show();
        AppMethodBeat.o(33027);
        return;
        ((f.a)localObject).bow(str);
      }
    }
    t(paramContext, paramString, paramInt);
    AppMethodBeat.o(33027);
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33028);
    aP(paramString, 3, paramInt);
    aQ(paramString, 3, paramInt);
    ag.bah();
    paramString = com.tencent.mm.al.f.MX(paramString);
    Object localObject = dol;
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format((String)localObject, new Object[] { paramString });
      localObject = com.tencent.mm.plugin.downloader.model.f.cBv().alh(paramString);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3) && (s.YS(((FileDownloadTaskInfo)localObject).path))) {
        s.deleteFile(((FileDownloadTaskInfo)localObject).path);
      }
      u.makeText(paramContext, paramContext.getString(2131758753), 2000).show();
      localObject = new g.a();
      ((g.a)localObject).alj(paramString);
      ((g.a)localObject).all(paramContext.getString(2131758749));
      ((g.a)localObject).Fl(1);
      ((g.a)localObject).kS(true);
      com.tencent.mm.plugin.downloader.model.f.cBv().a(((g.a)localObject).qIY);
      AppMethodBeat.o(33028);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */