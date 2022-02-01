package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.ap;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.protocal.protobuf.ghw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/fts/ChatSearchLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "THREAD_TAG", "mJSCallback", "Lcom/tencent/mm/plugin/webview/fts/PreGetController$JSCallback;", "getCgiAction", "content", "getChatSearchData", "", "params", "", "", "getSessionId", "url", "onDataBack", "", "tag", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportAction", "action", "sessionId", "cgiRet", "cgiAction", "start", "stop", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  private static final String TAG;
  private static final String THREAD_TAG;
  public static final a WAv;
  private static final h.a WAw;
  
  static
  {
    AppMethodBeat.i(295667);
    WAv = new a();
    TAG = "MicroMsg.WebSearch.ChatSearchLogic";
    THREAD_TAG = "WebSearch.ChatSearchLogic";
    WAw = a..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(295667);
  }
  
  private static final void a(w paramw)
  {
    AppMethodBeat.i(295660);
    kotlin.g.b.s.u(paramw, "$model");
    Object localObject = new ab(paramw);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    localObject = paramw.Wow;
    kotlin.g.b.s.s(localObject, "model.imageSearchSessionId");
    c(6, (String)localObject, paramw.scene, 0, bjD(paramw.content));
    AppMethodBeat.o(295660);
  }
  
  private static final void a(h.b paramb)
  {
    AppMethodBeat.i(295665);
    if (((paramb.WBq instanceof w)) && ((paramb.WBr instanceof String)))
    {
      Object localObject1 = paramb.WBq;
      if (localObject1 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.websearch.api.NetSceneRequestModel");
        AppMethodBeat.o(295665);
        throw paramb;
      }
      Object localObject2 = (w)localObject1;
      localObject1 = k.auP(((w)localObject2).hVk);
      paramb = paramb.WBr;
      if (paramb == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(295665);
        throw paramb;
      }
      paramb = (String)paramb;
      localObject2 = ((w)localObject2).hOG;
      Bundle localBundle = new Bundle();
      localBundle.putString("fts_key_json_data", paramb);
      localBundle.putString("fts_key_req_id", (String)localObject2);
      try
      {
        if (((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb != null) {
          ((com.tencent.mm.plugin.webview.ui.tools.jsapi.j)localObject1).WFb.i(127, localBundle);
        }
        AppMethodBeat.o(295665);
        return;
      }
      catch (RemoteException paramb)
      {
        Log.w("MicroMsg.MsgHandler", "onChatSearchDataReady exception" + paramb.getMessage());
      }
    }
    AppMethodBeat.o(295665);
  }
  
  private static String bjC(String paramString)
  {
    AppMethodBeat.i(295647);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(295647);
      return "";
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("sessionId");
      if (paramString == null)
      {
        AppMethodBeat.o(295647);
        return "";
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(295647);
      return "";
    }
    AppMethodBeat.o(295647);
    return paramString;
  }
  
  private static String bjD(String paramString)
  {
    AppMethodBeat.i(295650);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(295650);
      return "";
    }
    try
    {
      paramString = new JSONObject(paramString).optString("action");
      if (paramString == null)
      {
        AppMethodBeat.o(295650);
        return "";
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(295650);
      return "";
    }
    AppMethodBeat.o(295650);
    return paramString;
  }
  
  public static boolean bz(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(295644);
    kotlin.g.b.s.u(paramMap, "params");
    Log.i(TAG, "start getChatSearchData：%s", new Object[] { paramMap });
    w localw = new w();
    localw.scene = aj.c(paramMap, "scene", 0);
    localw.hOG = aj.au(paramMap, "requestId");
    localw.Wou = aj.c(paramMap, "type", 0);
    localw.hVk = aj.c(paramMap, "webview_instance_id", -1);
    localw.Wow = bjC(aj.au(paramMap, "url"));
    paramMap = aj.au(paramMap, "params");
    CharSequence localCharSequence = (CharSequence)paramMap;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramMap = new JSONObject(paramMap);
        localw.hAT = paramMap.optString("reqKey", "");
        localw.content = paramMap.optString("content", "");
      }
      if (TextUtils.isEmpty((CharSequence)localw.content)) {
        break label259;
      }
      paramMap = localw.content;
      kotlin.g.b.s.s(paramMap, "model.content");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localw.content))
      {
        g.ivX();
        paramMap = h.aHT(localw.content);
        kotlin.g.b.s.s(paramMap, "getFTSWebSearchLogic().p…ContentKey(model.content)");
      }
      g.ivX().WBQ.a(0, paramMap, localw, new a..ExternalSyntheticLambda1(localw), WAw);
      AppMethodBeat.o(295644);
      return false;
      i = 0;
      break;
      label259:
      paramMap = localw.hOG;
      kotlin.g.b.s.s(paramMap, "model.requestId");
    }
  }
  
  private static void c(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(295654);
    ap localap = new ap();
    localap.ilm = paramInt1;
    localap.imW = paramInt2;
    localap.kE("");
    localap.kF("");
    localap.imM = 0;
    localap.kC(paramString1);
    localap.ipe = System.currentTimeMillis();
    localap.ipf = paramInt3;
    localap.ipg = localap.F("CgiAction", paramString2, true);
    localap.bMH();
    as.a((com.tencent.mm.plugin.report.a)localap);
    AppMethodBeat.o(295654);
  }
  
  private static void og(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295656);
    g.ivX().WBQ.a(0, paramString2, paramString1, WAw);
    AppMethodBeat.o(295656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(295684);
    if ((paramp instanceof ab)) {
      if (!TextUtils.isEmpty((CharSequence)((ab)paramp).WnS.content))
      {
        paramString = ((ab)paramp).WnS.content;
        kotlin.g.b.s.s(paramString, "scene.model.content");
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)((ab)paramp).WnS.content))
      {
        g.ivX();
        paramString = h.aHT(((ab)paramp).WnS.content);
        kotlin.g.b.s.s(paramString, "getFTSWebSearchLogic().p…tKey(scene.model.content)");
      }
      ghw localghw = ((ab)paramp).WoC;
      Object localObject1 = ((ab)paramp).WnS;
      Object localObject2;
      int i;
      if ((localghw != null) && (localObject1 != null))
      {
        localObject2 = (CharSequence)((w)localObject1).Wow;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          label157:
          if (i == 0)
          {
            localObject2 = ((w)localObject1).Wow;
            kotlin.g.b.s.s(localObject2, "model.imageSearchSessionId");
            c(7, (String)localObject2, ((w)localObject1).scene, paramInt2, bjD(((w)localObject1).content));
          }
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            break label333;
          }
          Log.i(TAG, "net scene fail requestId:" + ((ab)paramp).WnS.hOG + " reqKey:" + ((ab)paramp).WnS.hAT);
          paramp = new JSONObject();
        }
      }
      try
      {
        paramp.put("ret", -1);
        label277:
        paramp = paramp.toString();
        kotlin.g.b.s.s(paramp, "resultObject.toString()");
        og(paramp, paramString);
        AppMethodBeat.o(295684);
        return;
        paramString = ((ab)paramp).WnS.hOG;
        kotlin.g.b.s.s(paramString, "scene.model.requestId");
        continue;
        i = 0;
        break label157;
        label333:
        localObject1 = TAG;
        localObject2 = new StringBuilder("net scene success requestId:").append(((ab)paramp).WnS.hOG).append(" reqKey:").append(((ab)paramp).WnS.hAT).append(" jsonStr:");
        paramp = localghw.YQb;
        if (paramp == null) {}
        for (paramp = null;; paramp = Integer.valueOf(paramp.length()))
        {
          Log.i((String)localObject1, paramp);
          paramp = localghw.YQb;
          kotlin.g.b.s.s(paramp, "response.json_str");
          og(paramp, paramString);
          AppMethodBeat.o(295684);
          return;
        }
      }
      catch (Exception localException)
      {
        break label277;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */