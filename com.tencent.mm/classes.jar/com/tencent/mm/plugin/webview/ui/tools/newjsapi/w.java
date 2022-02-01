package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.VerifyPwdUI;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestVerifyPwd;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_VERIFY_WX_PWD", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestVerifyWxPwd", "plugin-webview_release"})
public final class w
  extends a
  implements MMActivity.a
{
  private static final int IIl = 398;
  private static n Qqe;
  private static f QvF;
  private static final int QvH = 1000;
  public static final w QvI;
  private static final String TAG = "MicroMsg.JsApiRequestVertifyPwd";
  private static final String fXz = "verifiyWXPassword";
  
  static
  {
    AppMethodBeat.i(267589);
    QvI = new w();
    TAG = "MicroMsg.JsApiRequestVertifyPwd";
    QvH = 1000;
    IIl = 398;
    fXz = "verifiyWXPassword";
    AppMethodBeat.o(267589);
  }
  
  private static void a(f paramf, n paramn, int paramInt, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(267586);
    if (paramf == null)
    {
      AppMethodBeat.o(267586);
      return;
    }
    if (paramn == null)
    {
      AppMethodBeat.o(267586);
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
      paramf.PNo.h(paramn.POu, paramn.function + ":" + paramMap, localMap);
      AppMethodBeat.o(267586);
      return;
    }
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(267581);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.i(TAG, "JsApiRequestVerifyPwd");
    QvF = paramf;
    Qqe = paramn;
    if ((paramf.context instanceof MMActivity))
    {
      paramn = paramf.context;
      if (paramn == null)
      {
        paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(267581);
        throw paramf;
      }
      ((MMActivity)paramn).mmSetOnActivityResultCallback((MMActivity.a)this);
    }
    paramn = new Intent(paramf.context, VerifyPwdUI.class);
    paramn.putExtra("key_scenen", 0);
    if ((paramf.context instanceof MMActivity))
    {
      paramf = paramf.context;
      if (paramf == null)
      {
        paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(267581);
        throw paramf;
      }
      ((MMActivity)paramf).startActivityForResult(paramn, QvH);
    }
    AppMethodBeat.o(267581);
    return true;
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(267584);
    String str = TAG;
    Object localObject = new StringBuilder("JsApiRequestVerifyPwd onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(str, bool);
      if ((paramInt2 != -1) || (paramIntent == null) || (paramInt1 != QvH)) {
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
      a(QvF, Qqe, 0, (Map)localObject);
      AppMethodBeat.o(267584);
      return;
    }
    a(QvF, Qqe, -1, null);
    AppMethodBeat.o(267584);
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.w
 * JD-Core Version:    0.7.0.1
 */