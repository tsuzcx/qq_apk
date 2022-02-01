package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public enum d
  implements c
{
  private static c yRR;
  
  static
  {
    AppMethodBeat.i(145664);
    yRQ = new d("INSTANCE");
    yRS = new d[] { yRQ };
    yRR = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      yRR = paramc;
    }
  }
  
  public final void PE(int paramInt)
  {
    AppMethodBeat.i(189019);
    yRR.PE(paramInt);
    AppMethodBeat.o(189019);
  }
  
  public final void PF(int paramInt)
  {
    AppMethodBeat.i(145659);
    yRR.PF(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(189020);
    yRR.asyncReportFinderSecurityInfoThroughCgi(paramInt);
    AppMethodBeat.o(189020);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    yRR.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final boolean ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145657);
    boolean bool = yRR.ay(paramInt, paramLong);
    AppMethodBeat.o(145657);
    return bool;
  }
  
  public final boolean az(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = yRR.az(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void dQs()
  {
    AppMethodBeat.i(145662);
    yRR.dQs();
    AppMethodBeat.o(145662);
  }
  
  public final void hw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    yRR.hw(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    yRR.r(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  static final class a
    implements c
  {
    public final void PE(int paramInt)
    {
      AppMethodBeat.i(189017);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(189017);
    }
    
    public final void PF(int paramInt)
    {
      AppMethodBeat.i(145650);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
    {
      AppMethodBeat.i(189018);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(189018);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final boolean ay(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145648);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145648);
      return false;
    }
    
    public final boolean az(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void dQs()
    {
      AppMethodBeat.i(145653);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void hw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(145649);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145649);
    }
    
    public final void r(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(145651);
      ae.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */