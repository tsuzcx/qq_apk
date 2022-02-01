package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
{
  public static void a(a parama)
  {
    AppMethodBeat.i(200026);
    if (parama != null) {}
    try
    {
      iR(parama.dFW(), parama.getContent());
      AppMethodBeat.o(200026);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(200026);
    }
  }
  
  private static void iR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200027);
    try
    {
      ac.d("SnsAdChannelReporter", "Channel: " + paramString1 + "; Content: " + paramString2);
      j.iU(paramString1, paramString2);
      AppMethodBeat.o(200027);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(200027);
    }
  }
  
  public static abstract interface a
  {
    public abstract String dFW();
    
    public abstract String getContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.d
 * JD-Core Version:    0.7.0.1
 */