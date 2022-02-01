package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import java.io.Serializable;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class t<A, B, C>
  implements Serializable
{
  public final C MKl;
  public final A first;
  public final B second;
  
  public t(A paramA, B paramB, C paramC)
  {
    this.first = paramA;
    this.second = paramB;
    this.MKl = paramC;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129588);
    if (this != paramObject)
    {
      if ((paramObject instanceof t))
      {
        paramObject = (t)paramObject;
        if ((!p.i(this.first, paramObject.first)) || (!p.i(this.second, paramObject.second)) || (!p.i(this.MKl, paramObject.MKl))) {}
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
      localObject = this.MKl;
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
    String str = "(" + this.first + ", " + this.second + ", " + this.MKl + ')';
    AppMethodBeat.o(129586);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.t
 * JD-Core Version:    0.7.0.1
 */