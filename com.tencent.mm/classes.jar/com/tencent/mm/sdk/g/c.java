package com.tencent.mm.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.c.a;
import com.tencent.mm.sdk.g.a.e;

public final class c
  implements com.tencent.mm.sdk.g.a.c
{
  private e ysf;
  private c.a ysg;
  
  public c(e parame)
  {
    this.ysf = parame;
  }
  
  public final void a(c.a parama)
  {
    this.ysg = parama;
  }
  
  public final void a(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(52532);
    a(paramRunnable, paramString, 0L);
    AppMethodBeat.o(52532);
  }
  
  public final void a(Runnable paramRunnable, String paramString, long paramLong)
  {
    AppMethodBeat.i(52533);
    if (0L >= paramLong)
    {
      this.ysf.b(paramRunnable, paramString);
      AppMethodBeat.o(52533);
      return;
    }
    this.ysf.b(paramRunnable, paramString, paramLong);
    AppMethodBeat.o(52533);
  }
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(52530);
    q(paramRunnable, 0L);
    AppMethodBeat.o(52530);
  }
  
  public final void ak(Runnable paramRunnable)
  {
    AppMethodBeat.i(52534);
    this.ysf.remove(paramRunnable);
    AppMethodBeat.o(52534);
  }
  
  public final void q(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52531);
    if (0L >= paramLong)
    {
      this.ysf.execute(paramRunnable);
      AppMethodBeat.o(52531);
      return;
    }
    this.ysf.r(paramRunnable, paramLong);
    AppMethodBeat.o(52531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.c
 * JD-Core Version:    0.7.0.1
 */