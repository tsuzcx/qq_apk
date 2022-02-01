package com.tencent.mm.plugin.secinforeport.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum d
  implements c
{
  private static c Pmc;
  
  static
  {
    AppMethodBeat.i(145664);
    Pmb = new d("INSTANCE");
    Pmd = new d[] { Pmb };
    Pmc = new a((byte)0);
    AppMethodBeat.o(145664);
  }
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      Pmc = paramc;
    }
  }
  
  public static void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(261975);
    Pmc.kY(paramInt, 0);
    AppMethodBeat.o(261975);
  }
  
  public final void C(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262005);
    Pmc.C(paramString, paramArrayOfByte);
    AppMethodBeat.o(262005);
  }
  
  public final boolean aZ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(145661);
    boolean bool = Pmc.aZ(paramInt, paramLong);
    AppMethodBeat.o(145661);
    return bool;
  }
  
  public final void aiL(int paramInt)
  {
    AppMethodBeat.i(262003);
    Pmc.aiL(paramInt);
    AppMethodBeat.o(262003);
  }
  
  public final void aiM(int paramInt)
  {
    AppMethodBeat.i(145659);
    Pmc.aiM(paramInt);
    AppMethodBeat.o(145659);
  }
  
  public final void asyncReportNewInstallAppThroughCgi(Intent paramIntent)
  {
    AppMethodBeat.i(261986);
    Pmc.asyncReportNewInstallAppThroughCgi(paramIntent);
    AppMethodBeat.o(261986);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(145663);
    Pmc.asyncReportPaySecurityInfoThroughCgi();
    AppMethodBeat.o(145663);
  }
  
  public final void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261982);
    Pmc.asyncReportSensorSceneInfoThroughCgi(paramString, paramArrayOfByte);
    AppMethodBeat.o(261982);
  }
  
  public final void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261983);
    Pmc.asyncReportTuringOwnerThroughCgi(paramArrayOfByte);
    AppMethodBeat.o(261983);
  }
  
  public final boolean ba(int paramInt, long paramLong)
  {
    AppMethodBeat.i(262012);
    boolean bool = Pmc.ba(paramInt, paramLong);
    AppMethodBeat.o(262012);
    return bool;
  }
  
  public final void br(Intent paramIntent)
  {
    AppMethodBeat.i(262010);
    Pmc.br(paramIntent);
    AppMethodBeat.o(262010);
  }
  
  public final void cs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262008);
    Pmc.cs(paramArrayOfByte);
    AppMethodBeat.o(262008);
  }
  
  public final void gUC()
  {
    AppMethodBeat.i(145662);
    Pmc.gUC();
    AppMethodBeat.o(145662);
  }
  
  public final void kY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261980);
    Pmc.kY(paramInt1, paramInt2);
    AppMethodBeat.o(261980);
  }
  
  public final void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145658);
    Pmc.kZ(paramInt1, paramInt2);
    AppMethodBeat.o(145658);
  }
  
  public final void t(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145660);
    Pmc.t(paramInt, paramArrayOfByte);
    AppMethodBeat.o(145660);
  }
  
  static final class a
    implements c
  {
    public final void C(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(261996);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261996);
    }
    
    public final boolean aZ(int paramInt, long paramLong)
    {
      AppMethodBeat.i(145652);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145652);
      return false;
    }
    
    public final void aiL(int paramInt)
    {
      AppMethodBeat.i(261991);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261991);
    }
    
    public final void aiM(int paramInt)
    {
      AppMethodBeat.i(145650);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145650);
    }
    
    public final void asyncReportNewInstallAppThroughCgi(Intent paramIntent)
    {
      AppMethodBeat.i(261978);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261978);
    }
    
    public final void asyncReportPaySecurityInfoThroughCgi()
    {
      AppMethodBeat.i(145654);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145654);
    }
    
    public final void asyncReportSensorSceneInfoThroughCgi(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(261974);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261974);
    }
    
    public final void asyncReportTuringOwnerThroughCgi(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(261977);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261977);
    }
    
    public final boolean ba(int paramInt, long paramLong)
    {
      AppMethodBeat.i(262002);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(262002);
      return false;
    }
    
    public final void br(Intent paramIntent)
    {
      AppMethodBeat.i(262000);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(262000);
    }
    
    public final void cs(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(261998);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261998);
    }
    
    public final void gUC()
    {
      AppMethodBeat.i(145653);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145653);
    }
    
    public final void kY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(261971);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(261971);
    }
    
    public final void kZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(145649);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145649);
    }
    
    public final void t(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(145651);
      Log.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      AppMethodBeat.o(145651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */