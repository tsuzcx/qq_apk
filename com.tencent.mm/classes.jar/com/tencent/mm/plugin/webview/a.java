package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.regex.Pattern;

public final class a
{
  public static final String DFA;
  public static final Pattern DFz;
  
  static
  {
    AppMethodBeat.i(77805);
    DFz = Pattern.compile("(http|https)://mp.weixin.qq.com.*");
    DFA = b.arU() + "vproxy";
    AppMethodBeat.o(77805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a
 * JD-Core Version:    0.7.0.1
 */