package com.tencent.mm.plugin.webview.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;

public final class a
  implements n
{
  public static m iRG;
  public static l iRH;
  
  public static void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(77826);
    if (0L > 0L)
    {
      h.LTJ.a(paramRunnable, 0L, "WebViewWorkerThread");
      AppMethodBeat.o(77826);
      return;
    }
    h.LTJ.f(paramRunnable, "WebViewWorkerThread");
    AppMethodBeat.o(77826);
  }
  
  public final void a(l paraml)
  {
    iRH = paraml;
  }
  
  public final void a(m paramm)
  {
    iRG = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a.a
 * JD-Core Version:    0.7.0.1
 */