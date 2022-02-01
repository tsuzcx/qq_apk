package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.regex.Pattern;

public final class a
{
  public static final Pattern IJn;
  public static final String IJo;
  
  static
  {
    AppMethodBeat.i(77805);
    IJn = Pattern.compile("(http|https)://" + WeChatHosts.domainString(2131761726) + ".*");
    IJo = b.aKJ() + "vproxy";
    AppMethodBeat.o(77805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a
 * JD-Core Version:    0.7.0.1
 */