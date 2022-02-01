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
import d.g.b.p;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openFinderDetailView", "extInfo", "OpenFinderViewTask", "OpenFinderViewTaskData", "plugin-webview_release"})
public final class JsApiOpenFinderView
  extends a
{
  private static final int EkT = 369;
  public static final JsApiOpenFinderView EpI;
  private static final String dKm = "openFinderView";
  
  static
  {
    AppMethodBeat.i(207674);
    EpI = new JsApiOpenFinderView();
    EkT = 369;
    dKm = "openFinderView";
    AppMethodBeat.o(207674);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207673);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    ad.i("MicroMsg.JsApiOpenFinderView", "alvinfluo openFinderView");
    String str2 = (String)paraml.xaW.get("extInfo");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    ad.d("MicroMsg.JsApiOpenFinderView", "alvinluo openFinderView extInfo: %s", new Object[] { str1 });
    XIPCInvoker.a("com.tencent.mm", new OpenFinderViewTaskData(str1), a.class, (com.tencent.mm.ipcinvoker.d)new b(paramd, paraml));
    AppMethodBeat.o(207673);
    return true;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"})
  static final class OpenFinderViewTaskData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(207671);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(207671);
    }
    
    public OpenFinderViewTaskData(Parcel paramParcel)
    {
      AppMethodBeat.i(207670);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(207670);
    }
    
    public OpenFinderViewTaskData(String paramString)
    {
      AppMethodBeat.i(207669);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(207669);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(207668);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(207668);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "plugin-webview_release"})
    public static final class a
      implements Parcelable.Creator<JsApiOpenFinderView.OpenFinderViewTaskData>
    {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
  static final class a
    implements b<JsApiOpenFinderView.OpenFinderViewTaskData, IPCBoolean>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<IPCBoolean>
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderView
 * JD-Core Version:    0.7.0.1
 */