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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.an.d;
import com.tencent.mm.an.e;
import com.tencent.mm.an.x;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.af.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;

public final class i
{
  private static final String hlb;
  
  static
  {
    AppMethodBeat.i(249238);
    hlb = "https://" + WeChatHosts.domainString(R.l.host_work_weixin_qq_com) + "/wework_admin/commdownload?from=conv%s";
    AppMethodBeat.o(249238);
  }
  
  private static int ba(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33029);
    com.tencent.mm.api.c localc = af.bHf().Mn(paramString);
    String str = paramString;
    if (localc != null)
    {
      str = paramString;
      if (localc.aAQ()) {
        str = localc.aAX();
      }
    }
    paramString = af.bHq().Mi(str);
    int i;
    int j;
    label68:
    long l1;
    if (paramString != null)
    {
      i = paramString.field_qyUin;
      if (paramString == null) {
        break label216;
      }
      j = paramString.field_userUin;
      if (paramString == null) {
        break label222;
      }
      l1 = paramString.field_wwCorpId;
      label78:
      if (paramString == null) {
        break label228;
      }
    }
    label216:
    label222:
    label228:
    for (long l2 = paramString.field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      Log.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(33029);
      return paramInt2;
      i = 0;
      break;
      j = 0;
      break label68;
      l1 = 0L;
      break label78;
    }
  }
  
  public static void bb(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33031);
    com.tencent.mm.api.c localc = af.bHf().Mn(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      if (paramInt2 == 4) {
        paramInt2 = 3;
      }
      for (;;)
      {
        Object localObject = paramString;
        if (localc != null)
        {
          localObject = paramString;
          if (localc.aAQ()) {
            localObject = localc.aAX();
          }
        }
        paramString = af.bHq().Mi((String)localObject);
        localObject = new x(paramString, paramInt1, paramInt2, new Object());
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
        int i;
        if (paramString.field_chatOpen)
        {
          i = 1;
          if (!paramString.field_show_confirm) {
            break label210;
          }
        }
        label210:
        for (int j = 1;; j = 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(i), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(33031);
          return;
          i = 0;
          break;
        }
      }
    }
  }
  
  public static int cT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33024);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33024);
      return 0;
    }
    paramString = af.bHq().Mi(paramString);
    int i;
    if ((paramString != null) && ((paramString.field_userFlag & 0x2) != 0)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramString.field_wwExposeTimes < paramString.field_wwMaxExposeTimes) || (u.y(paramContext, "com.tencent.wework")))
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
  
  public static void cU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(33025);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33025);
      return;
    }
    if (!u.y(paramContext, "com.tencent.wework")) {
      af.bHq().Ml(paramString);
    }
    AppMethodBeat.o(33025);
  }
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33026);
    if (u.y(paramContext, "com.tencent.wework"))
    {
      ba(paramString, 4, paramInt);
      AppMethodBeat.o(33026);
      return;
    }
    ba(paramString, 5, paramInt);
    AppMethodBeat.o(33026);
  }
  
  public static void w(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(33027);
    ba(paramString, 1, paramInt);
    bb(paramString, 2, paramInt);
    d locald = af.bHq().Mj(paramString);
    Object localObject = null;
    String str;
    if ((4 == paramInt) || (3 == paramInt))
    {
      af.bHq();
      str = e.bGA();
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
    if (u.y(paramContext, "com.tencent.wework"))
    {
      ba(paramString, 2, paramInt);
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
        a.post(new i.4(paramContext, paramString));
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
      k.a(paramContext, R.l.enterprise_wework_donwload_confirm_tip, 0, R.l.enterprise_wework_donwload_confirm_btn, R.l.app_cancel, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33021);
          i.x(i.this, paramString, paramInt);
          AppMethodBeat.o(33021);
        }
      }, null);
      AppMethodBeat.o(33027);
      return;
    }
    if (locald.field_show_confirm)
    {
      localObject = new g.a(paramContext);
      ((g.a)localObject).bDJ(paramContext.getString(R.l.app_cancel));
      ((g.a)localObject).aEX(R.l.enterprise_wework_donwload_confirm_btn);
      af.bHq();
      af.bHq();
      str = e.vO(1);
      if (str == null) {
        ((g.a)localObject).bDE(paramContext.getString(R.l.enterprise_wework_donwload_confirm_tip));
      }
      for (;;)
      {
        ((g.a)localObject).a(new g.c()new g.c
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        }, new g.c()
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(33022);
            i.x(i.this, paramString, paramInt);
            AppMethodBeat.o(33022);
          }
        }).show();
        AppMethodBeat.o(33027);
        return;
        ((g.a)localObject).bDE(str);
      }
    }
    x(paramContext, paramString, paramInt);
    AppMethodBeat.o(33027);
  }
  
  public static void x(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(33028);
    ba(paramString, 3, paramInt);
    bb(paramString, 3, paramInt);
    af.bHf();
    paramString = com.tencent.mm.an.f.Ms(paramString);
    String str = hlb;
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format(str, new Object[] { paramString });
      paramString = com.tencent.mm.plugin.downloader.model.f.duv().amP(paramString);
      if ((paramString != null) && (paramString.status == 3) && (y.ZC(paramString.path))) {
        y.deleteFile(paramString.path);
      }
      aa.makeText(paramContext, paramContext.getString(R.l.enterprise_wework_download_tip), 2000).show();
      paramString = new Intent();
      paramString.putExtra("rawUrl", "https://work.weixin.qq.com/wework_admin/commdownload?from=wxpluginbottom");
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(33028);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */