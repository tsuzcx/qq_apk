package com.tencent.mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.sdk.platformtools.ae;

public class ProcessService$MMProcessService
  extends CommonProcessService
{
  private CoreService.a fFV = null;
  
  public final String getTag()
  {
    return "MicroMsg.MMProcessService";
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(133210);
    try
    {
      this.fFV = ((CoreService.a)Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance());
      ae.d("MicroMsg.MMProcessService", "broadcastRegisterHelper = %s", new Object[] { this.fFV });
      this.fFV.registerBroadcasts();
      super.onCreate();
      AppMethodBeat.o(133210);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.MMProcessService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(133211);
    if (this.fFV != null) {}
    try
    {
      this.fFV.unRegisterBroadcasts();
      super.onDestroy();
      AppMethodBeat.o(133211);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.MMProcessService", "onDestroy unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.ProcessService.MMProcessService
 * JD-Core Version:    0.7.0.1
 */