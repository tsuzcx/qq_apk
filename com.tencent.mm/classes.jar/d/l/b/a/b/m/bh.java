package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bh
{
  private final boolean JYG;
  public final boolean JYH;
  private final int JYI;
  public final String label;
  
  static
  {
    AppMethodBeat.i(60912);
    bh localbh1 = new bh("INVARIANT", 0, "", true, true, 0);
    JYC = localbh1;
    bh localbh2 = new bh("IN_VARIANCE", 1, "in", true, false, -1);
    JYD = localbh2;
    bh localbh3 = new bh("OUT_VARIANCE", 2, "out", false, true, 1);
    JYE = localbh3;
    JYF = new bh[] { localbh1, localbh2, localbh3 };
    AppMethodBeat.o(60912);
  }
  
  private bh(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.label = paramString;
    this.JYG = paramBoolean1;
    this.JYH = paramBoolean2;
    this.JYI = paramInt;
  }
  
  public final String toString()
  {
    return this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bh
 * JD-Core Version:    0.7.0.1
 */