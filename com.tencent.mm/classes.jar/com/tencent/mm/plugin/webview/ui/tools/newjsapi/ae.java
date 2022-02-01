package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_SUBSCRIBE_MSG", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "errMsg", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestSubscribeMessage", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends a
  implements MMActivity.a
{
  private static final int OOk;
  private static p Xit;
  public static final ae XnS;
  private static WeakReference<com.tencent.mm.plugin.webview.jsapi.h> XnT;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297541);
    XnS = new ae();
    OOk = 395;
    idA = "requestSubscribeMessage";
    AppMethodBeat.o(297541);
  }
  
  private static void a(p paramp, int paramInt, String paramString, Map<String, ? extends Object> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(297537);
    if (paramp == null)
    {
      AppMethodBeat.o(297537);
      return;
    }
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("err_code", Integer.valueOf(paramInt));
    if (paramMap != null) {
      localMap.putAll(paramMap);
    }
    if (paramInt == 0) {
      if (((CharSequence)paramString).length() > 0)
      {
        paramInt = i;
        if (paramInt == 0) {
          break label161;
        }
      }
    }
    label161:
    label194:
    for (;;)
    {
      paramMap = XnT;
      if (paramMap != null)
      {
        paramMap = (com.tencent.mm.plugin.webview.jsapi.h)paramMap.get();
        if (paramMap != null)
        {
          paramMap = paramMap.WDy;
          if (paramMap != null) {
            paramMap.doCallback(paramp.WEH, paramp.function + ':' + paramString, localMap);
          }
        }
      }
      XnT = null;
      AppMethodBeat.o(297537);
      return;
      paramInt = 0;
      break;
      paramString = "ok";
      continue;
      if (((CharSequence)paramString).length() > 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label194;
        }
        paramString = "unknown error";
        break;
      }
    }
  }
  
  private final boolean m(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297528);
    String str = (String)paramp.params.get("appId");
    Object localObject1 = (String)paramp.params.get("extInfo");
    Object localObject3 = (String)paramp.params.get("templateIdList");
    Object localObject2 = new ArrayList();
    int i;
    int k;
    if (localObject3 != null)
    {
      localObject3 = new JSONArray((String)localObject3);
      i = 0;
      k = ((JSONArray)localObject3).length();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      Object localObject4 = ((JSONArray)localObject3).get(i);
      if (!(localObject4 instanceof String)) {
        a(paramp, 10004, ":fail templateId invalid", null);
      }
      do
      {
        if (!((ArrayList)localObject2).isEmpty()) {
          break;
        }
        a(paramp, 10001, ":fail templateIdList empty", null);
        AppMethodBeat.o(297528);
        return true;
        ((ArrayList)localObject2).add(localObject4);
      } while (j >= k);
      i = j;
    }
    if ((paramh.context instanceof MMActivity)) {
      ((MMActivity)paramh.context).mmSetOnActivityResultCallback((MMActivity.a)this);
    }
    paramp = new Bundle();
    paramp.putString("key_extra_info", (String)localObject1);
    paramp.putBoolean("key_need_result", true);
    paramp.putStringArrayList("key_template_id_list", (ArrayList)localObject2);
    localObject1 = (ISubscribeMsgService)com.tencent.mm.kernel.h.ax(ISubscribeMsgService.class);
    localObject2 = paramh.context;
    paramh = str;
    if (str == null) {
      paramh = "";
    }
    ((ISubscribeMsgService)localObject1).a((Context)localObject2, 2, 1000, paramh, paramp);
    AppMethodBeat.o(297528);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297559);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage");
    XnT = new WeakReference(paramh);
    Xit = paramp;
    boolean bool = m(paramh, paramp);
    AppMethodBeat.o(297559);
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
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(297566);
    Object localObject1 = new StringBuilder("alvinluo requestSubscribeMessage onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.JsApiRequestSubscribeMessage", bool);
      if ((paramIntent == null) || (paramInt1 != 1000)) {
        break label337;
      }
      localObject3 = paramIntent.getParcelableArrayListExtra("key_result_data");
      paramInt1 = paramIntent.getIntExtra("key_result_err_code", -1);
      localObject2 = paramIntent.getStringExtra("key_result_err_msg");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknown error";
      }
      localObject2 = paramIntent.getStringExtra("key_result_ext_data");
      paramIntent = (Intent)localObject2;
      if (localObject2 == null) {
        paramIntent = "";
      }
      if (localObject3 != null) {
        break label277;
      }
    }
    label277:
    for (Object localObject2 = null;; localObject2 = Integer.valueOf(((ArrayList)localObject3).size()))
    {
      Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage onActivityResult errCode: %s, errMsg: %s, template size: %s, extData: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramIntent });
      localObject2 = new JSONObject();
      if (localObject3 == null) {
        break label290;
      }
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (SubscribeMsgTmpItem)((Iterator)localObject3).next();
        String str = ((SubscribeMsgTmpItem)localObject4).nSg;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("status", ((SubscribeMsgTmpItem)localObject4).phW);
        localObject4 = ah.aiuX;
        ((JSONObject)localObject2).put(str, localJSONObject.toString());
      }
      bool = false;
      break;
    }
    label290:
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put("templatesDetail", ((JSONObject)localObject2).toString());
    ((HashMap)localObject3).put("ext_info", paramIntent);
    a(Xit, paramInt1, (String)localObject1, (Map)localObject3);
    label337:
    AppMethodBeat.o(297566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ae
 * JD-Core Version:    0.7.0.1
 */