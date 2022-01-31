package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;

class lu$1
  implements ThreadFactory
{
  lu$1(lu paramlu) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(149232);
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setPriority(3);
    AppMethodBeat.o(149232);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lu.1
 * JD-Core Version:    0.7.0.1
 */