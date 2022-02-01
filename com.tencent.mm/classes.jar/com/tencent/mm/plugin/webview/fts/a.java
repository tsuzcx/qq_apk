package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.eem;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/fts/ChatSearchLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "THREAD_TAG", "getChatSearchData", "", "params", "", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "start", "stop", "plugin-webview_release"})
public final class a
  implements f
{
  public static final a DJE;
  private static final String TAG = "MicroMsg.WebSearch.ChatSearchLogic";
  private static final String tcK = "WebSearch.ChatSearchLogic";
  
  static
  {
    AppMethodBeat.i(207576);
    DJE = new a();
    TAG = "MicroMsg.WebSearch.ChatSearchLogic";
    tcK = "WebSearch.ChatSearchLogic";
    AppMethodBeat.o(207576);
  }
  
  public static boolean bd(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(207574);
    p.h(paramMap, "params");
    s locals = new s();
    locals.scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    locals.dwW = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "requestId");
    locals.DBs = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
    locals.dCT = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "webview_instance_id", -1);
    paramMap = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "params");
    CharSequence localCharSequence = (CharSequence)paramMap;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramMap = new JSONObject(paramMap);
        locals.dlu = paramMap.optString("reqKey", "");
        locals.content = paramMap.optString("content", "");
      }
      paramMap = new w(locals);
      g.aiU().b((n)paramMap);
      AppMethodBeat.o(207574);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(207575);
    final eem localeem;
    s locals;
    if ((paramn instanceof w))
    {
      localeem = ((w)paramn).eLX();
      locals = ((w)paramn).eLY();
      if ((localeem != null) && (locals != null)) {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "net scene fail requestId:" + ((w)paramn).eLY().dwW + " reqKey:" + ((w)paramn).eLY().dlu);
          paramString = new JSONObject();
        }
      }
    }
    try
    {
      paramString.put("ret", -1);
      label118:
      paramString = paramString.toString();
      p.g(paramString, "resultObject.toString()");
      c.c(tcK, (d.g.a.a)new a(locals, paramString));
      AppMethodBeat.o(207575);
      return;
      String str = TAG;
      paramn = new StringBuilder("net scene success requestId:").append(((w)paramn).eLY().dwW).append(" reqKey:").append(((w)paramn).eLY().dlu).append(" jsonStr:");
      paramString = localeem.FFt;
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.length());; paramString = null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(str, paramString);
        c.c(tcK, (d.g.a.a)new b(locals, localeem));
        AppMethodBeat.o(207575);
        return;
      }
    }
    catch (Exception paramn)
    {
      break label118;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(s params, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(s params, eem parameem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */