package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchUILogic;", "", "()V", "TAG", "", "genEmojiSearchUrl", "params", "", "putCommonUrlParams", "", "startEmojiSearchDialog", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;", "context", "Landroid/content/Context;", "talker", "toSendText", "listener", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "sessionId", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c WqA;
  
  static
  {
    AppMethodBeat.i(315048);
    WqA = new c();
    AppMethodBeat.o(315048);
  }
  
  public static String bq(Map<String, String> paramMap)
  {
    AppMethodBeat.i(315037);
    s.u(paramMap, "params");
    String str = aj.asW(10).iqs();
    br(paramMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(str);
    localStringBuffer.append("?");
    localStringBuffer.append(aj.toUrlParams(paramMap));
    paramMap = localStringBuffer.toString();
    s.s(paramMap, "urlBuffer.toString()");
    AppMethodBeat.o(315037);
    return paramMap;
  }
  
  static void br(Map<String, String> paramMap)
  {
    AppMethodBeat.i(315044);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    s.s(str, "getCurrentLanguage(MMApp…tionContext.getContext())");
    paramMap.put("lang", str);
    paramMap.put("platform", "android");
    paramMap.put("version", String.valueOf(aj.asY(10)));
    str = aj.gtA();
    s.s(str, "getNetType()");
    paramMap.put("netType", str);
    str = BuildInfo.CLIENT_VERSION;
    s.s(str, "CLIENT_VERSION");
    paramMap.put("wechatVersion", str);
    AppMethodBeat.o(315044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.c
 * JD-Core Version:    0.7.0.1
 */