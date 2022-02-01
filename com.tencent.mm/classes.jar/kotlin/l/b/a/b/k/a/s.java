package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.f.b;

public final class s<T>
{
  private final b aiEe;
  private final T ajmw;
  private final T ajmx;
  private final String filePath;
  
  public s(T paramT1, T paramT2, String paramString, b paramb)
  {
    AppMethodBeat.i(192283);
    this.ajmw = paramT1;
    this.ajmx = paramT2;
    this.filePath = paramString;
    this.aiEe = paramb;
    AppMethodBeat.o(192283);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60322);
    if (this == paramObject)
    {
      AppMethodBeat.o(60322);
      return true;
    }
    if (!(paramObject instanceof s))
    {
      AppMethodBeat.o(60322);
      return false;
    }
    paramObject = (s)paramObject;
    if (!kotlin.g.b.s.p(this.ajmw, paramObject.ajmw))
    {
      AppMethodBeat.o(60322);
      return false;
    }
    if (!kotlin.g.b.s.p(this.ajmx, paramObject.ajmx))
    {
      AppMethodBeat.o(60322);
      return false;
    }
    if (!kotlin.g.b.s.p(this.filePath, paramObject.filePath))
    {
      AppMethodBeat.o(60322);
      return false;
    }
    if (!kotlin.g.b.s.p(this.aiEe, paramObject.aiEe))
    {
      AppMethodBeat.o(60322);
      return false;
    }
    AppMethodBeat.o(60322);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(60321);
    int i;
    if (this.ajmw == null)
    {
      i = 0;
      if (this.ajmx != null) {
        break label74;
      }
    }
    for (;;)
    {
      int k = this.filePath.hashCode();
      int m = this.aiEe.hashCode();
      AppMethodBeat.o(60321);
      return ((i * 31 + j) * 31 + k) * 31 + m;
      i = this.ajmw.hashCode();
      break;
      label74:
      j = this.ajmx.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60320);
    String str = "IncompatibleVersionErrorData(actualVersion=" + this.ajmw + ", expectedVersion=" + this.ajmx + ", filePath=" + this.filePath + ", classId=" + this.aiEe + ')';
    AppMethodBeat.o(60320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.s
 * JD-Core Version:    0.7.0.1
 */