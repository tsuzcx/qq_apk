package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openFinderDetailView", "extInfo", "OpenFinderDetailViewTask", "OpenFinderDetailViewTaskData", "plugin-webview_release"})
public final class JsApiOpenFinderDetailView
  extends a
{
  private static final int Bpa = 369;
  public static final JsApiOpenFinderDetailView Lwe;
  private static final String dAn = "openFinderDetailView";
  
  static
  {
    AppMethodBeat.i(197223);
    Lwe = new JsApiOpenFinderDetailView();
    Bpa = 369;
    dAn = "openFinderDetailView";
    AppMethodBeat.o(197223);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(197222);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    ad.i("MicroMsg.JsApiOpenFinderDetailView", "alvinfluo openFinderDetailView");
    String str2 = (String)paraml.uLu.get("extInfo");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    ad.d("MicroMsg.JsApiOpenFinderDetailView", "alvinluo openFinderDetailView extInfo: %s", new Object[] { str1 });
    XIPCInvoker.a("com.tencent.mm", new OpenFinderDetailViewTaskData(str1), a.class, (com.tencent.mm.ipcinvoker.d)new b(paramd, paraml));
    AppMethodBeat.o(197222);
    return true;
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView$OpenFinderDetailViewTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"})
  static final class OpenFinderDetailViewTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(197220);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(197220);
    }
    
    public OpenFinderDetailViewTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(197219);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(197219);
    }
    
    public OpenFinderDetailViewTaskData(String paramString)
    {
      AppMethodBeat.i(197218);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(197218);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(197217);
      k.h(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(197217);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView$OpenFinderDetailViewTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView$OpenFinderDetailViewTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView$OpenFinderDetailViewTaskData;", "plugin-webview_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenFinderDetailView.OpenFinderDetailViewTaskData>
    {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView$OpenFinderDetailViewTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderDetailView$OpenFinderDetailViewTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements b<JsApiOpenFinderDetailView.OpenFinderDetailViewTaskData, IPCBoolean>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean>
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderDetailView
 * JD-Core Version:    0.7.0.1
 */