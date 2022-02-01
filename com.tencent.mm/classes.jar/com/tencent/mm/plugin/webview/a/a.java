package com.tencent.mm.plugin.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class a
  implements n
{
  public static m pFn;
  public static l pFo;
  
  public static void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(77826);
    if (0L > 0L)
    {
      h.ahAA.a(paramRunnable, 0L, "WebViewWorkerThread");
      AppMethodBeat.o(77826);
      return;
    }
    h.ahAA.g(paramRunnable, "WebViewWorkerThread");
    AppMethodBeat.o(77826);
  }
  
  public final void a(l paraml)
  {
    pFo = paraml;
  }
  
  public final void a(m paramm)
  {
    pFn = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a.a
 * JD-Core Version:    0.7.0.1
 */