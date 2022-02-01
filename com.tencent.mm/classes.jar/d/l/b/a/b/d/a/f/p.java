package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.ab;

final class p
{
  final ab MOF;
  final d Nic;
  
  public p(ab paramab, d paramd)
  {
    AppMethodBeat.i(58122);
    this.MOF = paramab;
    this.Nic = paramd;
    AppMethodBeat.o(58122);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58125);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((!d.g.b.p.i(this.MOF, paramObject.MOF)) || (!d.g.b.p.i(this.Nic, paramObject.Nic))) {}
      }
    }
    else
    {
      AppMethodBeat.o(58125);
      return true;
    }
    AppMethodBeat.o(58125);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(58124);
    Object localObject = this.MOF;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Nic;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(58124);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58123);
    String str = "TypeAndDefaultQualifiers(type=" + this.MOF + ", defaultQualifiers=" + this.Nic + ")";
    AppMethodBeat.o(58123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.p
 * JD-Core Version:    0.7.0.1
 */