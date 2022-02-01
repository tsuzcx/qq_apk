package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.d.a.a.a;
import d.l.b.a.b.d.a.f.h;
import java.util.Collection;

public final class k
{
  public final Collection<a.a> JAA;
  public final h JAz;
  
  public k(h paramh, Collection<? extends a.a> paramCollection)
  {
    AppMethodBeat.i(57765);
    this.JAz = paramh;
    this.JAA = paramCollection;
    AppMethodBeat.o(57765);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57768);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((!d.g.b.k.g(this.JAz, paramObject.JAz)) || (!d.g.b.k.g(this.JAA, paramObject.JAA))) {}
      }
    }
    else
    {
      AppMethodBeat.o(57768);
      return true;
    }
    AppMethodBeat.o(57768);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(57767);
    Object localObject = this.JAz;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.JAA;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(57767);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57766);
    String str = "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.JAz + ", qualifierApplicabilityTypes=" + this.JAA + ")";
    AppMethodBeat.o(57766);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.k
 * JD-Core Version:    0.7.0.1
 */