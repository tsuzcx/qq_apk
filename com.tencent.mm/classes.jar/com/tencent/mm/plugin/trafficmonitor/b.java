package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;
import java.util.TimerTask;

public final class b
  extends c
{
  public final String TAG = "MicroMsg.FileTrafficStatsInspector";
  private Timer oTD = null;
  private boolean started;
  private TimerTask tog = null;
  
  public final void cKM()
  {
    AppMethodBeat.i(114757);
    if (this.started)
    {
      AppMethodBeat.o(114757);
      return;
    }
    this.currentIndex = 0;
    a.init(this.id);
    a.reset(this.id);
    a.update(this.id);
    this.tog = new b.1(this);
    this.oTD = new Timer();
    try
    {
      this.oTD.schedule(this.tog, 0L, this.interval);
      this.started = true;
      AppMethodBeat.o(114757);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FileTrafficStatsInspector", "timer.schedule got an IllegalArgumentException, %s", new Object[] { localIllegalArgumentException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.b
 * JD-Core Version:    0.7.0.1
 */