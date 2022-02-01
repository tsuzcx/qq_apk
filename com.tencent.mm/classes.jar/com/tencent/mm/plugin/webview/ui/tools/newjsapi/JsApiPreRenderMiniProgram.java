package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "convertVersionType", "envVersion", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "preRender", "extInfo", "preRenderMiniProgram", "PreRenderMiniProgramData", "PreRenderMiniProgramTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiPreRenderMiniProgram
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final JsApiPreRenderMiniProgram XnK;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297724);
    XnK = new JsApiPreRenderMiniProgram();
    OOk = 417;
    idA = "prerenderMiniProgram";
    AppMethodBeat.o(297724);
  }
  
  private static final void i(h paramh, p paramp, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(297697);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    if (paramIPCBoolean.value)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(297697);
      return;
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail open fail"), null);
    AppMethodBeat.o(297697);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297756);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.prerenderMiniProgram", "prerenderMiniProgram");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("referrerAppId", (String)paramp.params.get("referrerAppId"));
    ((JSONObject)localObject).put("targetAppId", (String)paramp.params.get("targetAppId"));
    ((JSONObject)localObject).put("path", (String)paramp.params.get("path"));
    ((JSONObject)localObject).put("envVersion", (String)paramp.params.get("envVersion"));
    localObject = ((JSONObject)localObject).toString();
    s.s(localObject, "extJson.toString()");
    Log.d("MicroMsg.prerenderMiniProgram", "OpenWeAppSilence extInfo: %s", new Object[] { localObject });
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PreRenderMiniProgramData((String)localObject), a.class, new JsApiPreRenderMiniProgram..ExternalSyntheticLambda0(paramh, paramp));
    AppMethodBeat.o(297756);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$PreRenderMiniProgramData;", "Landroid/os/Parcelable;", "extInfo", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class PreRenderMiniProgramData
    implements Parcelable
  {
    public static final a CREATOR;
    String extInfo;
    
    static
    {
      AppMethodBeat.i(297834);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297834);
    }
    
    public PreRenderMiniProgramData(Parcel paramParcel)
    {
      AppMethodBeat.i(297828);
      this.extInfo = "";
      String str = paramParcel.readString();
      paramParcel = str;
      if (str == null) {
        paramParcel = "";
      }
      this.extInfo = paramParcel;
      AppMethodBeat.o(297828);
    }
    
    public PreRenderMiniProgramData(String paramString)
    {
      AppMethodBeat.i(297816);
      this.extInfo = "";
      this.extInfo = paramString;
      AppMethodBeat.o(297816);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(297839);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.extInfo);
      AppMethodBeat.o(297839);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$PreRenderMiniProgramData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$PreRenderMiniProgramData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$PreRenderMiniProgramData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiPreRenderMiniProgram.PreRenderMiniProgramData>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$PreRenderMiniProgramTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$PreRenderMiniProgramData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiPreRenderMiniProgram.PreRenderMiniProgramData, IPCBoolean>
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPreRenderMiniProgram$preRender$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(297770);
      Log.i("MicroMsg.prerenderMiniProgram", "prerender mini pro fail,errCode:" + paramInt + ",errMsg:" + paramString);
      AppMethodBeat.o(297770);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(297763);
      Log.i("MicroMsg.prerenderMiniProgram", "prerender mini pro success!");
      AppMethodBeat.o(297763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiPreRenderMiniProgram
 * JD-Core Version:    0.7.0.1
 */