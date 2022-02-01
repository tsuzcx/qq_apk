package com.tencent.mm.plugin.record.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class l
  implements f
{
  private Map<Long, String> xrc;
  
  public l()
  {
    AppMethodBeat.i(213092);
    this.xrc = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(213092);
  }
  
  private static void iG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213096);
    bu localbu = new bu();
    localbu.qA(bj.Bo(paramString1));
    localbu.tN(paramString1);
    localbu.setContent(paramString2);
    localbu.setType(10000);
    localbu.setStatus(6);
    localbu.kr(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(localbu);
    AppMethodBeat.o(213096);
  }
  
  public final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(213093);
    this.xrc.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(213093);
  }
  
  public final void x(long paramLong, String paramString)
  {
    AppMethodBeat.i(213095);
    if (this.xrc.keySet().contains(Long.valueOf(paramLong)))
    {
      iG(paramString, aj.getContext().getString(2131761740));
      this.xrc.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(213095);
  }
  
  public final void yB(long paramLong)
  {
    AppMethodBeat.i(213094);
    if (this.xrc.keySet().contains(Long.valueOf(paramLong)))
    {
      iG((String)this.xrc.get(Long.valueOf(paramLong)), aj.getContext().getString(2131761740));
      this.xrc.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(213094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.l
 * JD-Core Version:    0.7.0.1
 */