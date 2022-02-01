package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class t<T extends d.l.b.a.b.e.b.a>
{
  private final T JUP;
  private final T JUQ;
  private final d.l.b.a.b.f.a Joh;
  private final String filePath;
  
  public t(T paramT1, T paramT2, String paramString, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60319);
    this.JUP = paramT1;
    this.JUQ = paramT2;
    this.filePath = paramString;
    this.Joh = parama;
    AppMethodBeat.o(60319);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60322);
    if (this != paramObject)
    {
      if ((paramObject instanceof t))
      {
        paramObject = (t)paramObject;
        if ((!k.g(this.JUP, paramObject.JUP)) || (!k.g(this.JUQ, paramObject.JUQ)) || (!k.g(this.filePath, paramObject.filePath)) || (!k.g(this.Joh, paramObject.Joh))) {}
      }
    }
    else
    {
      AppMethodBeat.o(60322);
      return true;
    }
    AppMethodBeat.o(60322);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(60321);
    Object localObject = this.JUP;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.JUQ;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.filePath;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.Joh;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(60321);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60320);
    String str = "IncompatibleVersionErrorData(actualVersion=" + this.JUP + ", expectedVersion=" + this.JUQ + ", filePath=" + this.filePath + ", classId=" + this.Joh + ")";
    AppMethodBeat.o(60320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.k.a.t
 * JD-Core Version:    0.7.0.1
 */