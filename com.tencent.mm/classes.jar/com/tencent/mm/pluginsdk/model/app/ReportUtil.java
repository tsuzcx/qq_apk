package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public final class ReportUtil
{
  public static void a(Context paramContext, ReportArgs paramReportArgs)
  {
    AppMethodBeat.i(31090);
    if (paramReportArgs.bUl == 1)
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
    u.bS(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.bJH;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
    AppMethodBeat.o(31090);
  }
  
  public static void a(Context paramContext, ReportArgs paramReportArgs, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(31089);
    if (paramReportArgs == null)
    {
      AppMethodBeat.o(31089);
      return;
    }
    ad.b localb = ad.bCb().M("kWXEntryActivity_data_center_session_id", true);
    if (localb != null) {
      bool = localb.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
    }
    ap(paramBoolean, paramReportArgs.errCode);
    if ((bool) && (paramBoolean)) {
      paramReportArgs.errCode = -2;
    }
    a(paramContext, paramReportArgs);
    AppMethodBeat.o(31089);
  }
  
  public static void ap(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(31088);
    ad.b localb = ad.bCb().M("kWXEntryActivity_data_center_session_id", true);
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
      h.OAn.b(15632, new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(31088);
      return;
    }
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
    u.bS(localBundle);
    localObject = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject).targetPkgName = paramReportArgs.bJH;
    ((MMessageActV2.Args)localObject).bundle = localBundle;
    MMessageActV2.send(paramContext, (MMessageActV2.Args)localObject);
    AppMethodBeat.o(31091);
  }
  
  private static String bU(Bundle paramBundle)
  {
    AppMethodBeat.i(31093);
    SendMessageToWX.Req localReq = new SendMessageToWX.Req();
    localReq.fromBundle(paramBundle);
    paramBundle = localReq.transaction;
    AppMethodBeat.o(31093);
    return paramBundle;
  }
  
  public static ReportArgs c(Bundle paramBundle, int paramInt)
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
      localObject1 = IntentUtil.getString(paramBundle, "_wxapi_payreq_appid");
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(31092);
        return null;
      }
    }
    localObject1 = new g();
    ((g)localObject1).field_appId = ((String)localObject2);
    if ((bh.bCA()) && (bh.baz()))
    {
      as.gxn().get((IAutoDBItem)localObject1, new String[0]);
      if (!Util.isNullOrNil(((g)localObject1).field_packageName)) {}
    }
    else
    {
      ((g)localObject1).field_packageName = paramBundle.getString("_mmessage_appPackage");
    }
    localObject2 = new ReportArgs();
    ((ReportArgs)localObject2).bJH = ((g)localObject1).field_packageName;
    ((ReportArgs)localObject2).errCode = paramInt;
    ((ReportArgs)localObject2).transaction = bU(paramBundle);
    ((ReportArgs)localObject2).openId = ((g)localObject1).field_openId;
    ((ReportArgs)localObject2).bUl = paramBundle.getInt("_wxapi_command_type");
    AppMethodBeat.o(31092);
    return localObject2;
  }
  
  public static class ReportArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<ReportArgs> CREATOR;
    public String bJH;
    public int bUl;
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
      this.bJH = paramParcel.readString();
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
      paramParcel.writeString(this.bJH);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.transaction);
      paramParcel.writeString(this.openId);
      AppMethodBeat.o(31085);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ReportUtil
 * JD-Core Version:    0.7.0.1
 */