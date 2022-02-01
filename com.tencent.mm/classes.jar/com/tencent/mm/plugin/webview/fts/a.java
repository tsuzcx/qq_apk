package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/fts/ChatSearchLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "THREAD_TAG", "getChatSearchData", "", "params", "", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "start", "stop", "plugin-webview_release"})
public final class a
  implements f
{
  public static final a EbC;
  private static final String TAG = "MicroMsg.WebSearch.ChatSearchLogic";
  private static final String tnE = "WebSearch.ChatSearchLogic";
  
  static
  {
    AppMethodBeat.i(199332);
    EbC = new a();
    TAG = "MicroMsg.WebSearch.ChatSearchLogic";
    tnE = "WebSearch.ChatSearchLogic";
    AppMethodBeat.o(199332);
  }
  
  public static boolean bj(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(199330);
    p.h(paramMap, "params");
    s locals = new s();
    locals.scene = ad.b(paramMap, "scene", 0);
    locals.dyb = ad.A(paramMap, "requestId");
    locals.DTp = ad.b(paramMap, "type", 0);
    locals.dDY = ad.b(paramMap, "webview_instance_id", -1);
    paramMap = ad.A(paramMap, "params");
    CharSequence localCharSequence = (CharSequence)paramMap;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramMap = new JSONObject(paramMap);
        locals.dmw = paramMap.optString("reqKey", "");
        locals.content = paramMap.optString("content", "");
      }
      paramMap = new w(locals);
      g.ajj().b((n)paramMap);
      AppMethodBeat.o(199330);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(199331);
    final egd localegd;
    s locals;
    if ((paramn instanceof w))
    {
      localegd = ((w)paramn).ePG();
      locals = ((w)paramn).ePH();
      if ((localegd != null) && (locals != null)) {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ae.i(TAG, "net scene fail requestId:" + ((w)paramn).ePH().dyb + " reqKey:" + ((w)paramn).ePH().dmw);
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
      c.c(tnE, (d.g.a.a)new a(locals, paramString));
      AppMethodBeat.o(199331);
      return;
      String str = TAG;
      paramn = new StringBuilder("net scene success requestId:").append(((w)paramn).ePH().dyb).append(" reqKey:").append(((w)paramn).ePH().dmw).append(" jsonStr:");
      paramString = localegd.FXO;
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.length());; paramString = null)
      {
        ae.i(str, paramString);
        c.c(tnE, (d.g.a.a)new b(locals, localegd));
        AppMethodBeat.o(199331);
        return;
      }
    }
    catch (Exception paramn)
    {
      break label118;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(s params, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(s params, egd paramegd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */