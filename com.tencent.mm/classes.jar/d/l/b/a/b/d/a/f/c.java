package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;

final class c<T>
{
  final g NEb;
  final T result;
  
  public c(T paramT, g paramg)
  {
    this.result = paramT;
    this.NEb = paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58023);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.i(this.result, paramObject.result)) || (!p.i(this.NEb, paramObject.NEb))) {}
      }
    }
    else
    {
      AppMethodBeat.o(58023);
      return true;
    }
    AppMethodBeat.o(58023);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(58022);
    Object localObject = this.result;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.NEb;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(58022);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58021);
    String str = "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.NEb + ")";
    AppMethodBeat.o(58021);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.c
 * JD-Core Version:    0.7.0.1
 */