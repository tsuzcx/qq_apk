package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
{
  public static void a(a parama)
  {
    AppMethodBeat.i(197707);
    if (parama != null) {}
    try
    {
      jc(parama.dRQ(), parama.getContent());
      AppMethodBeat.o(197707);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(197707);
    }
  }
  
  private static void jc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197708);
    try
    {
      ad.d("SnsAdChannelReporter", "Channel: " + paramString1 + "; Content: " + paramString2);
      j.jf(paramString1, paramString2);
      AppMethodBeat.o(197708);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(197708);
    }
  }
  
  public static abstract interface a
  {
    public abstract String dRQ();
    
    public abstract String getContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.g
 * JD-Core Version:    0.7.0.1
 */