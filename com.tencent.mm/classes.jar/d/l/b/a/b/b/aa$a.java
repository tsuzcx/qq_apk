package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.f.a;
import java.util.List;

final class aa$a
{
  final a Joh;
  final List<Integer> Jqv;
  
  public aa$a(a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(56865);
    this.Joh = parama;
    this.Jqv = paramList;
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
        if ((!k.g(this.Joh, paramObject.Joh)) || (!k.g(this.Jqv, paramObject.Jqv))) {}
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
    Object localObject = this.Joh;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Jqv;
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
    String str = "ClassRequest(classId=" + this.Joh + ", typeParametersCount=" + this.Jqv + ")";
    AppMethodBeat.o(56866);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.b.aa.a
 * JD-Core Version:    0.7.0.1
 */