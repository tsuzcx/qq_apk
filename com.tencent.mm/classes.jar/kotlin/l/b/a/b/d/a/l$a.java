package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.f.b;

public final class l$a
{
  public final b aiEe;
  private final byte[] aiOJ;
  private final g aiOK;
  
  private l$a(b paramb, byte[] paramArrayOfByte, g paramg)
  {
    AppMethodBeat.i(57580);
    this.aiEe = paramb;
    this.aiOJ = null;
    this.aiOK = paramg;
    AppMethodBeat.o(57580);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57584);
    if (this == paramObject)
    {
      AppMethodBeat.o(57584);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(57584);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.aiEe, paramObject.aiEe))
    {
      AppMethodBeat.o(57584);
      return false;
    }
    if (!s.p(this.aiOJ, paramObject.aiOJ))
    {
      AppMethodBeat.o(57584);
      return false;
    }
    if (!s.p(this.aiOK, paramObject.aiOK))
    {
      AppMethodBeat.o(57584);
      return false;
    }
    AppMethodBeat.o(57584);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(57583);
    int k = this.aiEe.hashCode();
    int i;
    if (this.aiOJ == null)
    {
      i = 0;
      if (this.aiOK != null) {
        break label59;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(57583);
      return (i + k * 31) * 31 + j;
      i = Arrays.hashCode(this.aiOJ);
      break;
      label59:
      j = this.aiOK.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57582);
    String str = "Request(classId=" + this.aiEe + ", previouslyFoundClassFileContent=" + Arrays.toString(this.aiOJ) + ", outerClass=" + this.aiOK + ')';
    AppMethodBeat.o(57582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.l.a
 * JD-Core Version:    0.7.0.1
 */