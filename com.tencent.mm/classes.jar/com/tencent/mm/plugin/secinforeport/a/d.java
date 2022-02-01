package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public enum d
  implements c
{
  private static c yBR;
  
  static
  {
    AppMethodBeat.i(145664);
    yBQ = new d("INSTANCE");
    yBS = new d[] { yBQ };
    yBR = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      yBR = paramc;
    }
  }
  
  public final void OX(int paramInt)
  {
    AppMethodBeat.i(186426);
    yBR.OX(paramInt);
    AppMethodBeat.o(186426);
  }
  
  public final void OY(int paramInt)
  {
    AppMethodBeat.i(145659);
    yBR.OY(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(186427);
    yBR.asyncReportFinderSecurityInfoThroughCgi(paramInt);
    AppMethodBeat.o(186427);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    yBR.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final boolean ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145657);
    boolean bool = yBR.ay(paramInt, paramLong);
    AppMethodBeat.o(145657);
    return bool;
  }
  
  public final boolean az(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = yBR.az(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void dMZ()
  {
    AppMethodBeat.i(145662);
    yBR.dMZ();
    AppMethodBeat.o(145662);
  }
  
  public final void hu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    yBR.hu(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    yBR.r(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  static final class a
    implements c
  {
    public final void OX(int paramInt)
    {
      AppMethodBeat.i(186424);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(186424);
    }
    
    public final void OY(int paramInt)
    {
      AppMethodBeat.i(145650);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
    {
      AppMethodBeat.i(186425);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(186425);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final boolean ay(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145648);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145648);
      return false;
    }
    
    public final boolean az(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void dMZ()
    {
      AppMethodBeat.i(145653);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void hu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(145649);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145649);
    }
    
    public final void r(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(145651);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */