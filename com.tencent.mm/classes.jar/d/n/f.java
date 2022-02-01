package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.k.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"})
public final class f
{
  public final d KcJ;
  public final String value;
  
  public f(String paramString, d paramd)
  {
    AppMethodBeat.i(129350);
    this.value = paramString;
    this.KcJ = paramd;
    AppMethodBeat.o(129350);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129353);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!k.g(this.value, paramObject.value)) || (!k.g(this.KcJ, paramObject.KcJ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(129353);
      return true;
    }
    AppMethodBeat.o(129353);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(129352);
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.KcJ;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(129352);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129351);
    String str = "MatchGroup(value=" + this.value + ", range=" + this.KcJ + ")";
    AppMethodBeat.o(129351);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.f
 * JD-Core Version:    0.7.0.1
 */