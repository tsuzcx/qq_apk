package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/LazyKt")
public class m
{
  public static final <T> j<T> a(o paramo, a<? extends T> parama)
  {
    AppMethodBeat.i(129244);
    kotlin.g.b.s.u(paramo, "mode");
    kotlin.g.b.s.u(parama, "initializer");
    switch (l.$EnumSwitchMapping$0[paramo.ordinal()])
    {
    default: 
      paramo = new p();
      AppMethodBeat.o(129244);
      throw paramo;
    case 1: 
      paramo = (j)new t(parama, (byte)0);
      AppMethodBeat.o(129244);
      return paramo;
    case 2: 
      paramo = (j)new s(parama);
      AppMethodBeat.o(129244);
      return paramo;
    }
    paramo = (j)new ai(parama);
    AppMethodBeat.o(129244);
    return paramo;
  }
  
  public static final <T> j<T> cm(a<? extends T> parama)
  {
    AppMethodBeat.i(129243);
    kotlin.g.b.s.u(parama, "initializer");
    parama = (j)new t(parama, (byte)0);
    AppMethodBeat.o(129243);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m
 * JD-Core Version:    0.7.0.1
 */