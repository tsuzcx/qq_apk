package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class t<T extends kotlin.l.b.a.b.e.b.a>
{
  private final kotlin.l.b.a.b.f.a aaId;
  private final T abnM;
  private final T abnN;
  private final String filePath;
  
  public t(T paramT1, T paramT2, String paramString, kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60319);
    this.abnM = paramT1;
    this.abnN = paramT2;
    this.filePath = paramString;
    this.aaId = parama;
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
        if ((!p.h(this.abnM, paramObject.abnM)) || (!p.h(this.abnN, paramObject.abnN)) || (!p.h(this.filePath, paramObject.filePath)) || (!p.h(this.aaId, paramObject.aaId))) {}
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
    Object localObject = this.abnM;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.abnN;
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
      localObject = this.aaId;
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
    String str = "IncompatibleVersionErrorData(actualVersion=" + this.abnM + ", expectedVersion=" + this.abnN + ", filePath=" + this.filePath + ", classId=" + this.aaId + ")";
    AppMethodBeat.o(60320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.t
 * JD-Core Version:    0.7.0.1
 */