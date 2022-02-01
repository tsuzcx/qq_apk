package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenCTID;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_OPEN_CTID", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends a
  implements MMActivity.a
{
  private static p Xit;
  public static final v Xns;
  private static final int Xnt;
  private static h Xnu;
  
  static
  {
    AppMethodBeat.i(297741);
    Xns = new v();
    Xnt = 212;
    AppMethodBeat.o(297741);
  }
  
  private static void a(p paramp, int paramInt, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(297736);
    Log.i("MicroMsg.JsApiOpenCTID", "callbackJsApi, msg:" + paramp + ", errCode:" + paramInt + "， retMap:" + paramMap);
    if (Xnu == null)
    {
      AppMethodBeat.o(297736);
      return;
    }
    if (paramp == null)
    {
      AppMethodBeat.o(297736);
      return;
    }
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("err_code", Integer.valueOf(paramInt));
    if (paramMap != null) {
      localMap.put("result", paramMap);
    }
    if (paramInt == 0) {}
    for (paramMap = "ok";; paramMap = "unknown error")
    {
      Object localObject = Xnu;
      if (localObject != null)
      {
        localObject = ((h)localObject).WDy;
        if (localObject != null) {
          ((e)localObject).doCallback(paramp.WEH, paramp.function + ':' + paramMap, localMap);
        }
      }
      Xnu = null;
      AppMethodBeat.o(297736);
      return;
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297751);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Xnu = paramh;
    Xit = paramp;
    Log.i("MicroMsg.JsApiOpenCTID", "jsapi call, params:%s", new Object[] { paramp.params });
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("cn.cyberIdentity.certification", "cn.wh.project.view.v.authorization.WAuthActivity"));
    localIntent.setFlags(8388608);
    Object localObject = paramp.params.get("orgID");
    if (localObject == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297751);
      throw paramh;
    }
    localIntent.putExtra("orgID", (String)localObject);
    localObject = paramp.params.get("appID");
    if (localObject == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297751);
      throw paramh;
    }
    localIntent.putExtra("appID", (String)localObject);
    localObject = paramp.params.get("bizSeq");
    if (localObject == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297751);
      throw paramh;
    }
    localIntent.putExtra("bizSeq", (String)localObject);
    paramp = paramp.params.get("type");
    if (paramp == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(297751);
      throw paramh;
    }
    localIntent.putExtra("type", (String)paramp);
    localIntent.putExtra("packageName", MMApplicationContext.getApplicationId());
    if ((paramh.context instanceof MMActivity))
    {
      ((MMActivity)paramh.context).mmSetOnActivityResultCallback((MMActivity.a)this);
      ((MMActivity)paramh.context).startActivityForResult(localIntent, Xnt);
    }
    AppMethodBeat.o(297751);
    return true;
  }
  
  public final String gPX()
  {
    return "openCTID";
  }
  
  public final int gPZ()
  {
    return 440;
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(297767);
    if (paramInt1 != Xnt)
    {
      AppMethodBeat.o(297767);
      return;
    }
    Object localObject = new StringBuilder("JsApiOpenCTID onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.JsApiOpenCTID", bool);
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      HashMap localHashMap = new HashMap();
      String str = paramIntent.getStringExtra("resultCode");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("resultCode", localObject);
      str = paramIntent.getStringExtra("resultDesc");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("resultDesc", localObject);
      str = paramIntent.getStringExtra("idCardAuthData");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("idCardAuthData", localObject);
      str = paramIntent.getStringExtra("certPwdData");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("certPwdData", localObject);
      localObject = paramIntent.getStringExtra("resultData");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
      localHashMap.put("resultData", paramIntent);
      a(Xit, 0, (Map)localHashMap);
      AppMethodBeat.o(297767);
      return;
    }
    a(Xit, -1, null);
    AppMethodBeat.o(297767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.v
 * JD-Core Version:    0.7.0.1
 */