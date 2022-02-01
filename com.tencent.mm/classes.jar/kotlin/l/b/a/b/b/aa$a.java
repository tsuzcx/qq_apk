package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;

final class aa$a
{
  final a aaId;
  final List<Integer> aaKq;
  
  public aa$a(a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56865);
    this.aaId = parama;
    this.aaKq = paramList;
    AppMethodBeat.o(56865);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56868);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.aaId, paramObject.aaId)) || (!p.h(this.aaKq, paramObject.aaKq))) {}
      }
    }
    else
    {
      AppMethodBeat.o(56868);
      return true;
    }
    AppMethodBeat.o(56868);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(56867);
    Object localObject = this.aaId;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.aaKq;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(56867);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56866);
    String str = "ClassRequest(classId=" + this.aaId + ", typeParametersCount=" + this.aaKq + ")";
    AppMethodBeat.o(56866);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.b.aa.a
 * JD-Core Version:    0.7.0.1
 */