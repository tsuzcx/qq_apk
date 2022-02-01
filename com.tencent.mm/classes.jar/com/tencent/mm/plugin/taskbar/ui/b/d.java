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
  public com.tencent.threadpool.i.d<?> Lox;
  public boolean Uz;
  private WeakReference<Context> mvP;
  public HashMap<Integer, b> mvQ;
  public final Object mvS;
  
  static
  {
    AppMethodBeat.i(264218);
    STS = new d("INSTANCE");
    STT = new d[] { STS };
    AppMethodBeat.o(264218);
  }
  
  private d()
  {
    AppMethodBeat.i(264198);
    this.mvP = null;
    this.mvQ = new HashMap();
    this.Uz = false;
    this.Lox = null;
    this.mvS = new Object();
    AppMethodBeat.o(264198);
  }
  
  public final void aYb()
  {
    AppMethodBeat.i(264226);
    synchronized (this.mvS)
    {
      if (!this.Uz)
      {
        AppMethodBeat.o(264226);
        return;
      }
      if (this.Lox != null) {
        this.Lox.cancel(false);
      }
      this.Uz = false;
      AppMethodBeat.o(264226);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(264232);
    Log.i("MicroMsg.PerformanceMonitor", "alvinluo PerformanceMonitor release");
    if (this.mvQ != null) {
      this.mvQ.clear();
    }
    AppMethodBeat.o(264232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.b.d
 * JD-Core Version:    0.7.0.1
 */