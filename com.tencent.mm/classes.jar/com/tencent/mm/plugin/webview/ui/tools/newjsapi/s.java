package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_SUBSCRIBE_MSG", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "errMsg", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestSubscribeMessage", "plugin-webview_release"})
public final class s
  extends a
  implements MMActivity.a
{
  private static final int CDJ = 395;
  private static n JsF;
  private static f JxI;
  public static final s JxJ;
  private static final String edq = "requestSubscribeMessage";
  
  static
  {
    AppMethodBeat.i(210665);
    JxJ = new s();
    CDJ = 395;
    edq = "requestSubscribeMessage";
    AppMethodBeat.o(210665);
  }
  
  private static void a(f paramf, n paramn, int paramInt, String paramString, Map<String, ? extends Object> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(210664);
    p.h(paramString, "errMsg");
    if (paramf == null)
    {
      AppMethodBeat.o(210664);
      return;
    }
    if (paramn == null)
    {
      AppMethodBeat.o(210664);
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
          break label147;
        }
      }
    }
    label147:
    label180:
    for (;;)
    {
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":" + paramString, localMap);
      AppMethodBeat.o(210664);
      return;
      paramInt = 0;
      break;
      paramString = "ok";
      continue;
      if (((CharSequence)paramString).length() > 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label180;
        }
        paramString = "unknown error";
        break;
      }
    }
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210662);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage");
    JxI = paramf;
    JsF = paramn;
    String str = (String)paramn.params.get("appId");
    Object localObject1 = (String)paramn.params.get("extInfo");
    Object localObject3 = (String)paramn.params.get("templateIdList");
    Object localObject2 = new ArrayList();
    int i;
    int j;
    if (localObject3 != null)
    {
      localObject3 = new JSONArray((String)localObject3);
      i = 0;
      j = ((JSONArray)localObject3).length();
    }
    for (;;)
    {
      Object localObject4;
      if (i < j)
      {
        localObject4 = ((JSONArray)localObject3).get(i);
        if (!(localObject4 instanceof String)) {
          a(paramf, paramn, 10004, ":fail templateId invalid", null);
        }
      }
      else
      {
        if (!((ArrayList)localObject2).isEmpty()) {
          break;
        }
        a(paramf, paramn, 10001, ":fail templateIdList empty", null);
        AppMethodBeat.o(210662);
        return true;
      }
      ((ArrayList)localObject2).add(localObject4);
      i += 1;
    }
    if ((paramf.context instanceof MMActivity))
    {
      paramn = paramf.context;
      if (paramn == null)
      {
        paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(210662);
        throw paramf;
      }
      ((MMActivity)paramn).mmSetOnActivityResultCallback((MMActivity.a)this);
    }
    paramn = new Bundle();
    paramn.putString("key_extra_info", (String)localObject1);
    paramn.putBoolean("key_need_result", true);
    paramn.putStringArrayList("key_template_id_list", (ArrayList)localObject2);
    localObject1 = (ISubscribeMsgService)g.af(ISubscribeMsgService.class);
    localObject2 = paramf.context;
    paramf = str;
    if (str == null) {
      paramf = "";
    }
    ((ISubscribeMsgService)localObject1).a((Context)localObject2, 2, 1000, paramf, paramn);
    AppMethodBeat.o(210662);
    return true;
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(210663);
    Object localObject1 = new StringBuilder("alvinluo requestSubscribeMessage onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.JsApiRequestSubscribeMessage", bool);
      if ((paramIntent == null) || (paramInt1 != 1000)) {
        break label335;
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
      if (localObject3 == null) {
        break label279;
      }
    }
    label279:
    for (Object localObject2 = Integer.valueOf(((ArrayList)localObject3).size());; localObject2 = null)
    {
      Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage onActivityResult errCode: %s, errMsg: %s, template size: %s, extData: %s", new Object[] { Integer.valueOf(paramInt1), localObject1, localObject2, paramIntent });
      localObject2 = new JSONObject();
      if (localObject3 == null) {
        break label285;
      }
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject3).next();
        String str = localSubscribeMsgTmpItem.ixM;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("status", localSubscribeMsgTmpItem.jyE);
        ((JSONObject)localObject2).put(str, localJSONObject.toString());
      }
      bool = false;
      break;
    }
    label285:
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put("templatesDetail", ((JSONObject)localObject2).toString());
    ((HashMap)localObject3).put("ext_info", paramIntent);
    a(JxI, JsF, paramInt1, (String)localObject1, (Map)localObject3);
    label335:
    AppMethodBeat.o(210663);
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.s
 * JD-Core Version:    0.7.0.1
 */