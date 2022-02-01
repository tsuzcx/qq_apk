package kotlin.l.b.a.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e
  implements Serializable
{
  public static final a aiNT;
  private static final e aiNU;
  private final int column = -1;
  private final int line = -1;
  
  static
  {
    AppMethodBeat.i(191375);
    aiNT = new a((byte)0);
    aiNU = new e();
    AppMethodBeat.o(191375);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
      if (this.line != paramObject.line) {
        return false;
      }
    } while (this.column == paramObject.column);
    return false;
  }
  
  public final int hashCode()
  {
    return this.line * 31 + this.column;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191377);
    String str = "Position(line=" + this.line + ", column=" + this.column + ')';
    AppMethodBeat.o(191377);
    return str;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.c.a.e
 * JD-Core Version:    0.7.0.1
 */