package com.tencent.mm.sns_compose.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sns_compose.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/page/ViewEvents;", "", "()V", "Remove", "Lcom/tencent/mm/sns_compose/page/ViewEvents$Remove;", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/page/ViewEvents$Remove;", "Lcom/tencent/mm/sns_compose/page/ViewEvents;", "entity", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;)V", "getEntity", "()Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    public static final int Ue = 8;
    final f aczN;
    
    public a(f paramf)
    {
      super();
      AppMethodBeat.i(235599);
      this.aczN = paramf;
      AppMethodBeat.o(235599);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(235619);
      if (this == paramObject)
      {
        AppMethodBeat.o(235619);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(235619);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.aczN, paramObject.aczN))
      {
        AppMethodBeat.o(235619);
        return false;
      }
      AppMethodBeat.o(235619);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(235612);
      int i = this.aczN.hashCode();
      AppMethodBeat.o(235612);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(235608);
      String str = "Remove(entity=" + this.aczN + ')';
      AppMethodBeat.o(235608);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.d
 * JD-Core Version:    0.7.0.1
 */