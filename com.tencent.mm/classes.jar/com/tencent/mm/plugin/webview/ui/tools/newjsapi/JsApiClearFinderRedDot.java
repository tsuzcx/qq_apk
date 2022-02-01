package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "ClearFinderRedDotData", "ClearFinderRedDotTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiClearFinderRedDot
  extends a
{
  private static final int OOk;
  public static final JsApiClearFinderRedDot XmL;
  public static final String idA;
  
  static
  {
    AppMethodBeat.i(297824);
    XmL = new JsApiClearFinderRedDot();
    OOk = 421;
    idA = "cleanFinderRedDot";
    AppMethodBeat.o(297824);
  }
  
  private static final void a(h paramh, p paramp, IPCInteger paramIPCInteger)
  {
    AppMethodBeat.i(297814);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("cleanRet", Integer.valueOf(paramIPCInteger.value));
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":success"), (Map)localHashMap);
    AppMethodBeat.o(297814);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297854);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiClearFinderRedDot", "cleanFinderRedDot");
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject2 = paramp.params.get("businessType");
      if (localObject2 != null)
      {
        Log.i("MicroMsg.JsApiClearFinderRedDot", s.X("businessType :", localObject2));
        ((JSONObject)localObject1).put("businessType", localObject2);
      }
      localObject2 = paramp.params.get("redDotPath");
      if (localObject2 != null)
      {
        Log.i("MicroMsg.JsApiClearFinderRedDot", s.X("redDotPath :", localObject2));
        ((JSONObject)localObject1).put("redDotPath", localObject2);
      }
      String str = MainProcessIPCService.PROCESS_NAME;
      localObject2 = ((JSONObject)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      XIPCInvoker.a(str, new ClearFinderRedDotData((String)localObject1), a.class, new JsApiClearFinderRedDot..ExternalSyntheticLambda0(paramh, paramp));
    }
    catch (Exception paramh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiClearFinderRedDot", (Throwable)paramh, "handleMsg exception", new Object[0]);
      }
    }
    AppMethodBeat.o(297854);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot$ClearFinderRedDotData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class ClearFinderRedDotData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(297656);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297656);
    }
    
    public ClearFinderRedDotData(Parcel paramParcel)
    {
      AppMethodBeat.i(297650);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(297650);
    }
    
    public ClearFinderRedDotData(String paramString)
    {
      AppMethodBeat.i(297645);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(297645);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297668);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(297668);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot$ClearFinderRedDotData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot$ClearFinderRedDotData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot$ClearFinderRedDotData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiClearFinderRedDot.ClearFinderRedDotData>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot$ClearFinderRedDotTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiClearFinderRedDot$ClearFinderRedDotData;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiClearFinderRedDot.ClearFinderRedDotData, IPCInteger>
  {
    private static final void a(f paramf, Integer paramInteger)
    {
      AppMethodBeat.i(297808);
      if (paramf != null) {
        if (paramInteger != null) {
          break label35;
        }
      }
      label35:
      for (int i = 0;; i = paramInteger.intValue())
      {
        paramf.onCallback(new IPCInteger(i));
        AppMethodBeat.o(297808);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiClearFinderRedDot
 * JD-Core Version:    0.7.0.1
 */