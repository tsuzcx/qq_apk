package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.regex.Pattern;

public final class a
{
  public static final Pattern Wuh;
  public static final String Wui;
  
  static
  {
    AppMethodBeat.i(77805);
    Wuh = Pattern.compile("(http|https)://" + WeChatHosts.domainString(a.e.host_mp_weixin_qq_com) + ".*");
    Wui = b.bmz() + "vproxy";
    AppMethodBeat.o(77805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a
 * JD-Core Version:    0.7.0.1
 */