package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends d
{
  public a agvz;
  private String bjg;
  Looper mLooper;
  
  public h(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
    AppMethodBeat.i(74915);
    AppMethodBeat.o(74915);
  }
  
  private h(Looper paramLooper, a parama, String paramString)
  {
    this.mLooper = paramLooper;
    this.agvz = parama;
    this.bjg = paramString;
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
  
  public void arrange(Runnable paramRunnable)
  {
    AppMethodBeat.i(74919);
    this.agvz.post(paramRunnable);
    AppMethodBeat.o(74919);
  }
  
  public void arrangeInterval(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(74920);
    if (paramLong >= 0L)
    {
      this.agvz.d(paramRunnable, paramLong);
      AppMethodBeat.o(74920);
      return;
    }
    this.agvz.post(paramRunnable);
    AppMethodBeat.o(74920);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(74918);
    this.agvz.Fg();
    AppMethodBeat.o(74918);
  }
  
  public String getType()
  {
    return this.bjg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.h.h
 * JD-Core Version:    0.7.0.1
 */