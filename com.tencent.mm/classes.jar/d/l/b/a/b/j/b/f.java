package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.f.a;

public final class f
{
  public final int LFt;
  public final a LbB;
  
  public f(a parama, int paramInt)
  {
    AppMethodBeat.i(60051);
    this.LbB = parama;
    this.LFt = paramInt;
    AppMethodBeat.o(60051);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60053);
    if (this != paramObject)
    {
      if (!(paramObject instanceof f)) {
        break label65;
      }
      paramObject = (f)paramObject;
      if (!k.g(this.LbB, paramObject.LbB)) {
        break label65;
      }
      if (this.LFt != paramObject.LFt) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60053);
      return true;
    }
    label65:
    AppMethodBeat.o(60053);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60052);
    a locala = this.LbB;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      int j = this.LFt;
      AppMethodBeat.o(60052);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(60050);
    Object localObject = new StringBuilder();
    int k = this.LFt;
    int i = 0;
    while (i < k)
    {
      ((StringBuilder)localObject).append("kotlin/Array<");
      i += 1;
    }
    ((StringBuilder)localObject).append(this.LbB);
    k = this.LFt;
    i = j;
    while (i < k)
    {
      ((StringBuilder)localObject).append(">");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    k.g(localObject, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(60050);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.f
 * JD-Core Version:    0.7.0.1
 */