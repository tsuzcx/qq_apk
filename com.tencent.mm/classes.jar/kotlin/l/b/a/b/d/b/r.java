package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class r
{
  public static final r.a aiXc;
  final String signature;
  
  static
  {
    AppMethodBeat.i(58237);
    aiXc = new r.a((byte)0);
    AppMethodBeat.o(58237);
  }
  
  private r(String paramString)
  {
    this.signature = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58240);
    if (this == paramObject)
    {
      AppMethodBeat.o(58240);
      return true;
    }
    if (!(paramObject instanceof r))
    {
      AppMethodBeat.o(58240);
      return false;
    }
    paramObject = (r)paramObject;
    if (!s.p(this.signature, paramObject.signature))
    {
      AppMethodBeat.o(58240);
      return false;
    }
    AppMethodBeat.o(58240);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(58239);
    int i = this.signature.hashCode();
    AppMethodBeat.o(58239);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58238);
    String str = "MemberSignature(signature=" + this.signature + ')';
    AppMethodBeat.o(58238);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.r
 * JD-Core Version:    0.7.0.1
 */