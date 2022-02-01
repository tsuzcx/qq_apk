package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;

public final class f
{
  final c aiyk;
  final a.b ajlM;
  final a ajlN;
  final av ajlO;
  
  public f(c paramc, a.b paramb, a parama, av paramav)
  {
    AppMethodBeat.i(60288);
    this.aiyk = paramc;
    this.ajlM = paramb;
    this.ajlN = parama;
    this.ajlO = paramav;
    AppMethodBeat.o(60288);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60291);
    if (this == paramObject)
    {
      AppMethodBeat.o(60291);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(60291);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.aiyk, paramObject.aiyk))
    {
      AppMethodBeat.o(60291);
      return false;
    }
    if (!s.p(this.ajlM, paramObject.ajlM))
    {
      AppMethodBeat.o(60291);
      return false;
    }
    if (!s.p(this.ajlN, paramObject.ajlN))
    {
      AppMethodBeat.o(60291);
      return false;
    }
    if (!s.p(this.ajlO, paramObject.ajlO))
    {
      AppMethodBeat.o(60291);
      return false;
    }
    AppMethodBeat.o(60291);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60290);
    int i = this.aiyk.hashCode();
    int j = this.ajlM.hashCode();
    int k = this.ajlN.hashCode();
    int m = this.ajlO.hashCode();
    AppMethodBeat.o(60290);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60289);
    String str = "ClassData(nameResolver=" + this.aiyk + ", classProto=" + this.ajlM + ", metadataVersion=" + this.ajlN + ", sourceElement=" + this.ajlO + ')';
    AppMethodBeat.o(60289);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.f
 * JD-Core Version:    0.7.0.1
 */