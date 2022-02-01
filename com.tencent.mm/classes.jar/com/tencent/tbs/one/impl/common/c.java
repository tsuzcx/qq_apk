package com.tencent.tbs.one.impl.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;

public class c<T>
  extends l<T>
{
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(174184);
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174190);
        c.a(c.this, paramInt1, paramInt2);
        AppMethodBeat.o(174190);
      }
    });
    AppMethodBeat.o(174184);
  }
  
  public void a(final int paramInt, final String paramString, final Throwable paramThrowable)
  {
    AppMethodBeat.i(174186);
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174183);
        c.a(c.this, paramInt, paramString, paramThrowable);
        AppMethodBeat.o(174183);
      }
    });
    AppMethodBeat.o(174186);
  }
  
  public void a(final T paramT)
  {
    AppMethodBeat.i(174185);
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174255);
        c.a(c.this, paramT);
        AppMethodBeat.o(174255);
      }
    });
    AppMethodBeat.o(174185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.c
 * JD-Core Version:    0.7.0.1
 */