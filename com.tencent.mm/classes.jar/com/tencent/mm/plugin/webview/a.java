package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.regex.Pattern;

public final class a
{
  public static final Pattern PDC;
  public static final String PDD;
  
  static
  {
    AppMethodBeat.i(77805);
    PDC = Pattern.compile("(http|https)://" + WeChatHosts.domainString(a.a.host_mp_weixin_qq_com) + ".*");
    PDD = b.aSL() + "vproxy";
    AppMethodBeat.o(77805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a
 * JD-Core Version:    0.7.0.1
 */