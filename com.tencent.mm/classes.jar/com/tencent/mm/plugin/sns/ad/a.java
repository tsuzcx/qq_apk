package com.tencent.mm.plugin.sns.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements d
{
  private Map<Integer, com.tencent.mm.plugin.sns.ad.b.a> xIa;
  
  public a()
  {
    AppMethodBeat.i(94962);
    this.xIa = new HashMap();
    AppMethodBeat.o(94962);
  }
  
  public final void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94964);
    com.tencent.mm.plugin.sns.ad.b.a locala = (com.tencent.mm.plugin.sns.ad.b.a)this.xIa.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      ac.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.ad.b.a.class, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(94964);
      return;
    }
    locala.f(paramInt2, paramVarArgs);
    AppMethodBeat.o(94964);
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.b.a parama)
  {
    AppMethodBeat.i(94963);
    this.xIa.put(Integer.valueOf(parama.dtI()), parama);
    AppMethodBeat.o(94963);
  }
  
  public final void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94965);
    com.tencent.mm.plugin.sns.ad.b.a locala = (com.tencent.mm.plugin.sns.ad.b.a)this.xIa.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      ac.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.ad.b.a.class, Integer.valueOf(paramInt) });
      AppMethodBeat.o(94965);
      return;
    }
    locala.w(paramVarArgs);
    AppMethodBeat.o(94965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a
 * JD-Core Version:    0.7.0.1
 */