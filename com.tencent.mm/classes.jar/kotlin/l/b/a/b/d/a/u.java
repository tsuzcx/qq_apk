package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.l.b.a.b.f.c;

public final class u
{
  final ab aiPk;
  final ab aiPl;
  final Map<c, ab> aiPm;
  private final j aiPn;
  final boolean aiPo;
  
  private u(ab paramab1, ab paramab2, Map<c, ? extends ab> paramMap)
  {
    AppMethodBeat.i(192004);
    this.aiPk = paramab1;
    this.aiPl = paramab2;
    this.aiPm = paramMap;
    this.aiPn = k.cm((a)new a(this));
    if ((this.aiPk == ab.aiQh) && (this.aiPl == ab.aiQh) && (this.aiPm.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      this.aiPo = bool;
      AppMethodBeat.o(192004);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192029);
    if (this == paramObject)
    {
      AppMethodBeat.o(192029);
      return true;
    }
    if (!(paramObject instanceof u))
    {
      AppMethodBeat.o(192029);
      return false;
    }
    paramObject = (u)paramObject;
    if (this.aiPk != paramObject.aiPk)
    {
      AppMethodBeat.o(192029);
      return false;
    }
    if (this.aiPl != paramObject.aiPl)
    {
      AppMethodBeat.o(192029);
      return false;
    }
    if (!s.p(this.aiPm, paramObject.aiPm))
    {
      AppMethodBeat.o(192029);
      return false;
    }
    AppMethodBeat.o(192029);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(192024);
    int j = this.aiPk.hashCode();
    if (this.aiPl == null) {}
    for (int i = 0;; i = this.aiPl.hashCode())
    {
      int k = this.aiPm.hashCode();
      AppMethodBeat.o(192024);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192016);
    String str = "Jsr305Settings(globalLevel=" + this.aiPk + ", migrationLevel=" + this.aiPl + ", userDefinedLevelForSpecificAnnotation=" + this.aiPm + ')';
    AppMethodBeat.o(192016);
    return str;
  }
  
  static final class a
    extends kotlin.g.b.u
    implements a<String[]>
  {
    a(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.u
 * JD-Core Version:    0.7.0.1
 */