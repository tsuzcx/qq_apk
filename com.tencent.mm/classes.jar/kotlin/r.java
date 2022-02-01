package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.p;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class r<A, B, C>
  implements Serializable
{
  public final C SWY;
  public final A first;
  public final B second;
  
  public r(A paramA, B paramB, C paramC)
  {
    this.first = paramA;
    this.second = paramB;
    this.SWY = paramC;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129588);
    if (this != paramObject)
    {
      if ((paramObject instanceof r))
      {
        paramObject = (r)paramObject;
        if ((!p.j(this.first, paramObject.first)) || (!p.j(this.second, paramObject.second)) || (!p.j(this.SWY, paramObject.SWY))) {}
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
    Object localObject = this.first;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.second;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.SWY;
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
    String str = "(" + this.first + ", " + this.second + ", " + this.SWY + ')';
    AppMethodBeat.o(129586);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.r
 * JD-Core Version:    0.7.0.1
 */