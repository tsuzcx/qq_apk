package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.d;
import com.tencent.mm.openim.api.h.a;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenCustomerServiceChat;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "KEY_DISMISS_WEBVIEW", "", "KEY_EXTINFO", "KEY_SCENE", "TAG", "controlByte", "", "getControlByte", "()I", "dismissWebView", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "closeWebViewUIIfNeed", "", "handleMsg", "needShowErrToast", "scene", "onCallback", "errCode", "errMsg", "openCustomerServiceChat", "extInfo", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends a
{
  private static final int OOk;
  private static p Xit;
  private static com.tencent.mm.plugin.webview.jsapi.h Xnu;
  public static final w Xnv;
  private static boolean Xnw;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297782);
    Xnv = new w();
    OOk = 412;
    idA = "openCustomerServiceChat";
    AppMethodBeat.o(297782);
  }
  
  private static void af(int paramInt, String paramString)
  {
    AppMethodBeat.i(297753);
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_code", Integer.valueOf(paramInt));
    Object localObject1 = Xnu;
    e locale;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      locale = ((com.tencent.mm.plugin.webview.jsapi.h)localObject1).WDy;
      if (locale != null)
      {
        localObject1 = Xit;
        if (localObject1 != null) {
          break label118;
        }
        localObject1 = null;
        localStringBuilder = new StringBuilder();
        localObject2 = Xit;
        if (localObject2 != null) {
          break label126;
        }
      }
    }
    label118:
    label126:
    for (Object localObject2 = null;; localObject2 = ((p)localObject2).function)
    {
      locale.doCallback((String)localObject1, localObject2 + ':' + paramString, (Map)localHashMap);
      iBM();
      Xnu = null;
      AppMethodBeat.o(297753);
      return;
      localObject1 = ((p)localObject1).WEH;
      break;
    }
  }
  
  private static void iBM()
  {
    AppMethodBeat.i(297764);
    Object localObject = Xnu;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.webview.jsapi.h)localObject).context)
    {
      Log.v("MicroMsg.JsApiOpenCustomerServiceChat", "alvinluo closeWebViewUIIfNeed dismissWebView: %s, env: %s", new Object[] { Boolean.valueOf(Xnw), localObject });
      if ((Xnw) && ((localObject instanceof Activity)))
      {
        ((Activity)localObject).finish();
        ((Activity)localObject).overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(297764);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    int j = 0;
    AppMethodBeat.i(297826);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Xnu = paramh;
    Xit = paramp;
    String str2 = (String)paramp.params.get("extInfo");
    Object localObject = (CharSequence)str2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      af(1, "extInfo empty");
      AppMethodBeat.o(297826);
      return true;
    }
    String str1 = new JSONObject(str2).optString("url");
    localObject = paramp.params.get("scene");
    label141:
    boolean bool;
    if ((localObject instanceof Integer))
    {
      localObject = (Integer)localObject;
      if (localObject != null) {
        break label278;
      }
      i = 3;
      Xnw = s.p(paramp.params.get("dismissSelf"), "true");
      bool = Xnw;
      if ((i != 3) || (!bool)) {
        break label287;
      }
      bool = true;
      label178:
      Log.i("MicroMsg.JsApiOpenCustomerServiceChat", "alvinluo openCustomerServiceChat scene: %s, extInfo: %s, dismissWebView: %s, needShowErrToast: %s", new Object[] { paramp.params.get("scene"), str2, Boolean.valueOf(Xnw), Boolean.valueOf(bool) });
      paramp = (CharSequence)str1;
      if ((paramp == null) || (paramp.length() == 0)) {
        j = 1;
      }
      if (j == 0) {
        break label304;
      }
      Log.e("MicroMsg.JsApiOpenCustomerServiceChat", "alvinluo openCustomerServiceChat url invalid");
      af(1, "url empty");
    }
    for (;;)
    {
      AppMethodBeat.o(297826);
      return true;
      localObject = null;
      break;
      label278:
      i = ((Integer)localObject).intValue();
      break label141;
      label287:
      if (i == 4)
      {
        bool = true;
        break label178;
      }
      bool = false;
      break label178;
      label304:
      paramp = new OpenIMKefuStartConversationRequest();
      paramp.context = paramh.context;
      paramp.prw = i;
      paramh = new du();
      paramh.url = str1;
      paramh.YFV = str1;
      localObject = ah.aiuX;
      paramp.pry = paramh;
      paramp.prx = h.a.xD(paramp.prw);
      paramp.prz = bool;
      paramp.prA = paramp.context.getResources().getString(c.i.open_im_kefu_start_conversation_error_tips);
      paramp.prF = new Intent();
      paramh = paramp.prF;
      localObject = MMHandler.createFreeHandler(Looper.getMainLooper());
      s.s(localObject, "createFreeHandler(Looper.getMainLooper())");
      paramh.putExtra("key_result_receiver", (Parcelable)new OpenImKefuStartChattingResultReceiver((Handler)localObject, (OpenImKefuStartChattingResultReceiver.b)new w.a()));
      paramh = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (paramh != null) {
        paramh.a(paramp);
      }
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.w
 * JD-Core Version:    0.7.0.1
 */