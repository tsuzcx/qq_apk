package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.z.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.sdk.e.c;

public final class ReportUtil
{
  public static void Z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(31088);
    z.b localb = com.tencent.mm.model.z.aBG().F("kWXEntryActivity_data_center_session_id", true);
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
      com.tencent.mm.plugin.report.service.g.yxI.f(15632, new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(31088);
      return;
    }
  }
  
  public static void a(Context paramContext, ReportArgs paramReportArgs)
  {
    AppMethodBeat.i(31090);
    if (paramReportArgs.EN == 1)
    {
      b(paramContext, paramReportArgs);
      AppMethodBeat.o(31090);
      return;
    }
    Object localObject = new SendMessageToWX.Resp();
    ((SendMessageToWX.Resp)localObject).errCode = paramReportArgs.errCode;
    ((SendMessageToWX.Resp)localObject).transaction = paramReportArgs.transaction;
    ((SendMessageToWX.Resp)localObject).openId = paramReportArgs.openId;
    Bundle localBundle = new Bundle();
    ((SendMessageToWX.Resp)localObject).toBundle(localBundle);
    q.bc(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.Lw;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
    AppMethodBeat.o(31090);
  }
  
  public static void a(Context paramContext, ReportArgs paramReportArgs, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(31089);
    z.b localb = com.tencent.mm.model.z.aBG().F("kWXEntryActivity_data_center_session_id", true);
    if (localb != null) {
      bool = localb.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
    }
    Z(paramBoolean, paramReportArgs.errCode);
    if ((bool) && (paramBoolean)) {
      paramReportArgs.errCode = -2;
    }
    a(paramContext, paramReportArgs);
    AppMethodBeat.o(31089);
  }
  
  private static void b(Context paramContext, ReportArgs paramReportArgs)
  {
    AppMethodBeat.i(31091);
    Object localObject = new SendAuth.Resp();
    ((SendAuth.Resp)localObject).transaction = paramReportArgs.transaction;
    ((SendAuth.Resp)localObject).errCode = paramReportArgs.errCode;
    ((SendAuth.Resp)localObject).openId = paramReportArgs.openId;
    Bundle localBundle = new Bundle();
    ((SendAuth.Resp)localObject).toBundle(localBundle);
    q.bc(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.Lw;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
    AppMethodBeat.o(31091);
  }
  
  private static String be(Bundle paramBundle)
  {
    AppMethodBeat.i(31093);
    SendMessageToWX.Req localReq = new SendMessageToWX.Req();
    localReq.fromBundle(paramBundle);
    paramBundle = localReq.transaction;
    AppMethodBeat.o(31093);
    return paramBundle;
  }
  
  public static ReportArgs d(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(31092);
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
      localObject1 = com.tencent.mm.sdk.platformtools.z.m(paramBundle, "_wxapi_payreq_appid");
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(31092);
        return null;
      }
    }
    localObject1 = new g();
    ((g)localObject1).field_appId = ((String)localObject2);
    if ((bc.aCh()) && (bc.ajM())) {
      ao.dBg().get((c)localObject1, new String[0]);
    }
    for (;;)
    {
      localObject2 = new ReportArgs();
      ((ReportArgs)localObject2).Lw = ((g)localObject1).field_packageName;
      ((ReportArgs)localObject2).errCode = paramInt;
      ((ReportArgs)localObject2).transaction = be(paramBundle);
      ((ReportArgs)localObject2).openId = ((g)localObject1).field_openId;
      ((ReportArgs)localObject2).EN = paramBundle.getInt("_wxapi_command_type");
      AppMethodBeat.o(31092);
      return localObject2;
      ((g)localObject1).field_packageName = paramBundle.getString("_mmessage_appPackage");
    }
  }
  
  public static class ReportArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<ReportArgs> CREATOR;
    public int EN;
    public String Lw;
    public int errCode;
    public String openId;
    public String transaction;
    
    static
    {
      AppMethodBeat.i(31087);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(31087);
    }
    
    public ReportArgs() {}
    
    private ReportArgs(Parcel paramParcel)
    {
      AppMethodBeat.i(31086);
      this.Lw = paramParcel.readString();
      this.errCode = paramParcel.readInt();
      this.transaction = paramParcel.readString();
      this.openId = paramParcel.readString();
      AppMethodBeat.o(31086);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(31085);
      paramParcel.writeString(this.Lw);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.transaction);
      paramParcel.writeString(this.openId);
      AppMethodBeat.o(31085);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ReportUtil
 * JD-Core Version:    0.7.0.1
 */