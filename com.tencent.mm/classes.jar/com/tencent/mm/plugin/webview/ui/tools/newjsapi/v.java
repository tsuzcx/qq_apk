package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "REQUEST_CODE_SUBSCRIBE_MSG", "", "TAG", "", "controlByte", "getControlByte", "()I", "env", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "funcName", "getFuncName", "()Ljava/lang/String;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackJsApi", "", "errCode", "errMsg", "retMap", "", "", "handleMsg", "", "mmOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestSubscribeMessage", "plugin-webview_release"})
public final class v
  extends a
  implements MMActivity.a
{
  private static final int IIl = 395;
  private static n Qqe;
  public static final v QvG;
  private static WeakReference<f> SuN;
  private static final String fXz = "requestSubscribeMessage";
  
  static
  {
    AppMethodBeat.i(220561);
    QvG = new v();
    IIl = 395;
    fXz = "requestSubscribeMessage";
    AppMethodBeat.o(220561);
  }
  
  private static void a(n paramn, int paramInt, String paramString, Map<String, ? extends Object> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(292996);
    if (paramn == null)
    {
      AppMethodBeat.o(292996);
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
          break label159;
        }
      }
    }
    label159:
    label192:
    for (;;)
    {
      paramMap = SuN;
      if (paramMap != null)
      {
        paramMap = (f)paramMap.get();
        if (paramMap != null)
        {
          paramMap = paramMap.PNo;
          if (paramMap != null) {
            paramMap.h(paramn.POu, paramn.function + ":" + paramString, localMap);
          }
        }
      }
      SuN = null;
      AppMethodBeat.o(292996);
      return;
      paramInt = 0;
      break;
      paramString = "ok";
      continue;
      if (((CharSequence)paramString).length() > 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label192;
        }
        paramString = "unknown error";
        break;
      }
    }
  }
  
  private final boolean m(f paramf, n paramn)
  {
    AppMethodBeat.i(292995);
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
          a(paramn, 10004, ":fail templateId invalid", null);
        }
      }
      else
      {
        if (!((ArrayList)localObject2).isEmpty()) {
          break;
        }
        a(paramn, 10001, ":fail templateIdList empty", null);
        AppMethodBeat.o(292995);
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
        AppMethodBeat.o(292995);
        throw paramf;
      }
      ((MMActivity)paramn).mmSetOnActivityResultCallback((MMActivity.a)this);
    }
    paramn = new Bundle();
    paramn.putString("key_extra_info", (String)localObject1);
    paramn.putBoolean("key_need_result", true);
    paramn.putStringArrayList("key_template_id_list", (ArrayList)localObject2);
    localObject1 = (ISubscribeMsgService)com.tencent.mm.kernel.h.ae(ISubscribeMsgService.class);
    localObject2 = paramf.context;
    paramf = str;
    if (str == null) {
      paramf = "";
    }
    ((ISubscribeMsgService)localObject1).a((Context)localObject2, 2, 1000, paramf, paramn);
    AppMethodBeat.o(292995);
    return true;
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(220551);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.i("MicroMsg.JsApiRequestSubscribeMessage", "alvinluo requestSubscribeMessage");
    SuN = new WeakReference(paramf);
    Qqe = paramn;
    boolean bool = m(paramf, paramn);
    AppMethodBeat.o(220551);
    return bool;
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(220554);
    Object localObject1 = new StringBuilder("alvinluo requestSubscribeMessage onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.JsApiRequestSubscribeMessage", bool);
      if ((paramIntent == null) || (paramInt1 != 1000)) {
        break label332;
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
        String str = localSubscribeMsgTmpItem.lnb;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("status", localSubscribeMsgTmpItem.moi);
        ((JSONObject)localObject2).put(str, localJSONObject.toString());
      }
      bool = false;
      break;
    }
    label285:
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put("templatesDetail", ((JSONObject)localObject2).toString());
    ((HashMap)localObject3).put("ext_info", paramIntent);
    a(Qqe, paramInt1, (String)localObject1, (Map)localObject3);
    label332:
    AppMethodBeat.o(220554);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.v
 * JD-Core Version:    0.7.0.1
 */