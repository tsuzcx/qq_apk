package com.tencent.mm.sdk.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.g.b.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
{
  public static a a(String paramString, BlockingQueue<Runnable> paramBlockingQueue)
  {
    AppMethodBeat.i(52700);
    if (com.tencent.mm.sdk.g.d.ysi)
    {
      paramString = new d.a(paramString, 6);
      AppMethodBeat.o(52700);
      return paramString;
    }
    paramString = new c(paramString, paramBlockingQueue);
    AppMethodBeat.o(52700);
    return paramString;
  }
  
  public static a aqx(String paramString)
  {
    AppMethodBeat.i(52701);
    if (com.tencent.mm.sdk.g.d.ysi)
    {
      paramString = new d.a(paramString, 1);
      AppMethodBeat.o(52701);
      return paramString;
    }
    paramString = new c(paramString, 1, 1, new LinkedBlockingQueue());
    AppMethodBeat.o(52701);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.g.c.d
 * JD-Core Version:    0.7.0.1
 */