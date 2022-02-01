package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.g;

@Metadata(d1={""}, d2={"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class f
{
  public final g ajuK;
  public final String value;
  
  public f(String paramString, g paramg)
  {
    AppMethodBeat.i(129350);
    this.value = paramString;
    this.ajuK = paramg;
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
        if ((!s.p(this.value, paramObject.value)) || (!s.p(this.ajuK, paramObject.ajuK))) {}
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
      localObject = this.ajuK;
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
    String str = "MatchGroup(value=" + this.value + ", range=" + this.ajuK + ")";
    AppMethodBeat.o(129351);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.f
 * JD-Core Version:    0.7.0.1
 */