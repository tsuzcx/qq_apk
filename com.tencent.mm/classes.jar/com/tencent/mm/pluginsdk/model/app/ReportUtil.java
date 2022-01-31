package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;

public final class ReportUtil
{
  public static void G(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27388);
    v.b localb = v.aae().z("kWXEntryActivity_data_center_session_id", true);
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
        break label130;
      }
    }
    label130:
    for (int i = 0;; i = -1)
    {
      h.qsU.e(15632, new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(27388);
      return;
    }
  }
  
  public static void a(Context paramContext, ReportUtil.ReportArgs paramReportArgs)
  {
    AppMethodBeat.i(27390);
    if (paramReportArgs.vA == 1)
    {
      b(paramContext, paramReportArgs);
      AppMethodBeat.o(27390);
      return;
    }
    Object localObject = new SendMessageToWX.Resp();
    ((SendMessageToWX.Resp)localObject).errCode = paramReportArgs.errCode;
    ((SendMessageToWX.Resp)localObject).transaction = paramReportArgs.transaction;
    ((SendMessageToWX.Resp)localObject).openId = paramReportArgs.openId;
    Bundle localBundle = new Bundle();
    ((SendMessageToWX.Resp)localObject).toBundle(localBundle);
    p.aC(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.Ca;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
    AppMethodBeat.o(27390);
  }
  
  public static void a(Context paramContext, ReportUtil.ReportArgs paramReportArgs, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(27389);
    v.b localb = v.aae().z("kWXEntryActivity_data_center_session_id", true);
    if (localb != null) {
      bool = localb.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
    }
    G(paramBoolean, paramReportArgs.errCode);
    if ((bool) && (paramBoolean)) {
      paramReportArgs.errCode = -2;
    }
    a(paramContext, paramReportArgs);
    AppMethodBeat.o(27389);
  }
  
  private static String aE(Bundle paramBundle)
  {
    AppMethodBeat.i(27393);
    SendMessageToWX.Req localReq = new SendMessageToWX.Req();
    localReq.fromBundle(paramBundle);
    paramBundle = localReq.transaction;
    AppMethodBeat.o(27393);
    return paramBundle;
  }
  
  private static void b(Context paramContext, ReportUtil.ReportArgs paramReportArgs)
  {
    AppMethodBeat.i(27391);
    Object localObject = new SendAuth.Resp();
    ((SendAuth.Resp)localObject).transaction = paramReportArgs.transaction;
    ((SendAuth.Resp)localObject).errCode = paramReportArgs.errCode;
    ((SendAuth.Resp)localObject).openId = paramReportArgs.openId;
    Bundle localBundle = new Bundle();
    ((SendAuth.Resp)localObject).toBundle(localBundle);
    p.aC(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.Ca;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
    AppMethodBeat.o(27391);
  }
  
  public static ReportUtil.ReportArgs c(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(27392);
    Object localObject2 = paramBundle.getString("SendAppMessageWrapper_AppId");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      String str = paramBundle.getString("_mmessage_content");
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = Uri.parse(str).getQueryParameter("appid");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = w.l(paramBundle, "_wxapi_payreq_appid");
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(27392);
        return null;
      }
    }
    localObject1 = new f();
    ((f)localObject1).field_appId = ((String)localObject2);
    if ((aw.aaB()) && (aw.RG())) {
      al.cac().get((c)localObject1, new String[0]);
    }
    for (;;)
    {
      localObject2 = new ReportUtil.ReportArgs();
      ((ReportUtil.ReportArgs)localObject2).Ca = ((f)localObject1).field_packageName;
      ((ReportUtil.ReportArgs)localObject2).errCode = paramInt;
      ((ReportUtil.ReportArgs)localObject2).transaction = aE(paramBundle);
      ((ReportUtil.ReportArgs)localObject2).openId = ((f)localObject1).field_openId;
      ((ReportUtil.ReportArgs)localObject2).vA = paramBundle.getInt("_wxapi_command_type");
      AppMethodBeat.o(27392);
      return localObject2;
      ((f)localObject1).field_packageName = paramBundle.getString("_mmessage_appPackage");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ReportUtil
 * JD-Core Version:    0.7.0.1
 */