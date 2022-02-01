package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, iBN=1)
public class i
{
  public static final <T> f<T> a(k paramk, a<? extends T> parama)
  {
    AppMethodBeat.i(129244);
    kotlin.g.b.p.k(paramk, "mode");
    kotlin.g.b.p.k(parama, "initializer");
    switch (h.$EnumSwitchMapping$0[paramk.ordinal()])
    {
    default: 
      paramk = new m();
      AppMethodBeat.o(129244);
      throw paramk;
    case 1: 
      paramk = (f)new q(parama, (byte)0);
      AppMethodBeat.o(129244);
      return paramk;
    case 2: 
      paramk = (f)new p(parama);
      AppMethodBeat.o(129244);
      return paramk;
    }
    paramk = (f)new y(parama);
    AppMethodBeat.o(129244);
    return paramk;
  }
  
  public static final <T> f<T> ar(a<? extends T> parama)
  {
    AppMethodBeat.i(129243);
    kotlin.g.b.p.k(parama, "initializer");
    parama = (f)new q(parama, (byte)0);
    AppMethodBeat.o(129243);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.i
 * JD-Core Version:    0.7.0.1
 */