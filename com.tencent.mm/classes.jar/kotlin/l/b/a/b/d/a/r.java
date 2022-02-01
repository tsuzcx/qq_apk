package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.h;

public final class r
{
  public static final a aiOY;
  private static final r aiPc;
  final ab aiOZ;
  final h aiPa;
  final ab aiPb;
  
  static
  {
    AppMethodBeat.i(192021);
    aiOY = new a((byte)0);
    aiPc = new r(ab.aiQj, null, null, 6);
    AppMethodBeat.o(192021);
  }
  
  public r(ab paramab1, h paramh, ab paramab2)
  {
    AppMethodBeat.i(192001);
    this.aiOZ = paramab1;
    this.aiPa = paramh;
    this.aiPb = paramab2;
    AppMethodBeat.o(192001);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192037);
    if (this == paramObject)
    {
      AppMethodBeat.o(192037);
      return true;
    }
    if (!(paramObject instanceof r))
    {
      AppMethodBeat.o(192037);
      return false;
    }
    paramObject = (r)paramObject;
    if (this.aiOZ != paramObject.aiOZ)
    {
      AppMethodBeat.o(192037);
      return false;
    }
    if (!s.p(this.aiPa, paramObject.aiPa))
    {
      AppMethodBeat.o(192037);
      return false;
    }
    if (this.aiPb != paramObject.aiPb)
    {
      AppMethodBeat.o(192037);
      return false;
    }
    AppMethodBeat.o(192037);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(192033);
    int j = this.aiOZ.hashCode();
    if (this.aiPa == null) {}
    for (int i = 0;; i = this.aiPa.hashCode())
    {
      int k = this.aiPb.hashCode();
      AppMethodBeat.o(192033);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192026);
    String str = "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.aiOZ + ", sinceVersion=" + this.aiPa + ", reportLevelAfter=" + this.aiPb + ')';
    AppMethodBeat.o(192026);
    return str;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.r
 * JD-Core Version:    0.7.0.1
 */