package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class r<A, B>
  implements Serializable
{
  public final A bsC;
  public final B bsD;
  
  public r(A paramA, B paramB)
  {
    this.bsC = paramA;
    this.bsD = paramB;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129574);
    if (this != paramObject)
    {
      if ((paramObject instanceof r))
      {
        paramObject = (r)paramObject;
        if ((!s.p(this.bsC, paramObject.bsC)) || (!s.p(this.bsD, paramObject.bsD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(129574);
      return true;
    }
    AppMethodBeat.o(129574);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(129573);
    Object localObject = this.bsC;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.bsD;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(129573);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129572);
    String str = "(" + this.bsC + ", " + this.bsD + ')';
    AppMethodBeat.o(129572);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.r
 * JD-Core Version:    0.7.0.1
 */