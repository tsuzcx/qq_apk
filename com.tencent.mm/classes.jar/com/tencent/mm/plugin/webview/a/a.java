package com.tencent.mm.plugin.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;

public final class a
  implements o
{
  public static n gmO;
  public static m gmP;
  
  public static void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(5622);
    if (0L > 0L)
    {
      d.ysm.b(paramRunnable, "WebViewWorkerThread", 0L);
      AppMethodBeat.o(5622);
      return;
    }
    d.ysm.b(paramRunnable, "WebViewWorkerThread");
    AppMethodBeat.o(5622);
  }
  
  public final void a(m paramm)
  {
    gmP = paramm;
  }
  
  public final void a(n paramn)
  {
    gmO = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.a.a
 * JD-Core Version:    0.7.0.1
 */