package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> MgR;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.MgR = new AtomicReference(new a(false, d.ggY()));
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
    AtomicReference localAtomicReference = this.MgR;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.Met)
      {
        paramj.ggm();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void ggm()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.MgR;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.Met)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.ggX()));
    locala.MeJ.ggm();
    AppMethodBeat.o(90451);
  }
  
  public final boolean ggn()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.MgR.get()).Met;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final j MeJ;
    final boolean Met;
    
    a(boolean paramBoolean, j paramj)
    {
      this.Met = paramBoolean;
      this.MeJ = paramj;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.Met, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
    
    final a ggX()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.MeJ);
      AppMethodBeat.o(90447);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */