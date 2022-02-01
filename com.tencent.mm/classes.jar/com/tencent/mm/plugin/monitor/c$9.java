package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$9
  implements b.c
{
  c$9(c paramc) {}
  
  public final boolean a(b.b paramb, long paramLong)
  {
    AppMethodBeat.i(266664);
    if ((!com.tencent.matrix.a.b.b.bZ(paramb.mContext)) && (paramLong >= 300000L))
    {
      e.a.ns(80);
      if (c.a(this.LfZ) != null)
      {
        Log.w("MicroMsg.SubCoreBaseMonitor", "#onAppLowEnergy, cancel file scanning");
        c.a(this.LfZ).cancel();
        c.a(this.LfZ, null);
      }
      AppMethodBeat.o(266664);
      return true;
    }
    AppMethodBeat.o(266664);
    return false;
  }
  
  public final boolean gl(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.9
 * JD-Core Version:    0.7.0.1
 */