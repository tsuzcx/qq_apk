package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetFinderRedDotData", "GetFinderRedDotTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiGetFinderRedDot
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final JsApiGetFinderRedDot Xnc;
  public static final String idA;
  
  static
  {
    AppMethodBeat.i(297597);
    Xnc = new JsApiGetFinderRedDot();
    OOk = 420;
    idA = "getFinderRedDot";
    AppMethodBeat.o(297597);
  }
  
  private static final void a(h paramh, p paramp, IPCString paramIPCString)
  {
    AppMethodBeat.i(297592);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    String str = paramIPCString.value;
    paramIPCString = str;
    if (str == null) {
      paramIPCString = "";
    }
    localMap.put("redDotInfo", new JSONObject(paramIPCString));
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":success"), (Map)localHashMap);
    AppMethodBeat.o(297592);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297618);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiGetFinderRedDot", "JsApiGetFinderRedDot");
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject2 = paramp.params.get("businessType");
      if (localObject2 != null)
      {
        Log.i("MicroMsg.JsApiGetFinderRedDot", s.X("businessType :", localObject2));
        ((JSONObject)localObject1).put("businessType", localObject2);
      }
      localObject2 = paramp.params.get("redDotPath");
      if (localObject2 != null)
      {
        Log.i("MicroMsg.JsApiGetFinderRedDot", s.X("redDotPath :", localObject2));
        ((JSONObject)localObject1).put("redDotPath", localObject2);
      }
      String str = MainProcessIPCService.PROCESS_NAME;
      localObject2 = ((JSONObject)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      XIPCInvoker.a(str, new GetFinderRedDotData((String)localObject1), a.class, new JsApiGetFinderRedDot..ExternalSyntheticLambda0(paramh, paramp));
    }
    catch (Exception paramh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetFinderRedDot", (Throwable)paramh, "handleMsg exception", new Object[0]);
      }
    }
    AppMethodBeat.o(297618);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot$GetFinderRedDotData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class GetFinderRedDotData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(297766);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297766);
    }
    
    public GetFinderRedDotData(Parcel paramParcel)
    {
      AppMethodBeat.i(297759);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(297759);
    }
    
    public GetFinderRedDotData(String paramString)
    {
      AppMethodBeat.i(297750);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(297750);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297775);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(297775);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot$GetFinderRedDotData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot$GetFinderRedDotData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot$GetFinderRedDotData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiGetFinderRedDot.GetFinderRedDotData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot$GetFinderRedDotTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetFinderRedDot$GetFinderRedDotData;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiGetFinderRedDot.GetFinderRedDotData, IPCString>
  {
    private static final void a(f paramf, String paramString)
    {
      AppMethodBeat.i(297786);
      if (paramf != null)
      {
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramf.onCallback(new IPCString(str));
      }
      AppMethodBeat.o(297786);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiGetFinderRedDot
 * JD-Core Version:    0.7.0.1
 */