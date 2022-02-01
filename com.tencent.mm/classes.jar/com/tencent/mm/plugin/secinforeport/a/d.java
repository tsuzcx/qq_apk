package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum d
  implements c
{
  private static c CWH;
  
  static
  {
    AppMethodBeat.i(145664);
    CWG = new d("INSTANCE");
    CWI = new d[] { CWG };
    CWH = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      CWH = paramc;
    }
  }
  
  public final void Xi(int paramInt)
  {
    AppMethodBeat.i(187535);
    CWH.Xi(paramInt);
    AppMethodBeat.o(187535);
  }
  
  public final void Xj(int paramInt)
  {
    AppMethodBeat.i(145659);
    CWH.Xj(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final boolean aF(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145657);
    boolean bool = CWH.aF(paramInt, paramLong);
    AppMethodBeat.o(145657);
    return bool;
  }
  
  public final boolean aG(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = CWH.aG(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(187536);
    CWH.asyncReportFinderSecurityInfoThroughCgi(paramInt);
    AppMethodBeat.o(187536);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    CWH.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187538);
    CWH.ca(paramArrayOfByte);
    AppMethodBeat.o(187538);
  }
  
  public final void eSt()
  {
    AppMethodBeat.i(145662);
    CWH.eSt();
    AppMethodBeat.o(145662);
  }
  
  public final void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    CWH.ik(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    CWH.r(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  public final void u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187537);
    CWH.u(paramString, paramArrayOfByte);
    AppMethodBeat.o(187537);
  }
  
  static final class a
    implements c
  {
    public final void Xi(int paramInt)
    {
      AppMethodBeat.i(187531);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(187531);
    }
    
    public final void Xj(int paramInt)
    {
      AppMethodBeat.i(145650);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final boolean aF(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145648);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145648);
      return false;
    }
    
    public final boolean aG(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
    {
      AppMethodBeat.i(187532);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(187532);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final void ca(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(187534);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(187534);
    }
    
    public final void eSt()
    {
      AppMethodBeat.i(145653);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void ik(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(145649);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145649);
    }
    
    public final void r(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(145651);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145651);
    }
    
    public final void u(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(187533);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(187533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */