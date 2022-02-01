package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.cd.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.fbv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class q
{
  final Map<String, p> tTM;
  
  q()
  {
    AppMethodBeat.i(200620);
    this.tTM = new ConcurrentHashMap(1);
    AppMethodBeat.o(200620);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final p paramp, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(200622);
    o.Fne.am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199699);
        parama.a(paramInt1, paramInt2, paramp);
        AppMethodBeat.o(199699);
      }
    });
    AppMethodBeat.o(200622);
  }
  
  public final void asv(String paramString)
  {
    AppMethodBeat.i(200625);
    Log.i("MicroMsg.Multitalk.ILinkSessionMgr", "hy: on exit");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(200625);
      return;
    }
    this.tTM.remove(paramString);
    AppMethodBeat.o(200625);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, p paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.q
 * JD-Core Version:    0.7.0.1
 */