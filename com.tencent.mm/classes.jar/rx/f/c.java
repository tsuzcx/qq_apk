package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> Kti;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.Kti = new AtomicReference(new a(false, d.fOi()));
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
    AtomicReference localAtomicReference = this.Kti;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.KqK)
      {
        paramj.fNw();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.Kti;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.KqK)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.fOh()));
    locala.Kra.fNw();
    AppMethodBeat.o(90451);
  }
  
  public final boolean fNx()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.Kti.get()).KqK;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final boolean KqK;
    final j Kra;
    
    a(boolean paramBoolean, j paramj)
    {
      this.KqK = paramBoolean;
      this.Kra = paramj;
    }
    
    final a fOh()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.Kra);
      AppMethodBeat.o(90447);
      return locala;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.KqK, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */