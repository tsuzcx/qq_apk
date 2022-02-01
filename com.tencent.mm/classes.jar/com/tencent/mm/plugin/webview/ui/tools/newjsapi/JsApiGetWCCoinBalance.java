package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getWCCoinBalance", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "extInfo", "handleMsg", "GetWeCoinBalanceTask", "GetWeCoinTaskData", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiGetWCCoinBalance
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final JsApiGetWCCoinBalance Xng;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297589);
    Xng = new JsApiGetWCCoinBalance();
    OOk = 407;
    idA = "getWCCoinBalance";
    AppMethodBeat.o(297589);
  }
  
  private static final void a(h paramh, p paramp, Map paramMap, String paramString, IPCLong paramIPCLong)
  {
    AppMethodBeat.i(297584);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    s.u(paramMap, "$values");
    s.u(paramString, "$keyBalance");
    if (paramIPCLong.value < 0L)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297584);
      return;
    }
    paramMap.put(paramString, Long.valueOf(paramIPCLong.value));
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), paramMap);
    AppMethodBeat.o(297584);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297608);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str = (String)paramp.params.get("extInfo");
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiGetWCCoinBalance", "getWCCoinBalance extInfo: %s", new Object[] { str });
      Map localMap = (Map)new HashMap();
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new GetWeCoinTaskData(str), a.class, new JsApiGetWCCoinBalance..ExternalSyntheticLambda0(paramh, paramp, localMap, "balance"));
      AppMethodBeat.o(297608);
      return true;
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class GetWeCoinTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    private String extInfo;
    
    static
    {
      AppMethodBeat.i(297700);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297700);
    }
    
    public GetWeCoinTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(297691);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(297691);
    }
    
    public GetWeCoinTaskData(String paramString)
    {
      AppMethodBeat.i(297684);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(297684);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297706);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(297706);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinTaskData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiGetWCCoinBalance.GetWeCoinTaskData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinBalanceTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCLong;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiGetWCCoinBalance.GetWeCoinTaskData, IPCLong>
  {
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetWCCoinBalance$GetWeCoinBalanceTask$invoke$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "wecoinMsg", "", "onSuccess", "data", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements i<Long>
    {
      a(f<IPCLong> paramf) {}
      
      public final void s(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(297793);
        Log.i("MicroMsg.JsApiGetWCCoinBalance", "[WeCoin] getWeCoinBalance onFailed,errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
        paramString = this.mht;
        if (paramString != null) {
          paramString.onCallback(new IPCLong(-1L));
        }
        AppMethodBeat.o(297793);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiGetWCCoinBalance
 * JD-Core Version:    0.7.0.1
 */