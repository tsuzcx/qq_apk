package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;

final class ag$a
{
  final b aiEe;
  final List<Integer> aiHf;
  
  public ag$a(b paramb, List<Integer> paramList)
  {
    AppMethodBeat.i(56865);
    this.aiEe = paramb;
    this.aiHf = paramList;
    AppMethodBeat.o(56865);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56868);
    if (this == paramObject)
    {
      AppMethodBeat.o(56868);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(56868);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.aiEe, paramObject.aiEe))
    {
      AppMethodBeat.o(56868);
      return false;
    }
    if (!s.p(this.aiHf, paramObject.aiHf))
    {
      AppMethodBeat.o(56868);
      return false;
    }
    AppMethodBeat.o(56868);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56867);
    int i = this.aiEe.hashCode();
    int j = this.aiHf.hashCode();
    AppMethodBeat.o(56867);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56866);
    String str = "ClassRequest(classId=" + this.aiEe + ", typeParametersCount=" + this.aiHf + ')';
    AppMethodBeat.o(56866);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.b.ag.a
 * JD-Core Version:    0.7.0.1
 */