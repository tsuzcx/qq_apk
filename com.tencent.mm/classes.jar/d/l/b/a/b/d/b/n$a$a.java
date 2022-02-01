package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.Arrays;

public final class n$a$a
  extends n.a
{
  public final byte[] content;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58219);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!k.g(this.content, paramObject.content)) {}
      }
    }
    else
    {
      AppMethodBeat.o(58219);
      return true;
    }
    AppMethodBeat.o(58219);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(58218);
    byte[] arrayOfByte = this.content;
    if (arrayOfByte != null)
    {
      int i = Arrays.hashCode(arrayOfByte);
      AppMethodBeat.o(58218);
      return i;
    }
    AppMethodBeat.o(58218);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58217);
    String str = "ClassFileContent(content=" + Arrays.toString(this.content) + ")";
    AppMethodBeat.o(58217);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.d.b.n.a.a
 * JD-Core Version:    0.7.0.1
 */