package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.erk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class r
{
  final Map<String, q> qva;
  
  r()
  {
    AppMethodBeat.i(239303);
    this.qva = new ConcurrentHashMap(1);
    AppMethodBeat.o(239303);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final q paramq, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(239304);
    p.zHS.aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239301);
        parama.a(paramInt1, paramInt2, paramq);
        AppMethodBeat.o(239301);
      }
    });
    AppMethodBeat.o(239304);
  }
  
  public final void akH(String paramString)
  {
    AppMethodBeat.i(239305);
    Log.i("MicroMsg.Multitalk.ILinkSessionMgr", "hy: on exit");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(239305);
      return;
    }
    this.qva.remove(paramString);
    AppMethodBeat.o(239305);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.r
 * JD-Core Version:    0.7.0.1
 */