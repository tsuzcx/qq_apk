package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public enum d
  implements c
{
  private static c wcF;
  
  static
  {
    AppMethodBeat.i(145664);
    wcE = new d("INSTANCE");
    wcG = new d[] { wcE };
    wcF = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      wcF = paramc;
    }
  }
  
  public final void Lv(int paramInt)
  {
    AppMethodBeat.i(195206);
    wcF.Lv(paramInt);
    AppMethodBeat.o(195206);
  }
  
  public final void Lw(int paramInt)
  {
    AppMethodBeat.i(145659);
    wcF.Lw(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final boolean as(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145657);
    boolean bool = wcF.as(paramInt, paramLong);
    AppMethodBeat.o(145657);
    return bool;
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(195207);
    wcF.asyncReportFinderSecurityInfoThroughCgi(paramInt);
    AppMethodBeat.o(195207);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    wcF.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final boolean at(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = wcF.at(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void dnu()
  {
    AppMethodBeat.i(145662);
    wcF.dnu();
    AppMethodBeat.o(145662);
  }
  
  public final void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    wcF.gU(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    wcF.r(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  static final class a
    implements c
  {
    public final void Lv(int paramInt)
    {
      AppMethodBeat.i(195204);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(195204);
    }
    
    public final void Lw(int paramInt)
    {
      AppMethodBeat.i(145650);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final boolean as(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145648);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145648);
      return false;
    }
    
    public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
    {
      AppMethodBeat.i(195205);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(195205);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final boolean at(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void dnu()
    {
      AppMethodBeat.i(145653);
      ad.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void gU(int paramInt1, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */