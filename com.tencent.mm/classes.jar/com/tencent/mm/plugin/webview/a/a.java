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
  public static l iUA;
  public static m iUz;
  
  public static void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(77826);
    if (0L > 0L)
    {
      h.MqF.a(paramRunnable, 0L, "WebViewWorkerThread");
      AppMethodBeat.o(77826);
      return;
    }
    h.MqF.f(paramRunnable, "WebViewWorkerThread");
    AppMethodBeat.o(77826);
  }
  
  public final void a(l paraml)
  {
    iUA = paraml;
  }
  
  public final void a(m paramm)
  {
    iUz = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a.a
 * JD-Core Version:    0.7.0.1
 */