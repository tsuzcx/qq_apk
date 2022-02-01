package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> abSa;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.abSa = new AtomicReference(new a(false, d.iWw()));
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
    AtomicReference localAtomicReference = this.abSa;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.abPK)
      {
        paramj.iVJ();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void iVJ()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.abSa;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.abPK)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.iWv()));
    locala.abQa.iVJ();
    AppMethodBeat.o(90451);
  }
  
  public final boolean iVK()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.abSa.get()).abPK;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final boolean abPK;
    final j abQa;
    
    a(boolean paramBoolean, j paramj)
    {
      this.abPK = paramBoolean;
      this.abQa = paramj;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.abPK, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
    
    final a iWv()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.abQa);
      AppMethodBeat.o(90447);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */