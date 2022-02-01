package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.f.a;

public final class j$a
{
  public final a aaId;
  private final byte[] aaRU;
  private final g aaRV;
  
  private j$a(a parama, byte[] paramArrayOfByte, g paramg)
  {
    AppMethodBeat.i(57580);
    this.aaId = parama;
    this.aaRU = null;
    this.aaRV = paramg;
    AppMethodBeat.o(57580);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57584);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.aaId, paramObject.aaId)) || (!p.h(this.aaRU, paramObject.aaRU)) || (!p.h(this.aaRV, paramObject.aaRV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(57584);
      return true;
    }
    AppMethodBeat.o(57584);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(57583);
    Object localObject = this.aaId;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.aaRU;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = Arrays.hashCode((byte[])localObject);; j = 0)
    {
      localObject = this.aaRV;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(57583);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57582);
    String str = "Request(classId=" + this.aaId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.aaRU) + ", outerClass=" + this.aaRV + ")";
    AppMethodBeat.o(57582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.j.a
 * JD-Core Version:    0.7.0.1
 */