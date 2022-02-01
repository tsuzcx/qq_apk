package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.f.a;

public final class f
{
  public final a MSw;
  public final int Nwr;
  
  public f(a parama, int paramInt)
  {
    AppMethodBeat.i(60051);
    this.MSw = parama;
    this.Nwr = paramInt;
    AppMethodBeat.o(60051);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60053);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!p.i(this.MSw, paramObject.MSw)) || (this.Nwr != paramObject.Nwr)) {}
      }
    }
    else
    {
      AppMethodBeat.o(60053);
      return true;
    }
    AppMethodBeat.o(60053);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60052);
    a locala = this.MSw;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      int j = this.Nwr;
      AppMethodBeat.o(60052);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(60050);
    Object localObject = new StringBuilder();
    int k = this.Nwr;
    int i = 0;
    while (i < k)
    {
      ((StringBuilder)localObject).append("kotlin/Array<");
      i += 1;
    }
    ((StringBuilder)localObject).append(this.MSw);
    k = this.Nwr;
    i = j;
    while (i < k)
    {
      ((StringBuilder)localObject).append(">");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(60050);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.f
 * JD-Core Version:    0.7.0.1
 */