package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestVerifyPwd;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_VERIFY_WX_PWD", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestVerifyWxPwd", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends a
  implements MMActivity.a
{
  private static final int OOk;
  private static final String TAG;
  private static p Xit;
  public static final af XnU;
  private static final int XnV;
  private static h Xnu;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297525);
    XnU = new af();
    TAG = "MicroMsg.JsApiRequestVertifyPwd";
    XnV = 208;
    OOk = 398;
    idA = "verifiyWXPassword";
    AppMethodBeat.o(297525);
  }
  
  private static void a(h paramh, p paramp, int paramInt, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(297522);
    if (paramh == null)
    {
      AppMethodBeat.o(297522);
      return;
    }
    if (paramp == null)
    {
      AppMethodBeat.o(297522);
      return;
    }
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("err_code", Integer.valueOf(paramInt));
    if (paramMap != null) {
      localMap.putAll(paramMap);
    }
    if (paramInt == 0) {}
    for (paramMap = "ok";; paramMap = "unknown error")
    {
      paramh.WDy.doCallback(paramp.WEH, paramp.function + ':' + paramMap, localMap);
      AppMethodBeat.o(297522);
      return;
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297545);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i(TAG, "JsApiRequestVerifyPwd");
    Xnu = paramh;
    Xit = paramp;
    if ((paramh.context instanceof MMActivity)) {
      ((MMActivity)paramh.context).mmSetOnActivityResultCallback((MMActivity.a)this);
    }
    paramp = new Intent(paramh.context, VerifyPwdUI.class);
    paramp.putExtra("key_scenen", 0);
    if ((paramh.context instanceof MMActivity)) {
      ((MMActivity)paramh.context).startActivityForResult(paramp, XnV);
    }
    AppMethodBeat.o(297545);
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
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(297550);
    String str = TAG;
    Object localObject = new StringBuilder("JsApiRequestVerifyPwd onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(str, bool);
      if ((paramInt2 != -1) || (paramIntent == null) || (paramInt1 != XnV)) {
        break;
      }
      str = paramIntent.getStringExtra("key_ticket");
      localObject = new HashMap();
      paramIntent = str;
      if (str == null) {
        paramIntent = "";
      }
      ((HashMap)localObject).put("ticket", paramIntent);
      ((HashMap)localObject).put("sucessful", "true");
      a(Xnu, Xit, 0, (Map)localObject);
      AppMethodBeat.o(297550);
      return;
    }
    a(Xnu, Xit, -1, null);
    AppMethodBeat.o(297550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.af
 * JD-Core Version:    0.7.0.1
 */