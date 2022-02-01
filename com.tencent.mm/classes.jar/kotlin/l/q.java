package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"})
public final class q
{
  private static final q SZo;
  public static final a SZp;
  private final r SZm;
  private final o SZn;
  
  static
  {
    AppMethodBeat.i(129547);
    SZp = new a((byte)0);
    SZo = new q(null, null);
    AppMethodBeat.o(129547);
  }
  
  public q(r paramr, o paramo)
  {
    this.SZm = paramr;
    this.SZn = paramo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129550);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((!p.j(this.SZm, paramObject.SZm)) || (!p.j(this.SZn, paramObject.SZn))) {}
      }
    }
    else
    {
      AppMethodBeat.o(129550);
      return true;
    }
    AppMethodBeat.o(129550);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(129549);
    Object localObject = this.SZm;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.SZn;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(129549);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129548);
    String str = "KTypeProjection(variance=" + this.SZm + ", type=" + this.SZn + ")";
    AppMethodBeat.o(129548);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.q
 * JD-Core Version:    0.7.0.1
 */