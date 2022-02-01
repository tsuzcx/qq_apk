package com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.f;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/webprefetcher/JsApiTransferRequestBase;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "getTransferType", "", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends a
{
  public static final a Xoh = new a((byte)0);
  
  public final boolean a(final com.tencent.mm.plugin.webview.jsapi.h paramh, final p paramp)
  {
    JSONObject localJSONObject = null;
    s.u(paramh, "env");
    s.u(paramp, "msg");
    try
    {
      Object localObject1 = i.Wya;
      if (i.a.gTR()) {
        Toast.makeText(paramh.context, (CharSequence)s.X(gPX(), " called"), 0).show();
      }
      localTransferRequestInfo = new TransferRequestInfo();
      localTransferRequestInfo.type = dgH();
      localObject1 = paramp.params.get("scope");
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localTransferRequestInfo.scope = ((String)localObject3);
        localObject1 = paramh.isj();
        if (localObject1 != null) {
          break label599;
        }
        localObject3 = null;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = paramh.WDz;
          if (localObject1 != null) {
            break label609;
          }
          localObject1 = "";
        }
        localTransferRequestInfo.url = ((String)localObject1);
        Object localObject4 = new dev();
        localObject1 = paramp.params.get("reqUrl");
        if (!(localObject1 instanceof String)) {
          break label632;
        }
        localObject1 = (String)localObject1;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        ((dev)localObject4).url = ((String)localObject3);
        localObject1 = paramp.params.get("reqBody");
        if (!(localObject1 instanceof String)) {
          break label638;
        }
        localObject1 = (String)localObject1;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        ((dev)localObject4).YSb = ((String)localObject3);
        localObject1 = paramp.params.get("cgiCmdId");
        if (!(localObject1 instanceof String)) {
          break label644;
        }
        localObject1 = (String)localObject1;
        ((dev)localObject4).aaKR = Util.safeParseInt((String)localObject1);
        localObject1 = paramp.params.get("method");
        if (!(localObject1 instanceof String)) {
          break label650;
        }
        localObject1 = (String)localObject1;
        ((dev)localObject4).method = Util.safeParseInt((String)localObject1);
        localObject1 = ah.aiuX;
        localTransferRequestInfo.vBl = ((dev)localObject4);
        try
        {
          localObject3 = paramp.params.get("header");
          localObject1 = localJSONObject;
          if (!(localObject3 instanceof String)) {
            break label661;
          }
          localObject1 = (String)localObject3;
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.JsApiTransferRequestBase", (Throwable)localException1, "parseTransferRequestInfo exception", new Object[0]);
          ((f)com.tencent.mm.kernel.h.ax(f.class)).a(localTransferRequestInfo, (g.a)new b(this, paramh, paramp));
          return true;
        }
        if (((CharSequence)localObject3).length() <= 0) {
          break label656;
        }
        i = 1;
        if (i != 0)
        {
          localJSONObject = new JSONObject((String)localObject3);
          localObject4 = localJSONObject.keys();
          s.s(localObject4, "headerJson.keys()");
          while (((Iterator)localObject4).hasNext())
          {
            String str = (String)((Iterator)localObject4).next();
            localObject3 = localJSONObject.optString(str);
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            localObject3 = localTransferRequestInfo.vBl.aaKS;
            czo localczo = new czo();
            localczo.key = str;
            localczo.value = ((String)localObject1);
            localObject1 = ah.aiuX;
            ((LinkedList)localObject3).push(localczo);
          }
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        TransferRequestInfo localTransferRequestInfo;
        int i;
        Log.printErrStackTrace("MicroMsg.JsApiTransferRequestBase", (Throwable)localException2, "showToast exception", new Object[0]);
        continue;
        Object localObject2 = null;
        continue;
        label599:
        Object localObject3 = ((BaseWebViewController)localObject2).getCurrentUrl();
        continue;
        label609:
        localObject3 = ((MMWebView)localObject2).getUrl();
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = "";
          continue;
          label632:
          localObject2 = null;
          continue;
          label638:
          localObject2 = null;
          continue;
          label644:
          localObject2 = null;
          continue;
          label650:
          localObject2 = null;
          continue;
          label656:
          i = 0;
          continue;
          label661:
          localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = "";
          }
        }
      }
    }
  }
  
  public abstract int dgH();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/webprefetcher/JsApiTransferRequestBase$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/webprefetcher/JsApiTransferRequestBase$handleMsg$1", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(c paramc, com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp) {}
    
    public final void a(String paramString, dew paramdew)
    {
      AppMethodBeat.i(297685);
      HashMap localHashMap = new HashMap();
      Object localObject2 = "[transferRequest-" + this.Xoi.gPX() + "] errMsg: %s, response: %s";
      Object localObject1;
      int i;
      if (paramdew == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.JsApiTransferRequestBase", (String)localObject2, new Object[] { paramString, localObject1 });
        if (paramdew == null) {
          break label409;
        }
        ((Map)localHashMap).put("errCode", Integer.valueOf(paramdew.ret));
        localObject2 = (Map)localHashMap;
        localObject1 = paramdew.Kuf;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((Map)localObject2).put("result", paramString);
        paramString = paramdew.aaKS;
        s.s(paramString, "response.header");
        if (((Collection)paramString).isEmpty()) {
          break label274;
        }
        i = 1;
        label154:
        if (i == 0) {
          break label298;
        }
        paramString = new JSONObject();
        localObject1 = paramdew.aaKS;
        s.s(localObject1, "response.header");
        localObject1 = ((Iterable)localObject1).iterator();
      }
      label274:
      label282:
      for (;;)
      {
        label191:
        if (!((Iterator)localObject1).hasNext()) {
          break label284;
        }
        localObject2 = (czo)((Iterator)localObject1).next();
        CharSequence localCharSequence = (CharSequence)((czo)localObject2).key;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label282;
          }
          paramString.put(((czo)localObject2).key, ((czo)localObject2).value);
          break label191;
          localObject1 = Integer.valueOf(paramdew.ret);
          break;
          i = 0;
          break label154;
        }
      }
      label284:
      ((Map)localHashMap).put("header", paramString);
      label298:
      if (paramdew.ret == 0)
      {
        paramh.WDy.doCallback(paramp.WEH, s.X(this.Xoi.gPX(), ":ok"), (Map)localHashMap);
        AppMethodBeat.o(297685);
        return;
      }
      paramh.WDy.doCallback(paramp.WEH, this.Xoi.gPX() + ":fail " + paramdew.error_msg, (Map)localHashMap);
      AppMethodBeat.o(297685);
      return;
      label409:
      ((Map)localHashMap).put("errCode", Integer.valueOf(-1));
      paramh.WDy.doCallback(paramp.WEH, s.X(this.Xoi.gPX(), ":fail"), (Map)localHashMap);
      AppMethodBeat.o(297685);
    }
    
    public final boolean a(TransferRequestInfo paramTransferRequestInfo)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher.c
 * JD-Core Version:    0.7.0.1
 */