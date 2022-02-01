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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic;", "", "()V", "TAG", "", "genTagSearchUrl", "params", "", "putCommonUrlParams", "", "startTagSearchDialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "context", "Landroid/content/Context;", "talker", "enterType", "", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "query", "sessionId", "cursorIndex", "ui-websearch_release"})
public final class c
{
  public static final c PAp;
  public static final String TAG = "MicroMsg.WebSearch.TagSearchUILogic";
  
  static
  {
    AppMethodBeat.i(198696);
    PAp = new c();
    TAG = "MicroMsg.WebSearch.TagSearchUILogic";
    AppMethodBeat.o(198696);
  }
  
  public static String aZ(Map<String, String> paramMap)
  {
    AppMethodBeat.i(198689);
    p.k(paramMap, "params");
    Object localObject = ai.anf(6);
    p.j(localObject, "WebSearchApiLogic.getSea….TEMPLATE_TYPE_TAGSEARCH)");
    localObject = ((at)localObject).gRg();
    ba(paramMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("?");
    localStringBuffer.append(ai.toUrlParams(paramMap));
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(198689);
    return paramMap;
  }
  
  public static void ba(Map<String, String> paramMap)
  {
    AppMethodBeat.i(198693);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    p.j(str, "LocaleUtil.getCurrentLan…tionContext.getContext())");
    paramMap.put("lang", str);
    paramMap.put("platform", "android");
    paramMap.put("version", String.valueOf(ai.anh(6)));
    str = ai.anV();
    p.j(str, "WebSearchApiLogic.getNetType()");
    paramMap.put("netType", str);
    str = BuildInfo.CLIENT_VERSION;
    p.j(str, "BuildInfo.CLIENT_VERSION");
    paramMap.put("wechatVersion", str);
    AppMethodBeat.o(198693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.c
 * JD-Core Version:    0.7.0.1
 */