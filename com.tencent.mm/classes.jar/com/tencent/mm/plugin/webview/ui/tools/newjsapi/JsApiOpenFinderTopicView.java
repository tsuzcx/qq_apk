package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openFinderTopicView", "extInfo", "OpenFinderTopicTask", "OpenFinderTopicTaskData", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenFinderTopicView
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final JsApiOpenFinderTopicView XnB;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297813);
    XnB = new JsApiOpenFinderTopicView();
    OOk = 392;
    idA = "openFinderTopicView";
    AppMethodBeat.o(297813);
  }
  
  private static final void d(h paramh, p paramp, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(297804);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    if (paramIPCBoolean.value)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(297804);
      return;
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail open fail"), null);
    AppMethodBeat.o(297804);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297852);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiOpenFinderTopicView", "OpenFinderTopicView");
    String str2 = (String)paramp.params.get("extInfo");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    Log.d("MicroMsg.JsApiOpenFinderTopicView", "OpenFinderTopicView extInfo: %s", new Object[] { str1 });
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new OpenFinderTopicTaskData(str1), a.class, new JsApiOpenFinderTopicView..ExternalSyntheticLambda0(paramh, paramp));
    AppMethodBeat.o(297852);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView$OpenFinderTopicTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class OpenFinderTopicTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(297853);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297853);
    }
    
    public OpenFinderTopicTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(297849);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(297849);
    }
    
    public OpenFinderTopicTaskData(String paramString)
    {
      AppMethodBeat.i(297845);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(297845);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297857);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(297857);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView$OpenFinderTopicTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView$OpenFinderTopicTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView$OpenFinderTopicTaskData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenFinderTopicView.OpenFinderTopicTaskData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView$OpenFinderTopicTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderTopicView$OpenFinderTopicTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiOpenFinderTopicView.OpenFinderTopicTaskData, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderTopicView
 * JD-Core Version:    0.7.0.1
 */