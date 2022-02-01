package com.tencent.threadpool.e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.c.c;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final d ahBm;
  private static final ConcurrentHashMap<Looper, WeakReference<Handler>> ahBn;
  private final Looper looper;
  
  static
  {
    AppMethodBeat.i(183287);
    ahBm = new d();
    ahBn = new ConcurrentHashMap();
    AppMethodBeat.o(183287);
  }
  
  private d()
  {
    AppMethodBeat.i(183283);
    HandlerThread localHandlerThread = c.createHandlerThread("TP#Internal");
    localHandlerThread.setPriority(8);
    localHandlerThread.start();
    this.looper = localHandlerThread.getLooper();
    AppMethodBeat.o(183283);
  }
  
  public static Handler a(String paramString, Handler.Callback paramCallback)
  {
    AppMethodBeat.i(183285);
    paramString = new a(paramString, ahBm.looper, paramCallback);
    ahBn.put(ahBm.looper, new WeakReference(paramString));
    AppMethodBeat.o(183285);
    return paramString;
  }
  
  public static void release()
  {
    AppMethodBeat.i(183286);
    Iterator localIterator = ahBn.values().iterator();
    while (localIterator.hasNext())
    {
      Handler localHandler = (Handler)((WeakReference)localIterator.next()).get();
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
    }
    AppMethodBeat.o(183286);
  }
  
  static final class a
    extends Handler
  {
    private final String name;
    
    a(String paramString, Looper paramLooper, Handler.Callback paramCallback)
    {
      super(paramCallback);
      this.name = paramString;
    }
    
    public final String toString()
    {
      return this.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.e.d
 * JD-Core Version:    0.7.0.1
 */