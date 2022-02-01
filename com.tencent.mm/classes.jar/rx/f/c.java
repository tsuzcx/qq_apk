package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c
  implements j
{
  final AtomicReference<a> UoL;
  
  public c()
  {
    AppMethodBeat.i(90449);
    this.UoL = new AtomicReference(new a(false, d.hRm()));
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
    AtomicReference localAtomicReference = this.UoL;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.Umo)
      {
        paramj.hQA();
        AppMethodBeat.o(90452);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.g(paramj)));
    AppMethodBeat.o(90452);
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90451);
    AtomicReference localAtomicReference = this.UoL;
    a locala;
    do
    {
      locala = (a)localAtomicReference.get();
      if (locala.Umo)
      {
        AppMethodBeat.o(90451);
        return;
      }
    } while (!localAtomicReference.compareAndSet(locala, locala.hRl()));
    locala.UmE.hQA();
    AppMethodBeat.o(90451);
  }
  
  public final boolean hQB()
  {
    AppMethodBeat.i(90450);
    boolean bool = ((a)this.UoL.get()).Umo;
    AppMethodBeat.o(90450);
    return bool;
  }
  
  static final class a
  {
    final j UmE;
    final boolean Umo;
    
    a(boolean paramBoolean, j paramj)
    {
      this.Umo = paramBoolean;
      this.UmE = paramj;
    }
    
    final a g(j paramj)
    {
      AppMethodBeat.i(90448);
      paramj = new a(this.Umo, paramj);
      AppMethodBeat.o(90448);
      return paramj;
    }
    
    final a hRl()
    {
      AppMethodBeat.i(90447);
      a locala = new a(true, this.UmE);
      AppMethodBeat.o(90447);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.f.c
 * JD-Core Version:    0.7.0.1
 */