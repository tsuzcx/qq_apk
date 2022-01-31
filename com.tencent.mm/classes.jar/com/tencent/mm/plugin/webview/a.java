package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import java.util.regex.Pattern;

public final class a
{
  public static final Pattern uNB;
  public static final String uNC;
  
  static
  {
    AppMethodBeat.i(5610);
    uNB = Pattern.compile("(http|https)://mp.weixin.qq.com.*");
    uNC = e.eQz + "vproxy";
    AppMethodBeat.o(5610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a
 * JD-Core Version:    0.7.0.1
 */