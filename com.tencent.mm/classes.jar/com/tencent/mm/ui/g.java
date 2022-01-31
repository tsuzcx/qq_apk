package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.r;
import com.tencent.mm.aj.z;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.b.e.a;

public final class g
{
  private static int aD(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29204);
    d locald = z.afi().rK(paramString);
    if (locald.aeh()) {
      paramString = locald.aeo();
    }
    paramString = z.afr().rx(paramString);
    int i;
    int j;
    label56:
    long l1;
    if (paramString != null)
    {
      i = paramString.field_qyUin;
      if (paramString == null) {
        break label205;
      }
      j = paramString.field_userUin;
      if (paramString == null) {
        break label211;
      }
      l1 = paramString.field_wwCorpId;
      label66:
      if (paramString == null) {
        break label217;
      }
    }
    label205:
    label211:
    label217:
    for (long l2 = paramString.field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      ab.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      AppMethodBeat.o(29204);
      return paramInt2;
      i = 0;
      break;
      j = 0;
      break label56;
      l1 = 0L;
      break label66;
    }
  }
  
  public static void aE(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29206);
    Object localObject = z.afi().rK(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 4) {
        i = 3;
      }
      if (((d)localObject).aeh()) {
        paramString = ((d)localObject).aeo();
      }
      paramString = z.afr().rx(paramString);
      localObject = new r(paramString, paramInt1, i, new Object());
      com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
      if (paramString.field_chatOpen)
      {
        paramInt2 = 1;
        if (!paramString.field_show_confirm) {
          break label201;
        }
      }
      label201:
      for (int j = 1;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(paramInt2), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(i) });
        AppMethodBeat.o(29206);
        return;
        paramInt2 = 0;
        break;
      }
    }
  }
  
  public static int bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29199);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29199);
      return 0;
    }
    paramString = z.afr().rx(paramString);
    int i;
    if ((paramString != null) && ((paramString.field_userFlag & 0x2) != 0)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramString.field_wwExposeTimes < paramString.field_wwMaxExposeTimes) || (com.tencent.mm.pluginsdk.model.app.p.u(paramContext, "com.tencent.wework")))
      {
        AppMethodBeat.o(29199);
        return 2;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(29199);
        return 1;
      }
    }
    AppMethodBeat.o(29199);
    return 0;
  }
  
  public static void bK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29200);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29200);
      return;
    }
    if (!com.tencent.mm.pluginsdk.model.app.p.u(paramContext, "com.tencent.wework")) {
      z.afr().rA(paramString);
    }
    AppMethodBeat.o(29200);
  }
  
  public static void eK(String paramString, int paramInt)
  {
    AppMethodBeat.i(29205);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(29205);
      return;
    }
    paramString = z.afr().rx(paramString);
    int i;
    if (paramString != null)
    {
      i = paramString.field_qyUin;
      if (paramString == null) {
        break label121;
      }
    }
    label121:
    for (int j = paramString.field_userUin;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13703, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
      ab.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(29205);
      return;
      i = 0;
      break;
    }
  }
  
  public static void s(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(29201);
    if (com.tencent.mm.pluginsdk.model.app.p.u(paramContext, "com.tencent.wework"))
    {
      aD(paramString, 4, paramInt);
      AppMethodBeat.o(29201);
      return;
    }
    aD(paramString, 5, paramInt);
    AppMethodBeat.o(29201);
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(29202);
    aD(paramString, 1, paramInt);
    aE(paramString, 2, paramInt);
    Object localObject = z.afr().ry(paramString);
    if (com.tencent.mm.pluginsdk.model.app.p.u(paramContext, "com.tencent.wework"))
    {
      aD(paramString, 2, paramInt);
      paramString = com.tencent.mm.plugin.appbrand.s.b.getPackageInfo(paramContext, "com.tencent.wework");
      if ((!bo.isNullOrNil(paramString.versionName)) && (paramString.versionName.compareTo("1.3.3") >= 0))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        if ((paramInt == 2) || (paramInt == 4) || (paramInt == 6))
        {
          paramString = "wxwork://createconversation";
          ((Intent)localObject).setData(Uri.parse(paramString));
        }
      }
      for (paramString = (String)localObject;; paramString = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.wework"))
      {
        a.post(new g.4(paramContext, paramString));
        AppMethodBeat.o(29202);
        return;
        paramString = "wxwork://conversationlist";
        break;
      }
    }
    if (((com.tencent.mm.aj.b)localObject).field_use_preset_banner_tips)
    {
      com.tencent.mm.ui.base.h.a(paramContext, 2131299327, 0, 2131299326, 2131296888, new g.1(paramContext, paramString, paramInt), null);
      AppMethodBeat.o(29202);
      return;
    }
    if (((com.tencent.mm.aj.b)localObject).field_show_confirm)
    {
      localObject = new e.a(paramContext);
      ((e.a)localObject).AHt = paramContext.getString(2131296888);
      ((e.a)localObject).Rm(2131299326);
      z.afr();
      z.afr();
      String str = c.kX(1);
      if (str == null) {
        ((e.a)localObject).avu(paramContext.getString(2131299327));
      }
      for (;;)
      {
        ((e.a)localObject).a(new g.2(), new g.3(paramContext, paramString, paramInt)).show();
        AppMethodBeat.o(29202);
        return;
        ((e.a)localObject).avu(str);
      }
    }
    u(paramContext, paramString, paramInt);
    AppMethodBeat.o(29202);
  }
  
  public static void u(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(29203);
    aD(paramString, 3, paramInt);
    aE(paramString, 3, paramInt);
    z.afi();
    if (bo.isNullOrNil(com.tencent.mm.aj.e.rO(paramString))) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format("https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s", new Object[] { paramString });
      Object localObject = f.bjl().JI(paramString);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3) && (com.tencent.mm.vfs.e.cN(((FileDownloadTaskInfo)localObject).path))) {
        com.tencent.mm.vfs.e.deleteFile(((FileDownloadTaskInfo)localObject).path);
      }
      t.makeText(paramContext, paramContext.getString(2131299328), 2000).show();
      localObject = new g.a();
      ((g.a)localObject).JJ(paramString);
      ((g.a)localObject).JL(paramContext.getString(2131299324));
      ((g.a)localObject).tV(1);
      ((g.a)localObject).gr(true);
      f.bjl().a(((g.a)localObject).kYR);
      AppMethodBeat.o(29203);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */