package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openLiteApp", "appId", "OpenLiteAppData", "OpenLiteAppTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiOpenLiteApp
  extends a
{
  private static final int OOk;
  public static final JsApiOpenLiteApp XnD;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297602);
    XnD = new JsApiOpenLiteApp();
    OOk = 388;
    idA = "openLiteApp";
    AppMethodBeat.o(297602);
  }
  
  private static boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, String paramString)
  {
    AppMethodBeat.i(297586);
    Log.d("MicroMsg.JsApiOpenLiteApp", "OpenLiteApp appId: %s", new Object[] { paramString });
    Object localObject1 = paramp.WEI;
    Bundle localBundle = new Bundle();
    String str1 = "";
    String str2 = "";
    localBundle.putString("appId", paramString);
    for (;;)
    {
      try
      {
        if (((JSONObject)localObject1).has("page"))
        {
          str1 = ((JSONObject)localObject1).getString("page");
          s.s(str1, "params.getString(ILiteAppConstants.PAGE)");
          localBundle.putString("path", str1);
        }
        if (!((JSONObject)localObject1).has("checkUpdate")) {
          break label521;
        }
        bool1 = ((JSONObject)localObject1).getBoolean("checkUpdate");
        if (!((JSONObject)localObject1).has("syncCheckUpdate")) {
          break label515;
        }
        bool2 = ((JSONObject)localObject1).getBoolean("syncCheckUpdate");
        if (((JSONObject)localObject1).has("query"))
        {
          str2 = ((JSONObject)localObject1).getJSONObject("query").toString();
          s.s(str2, "params.getJSONObject(ILi…nstants.QUERY).toString()");
          localBundle.putString("query", str2);
        }
        if ((((JSONObject)localObject1).has("transparent")) && (((JSONObject)localObject1).getBoolean("transparent"))) {
          localBundle.putBoolean("transparent", true);
        }
        if (((JSONObject)localObject1).has("mode"))
        {
          localObject2 = ((JSONObject)localObject1).getString("mode");
          if (!Util.isNullOrNil((String)localObject2)) {
            localBundle.putString("mode", (String)localObject2);
          }
        }
        if (((JSONObject)localObject1).has("sheet_height"))
        {
          localObject1 = ((JSONObject)localObject1).getString("sheet_height");
          if (!Util.isNullOrNil((String)localObject1)) {
            localBundle.putString("sheet_height", (String)localObject1);
          }
        }
        localBundle.putInt("nextAnimIn", com.tencent.mm.plugin.webview.c.a.slide_right_in);
        localBundle.putInt("currentAnimOut", com.tencent.mm.plugin.webview.c.a.slide_right_out);
        localObject1 = new StringBuilder();
        Object localObject2 = ((StringBuilder)localObject1).append(paramString).append(",").append(str1).append(",").append(str2).append(",");
        if (bool1)
        {
          i = 1;
          ((StringBuilder)localObject2).append(i);
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(20980, ((StringBuilder)localObject1).toString());
          com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 89L, 1L);
          Log.i("MicroMsg.JsApiOpenLiteApp", "open liteapp:" + paramString + ", page:" + str1 + ", query" + str2 + ", checkUpdate:" + bool1 + ", syncCheckUpdate:" + bool2);
          XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new OpenLiteAppData(localBundle, bool1, bool2), a.class, new JsApiOpenLiteApp..ExternalSyntheticLambda0(paramh, paramp));
          AppMethodBeat.o(297586);
          return true;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenLiteApp", (Throwable)paramString, "", new Object[0]);
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ": fail"), null);
        AppMethodBeat.o(297586);
        return false;
      }
      int i = 0;
      continue;
      label515:
      boolean bool2 = false;
      continue;
      label521:
      boolean bool1 = false;
    }
  }
  
  private static final void f(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(297598);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    if (paramIPCBoolean.value)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ": success"), null);
      AppMethodBeat.o(297598);
      return;
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ": fail open liteapp"), null);
    AppMethodBeat.o(297598);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297625);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiOpenLiteApp", "OpenLiteApp");
    if (paramp.params.get("appId") == null)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ": fail expected appId"), null);
      AppMethodBeat.o(297625);
      return false;
    }
    Object localObject = paramp.params.get("appId");
    if (localObject == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297625);
      throw paramh;
    }
    boolean bool = a(paramh, paramp, (String)localObject);
    AppMethodBeat.o(297625);
    return bool;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppData;", "Landroid/os/Parcelable;", "bundle", "Landroid/os/Bundle;", "checkUpdate", "", "syncCheckUpdate", "(Landroid/os/Bundle;ZZ)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "getCheckUpdate", "()Z", "setCheckUpdate", "(Z)V", "getSyncCheckUpdate", "setSyncCheckUpdate", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class OpenLiteAppData
    implements Parcelable
  {
    public static final a CREATOR;
    boolean XnE;
    boolean XnF;
    Bundle bundle;
    
    static
    {
      AppMethodBeat.i(297672);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(297672);
    }
    
    public OpenLiteAppData(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(297662);
      this.bundle = new Bundle();
      this.bundle = paramBundle;
      this.XnE = paramBoolean1;
      this.XnF = paramBoolean2;
      AppMethodBeat.o(297662);
    }
    
    public OpenLiteAppData(Parcel paramParcel)
    {
      AppMethodBeat.i(297670);
      this.bundle = new Bundle();
      Bundle localBundle2 = paramParcel.readBundle();
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      this.bundle = localBundle1;
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.XnE = bool1;
        if (paramParcel.readByte() == 0) {
          break label97;
        }
      }
      label97:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.XnF = bool1;
        AppMethodBeat.o(297670);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(297674);
      s.u(paramParcel, "parcel");
      paramParcel.writeBundle(this.bundle);
      if (this.XnE)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.XnF) {
          break label62;
        }
      }
      label62:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(297674);
        return;
        paramInt = 0;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppData;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiOpenLiteApp.OpenLiteAppData>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<JsApiOpenLiteApp.OpenLiteAppData, IPCBoolean>
  {
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenLiteApp$OpenLiteAppTask$invoke$1", "Lcom/tencent/mm/plugin/lite/api/ILiteAppService$StartLiteAppCallback;", "fail", "", "success", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.lite.api.c.a
    {
      a(ah.a parama) {}
      
      public final void csx()
      {
        AppMethodBeat.i(297696);
        Log.i("MicroMsg.JsApiOpenLiteApp", "JsApiOpenLiteApp success");
        this.XnG.aiwY = true;
        AppMethodBeat.o(297696);
      }
      
      public final void csy()
      {
        AppMethodBeat.i(297701);
        Log.i("MicroMsg.JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
        this.XnG.aiwY = false;
        AppMethodBeat.o(297701);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenLiteApp
 * JD-Core Version:    0.7.0.1
 */