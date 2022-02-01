package com.tencent.scanlib.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c
{
  private static c JVb;
  public ExecutorService JVa;
  private Handler handler;
  
  private c()
  {
    AppMethodBeat.i(174600);
    this.JVa = Executors.newSingleThreadExecutor();
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(174600);
  }
  
  public static c fCX()
  {
    AppMethodBeat.i(174601);
    if (JVb == null) {}
    try
    {
      if (JVb == null) {
        JVb = new c();
      }
      c localc = JVb;
      AppMethodBeat.o(174601);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(174601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a.c
 * JD-Core Version:    0.7.0.1
 */