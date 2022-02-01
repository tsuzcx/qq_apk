package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;

final class c<T>
{
  final g aiUH;
  final T result;
  
  public c(T paramT, g paramg)
  {
    this.result = paramT;
    this.aiUH = paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58023);
    if (this == paramObject)
    {
      AppMethodBeat.o(58023);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(58023);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.result, paramObject.result))
    {
      AppMethodBeat.o(58023);
      return false;
    }
    if (!s.p(this.aiUH, paramObject.aiUH))
    {
      AppMethodBeat.o(58023);
      return false;
    }
    AppMethodBeat.o(58023);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(58022);
    int i;
    if (this.result == null)
    {
      i = 0;
      if (this.aiUH != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(58022);
      return i * 31 + j;
      i = this.result.hashCode();
      break;
      label46:
      j = this.aiUH.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58021);
    String str = "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.aiUH + ')';
    AppMethodBeat.o(58021);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.c
 * JD-Core Version:    0.7.0.1
 */