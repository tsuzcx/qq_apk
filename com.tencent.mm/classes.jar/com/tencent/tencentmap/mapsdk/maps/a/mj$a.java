package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;

class mj$a<T, S extends mq>
  implements nw
{
  private final nx<? super md<T, S>> a;
  private final mg<T, S> b;
  private final oe<? super mq, Boolean> c;
  private volatile mw<mh<T, S>> d;
  private final AtomicLong e;
  
  mj$a(mg<T, S> parammg, oe<? super mq, Boolean> paramoe, nx<? super md<T, S>> paramnx)
  {
    AppMethodBeat.i(149304);
    this.e = new AtomicLong(0L);
    this.b = parammg;
    this.c = paramoe;
    this.a = paramnx;
    this.d = mw.a(new mh(parammg, 0));
    AppMethodBeat.o(149304);
  }
  
  private void a()
  {
    AppMethodBeat.i(149306);
    this.e.set(9223372036854775807L);
    this.b.a(this.c, this.a);
    if (!this.a.c()) {
      this.a.a();
    }
    AppMethodBeat.o(149306);
  }
  
  private void b(long paramLong)
  {
    AppMethodBeat.i(149307);
    if (this.e.getAndAdd(paramLong) == 0L)
    {
      label82:
      do
      {
        for (;;)
        {
          paramLong = this.e.get();
          this.d = ma.a(this.c, this.a, this.d, paramLong);
          if (!this.d.b()) {
            break label82;
          }
          if (this.a.c()) {
            break;
          }
          this.a.a();
        }
        AppMethodBeat.o(149307);
        return;
      } while (this.e.addAndGet(-paramLong) != 0L);
      AppMethodBeat.o(149307);
      return;
    }
    AppMethodBeat.o(149307);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(149305);
    if (paramLong != 0L) {}
    try
    {
      long l = this.e.get();
      if (l == 9223372036854775807L)
      {
        AppMethodBeat.o(149305);
        return;
      }
      if (paramLong == 9223372036854775807L)
      {
        a();
        AppMethodBeat.o(149305);
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      this.a.a(localRuntimeException);
      AppMethodBeat.o(149305);
      return;
    }
    b(paramLong);
    AppMethodBeat.o(149305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mj.a
 * JD-Core Version:    0.7.0.1
 */