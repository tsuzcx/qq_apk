package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> OyY;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.OyY = new AtomicReference(new a(false, d.gEe()));
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
    AtomicReference localAtomicReference = this.OyY;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.OwA)
      {
        paramj.gDs();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void gDs()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.OyY;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.OwA)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.gEd()));
    locala.OwQ.gDs();
    AppMethodBeat.o(90451);
  }
  
  public final boolean gDt()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.OyY.get()).OwA;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final boolean OwA;
    final j OwQ;
    
    a(boolean paramBoolean, j paramj)
    {
      this.OwA = paramBoolean;
      this.OwQ = paramj;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.OwA, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
    
    final a gEd()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.OwQ);
      AppMethodBeat.o(90447);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */