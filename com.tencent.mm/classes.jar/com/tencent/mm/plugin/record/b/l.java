package com.tencent.mm.plugin.record.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
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
  private Map<Long, String> HDe;
  
  public l()
  {
    AppMethodBeat.i(210134);
    this.HDe = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(210134);
  }
  
  private static void jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210150);
    ca localca = new ca();
    localca.setCreateTime(bq.RP(paramString1));
    localca.Jm(paramString1);
    localca.setContent(paramString2);
    localca.setType(10000);
    localca.setStatus(6);
    localca.pJ(0);
    ((n)h.ae(n.class)).eSe().aM(localca);
    AppMethodBeat.o(210150);
  }
  
  public final void K(long paramLong, String paramString)
  {
    AppMethodBeat.i(210136);
    this.HDe.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(210136);
  }
  
  public final void L(long paramLong, String paramString)
  {
    AppMethodBeat.i(210143);
    if (this.HDe.keySet().contains(Long.valueOf(paramLong)))
    {
      jL(paramString, MMApplicationContext.getContext().getString(a.c.big_file_over_svr_limit));
      this.HDe.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(210143);
  }
  
  public final void Pl(long paramLong)
  {
    AppMethodBeat.i(210140);
    if (this.HDe.keySet().contains(Long.valueOf(paramLong)))
    {
      jL((String)this.HDe.get(Long.valueOf(paramLong)), MMApplicationContext.getContext().getString(a.c.big_file_over_svr_limit));
      this.HDe.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(210140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.l
 * JD-Core Version:    0.7.0.1
 */