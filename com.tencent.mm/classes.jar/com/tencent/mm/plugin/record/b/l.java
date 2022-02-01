package com.tencent.mm.plugin.record.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class l
  implements f
{
  private Map<Long, String> BGY;
  
  public l()
  {
    AppMethodBeat.i(215181);
    this.BGY = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(215181);
  }
  
  private static void jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215185);
    ca localca = new ca();
    localca.setCreateTime(bp.Kw(paramString1));
    localca.Cy(paramString1);
    localca.setContent(paramString2);
    localca.setType(10000);
    localca.setStatus(6);
    localca.nv(0);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
    AppMethodBeat.o(215185);
  }
  
  public final void C(long paramLong, String paramString)
  {
    AppMethodBeat.i(215182);
    this.BGY.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(215182);
  }
  
  public final void D(long paramLong, String paramString)
  {
    AppMethodBeat.i(215184);
    if (this.BGY.keySet().contains(Long.valueOf(paramLong)))
    {
      jz(paramString, MMApplicationContext.getContext().getString(2131756571));
      this.BGY.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(215184);
  }
  
  public final void HQ(long paramLong)
  {
    AppMethodBeat.i(215183);
    if (this.BGY.keySet().contains(Long.valueOf(paramLong)))
    {
      jz((String)this.BGY.get(Long.valueOf(paramLong)), MMApplicationContext.getContext().getString(2131756571));
      this.BGY.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(215183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.l
 * JD-Core Version:    0.7.0.1
 */