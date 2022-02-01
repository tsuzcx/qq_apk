package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
{
  public static void a(a parama)
  {
    AppMethodBeat.i(219179);
    if (parama != null) {}
    try
    {
      jj(parama.dVo(), parama.getContent());
      AppMethodBeat.o(219179);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(219179);
    }
  }
  
  private static void jj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219180);
    try
    {
      ae.d("SnsAdChannelReporter", "Channel: " + paramString1 + "; Content: " + paramString2);
      k.jm(paramString1, paramString2);
      AppMethodBeat.o(219180);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(219180);
    }
  }
  
  public static abstract interface a
  {
    public abstract String dVo();
    
    public abstract String getContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.g
 * JD-Core Version:    0.7.0.1
 */