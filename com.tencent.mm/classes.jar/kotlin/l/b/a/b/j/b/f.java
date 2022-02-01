package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;

public final class f
{
  public final b aiEe;
  public final int ajjD;
  
  public f(b paramb, int paramInt)
  {
    AppMethodBeat.i(60051);
    this.aiEe = paramb;
    this.ajjD = paramInt;
    AppMethodBeat.o(60051);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60053);
    if (this == paramObject)
    {
      AppMethodBeat.o(60053);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(60053);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.aiEe, paramObject.aiEe))
    {
      AppMethodBeat.o(60053);
      return false;
    }
    if (this.ajjD != paramObject.ajjD)
    {
      AppMethodBeat.o(60053);
      return false;
    }
    AppMethodBeat.o(60053);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60052);
    int i = this.aiEe.hashCode();
    int j = this.ajjD;
    AppMethodBeat.o(60052);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(60050);
    Object localObject = new StringBuilder();
    int k = this.ajjD;
    int i = 0;
    while (i < k)
    {
      ((StringBuilder)localObject).append("kotlin/Array<");
      i += 1;
    }
    ((StringBuilder)localObject).append(this.aiEe);
    k = this.ajjD;
    i = j;
    while (i < k)
    {
      ((StringBuilder)localObject).append(">");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(60050);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.f
 * JD-Core Version:    0.7.0.1
 */