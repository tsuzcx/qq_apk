package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.protobuf.fao;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/fts/ChatSearchLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "THREAD_TAG", "mJSCallback", "Lcom/tencent/mm/plugin/webview/fts/PreGetController$JSCallback;", "getCgiAction", "content", "getChatSearchData", "", "params", "", "", "getSessionId", "url", "onDataBack", "", "tag", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportAction", "action", "sessionId", "cgiRet", "cgiAction", "start", "stop", "plugin-webview_release"})
public final class a
  implements i
{
  public static final h.a INN;
  public static final a INO;
  public static final String TAG = "MicroMsg.WebSearch.ChatSearchLogic";
  private static final String kWD = "WebSearch.ChatSearchLogic";
  
  static
  {
    AppMethodBeat.i(210305);
    INO = new a();
    TAG = "MicroMsg.WebSearch.ChatSearchLogic";
    kWD = "WebSearch.ChatSearchLogic";
    INN = (h.a)a.b.INQ;
    AppMethodBeat.o(210305);
  }
  
  private static String aXW(String paramString)
  {
    AppMethodBeat.i(210300);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210300);
      return "";
    }
    try
    {
      localObject = new JSONObject(paramString).optString("action");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      AppMethodBeat.o(210300);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(210300);
    }
    return "";
  }
  
  public static String avA(String paramString)
  {
    AppMethodBeat.i(210299);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210299);
      return "";
    }
    try
    {
      localObject = Uri.parse(paramString).getQueryParameter("sessionId");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      AppMethodBeat.o(210299);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(210299);
    }
    return "";
  }
  
  private static void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(210301);
    ab localab = new ab();
    localab.jK(paramInt1);
    localab.jM(paramInt2);
    localab.ig("");
    localab.ih("");
    localab.jN(0);
    localab.ie(paramString1);
    localab.bW(System.currentTimeMillis());
    localab.jO(paramInt3);
    localab.ij(paramString2);
    localab.bfK();
    ar.a((com.tencent.mm.plugin.report.a)localab);
    AppMethodBeat.o(210301);
  }
  
  private static void lR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210304);
    j localj = g.gdt();
    p.g(localj, "SubCoreTools.getFTSWebSearchLogic()");
    localj.gaB().a(0, paramString2, paramString1, INN);
    AppMethodBeat.o(210304);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(210303);
    if ((paramq instanceof aa)) {
      if (!TextUtils.isEmpty((CharSequence)((aa)paramq).fXN().content))
      {
        paramString = ((aa)paramq).fXN().content;
        p.g(paramString, "scene.model.content");
      }
    }
    for (;;)
    {
      fao localfao = ((aa)paramq).fXS();
      Object localObject1 = ((aa)paramq).fXN();
      Object localObject2;
      int i;
      if ((localfao != null) && (localObject1 != null))
      {
        localObject2 = (CharSequence)((v)localObject1).IDZ;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          label109:
          if (i == 0)
          {
            localObject2 = ((v)localObject1).IDZ;
            p.g(localObject2, "model.imageSearchSessionId");
            b(7, (String)localObject2, ((v)localObject1).scene, paramInt2, aXW(((v)localObject1).content));
          }
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            break label282;
          }
          Log.i(TAG, "net scene fail requestId:" + ((aa)paramq).fXN().dPI + " reqKey:" + ((aa)paramq).fXN().dDL);
          paramq = new JSONObject();
        }
      }
      try
      {
        paramq.put("ret", -1);
        label227:
        paramq = paramq.toString();
        p.g(paramq, "resultObject.toString()");
        lR(paramq, paramString);
        AppMethodBeat.o(210303);
        return;
        paramString = ((aa)paramq).fXN().dPI;
        p.g(paramString, "scene.model.requestId");
        continue;
        i = 0;
        break label109;
        label282:
        localObject1 = TAG;
        localObject2 = new StringBuilder("net scene success requestId:").append(((aa)paramq).fXN().dPI).append(" reqKey:").append(((aa)paramq).fXN().dDL).append(" jsonStr:");
        paramq = localfao.KRB;
        if (paramq != null) {}
        for (paramq = Integer.valueOf(paramq.length());; paramq = null)
        {
          Log.i((String)localObject1, paramq);
          paramq = localfao.KRB;
          p.g(paramq, "response.json_str");
          lR(paramq, paramString);
          AppMethodBeat.o(210303);
          return;
        }
      }
      catch (Exception localException)
      {
        break label227;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */