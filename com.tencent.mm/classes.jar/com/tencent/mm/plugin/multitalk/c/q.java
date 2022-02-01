package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.fyg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class q
{
  final Map<String, p> wXd;
  
  public q()
  {
    AppMethodBeat.i(285161);
    this.wXd = new ConcurrentHashMap(1);
    AppMethodBeat.o(285161);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final p paramp, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(285176);
    o.Ljn.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285099);
        parama.a(paramInt1, paramInt2, paramp);
        AppMethodBeat.o(285099);
      }
    });
    AppMethodBeat.o(285176);
  }
  
  public final void ama(String paramString)
  {
    AppMethodBeat.i(285182);
    Log.i("MicroMsg.Multitalk.ILinkSessionMgr", "hy: on exit");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(285182);
      return;
    }
    this.wXd.remove(paramString);
    AppMethodBeat.o(285182);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, p paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.q
 * JD-Core Version:    0.7.0.1
 */