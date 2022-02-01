package com.tencent.mm.plugin.monitor;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class b$9
  implements k.a
{
  b$9(b paramb) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(51508);
    ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", new Object[] { bs.eWi() });
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString))) {
      h.JZN.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51507);
          b.a(b.9.this.uVA);
          AppMethodBeat.o(51507);
        }
      }, 100L);
    }
    AppMethodBeat.o(51508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.9
 * JD-Core Version:    0.7.0.1
 */