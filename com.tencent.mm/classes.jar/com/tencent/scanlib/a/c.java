package com.tencent.scanlib.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c
{
  private static c ahvL;
  public ExecutorService ahvK;
  private Handler handler;
  
  private c()
  {
    AppMethodBeat.i(174600);
    this.ahvK = Executors.newSingleThreadExecutor();
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(174600);
  }
  
  public static c jXL()
  {
    AppMethodBeat.i(174601);
    if (ahvL == null) {}
    try
    {
      if (ahvL == null) {
        ahvL = new c();
      }
      c localc = ahvL;
      AppMethodBeat.o(174601);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(174601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.a.c
 * JD-Core Version:    0.7.0.1
 */