package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class u<A, B, C>
  implements Serializable
{
  public final C aiuN;
  public final A bsC;
  public final B bsD;
  
  public u(A paramA, B paramB, C paramC)
  {
    this.bsC = paramA;
    this.bsD = paramB;
    this.aiuN = paramC;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129588);
    if (this != paramObject)
    {
      if ((paramObject instanceof u))
      {
        paramObject = (u)paramObject;
        if ((!s.p(this.bsC, paramObject.bsC)) || (!s.p(this.bsD, paramObject.bsD)) || (!s.p(this.aiuN, paramObject.aiuN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(129588);
      return true;
    }
    AppMethodBeat.o(129588);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(129587);
    Object localObject = this.bsC;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.bsD;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.aiuN;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(129587);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129586);
    String str = "(" + this.bsC + ", " + this.bsD + ", " + this.aiuN + ')';
    AppMethodBeat.o(129586);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.u
 * JD-Core Version:    0.7.0.1
 */