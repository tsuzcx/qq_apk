package com.tencent.mm.plugin.websearch.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic;", "", "()V", "TAG", "", "genTagSearchUrl", "params", "", "putCommonUrlParams", "", "startTagSearchDialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "context", "Landroid/content/Context;", "talker", "enterType", "", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "query", "sessionId", "cursorIndex", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final String TAG;
  public static final c WqP;
  
  static
  {
    AppMethodBeat.i(315403);
    WqP = new c();
    TAG = "MicroMsg.WebSearch.TagSearchUILogic";
    AppMethodBeat.o(315403);
  }
  
  public static void br(Map<String, String> paramMap)
  {
    AppMethodBeat.i(315399);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    s.s(str, "getCurrentLanguage(MMApp…tionContext.getContext())");
    paramMap.put("lang", str);
    paramMap.put("platform", "android");
    paramMap.put("version", String.valueOf(aj.asY(6)));
    str = aj.gtA();
    s.s(str, "getNetType()");
    paramMap.put("netType", str);
    str = BuildInfo.CLIENT_VERSION;
    s.s(str, "CLIENT_VERSION");
    paramMap.put("wechatVersion", str);
    AppMethodBeat.o(315399);
  }
  
  public static String bs(Map<String, String> paramMap)
  {
    AppMethodBeat.i(315395);
    s.u(paramMap, "params");
    String str = aj.asW(6).iqs();
    br(paramMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(str);
    localStringBuffer.append("?");
    localStringBuffer.append(aj.toUrlParams(paramMap));
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(315395);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.c
 * JD-Core Version:    0.7.0.1
 */