package com.tencent.mm.plugin.sns.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements d
{
  private Map<Integer, com.tencent.mm.plugin.sns.ad.d.a> zmU;
  
  public a()
  {
    AppMethodBeat.i(94962);
    this.zmU = new HashMap();
    AppMethodBeat.o(94962);
  }
  
  public final void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94964);
    com.tencent.mm.plugin.sns.ad.d.a locala = (com.tencent.mm.plugin.sns.ad.d.a)this.zmU.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      ae.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.ad.d.a.class, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(94964);
      return;
    }
    locala.f(paramInt2, paramVarArgs);
    AppMethodBeat.o(94964);
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.d.a parama)
  {
    AppMethodBeat.i(94963);
    this.zmU.put(Integer.valueOf(parama.dHw()), parama);
    AppMethodBeat.o(94963);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94965);
    com.tencent.mm.plugin.sns.ad.d.a locala = (com.tencent.mm.plugin.sns.ad.d.a)this.zmU.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      ae.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.ad.d.a.class, Integer.valueOf(paramInt) });
      AppMethodBeat.o(94965);
      return;
    }
    locala.v(paramVarArgs);
    AppMethodBeat.o(94965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a
 * JD-Core Version:    0.7.0.1
 */