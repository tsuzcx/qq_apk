package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class r
{
  final Map<String, q> pfW;
  
  r()
  {
    AppMethodBeat.i(190709);
    this.pfW = new ConcurrentHashMap(1);
    AppMethodBeat.o(190709);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final q paramq, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(190710);
    p.wmO.ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190707);
        parama.a(paramInt1, paramInt2, paramq);
        AppMethodBeat.o(190707);
      }
    });
    AppMethodBeat.o(190710);
  }
  
  public final void aaB(String paramString)
  {
    AppMethodBeat.i(190711);
    ae.i("MicroMsg.Multitalk.ILinkSessionMgr", "hy: on exit");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(190711);
      return;
    }
    this.pfW.remove(paramString);
    AppMethodBeat.o(190711);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.r
 * JD-Core Version:    0.7.0.1
 */