package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public enum d
  implements c
{
  private static c xnQ;
  
  static
  {
    AppMethodBeat.i(145664);
    xnP = new d("INSTANCE");
    xnR = new d[] { xnP };
    xnQ = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      xnQ = paramc;
    }
  }
  
  public final void Nv(int paramInt)
  {
    AppMethodBeat.i(206773);
    xnQ.Nv(paramInt);
    AppMethodBeat.o(206773);
  }
  
  public final void Nw(int paramInt)
  {
    AppMethodBeat.i(145659);
    xnQ.Nw(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final boolean ar(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145657);
    boolean bool = xnQ.ar(paramInt, paramLong);
    AppMethodBeat.o(145657);
    return bool;
  }
  
  public final boolean as(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = xnQ.as(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(206774);
    xnQ.asyncReportFinderSecurityInfoThroughCgi(paramInt);
    AppMethodBeat.o(206774);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    xnQ.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(145662);
    xnQ.dBC();
    AppMethodBeat.o(145662);
  }
  
  public final void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    xnQ.hd(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    xnQ.r(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  static final class a
    implements c
  {
    public final void Nv(int paramInt)
    {
      AppMethodBeat.i(206771);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(206771);
    }
    
    public final void Nw(int paramInt)
    {
      AppMethodBeat.i(145650);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final boolean ar(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145648);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145648);
      return false;
    }
    
    public final boolean as(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
    {
      AppMethodBeat.i(206772);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(206772);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final void dBC()
    {
      AppMethodBeat.i(145653);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void hd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(145649);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145649);
    }
    
    public final void r(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(145651);
      ac.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */