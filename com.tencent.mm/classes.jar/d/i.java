package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, fOb=1)
public class i
{
  public static final <T> f<T> K(a<? extends T> parama)
  {
    AppMethodBeat.i(129243);
    d.g.b.k.h(parama, "initializer");
    parama = (f)new s(parama, (byte)0);
    AppMethodBeat.o(129243);
    return parama;
  }
  
  public static final <T> f<T> a(k paramk, a<? extends T> parama)
  {
    AppMethodBeat.i(129244);
    d.g.b.k.h(paramk, "mode");
    d.g.b.k.h(parama, "initializer");
    switch (h.cfA[paramk.ordinal()])
    {
    default: 
      paramk = new m();
      AppMethodBeat.o(129244);
      throw paramk;
    case 1: 
      paramk = (f)new s(parama, (byte)0);
      AppMethodBeat.o(129244);
      return paramk;
    case 2: 
      paramk = (f)new r(parama);
      AppMethodBeat.o(129244);
      return paramk;
    }
    paramk = (f)new z(parama);
    AppMethodBeat.o(129244);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.i
 * JD-Core Version:    0.7.0.1
 */