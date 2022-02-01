package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;

public final class c$a
{
  public final b aiFm;
  final b aiFn;
  final b aiFo;
  
  public c$a(b paramb1, b paramb2, b paramb3)
  {
    AppMethodBeat.i(56749);
    this.aiFm = paramb1;
    this.aiFn = paramb2;
    this.aiFo = paramb3;
    AppMethodBeat.o(56749);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56752);
    if (this == paramObject)
    {
      AppMethodBeat.o(56752);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(56752);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.aiFm, paramObject.aiFm))
    {
      AppMethodBeat.o(56752);
      return false;
    }
    if (!s.p(this.aiFn, paramObject.aiFn))
    {
      AppMethodBeat.o(56752);
      return false;
    }
    if (!s.p(this.aiFo, paramObject.aiFo))
    {
      AppMethodBeat.o(56752);
      return false;
    }
    AppMethodBeat.o(56752);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56751);
    int i = this.aiFm.hashCode();
    int j = this.aiFn.hashCode();
    int k = this.aiFo.hashCode();
    AppMethodBeat.o(56751);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56750);
    String str = "PlatformMutabilityMapping(javaClass=" + this.aiFm + ", kotlinReadOnly=" + this.aiFn + ", kotlinMutable=" + this.aiFo + ')';
    AppMethodBeat.o(56750);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */