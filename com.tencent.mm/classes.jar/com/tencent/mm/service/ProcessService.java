package com.tencent.mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public final class ProcessService
{
  public static ConcurrentHashMap<String, b> NKc;
  
  static
  {
    AppMethodBeat.i(133212);
    NKc = new ConcurrentHashMap();
    AppMethodBeat.o(133212);
  }
  
  public static class DexOptProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.DexOptProcessService";
    }
  }
  
  public static class ExDeviceProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.ExDeviceProcessService";
    }
  }
  
  public static class LiteProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.LiteProcessService";
    }
  }
  
  public static class MMProcessService
    extends CommonProcessService
  {
    private CoreService.a glf = null;
    
    public final String getTag()
    {
      return "MicroMsg.MMProcessService";
    }
    
    public void onCreate()
    {
      AppMethodBeat.i(133210);
      try
      {
        this.glf = ((CoreService.a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
        Log.d("MicroMsg.MMProcessService", "broadcastRegisterHelper = %s", new Object[] { this.glf });
        this.glf.registerBroadcasts();
        super.onCreate();
        AppMethodBeat.o(133210);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMProcessService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException.getMessage() });
        }
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(133211);
      if (this.glf != null) {}
      try
      {
        this.glf.unRegisterBroadcasts();
        super.onDestroy();
        AppMethodBeat.o(133211);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMProcessService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public static class PushProcessServicer
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.PushProcessServicer";
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
  
  public static class SupportProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.SupportProcessService";
    }
  }
  
  public static class ToolsProcessService
    extends CommonProcessService
  {
    public final String getTag()
    {
      return "MicroMsg.ToolsProcessService";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.ProcessService
 * JD-Core Version:    0.7.0.1
 */