package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.g.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$8
  implements k.a
{
  b$8(b paramb) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(84525);
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bo.dtY() });
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString))) {
      d.ysn.q(new b.8.1(this), 100L);
    }
    AppMethodBeat.o(84525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.8
 * JD-Core Version:    0.7.0.1
 */