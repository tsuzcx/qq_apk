package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> akeS;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.akeS = new AtomicReference(new a(false, d.kKX()));
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
    AtomicReference localAtomicReference = this.akeS;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.akcC)
      {
        paramj.kKh();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.akeS;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.akcC)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.kKW()));
    locala.akcS.kKh();
    AppMethodBeat.o(90451);
  }
  
  public final boolean kKi()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.akeS.get()).akcC;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final boolean akcC;
    final j akcS;
    
    a(boolean paramBoolean, j paramj)
    {
      this.akcC = paramBoolean;
      this.akcS = paramj;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.akcC, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
    
    final a kKW()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.akcS);
      AppMethodBeat.o(90447);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */