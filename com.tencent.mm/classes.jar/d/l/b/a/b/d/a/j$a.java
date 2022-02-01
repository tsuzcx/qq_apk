package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.f.a;
import java.util.Arrays;

public final class j$a
{
  public final a Joh;
  private final byte[] JxX;
  private final g JxY;
  
  private j$a(a parama, byte[] paramArrayOfByte, g paramg)
  {
    AppMethodBeat.i(57580);
    this.Joh = parama;
    this.JxX = paramArrayOfByte;
    this.JxY = paramg;
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
        if ((!k.g(this.Joh, paramObject.Joh)) || (!k.g(this.JxX, paramObject.JxX)) || (!k.g(this.JxY, paramObject.JxY))) {}
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
    Object localObject = this.Joh;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.JxX;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = Arrays.hashCode((byte[])localObject);; j = 0)
    {
      localObject = this.JxY;
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
    String str = "Request(classId=" + this.Joh + ", previouslyFoundClassFileContent=" + Arrays.toString(this.JxX) + ", outerClass=" + this.JxY + ")";
    AppMethodBeat.o(57582);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     d.l.b.a.b.d.a.j.a
 * JD-Core Version:    0.7.0.1
 */