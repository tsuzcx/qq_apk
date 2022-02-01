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
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.w;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.i;

public final class g
{
  private static int aN(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33029);
    com.tencent.mm.api.c localc = af.aCW().AE(paramString);
    if (localc.IO()) {
      paramString = localc.IV();
    }
    paramString = af.aDf().Az(paramString);
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
      com.tencent.mm.plugin.report.service.h.wUl.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      ac.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
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
  
  public static void aO(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33031);
    Object localObject = af.aCW().AE(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 4) {
        i = 3;
      }
      if (((com.tencent.mm.api.c)localObject).IO()) {
        paramString = ((com.tencent.mm.api.c)localObject).IV();
      }
      paramString = af.aDf().Az(paramString);
      localObject = new w(paramString, paramInt1, i, new Object());
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
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
        com.tencent.mm.plugin.report.service.h.wUl.f(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(paramInt2), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(i) });
        AppMethodBeat.o(33031);
        return;
        paramInt2 = 0;
        break;
      }
    }
  }
  
  public static int cb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33024);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33024);
      return 0;
    }
    paramString = af.aDf().Az(paramString);
    int i;
    if ((paramString != null) && ((paramString.field_userFlag & 0x2) != 0)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramString.field_wwExposeTimes < paramString.field_wwMaxExposeTimes) || (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, "com.tencent.wework")))
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
  
  public static void cc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33025);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33025);
      return;
    }
    if (!com.tencent.mm.pluginsdk.model.app.q.t(paramContext, "com.tencent.wework")) {
      af.aDf().AC(paramString);
    }
    AppMethodBeat.o(33025);
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33026);
    if (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, "com.tencent.wework"))
    {
      aN(paramString, 4, paramInt);
      AppMethodBeat.o(33026);
      return;
    }
    aN(paramString, 5, paramInt);
    AppMethodBeat.o(33026);
  }
  
  public static void u(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(33027);
    aN(paramString, 1, paramInt);
    aO(paramString, 2, paramInt);
    com.tencent.mm.al.c localc = af.aDf().AA(paramString);
    Object localObject = null;
    String str;
    if ((4 == paramInt) || (3 == paramInt))
    {
      af.aDf();
      str = com.tencent.mm.al.d.aCp();
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
            com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
            AppMethodBeat.o(33027);
            return;
          }
        }
      }
    }
    if (com.tencent.mm.pluginsdk.model.app.q.t(paramContext, "com.tencent.wework"))
    {
      aN(paramString, 2, paramInt);
      paramString = com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(paramContext, "com.tencent.wework");
      if ((!bs.isNullOrNil(paramString.versionName)) && (paramString.versionName.compareTo("1.3.3") >= 0))
      {
        paramString = new Intent();
        paramString.setAction("android.intent.action.VIEW");
        if (((paramInt == 4) || (3 == paramInt)) && (localObject != null) && (((String)localObject).length() > 0)) {
          paramString.setData(Uri.parse((String)localObject));
        }
      }
      for (;;)
      {
        a.post(new g.4(paramContext, paramString));
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
    if (localc.field_use_preset_banner_tips)
    {
      com.tencent.mm.ui.base.h.b(paramContext, 2131758454, 0, 2131758453, 2131755691, new DialogInterface.OnClickListener()
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
    if (localc.field_show_confirm)
    {
      localObject = new f.a(paramContext);
      ((f.a)localObject).aRV(paramContext.getString(2131755691));
      ((f.a)localObject).acQ(2131758453);
      af.aDf();
      af.aDf();
      str = com.tencent.mm.al.d.ou(1);
      if (str == null) {
        ((f.a)localObject).aRQ(paramContext.getString(2131758454));
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
        ((f.a)localObject).aRQ(str);
      }
    }
    v(paramContext, paramString, paramInt);
    AppMethodBeat.o(33027);
  }
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33028);
    aN(paramString, 3, paramInt);
    aO(paramString, 3, paramInt);
    af.aCW();
    if (bs.isNullOrNil(e.AI(paramString))) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format("https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s", new Object[] { paramString });
      Object localObject = f.bXJ().WC(paramString);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3) && (i.eA(((FileDownloadTaskInfo)localObject).path))) {
        i.deleteFile(((FileDownloadTaskInfo)localObject).path);
      }
      t.makeText(paramContext, paramContext.getString(2131758455), 2000).show();
      localObject = new g.a();
      ((g.a)localObject).WD(paramString);
      ((g.a)localObject).WF(paramContext.getString(2131758451));
      ((g.a)localObject).AG(1);
      ((g.a)localObject).jF(true);
      f.bXJ().a(((g.a)localObject).oJg);
      AppMethodBeat.o(33028);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */