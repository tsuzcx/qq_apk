package com.tencent.threadpool.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;

public final class c
{
  public static Future<?> bq(Runnable paramRunnable)
  {
    AppMethodBeat.i(226852);
    paramRunnable = b.jZF().bq(paramRunnable);
    AppMethodBeat.o(226852);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.k.c
 * JD-Core Version:    0.7.0.1
 */