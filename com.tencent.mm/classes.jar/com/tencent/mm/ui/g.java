package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.r;
import com.tencent.mm.ai.z;
import com.tencent.mm.cg.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

public final class g
{
  private static int am(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.mm.ai.d locald = z.My().kQ(paramString);
    if (locald.Lz()) {
      paramString = locald.LG();
    }
    paramString = z.MH().kD(paramString);
    int i;
    int j;
    label50:
    long l1;
    if (paramString != null)
    {
      i = paramString.field_qyUin;
      if (paramString == null) {
        break label193;
      }
      j = paramString.field_userUin;
      if (paramString == null) {
        break label199;
      }
      l1 = paramString.field_wwCorpId;
      label60:
      if (paramString == null) {
        break label205;
      }
    }
    label193:
    label199:
    label205:
    for (long l2 = paramString.field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      y.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l1), Long.valueOf(l2) });
      return paramInt2;
      i = 0;
      break;
      j = 0;
      break label50;
      l1 = 0L;
      break label60;
    }
  }
  
  public static void an(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = z.My().kQ(paramString);
    if (paramInt2 == 3) {
      paramInt2 = 2;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 4) {
        i = 3;
      }
      if (((com.tencent.mm.ai.d)localObject).Lz()) {
        paramString = ((com.tencent.mm.ai.d)localObject).LG();
      }
      paramString = z.MH().kD(paramString);
      localObject = new r(paramString, paramInt1, i, new Object());
      com.tencent.mm.kernel.g.DO().dJT.a((m)localObject, 0);
      if (paramString.field_chatOpen)
      {
        paramInt2 = 1;
        if (!paramString.field_show_confirm) {
          break label189;
        }
      }
      label189:
      for (int j = 1;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15162, new Object[] { Long.valueOf(paramString.field_wwCorpId), Long.valueOf(paramString.field_wwUserVid), Integer.valueOf(paramInt2), Integer.valueOf(paramString.field_wwUnreadCnt), Integer.valueOf(j), Integer.valueOf(paramString.field_userType), Integer.valueOf(paramInt1), Integer.valueOf(i) });
        return;
        paramInt2 = 0;
        break;
      }
    }
  }
  
  public static int bw(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return 0;
      paramString = z.MH().kD(paramString);
      if ((paramString != null) && ((paramString.field_userFlag & 0x2) != 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        if ((paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes) && (!com.tencent.mm.pluginsdk.model.app.p.o(paramContext, "com.tencent.wework"))) {
          break label63;
        }
        return 2;
      }
    }
    label63:
    return 1;
  }
  
  public static void bx(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {}
    while (com.tencent.mm.pluginsdk.model.app.p.o(paramContext, "com.tencent.wework")) {
      return;
    }
    z.MH().kG(paramString);
  }
  
  public static void dB(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    paramString = z.MH().kD(paramString);
    int i;
    if (paramString != null)
    {
      i = paramString.field_qyUin;
      if (paramString == null) {
        break label103;
      }
    }
    label103:
    for (int j = paramString.field_userUin;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13703, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
      y.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
      return;
      i = 0;
      break;
    }
  }
  
  public static void m(Context paramContext, String paramString, int paramInt)
  {
    if (com.tencent.mm.pluginsdk.model.app.p.o(paramContext, "com.tencent.wework"))
    {
      am(paramString, 4, paramInt);
      return;
    }
    am(paramString, 5, paramInt);
  }
  
  public static void n(Context paramContext, String paramString, int paramInt)
  {
    am(paramString, 1, paramInt);
    an(paramString, 2, paramInt);
    Object localObject = z.MH().kE(paramString);
    if (com.tencent.mm.pluginsdk.model.app.p.o(paramContext, "com.tencent.wework"))
    {
      am(paramString, 2, paramInt);
      paramString = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(paramContext, "com.tencent.wework");
      if ((!bk.bl(paramString.versionName)) && (paramString.versionName.compareTo("1.3.3") >= 0))
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
        return;
        paramString = "wxwork://conversationlist";
        break;
      }
    }
    if ((((com.tencent.mm.ai.b)localObject).field_chatOpen) || (((com.tencent.mm.ai.b)localObject).field_use_preset_banner_tips))
    {
      com.tencent.mm.ui.base.h.a(paramContext, R.l.enterprise_wework_donwload_confirm_tip, 0, R.l.enterprise_wework_donwload_confirm_btn, R.l.app_cancel, new g.1(paramContext, paramString, paramInt), null);
      return;
    }
    if (((com.tencent.mm.ai.b)localObject).field_show_confirm)
    {
      localObject = new com.tencent.mm.ui.widget.a.e.a(paramContext);
      ((com.tencent.mm.ui.widget.a.e.a)localObject).wnw = paramContext.getString(R.l.app_cancel);
      ((com.tencent.mm.ui.widget.a.e.a)localObject).Iu(R.l.enterprise_wework_donwload_confirm_btn);
      z.MH();
      z.MH();
      String str = c.ik(1);
      if (str == null) {
        ((com.tencent.mm.ui.widget.a.e.a)localObject).aeG(paramContext.getString(R.l.enterprise_wework_donwload_confirm_tip));
      }
      for (;;)
      {
        ((com.tencent.mm.ui.widget.a.e.a)localObject).a(new g.2(), new g.3(paramContext, paramString, paramInt)).show();
        return;
        ((com.tencent.mm.ui.widget.a.e.a)localObject).aeG(str);
      }
    }
    o(paramContext, paramString, paramInt);
  }
  
  public static void o(Context paramContext, String paramString, int paramInt)
  {
    am(paramString, 3, paramInt);
    an(paramString, 3, paramInt);
    z.My();
    if (bk.bl(com.tencent.mm.ai.e.kT(paramString))) {}
    for (paramString = "off";; paramString = "on")
    {
      paramString = String.format("https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s", new Object[] { paramString });
      Object localObject = com.tencent.mm.plugin.downloader.model.d.aFP().zM(paramString);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3) && (com.tencent.mm.vfs.e.bK(((FileDownloadTaskInfo)localObject).path))) {
        com.tencent.mm.vfs.e.deleteFile(((FileDownloadTaskInfo)localObject).path);
      }
      s.makeText(paramContext, paramContext.getString(R.l.enterprise_wework_download_tip), 2000).show();
      localObject = new com.tencent.mm.plugin.downloader.model.e.a();
      ((com.tencent.mm.plugin.downloader.model.e.a)localObject).zN(paramString);
      ((com.tencent.mm.plugin.downloader.model.e.a)localObject).zP(paramContext.getString(R.l.enterprise_wework_apk));
      ((com.tencent.mm.plugin.downloader.model.e.a)localObject).pE(1);
      ((com.tencent.mm.plugin.downloader.model.e.a)localObject).eO(true);
      com.tencent.mm.plugin.downloader.model.d.aFP().a(((com.tencent.mm.plugin.downloader.model.e.a)localObject).iPG);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */