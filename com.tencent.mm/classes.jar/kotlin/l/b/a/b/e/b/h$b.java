package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h$b
{
  public static final a ajdh;
  public static final b ajdi;
  private final int aaGW;
  private final int rid;
  private final int rie;
  
  static
  {
    AppMethodBeat.i(191554);
    ajdh = new a((byte)0);
    ajdi = new b(256, 256, 256);
    AppMethodBeat.o(191554);
  }
  
  public h$b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.rid = paramInt1;
    this.rie = paramInt2;
    this.aaGW = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.rid != paramObject.rid) {
        return false;
      }
      if (this.rie != paramObject.rie) {
        return false;
      }
    } while (this.aaGW == paramObject.aaGW);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.rid * 31 + this.rie) * 31 + this.aaGW;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191557);
    if (this.aaGW == 0)
    {
      str = this.rid + '.' + this.rie;
      AppMethodBeat.o(191557);
      return str;
    }
    String str = this.rid + '.' + this.rie + '.' + this.aaGW;
    AppMethodBeat.o(191557);
    return str;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.h.b
 * JD-Core Version:    0.7.0.1
 */