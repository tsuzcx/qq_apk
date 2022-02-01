package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> ObT;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.ObT = new AtomicReference(new a(false, d.gzC()));
    AppMethodBeat.o(90449);
  }
  
  public final void f(j paramj)
  {
    AppMethodBeat.i(90452);
    if (paramj == null)
    {
      paramj = new IllegalArgumentException("Subscription can not be null");
      AppMethodBeat.o(90452);
      throw paramj;
    }
    AtomicReference localAtomicReference = this.ObT;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.NZv)
      {
        paramj.gyQ();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void gyQ()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.ObT;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.NZv)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.gzB()));
    locala.NZL.gyQ();
    AppMethodBeat.o(90451);
  }
  
  public final boolean gyR()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.ObT.get()).NZv;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final j NZL;
    final boolean NZv;
    
    a(boolean paramBoolean, j paramj)
    {
      this.NZv = paramBoolean;
      this.NZL = paramj;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.NZv, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
    
    final a gzB()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.NZL);
      AppMethodBeat.o(90447);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */