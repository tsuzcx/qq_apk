package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends d
{
  public a HQU;
  Looper mLooper;
  public String mType;
  
  public h(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
    AppMethodBeat.i(74915);
    AppMethodBeat.o(74915);
  }
  
  private h(Looper paramLooper, a parama, String paramString)
  {
    this.mLooper = paramLooper;
    this.HQU = parama;
    this.mType = paramString;
  }
  
  public h(Looper paramLooper, String paramString)
  {
    this(new Handler(paramLooper), paramString);
    AppMethodBeat.i(74917);
    AppMethodBeat.o(74917);
  }
  
  public h(a parama, String paramString)
  {
    this(parama.getLooper(), parama, paramString);
    AppMethodBeat.i(74916);
    AppMethodBeat.o(74916);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(74918);
    this.HQU.fm();
    AppMethodBeat.o(74918);
  }
  
  public final void f(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(74920);
    if (paramLong >= 0L)
    {
      this.HQU.c(paramRunnable, paramLong);
      AppMethodBeat.o(74920);
      return;
    }
    this.HQU.post(paramRunnable);
    AppMethodBeat.o(74920);
  }
  
  public final String getType()
  {
    return this.mType;
  }
  
  public final void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(74919);
    this.HQU.post(paramRunnable);
    AppMethodBeat.o(74919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.h
 * JD-Core Version:    0.7.0.1
 */