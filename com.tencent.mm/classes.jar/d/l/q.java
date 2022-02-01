package d.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"})
public final class q
{
  private static final q MMB;
  public static final a MMC;
  private final o MMA;
  private final r MMz;
  
  static
  {
    AppMethodBeat.i(129547);
    MMC = new a((byte)0);
    MMB = new q(null, null);
    AppMethodBeat.o(129547);
  }
  
  public q(r paramr, o paramo)
  {
    this.MMz = paramr;
    this.MMA = paramo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129550);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((!p.i(this.MMz, paramObject.MMz)) || (!p.i(this.MMA, paramObject.MMA))) {}
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
    Object localObject = this.MMz;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.MMA;
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
    String str = "KTypeProjection(variance=" + this.MMz + ", type=" + this.MMA + ")";
    AppMethodBeat.o(129548);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.q
 * JD-Core Version:    0.7.0.1
 */