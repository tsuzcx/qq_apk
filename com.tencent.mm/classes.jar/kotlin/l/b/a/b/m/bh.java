package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bh
{
  private final boolean abrt;
  public final boolean abru;
  private final int abrv;
  public final String label;
  
  static
  {
    AppMethodBeat.i(60912);
    bh localbh1 = new bh("INVARIANT", 0, "", true, true, 0);
    abrp = localbh1;
    bh localbh2 = new bh("IN_VARIANCE", 1, "in", true, false, -1);
    abrq = localbh2;
    bh localbh3 = new bh("OUT_VARIANCE", 2, "out", false, true, 1);
    abrr = localbh3;
    abrs = new bh[] { localbh1, localbh2, localbh3 };
    AppMethodBeat.o(60912);
  }
  
  private bh(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.label = paramString;
    this.abrt = paramBoolean1;
    this.abru = paramBoolean2;
    this.abrv = paramInt;
  }
  
  public final String toString()
  {
    return this.label;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bh
 * JD-Core Version:    0.7.0.1
 */