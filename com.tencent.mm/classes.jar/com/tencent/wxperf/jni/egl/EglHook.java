package com.tencent.wxperf.jni.egl;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EglHook
  extends com.tencent.wxperf.jni.a
{
  private static EglHook.a MLB;
  public static final EglHook MLC;
  private static final List<OnChangeListener> listeners;
  
  static
  {
    AppMethodBeat.i(195212);
    MLB = new EglHook.a.a();
    MLC = new EglHook();
    listeners = new ArrayList();
    AppMethodBeat.o(195212);
  }
  
  public static void a(OnChangeListener paramOnChangeListener)
  {
    AppMethodBeat.i(195206);
    synchronized (listeners)
    {
      listeners.add(paramOnChangeListener);
      AppMethodBeat.o(195206);
      return;
    }
  }
  
  @Deprecated
  public static void a(EglHook.a parama)
  {
    MLB = parama;
  }
  
  @Keep
  public static void onCreateEglContext(long paramLong)
  {
    AppMethodBeat.i(195207);
    MLB.e("Cc1over-debug", "onCreateEglContext callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195207);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglContext(locala);
      }
    }
    AppMethodBeat.o(195207);
  }
  
  @Keep
  public static void onCreateEglWindowSurface(long paramLong)
  {
    AppMethodBeat.i(195210);
    MLB.e("Cc1over-debug", "onCreateEglWindowSurface callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195210);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglWindowSurface(locala);
      }
    }
    AppMethodBeat.o(195210);
  }
  
  @Keep
  public static void onCreatePbufferSurface(long paramLong)
  {
    AppMethodBeat.i(195211);
    MLB.e("Cc1over-debug", "onCreatePbufferSurface callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195211);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreatePbufferSurface(locala);
      }
    }
    AppMethodBeat.o(195211);
  }
  
  @Keep
  public static void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(195209);
    MLB.e("Cc1over-debug", "onDeleteEglContext callback");
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195209);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglContext(paramLong);
      }
    }
    AppMethodBeat.o(195209);
  }
  
  @Keep
  public static void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(195208);
    MLB.e("Cc1over-debug", "onDeleteEglSurface callback");
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(195208);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglSurface(paramLong);
      }
    }
    AppMethodBeat.o(195208);
  }
  
  private native void startHook();
  
  public final void geH() {}
  
  public final void geI()
  {
    AppMethodBeat.i(195205);
    startHook();
    AppMethodBeat.o(195205);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wxperf.jni.egl.EglHook
 * JD-Core Version:    0.7.0.1
 */