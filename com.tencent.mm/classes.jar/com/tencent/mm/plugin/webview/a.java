package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.regex.Pattern;

public final class a
{
  public static final Pattern AKj;
  public static final String AKk;
  
  static
  {
    AppMethodBeat.i(77805);
    AKj = Pattern.compile("(http|https)://mp.weixin.qq.com.*");
    AKk = b.aih() + "vproxy";
    AppMethodBeat.o(77805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a
 * JD-Core Version:    0.7.0.1
 */