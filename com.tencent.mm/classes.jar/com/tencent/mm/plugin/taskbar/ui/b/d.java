package com.tencent.mm.plugin.taskbar.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;

public enum d
{
  public com.tencent.e.i.d<?> FpU;
  public boolean isRunning;
  private WeakReference<Context> jVV;
  public HashMap<Integer, b> jVW;
  public final Object jVY;
  
  static
  {
    AppMethodBeat.i(215736);
    MqG = new d("INSTANCE");
    MqH = new d[] { MqG };
    AppMethodBeat.o(215736);
  }
  
  private d()
  {
    AppMethodBeat.i(215733);
    this.jVV = null;
    this.jVW = new HashMap();
    this.isRunning = false;
    this.FpU = null;
    this.jVY = new Object();
    AppMethodBeat.o(215733);
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(215734);
    synchronized (this.jVY)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(215734);
        return;
      }
      if (this.FpU != null) {
        this.FpU.cancel(false);
      }
      this.isRunning = false;
      AppMethodBeat.o(215734);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(215735);
    Log.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.jVW != null) {
      this.jVW.clear();
    }
    AppMethodBeat.o(215735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.b.d
 * JD-Core Version:    0.7.0.1
 */