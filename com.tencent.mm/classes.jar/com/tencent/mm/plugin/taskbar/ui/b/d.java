package com.tencent.mm.plugin.taskbar.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public enum d
{
  private WeakReference<Context> hkm;
  public HashMap<Integer, b> hkn;
  public final Object hkp;
  public boolean isRunning;
  public Timer mTimer;
  
  static
  {
    AppMethodBeat.i(238329);
    FVl = new d("INSTANCE");
    FVm = new d[] { FVl };
    AppMethodBeat.o(238329);
  }
  
  private d()
  {
    AppMethodBeat.i(238326);
    this.hkm = null;
    this.hkn = new HashMap();
    this.isRunning = false;
    this.mTimer = null;
    this.hkp = new Object();
    AppMethodBeat.o(238326);
  }
  
  public final void axH()
  {
    AppMethodBeat.i(238327);
    synchronized (this.hkp)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(238327);
        return;
      }
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      this.isRunning = false;
      AppMethodBeat.o(238327);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(238328);
    Log.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.hkn != null) {
      this.hkn.clear();
    }
    AppMethodBeat.o(238328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.b.d
 * JD-Core Version:    0.7.0.1
 */