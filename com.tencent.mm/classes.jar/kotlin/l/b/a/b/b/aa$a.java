package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;

final class aa$a
{
  final a Tfj;
  final List<Integer> Thw;
  
  public aa$a(a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56865);
    this.Tfj = parama;
    this.Thw = paramList;
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
        if ((!p.j(this.Tfj, paramObject.Tfj)) || (!p.j(this.Thw, paramObject.Thw))) {}
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
    Object localObject = this.Tfj;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Thw;
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
    String str = "ClassRequest(classId=" + this.Tfj + ", typeParametersCount=" + this.Thw + ")";
    AppMethodBeat.o(56866);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.b.b.aa.a
 * JD-Core Version:    0.7.0.1
 */