package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openFinderDetailView", "extInfo", "OpenFinderViewTask", "OpenFinderViewTaskData", "plugin-webview_release"})
public final class JsApiOpenFinderView
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 369;
  public static final JsApiOpenFinderView Qvx;
  private static final String fXz = "openFinderView";
  
  static
  {
    AppMethodBeat.i(228217);
    Qvx = new JsApiOpenFinderView();
    IIl = 369;
    fXz = "openFinderView";
    AppMethodBeat.o(228217);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final n paramn)
  {
    AppMethodBeat.i(228215);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.i("MicroMsg.JsApiOpenFinderView", "alvinfluo openFinderView");
    String str2 = (String)paramn.params.get("extInfo");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    Log.d("MicroMsg.JsApiOpenFinderView", "alvinluo openFinderView extInfo: %s", new Object[] { str1 });
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new OpenFinderViewTaskData(str1), a.class, (com.tencent.mm.ipcinvoker.f)new b(paramf, paramn));
    AppMethodBeat.o(228215);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"})
  static final class OpenFinderViewTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(216432);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(216432);
    }
    
    public OpenFinderViewTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(216431);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(216431);
    }
    
    public OpenFinderViewTaskData(String paramString)
    {
      AppMethodBeat.i(216430);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(216430);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(216428);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(216428);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "plugin-webview_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenFinderView.OpenFinderViewTaskData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements d<JsApiOpenFinderView.OpenFinderViewTaskData, IPCBoolean>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.f<IPCBoolean>
  {
    b(com.tencent.mm.plugin.webview.d.f paramf, n paramn) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderView
 * JD-Core Version:    0.7.0.1
 */