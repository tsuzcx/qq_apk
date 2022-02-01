package com.tencent.wxperf.jni.egl;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EglHook
  extends com.tencent.wxperf.jni.a
{
  public static final EglHook Syq;
  private static final List<OnChangeListener> listeners;
  
  static
  {
    AppMethodBeat.i(199060);
    Syq = new EglHook();
    listeners = new ArrayList();
    AppMethodBeat.o(199060);
  }
  
  public static void a(OnChangeListener paramOnChangeListener)
  {
    AppMethodBeat.i(199054);
    synchronized (listeners)
    {
      listeners.add(paramOnChangeListener);
      AppMethodBeat.o(199054);
      return;
    }
  }
  
  @Keep
  public static void onCreateEglContext(long paramLong)
  {
    AppMethodBeat.i(199055);
    Log.i("Wxperf.EglHook", "onCreateEglContext callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(199055);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglContext(locala);
      }
    }
    AppMethodBeat.o(199055);
  }
  
  @Keep
  public static void onCreateEglWindowSurface(long paramLong)
  {
    AppMethodBeat.i(199058);
    Log.i("Wxperf.EglHook", "onCreateEglWindowSurface callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(199058);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglWindowSurface(locala);
      }
    }
    AppMethodBeat.o(199058);
  }
  
  @Keep
  public static void onCreatePbufferSurface(long paramLong)
  {
    AppMethodBeat.i(199059);
    Log.i("Wxperf.EglHook", "onCreatePbufferSurface callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(199059);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreatePbufferSurface(locala);
      }
    }
    AppMethodBeat.o(199059);
  }
  
  @Keep
  public static void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(199057);
    Log.i("Wxperf.EglHook", "onDeleteEglContext callback");
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(199057);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglContext(paramLong);
      }
    }
    AppMethodBeat.o(199057);
  }
  
  @Keep
  public static void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(199056);
    Log.i("Wxperf.EglHook", "onDeleteEglSurface callback");
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(199056);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglSurface(paramLong);
      }
    }
    AppMethodBeat.o(199056);
  }
  
  private native void startHook();
  
  public final void hrX() {}
  
  public final void hrY()
  {
    AppMethodBeat.i(199053);
    startHook();
    AppMethodBeat.o(199053);
  }
  
  public static abstract interface OnChangeListener
  {
    @Keep
    public abstract void onCreateEglContext(a parama);
    
    @Keep
    public abstract void onCreateEglWindowSurface(a parama);
    
    @Keep
    public abstract void onCreatePbufferSurface(a parama);
    
    @Keep
    public abstract void onDeleteEglContext(long paramLong);
    
    @Keep
    public abstract void onDeleteEglSurface(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wxperf.jni.egl.EglHook
 * JD-Core Version:    0.7.0.1
 */