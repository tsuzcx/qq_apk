package com.tencent.mm.plugin.sns.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements d
{
  private Map<Integer, com.tencent.mm.plugin.sns.ad.e.a> Jxr;
  
  public a()
  {
    AppMethodBeat.i(94962);
    this.Jxr = new HashMap();
    AppMethodBeat.o(94962);
  }
  
  public final void a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94965);
    com.tencent.mm.plugin.sns.ad.e.a locala = (com.tencent.mm.plugin.sns.ad.e.a)this.Jxr.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      Log.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.ad.e.a.class, Integer.valueOf(paramInt) });
      AppMethodBeat.o(94965);
      return;
    }
    locala.v(paramVarArgs);
    AppMethodBeat.o(94965);
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.e.a parama)
  {
    AppMethodBeat.i(94963);
    this.Jxr.put(Integer.valueOf(parama.getKey()), parama);
    AppMethodBeat.o(94963);
  }
  
  public final void b(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94964);
    com.tencent.mm.plugin.sns.ad.e.a locala = (com.tencent.mm.plugin.sns.ad.e.a)this.Jxr.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      Log.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[] { com.tencent.mm.plugin.sns.ad.e.a.class, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(94964);
      return;
    }
    locala.a(paramInt2, paramVarArgs);
    AppMethodBeat.o(94964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a
 * JD-Core Version:    0.7.0.1
 */