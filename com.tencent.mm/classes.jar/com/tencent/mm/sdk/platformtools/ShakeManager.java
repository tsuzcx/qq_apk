package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ShakeManager
{
  private static final String TAG = "MicroMsg.ShakeManager";
  private ShakeManager.ShakeSensorListener listener;
  private SensorManager manager;
  
  public ShakeManager(Context paramContext)
  {
    AppMethodBeat.i(157832);
    this.manager = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(157832);
  }
  
  public boolean startShake(Runnable paramRunnable)
  {
    AppMethodBeat.i(157833);
    if (this.manager == null)
    {
      AppMethodBeat.o(157833);
      return false;
    }
    List localList = this.manager.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.listener = new ShakeManager.ShakeSensorListener(paramRunnable);
      this.manager.registerListener(this.listener, 2, 3);
      AppMethodBeat.o(157833);
      return true;
    }
    AppMethodBeat.o(157833);
    return false;
  }
  
  public void stopShake()
  {
    AppMethodBeat.i(157834);
    if ((this.manager != null) && (this.listener != null)) {
      this.manager.unregisterListener(this.listener, 2);
    }
    AppMethodBeat.o(157834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ShakeManager
 * JD-Core Version:    0.7.0.1
 */