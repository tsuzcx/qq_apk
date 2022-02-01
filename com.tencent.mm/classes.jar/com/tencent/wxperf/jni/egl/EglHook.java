package com.tencent.wxperf.jni.egl;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EglHook
  extends com.tencent.wxperf.jni.a
{
  private static EglHook.a MoF;
  public static final EglHook MoG;
  private static final List<OnChangeListener> listeners;
  
  static
  {
    AppMethodBeat.i(211541);
    MoF = new EglHook.a.a();
    MoG = new EglHook();
    listeners = new ArrayList();
    AppMethodBeat.o(211541);
  }
  
  public static void a(OnChangeListener paramOnChangeListener)
  {
    AppMethodBeat.i(211535);
    synchronized (listeners)
    {
      listeners.add(paramOnChangeListener);
      AppMethodBeat.o(211535);
      return;
    }
  }
  
  public static void a(EglHook.a parama)
  {
    MoF = parama;
  }
  
  @Keep
  public static void onCreateEglContext(long paramLong)
  {
    AppMethodBeat.i(211536);
    MoF.e("Cc1over-debug", "onCreateEglContext callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(211536);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglContext(locala);
      }
    }
    AppMethodBeat.o(211536);
  }
  
  @Keep
  public static void onCreateEglWindowSurface(long paramLong)
  {
    AppMethodBeat.i(211539);
    MoF.e("Cc1over-debug", "onCreateEglWindowSurface callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(211539);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreateEglWindowSurface(locala);
      }
    }
    AppMethodBeat.o(211539);
  }
  
  @Keep
  public static void onCreatePbufferSurface(long paramLong)
  {
    AppMethodBeat.i(211540);
    MoF.e("Cc1over-debug", "onCreatePbufferSurface callback");
    a locala = new a(paramLong);
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(211540);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onCreatePbufferSurface(locala);
      }
    }
    AppMethodBeat.o(211540);
  }
  
  @Keep
  public static void onDeleteEglContext(long paramLong)
  {
    AppMethodBeat.i(211538);
    MoF.e("Cc1over-debug", "onDeleteEglContext callback");
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(211538);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglContext(paramLong);
      }
    }
    AppMethodBeat.o(211538);
  }
  
  @Keep
  public static void onDeleteEglSurface(long paramLong)
  {
    AppMethodBeat.i(211537);
    MoF.e("Cc1over-debug", "onDeleteEglSurface callback");
    synchronized (listeners)
    {
      if (listeners.size() == 0)
      {
        AppMethodBeat.o(211537);
        return;
      }
      Iterator localIterator = listeners.iterator();
      if (localIterator.hasNext()) {
        ((OnChangeListener)localIterator.next()).onDeleteEglSurface(paramLong);
      }
    }
    AppMethodBeat.o(211537);
  }
  
  private native void startHook();
  
  public final void gaf() {}
  
  public final void gag()
  {
    AppMethodBeat.i(211534);
    startHook();
    AppMethodBeat.o(211534);
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