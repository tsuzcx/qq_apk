package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.f.f;

final class r
{
  final f Lgj;
  final String signature;
  
  public r(f paramf, String paramString)
  {
    AppMethodBeat.i(57618);
    this.Lgj = paramf;
    this.signature = paramString;
    AppMethodBeat.o(57618);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57621);
    if (this != paramObject)
    {
      if ((paramObject instanceof r))
      {
        paramObject = (r)paramObject;
        if ((!k.g(this.Lgj, paramObject.Lgj)) || (!k.g(this.signature, paramObject.signature))) {}
      }
    }
    else
    {
      AppMethodBeat.o(57621);
      return true;
    }
    AppMethodBeat.o(57621);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(57620);
    Object localObject = this.Lgj;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.signature;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(57620);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57619);
    String str = "NameAndSignature(name=" + this.Lgj + ", signature=" + this.signature + ")";
    AppMethodBeat.o(57619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.r
 * JD-Core Version:    0.7.0.1
 */