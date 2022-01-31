package com.tencent.mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class ProcessService
{
  public static ConcurrentHashMap<String, b> ytN;
  
  static
  {
    AppMethodBeat.i(58945);
    ytN = new ConcurrentHashMap();
    AppMethodBeat.o(58945);
  }
  
  public static class MMProcessService
    extends CommonProcessService
  {
    private CoreService.a dYD = null;
    
    public final String getTag()
    {
      return "MicroMsg.MMProcessService";
    }
    
    public void onCreate()
    {
      AppMethodBeat.i(58943);
      try
      {
        this.dYD = ((CoreService.a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
        ab.d("MicroMsg.MMProcessService", "broadcastRegisterHelper = %s", new Object[] { this.dYD });
        this.dYD.registerBroadcasts();
        super.onCreate();
        AppMethodBeat.o(58943);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMProcessService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException.getMessage() });
        }
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(58944);
      if (this.dYD != null) {}
      try
      {
        this.dYD.unRegisterBroadcasts();
        super.onDestroy();
        AppMethodBeat.o(58944);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMProcessService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public static class SandBoxProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.SandBoxProcessService";
    }
  }
  
  public static class ToolsmpProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.ToolsmpProcessService";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.service.ProcessService
 * JD-Core Version:    0.7.0.1
 */