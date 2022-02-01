package com.tencent.mm.plugin.sns.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.a;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements d
{
  private Map<Integer, a> PKU;
  
  public b()
  {
    AppMethodBeat.i(94962);
    this.PKU = new HashMap();
    AppMethodBeat.o(94962);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(94963);
    this.PKU.put(Integer.valueOf(parama.getKey()), parama);
    AppMethodBeat.o(94963);
  }
  
  public final void b(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94964);
    a locala = (a)this.PKU.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      Log.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { a.class, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(94964);
      return;
    }
    locala.b(paramInt2, paramVarArgs);
    AppMethodBeat.o(94964);
  }
  
  public final void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94965);
    a locala = (a)this.PKU.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      Log.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { a.class, Integer.valueOf(paramInt) });
      AppMethodBeat.o(94965);
      return;
    }
    locala.x(paramVarArgs);
    AppMethodBeat.o(94965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b
 * JD-Core Version:    0.7.0.1
 */