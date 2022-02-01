package com.tencent.mm.plugin.record.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class l
  implements f
{
  private Map<Long, String> xGZ;
  
  public l()
  {
    AppMethodBeat.i(221832);
    this.xGZ = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(221832);
  }
  
  private static void iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221836);
    bv localbv = new bv();
    localbv.qN(bl.BQ(paramString1));
    localbv.ui(paramString1);
    localbv.setContent(paramString2);
    localbv.setType(10000);
    localbv.setStatus(6);
    localbv.kt(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
    AppMethodBeat.o(221836);
  }
  
  public final void x(long paramLong, String paramString)
  {
    AppMethodBeat.i(221833);
    this.xGZ.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(221833);
  }
  
  public final void y(long paramLong, String paramString)
  {
    AppMethodBeat.i(221835);
    if (this.xGZ.keySet().contains(Long.valueOf(paramLong)))
    {
      iM(paramString, ak.getContext().getString(2131761740));
      this.xGZ.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(221835);
  }
  
  public final void za(long paramLong)
  {
    AppMethodBeat.i(221834);
    if (this.xGZ.keySet().contains(Long.valueOf(paramLong)))
    {
      iM((String)this.xGZ.get(Long.valueOf(paramLong)), ak.getContext().getString(2131761740));
      this.xGZ.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(221834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.l
 * JD-Core Version:    0.7.0.1
 */