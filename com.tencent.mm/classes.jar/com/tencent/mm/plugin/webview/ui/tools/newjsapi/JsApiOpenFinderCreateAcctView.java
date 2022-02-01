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
import com.tencent.mm.plugin.findersdk.a.ca.a;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "OpenFinderCreateAccountTask", "OpenFinderCreateAccountTaskData", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenFinderCreateAcctView
  extends a
{
  private static final int OOk;
  public static final JsApiOpenFinderCreateAcctView Xnx;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297719);
    Xnx = new JsApiOpenFinderCreateAcctView();
    OOk = 411;
    idA = "openFinderCreateAcctView";
    AppMethodBeat.o(297719);
  }
  
  private static final void a(h paramh, p paramp, IPCInteger paramIPCInteger)
  {
    AppMethodBeat.i(297714);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    HashMap localHashMap = new HashMap();
    switch (paramIPCInteger.value)
    {
    }
    for (;;)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":success"), (Map)localHashMap);
      AppMethodBeat.o(297714);
      return;
      ((Map)localHashMap).put("message", "创建成功");
      ((Map)localHashMap).put("code", Integer.valueOf(100));
      ((Map)localHashMap).put("err_msg", "openFinderCreateAcctView:ok");
      continue;
      ((Map)localHashMap).put("message", "用户取消");
      ((Map)localHashMap).put("code", Integer.valueOf(200));
      ((Map)localHashMap).put("err_msg", "openFinderCreateAcctView:cancel");
      continue;
      ((Map)localHashMap).put("message", "参数为空");
      ((Map)localHashMap).put("code", Integer.valueOf(300));
      ((Map)localHashMap).put("err_msg", "openFinderCreateAcctView:fail");
      continue;
      ((Map)localHashMap).put("message", "账号已存在");
      ((Map)localHashMap).put("code", Integer.valueOf(301));
      ((Map)localHashMap).put("err_msg", "openFinderCreateAcctView:fail");
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297738);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiOpenFinderCreateAcctView", "OpenFinderCreateAcctView");
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject2 = paramp.params.get("scene");
      if (localObject2 != null)
      {
        Log.i("MicroMsg.JsApiOpenFinderCreateAcctView", s.X("OpenFinderCreateAcctView scene :", localObject2));
        ((JSONObject)localObject1).put("scene", localObject2);
      }
      localObject2 = paramp.params.get("tipsWording");
      if (localObject2 != null)
      {
        Log.i("MicroMsg.JsApiOpenFinderCreateAcctView", s.X("OpenFinderCreateAcctView tipsWording :", localObject2));
        ((JSONObject)localObject1).put("tipsWording", localObject2);
      }
      String str = MainProcessIPCService.PROCESS_NAME;
      localObject2 = ((JSONObject)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      XIPCInvoker.a(str, new OpenFinderCreateAccountTaskData((String)localObject1), a.class, new JsApiOpenFinderCreateAcctView..ExternalSyntheticLambda0(paramh, paramp));
    }
    catch (Exception paramh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenFinderCreateAcctView", (Throwable)paramh, "handleMsg exception", new Object[0]);
      }
    }
    AppMethodBeat.o(297738);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class OpenFinderCreateAccountTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(297754);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297754);
    }
    
    public OpenFinderCreateAccountTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(297743);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(297743);
    }
    
    public OpenFinderCreateAccountTaskData(String paramString)
    {
      AppMethodBeat.i(297735);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(297735);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297760);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(297760);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTaskData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenFinderCreateAcctView.OpenFinderCreateAccountTaskData>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiOpenFinderCreateAcctView.OpenFinderCreateAccountTaskData, IPCInteger>
  {
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderCreateAcctView$OpenFinderCreateAccountTask$invoke$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "result", "(Ljava/lang/Integer;)V", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ca.a<Integer>
    {
      a(f<IPCInteger> paramf) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderCreateAcctView
 * JD-Core Version:    0.7.0.1
 */