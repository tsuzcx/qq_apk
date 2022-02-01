package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.plugin.websearch.webview.n;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.gid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchWebData;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryData;", "Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/IEmojiSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/emojisearch/ui/IEmojiSearchUIComponent;)V", "netSceneGetSearchShare", "Lcom/tencent/mm/plugin/websearch/api/NetSceneGetSearchShare;", "cancelSearchShare", "", "destroy", "getEmojiSearchUIComponent", "getSearchData", "paramStr", "", "getSearchShare", "paramsStr", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends n<amr>
{
  r WqB;
  
  public d(com.tencent.mm.plugin.websearch.a.a.d paramd)
  {
    super((e)paramd);
    AppMethodBeat.i(315042);
    com.tencent.mm.kernel.h.aZW().a(4614, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(4384, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(315042);
  }
  
  public final void aEN(String paramString)
  {
    AppMethodBeat.i(315055);
    kotlin.g.b.s.u(paramString, "paramStr");
    paramString = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramString.keys();
    kotlin.g.b.s.s(localIterator, "requestObj.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Map localMap = (Map)localHashMap;
      kotlin.g.b.s.s(str, "it");
      localMap.put(str, paramString.opt(str));
    }
    paramString = new com.tencent.mm.plugin.websearch.api.p(bt((Map)localHashMap));
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
    AppMethodBeat.o(315055);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(315079);
    super.destroy();
    com.tencent.mm.kernel.h.aZW().b(4614, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(4384, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(315079);
  }
  
  public final void iqA()
  {
    AppMethodBeat.i(315073);
    r localr = this.WqB;
    if (localr != null)
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localr);
      this.WqB = null;
    }
    AppMethodBeat.o(315073);
  }
  
  final com.tencent.mm.plugin.websearch.a.a.d iqz()
  {
    AppMethodBeat.i(315047);
    Object localObject = this.WrK;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.websearch.emojisearch.ui.IEmojiSearchUIComponent");
      AppMethodBeat.o(315047);
      throw ((Throwable)localObject);
    }
    localObject = (com.tencent.mm.plugin.websearch.a.a.d)localObject;
    AppMethodBeat.o(315047);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    AppMethodBeat.i(315070);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramp instanceof com.tencent.mm.plugin.websearch.api.p))
    {
      if (((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.hVk == ipD())
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Object localObject = ((com.tencent.mm.plugin.websearch.api.p)paramp).WnR;
          if (localObject == null)
          {
            paramString = null;
            if (paramString != null) {
              break label245;
            }
            paramString = ((d)this).iqz().iqC();
            if (paramString != null) {
              if (((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.offset != 0) {
                break label239;
              }
            }
          }
          label239:
          for (bool1 = bool2;; bool1 = false)
          {
            paramp = ((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.hOG;
            kotlin.g.b.s.s(paramp, "scene.model.requestId");
            paramString.h(bool1, "{\"ret\":-1}", paramp);
            AppMethodBeat.o(315070);
            return;
            paramString = iqz().iqC();
            if (paramString == null)
            {
              paramString = null;
              break;
            }
            if (((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.offset == 0) {}
            for (bool1 = true;; bool1 = false)
            {
              localObject = ((gid)localObject).aayd;
              kotlin.g.b.s.s(localObject, "it.Json");
              String str = ((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.hOG;
              kotlin.g.b.s.s(str, "scene.model.requestId");
              paramString.h(bool1, (String)localObject, str);
              paramString = ah.aiuX;
              break;
            }
          }
          label245:
          AppMethodBeat.o(315070);
          return;
        }
        paramString = iqz().iqC();
        if (paramString != null)
        {
          if (((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.offset == 0) {}
          for (;;)
          {
            paramp = ((com.tencent.mm.plugin.websearch.api.p)paramp).WnS.hOG;
            kotlin.g.b.s.s(paramp, "scene.model.requestId");
            paramString.h(bool1, "{\"ret\":-1}", paramp);
            AppMethodBeat.o(315070);
            return;
            bool1 = false;
          }
        }
      }
    }
    else if (((paramp instanceof r)) && (((r)paramp).WnW == ipD()) && (kotlin.g.b.s.p(paramp, this.WqB)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((r)paramp).WnV;
        if (paramString != null) {
          iqz().a(paramString, ((r)paramp).WnU.YWK);
        }
      }
      this.WqB = null;
    }
    AppMethodBeat.o(315070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.d
 * JD-Core Version:    0.7.0.1
 */