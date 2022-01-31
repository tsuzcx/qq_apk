package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class aq
{
  private ThreadPoolExecutor a;
  
  private aq()
  {
    AppMethodBeat.i(147241);
    this.a = ((ThreadPoolExecutor)Executors.newCachedThreadPool(new ae("halley_" + ac.c() + "_" + "BusinessTaskPool")));
    AppMethodBeat.o(147241);
  }
  
  public static aq a()
  {
    AppMethodBeat.i(147242);
    aq localaq = aq.a.a();
    AppMethodBeat.o(147242);
    return localaq;
  }
  
  public final ThreadPoolExecutor b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.aq
 * JD-Core Version:    0.7.0.1
 */