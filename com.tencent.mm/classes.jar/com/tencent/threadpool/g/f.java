package com.tencent.threadpool.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class f
  extends b
{
  private final long ahBG = 1000L;
  private final float htO = 500.0F;
  
  public f(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final long a(g paramg, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183327);
    Object localObject = paramg.map.get("incrementCount");
    if (localObject == null) {}
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      long l = ((float)this.ahBG + i * this.htO);
      paramg.map.put("incrementCount", Integer.valueOf(i + 1));
      l = paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(183327);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.g.f
 * JD-Core Version:    0.7.0.1
 */