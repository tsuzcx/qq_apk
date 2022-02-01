package d.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"})
public final class q
{
  private static final q Jib;
  public static final a Jic;
  private final r JhZ;
  private final o Jia;
  
  static
  {
    AppMethodBeat.i(129547);
    Jic = new a((byte)0);
    Jib = new q(null, null);
    AppMethodBeat.o(129547);
  }
  
  public q(r paramr, o paramo)
  {
    this.JhZ = paramr;
    this.Jia = paramo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129550);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((!k.g(this.JhZ, paramObject.JhZ)) || (!k.g(this.Jia, paramObject.Jia))) {}
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
    Object localObject = this.JhZ;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Jia;
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
    String str = "KTypeProjection(variance=" + this.JhZ + ", type=" + this.Jia + ")";
    AppMethodBeat.o(129548);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.q
 * JD-Core Version:    0.7.0.1
 */