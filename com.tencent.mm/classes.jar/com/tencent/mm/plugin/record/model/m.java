package com.tencent.mm.plugin.record.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.cc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class m
  implements f
{
  private Map<Long, String> NAG;
  
  public m()
  {
    AppMethodBeat.i(305322);
    this.NAG = Collections.synchronizedMap(new HashMap());
    AppMethodBeat.o(305322);
  }
  
  private static void lg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(305324);
    cc localcc = new cc();
    localcc.setCreateTime(br.JN(paramString1));
    localcc.BS(paramString1);
    localcc.setContent(paramString2);
    localcc.setType(10000);
    localcc.setStatus(6);
    localcc.pI(0);
    ((n)h.ax(n.class)).gaZ().ba(localcc);
    AppMethodBeat.o(305324);
  }
  
  public final void Z(long paramLong, String paramString)
  {
    AppMethodBeat.i(305327);
    this.NAG.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(305327);
  }
  
  public final void aa(long paramLong, String paramString)
  {
    AppMethodBeat.i(305332);
    if (this.NAG.keySet().contains(Long.valueOf(paramLong)))
    {
      lg(paramString, MMApplicationContext.getContext().getString(a.c.big_file_over_svr_limit));
      this.NAG.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(305332);
  }
  
  public final void tl(long paramLong)
  {
    AppMethodBeat.i(305330);
    if (this.NAG.keySet().contains(Long.valueOf(paramLong)))
    {
      lg((String)this.NAG.get(Long.valueOf(paramLong)), MMApplicationContext.getContext().getString(a.c.big_file_over_svr_limit));
      this.NAG.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(305330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.m
 * JD-Core Version:    0.7.0.1
 */