package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic;", "", "()V", "TAG", "", "genTagSearchUrl", "params", "", "putCommonUrlParams", "", "startTagSearchDialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "context", "Landroid/content/Context;", "talker", "enterType", "", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "query", "sessionId", "cursorIndex", "ui-websearch_release"})
public final class c
{
  public static final c IFY;
  public static final String TAG = "MicroMsg.WebSearch.TagSearchUILogic";
  
  static
  {
    AppMethodBeat.i(197950);
    IFY = new c();
    TAG = "MicroMsg.WebSearch.TagSearchUILogic";
    AppMethodBeat.o(197950);
  }
  
  public static String bf(Map<String, String> paramMap)
  {
    AppMethodBeat.i(197948);
    p.h(paramMap, "params");
    Object localObject = ai.afr(6);
    p.g(localObject, "WebSearchApiLogic.getSea….TEMPLATE_TYPE_TAGSEARCH)");
    localObject = ((at)localObject).fYv();
    bg(paramMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("?");
    localStringBuffer.append(ai.toUrlParams(paramMap));
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(197948);
    return paramMap;
  }
  
  public static void bg(Map<String, String> paramMap)
  {
    AppMethodBeat.i(197949);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    p.g(str, "LocaleUtil.getCurrentLan…tionContext.getContext())");
    paramMap.put("lang", str);
    paramMap.put("platform", "android");
    paramMap.put("version", String.valueOf(ai.aft(6)));
    str = ai.ait();
    p.g(str, "WebSearchApiLogic.getNetType()");
    paramMap.put("netType", str);
    str = BuildInfo.CLIENT_VERSION;
    p.g(str, "BuildInfo.CLIENT_VERSION");
    paramMap.put("wechatVersion", str);
    AppMethodBeat.o(197949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.c
 * JD-Core Version:    0.7.0.1
 */