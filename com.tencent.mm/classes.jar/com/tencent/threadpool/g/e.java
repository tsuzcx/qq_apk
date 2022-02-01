package com.tencent.threadpool.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class e
  extends b
{
  public e(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final long a(g paramg, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183326);
    long l1 = paramg.getLong("INCREMENT", 1L);
    long l2 = paramg.getLong("LAST_INCREMENT", 0L) + l1;
    paramg.cG("LAST_INCREMENT", l1);
    paramg.cG("INCREMENT", l2);
    l1 = paramTimeUnit.convert(l2, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(183326);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.g.e
 * JD-Core Version:    0.7.0.1
 */