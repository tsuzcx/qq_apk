package com.tencent.mm.plugin.webview.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;

public final class a
  implements m
{
  public static l iyx;
  public static k iyy;
  
  public static void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(77826);
    if (0L > 0L)
    {
      h.JZN.a(paramRunnable, 0L, "WebViewWorkerThread");
      AppMethodBeat.o(77826);
      return;
    }
    h.JZN.f(paramRunnable, "WebViewWorkerThread");
    AppMethodBeat.o(77826);
  }
  
  public final void a(k paramk)
  {
    iyy = paramk;
  }
  
  public final void a(l paraml)
  {
    iyx = paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a.a
 * JD-Core Version:    0.7.0.1
 */