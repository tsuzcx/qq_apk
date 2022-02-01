package com.tencent.mm.plugin.secinforeport.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum d
  implements c
{
  private static c Jcn;
  
  static
  {
    AppMethodBeat.i(145664);
    Jcm = new d("INSTANCE");
    Jco = new d[] { Jcm };
    Jcn = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      Jcn = paramc;
    }
  }
  
  public static void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(210735);
    Jcn.jq(paramInt, 0);
    AppMethodBeat.o(210735);
  }
  
  public final boolean aS(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = Jcn.aS(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void aT(Intent paramIntent)
  {
    AppMethodBeat.i(210732);
    Jcn.aT(paramIntent);
    AppMethodBeat.o(210732);
  }
  
  public final boolean aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(210733);
    boolean bool = Jcn.aT(paramInt, paramLong);
    AppMethodBeat.o(210733);
    return bool;
  }
  
  public final void aeg(int paramInt)
  {
    AppMethodBeat.i(210728);
    Jcn.aeg(paramInt);
    AppMethodBeat.o(210728);
  }
  
  public final void aeh(int paramInt)
  {
    AppMethodBeat.i(145659);
    Jcn.aeh(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final void asyncReportNewInstallAppThroughCgi(Intent paramIntent)
  {
    AppMethodBeat.i(210727);
    Jcn.asyncReportNewInstallAppThroughCgi(paramIntent);
    AppMethodBeat.o(210727);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    Jcn.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210724);
    Jcn.asyncReportSensorSceneInfoThroughCgi(paramString, paramArrayOfByte);
    AppMethodBeat.o(210724);
  }
  
  public final void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210725);
    Jcn.asyncReportTuringOwnerThroughCgi(paramArrayOfByte);
    AppMethodBeat.o(210725);
  }
  
  public final void cq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210730);
    Jcn.cq(paramArrayOfByte);
    AppMethodBeat.o(210730);
  }
  
  public final void fFu()
  {
    AppMethodBeat.i(145662);
    Jcn.fFu();
    AppMethodBeat.o(145662);
  }
  
  public final void jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210722);
    Jcn.jq(paramInt1, paramInt2);
    AppMethodBeat.o(210722);
  }
  
  public final void jr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    Jcn.jr(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    Jcn.s(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  public final void z(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210729);
    Jcn.z(paramString, paramArrayOfByte);
    AppMethodBeat.o(210729);
  }
  
  static final class a
    implements c
  {
    public final boolean aS(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void aT(Intent paramIntent)
    {
      AppMethodBeat.i(210704);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210704);
    }
    
    public final boolean aT(int paramInt, long paramLong)
    {
      AppMethodBeat.i(210705);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210705);
      return false;
    }
    
    public final void aeg(int paramInt)
    {
      AppMethodBeat.i(210701);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210701);
    }
    
    public final void aeh(int paramInt)
    {
      AppMethodBeat.i(145650);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final void asyncReportNewInstallAppThroughCgi(Intent paramIntent)
    {
      AppMethodBeat.i(210700);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210700);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(210698);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210698);
    }
    
    public final void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(210699);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210699);
    }
    
    public final void cq(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(210703);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210703);
    }
    
    public final void fFu()
    {
      AppMethodBeat.i(145653);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void jq(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210696);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210696);
    }
    
    public final void jr(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(145649);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145649);
    }
    
    public final void s(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(145651);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145651);
    }
    
    public final void z(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(210702);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(210702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */