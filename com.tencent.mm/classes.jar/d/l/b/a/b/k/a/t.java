package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class t<T extends d.l.b.a.b.e.b.a>
{
  private final T NWn;
  private final T NWo;
  private final d.l.b.a.b.f.a NpB;
  private final String filePath;
  
  public t(T paramT1, T paramT2, String paramString, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60319);
    this.NWn = paramT1;
    this.NWo = paramT2;
    this.filePath = paramString;
    this.NpB = parama;
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
        if ((!p.i(this.NWn, paramObject.NWn)) || (!p.i(this.NWo, paramObject.NWo)) || (!p.i(this.filePath, paramObject.filePath)) || (!p.i(this.NpB, paramObject.NpB))) {}
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
    Object localObject = this.NWn;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.NWo;
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
      localObject = this.NpB;
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
    String str = "IncompatibleVersionErrorData(actualVersion=" + this.NWn + ", expectedVersion=" + this.NWo + ", filePath=" + this.filePath + ", classId=" + this.NpB + ")";
    AppMethodBeat.o(60320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.t
 * JD-Core Version:    0.7.0.1
 */