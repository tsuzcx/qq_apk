package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.t;

public final class ReportUtil
{
  public static void a(Context paramContext, ReportUtil.ReportArgs paramReportArgs)
  {
    if (paramReportArgs.uC == 1)
    {
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = paramReportArgs.transaction;
      ((SendAuth.Resp)localObject).errCode = paramReportArgs.errCode;
      ((SendAuth.Resp)localObject).openId = paramReportArgs.openId;
      localBundle = new Bundle();
      ((SendAuth.Resp)localObject).toBundle(localBundle);
      p.ak(localBundle);
      localObject = new MMessageActV2.Args();
      ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.Bo;
      ((MMessageActV2.Args)localObject).bundle = localBundle;
      MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
      return;
    }
    Object localObject = new SendMessageToWX.Resp();
    ((SendMessageToWX.Resp)localObject).errCode = paramReportArgs.errCode;
    ((SendMessageToWX.Resp)localObject).transaction = paramReportArgs.transaction;
    ((SendMessageToWX.Resp)localObject).openId = paramReportArgs.openId;
    Bundle localBundle = new Bundle();
    ((SendMessageToWX.Resp)localObject).toBundle(localBundle);
    p.ak(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.Bo;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
  }
  
  public static void a(Context paramContext, ReportUtil.ReportArgs paramReportArgs, boolean paramBoolean)
  {
    boolean bool = false;
    u.b localb = u.Hc().v("kWXEntryActivity_data_center_session_id", true);
    if (localb != null) {
      bool = localb.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
    }
    y(paramBoolean, paramReportArgs.errCode);
    if ((bool) && (paramBoolean)) {
      paramReportArgs.errCode = -2;
    }
    a(paramContext, paramReportArgs);
  }
  
  public static ReportUtil.ReportArgs c(Bundle paramBundle, int paramInt)
  {
    Object localObject2 = paramBundle.getString("SendAppMessageWrapper_AppId");
    Object localObject1 = localObject2;
    Object localObject3;
    if (localObject2 == null)
    {
      localObject3 = paramBundle.getString("_mmessage_content");
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Uri.parse((String)localObject3).getQueryParameter("appid");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = t.k(paramBundle, "_wxapi_payreq_appid");
      localObject2 = localObject1;
      if (localObject1 == null) {
        return null;
      }
    }
    localObject1 = new f();
    ((f)localObject1).field_appId = ((String)localObject2);
    if ((au.Hz()) && (au.DK())) {
      ap.brn().b((c)localObject1, new String[0]);
    }
    for (;;)
    {
      localObject2 = new ReportUtil.ReportArgs();
      ((ReportUtil.ReportArgs)localObject2).Bo = ((f)localObject1).field_packageName;
      ((ReportUtil.ReportArgs)localObject2).errCode = paramInt;
      localObject3 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject3).fromBundle(paramBundle);
      ((ReportUtil.ReportArgs)localObject2).transaction = ((SendMessageToWX.Req)localObject3).transaction;
      ((ReportUtil.ReportArgs)localObject2).openId = ((f)localObject1).field_openId;
      ((ReportUtil.ReportArgs)localObject2).uC = paramBundle.getInt("_wxapi_command_type");
      return localObject2;
      ((f)localObject1).field_packageName = paramBundle.getString("_mmessage_appPackage");
    }
  }
  
  public static void y(boolean paramBoolean, int paramInt)
  {
    u.b localb = u.Hc().v("kWXEntryActivity_data_center_session_id", true);
    String str;
    int j;
    int k;
    if (localb != null)
    {
      str = localb.getString("kWXEntryActivity_data_center_app_id", "");
      boolean bool = localb.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
      j = localb.getInt("kWXEntryActivity_data_center_msg_type", 0);
      k = localb.getInt("kWXEntryActivity_data_center_scene", 0);
      if (paramBoolean) {
        paramInt = -2;
      }
      if (!bool) {
        break label118;
      }
    }
    label118:
    for (int i = 0;; i = -1)
    {
      h.nFQ.f(15632, new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ReportUtil
 * JD-Core Version:    0.7.0.1
 */